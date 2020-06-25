package net.astrum.common.blocks.Astrum;

import net.astrum.client.IRenderTypeable;
import net.astrum.common.blocks.base.PlantBase;
import net.astrum.common.enums.AstrumRenderLayer;
import net.astrum.common.registry.BlocksRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class AstrumSapling extends SaplingBlock implements IRenderTypeable {
    public AstrumSapling(SaplingGenerator generator, Settings settings){
        super(generator, settings);

    }
    private AstrumRenderLayer layer = AstrumRenderLayer.TRANSLUCENT;
    @Override
    public AstrumRenderLayer getRenderLayer() {
        return layer;
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(BlocksRegistry.ASTRUM_DIRT)|| floor.isOf(BlocksRegistry.ASTRUM_GRASS);
    }


}
