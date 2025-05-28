package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class PoundCakeItem extends Item {
   public PoundCakeItem(Properties properties) {
      super(properties.stacksTo(16).food(new FoodProperties.Builder().nutrition(16).saturationModifier(0.44F).build()));
   }
}
