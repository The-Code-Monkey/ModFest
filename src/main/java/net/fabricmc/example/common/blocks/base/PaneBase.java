package net.fabricmc.example.common.blocks.base;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.example.common.enums.ModRenderLayer;
import net.fabricmc.example.client.IRenderTypeable;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.util.math.Direction;

public class PaneBase extends PaneBlock implements IRenderTypeable {
    public PaneBase(Block block) {
        super(FabricBlockSettings.copy(block).strength(0.3F, 0.3F).nonOpaque());
    }

    @Override
    public ModRenderLayer getRenderLayer() {
        return ModRenderLayer.TRANSLUCENT;
    }

    @Environment(EnvType.CLIENT)
    public boolean isSideInvisible(BlockState state, BlockState neighbor, Direction facing) {
        if (neighbor.getBlock() == this) {
            if (!facing.getAxis().isHorizontal()) {
                return false;
            }
            if (state.get(FACING_PROPERTIES.get(facing)) && neighbor.get(FACING_PROPERTIES.get(facing.getOpposite()))) {
                return true;
            }
        }
        return super.isSideInvisible(state, neighbor, facing);
    }

}
