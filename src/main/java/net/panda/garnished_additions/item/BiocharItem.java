package net.panda.garnished_additions.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.panda.garnished_additions.init.GarnishedAdditionsItemsInit;

public class BiocharItem extends Item {
   public BiocharItem(Properties properties) {
      super(properties);
   }

   @Override
   public InteractionResult useOn(UseOnContext context) {
      super.useOn(context);

      Level level = context.getLevel();
      BlockPos pos0 = context.getClickedPos();

      BlockPos pos1 = BlockPos.containing(pos0.getX(), pos0.getY(), pos0.getZ());
      if ((BoneMealItem.growCrop(GarnishedAdditionsItemsInit.BIOCHAR.asStack(), level, pos1)
              || BoneMealItem.growWaterPlant(GarnishedAdditionsItemsInit.BIOCHAR.asStack(), level, pos1, null))
              && !level.isClientSide) {
         level.levelEvent(2005, pos1, 0);
      }

      return InteractionResult.SUCCESS;
   }
}
