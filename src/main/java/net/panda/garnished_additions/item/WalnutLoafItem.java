package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class WalnutLoafItem extends Item {
   public WalnutLoafItem(Properties properties) {
      super(properties.stacksTo(32).food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.56F).build()));
   }
}
