package net.nolli.arcanummod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.nolli.arcanummod.block.ModBlocks;
import net.nolli.arcanummod.block.custom.SeaCrystalLampBlock;
import net.nolli.arcanummod.item.ModItems;
import net.minecraft.util.Identifier;


public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SEA_CRYSTAL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_SEA_CRYSTAL_BLOCK);
        BlockStateModelGenerator.BlockTexturePool polishedSeaCrystalPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_SEA_CRYSTAL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SEA_CRYSTAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SEA_CRYSTAL_ORE);

        polishedSeaCrystalPool.stairs(ModBlocks.POLISHED_SEA_CRYSTAL_STAIRS);
        polishedSeaCrystalPool.slab(ModBlocks.POLISHED_SEA_CRYSTAL_SLAB);

        polishedSeaCrystalPool.button(ModBlocks.POLISHED_SEA_CRYSTAL_BUTTON);
        polishedSeaCrystalPool.pressurePlate(ModBlocks.POLISHED_SEA_CRYSTAL_PRESSURE_PLATE);

        polishedSeaCrystalPool.fence(ModBlocks.POLISHED_SEA_CRYSTAL_FENCE);
        polishedSeaCrystalPool.fenceGate(ModBlocks.POLISHED_SEA_CRYSTAL_FENCE_GATE);
        polishedSeaCrystalPool.wall(ModBlocks.POLISHED_SEA_CRYSTAL_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.POLISHED_SEA_CRYSTAL_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.POLISHED_SEA_CRYSTAL_TRAPDOOR);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.SEA_CRYSTAL_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.SEA_CRYSTAL_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.SEA_CRYSTAL_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(SeaCrystalLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SEA_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SEA_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLOVER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLOVER_OF_FORTUNE, Models.GENERATED);

        itemModelGenerator.register(ModItems.GOLD_CLOVER, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_CLOVER, Models.GENERATED);

        itemModelGenerator.register(ModItems.SEA_CRYSTAL_BEER, Models.GENERATED);

        itemModelGenerator.register(ModItems.SEA_CRYSTAL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SEA_CRYSTAL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SEA_CRYSTAL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SEA_CRYSTAL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SEA_CRYSTAL_HOE, Models.HANDHELD);
    }
}
