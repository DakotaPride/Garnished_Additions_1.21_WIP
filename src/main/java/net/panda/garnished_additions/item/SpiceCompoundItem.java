package net.panda.garnished_additions.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class SpiceCompoundItem extends Item {
   public SpiceCompoundItem(Properties properties) {
      super(properties.fireResistant());
   }
}
