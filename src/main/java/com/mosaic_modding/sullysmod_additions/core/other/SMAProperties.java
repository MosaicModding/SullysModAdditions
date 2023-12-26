package com.mosaic_modding.sullysmod_additions.core.other;

import com.uraneptus.sullysmod.core.other.SMProperties;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

@SuppressWarnings("unused")
public class SMAProperties extends SMProperties {

    public static final class Blocks {

    }

    public static final class Items {
        public static final Item.Properties FD_COMPAT_TAB = new Item.Properties();
        public static final Item.Properties CAVE_CHUM_BUCKET = sixteenStack().food(SMAProperties.Foods.CAVE_CHUM_BUCKET_FOOD);

        public static Item.Properties sixteenStack() {
            return new Item.Properties().stacksTo(16);
        }
    }

    public static final class Foods {
        public static final FoodProperties LANTERNFISH_SLICE_FOOD = new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 200), 1.0F).fast().build();
        public static final FoodProperties COOKED_LANTERNFISH_SLICE_FOOD = new FoodProperties.Builder().nutrition(3).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 200), 1.0F).fast().build();
        public static final FoodProperties LANTERNFISH_ROLL_FOOD = new FoodProperties.Builder().nutrition(7).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 200), 1.0F).build();
        public static final FoodProperties CAVE_CHUM_BUCKET_FOOD = new FoodProperties.Builder().nutrition(13).saturationMod(1.0F).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 200), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 800), 1.0F).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 800), 1.0F).build();
    }
}
