package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class ChestnutCakeItem extends Item {
   public ChestnutCakeItem(Properties properties) {
      super(properties.stacksTo(16).food(new FoodProperties.Builder().nutrition(16).saturationModifier(0.5F).build()));
   }
}
