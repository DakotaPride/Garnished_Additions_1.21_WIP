package net.panda.garnished_additions.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.panda.garnished_additions.GarnishedAdditionsForgeMain;
import net.panda.garnished_additions.feature.HazardousHyphaeFeature;
import net.panda.garnished_additions.feature.LethalLianaFeature;

public class GarnishedAdditionsFeatures {
    private static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.FEATURE, GarnishedAdditionsForgeMain.MOD_ID);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHEREAL_TREE_CONFIGURED = loadConfiguredKey("ethereal_tree");
    public static final ResourceKey<PlacedFeature> ETHEREAL_TREE_PLACED = loadPlacedKey("ethereal_tree");

    public static final DeferredHolder<Feature<?>, HazardousHyphaeFeature> HAZARDOUS_HYPHAE =
            REGISTER.register("hazardous_hyphae", () -> new HazardousHyphaeFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, LethalLianaFeature> LETHAL_LIANA =
            REGISTER.register("lethal_liana", () -> new LethalLianaFeature(NoneFeatureConfiguration.CODEC));

    public static ResourceKey<ConfiguredFeature<?, ?>> loadConfiguredKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, GarnishedAdditionsForgeMain.asResource(name));
    }

    public static ResourceKey<PlacedFeature> loadPlacedKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, GarnishedAdditionsForgeMain.asResource(name));
    }

    public static void register(IEventBus bus) {
        REGISTER.register(bus);
    }
}
