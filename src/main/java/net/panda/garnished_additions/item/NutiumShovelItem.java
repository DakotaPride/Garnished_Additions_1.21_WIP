package net.panda.garnished_additions.item;

import net.minecraft.world.item.ShovelItem;
import net.panda.garnished_additions.init.GarnishedAdditionsTiers;

public class NutiumShovelItem extends ShovelItem {
   public NutiumShovelItem(Properties properties) {
      super(GarnishedAdditionsTiers.NUTIUM, properties.fireResistant());
   }
}
