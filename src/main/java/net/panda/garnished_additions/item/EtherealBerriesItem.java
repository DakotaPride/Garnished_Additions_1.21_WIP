package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemNameBlockItem;
import net.panda.garnished_additions.init.GarnishedAdditionsBlocksInit;

public class EtherealBerriesItem extends ItemNameBlockItem {
   public EtherealBerriesItem(Properties properties) {
      super(GarnishedAdditionsBlocksInit.ETHEREAL_BERRY_BUSH.get(), properties.food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.4F).build()));
   }
}
