package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class CookedStriderItem extends Item {
   public CookedStriderItem(Properties properties) {
      super(properties.fireResistant().food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.6F).build()));
   }
}
