package net.astrum.client.entity.model;

import net.astrum.common.entity.EntityTriffid;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ModelTriffid extends EntityModel<EntityTriffid> {

    private final ModelPart head;
    private final ModelPart body;

    private float pitch;

    public ModelTriffid() {
        this.textureHeight = 64;
        this.textureWidth = 64;

        head = new ModelPart(this, 0, 0);
        head.addCuboid(-6, -6, -6, 12, 12, 12);

        body = new ModelPart(this, 0, 0);
        body.addCuboid(-2.0F, 0.0F, -1.0F, 4.0F, 20.0F, 2.0F);
        body.addCuboid(-5.0F, 3.0F, -6.0F, 10.0F, 16.0F, 6.0F);
        body.setPivot(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void setAngles(EntityTriffid entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void animateModel(EntityTriffid livingEntity, float f, float g, float h) {
        this.pitch = livingEntity.getLeaningPitch(h);
        super.animateModel(livingEntity, f, g, h);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        // translate model down
        matrices.translate(0, 1.125, 0);

        // render head parts
        head.render(matrices, vertices, light, overlay);

        // render body parts
//        body.render(matrices, vertices, light, overlay);

        // render leg parts
    }
}
