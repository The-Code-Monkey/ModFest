package net.astrum.common.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;

public class SlabBase extends SlabBlock {
    public SlabBase(Block block) {
        super(FabricBlockSettings.copy(block).nonOpaque());
    }
}
