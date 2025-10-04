package net.nolli.arcanummod.event;

import net.nolli.arcanummod.ArcanumMod;
import net.nolli.arcanummod.effect.SoulDrainEffect;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;

public class SoulDrainKillHandler {

    /**
     * Rejestruje wszystkie eventy związane z Soul Drain:
     * - po zabiciu encji przez gracza
     * - tick serwera do czyszczenia efektów
     */
    public static void register() {
        ArcanumMod.LOGGER.info("Registering SoulDrain kill handler");

        // Event: po zabiciu encji przez gracza
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, killedEntity) -> {
            if (entity instanceof PlayerEntity player && killedEntity instanceof LivingEntity victim) {
                SoulDrainEffect.onEntityKilled(player, victim);
            }
        });

        // Event: tick serwera, sprzątanie graczy którzy stracili efekt
        ServerTickEvents.END_SERVER_TICK.register((MinecraftServer server) -> {
            SoulDrainEffect.cleanupAllOnServer(server);
        });
    }
}
