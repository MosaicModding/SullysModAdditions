package com.mosaic_modding.sullysmod_additions.core.events;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import com.mosaic_modding.sullysmod_additions.core.integration.TFCompat;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SullysModAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SMACommonEvents {

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerSpawnPlacement(SpawnPlacementRegisterEvent event) {
        TFCompat.handleLanternfishSpawn(event);
    }
}
