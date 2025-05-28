package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class WalnutPieItem extends Item {
   public WalnutPieItem(Properties properties) {
      super(properties.stacksTo(16).food(new FoodProperties.Builder().nutrition(12).saturationModifier(0.5F).build()));
   }
}
