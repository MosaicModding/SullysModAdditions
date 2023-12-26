package com.mosaic_modding.sullysmod_additions.core.registry;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import com.teamabnormals.blueprint.core.util.registry.EntitySubRegistryHelper;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SullysModAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SMAEntityTypes {
    public static final EntitySubRegistryHelper HELPER = SullysModAdditions.REGISTRY_HELPER.getEntitySubHelper();

}