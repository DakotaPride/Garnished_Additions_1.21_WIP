package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class RawGuardianItem extends Item {
   public RawGuardianItem(Properties properties) {
      super(properties.food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.25F).build()));
   }
}
