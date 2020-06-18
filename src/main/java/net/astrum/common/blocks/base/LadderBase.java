package net.astrum.common.blocks.base;

import net.astrum.common.enums.AstrumRenderLayer;
import net.astrum.common.helpers.BlocksHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class LadderBase extends BlockBaseNotFull {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);
    protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);

    public LadderBase(Block block) {
        super(FabricBlockSettings.copy(block).nonOpaque());
        this.setRenderLayer(AstrumRenderLayer.CUTOUT);
        this.setClimbable(true);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(FACING);
        stateManager.add(WATERLOGGED);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos)
    {
        switch (state.get(FACING))
        {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case EAST:
            default:
                return EAST_SHAPE;
        }
    }

    private boolean canPlaceOn(BlockView world, BlockPos pos, Direction side)
    {
        BlockState blockState = world.getBlockState(pos);
        return !blockState.emitsRedstonePower() && blockState.isSideSolidFullSquare(world, pos, side);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos)
    {
        Direction direction = (Direction) state.get(FACING);
        return this.canPlaceOn(world, pos.offset(direction.getOpposite()), direction);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx)
    {
        BlockState blockState2;
        if (!ctx.canReplaceExisting())
        {
            blockState2 = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(ctx.getSide().getOpposite()));
            if (blockState2.getBlock() == this && blockState2.get(FACING) == ctx.getSide())
            {
                return null;
            }
        }

        blockState2 = this.getDefaultState();
        WorldView worldView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        Direction[] var6 = ctx.getPlacementDirections();

        for (Direction direction : var6) {
            if (direction.getAxis().isHorizontal()) {
                blockState2 = (BlockState) blockState2.with(FACING, direction.getOpposite());
                if (blockState2.canPlaceAt(worldView, blockPos)) {
                    return (BlockState) blockState2.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
                }
            }
        }

        return null;
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation)
    {
        return BlocksHelper.rotateHorizontal(state, rotation, FACING);
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror)
    {
        return BlocksHelper.mirrorHorizontal(state, mirror, FACING);
    }

    @Override
    public FluidState getFluidState(BlockState state)
    {
        return (Boolean) state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
}
