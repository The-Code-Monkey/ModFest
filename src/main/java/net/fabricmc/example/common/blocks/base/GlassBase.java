package net.fabricmc.example.common.blocks.base;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.example.common.enums.ModRenderLayer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class GlassBase extends BlockBaseNotFull {
    public GlassBase(Block block) {
        super(FabricBlockSettings.copy(block)
                .nonOpaque()
                .sounds(BlockSoundGroup.GLASS));
        this.setRenderLayer(ModRenderLayer.TRANSLUCENT);
    }

    @Environment(EnvType.CLIENT)
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView view, BlockPos pos)
    {
        return 1.0F;
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView view, BlockPos pos)
    {
        return true;
    }

    @Environment(EnvType.CLIENT)
    public boolean isSideInvisible(BlockState state, BlockState neighbor, Direction facing)
    {
        return neighbor.getBlock() == this || super.isSideInvisible(state, neighbor, facing);
    }
}
