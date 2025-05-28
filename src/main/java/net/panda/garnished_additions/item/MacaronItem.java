package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class MacaronItem extends Item {
   public MacaronItem(Properties properties) {
      super(properties.food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.45F).build()));
   }
}
