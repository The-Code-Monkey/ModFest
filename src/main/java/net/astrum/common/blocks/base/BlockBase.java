package net.astrum.common.blocks.base;

import net.astrum.client.IRenderTypeable;
import net.astrum.common.enums.AstrumRenderLayer;
import net.minecraft.block.Block;

public class BlockBase extends Block implements IRenderTypeable {
    private boolean isClimbable = false;
    private AstrumRenderLayer layer = AstrumRenderLayer.SOLID;

    public BlockBase(Settings settings) {
        super(settings);
    }

    public void setClimbable(boolean climbable)
    {
        this.isClimbable = climbable;
    }

    public boolean isClimbable()
    {
        return isClimbable;
    }

    public void setRenderLayer(AstrumRenderLayer layer)
    {
        this.layer = layer;
    }

    @Override
    public AstrumRenderLayer getRenderLayer() {
        return layer;
    }
}
