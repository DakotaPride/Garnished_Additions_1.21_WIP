package net.panda.garnished_additions.item;

import net.minecraft.world.item.PickaxeItem;
import net.panda.garnished_additions.init.GarnishedAdditionsTiers;

public class NutiumPickaxeItem extends PickaxeItem {
   public NutiumPickaxeItem(Properties properties) {
      super(GarnishedAdditionsTiers.NUTIUM, properties.fireResistant());
   }
}
