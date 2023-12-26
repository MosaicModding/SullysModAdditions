package com.mosaic_modding.sullysmod_additions.data.client;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import com.mosaic_modding.sullysmod_additions.core.registry.SMABlocks;
import com.mosaic_modding.sullysmod_additions.core.registry.SMAItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

import static com.mosaic_modding.sullysmod_additions.data.SMADatagenUtil.modBlockLocation;
import static com.mosaic_modding.sullysmod_additions.data.SMADatagenUtil.name;

@SuppressWarnings({"unused", "SameParameterValue"})
public class SMAItemModelProvider extends ItemModelProvider {

    public SMAItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, SullysModAdditions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        SMABlocks.VERTICAL_SLABS.forEach(((block, parent) -> basicBlockItem(block)));
        basicItem(SMAItems.LANTERNFISH_SLICE);
        basicItem(SMAItems.COOKED_LANTERNFISH_SLICE);
        basicItem(SMAItems.LANTERNFISH_ROLL);
        basicItem(SMAItems.CAVE_CHUM_BUCKET);
    }

    private void basicBlockItem(Supplier<? extends Block> blockForItem) {
        withExistingParent(name(blockForItem.get()), modBlockLocation(name(blockForItem.get())));
    }

    private void basicItem(Supplier<? extends Item> item) {
        basicItem(item.get());
    }
}
