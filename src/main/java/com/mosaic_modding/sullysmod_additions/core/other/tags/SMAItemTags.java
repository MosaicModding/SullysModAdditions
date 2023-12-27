package com.mosaic_modding.sullysmod_additions.core.other.tags;

import com.teamabnormals.blueprint.core.util.TagUtil;
import com.uraneptus.fishermens_trap.FishermensTrap;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class SMAItemTags {

    //Quark Tags
    public static final TagKey<Item> VERTICAL_SLABS = TagUtil.itemTag("quark", "vertical_slabs");
    public static final TagKey<Item> GLOW_BERRIES = TagUtil.itemTag(FishermensTrap.MOD_ID, "jei_display_results/minecraft/glow_berries");
}
