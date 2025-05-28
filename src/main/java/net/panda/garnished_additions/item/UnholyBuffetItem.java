package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class UnholyBuffetItem extends Item {
   public UnholyBuffetItem(Properties properties) {
      super(properties.stacksTo(1).rarity(Rarity.UNCOMMON).food(new FoodProperties.Builder().nutrition(24).saturationModifier(0.5F).build()));
   }
}
