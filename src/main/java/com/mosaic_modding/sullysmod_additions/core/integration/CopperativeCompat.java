package com.mosaic_modding.sullysmod_additions.core.integration;

import com.uraneptus.sullysmod.common.blocks.WeatheringCopperButtonBlock;
import com.uraneptus.sullysmod.core.registry.SMBlocks;
import galena.copperative.content.event.CommonEvents;
import galena.copperative.content.item.PatinaItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;

public class CopperativeCompat {
    private static boolean isActive = false;

    public static void init() {
        isActive = true;
    }

    public static void handleAxeScrape(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        Block block = level.getBlockState(event.getPos()).getBlock();
        ItemStack itemStack = event.getItemStack();
        BlockHitResult hitResult = event.getHitVec();
        Player player = event.getEntity();

        if (!isActive) return;
        if (player == null) return;
        if (block instanceof WeatheringCopperButtonBlock) {
            if (player.isCreative()) {
                if (level instanceof ServerLevel serverLevel && itemStack.getItem() instanceof AxeItem && WeatheringCopperButtonBlock.getPrevious(block.defaultBlockState()).isPresent()) {
                    var dropPos = hitResult.getBlockPos();
                    var clickedFace = hitResult.getDirection();
                    var lootTable = serverLevel.getServer().getLootData().getLootTable(CommonEvents.PATINA_LOOT_TABLE);
                    var lootContext = new LootParams.Builder(serverLevel)
                            .withParameter(LootContextParams.BLOCK_STATE, block.defaultBlockState())
                            .withParameter(LootContextParams.ORIGIN, hitResult.getLocation())
                            .withParameter(LootContextParams.TOOL, itemStack)
                            .withParameter(LootContextParams.THIS_ENTITY, player)
                            .create(LootContextParamSets.BLOCK);

                    lootTable.getRandomItems(lootContext).forEach(stack ->
                            Block.popResourceFromFace(serverLevel, dropPos, clickedFace, stack)
                    );
                }
            }
            //Can't continue until this is static
            if (itemStack.getItem() instanceof PatinaItem && WeatheringCopperButtonBlock.getNext(block.defaultBlockState()).isPresent())
        }


    }
}
