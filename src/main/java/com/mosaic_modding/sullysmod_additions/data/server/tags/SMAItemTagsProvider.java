package com.mosaic_modding.sullysmod_additions.data.server.tags;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import com.mosaic_modding.sullysmod_additions.core.other.tags.SMAItemTags;
import com.mosaic_modding.sullysmod_additions.core.registry.SMABlocks;
import com.mosaic_modding.sullysmod_additions.core.registry.SMAItems;
import com.uraneptus.fishermens_trap.core.other.FTItemTags;
import com.uraneptus.sullysmod.core.other.tags.SMItemTags;
import com.uraneptus.sullysmod.core.registry.SMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SMAItemTagsProvider extends ItemTagsProvider {

    public SMAItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> pProvider, CompletableFuture<TagsProvider.TagLookup<Block>> blockProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, pProvider, blockProvider, SullysModAdditions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        tag(SMItemTags.RAW_LANTERNFISH).add(SMAItems.LANTERNFISH_SLICE.get());
        tag(SMItemTags.COOKED_LANTERNFISH).add(SMAItems.COOKED_LANTERNFISH_SLICE.get());

        SMABlocks.VERTICAL_SLABS.forEach((block, parent) -> tag(SMAItemTags.VERTICAL_SLABS).add(block.get().asItem()));

        tag(FTItemTags.FISH_BAITS).add(Items.GLOW_BERRIES);
        tag(SMAItemTags.GLOW_BERRIES).add(SMItems.LANTERNFISH.get());
    }
}
