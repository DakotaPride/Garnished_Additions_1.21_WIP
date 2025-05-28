package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.panda.garnished_additions.item.template.BowlFoodItem;

public class BlazeNoodlesItem extends BowlFoodItem {
   public BlazeNoodlesItem(Properties properties) {
      super(properties.fireResistant(), new FoodProperties.Builder().nutrition(8).saturationModifier(0.38F));
   }

}
