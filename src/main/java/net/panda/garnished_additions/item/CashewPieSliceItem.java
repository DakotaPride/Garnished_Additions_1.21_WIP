package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CashewPieSliceItem extends Item {
   public CashewPieSliceItem(Properties properties) {
      super(properties.food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.5F).build()));
   }
}
