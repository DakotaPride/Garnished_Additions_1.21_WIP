package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class IronnutItem extends Item {
   public IronnutItem(Properties properties) {
      super(properties.food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.36F).build()));
   }
}
