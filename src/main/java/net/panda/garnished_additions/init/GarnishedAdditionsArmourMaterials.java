package net.panda.garnished_additions.init;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.panda.garnished_additions.GarnishedAdditionsForgeMain;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class GarnishedAdditionsArmourMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOUR_MATERIAL = DeferredRegister.create(Registries.ARMOR_MATERIAL, GarnishedAdditionsForgeMain.MOD_ID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> NUTIUM = register(
            "nutium",
            Util.make(new EnumMap<>(ArmorItem.Type.class), protection -> {
                protection.put(ArmorItem.Type.BOOTS, 4);
                protection.put(ArmorItem.Type.LEGGINGS, 7);
                protection.put(ArmorItem.Type.CHESTPLATE, 9);
                protection.put(ArmorItem.Type.HELMET, 4);
                protection.put(ArmorItem.Type.BODY, 9);
            }),
            20,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            4.0F,
            0.2F,
            () -> Ingredient.of(GarnishedAdditionsItemsInit.NUTIUM_INGOT.get())
    );

    public static void register(IEventBus bus) {
        ARMOUR_MATERIAL.register(bus);
    }

    private static DeferredHolder<ArmorMaterial, ArmorMaterial> register(
            String string, EnumMap<ArmorItem.Type, Integer> enumMap, int i, Holder<SoundEvent> holder, float f, float g, Supplier<Ingredient> supplier
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(GarnishedAdditionsForgeMain.asResource(string)));
        return register(string, enumMap, i, holder, f, g, supplier, list);
    }

    private static DeferredHolder<ArmorMaterial, ArmorMaterial> register(
            String string,
            EnumMap<ArmorItem.Type, Integer> enumMap,
            int i,
            Holder<SoundEvent> holder,
            float f,
            float g,
            Supplier<Ingredient> supplier,
            List<ArmorMaterial.Layer> list
    ) {
        EnumMap<ArmorItem.Type, Integer> enumMap2 = new EnumMap<>(ArmorItem.Type.class);

        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap2.put(type, enumMap.get(type));
        }

        return ARMOUR_MATERIAL.register(string, () -> new ArmorMaterial(enumMap2, i, holder, supplier, list, f, g));
//        return Registry.registerForHolder(
//                BuiltInRegistries.ARMOR_MATERIAL, HibernalHerbsMod.asResource(string), new ArmorMaterial(enumMap2, i, holder, supplier, list, f, g)
//        );
    }
}
