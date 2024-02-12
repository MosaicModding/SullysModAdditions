package com.mosaic_modding.sullysmod_additions.data.server.tags;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import com.mosaic_modding.sullysmod_additions.core.integration.TFCompat;
import com.uraneptus.sullysmod.core.other.tags.SMBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SMABiomeTagsProvider extends BiomeTagsProvider {
    public SMABiomeTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper fileHelper) {
        super(packOutput, pProvider, SullysModAdditions.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(SMBiomeTags.LANTERNFISH_SPAWN_IN).addOptional(TFCompat.STREAM_BIOME);
    }
}
