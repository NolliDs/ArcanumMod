package net.nolli.arcanummod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nolli.arcanummod.ArcanumMod;
import net.nolli.arcanummod.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup ARCANUM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ArcanumMod.MOD_ID, "arcanum_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SEA_CRYSTAL))
                    .displayName(Text.translatable("itemgroup.arcanummod.arcanum_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.RAW_SEA_CRYSTAL);
                        entries.add(ModItems.SEA_CRYSTAL);
                        entries.add(ModItems.CLOVER);

                        entries.add(ModItems.SEA_CRYSTAL_BEER);

                        entries.add(ModItems.GOLD_CLOVER);
                        entries.add(ModItems.NETHERITE_CLOVER);
                        entries.add(ModItems.CLOVER_OF_FORTUNE);

                        entries.add(ModItems.SEA_CRYSTAL_SWORD);
                        entries.add(ModItems.SEA_CRYSTAL_PICKAXE);
                        entries.add(ModItems.SEA_CRYSTAL_SHOVEL);
                        entries.add(ModItems.SEA_CRYSTAL_AXE);
                        entries.add(ModItems.SEA_CRYSTAL_HOE);

                        entries.add(ModItems.SEA_CRYSTAL_HELMET);
                        entries.add(ModItems.SEA_CRYSTAL_CHESTPLATE);
                        entries.add(ModItems.SEA_CRYSTAL_LEGGINGS);
                        entries.add(ModItems.SEA_CRYSTAL_BOOTS);
                    }).build());
    public static final ItemGroup ARCANUM_ITEMS_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ArcanumMod.MOD_ID, "arcanum_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.SEA_CRYSTAL_BLOCK))
                    .displayName(Text.translatable("itemgroup.arcanummod.arcanum_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RAW_SEA_CRYSTAL_BLOCK);
                        entries.add(ModBlocks.SEA_CRYSTAL_BLOCK);
                        entries.add(ModBlocks.POLISHED_SEA_CRYSTAL_BLOCK);
                        entries.add(ModBlocks.DEEPSLATE_SEA_CRYSTAL_ORE);
                        entries.add(ModBlocks.SEA_CRYSTAL_ORE);
                        entries.add(ModBlocks.WILD_CLOVER);

                        entries.add(ModBlocks.NETHERITE_ALTAR);
                        entries.add(ModBlocks.SEA_CRYSTAL_LAMP);

                        entries.add(ModBlocks.POLISHED_SEA_CRYSTAL_STAIRS);
                        entries.add(ModBlocks.POLISHED_SEA_CRYSTAL_SLAB);
                        entries.add(ModBlocks.POLISHED_SEA_CRYSTAL_BUTTON);
                        entries.add(ModBlocks.POLISHED_SEA_CRYSTAL_PRESSURE_PLATE);
                        entries.add(ModBlocks.POLISHED_SEA_CRYSTAL_FENCE);
                        entries.add(ModBlocks.POLISHED_SEA_CRYSTAL_FENCE_GATE);
                        entries.add(ModBlocks.POLISHED_SEA_CRYSTAL_WALL);
                        entries.add(ModBlocks.POLISHED_SEA_CRYSTAL_DOOR);
                        entries.add(ModBlocks.POLISHED_SEA_CRYSTAL_TRAPDOOR);
                    }).build());

    public static void registerItemGroups() {
        ArcanumMod.LOGGER.info("Registering Item Groups for " + ArcanumMod.MOD_ID);
    }
}
