package net.astrum.client.entity.model;

import net.astrum.common.entity.EntityTriffidProjectile;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ModelTriffidWhip extends EntityModel<EntityTriffidProjectile> {
    private final ModelPart model;

    public ModelTriffidWhip() {
        textureWidth = 128;
        textureHeight = 128;

        model = new ModelPart(this);
        model.addCuboid(0, 0, 0, 1, 1, 1);
    }

    @Override
    public void setAngles(EntityTriffidProjectile entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        model.render(matrices, vertices, light, overlay);
    }
}
