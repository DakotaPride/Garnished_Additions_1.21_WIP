package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.panda.garnished_additions.item.template.BoneLeftoversItem;

public class SeasonedCookedRibsItem extends BoneLeftoversItem {
   public SeasonedCookedRibsItem(Properties properties) {
      super(properties, new FoodProperties.Builder().nutrition(11).saturationModifier(0.69F));
   }
}
