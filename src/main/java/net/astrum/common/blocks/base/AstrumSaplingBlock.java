package net.astrum.common.blocks.base;

import net.astrum.common.registry.BlocksRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class AstrumSaplingBlock extends SaplingBlock {
    public AstrumSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(BlocksRegistry.ASTRUM_DIRT) || floor.isOf(BlocksRegistry.ASTRUM_GRASS);
    }
}
