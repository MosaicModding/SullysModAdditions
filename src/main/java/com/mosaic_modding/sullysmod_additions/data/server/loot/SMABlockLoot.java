package com.mosaic_modding.sullysmod_additions.data.server.loot;

import com.mosaic_modding.sullysmod_additions.core.registry.SMABlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class SMABlockLoot extends BlockLootSubProvider {
    private static final Set<Item> EXPLOSION_RESISTANT = Set.of();

    protected SMABlockLoot() {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return SMABlocks.HELPER.getDeferredRegister().getEntries().stream().map(RegistryObject::get)::iterator;
    }

    @Override
    protected void generate() {
        SMABlocks.VERTICAL_SLABS.forEach((block, parent) -> createSlab(block.get()));
    }

    private void createSlab(Block block) {
        add(block, createSlabItemTable(block));
    }
}
