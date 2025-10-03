package net.nolli.arcanummod.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;
import net.nolli.arcanummod.item.ModFoodComponents;

public class SeaCrystalBeerItem extends Item {

    public SeaCrystalBeerItem(Settings settings) {
        super(settings.food(ModFoodComponents.SEA_CRYSTAL_BEER));
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
}
