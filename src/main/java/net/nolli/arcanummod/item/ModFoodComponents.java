package net.nolli.arcanummod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.SoundEvents;

public class ModFoodComponents {
    public static final FoodComponent SEA_CRYSTAL_BEER = new FoodComponent.Builder()
            .nutrition(2)
            .saturationModifier(0.8F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1200), 0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 1200), 0.15f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3000, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 3000, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 1), 1.0F)
            .alwaysEdible()
            .build();
}


