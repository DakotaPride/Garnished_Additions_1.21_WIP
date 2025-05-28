package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.panda.garnished_additions.item.template.BowlFoodItem;

public class PiglinStewItem extends BowlFoodItem {
   public PiglinStewItem(Properties properties) {
      super(properties.stacksTo(1), new FoodProperties.Builder().nutrition(12).saturationModifier(0.42F));
   }
}
