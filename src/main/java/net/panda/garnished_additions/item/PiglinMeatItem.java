package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class PiglinMeatItem extends Item {
   public PiglinMeatItem(Properties properties) {
      super(properties.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.33F).build()));
   }
}
