package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.panda.garnished_additions.item.template.GlassBottleDrinkItem;

public class BottleOfEtherealSyrupItem extends GlassBottleDrinkItem {
   public BottleOfEtherealSyrupItem(Properties properties) {
      super(properties.stacksTo(16), new FoodProperties.Builder().nutrition(5).saturationModifier(0.4F));
   }
}
