package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CashewPieItem extends Item {
   public CashewPieItem(Properties properties) {
      super(properties.stacksTo(16).food(new FoodProperties.Builder().nutrition(12).saturationModifier(0.5F).build()));
   }
}
