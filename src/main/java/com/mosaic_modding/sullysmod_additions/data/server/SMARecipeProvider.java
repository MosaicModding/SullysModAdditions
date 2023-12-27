package com.mosaic_modding.sullysmod_additions.data.server;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import com.mosaic_modding.sullysmod_additions.core.integration.VerticalSlabsCompat;
import com.mosaic_modding.sullysmod_additions.core.registry.SMABlocks;
import com.mosaic_modding.sullysmod_additions.core.registry.SMAItems;
import com.mosaic_modding.sullysmod_additions.data.SMADatagenUtil;
import com.mosaic_modding.sullysmod_additions.core.integration.CompatHandler;
import com.mosaic_modding.sullysmod_additions.core.integration.FDCompat;
import com.teamabnormals.blueprint.core.api.conditions.QuarkFlagRecipeCondition;
import com.uraneptus.sullysmod.SullysMod;
import com.uraneptus.sullysmod.core.data.server.SMRecipeProvider;
import com.uraneptus.sullysmod.core.data.server.builder.GrindstonePolishingRecipeBuilder;
import com.uraneptus.sullysmod.core.registry.SMBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

import java.util.function.Consumer;
import java.util.function.Supplier;

@SuppressWarnings("SameParameterValue")
public class SMARecipeProvider extends SMRecipeProvider {

    public SMARecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        modLoadedCookingRecipes(CompatHandler.FDID, SMAItems.LANTERNFISH_SLICE, SMAItems.COOKED_LANTERNFISH_SLICE, 0.35F, consumer);
        fishRollRecipes(SMAItems.LANTERNFISH_SLICE, SMAItems.LANTERNFISH_ROLL, consumer);

        verticalSlabRecipes(SMBlocks.ROUGH_JADE_BRICK_SLAB, SMABlocks.ROUGH_JADE_BRICK_VERTICAL_SLAB, consumer);
        verticalSlabRecipes(SMBlocks.ROUGH_JADE_TILE_SLAB, SMABlocks.ROUGH_JADE_TILE_VERTICAL_SLAB, consumer);
        verticalSlabRecipes(SMBlocks.SMOOTHED_ROUGH_JADE_SLAB, SMABlocks.SMOOTHED_ROUGH_JADE_VERTICAL_SLAB, consumer);
        verticalSlabRecipes(SMBlocks.POLISHED_JADE_BRICK_SLAB, SMABlocks.POLISHED_JADE_BRICK_VERTICAL_SLAB, consumer);
        verticalSlabRecipes(SMBlocks.POLISHED_JADE_TILE_SLAB, SMABlocks.POLISHED_JADE_TILE_VERTICAL_SLAB, consumer);
        verticalSlabRecipes(SMBlocks.POLISHED_SMALL_JADE_BRICK_SLAB, SMABlocks.POLISHED_SMALL_JADE_BRICK_VERTICAL_SLAB, consumer);
        verticalSlabRecipes(SMBlocks.POLISHED_JADE_SHINGLE_SLAB, SMABlocks.POLISHED_JADE_SHINGLE_VERTICAL_SLAB, consumer);

        verticalSlabPolishing(SMABlocks.ROUGH_JADE_BRICK_VERTICAL_SLAB, SMABlocks.POLISHED_JADE_BRICK_VERTICAL_SLAB, consumer);
        verticalSlabPolishing(SMABlocks.ROUGH_JADE_TILE_VERTICAL_SLAB, SMABlocks.POLISHED_JADE_TILE_VERTICAL_SLAB, consumer);

