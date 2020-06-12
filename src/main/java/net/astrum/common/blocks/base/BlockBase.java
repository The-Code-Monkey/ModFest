package net.astrum.common.blocks.base;

import net.astrum.client.IRenderTypeable;
import net.astrum.common.enums.AstrumRenderLayer;
import net.minecraft.block.Block;

public class BlockBase extends Block implements IRenderTypeable {
    private boolean isClimmable = false;
    private AstrumRenderLayer layer = AstrumRenderLayer.SOLID;

    public BlockBase(Settings settings) {
        super(settings);
    }

    public void setClimmable(boolean climmable)
    {
        this.isClimmable = climmable;
    }

    public boolean isClimmable()
    {
        return isClimmable;
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
