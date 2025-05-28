package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class GuardianGoulashItem extends Item {
   public GuardianGoulashItem(Properties properties) {
      super(properties.stacksTo(32).food(new FoodProperties.Builder().nutrition(11).saturationModifier(0.41F).build()));
   }
}
