package net.astrum.client;

import net.fabricmc.api.ClientModInitializer;
import net.astrum.common.enums.ModRenderLayer;
import net.astrum.common.registry.EntityRenderRegistry;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.registry.Registry;

public class ModMainClient implements ClientModInitializer {

    @Override
    public void onInitializeClient()
    {
        registerRenderLayers();
        EntityRenderRegistry.register();
    }

    private void registerRenderLayers()
    {
        RenderLayer cutout = RenderLayer.getCutout();
        RenderLayer translucent = RenderLayer.getTranslucent();
        Registry.BLOCK.forEach(block -> {
            if (block instanceof IRenderTypeable)
            {
                ModRenderLayer layer = ((IRenderTypeable) block).getRenderLayer();
                if (layer == ModRenderLayer.CUTOUT)
                    BlockRenderLayerMap.INSTANCE.putBlock(block, cutout);
                else if (layer == ModRenderLayer.TRANSLUCENT)
                    BlockRenderLayerMap.INSTANCE.putBlock(block, translucent);
            }
        });
    }
}
