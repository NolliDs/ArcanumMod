package net.nolli.arcanummod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nolli.arcanummod.ArcanumMod;
import net.minecraft.registry.Registry;
import net.nolli.arcanummod.item.custom.*;

import java.util.List;

public class ModItems {

    //Items
    public static final Item SEA_CRYSTAL = registerItem("sea_crystal", new Item(new Item.Settings()));
    public static final Item RAW_SEA_CRYSTAL = registerItem("raw_sea_crystal", new Item(new Item.Settings()));
    public static final Item CLOVER = registerItem("clover", new Item(new Item.Settings()));

    //Magic Items
    public static final Item GOLD_CLOVER = registerItem("gold_clover", new GoldCloverItem(new Item.Settings().maxDamage(5)));
    public static final Item NETHERITE_CLOVER = registerItem("netherite_clover", new NetheriteCloverItem(new Item.Settings().maxDamage(5)));
    public static final Item CLOVER_OF_FORTUNE = registerItem("clover_of_fortune", new CloverOfFortune(new Item.Settings()));

    //Tools
    public static final Item SEA_CRYSTAL_SWORD = registerItem("sea_crystal_sword",
            new SwordItem(ModToolMaterials.SEA_CRYSTAL, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SEA_CRYSTAL, 3, -2.4f))));

    public static final Item SEA_CRYSTAL_PICKAXE = registerItem("sea_crystal_pickaxe",
            new PickaxeItem(ModToolMaterials.SEA_CRYSTAL, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.SEA_CRYSTAL, 1, -2.8f))));

    public static final Item SEA_CRYSTAL_SHOVEL = registerItem("sea_crystal_shovel",
            new ShovelItem(ModToolMaterials.SEA_CRYSTAL, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.SEA_CRYSTAL, 1.5f, -3.0f))));

    public static final Item SEA_CRYSTAL_AXE = registerItem("sea_crystal_axe",
            new AxeItem(ModToolMaterials.SEA_CRYSTAL, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.SEA_CRYSTAL, 6, -3.1f))));

    public static final Item SEA_CRYSTAL_HOE = registerItem("sea_crystal_hoe",
            new HoeItem(ModToolMaterials.SEA_CRYSTAL, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.SEA_CRYSTAL, 0, -3f))));

    //Armor

    public static final Item SEA_CRYSTAL_HELMET = registerItem("sea_crystal_helmet",
            new ModArmorItem(ModArmorMaterials.SEA_CRYSTAL_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(20))));
    public static final Item SEA_CRYSTAL_CHESTPLATE = registerItem("sea_crystal_chestplate",
            new ModArmorItem(ModArmorMaterials.SEA_CRYSTAL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(20))));
    public static final Item SEA_CRYSTAL_LEGGINGS = registerItem("sea_crystal_leggings",
            new ModArmorItem(ModArmorMaterials.SEA_CRYSTAL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(20))));
    public static final Item SEA_CRYSTAL_BOOTS = registerItem("sea_crystal_boots",
            new ModArmorItem(ModArmorMaterials.SEA_CRYSTAL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(20))));

    //Food
    public static final Item SEA_CRYSTAL_BEER = registerItem("sea_crystal_beer", new SeaCrystalBeerItem(new Item.Settings()
            .food(ModFoodComponents.SEA_CRYSTAL_BEER).maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.arcanummod.seacrystalbeer"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

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
