package net.panda.garnished_additions;

import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.panda.garnished_additions.init.GarnishedAdditionsItemsInit;

@EventBusSubscriber
public class GarnishedAdditionsEvents {
   @SubscribeEvent
   public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
      ItemStack itemstack = event.getItemStack();
      if (itemstack.getItem() == GarnishedAdditionsItemsInit.BIOFUEL.get()) {
         event.setBurnTime(1800);
      } else if (itemstack.getItem() == GarnishedAdditionsItemsInit.NUT_POWDER.get()) {
         event.setBurnTime(1200);
      } else if (itemstack.getItem() == GarnishedAdditionsItemsInit.STARDUST.get()) {
         event.setBurnTime(3000);
      } else if (itemstack.getItem() == GarnishedAdditionsItemsInit.STELLAR_HUSK.get()) {
         event.setBurnTime(3000);
      } else if (itemstack.getItem() == GarnishedAdditionsItemsInit.STELLAR_CORE.get()) {
         event.setBurnTime(3000);
      } else if (itemstack.getItem() == GarnishedAdditionsItemsInit.IRONNUT.get()) {
         event.setBurnTime(3600);
      } else if (itemstack.getItem() == GarnishedAdditionsItemsInit.IRONNUT_POWDER.get()) {
         event.setBurnTime(2400);
      } else if (itemstack.getItem() == GarnishedAdditionsItemsInit.ETHEREAL_ESSENCE.get()) {
         event.setBurnTime(3000);
      } else if (itemstack.getItem() == GarnishedAdditionsItemsInit.ULTRADENSE_FUEL.get()) {
         event.setBurnTime(2000);
      }

   }
}
