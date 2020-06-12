package net.astrum.common.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.WallBlock;

public class WallBase extends WallBlock {
    public WallBase(Block block) {
        super(FabricBlockSettings.copy(block).nonOpaque());
    }
}
