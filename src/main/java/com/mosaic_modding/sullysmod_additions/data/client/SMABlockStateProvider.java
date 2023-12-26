package com.mosaic_modding.sullysmod_additions.data.client;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import com.mosaic_modding.sullysmod_additions.core.registry.SMABlocks;
import com.mosaic_modding.sullysmod_additions.data.SMADatagenUtil;
import com.teamabnormals.blueprint.common.block.VerticalSlabBlock;
import com.uraneptus.sullysmod.core.data.SMDatagenUtil;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

import static com.mosaic_modding.sullysmod_additions.data.SMADatagenUtil.*;

@SuppressWarnings("SameParameterValue")
public class SMABlockStateProvider extends BlockStateProvider {
    public SMABlockStateProvider(PackOutput packOutput, ExistingFileHelper exFileHelper) {
        super(packOutput, SullysModAdditions.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        SMABlocks.VERTICAL_SLABS.forEach(this::modVerticalSlabBlock);

        /*
        modVerticalSlabBlock(SMBlocks.POLISHED_JADE_BRICK_VERTICAL_SLAB, JADE_BRICKS);
        modVerticalSlabBlock(SMBlocks.POLISHED_SMALL_JADE_BRICK_VERTICAL_SLAB, SMALL_JADE_BRICKS);
        modVerticalSlabBlock(SMBlocks.POLISHED_JADE_SHINGLE_VERTICAL_SLAB, JADE_SHINGLES);
        modVerticalSlabBlock(SMBlocks.POLISHED_JADE_TILE_VERTICAL_SLAB, JADE_TILES);
        modVerticalSlabBlock(SMBlocks.ROUGH_JADE_BRICK_VERTICAL_SLAB, ROUGH_JADE_BRICKS);
        modVerticalSlabBlock(SMBlocks.SMOOTHED_ROUGH_JADE_VERTICAL_SLAB, SMOOTHED_ROUGH_JADE);
        modVerticalSlabBlock(SMBlocks.ROUGH_JADE_TILE_VERTICAL_SLAB, ROUGH_JADE_TILES);

         */

    }


    //TODO change parent model to own thing
    private void modVerticalSlabBlock(Supplier<? extends Block> slab, Supplier<? extends Block> parent) {
        ModelFile model = this.models()
                .withExistingParent(name(slab.get()), blueprintBlockLocation("vertical_slab"))
                .texture("top", SMDatagenUtil.modBlockLocation(name(parent.get())))
                .texture("bottom", SMDatagenUtil.modBlockLocation(name(parent.get())))
                .texture("side", SMDatagenUtil.modBlockLocation(name(parent.get())));

        getVariantBuilder(slab.get())
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.NORTH).addModels(new ConfiguredModel(model, 0, 0, true))
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.SOUTH).addModels(new ConfiguredModel(model, 0, 180, true))
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.EAST).addModels(new ConfiguredModel(model, 0, 90, true))
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.WEST).addModels(new ConfiguredModel(model, 0, 270, true))
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.DOUBLE).addModels(new ConfiguredModel(this.models().getExistingFile(SMDatagenUtil.modBlockLocation(name(parent.get())))));
    }
}
