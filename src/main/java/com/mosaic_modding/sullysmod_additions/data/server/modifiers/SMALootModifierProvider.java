package com.mosaic_modding.sullysmod_additions.data.server.modifiers;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import com.teamabnormals.blueprint.common.loot.modification.LootModifierProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings({"unused", "SameParameterValue"})
public class SMALootModifierProvider extends LootModifierProvider {

    public SMALootModifierProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(SullysModAdditions.MOD_ID, packOutput, lookupProvider);
    }

    @Override
    protected void registerEntries(HolderLookup.Provider provider) {

    }

    private static LootPoolEntryContainer createLootEntryWithCondition(ItemLike item, int weight, int min, int max, LootItemCondition.Builder condition) {
        return LootItem.lootTableItem(item).setWeight(weight).when(condition).apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))).build();
    }

    private static LootPoolEntryContainer createLootEntry(ItemLike item, int weight, int min, int max) {
        return LootItem.lootTableItem(item).setWeight(weight).apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))).build();
    }

    private static LootPoolEntryContainer createMusicDiscLootEntry(ItemLike item, int weight) {
        return LootItem.lootTableItem(item).setWeight(weight).build();
    }
}
