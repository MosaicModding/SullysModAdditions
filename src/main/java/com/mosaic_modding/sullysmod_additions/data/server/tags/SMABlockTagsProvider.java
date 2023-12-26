package com.mosaic_modding.sullysmod_additions.data.server.tags;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import com.mosaic_modding.sullysmod_additions.core.other.tags.SMABlockTags;
import com.mosaic_modding.sullysmod_additions.core.registry.SMABlocks;
import com.uraneptus.sullysmod.core.other.tags.SMBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SMABlockTagsProvider extends BlockTagsProvider {

    public SMABlockTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, pProvider, SullysModAdditions.MOD_ID, existingFileHelper);
    }

    @Override
    public void addTags(HolderLookup.Provider pProvider) {
        SMABlocks.VERTICAL_SLABS.forEach((block, parent) -> {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block.get());
            tag(BlockTags.NEEDS_IRON_TOOL).add(block.get());
            tag(SMBlockTags.PROJECTILES_BOUNCE_ON).add(block.get());
            tag(SMABlockTags.VERTICAL_SLABS).add(block.get());
        });
    }
}
