package net.astrum.common.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.TrapdoorBlock;

public class TrapdoorBase extends TrapdoorBlock {
    public TrapdoorBase(Block block) {
        super(FabricBlockSettings.copy(block).nonOpaque());
    }
}
