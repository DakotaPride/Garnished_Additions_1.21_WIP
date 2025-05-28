package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.panda.garnished_additions.item.template.BowlFoodItem;

public class SlimeStewItem extends BowlFoodItem {
   public SlimeStewItem(Properties properties) {
      super(properties.stacksTo(1), new FoodProperties.Builder().nutrition(8).saturationModifier(0.38F));
   }
}
