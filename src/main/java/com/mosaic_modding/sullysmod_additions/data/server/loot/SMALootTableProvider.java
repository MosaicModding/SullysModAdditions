package com.mosaic_modding.sullysmod_additions.data.server.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.Collections;
import java.util.List;

public class SMALootTableProvider extends LootTableProvider {

    public SMALootTableProvider(PackOutput packOutput) {
        super(packOutput, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(SMABlockLoot::new, LootContextParamSets.BLOCK)
        ));
    }

}
