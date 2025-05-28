package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Item.Properties;

public class ChocolateNutMixItem extends Item {
   public ChocolateNutMixItem(Properties properties) {
      super(properties.stacksTo(16).food(new FoodProperties.Builder().nutrition(14).saturationModifier(0.4F).build()));
   }
}
