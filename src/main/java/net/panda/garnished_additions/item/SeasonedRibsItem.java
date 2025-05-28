package net.panda.garnished_additions.item;

import net.minecraft.world.food.FoodProperties;
import net.panda.garnished_additions.item.template.BoneLeftoversItem;

public class SeasonedRibsItem extends BoneLeftoversItem {
   public SeasonedRibsItem(Properties properties) {
      super(properties, new FoodProperties.Builder().nutrition(5).saturationModifier(0.4F));
   }
}
