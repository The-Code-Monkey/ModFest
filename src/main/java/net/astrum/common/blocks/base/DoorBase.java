package net.astrum.common.blocks.base;

import net.astrum.client.IRenderTypeable;
import net.astrum.common.enums.AstrumRenderLayer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;

public class DoorBase extends DoorBlock implements IRenderTypeable {
    public DoorBase(Block block) {
        super(FabricBlockSettings.copyOf(block).breakByTool(FabricToolTags.AXES).nonOpaque());
    }

    @Override
    public AstrumRenderLayer getRenderLayer() {
        return AstrumRenderLayer.CUTOUT;
    }
}
