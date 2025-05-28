package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class SweetenedNutMixItem extends Item {
   public SweetenedNutMixItem(Properties properties) {
      super(properties.stacksTo(16).food(new FoodProperties.Builder().nutrition(14).saturationModifier(0.45F).build()));
   }
}
