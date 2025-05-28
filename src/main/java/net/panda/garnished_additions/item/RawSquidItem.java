package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class RawSquidItem extends Item {
   public RawSquidItem(Properties properties) {
      super(properties.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.17F).build()));
   }
}
