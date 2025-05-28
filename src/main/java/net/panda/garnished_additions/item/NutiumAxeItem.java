package net.panda.garnished_additions.item;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tiers;
import net.panda.garnished_additions.init.GarnishedAdditionsTiers;

public class NutiumAxeItem extends AxeItem {
   public NutiumAxeItem(Properties properties) {
      super(Tiers.NETHERITE, properties.fireResistant());
   }
}
