package net.astrum.common.registry;

import net.astrum.client.entity.render.RenderTriffid;
import net.astrum.client.entity.render.RenderTriffidWhip;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class EntityRenderRegistry {
    public static void register() {
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.TRIFFID, (dispatcher, context) -> new RenderTriffid(dispatcher));
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.TRIFFID_PROJECTILE, (dispatcher, context) -> new RenderTriffidWhip(dispatcher));
    }
}
