package net.panda.garnished_additions.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.panda.garnished_additions.init.GarnishedAdditionsItemsInit;

public class EtherealLeavesBlock extends LeavesBlock {
    public EtherealLeavesBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (stack.canPerformAction(net.neoforged.neoforge.common.ItemAbilities.SHEARS_HARVEST))
            popResource(level, pos, new ItemStack(GarnishedAdditionsItemsInit.ETHEREAL_LEAF.asItem(), 1));

        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }
}
