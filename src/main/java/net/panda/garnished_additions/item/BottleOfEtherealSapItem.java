package net.panda.garnished_additions.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.panda.garnished_additions.item.template.GlassBottleDrinkItem;

public class BottleOfEtherealSapItem extends GlassBottleDrinkItem {
   public BottleOfEtherealSapItem(Properties properties) {
      super(properties.stacksTo(16), new FoodProperties.Builder().nutrition(4).saturationModifier(0.5F));
   }
}
