package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class YamPuffsItem extends Item {
   public YamPuffsItem(Properties properties) {
      super(properties.stacksTo(32).food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.4F).build()));
   }
}
