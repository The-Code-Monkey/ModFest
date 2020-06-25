package net.astrum.common.blocks.base;

import jdk.internal.jline.internal.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Iterator;
import java.util.Random;

public class AstrumSaplingGenerator extends SaplingGenerator {
    public boolean generate(ServerWorld serverWorld, ChunkGenerator chunkGenerator, BlockPos blockPos, BlockState blockState, Random random) {
        ConfiguredFeature<TreeFeatureConfig, ?> configuredFeature = this.createTreeFeature(random, this.method_24282(serverWorld, blockPos));
        if (configuredFeature == null) {
            return false;
        } else {
            serverWorld.setBlockState(blockPos, Blocks.AIR.getDefaultState(), 4);
            configuredFeature.config.ignoreFluidCheck();
            if (configuredFeature.generate(serverWorld, serverWorld.getStructureAccessor(), chunkGenerator, random, blockPos)) {
                return true;
            } else {
                serverWorld.setBlockState(blockPos, blockState, 4);
                return false;
            }
        }
    }

    private boolean method_24282(WorldAccess worldAccess, BlockPos blockPos) {
        Iterator var3 = BlockPos.Mutable.iterate(blockPos.down().north(2).west(2), blockPos.up().south(2).east(2)).iterator();

        BlockPos blockPos2;
        do {
            if (!var3.hasNext()) {
                return false;
            }

            blockPos2 = (BlockPos)var3.next();
        } while(!worldAccess.getBlockState(blockPos2).isIn(BlockTags.FLOWERS));

        return true;
    }

    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
        return random.nextInt(10) == 0 ? Feature.TREE.configure(bl ? DefaultBiomeFeatures.FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG : DefaultBiomeFeatures.FANCY_TREE_CONFIG) : Feature.TREE.configure(bl ? DefaultBiomeFeatures.OAK_TREE_WITH_MORE_BEEHIVES_CONFIG : DefaultBiomeFeatures.OAK_TREE_CONFIG);
    }
}
