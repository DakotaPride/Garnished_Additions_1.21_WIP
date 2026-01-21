package net.panda.garnished_additions.block;

import net.dakotapride.garnished.item.hatchet.HatchetUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import net.panda.garnished_additions.init.GarnishedAdditionsBlocksInit;
import org.jetbrains.annotations.Nullable;

public class EtherealLogBlock extends RotatedPillarBlock {
    public EtherealLogBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility toolAction, boolean simulate) {
        if (HatchetUtils.canBeUsedToStripLogs(context.getItemInHand().getItem().getDefaultInstance())) {
            Level level = context.getLevel();
            Player player = context.getPlayer();
            BlockPos pos = context.getClickedPos();

            if (state.is(GarnishedAdditionsBlocksInit.ETHEREAL_LOG.get())) {
                level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                return GarnishedAdditionsBlocksInit.STRIPPED_ETHEREAL_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if (state.is(GarnishedAdditionsBlocksInit.ETHEREAL_WOOD.get())) {
                level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                return GarnishedAdditionsBlocksInit.STRIPPED_ETHEREAL_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
