package com.mosaic_modding.sullysmod_additions.core.events;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import com.mosaic_modding.sullysmod_additions.core.integration.CopperativeCompat;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SullysModAdditions.MOD_ID)
public class SMAPlayerEvents {

    @SubscribeEvent
    public static void handleAxeScrape(PlayerInteractEvent.RightClickBlock event) {
        CopperativeCompat.handleAxeScrape(event);
    }


}
