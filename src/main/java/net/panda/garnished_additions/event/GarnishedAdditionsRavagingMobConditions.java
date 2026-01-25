package net.panda.garnished_additions.event;

import net.dakotapride.garnished.event.hatchet.MobConditions;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.panda.garnished_additions.GarnishedAdditionsNeoForgeMain;
import net.panda.garnished_additions.init.GarnishedAdditionsItemsInit;

@EventBusSubscriber(modid = GarnishedAdditionsNeoForgeMain.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class GarnishedAdditionsRavagingMobConditions extends MobConditions {

    @SubscribeEvent
    private static void addDropsUponDeath(LivingDeathEvent event) {
        LivingEntity entity = event.getEntity();
        DamageSource source = event.getSource();

        if (source.getEntity() != null && source.getEntity() instanceof LivingEntity attacker && MobConditions.accept(attacker)) {
            applyConditions(entity, attacker);
        }

    }

    public static void applyConditions(LivingEntity entity, LivingEntity attacker) {
        // Salvaging Drop Conditions
        createBasicSalvagingDropConditions(entity, EntityType.COW, attacker, GarnishedAdditionsItemsInit.RIBS.get(), 3, 100.0F);
        createBasicSalvagingDropConditions(entity, EntityType.SQUID, attacker, GarnishedAdditionsItemsInit.RAW_SQUID.get(), 2, 100.0F);
        createBasicSalvagingDropConditions(entity, EntityType.GLOW_SQUID, attacker, GarnishedAdditionsItemsInit.RAW_GLOW_SQUID.get(), 2, 100.0F);
        createBasicSalvagingDropConditions(entity, EntityType.STRIDER, attacker, GarnishedAdditionsItemsInit.RAW_STRIDER.get(), 3, 100.0F);

        // Ravaging Drop Conditions
        createBasicRavagingDropConditions(entity, EntityType.HOGLIN, attacker, GarnishedAdditionsItemsInit.RAW_HOGLIN.get(), 3, 100.0F);
        createBasicRavagingDropConditions(entity, EntityType.PIGLIN, attacker, GarnishedAdditionsItemsInit.RAW_PIGLIN.get(), 3, 100.0F);
        createBasicRavagingDropConditions(entity, EntityType.PIGLIN_BRUTE, attacker, GarnishedAdditionsItemsInit.RAW_PIGLIN.get(), 3, 100.0F);
        if (fitWithinBounds(50))
            createBasicRavagingDropConditions(entity, EntityType.ELDER_GUARDIAN, attacker, GarnishedAdditionsItemsInit.RAW_ELDER_GUARDIAN.get(), 2, 100.0F);
        else createBasicRavagingDropConditions(entity, EntityType.ELDER_GUARDIAN, attacker, GarnishedAdditionsItemsInit.ELDER_GUARDIAN_FIN.get(), 1, 100.0F);

        if (fitWithinBounds(50))
            createBasicRavagingDropConditions(entity, EntityType.GUARDIAN, attacker, GarnishedAdditionsItemsInit.RAW_GUARDIAN.get(), 2, 100.0F);
        else createBasicRavagingDropConditions(entity, EntityType.GUARDIAN, attacker, GarnishedAdditionsItemsInit.GUARDIAN_FIN.get(), 1, 100.0F);
    }
}
