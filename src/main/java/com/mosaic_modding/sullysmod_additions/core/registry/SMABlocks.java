package com.mosaic_modding.sullysmod_additions.core.registry;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import com.mosaic_modding.sullysmod_additions.common.blocks.SMAVerticalSlabBlock;
import com.teamabnormals.blueprint.common.block.VerticalSlabBlock;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.uraneptus.sullysmod.core.other.SMProperties;
import com.uraneptus.sullysmod.core.registry.SMBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import oshi.util.tuples.Pair;

import java.util.HashMap;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = SullysModAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SMABlocks {
    public static final BlockSubRegistryHelper HELPER = SullysModAdditions.REGISTRY_HELPER.getBlockSubHelper();
    public static HashMap<Supplier<Block>, Supplier<Block>> VERTICAL_SLABS = new HashMap<>();

    //Jade Vertical Slabs
    public static final RegistryObject<Block> ROUGH_JADE_BRICK_VERTICAL_SLAB = createVerticalSlab(SMBlocks.ROUGH_JADE_BRICKS, SMProperties.Blocks.ROUGH_JADE_BLOCKS);
    public static final RegistryObject<Block> SMOOTHED_ROUGH_JADE_VERTICAL_SLAB = createVerticalSlab(SMBlocks.SMOOTHED_ROUGH_JADE, SMProperties.Blocks.ROUGH_JADE_BLOCKS);
    public static final RegistryObject<Block> ROUGH_JADE_TILE_VERTICAL_SLAB = createVerticalSlab(SMBlocks.ROUGH_JADE_TILES, SMProperties.Blocks.ROUGH_JADE_BLOCKS);
    public static final RegistryObject<Block> POLISHED_JADE_BRICK_VERTICAL_SLAB = createVerticalSlab(SMBlocks.POLISHED_JADE_BRICKS, SMProperties.Blocks.POLISHED_JADE_BLOCKS);
    public static final RegistryObject<Block> POLISHED_SMALL_JADE_BRICK_VERTICAL_SLAB = createVerticalSlab(SMBlocks.POLISHED_SMALL_JADE_BRICKS, SMProperties.Blocks.POLISHED_JADE_BLOCKS);
    public static final RegistryObject<Block> POLISHED_JADE_SHINGLE_VERTICAL_SLAB = createVerticalSlab(SMBlocks.POLISHED_JADE_SHINGLES, SMProperties.Blocks.POLISHED_JADE_BLOCKS);
    public static final RegistryObject<Block> POLISHED_JADE_TILE_VERTICAL_SLAB = createVerticalSlab(SMBlocks.POLISHED_JADE_TILES, SMProperties.Blocks.POLISHED_JADE_BLOCKS);

    public static RegistryObject<Block> createVerticalSlab(RegistryObject<Block> parent, BlockBehaviour.Properties properties) {
        String name = removeS(parent.getId().getPath()) + "_vertical_slab";
        RegistryObject<Block> regObject = HELPER.createBlock(name, () -> new SMAVerticalSlabBlock(parent, properties));
        VERTICAL_SLABS.put(regObject, parent);

        return regObject;
    }

    public static String removeS(String old) {
        if (old.endsWith("s")) {
            old = old.substring(0, old.length() - 1);
        }
        return old;
    }
}
