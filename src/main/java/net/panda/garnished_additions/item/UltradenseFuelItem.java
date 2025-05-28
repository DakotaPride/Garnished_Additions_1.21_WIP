package net.panda.garnished_additions.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class UltradenseFuelItem extends Item {
   public UltradenseFuelItem(Properties properties) {
      super(properties.fireResistant().rarity(Rarity.UNCOMMON));
   }
}
