package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class ChestnutCakeSliceItem extends Item {
   public ChestnutCakeSliceItem(Properties properties) {
      super(properties.food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.5F).build()));
   }
}
