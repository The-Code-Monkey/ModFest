package net.astrum.common.blocks.Astrum;

import jdk.internal.jline.internal.Nullable;
import net.astrum.common.features.trees.AstrumTreeFeatureConfig;
import net.astrum.common.registry.BlocksRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.Random;

public class AstrumSaplingGenerator extends SaplingGenerator {
    public AstrumSaplingGenerator(){

    }
    @Override
    public boolean generate(ServerWorld world, ChunkGenerator generator, BlockPos pos, BlockState state, Random random) {
        ConfiguredFeature<?, ?> feature = Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ASTRUM_LOG), new SimpleBlockStateProvider(ASTRUM_LEAVES), new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(5, 2, 0), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build());;
        if (feature.generate(world, world.getStructureAccessor(), generator, random, pos)) {
            world.setBlockState(pos, BlocksRegistry.ASTRUM_LOG.getDefaultState(), 4);
            return true;
        }
        return false;
    }

    public static final BlockState ASTRUM_LEAVES= Blocks.BIRCH_LEAVES.getDefaultState();
    public static final BlockState ASTRUM_LOG=Blocks.BIRCH_LOG.getDefaultState();

    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
        return Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ASTRUM_LOG), new SimpleBlockStateProvider(ASTRUM_LEAVES), new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(5, 2, 0), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build());
    }
}
