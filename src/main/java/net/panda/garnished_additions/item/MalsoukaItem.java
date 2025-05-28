package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class MalsoukaItem extends Item {
   public MalsoukaItem(Properties properties) {
      super(properties.food(new FoodProperties.Builder().nutrition(11).saturationModifier(0.8F).build()));
   }
}
