package net.fabricmc.example.common.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.FenceGateBlock;

public class GateBase extends FenceGateBlock {
    public GateBase(Block block) {
        super(FabricBlockSettings.copy(block).nonOpaque());
    }
}
