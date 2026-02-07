package net.panda.garnished_additions.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.panda.garnished_additions.GarnishedAdditionsNeoForgeMain;
import net.panda.garnished_additions.init.GarnishedAdditionsArmourMaterials;
import org.jetbrains.annotations.Nullable;

public abstract class NutiumArmourItem extends ArmorItem {
   ResourceLocation layer1 = GarnishedAdditionsNeoForgeMain.asResource("models/armor/nutium_layer_1.png");
   ResourceLocation layer2 = GarnishedAdditionsNeoForgeMain.asResource("models/armor/nutium_layer_2.png");

   public NutiumArmourItem(Type type, Properties properties) {
      super(GarnishedAdditionsArmourMaterials.NUTIUM, type, properties.fireResistant().stacksTo(1));
   }

   @Override
   public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
      return true;
   }

   public static class Boots extends NutiumArmourItem {
      public Boots(Properties properties) {
         super(Type.BOOTS, properties);
      }

//      @Override
//      public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
//         return super.layer1;
//      }

   }

   public static class Leggings extends NutiumArmourItem {
      public Leggings(Properties properties) {
         super(Type.LEGGINGS, properties);
      }

//      @Override
//      public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
//         return super.layer2;
//      }

   }

   public static class Chestplate extends NutiumArmourItem {
      public Chestplate(Properties properties) {
         super(Type.CHESTPLATE, properties);
      }

//      @Override
//      public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
//         return super.layer1;
//      }
   }

   public static class Helmet extends NutiumArmourItem {
      public Helmet(Properties properties) {
         super(Type.HELMET, properties);
      }

//      @Override
//      public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
//         return super.layer2;
//      }
   }
}
