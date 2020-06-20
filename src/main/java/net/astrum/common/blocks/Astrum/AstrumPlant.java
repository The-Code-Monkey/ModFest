package net.astrum.common.blocks.Astrum;

import net.astrum.common.blocks.base.PlantBase;
import net.astrum.common.registry.BlocksRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class AstrumPlant extends PlantBase {
    public AstrumPlant(Block block){
        super(block);
    }
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(BlocksRegistry.ASTRUM_DIRT)|| floor.isOf(BlocksRegistry.ASTRUM_GRASS);
    }
}
