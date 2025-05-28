package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class CookedGlowSquidItem extends Item {
   public CookedGlowSquidItem(Properties properties) {
      super(properties.food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.42F).build()));
   }
}
