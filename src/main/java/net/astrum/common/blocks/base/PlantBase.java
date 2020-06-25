package net.astrum.common.blocks.base;

import net.astrum.common.enums.AstrumRenderLayer;
import net.astrum.common.registry.BlocksRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.Random;

public class PlantBase extends BlockBase{
    public PlantBase(Block block){
        super(FabricBlockSettings.copy(block)
                .nonOpaque()
                .sounds(BlockSoundGroup.GRASS));
        this.setRenderLayer(AstrumRenderLayer.TRANSLUCENT);
    }


    protected int getTickRate() {
        return 20;
    }

    public boolean canMobSpawnInside() {
        return true;
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.DIRT)|| floor.isOf(Blocks.GRASS);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        return this.canPlantOnTop(world.getBlockState(blockPos), world, blockPos);
    }


}
