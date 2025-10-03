package net.nolli.arcanummod.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CloverOfFortune extends Item {
    public CloverOfFortune(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, net.minecraft.entity.Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            if (player.getMainHandStack() == stack || player.getOffHandStack() == stack) {
                StatusEffectInstance luck = new StatusEffectInstance(
                        StatusEffects.LUCK, 210, 0, true, false);
                player.addStatusEffect(luck);
            }
        }
    }
}
