package com.mosaic_modding.sullysmod_additions.core.integration;

import com.uraneptus.sullysmod.common.entities.Lanternfish;
import com.uraneptus.sullysmod.core.registry.SMEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;

public class TFCompat {
    private static boolean isActive = false;
    public static final ResourceLocation STREAM_BIOME = new ResourceLocation("twilightforest", "stream");

    public static void init() {
        isActive = true;
    }

    public static void handleLanternfishSpawn(SpawnPlacementRegisterEvent event) {
        if (!isActive) return;
        //TODO seems to break regular spawning idk
        event.register(SMEntityTypes.LANTERNFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TFCompat::lanternfishTFSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    public static boolean lanternfishTFSpawn(EntityType<? extends LivingEntity> type, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        if (level.getBiome(pos).is(STREAM_BIOME)) {
            return level.getFluidState(pos.below()).is(Fluids.WATER) && level.getFluidState(pos.above()).is(FluidTags.WATER);
        }
        return Lanternfish.checkLanternfishSpawnRules(type, level, spawnType, pos, random);
    }
}
