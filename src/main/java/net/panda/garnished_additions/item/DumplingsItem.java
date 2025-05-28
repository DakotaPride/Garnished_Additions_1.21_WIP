package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class DumplingsItem extends Item {
   public DumplingsItem(Properties properties) {
      super(properties.stacksTo(32).food(new FoodProperties.Builder().nutrition(9).saturationModifier(0.6F).build()));
   }
}
