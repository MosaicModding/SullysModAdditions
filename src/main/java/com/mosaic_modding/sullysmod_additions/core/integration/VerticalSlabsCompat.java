package com.mosaic_modding.sullysmod_additions.core.integration;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import com.mosaic_modding.sullysmod_additions.core.registry.SMABlocks;
import com.mosaic_modding.sullysmod_additions.core.registry.SMAItems;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

public class VerticalSlabsCompat {

    public static void init() {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> VerticalSlabsCompat::buildVerticalSlabCreativeTabContents);
    }

    private static void buildVerticalSlabCreativeTabContents() {
        CreativeModeTabContentsPopulator.mod(SullysModAdditions.MOD_ID)
                .tab(CreativeModeTabs.BUILDING_BLOCKS)
                .addItems(SMABlocks.ROUGH_JADE_BRICK_VERTICAL_SLAB,
                        SMABlocks.SMOOTHED_ROUGH_JADE_VERTICAL_SLAB,
                        SMABlocks.ROUGH_JADE_TILE_VERTICAL_SLAB,
                        SMABlocks.POLISHED_JADE_BRICK_VERTICAL_SLAB,
                        SMABlocks.POLISHED_SMALL_JADE_BRICK_VERTICAL_SLAB,
                        SMABlocks.POLISHED_JADE_SHINGLE_VERTICAL_SLAB,
                        SMABlocks.POLISHED_JADE_TILE_VERTICAL_SLAB)
        ;
    }
}
