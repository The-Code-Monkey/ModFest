package net.fabricmc.example.common.blocks.base;

import net.fabricmc.example.common.enums.ModRenderLayer;
import net.fabricmc.example.client.IRenderTypeable;
import net.minecraft.block.Block;

public class BlockBase extends Block implements IRenderTypeable {
    private boolean isClimmable = false;
    private ModRenderLayer layer = ModRenderLayer.SOLID;

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

    public void setRenderLayer(ModRenderLayer layer)
    {
        this.layer = layer;
    }

    @Override
    public ModRenderLayer getRenderLayer() {
        return layer;
    }
}
