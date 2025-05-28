package net.panda.garnished_additions.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class SpicePowderItem extends Item {
   public SpicePowderItem(Properties properties) {
      super(properties.fireResistant());
   }
}
