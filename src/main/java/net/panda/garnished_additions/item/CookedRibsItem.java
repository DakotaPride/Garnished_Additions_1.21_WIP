package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.panda.garnished_additions.item.template.BoneLeftoversItem;

public class CookedRibsItem extends BoneLeftoversItem {
   public CookedRibsItem(Properties properties) {
      super(properties, new FoodProperties.Builder().nutrition(9).saturationModifier(0.78F));
   }
}
