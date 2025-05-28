package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.panda.garnished_additions.item.template.BowlFoodItem;

public class HotNStickyStewItem extends BowlFoodItem {
   public HotNStickyStewItem(Properties properties) {
      super(properties.stacksTo(1), new FoodProperties.Builder().nutrition(14).saturationModifier(0.39F));
   }
}
