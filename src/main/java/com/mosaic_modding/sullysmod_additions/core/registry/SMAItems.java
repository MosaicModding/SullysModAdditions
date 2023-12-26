package com.mosaic_modding.sullysmod_additions.core.registry;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import com.mosaic_modding.sullysmod_additions.common.items.SMAFoodBucketItem;
import com.mosaic_modding.sullysmod_additions.core.integration.CompatHandler;
import com.mosaic_modding.sullysmod_additions.core.integration.FDCompat;
import com.mosaic_modding.sullysmod_additions.core.other.SMAProperties;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = SullysModAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SMAItems {
    public static final ItemSubRegistryHelper HELPER = SullysModAdditions.REGISTRY_HELPER.getItemSubHelper();

    //Compat Food
    public static final RegistryObject<Item> LANTERNFISH_SLICE = HELPER.createItem("lanternfish_slice", () -> new Item(PropertyUtil.food(SMAProperties.Foods.LANTERNFISH_SLICE_FOOD)));
    public static final RegistryObject<Item> COOKED_LANTERNFISH_SLICE = HELPER.createItem("cooked_lanternfish_slice", () -> new Item(PropertyUtil.food(SMAProperties.Foods.COOKED_LANTERNFISH_SLICE_FOOD)));
    public static final RegistryObject<Item> LANTERNFISH_ROLL = HELPER.createItem("lanternfish_roll", () -> new Item(PropertyUtil.food(SMAProperties.Foods.LANTERNFISH_ROLL_FOOD)));
    public static final RegistryObject<Item> CAVE_CHUM_BUCKET = HELPER.createItem("cave_chum_bucket", () -> new SMAFoodBucketItem(SMAProperties.Items.CAVE_CHUM_BUCKET));




}
