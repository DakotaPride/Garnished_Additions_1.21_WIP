package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class BlackPuddingItem extends Item {
   public BlackPuddingItem(Properties properties) {
      super(properties.stacksTo(32).food(new FoodProperties.Builder().nutrition(12).saturationModifier(0.42F).build()));
   }
}
