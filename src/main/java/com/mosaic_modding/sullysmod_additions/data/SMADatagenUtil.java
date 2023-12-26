package com.mosaic_modding.sullysmod_additions.data;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import com.uraneptus.sullysmod.SullysMod;
import com.uraneptus.sullysmod.core.data.SMDatagenUtil;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@SuppressWarnings("unused")
public class SMADatagenUtil extends SMDatagenUtil {
    //Quark Flag (We're going to need this a fair amount once that wood gets added)
    public static ResourceLocation QUARK_FLAG = SullysMod.blueprintPrefix("quark_flag");

    public static ResourceLocation modBlockLocation(String path) {
        return SullysModAdditions.modPrefix(ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    public static ResourceLocation modItemLocation(String path) {
        return SullysModAdditions.modPrefix(ModelProvider.ITEM_FOLDER + "/" + path);
    }

    public static ResourceLocation craftingPath(String name) {
        return SullysModAdditions.modPrefix("crafting/" + name);
    }

    public static ResourceLocation smeltingPath(String name) {
        return SullysModAdditions.modPrefix("smelting/" + name);
    }

    public static ResourceLocation blastingPath(String name) {
        return SullysModAdditions.modPrefix("blasting/" + name);
    }

    public static ResourceLocation smokingPath(String name) {
        return SullysModAdditions.modPrefix("smoking/" + name);
    }

    public static ResourceLocation campfire_cookingPath(String name) {
        return SullysModAdditions.modPrefix("campfire_cooking/" + name);
    }

    public static ResourceLocation stonecuttingPath(String name) {
        return SullysModAdditions.modPrefix("stonecutting/" + name);
    }

    public static ResourceLocation smithingPath(String name) {
        return SullysModAdditions.modPrefix("smithing/" + name);
    }
}