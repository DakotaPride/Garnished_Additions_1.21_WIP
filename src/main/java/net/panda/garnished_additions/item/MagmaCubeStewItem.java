package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item.Properties;
import net.panda.garnished_additions.item.template.BowlFoodItem;

public class MagmaCubeStewItem extends BowlFoodItem {
   public MagmaCubeStewItem(Properties properties) {
      super(properties.stacksTo(1), new FoodProperties.Builder().nutrition(10).saturationModifier(0.4F));
   }
}
