package net.astrum.client.entity.render;

import net.astrum.AstrumCore;
import net.astrum.common.entity.EntityTriffid;
import net.astrum.client.entity.model.ModelTriffid;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RenderTriffid extends MobEntityRenderer<EntityTriffid, ModelTriffid> {
    public RenderTriffid(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new ModelTriffid(), 1.25f);
    }

    @Override
    public Identifier getTexture(EntityTriffid entity) {
        return new Identifier(AstrumCore.MOD_ID, "textures/entity/triffid/triffid.png");
    }
}
