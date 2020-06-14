package net.astrum.client;

import net.fabricmc.api.ClientModInitializer;
import net.astrum.common.enums.AstrumRenderLayer;
import net.astrum.common.registry.EntityRenderRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
public class AstrumCoreClient implements ClientModInitializer {

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
                AstrumRenderLayer layer = ((IRenderTypeable) block).getRenderLayer();
                if (layer == AstrumRenderLayer.CUTOUT)
                    BlockRenderLayerMap.INSTANCE.putBlock(block, cutout);
                else if (layer == AstrumRenderLayer.TRANSLUCENT)
                    BlockRenderLayerMap.INSTANCE.putBlock(block, translucent);
            }
        });
    }
}
