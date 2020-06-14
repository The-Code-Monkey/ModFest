package net.astrum.common.helpers;

import net.astrum.AstrumCore;
import net.astrum.common.blocks.base.BlockFarmland;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Random;

public class BlocksHelper {
    public static final int FLAG_UPDATE_BLOCK = 1;
    public static final int FLAG_SEND_CLIENT_CHANGES = 2;
    public static final int FLAG_NO_RERENDER = 4;
    public static final int FORSE_RERENDER = 8;
    public static final int FLAG_IGNORE_OBSERVERS = 16;

    public static final int SET_SILENT = FLAG_UPDATE_BLOCK | FLAG_IGNORE_OBSERVERS | FLAG_SEND_CLIENT_CHANGES;

    private static final Vec3i[] OFFSETS = new Vec3i[] {
            new Vec3i(-1, -1, -1), new Vec3i(-1, -1, 0), new Vec3i(-1, -1, 1),
            new Vec3i(-1, 0, -1), new Vec3i(-1, 0, 0), new Vec3i(-1, 0, 1),
            new Vec3i(-1, 1, -1), new Vec3i(-1, 1, 0), new Vec3i(-1, 1, 1),

            new Vec3i(0, -1, -1), new Vec3i(0, -1, 0), new Vec3i(0, -1, 1),
            new Vec3i(0, 0, -1), new Vec3i(0, 0, 0), new Vec3i(0, 0, 1),
            new Vec3i(0, 1, -1), new Vec3i(0, 1, 0), new Vec3i(0, 1, 1),

            new Vec3i(1, -1, -1), new Vec3i(1, -1, 0), new Vec3i(1, -1, 1),
            new Vec3i(1, 0, -1), new Vec3i(1, 0, 0), new Vec3i(1, 0, 1),
            new Vec3i(1, 1, -1), new Vec3i(1, 1, 0), new Vec3i(1, 1, 1)
    };

    public static boolean isLava(BlockState state)
    {
        return state.getMaterial() == Material.LAVA;
    }

    public static boolean isNetherrack(BlockState state)
    {
        Block b = state.getBlock();
        return  b == Blocks.NETHERRACK ||
                b == Blocks.NETHER_QUARTZ_ORE;
    }

    public static boolean isSoulSand(BlockState state)
    {
        Block b = state.getBlock();
        return  b == Blocks.SOUL_SAND;
    }

    public static boolean isNetherGround(BlockState state)
    {
        Block b = state.getBlock();
        return  b == Blocks.NETHERRACK ||
                b == Blocks.NETHER_QUARTZ_ORE ||
                b == Blocks.SOUL_SAND;
    }

    public static boolean isNetherGroundMagma(BlockState state)
    {
        Block b = state.getBlock();
        return  b == Blocks.NETHERRACK ||
                b == Blocks.NETHER_QUARTZ_ORE ||
                b == Blocks.SOUL_SAND ||
                b == Blocks.MAGMA_BLOCK;
    }

    public static boolean isBone(BlockState state)
    {
        Block b = state.getBlock();
        return  b == Blocks.BONE_BLOCK;
    }

    public static boolean isGroundOrModContent(BlockState state)
    {
        Block b = state.getBlock();
        return  b == Blocks.NETHERRACK ||
                b == Blocks.NETHER_QUARTZ_ORE ||
                b == Blocks.SOUL_SAND ||
                Registry.BLOCK.getId(b).getNamespace().equals(AstrumCore.MOD_ID);
    }

    public static void setWithoutUpdate(World world, BlockPos pos, BlockState state)
    {
        world.setBlockState(pos, state, SET_SILENT);
    }

    public static int upRay(World world, BlockPos pos, int maxDist)
    {
        int length = 0;
        for (int j = 1; j < maxDist && (world.isAir(pos.up(j))); j++)
            length ++;
        return length;
    }

    public static int downRay(World world, BlockPos pos, int maxDist)
    {
        int length = 0;
        for (int j = 1; j < maxDist && (world.isAir(pos.down(j))); j++)
            length ++;
        return length;
    }

    public static BlockState rotateHorizontal(BlockState state, BlockRotation rotation, Property<Direction> facing)
    {
        return (BlockState)state.with(facing, rotation.rotate((Direction)state.get(facing)));
    }

    public static BlockState mirrorHorizontal(BlockState state, BlockMirror mirror, Property<Direction> facing)
    {
        return state.rotate(mirror.getRotation((Direction)state.get(facing)));
    }

    public static int getLengthDown(ServerWorld world, BlockPos pos, Block block)
    {
        int count = 1;
        while (world.getBlockState(pos.down(count)).getBlock() == block)
            count ++;
        return count;
    }

    public static boolean isFertile(BlockState state)
    {
        return state.getBlock() instanceof BlockFarmland;
    }

    public static void cover(World world, BlockPos center, Block ground, BlockState cover, int radius, Random random)
    {
        HashSet<BlockPos> points = new HashSet<BlockPos>();
        HashSet<BlockPos> points2 = new HashSet<BlockPos>();
        if (world.getBlockState(center).getBlock() == ground)
        {
            points.add(center);
            points2.add(center);
            for (int i = 0; i < radius; i++)
            {
                for (BlockPos pos : points) {
                    for (Vec3i offset : OFFSETS) {
                        if (random.nextBoolean()) {
                            BlockPos pos2 = pos.add(offset);
                            if (random.nextBoolean() && world.getBlockState(pos2).getBlock() == ground && !points.contains(pos2))
                                points2.add(pos2);
                        }
                    }
                }
                points.addAll(points2);
                points2.clear();
            }
            for (BlockPos pos : points) {
                BlocksHelper.setWithoutUpdate(world, pos, cover);
            }
        }
    }
}
