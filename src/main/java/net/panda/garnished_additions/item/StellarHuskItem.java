package net.panda.garnished_additions.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class StellarHuskItem extends Item {
   public StellarHuskItem(Properties properties) {
      super(properties.fireResistant().rarity(Rarity.UNCOMMON));
   }
}