        vscJadePolishing(CompatHandler.VSCID, VerticalSlabsCompat.getVSCBlock(SMABlocks.ROUGH_JADE_BRICK_VERTICAL_SLAB.get()), VerticalSlabsCompat.getVSCBlock(SMABlocks.POLISHED_JADE_BRICK_VERTICAL_SLAB.get()), consumer);
        vscJadePolishing(CompatHandler.VSCID, VerticalSlabsCompat.getVSCBlock(SMABlocks.ROUGH_JADE_TILE_VERTICAL_SLAB.get()), VerticalSlabsCompat.getVSCBlock(SMABlocks.POLISHED_JADE_TILE_VERTICAL_SLAB.get()), consumer);
    }

    private static void modLoadedCookingRecipes(String modId, Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, float experience, Consumer<FinishedRecipe> consumer) {
        String resultName = getItemName(result.get());

        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(modId))
                .addRecipe(consumer1 -> SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient.get()), RecipeCategory.FOOD, result.get(), experience, 200)
                        .unlockedBy(getHasName(ingredient.get()), has(ingredient.get()))
                        .save(consumer1, SullysModAdditions.modPrefix(getItemName(result.get()))))
                .build(consumer, SMADatagenUtil.smeltingPath(resultName));
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(modId))
                .addRecipe(consumer1 -> SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient.get()), RecipeCategory.FOOD, result.get(), experience, 600)
                        .unlockedBy(getHasName(ingredient.get()), has(ingredient.get()))
                        .save(consumer1, SullysModAdditions.modPrefix(getItemName(result.get()))))
                .build(consumer, SMADatagenUtil.campfire_cookingPath(resultName + "_from_campfire_cooking"));
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(modId))
                .addRecipe(consumer1 -> SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient.get()), RecipeCategory.FOOD, result.get(), experience, 100)
                        .unlockedBy(getHasName(ingredient.get()), has(ingredient.get()))
                        .save(consumer1, SullysModAdditions.modPrefix(getItemName(result.get()))))
                .build(consumer, SMADatagenUtil.smokingPath(resultName + "_from_smoking"));
    }

    private static void fishRollRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(CompatHandler.FDID))
                .addRecipe(consumer1 -> ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result.get(), 2).requires(ingredient.get(), 2).requires(FDCompat.getFDItem("cooked_rice"))
                        .unlockedBy(getHasName(ingredient.get()), has(ingredient.get()))
                        .save(consumer1, SullysModAdditions.modPrefix(getItemName(result.get()))))
                .build(consumer, SMADatagenUtil.craftingPath(getItemName(result.get())));

    }

    private static void verticalSlabRecipes(Supplier<? extends ItemLike> slab, Supplier<? extends ItemLike> verticalSlab, Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(new QuarkFlagRecipeCondition(SMADatagenUtil.QUARK_FLAG, "vertical_slabs"))
                .addRecipe(consumer1 -> ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, verticalSlab.get(), 3).define('#', slab.get()).pattern("#").pattern("#").pattern("#").unlockedBy(getHasName(slab.get()), has(slab.get())).save(consumer1, SullysModAdditions.modPrefix(getItemName(verticalSlab.get()))))
                .build(consumer, SMADatagenUtil.craftingPath(getItemName(verticalSlab.get())));

        ConditionalRecipe.builder()
                .addCondition(new QuarkFlagRecipeCondition(SMADatagenUtil.QUARK_FLAG, "vertical_slabs"))
                .addRecipe(consumer1 -> ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, slab.get()).requires(verticalSlab.get()).unlockedBy(getHasName(verticalSlab.get()), has(verticalSlab.get())).save(consumer1, SullysModAdditions.modPrefix(getItemName(verticalSlab.get()) + "_revert")))
                .build(consumer, SMADatagenUtil.craftingPath(getItemName(verticalSlab.get()) + "_revert"));
    }

    private static void verticalSlabPolishing(Supplier<? extends ItemLike> slab, Supplier<? extends ItemLike> polished, Consumer<FinishedRecipe> consumer) {
        String ingredientName = getItemName(slab.get());
        String resultName = getItemName(polished.get());
        ConditionalRecipe.builder()
                .addCondition(new QuarkFlagRecipeCondition(SMADatagenUtil.QUARK_FLAG, "vertical_slabs"))
                .addRecipe(consumer1 -> GrindstonePolishingRecipeBuilder.grindstonePolishing(RecipeCategory.BUILDING_BLOCKS, polished.get(), 1, 0).requires(slab.get()).save(consumer1, "_from_" + ingredientName))
                .build(consumer, SullysMod.modPrefix("grindstone_polishing/" + resultName + "_from_" + ingredientName));
    }

    private static void vscJadePolishing(String modId, ItemLike slab, ItemLike polished, Consumer<FinishedRecipe> consumer) {
        String ingredientName = getItemName(slab).replace("sullysmod/", "vsc_");
        String resultName = getItemName(polished).replace("sullysmod/", "vsc_");
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(modId))
                .addRecipe(consumer1 -> GrindstonePolishingRecipeBuilder.grindstonePolishing(RecipeCategory.BUILDING_BLOCKS, polished, 1, 0).requires(slab).save(consumer1, "_from_" + ingredientName))
                .build(consumer, SullysMod.modPrefix("grindstone_polishing/" + resultName + "_from_" + ingredientName));
    }
}
