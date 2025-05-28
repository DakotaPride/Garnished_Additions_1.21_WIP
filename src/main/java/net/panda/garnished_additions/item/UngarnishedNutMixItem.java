package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class UngarnishedNutMixItem extends Item {
   public UngarnishedNutMixItem(Properties properties) {
      super(properties.stacksTo(16).food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.2F).build()));
   }
}
