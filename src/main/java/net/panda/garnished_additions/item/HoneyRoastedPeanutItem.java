package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class HoneyRoastedPeanutItem extends Item {
   public HoneyRoastedPeanutItem(Properties properties) {
      super(properties.food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.5F).build()));
   }
}
