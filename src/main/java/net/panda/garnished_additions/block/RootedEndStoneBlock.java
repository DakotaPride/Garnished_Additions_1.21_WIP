package net.panda.garnished_additions.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.Tags;
import net.panda.garnished_additions.init.GarnishedAdditionsItemsInit;

public class RootedEndStoneBlock extends Block {
    public RootedEndStoneBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        //ItemStack stack = pPlayer.getItemInHand(pHand);

        if (stack.is(Items.SHEARS)) {
            pLevel.addFreshEntity(
                    new ItemEntity(
                            pLevel,
                            pPos.getX(),
                            pPos.getY() + 0.5,
                            pPos.getZ(),
                            GarnishedAdditionsItemsInit.ETHEREAL_ROOTS.asStack()
                    ));
            pLevel.setBlock(pPos, Blocks.END_STONE.defaultBlockState(), 19);

            stack.hurtAndBreak(1, pPlayer, LivingEntity.getSlotForHand(pHand));

            return ItemInteractionResult.SUCCESS;
        }

        return super.useItemOn(stack, pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
