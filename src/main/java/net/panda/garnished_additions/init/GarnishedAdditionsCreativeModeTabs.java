package net.panda.garnished_additions.init;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.panda.garnished_additions.GarnishedAdditionsForgeMain;

//@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class GarnishedAdditionsCreativeModeTabs {
   private static final DeferredRegister<CreativeModeTab> REGISTER =
           DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GarnishedAdditionsForgeMain.MOD_ID);

   public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GARNISHED_ADDITIONS = REGISTER.register("garnished_additions",
           () -> CreativeModeTab.builder()
                   .title(Component.translatable("itemGroup.garnished_additions.base"))
                   //.withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                   .icon(GarnishedAdditionsItemsInit.MELTED_CINDER_FLOUR_NUT_MIX::asStack)
                   .displayItems(new RegistrateDisplayItemsGenerator())
                   .build());

   public static void register(IEventBus eventBus) {
      REGISTER.register(eventBus);
   }

   private static class RegistrateDisplayItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {
      @Override
      public void accept(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
         output.accept(AllItems.CHROMATIC_COMPOUND.get());
         output.accept(AllItems.REFINED_RADIANCE.get());
         output.accept(AllItems.SHADOW_STEEL.get());
         output.accept(AllBlocks.REFINED_RADIANCE_CASING.get());
         output.accept(AllBlocks.SHADOW_STEEL_CASING.get());
         output.accept(GarnishedAdditionsItemsInit.NUTIUM_INGOT.get());
         output.accept(GarnishedAdditionsBlocksInit.NUTIUM_BLOCK.get());
         output.accept(GarnishedAdditionsItemsInit.NUTIUM_HELMET.get());
         output.accept(GarnishedAdditionsItemsInit.NUTIUM_CHESTPLATE.get());
         output.accept(GarnishedAdditionsItemsInit.NUTIUM_LEGGINGS.get());
         output.accept(GarnishedAdditionsItemsInit.NUTIUM_BOOTS.get());
         output.accept(GarnishedAdditionsItemsInit.NUTIUM_SWORD.get());
         output.accept(GarnishedAdditionsItemsInit.NUTIUM_AXE.get());
         output.accept(GarnishedAdditionsItemsInit.NUTIUM_PICKAXE.get());
         output.accept(GarnishedAdditionsItemsInit.NUTIUM_SHOVEL.get());
         output.accept(GarnishedAdditionsItemsInit.NUTIUM_HOE.get());
         output.accept(GarnishedAdditionsItemsInit.UNGARNISHED_NUT_MIX.get());
         output.accept(GarnishedAdditionsItemsInit.GARNISHED_NUT_MIX.get());
         output.accept(GarnishedAdditionsItemsInit.SWEETENED_NUT_MIX.get());
         output.accept(GarnishedAdditionsItemsInit.CHOCOLATE_NUT_MIX.get());
         output.accept(GarnishedAdditionsItemsInit.HONEYED_NUT_MIX.get());
         output.accept(GarnishedAdditionsItemsInit.CINDER_FLOUR_NUT_MIX.get());
         output.accept(GarnishedAdditionsItemsInit.MELTED_CINDER_FLOUR_NUT_MIX.get());
         output.accept(GarnishedAdditionsItemsInit.SALTED_NUT_MIX.get());
         output.accept(GarnishedAdditionsItemsInit.ROASTED_NUT_MIX.get());
         output.accept(GarnishedAdditionsItemsInit.HONEY_ROASTED_NUT_MIX.get());
         output.accept(GarnishedAdditionsItemsInit.SALTED_CASHEW.get());
         output.accept(GarnishedAdditionsItemsInit.SALTED_WALNUT.get());
         output.accept(GarnishedAdditionsItemsInit.SALTED_ALMOND.get());
         output.accept(GarnishedAdditionsItemsInit.SALTED_PECAN.get());
         output.accept(GarnishedAdditionsItemsInit.SALTED_PISTACHIO.get());
         output.accept(GarnishedAdditionsItemsInit.SALTED_MACADAMIA.get());
         output.accept(GarnishedAdditionsItemsInit.SALTED_PEANUT.get());
         output.accept(GarnishedAdditionsItemsInit.SALTED_HAZELNUT.get());
         output.accept(GarnishedAdditionsItemsInit.SALTED_CHESTNUT.get());
         output.accept(GarnishedAdditionsItemsInit.ROASTED_CASHEW.get());
         output.accept(GarnishedAdditionsItemsInit.ROASTED_WALNUT.get());
         output.accept(GarnishedAdditionsItemsInit.ROASTED_ALMOND.get());
         output.accept(GarnishedAdditionsItemsInit.ROASTED_PECAN.get());
         output.accept(GarnishedAdditionsItemsInit.ROASTED_PISTACHIO.get());
         output.accept(GarnishedAdditionsItemsInit.ROASTED_MACADAMIA.get());
         output.accept(GarnishedAdditionsItemsInit.ROASTED_PEANUT.get());
         output.accept(GarnishedAdditionsItemsInit.ROASTED_HAZELNUT.get());
         output.accept(GarnishedAdditionsItemsInit.ROASTED_CHESTNUT.get());
         output.accept(GarnishedAdditionsItemsInit.HONEY_ROASTED_CASHEW.get());
         output.accept(GarnishedAdditionsItemsInit.HONEY_ROASTED_WALNUT.get());
         output.accept(GarnishedAdditionsItemsInit.HONEY_ROASTED_ALMOND.get());
         output.accept(GarnishedAdditionsItemsInit.HONEY_ROASTED_PECAN.get());
         output.accept(GarnishedAdditionsItemsInit.HONEY_ROASTED_PISTACHIO.get());
         output.accept(GarnishedAdditionsItemsInit.HONEY_ROASTED_MACADAMIA.get());
         output.accept(GarnishedAdditionsItemsInit.HONEY_ROASTED_PEANUT.get());
         output.accept(GarnishedAdditionsItemsInit.HONEY_ROASTED_CHESTNUT.get());
         output.accept(GarnishedAdditionsItemsInit.HONEY_ROASTED_HAZELNUT.get());
         output.accept(GarnishedAdditionsItemsInit.FRITTELLE.get());
         output.accept(GarnishedAdditionsItemsInit.DUMPLINGS.get());
         output.accept(GarnishedAdditionsItemsInit.CHOCOLATE_NUT_BITES.get());
         output.accept(GarnishedAdditionsItemsInit.PEMMICAN.get());
         output.accept(GarnishedAdditionsItemsInit.BISCOTTI.get());
         output.accept(GarnishedAdditionsItemsInit.BAKEWELL_TART.get());
         output.accept(GarnishedAdditionsItemsInit.WALNUT_LOAF.get());
         output.accept(GarnishedAdditionsItemsInit.MALSOUKA.get());
         output.accept(GarnishedAdditionsItemsInit.MINCE_PIE.get());
         output.accept(GarnishedAdditionsItemsInit.PRALINE.get());
         output.accept(GarnishedAdditionsItemsInit.CHESTNUT_PANCAKE.get());
         output.accept(GarnishedAdditionsItemsInit.MARZIPAN.get());
         output.accept(GarnishedAdditionsItemsInit.CHESTNUT_CAKE.get());
         output.accept(GarnishedAdditionsItemsInit.CHESTNUT_CAKE_SLICE.get());
         output.accept(GarnishedAdditionsItemsInit.DERBY_PIE.get());
         output.accept(GarnishedAdditionsItemsInit.DERBY_PIE_SLICE.get());
         output.accept(GarnishedAdditionsItemsInit.POUND_CAKE.get());
         output.accept(GarnishedAdditionsItemsInit.POUND_CAKE_SLICE.get());
         output.accept(GarnishedAdditionsItemsInit.CHESTNUT_PIE.get());
         output.accept(GarnishedAdditionsItemsInit.CHESTNUT_PIE_SLICE.get());
         output.accept(GarnishedAdditionsItemsInit.CASHEW_PIE.get());
         output.accept(GarnishedAdditionsItemsInit.CASHEW_PIE_SLICE.get());
         output.accept(GarnishedAdditionsItemsInit.WALNUT_PIE.get());
         output.accept(GarnishedAdditionsItemsInit.WALNUT_PIE_SLICE.get());
         output.accept(GarnishedAdditionsItemsInit.MACARON.get());
         output.accept(GarnishedAdditionsItemsInit.YAM_PUFFS.get());
         output.accept(GarnishedAdditionsItemsInit.TRAVELERS_STEW.get());
         output.accept(GarnishedAdditionsItemsInit.PANCAKES.get());
         output.accept(GarnishedAdditionsItemsInit.HONEY_COVERED_PANCAKES.get());
         output.accept(GarnishedAdditionsItemsInit.CHOCOLATE_COVERED_PANCAKES.get());
         output.accept(GarnishedAdditionsItemsInit.ETHEREAL_PANCAKES.get());
         output.accept(GarnishedAdditionsBlocksInit.ETHEREAL_GROWTH.get());
         output.accept(GarnishedAdditionsBlocksInit.ETHEREAL_LOG.get());
         output.accept(GarnishedAdditionsBlocksInit.ETHEREAL_WOOD.get());
         output.accept(GarnishedAdditionsBlocksInit.STRIPPED_ETHEREAL_LOG.get());
         output.accept(GarnishedAdditionsBlocksInit.STRIPPED_ETHEREAL_WOOD.get());
         output.accept(GarnishedAdditionsBlocksInit.ETHEREAL_PLANKS.get());
         output.accept(GarnishedAdditionsBlocksInit.ETHEREAL_STAIRS.get());
         output.accept(GarnishedAdditionsBlocksInit.ETHEREAL_SLAB.get());
         output.accept(GarnishedAdditionsBlocksInit.ETHEREAL_FENCE.get());
         output.accept(GarnishedAdditionsBlocksInit.ETHEREAL_FENCE_GATE.get());
         output.accept(GarnishedAdditionsBlocksInit.ETHEREAL_DOOR.get());
         output.accept(GarnishedAdditionsBlocksInit.ETHEREAL_TRAPDOOR.get());
         output.accept(GarnishedAdditionsBlocksInit.ETHEREAL_PRESSURE_PLATE.get());
         output.accept(GarnishedAdditionsBlocksInit.ETHEREAL_BUTTON.get());
         output.accept(GarnishedAdditionsBlocksInit.ETHEREAL_LEAVES.get());
         output.accept(GarnishedAdditionsBlocksInit.ROOTED_END_STONE.get());
         output.accept(GarnishedAdditionsItemsInit.ETHEREAL_ROOTS.get());
         output.accept(GarnishedAdditionsItemsInit.ETHEREAL_BERRIES.get());
         output.accept(GarnishedAdditionsItemsInit.ETHEREAL_FRUIT.get());
         output.accept(GarnishedAdditionsItemsInit.ETHEREAL_LEAF.get());
         output.accept(GarnishedAdditionsItemsInit.BOTTLE_OF_ETHEREAL_SAP.get());
         output.accept(GarnishedAdditionsItemsInit.BOTTLE_OF_ETHEREAL_SYRUP.get());
         output.accept(GarnishedAdditionsItemsInit.ETHEREAL_COCKTAIL.get());
         output.accept(GarnishedAdditionsItemsInit.ETHEREAL_SALAD.get());
         output.accept(GarnishedAdditionsBlocksInit.ETHEREAL_CAKE.get());
         output.accept(GarnishedAdditionsItemsInit.SLICE_OF_ETHEREAL_DELIGHT.get());
         output.accept(GarnishedAdditionsItemsInit.RAW_PIGLIN.get());
         output.accept(GarnishedAdditionsItemsInit.COOKED_PIGLIN.get());
         output.accept(GarnishedAdditionsItemsInit.RAW_HOGLIN.get());
         output.accept(GarnishedAdditionsItemsInit.COOKED_HOGLIN.get());
         output.accept(GarnishedAdditionsItemsInit.RAW_STRIDER.get());
         output.accept(GarnishedAdditionsItemsInit.COOKED_STRIDER.get());
         output.accept(GarnishedAdditionsItemsInit.SPICE_COMPOUND.get());
         output.accept(GarnishedAdditionsItemsInit.SPICE_POWDER.get());
         output.accept(GarnishedAdditionsItemsInit.CURSED_CALAMARI.get());
         output.accept(GarnishedAdditionsItemsInit.GHAST_BALLS.get());
         output.accept(GarnishedAdditionsItemsInit.BLAZE_NOODLES.get());
         output.accept(GarnishedAdditionsItemsInit.DANGER_NOODLES.get());
         output.accept(GarnishedAdditionsItemsInit.PIGLIN_STEW.get());
         output.accept(GarnishedAdditionsItemsInit.MAGMA_CUBE_STEW.get());
         output.accept(GarnishedAdditionsItemsInit.SLIME_STEW.get());
         output.accept(GarnishedAdditionsItemsInit.HOT_N_STICKY_STEW.get());
         //output.accept(GarnishedAdditionsBlocksInit.HAZARDOUS_HYPHAE_PLANT.get());
         //output.accept(GarnishedAdditionsBlocksInit.LETHAL_LIANA_PLANT.get());
         output.accept(GarnishedAdditionsBlocksInit.HAZARDOUS_HYPHAE.get());
         output.accept(GarnishedAdditionsBlocksInit.LETHAL_LIANA.get());
         output.accept(GarnishedAdditionsItemsInit.BLACK_PUDDING.get());
         output.accept(GarnishedAdditionsItemsInit.GUARDIAN_FIN.get());
         output.accept(GarnishedAdditionsItemsInit.ELDER_GUARDIAN_FIN.get());
         output.accept(GarnishedAdditionsItemsInit.RAW_SQUID.get());
         output.accept(GarnishedAdditionsItemsInit.COOKED_SQUID.get());
         output.accept(GarnishedAdditionsItemsInit.RAW_GLOW_SQUID.get());
         output.accept(GarnishedAdditionsItemsInit.COOKED_GLOW_SQUID.get());
         output.accept(GarnishedAdditionsItemsInit.RAW_GUARDIAN.get());
         output.accept(GarnishedAdditionsItemsInit.COOKED_GUARDIAN.get());
         output.accept(GarnishedAdditionsItemsInit.RAW_ELDER_GUARDIAN.get());
         output.accept(GarnishedAdditionsItemsInit.COOKED_ELDER_GUARDIAN.get());
         output.accept(GarnishedAdditionsItemsInit.CALAMARI.get());
         output.accept(GarnishedAdditionsItemsInit.GLOWING_CALAMARI.get());
         output.accept(GarnishedAdditionsItemsInit.SASHIMI.get());
         output.accept(GarnishedAdditionsItemsInit.GUARDIAN_GOULASH.get());
         output.accept(GarnishedAdditionsItemsInit.SURF_TURF_PLATTER.get());
         output.accept(GarnishedAdditionsItemsInit.SEAFOOD_PLATTER.get());
         output.accept(GarnishedAdditionsItemsInit.GUARDIAN_FIN_SOUP.get());
         output.accept(GarnishedAdditionsItemsInit.ELDER_GUARDIAN_FIN_SOUP.get());
         output.accept(GarnishedAdditionsItemsInit.SEAFOOD_SALAD.get());
         output.accept(GarnishedAdditionsItemsInit.UNHOLY_BUFFET.get());
         output.accept(GarnishedAdditionsItemsInit.RIBS.get());
         output.accept(GarnishedAdditionsItemsInit.COOKED_RIBS.get());
         output.accept(GarnishedAdditionsItemsInit.SEASONED_RIBS.get());
         output.accept(GarnishedAdditionsItemsInit.SEASONED_COOKED_RIBS.get());
         output.accept(GarnishedAdditionsItemsInit.IRONNUT.get());
         output.accept(GarnishedAdditionsItemsInit.IRONNUT_POWDER.get());
         output.accept(GarnishedAdditionsItemsInit.NUT_POWDER.get());
         output.accept(GarnishedAdditionsItemsInit.BIOCHAR.get());
         output.accept(GarnishedAdditionsItemsInit.ETHEREAL_ESSENCE.get());
         output.accept(GarnishedAdditionsItemsInit.STARDUST.get());
         output.accept(GarnishedAdditionsItemsInit.STELLAR_HUSK.get());
         output.accept(GarnishedAdditionsItemsInit.STELLAR_CORE.get());
         output.accept(GarnishedAdditionsBlocksInit.STARDUST_BLOCK.get());
         output.accept(GarnishedAdditionsItemsInit.ULTRADENSE_FUEL.get());
         output.accept(GarnishedAdditionsItemsInit.BIOFUEL.get());
      }
   }
}
