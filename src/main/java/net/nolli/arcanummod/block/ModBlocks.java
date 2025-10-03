package net.nolli.arcanummod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.nolli.arcanummod.ArcanumMod;
import net.nolli.arcanummod.block.custom.NetheriteAltar;
import net.nolli.arcanummod.block.custom.SeaCrystalLampBlock;
import net.nolli.arcanummod.block.custom.WildCloverBlock;

public class ModBlocks {

    //Blocks
    public static final Block SEA_CRYSTAL_BLOCK = registerBlock("sea_crystal_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block RAW_SEA_CRYSTAL_BLOCK = registerBlock("raw_sea_crystal_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block POLISHED_SEA_CRYSTAL_BLOCK = registerBlock("polished_sea_crystal_block",
            new Block(AbstractBlock.Settings.create().strength(5.0F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));

    //Ores
    public static final Block DEEPSLATE_SEA_CRYSTAL_ORE = registerBlock("deepslate_sea_crystal_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block SEA_CRYSTAL_ORE = registerBlock("sea_crystal_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));


    //Function Blocks
    public static final Block NETHERITE_ALTAR = registerBlock("netherite_altar",
            new NetheriteAltar(AbstractBlock.Settings.create().strength(50f, 1200f).requiresTool()));

    //Non-Block Blocks
        //Polished Sea Crystal
    public static final Block POLISHED_SEA_CRYSTAL_STAIRS = registerBlock("polished_sea_crystal_stairs",
            new StairsBlock(ModBlocks.POLISHED_SEA_CRYSTAL_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(5.0F, 6.0F).requiresTool()));
    public static final Block POLISHED_SEA_CRYSTAL_SLAB = registerBlock("polished_sea_crystal_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(5.0F, 6.0F).requiresTool()));

    public static final Block POLISHED_SEA_CRYSTAL_BUTTON = registerBlock("polished_sea_crystal_button",
            new ButtonBlock(BlockSetType.IRON, 10,
                    AbstractBlock.Settings.create().strength(1f).strength(5.0F, 6.0F).noCollision()));
    public static final Block POLISHED_SEA_CRYSTAL_PRESSURE_PLATE = registerBlock("polished_sea_crystal_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(1f).requiresTool()));
    public static final Block POLISHED_SEA_CRYSTAL_FENCE = registerBlock("polished_sea_crystal_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(5.0F, 6.0F).requiresTool()));
    public static final Block POLISHED_SEA_CRYSTAL_FENCE_GATE = registerBlock("polished_sea_crystal_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.create().strength(5.0F, 6.0F).requiresTool()));
    public static final Block POLISHED_SEA_CRYSTAL_WALL = registerBlock("polished_sea_crystal_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(5.0F, 6.0F).requiresTool()));

    public static final Block POLISHED_SEA_CRYSTAL_DOOR = registerBlock("polished_sea_crystal_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(5.0F, 6.0F).requiresTool().nonOpaque()));
    public static final Block POLISHED_SEA_CRYSTAL_TRAPDOOR = registerBlock("polished_sea_crystal_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(5.0F, 6.0F).requiresTool().nonOpaque()));

    public static final Block WILD_CLOVER = registerBlock("wild_clover",
            new WildCloverBlock(AbstractBlock.Settings.create().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)
                    .nonOpaque().replaceable().burnable()
            ));

    public static final Block SEA_CRYSTAL_LAMP = registerBlock("sea_crystal_lamp",
            new SeaCrystalLampBlock(AbstractBlock.Settings.create().strength(0.5F).requiresTool()
                    .luminance(state -> state.get(SeaCrystalLampBlock.CLICKED) ? 15 : 0).nonOpaque()
                    .solidBlock((state, world, pos) -> false)
                    .suffocates((state, world, pos) -> false)
                    .blockVision((state, world, pos) -> false)
                    .sounds(BlockSoundGroup.GLASS)
            ));


    private static Block registerBlock(String name, Block block) {
        registerBlocksItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ArcanumMod.MOD_ID, name), block);
    }

    private static void registerBlocksItem(String name, Block block) {
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
