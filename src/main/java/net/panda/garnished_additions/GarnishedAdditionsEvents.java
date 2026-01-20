package net.panda.garnished_additions;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.panda.garnished_additions.init.GarnishedAdditionsItemsInit;

@EventBusSubscriber
public class GarnishedAdditionsEvents {
   /*
   Biofuel superheats for 90s, heats for 180s
   Nut Powder Heats for 60s
   Stardust Superheats for 150s, heats for 240s
   Stellar Husk Superheats for 150s, heats for 240s
   Stellar Core Superheats for 150s, heats for 240s
   Ironnut Heats for 180s
   Ironnut Powder Heats for 120s
   Ethereal Essence Heats for 150s
   Ultra-Dense Fuel Superheats for 120s, heats for 210s
   */

   private static void set(FurnaceFuelBurnTimeEvent event, Item item, int itemCount) {
      ItemStack itemStack = event.getItemStack();
      if (itemStack.getItem() == item)
         event.setBurnTime(itemCount*200);
   }

   @SubscribeEvent
   public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
      set(event, GarnishedAdditionsItemsInit.BIOFUEL.get(), 16);
      set(event, GarnishedAdditionsItemsInit.NUT_POWDER.get(), 8);
      set(event, GarnishedAdditionsItemsInit.STARDUST.get(), 16);
      set(event, GarnishedAdditionsItemsInit.STELLAR_HUSK.get(), 32);
      set(event, GarnishedAdditionsItemsInit.STELLAR_CORE.get(), 64);
      set(event, GarnishedAdditionsItemsInit.IRONNUT.get(), 16);
      set(event, GarnishedAdditionsItemsInit.IRONNUT_POWDER.get(), 12);
      set(event, GarnishedAdditionsItemsInit.ETHEREAL_ESSENCE.get(), 16);
      set(event, GarnishedAdditionsItemsInit.ULTRADENSE_FUEL.get(), 32);
   }
}
