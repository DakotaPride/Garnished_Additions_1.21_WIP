package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class GuardianFinSoupItem extends Item {
   public GuardianFinSoupItem(Properties properties) {
      super(properties.stacksTo(1).food(new FoodProperties.Builder().nutrition(13).saturationModifier(0.38F).build()));
   }
}
