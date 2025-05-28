package net.panda.garnished_additions.item.template;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class BowlFoodItem extends Item {
    FoodProperties.Builder foodProperties;
    public BowlFoodItem(Properties properties, FoodProperties.Builder foodProperties) {
        super(properties.food(foodProperties.build()));
        this.foodProperties = foodProperties.usingConvertsTo(Items.BOWL);
    }

}
