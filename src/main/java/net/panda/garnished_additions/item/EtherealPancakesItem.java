package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class EtherealPancakesItem extends Item {
   public EtherealPancakesItem(Properties properties) {
      super(properties.food(new FoodProperties.Builder().nutrition(9).saturationModifier(0.44F).build()));
   }
}
