package com.mosaic_modding.sullysmod_additions;

import com.mojang.logging.LogUtils;
import com.mosaic_modding.sullysmod_additions.data.client.*;
import com.mosaic_modding.sullysmod_additions.data.server.SMADatapackBuiltinEntriesProvider;
import com.mosaic_modding.sullysmod_additions.data.server.SMARecipeProvider;
import com.mosaic_modding.sullysmod_additions.data.server.advancements.SMAAdvancementProvider;
import com.mosaic_modding.sullysmod_additions.data.server.loot.SMALootTableProvider;
import com.mosaic_modding.sullysmod_additions.data.server.modifiers.SMAAdvancementModifiersProvider;
import com.mosaic_modding.sullysmod_additions.data.server.modifiers.SMALootModifierProvider;
import com.mosaic_modding.sullysmod_additions.data.server.tags.SMABiomeTagsProvider;
import com.mosaic_modding.sullysmod_additions.data.server.tags.SMABlockTagsProvider;
import com.mosaic_modding.sullysmod_additions.data.server.tags.SMAEntityTagsProvider;
import com.mosaic_modding.sullysmod_additions.data.server.tags.SMAItemTagsProvider;
import com.mosaic_modding.sullysmod_additions.core.integration.CompatHandler;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.concurrent.CompletableFuture;

@Mod(SullysModAdditions.MOD_ID)
@Mod.EventBusSubscriber(modid = SullysModAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SullysModAdditions {
    public static final String MOD_ID = "sullysmod_additions";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);
    public static final Logger LOGGER = LogUtils.getLogger();

    public SullysModAdditions() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(this::gatherData);

        REGISTRY_HELPER.register(bus);
        CompatHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation modPrefix(String path) {
        return new ResourceLocation(SullysModAdditions.MOD_ID, path);
    }

    @SubscribeEvent
    public static void addEntityAttributes(final EntityAttributeCreationEvent event) {

    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });
    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        boolean includeClient = event.includeClient();
        boolean includeServer = event.includeServer();
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(includeClient, new SMABlockStateProvider(packOutput, fileHelper));
        generator.addProvider(includeClient, new SMAItemModelProvider(packOutput, fileHelper));
        generator.addProvider(includeClient, new SMASoundDefinitionsProvider(packOutput, fileHelper));
        generator.addProvider(includeClient, new SMALangProvider(packOutput));

        SMABlockTagsProvider blockTagProvider = new SMABlockTagsProvider(packOutput, lookupProvider, fileHelper);
        generator.addProvider(includeServer, new SMAEntityTagsProvider(packOutput, lookupProvider, fileHelper));
        generator.addProvider(includeServer, blockTagProvider);
        generator.addProvider(includeServer, new SMAItemTagsProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), fileHelper));
        generator.addProvider(includeServer, new SMABiomeTagsProvider(packOutput, lookupProvider, fileHelper));
        generator.addProvider(includeServer, new SMAAdvancementModifiersProvider(packOutput, lookupProvider));
        generator.addProvider(includeServer, new SMALootTableProvider(packOutput));
        generator.addProvider(includeServer, new SMAAdvancementProvider(packOutput, lookupProvider, fileHelper));
        generator.addProvider(includeServer, new SMARecipeProvider(packOutput));
        generator.addProvider(includeServer, new SMALootModifierProvider(packOutput, lookupProvider));
        generator.addProvider(includeServer, new SMADatapackBuiltinEntriesProvider(packOutput, lookupProvider));
    }
}