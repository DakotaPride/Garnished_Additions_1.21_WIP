package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.panda.garnished_additions.item.template.BoneLeftoversItem;

public class RibsItem extends BoneLeftoversItem {
   public RibsItem(Properties properties) {
      super(properties, new FoodProperties.Builder().nutrition(3).saturationModifier(0.33F));
   }
}
