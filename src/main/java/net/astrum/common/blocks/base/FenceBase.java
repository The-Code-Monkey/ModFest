package net.astrum.common.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;

public class FenceBase extends FenceBlock {
    public FenceBase(Block block) {
        super(FabricBlockSettings.copyOf(block).breakByTool(FabricToolTags.AXES));
    }
}
