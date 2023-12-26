package com.mosaic_modding.sullysmod_additions.data.client;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

@SuppressWarnings("SameParameterValue")
public class SMASoundDefinitionsProvider extends SoundDefinitionsProvider {

    public SMASoundDefinitionsProvider(PackOutput packOutput, ExistingFileHelper helper) {
        super(packOutput, SullysModAdditions.MOD_ID, helper);
    }


    @Override
    public void registerSounds() {

    }

}
