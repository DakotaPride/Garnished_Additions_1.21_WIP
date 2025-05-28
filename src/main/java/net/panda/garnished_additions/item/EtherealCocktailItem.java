package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Item.Properties;
import net.panda.garnished_additions.item.template.GlassBottleDrinkItem;

public class EtherealCocktailItem extends GlassBottleDrinkItem {
   public EtherealCocktailItem(Properties properties) {
      super(properties.stacksTo(32), new FoodProperties.Builder().nutrition(8).saturationModifier(0.45F));
   }
}
