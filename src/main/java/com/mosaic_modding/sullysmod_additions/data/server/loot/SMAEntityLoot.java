package com.mosaic_modding.sullysmod_additions.data.server.loot;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.stream.Stream;

public class SMAEntityLoot extends EntityLootSubProvider {

    protected SMAEntityLoot() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return ForgeRegistries.ENTITY_TYPES.getValues().stream().filter(entityType -> ForgeRegistries.ENTITY_TYPES.getKey(entityType) != null && SullysModAdditions.MOD_ID.equals(ForgeRegistries.ENTITY_TYPES.getKey(entityType).getNamespace()));
    }

    @Override
    public void generate() {
        
    }
}
