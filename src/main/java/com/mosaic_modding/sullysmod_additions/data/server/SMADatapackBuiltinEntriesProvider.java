package com.mosaic_modding.sullysmod_additions.data.server;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class SMADatapackBuiltinEntriesProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder SET_BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ConfiguredFeatures::create)
            .add(Registries.PLACED_FEATURE, PlacedFeatures::create)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifiers::create)
            .add(Registries.DAMAGE_TYPE, DamageSources::create);

    public SMADatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, SET_BUILDER, Set.of(SullysModAdditions.MOD_ID));
    }

    private static class ConfiguredFeatures {
        private static final RuleTest STONE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        private static final RuleTest DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        public static void create(BootstapContext<ConfiguredFeature<?, ?>> context) {

        }

        private static ConfiguredFeature<?, ?> addOreConfig(List<OreConfiguration.TargetBlockState> targetList, int veinSize) {
            return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(targetList, veinSize));
        }

        private static void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> featureKey, Supplier<? extends ConfiguredFeature<?, ?>> feature) {
            context.register(featureKey, feature.get());
        }
    }

    private static class PlacedFeatures {
        public static void create(BootstapContext<PlacedFeature> context) {
        }

        private static PlacedFeature addOreFeature(Holder<ConfiguredFeature<?, ?>> configureFeature, int minHeight, int maxHeight, int count) {
            return addFeaturePlacement(configureFeature, HeightRangePlacement.triangle(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)), CountPlacement.of(count), InSquarePlacement.spread(), BiomeFilter.biome());
        }

        private static PlacedFeature addFeaturePlacement(Holder<ConfiguredFeature<?, ?>> configureFeature, PlacementModifier... placementModifiers) {
            return new PlacedFeature(configureFeature, List.of(placementModifiers));
        }

        private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> featureKey, PlacedFeature feature) {
            context.register(featureKey, feature);
        }
    }

    private static class BiomeModifiers {
        public static void create(BootstapContext<BiomeModifier> context) {

        }

        private static ForgeBiomeModifiers.AddFeaturesBiomeModifier addFeatureModifier(BootstapContext<BiomeModifier> context, HolderSet<PlacedFeature> placedSet, TagKey<Biome> biomeTag, GenerationStep.Decoration decoration) {
            return new ForgeBiomeModifiers.AddFeaturesBiomeModifier(context.lookup(Registries.BIOME).getOrThrow(biomeTag), placedSet, decoration);
        }

        private static ForgeBiomeModifiers.AddSpawnsBiomeModifier addSingleSpawnModifier(BootstapContext<BiomeModifier> context, TagKey<Biome> biomeTag, EntityType<?> entity, int weight, int minCount, int maxCount) {
            return ForgeBiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(context.lookup(Registries.BIOME).getOrThrow(biomeTag), new MobSpawnSettings.SpawnerData(entity, weight, minCount, maxCount));
        }

        private static void register(BootstapContext<BiomeModifier> context, String name, Supplier<? extends BiomeModifier> modifier) {
            context.register(ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, SullysModAdditions.modPrefix(name)), modifier.get());
        }
    }

    private static class DamageSources {
        protected static void create(BootstapContext<DamageType> context) {
        }

        protected static void register(BootstapContext<DamageType> context, ResourceKey<DamageType> key, DamageType damageType) {
            context.register(key, damageType);
        }
    }
}
