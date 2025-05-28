package net.panda.garnished_additions.item;

import net.minecraft.world.item.AxeItem;
import net.panda.garnished_additions.init.GarnishedAdditionsTiers;

public class NutiumAxeItem extends AxeItem {
   public NutiumAxeItem(Properties properties) {
      super(GarnishedAdditionsTiers.NUTIUM, properties.fireResistant());
   }
}
