package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.panda.garnished_additions.item.template.BowlFoodItem;

public class DangerNoodlesItem extends BowlFoodItem {
   public DangerNoodlesItem(Properties properties) {
      super(properties, new FoodProperties.Builder().nutrition(8).saturationModifier(0.56F));
   }
}
