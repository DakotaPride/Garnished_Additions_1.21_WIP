package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.panda.garnished_additions.item.template.BowlFoodItem;

public class ElderGuardianFinSoupItem extends BowlFoodItem {
   public ElderGuardianFinSoupItem(Properties properties) {
      super(properties, new FoodProperties.Builder().nutrition(16).saturationModifier(0.44F));
   }
}
