package net.nolli.arcanummod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.nolli.arcanummod.block.ModBlocks;
import net.nolli.arcanummod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RAW_SEA_CRYSTAL_BLOCK)
                .add(ModBlocks.SEA_CRYSTAL_BLOCK)
                .add(ModBlocks.SEA_CRYSTAL_ORE)
                .add(ModBlocks.DEEPSLATE_SEA_CRYSTAL_ORE)
                .add(ModBlocks.NETHERITE_ALTAR)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_BLOCK)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_STAIRS)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_SLAB)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_BUTTON)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_PRESSURE_PLATE)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_FENCE)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_FENCE_GATE)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_WALL)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_DOOR)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_SEA_CRYSTAL_BLOCK)
                .add(ModBlocks.SEA_CRYSTAL_BLOCK)
                .add(ModBlocks.SEA_CRYSTAL_ORE)
                .add(ModBlocks.DEEPSLATE_SEA_CRYSTAL_ORE)
                .add(ModBlocks.NETHERITE_ALTAR)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_BLOCK)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_STAIRS)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_SLAB)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_BUTTON)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_PRESSURE_PLATE)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_FENCE)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_FENCE_GATE)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_WALL)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_DOOR)
                .add(ModBlocks.POLISHED_SEA_CRYSTAL_TRAPDOOR);

        getOrCreateTagBuilder(ModTags.Blocks.TRANSFORMABLE_BLOCKS)
                .add(Blocks.STONE)
                .add(Blocks.ANDESITE);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.POLISHED_SEA_CRYSTAL_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.POLISHED_SEA_CRYSTAL_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.POLISHED_SEA_CRYSTAL_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_SEA_CRYSTAL_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
