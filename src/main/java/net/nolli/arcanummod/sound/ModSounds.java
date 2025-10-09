package net.nolli.arcanummod.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.nolli.arcanummod.ArcanumMod;

public class ModSounds {

    public static final SoundEvent NETHERITE_ALTAR_BREAK = registerSoundEvent("netherite_altar_break");
    public static final SoundEvent NETHERITE_ALTAR_STEP = registerSoundEvent("netherite_altar_step");
    public static final SoundEvent NETHERITE_ALTAR_PLACE = registerSoundEvent("netherite_altar_place");
    public static final SoundEvent NETHERITE_ALTAR_HIT = registerSoundEvent("netherite_altar_hit");
    public static final SoundEvent NETHERITE_ALTAR_FALL = registerSoundEvent("netherite_altar_fall");

    public static final BlockSoundGroup NETHERITE_ALTAR_SOUNDS = new BlockSoundGroup(10f, 1f,
            NETHERITE_ALTAR_BREAK, NETHERITE_ALTAR_STEP,NETHERITE_ALTAR_PLACE,NETHERITE_ALTAR_HIT, NETHERITE_ALTAR_FALL);

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(ArcanumMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        ArcanumMod.LOGGER.info("Registering Mod Sounds for " + ArcanumMod.MOD_ID);
    }

}
