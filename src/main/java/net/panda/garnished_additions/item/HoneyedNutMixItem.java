package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class HoneyedNutMixItem extends Item {
   public HoneyedNutMixItem(Properties properties) {
      super(properties.stacksTo(16).food(new FoodProperties.Builder().nutrition(15).saturationModifier(0.43F).build()));
   }
}
