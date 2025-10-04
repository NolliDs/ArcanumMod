package net.nolli.arcanummod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.particle.ParticleTypes;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SoulDrainEffect extends StatusEffect {

    private static final Map<UUID, Integer> killCounts = new ConcurrentHashMap<>();
    private static final Map<UUID, Double> addedHearts = new ConcurrentHashMap<>();
    private static final Map<UUID, Double> originalBase = new ConcurrentHashMap<>();

    public SoulDrainEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public static void onEntityKilled(PlayerEntity killer, LivingEntity victim) {
        if (killer == null || victim == null) return;

        // debug: kto zabił co
        System.out.println("[SoulDrain] onEntityKilled called. Killer=" + killer.getName().getString()
                + " Victim=" + victim.getType().getName().getString());

        if (!hasSoulDrain(killer)) {
            System.out.println("[SoulDrain] killer does NOT have soul_drain effect.");
            return;
        }

        if (!(victim instanceof EnderDragonEntity || victim instanceof WardenEntity || victim instanceof WitherEntity)) {
            System.out.println("[SoulDrain] victim is not in boss list.");
            return;
        }

        UUID id = killer.getUuid();
        int kills = killCounts.getOrDefault(id, 0) + 1;
        killCounts.put(id, kills);

        System.out.println("[SoulDrain] " + killer.getName().getString() + " boss kills with effect: " + kills);

        if (kills % 3 == 0) {
            // wykonuj tylko po stronie serwera
            if (killer.getWorld().isClient()) {
                System.out.println("[SoulDrain] Detected client world — skipping addHealth.");
                return;
            }

            System.out.println("[SoulDrain] Awarding +0.5 heart to " + killer.getName().getString());
            addHealth(killer, 1.0);
        }
    }

    private static boolean hasSoulDrain(PlayerEntity player) {
        return player.hasStatusEffect(ModEffects.SOUL_DRAIN);
    }


    private static void addHealth(PlayerEntity player, double amount) {
        EntityAttributeInstance attr = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (attr == null) return;

        UUID id = player.getUuid();

        // zapamiętaj oryginalne base tylko raz
        originalBase.computeIfAbsent(id, k -> attr.getBaseValue());

        double currentAdded = addedHearts.getOrDefault(id, 0.0);
        double newAdded = currentAdded + amount;
        addedHearts.put(id, newAdded);

        double base = originalBase.get(id);
        attr.setBaseValue(base + newAdded);

        // skróć HP gracza jeśli jest powyżej nowego maxa
        double newMax = attr.getValue();
        if (player.getHealth() > newMax) player.setHealth((float) newMax);

        // mała wizualna informacja w świecie
        player.getWorld().addParticle(ParticleTypes.SOUL, player.getX(), player.getY() + 1.0, player.getZ(), 0.0, 0.1, 0.0);
        System.out.println("[SoulDrain] New max health for " + player.getName().getString() + " = " + attr.getValue());
    }

    public static void cleanupIfEffectExpired(PlayerEntity player) {
        if (player == null) return;
        UUID id = player.getUuid();
        if (!originalBase.containsKey(id)) return;

        if (hasSoulDrain(player)) return; // wciąż ma efekt — nic nie rób

        // przywróć oryginalne wartości
        EntityAttributeInstance attr = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        Double base = originalBase.remove(id);
        addedHearts.remove(id);
        killCounts.remove(id);

        if (attr != null && base != null) {
            attr.setBaseValue(base);
            if (player.getHealth() > attr.getValue()) player.setHealth((float) attr.getValue());
            System.out.println("[SoulDrain] Restored base max health for " + player.getName().getString() + " -> " + base);
        }
    }

    public static void cleanupAllOnServer(MinecraftServer server) {
        if (server == null) return;
        for (ServerPlayerEntity sp : server.getPlayerManager().getPlayerList()) {
            cleanupIfEffectExpired(sp);
        }
    }
}
