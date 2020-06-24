package net.astrum.client.entity.render;

import net.astrum.AstrumCore;
import net.astrum.client.entity.model.ModelTriffidWhip;
import net.astrum.common.entity.EntityTriffidProjectile;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RenderTriffidWhip extends MobEntityRenderer<EntityTriffidProjectile, ModelTriffidWhip> {
    public RenderTriffidWhip(EntityRenderDispatcher entityRenderDispatcher) {

        super(entityRenderDispatcher, new ModelTriffidWhip(), 1.25f);
        shadowRadius=0;
    }

    @Override
    public Identifier getTexture(EntityTriffidProjectile entity) {
        return new Identifier(AstrumCore.MOD_ID, "textures/entity/triffid/triffid_whip.png");
    }
}
