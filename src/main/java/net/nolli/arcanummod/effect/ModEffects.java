package net.nolli.arcanummod.effect;

import net.nolli.arcanummod.ArcanumMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> SOUL_DRAIN = registerStatusEffect(
            "soul_drain",
            new SoulDrainEffect(StatusEffectCategory.NEUTRAL, 0x81FFFB)
    );

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect effect) {
        return Registry.registerReference(
                Registries.STATUS_EFFECT,
                Identifier.of(ArcanumMod.MOD_ID, name),
                effect
        );
    }

    public static void registerEffects() {
        ArcanumMod.LOGGER.info("Registering mod effects for " + ArcanumMod.MOD_ID);
        ArcanumMod.LOGGER.info("Registered effect: " + ArcanumMod.MOD_ID + ":soul_drain");
    }
}
