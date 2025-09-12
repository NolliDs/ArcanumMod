package net.nolli.arcanummod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.nolli.arcanummod.ArcanumMod;
import net.minecraft.registry.Registry;

public class ModItems {

    public static final Item SEA_CRYSTAL = registerItem("sea_crystal", new Item(new Item.Settings()));
    public static final Item RAW_SEA_CRYSTAL = registerItem("raw_sea_crystal", new Item(new Item.Settings()));

    private static Item registerItem(String name,Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ArcanumMod.MOD_ID, name), item);
    }

    public static void registerModItens(){
        ArcanumMod.LOGGER.info("Registering Mod Items for " + ArcanumMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(SEA_CRYSTAL);
            fabricItemGroupEntries.add(RAW_SEA_CRYSTAL);
        });
    }
}
