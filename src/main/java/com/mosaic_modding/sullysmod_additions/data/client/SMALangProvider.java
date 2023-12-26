package com.mosaic_modding.sullysmod_additions.data.client;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import com.mosaic_modding.sullysmod_additions.core.registry.SMABlocks;
import com.mosaic_modding.sullysmod_additions.core.registry.SMAItems;
import com.uraneptus.sullysmod.core.data.client.SMLangProvider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class SMALangProvider extends SMLangProvider {

    public SMALangProvider(PackOutput packOutput) {
        super(packOutput, SullysModAdditions.MOD_ID);
    }

    @Override
    protected void addTranslations() {
        SMABlocks.VERTICAL_SLABS.forEach((block, parent) -> forBlock(block));
        forItem(SMAItems.COOKED_LANTERNFISH_SLICE);
        forItem(SMAItems.LANTERNFISH_ROLL);
        forItem(SMAItems.CAVE_CHUM_BUCKET);
        add(SMAItems.LANTERNFISH_SLICE.get(), "Raw Lanternfish Slice");
    }
}