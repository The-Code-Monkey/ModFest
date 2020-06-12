package net.fabricmc.example.common.blocks.base;

import net.fabricmc.example.common.registry.BlocksRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import net.minecraft.world.gen.feature.BlockPileFeatureConfig;

import java.util.Random;

public class GrassBase extends BlockBase implements Fertilizable {
    public static final BooleanProperty SNOWY = Properties.SNOWY;

    public GrassBase() {
        super(FabricBlockSettings.of(Material.SOIL).strength(0.5F, 0.5F).sounds(BlockSoundGroup.GRASS).breakByTool(FabricToolTags.SHOVELS).breakByHand(true));
        this.setDefaultState(this.stateManager.getDefaultState().with(SNOWY, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SNOWY);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Block block = ctx.getWorld().getBlockState(ctx.getBlockPos().up()).getBlock();
        return this.getDefaultState().with(SNOWY, block == Blocks.SNOW_BLOCK || block == Blocks.SNOW);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (direction == Direction.UP) {
            Block block = newState.getBlock();
            return state.with(SNOWY, block == Blocks.SNOW_BLOCK || block == Blocks.SNOW);
        }
        return state;
    }

    private static boolean canSurvive(BlockState state, WorldView view, BlockPos pos) {
        BlockPos posAbove = pos.up();
        BlockState stateAbove = view.getBlockState(posAbove);
        if (stateAbove.getBlock() == Blocks.SNOW && stateAbove.get(SnowBlock.LAYERS) == 1) {
            return true;
        }
        int i = ChunkLightProvider.getRealisticOpacity(view, state, pos, stateAbove, posAbove, Direction.UP, stateAbove.getOpacity(view, posAbove));
        return i < view.getMaxLightLevel();
    }

    private static boolean canSpread(BlockState state, WorldView view, BlockPos pos) {
        BlockPos blockPos = pos.up();
        return canSurvive(state, view, pos) && !view.getFluidState(blockPos).matches(FluidTags.WATER);
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return world.getBlockState(pos.up()).isAir();
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        // TODO once biome features setup
    }

    public static boolean generate(World world, Random random, BlockPos pos, BlockPileFeatureConfig config, int i, int j) {
        for (Block block = world.getBlockState(pos.down()).getBlock(); block != BlocksRegistry.GRASS && pos.getY() > 0; block = world.getBlockState(pos).getBlock()) {
            pos = pos.down();
        }

        int y = pos.getY();
        if (y >= 1 && y + 1 < 256) {
            int placed = 0;

            for (int m = 0; m < i * i; ++m) {
                BlockPos pos2 = pos.add(random.nextInt(i) - random.nextInt(i), random.nextInt(j) - random.nextInt(j), random.nextInt(i) - random.nextInt(i));
                BlockState state = config.stateProvider.getBlockState(random, pos2);
                if (world.isAir(pos2) && pos2.getY() > 0 && state.canPlaceAt(world, pos2)) {
                    world.setBlockState(pos2, state, 2);
                    ++placed;
                }
            }

            return placed > 0;
        }
        return false;
    }
}
