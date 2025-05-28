package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class CookedElderGuardianItem extends Item {
   public CookedElderGuardianItem(Properties properties) {
      super(properties.food(new FoodProperties.Builder().nutrition(9).saturationModifier(0.56F).build()));
   }
}
