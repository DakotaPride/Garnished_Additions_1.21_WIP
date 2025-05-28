package net.panda.garnished_additions.item.template;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;

public class GlassBottleDrinkItem extends Item {
    FoodProperties.Builder foodProperties;
    public GlassBottleDrinkItem(Properties properties, FoodProperties.Builder foodProperties) {
        super(properties.food(foodProperties.build()));
        this.foodProperties = foodProperties.usingConvertsTo(Items.GLASS_BOTTLE);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

}