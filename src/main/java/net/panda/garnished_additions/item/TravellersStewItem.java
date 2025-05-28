package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class TravellersStewItem extends Item {
   public TravellersStewItem(Properties properties) {
      super(properties.stacksTo(1).food(new FoodProperties.Builder().nutrition(16).saturationModifier(0.6F).build()));
   }
}
