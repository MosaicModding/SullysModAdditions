package com.mosaic_modding.sullysmod_additions.core.integration;

import com.mosaic_modding.sullysmod_additions.core.integration.CompatHandler;
import com.mosaic_modding.sullysmod_additions.core.registry.SMAItems;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.registries.ForgeRegistries;

public class FDCompat {
    public static ResourceKey<CreativeModeTab> FDTAB;

    public static void init() {
        FDTAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CompatHandler.FDID, CompatHandler.FDID));
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> FDCompat::buildFDCreativeTabContents);
    }

    public static Item getFDItem(String id) {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(CompatHandler.FDID, id));
    }

    private static void buildFDCreativeTabContents() {
        CreativeModeTabContentsPopulator.mod(CompatHandler.FDID)
                .tab(FDCompat.FDTAB)
                .addItems(SMAItems.LANTERNFISH_SLICE, SMAItems.COOKED_LANTERNFISH_SLICE, SMAItems.LANTERNFISH_ROLL, SMAItems.CAVE_CHUM_BUCKET)
        ;
    }


}
