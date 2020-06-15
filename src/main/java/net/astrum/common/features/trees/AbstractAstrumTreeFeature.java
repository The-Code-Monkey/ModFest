package net.astrum.common.features.trees;

import com.mojang.serialization.Codec;
import net.astrum.common.registry.BlocksRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Material;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public abstract class AbstractAstrumTreeFeature<T extends AstrumTreeFeatureConfig> extends Feature<T> {
    public AbstractAstrumTreeFeature(Codec<T> codec) {
        super(codec);
    }

    protected static boolean isAirOrLeaves(ServerWorldAccess world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        return state.isAir()
                || state.getMaterial() == Material.LEAVES
                || state.getMaterial() == Material.REPLACEABLE_PLANT
                || state.isIn(BlockTags.SAPLINGS);
    }

    protected boolean canGenerateAt(ServerWorldAccess world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.isAir()
                || state.getMaterial() == Material.LEAVES
                || state.getMaterial() == Material.REPLACEABLE_PLANT
                || state.isIn(BlockTags.SAPLINGS)) {
            BlockState ground = world.getBlockState(pos.down());
            Block groundBlock = ground.getBlock();

            return groundBlock == BlocksRegistry.ASTRUM_GRASS
                    || groundBlock == BlocksRegistry.ASTRUM_DIRT;
        }
        return false;
    }

    protected static <T extends AstrumTreeFeatureConfig> void trySetLeaves(ServerWorldAccess world, BlockPos pos, int distance, Random random, T config) {
        BlockState state = world.getBlockState(pos);
        if (state.isAir()
                || (state.getMaterial() == Material.LEAVES && state.get(LeavesBlock.DISTANCE) > distance)
                || state.getMaterial() == Material.REPLACEABLE_PLANT
                || state.isIn(BlockTags.SAPLINGS)) {
            setBlockState(world, pos, config.leaves.getBlockState(random, pos).with(LeavesBlock.DISTANCE, distance));
        }
    }

    protected static void trySetToDirt(ServerWorldAccess world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() == BlocksRegistry.ASTRUM_GRASS) {
            setBlockState(world, pos, state);
        }
    }

    private static void setBlockState(ServerWorldAccess world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, state, 16 | 2 | 1);
    }

    protected static void placeHardcodedShape(ServerWorldAccess world, Random random, BlockPos pos, AstrumTreeFeatureConfig config, int[] shape, int trunkHeight) {
        BlockPos.Mutable mpos = new BlockPos.Mutable(pos.getX(), pos.getY(), pos.getZ());
        for (int dy = 0; dy < shape.length; dy++) {
            int radius = shape[dy];
            for (int dx = -radius; dx <= radius; dx++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    mpos.set(pos.getX() + dx, pos.getY() + dy, pos.getZ() + dz);
                    if (dy < trunkHeight && dx == 0 && dz == 0) {
                        world.setBlockState(mpos, config.trunk.getBlockState(random, mpos), 19);
                    } else if (Math.abs(dx) != radius || Math.abs(dz) != radius || random.nextInt(2) == 0) {
                        int distance = Math.abs(dx) + Math.abs(dz);
                        if (dy >= trunkHeight) {
                            distance += dy - trunkHeight + 1;
                        }
                        trySetLeaves(world, mpos, distance, random, config);
                    }
                }
            }
        }
    }
}
