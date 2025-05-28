package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class BakewellTartItem extends Item {
   public BakewellTartItem(Properties properties) {
      super(properties.food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.4F).build()));
   }
}
