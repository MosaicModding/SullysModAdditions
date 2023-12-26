package com.mosaic_modding.sullysmod_additions.data.server.modifiers;

import com.mosaic_modding.sullysmod_additions.SullysModAdditions;
import com.teamabnormals.blueprint.common.advancement.modification.AdvancementModifierProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class SMAAdvancementModifiersProvider extends AdvancementModifierProvider {
    public SMAAdvancementModifiersProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(SullysModAdditions.MOD_ID, packOutput, lookupProvider);
    }

    @Override
    protected void registerEntries(HolderLookup.Provider provider) {
        /*
        //Balanced Diet Setup
        CriteriaModifier.Builder constructBalancedDiet = CriteriaModifier.builder(this.modId);
        Collection<RegistryObject<Item>> items = SMItems.HELPER.getDeferredRegister().getEntries();

        items.forEach((item) -> {
            if (item.get().isEdible()) {
                constructBalancedDiet.addCriterion(ForgeRegistries.ITEMS.getKey(item.get()).getPath(), ConsumeItemTrigger.TriggerInstance.usedItem(item.get()));
            }
        });

        //Modifiers
        this.entry("husbandry/wax_on").selects("husbandry/wax_on").addModifier(CriteriaModifier.builder(this.modId).addCriterion("wax_on", ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(SMBlockTags.WAXABLE_COPPER_BLOCKS).build()), ItemPredicate.Builder.item().of(Items.HONEYCOMB))).addIndexedRequirements(0, false, "wax_on").build());
        this.entry("husbandry/wax_off").selects("husbandry/wax_off").addModifier(CriteriaModifier.builder(this.modId).addCriterion("wax_off", ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(SMBlockTags.WAXED_COPPER_BLOCKS).build()), ItemPredicate.Builder.item().of(SMItemTags.AXE_ITEMS))).addIndexedRequirements(0, false, "wax_off").build());
        this.entry("husbandry/balanced_diet").selects("husbandry/balanced_diet").addModifier(constructBalancedDiet.requirements(RequirementsStrategy.AND).build());
        this.entry("husbandry/tactical_fishing").selects("husbandry/tactical_fishing").addModifier(CriteriaModifier.builder(this.modId).addCriterion("lanternfish_bucket", FilledBucketTrigger.TriggerInstance.filledBucket(ItemPredicate.Builder.item().of(SMItems.LANTERNFISH_BUCKET.get()).build())).addIndexedRequirements(0, false, "lanternfish_bucket").build());
        this.entry("husbandry/bred_all_animals").selects("husbandry/bred_all_animals").addModifier(CriteriaModifier.builder(this.modId).addCriterion("tortoise", BredAnimalsTrigger.TriggerInstance.bredAnimals(EntityPredicate.Builder.entity().of(SMEntityTypes.TORTOISE.get()))).requirements(RequirementsStrategy.AND).build());
        this.entry("adventure/kill_a_mob").selects("adventure/kill_a_mob").addModifier(CriteriaModifier.builder(this.modId).addCriterion("bouldering_zombie", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(SMEntityTypes.BOULDERING_ZOMBIE.get()))).addCriterion("jungle_spider", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(SMEntityTypes.JUNGLE_SPIDER.get()))).addIndexedRequirements(0, false, "jungle_spider", "bouldering_zombie").build());
        this.entry("adventure/kill_all_mobs").selects("adventure/kill_all_mobs").addModifier(CriteriaModifier.builder(this.modId).addCriterion("bouldering_zombie", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(SMEntityTypes.BOULDERING_ZOMBIE.get()))).addCriterion("jungle_spider", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(SMEntityTypes.JUNGLE_SPIDER.get()))).requirements(RequirementsStrategy.AND).build());
        this.entry("nether/all_potions").selects("nether/all_potions").addModifier(new EffectsChangedModifier("all_effects", false, MobEffectsPredicate.effects().and(MobEffects.LUCK).and(MobEffects.UNLUCK)));
        this.entry("nether/all_effects").selects("nether/all_effects").addModifier(new EffectsChangedModifier("all_effects", false, MobEffectsPredicate.effects().and(MobEffects.LUCK).and(MobEffects.UNLUCK)));

         */
    }
}
