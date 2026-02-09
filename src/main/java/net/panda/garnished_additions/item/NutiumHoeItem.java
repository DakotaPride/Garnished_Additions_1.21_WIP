package net.panda.garnished_additions.item;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import net.panda.garnished_additions.init.GarnishedAdditionsTiers;

public class NutiumHoeItem extends HoeItem {
   public NutiumHoeItem(Properties properties) {
      super(GarnishedAdditionsTiers.NUTIUM, properties.fireResistant().rarity(Rarity.UNCOMMON));
   }
}
