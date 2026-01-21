package net.panda.garnished_additions.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.panda.garnished_additions.init.GarnishedAdditionsItemsInit;

import java.util.Random;

public class EtherealLeavesBlock extends LeavesBlock {
    public EtherealLeavesBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (stack.canPerformAction(net.neoforged.neoforge.common.ItemAbilities.SHEARS_HARVEST)) {
            popResource(level, pos, new ItemStack(GarnishedAdditionsItemsInit.ETHEREAL_LEAF.asItem(), 1 + (new Random().nextInt(2))));
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 1);
            spawnDestroyParticles(level, player, pos, state);

            EquipmentSlot equipmentslot = stack.equals(player.getItemBySlot(EquipmentSlot.OFFHAND)) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
            stack.hurtAndBreak(1, player, equipmentslot);
        }

        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }
}
