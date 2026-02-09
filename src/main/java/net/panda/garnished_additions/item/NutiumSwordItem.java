package net.panda.garnished_additions.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.panda.garnished_additions.init.GarnishedAdditionsTiers;

public class NutiumSwordItem extends SwordItem {
   public NutiumSwordItem(Properties properties) {
      super(GarnishedAdditionsTiers.NUTIUM, properties.fireResistant().rarity(Rarity.UNCOMMON));
   }
}
