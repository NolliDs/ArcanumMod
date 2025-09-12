package net.nolli.arcanummod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.nolli.arcanummod.ArcanumMod;

public class ModBlocks {

    public static final Block SEA_CRYSTAL_BLOCK = registerBlock("sea_crystal_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block RAW_SEA_CRYSTAL_BLOCK = registerBlock("raw_sea_crystal_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block DEEPSLATE_SEA_CRYSTAL_ORE = registerBlock("deepslate_sea_crystal_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block SEA_CRYSTAL_ORE = registerBlock("sea_crystal_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));


    private static Block registerBlock(String name, Block block) {
        regosterBlocksItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ArcanumMod.MOD_ID, name), block);
    }

    private static void regosterBlocksItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ArcanumMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        ArcanumMod.LOGGER.info("Registering Mod Blocks for " + ArcanumMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.SEA_CRYSTAL_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.RAW_SEA_CRYSTAL_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.DEEPSLATE_SEA_CRYSTAL_ORE);
            fabricItemGroupEntries.add(ModBlocks.SEA_CRYSTAL_ORE);
        });
    }
}
