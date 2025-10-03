package net.nolli.arcanummod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class WildCloverBlock extends PlantBlock {
    public static final MapCodec<WildCloverBlock> CODEC = createCodec(WildCloverBlock::new);

    private static final VoxelShape OUTLINE_SHAPE = Block.createCuboidShape(
            0.0, 0.0, 0.0,
            16.0, 3.0, 16.0
    );

    public WildCloverBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return OUTLINE_SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.GRASS_BLOCK)
                || floor.isOf(Blocks.DIRT)
                || floor.isOf(Blocks.COARSE_DIRT)
                || floor.isOf(Blocks.PODZOL)
                || floor.isOf(Blocks.FARMLAND)
                || floor.isOf(Blocks.MOSS_BLOCK);
    }
}
