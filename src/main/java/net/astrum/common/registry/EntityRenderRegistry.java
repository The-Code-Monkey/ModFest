package net.astrum.common.registry;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.EntityType;

@Environment(EnvType.CLIENT)
public class EntityRenderRegistry {
    public static void register() {

    }

    private static void registerRenderMob(EntityType<?> entity, Class<? extends MobEntityRenderer<?, ?>> renderer)
    {
        EntityRendererRegistry.INSTANCE.register(entity, (entityRenderDispatcher, context) -> {
            MobEntityRenderer<?, ?> render = null;
            try
            {
                render = renderer.getConstructor(entityRenderDispatcher.getClass()).newInstance(entityRenderDispatcher);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return render;
        });
    }

    private static void registerRenderAny(EntityType<?> entity, Class<? extends EntityRenderer<?>> renderer)
    {
        EntityRendererRegistry.INSTANCE.register(entity, (entityRenderDispatcher, context) -> {
            EntityRenderer<?> render = null;
            try
            {
                render = renderer.getConstructor(entityRenderDispatcher.getClass()).newInstance(entityRenderDispatcher);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return render;
        });
    }
}
