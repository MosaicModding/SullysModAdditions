package com.mosaic_modding.sullysmod_additions.core.integration;

import com.google.common.collect.BiMap;
import com.teamabnormals.blueprint.core.util.BlockUtil;
import com.uraneptus.sullysmod.common.blocks.WeatheringCopperButtonBlock;
import com.uraneptus.sullysmod.core.registry.SMBlocks;
import galena.copperative.content.event.CommonEvents;
import galena.copperative.content.item.PatinaItem;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;

import java.util.Optional;

public class CopperativeCompat {
    private static boolean isActive = false;

    public static void init() {
        isActive = true;
    }

    public static void handleAxeScrape(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockState blockState = level.getBlockState(event.getPos());
        Block block = blockState.getBlock();
        ItemStack itemStack = event.getItemStack();
        BlockHitResult hitResult = event.getHitVec();
        Player player = event.getEntity();
        BlockPos pos = event.getPos();

        if (!isActive) return;
        if (player == null ) return;
        if (block instanceof WeatheringCopperButtonBlock) {
            if (level instanceof ServerLevel serverLevel && itemStack.getItem() instanceof AxeItem && WeatheringCopperButtonBlock.getPrevious(blockState).isPresent()) {
                var dropPos = hitResult.getBlockPos();
                var clickedFace = hitResult.getDirection();
                var lootTable = serverLevel.getServer().getLootData().getLootTable(CommonEvents.PATINA_LOOT_TABLE);
                var lootContext = new LootParams.Builder(serverLevel)
                        .withParameter(LootContextParams.BLOCK_STATE, blockState)
                        .withParameter(LootContextParams.ORIGIN, hitResult.getLocation())
                        .withParameter(LootContextParams.TOOL, itemStack)
                        .withParameter(LootContextParams.THIS_ENTITY, player)
                        .create(LootContextParamSets.BLOCK);

                lootTable.getRandomItems(lootContext).forEach(stack ->
                        Block.popResourceFromFace(serverLevel, dropPos, clickedFace, stack)
                );
            }
            //Can't continue until this is static
            if (player.isShiftKeyDown() && itemStack.getItem() instanceof PatinaItem && getNextBlock(blockState).isPresent()) {
                BlockState nextBlock = getNextBlock(blockState).get();
                level.setBlock(pos, BlockUtil.transferAllBlockStates(blockState, nextBlock), 11);
                player.swing(event.getHand());
                level.playSound(player, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3005, pos, 0);

                if (!player.isCreative()) {
                    itemStack.shrink(1);
                }
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, pos, itemStack);
                }
            }
        }
    }

    public static Optional<BlockState> getNextBlock(BlockState state) {
        return Optional.ofNullable((Block)((BiMap<?, ?>)WeatheringCopperButtonBlock.NEXT_BY_BLOCK.get()).get(state.getBlock())).map((block) -> block.withPropertiesOf(state));
    }
}
