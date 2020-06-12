package net.fabricmc.example.common.blocks.base;

import net.fabricmc.example.common.enums.ModRenderLayer;
import net.fabricmc.example.client.IRenderTypeable;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;

public class DoorBase extends DoorBlock implements IRenderTypeable {
    public DoorBase(Block block) {
        super(FabricBlockSettings.copy(block).nonOpaque());
    }

    @Override
    public ModRenderLayer getRenderLayer() {
        return ModRenderLayer.CUTOUT;
    }
}
