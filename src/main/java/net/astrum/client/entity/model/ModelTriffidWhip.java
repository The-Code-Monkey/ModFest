package net.astrum.client.entity.model;

import net.astrum.common.entity.EntityTriffidProjectile;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ModelTriffidWhip extends EntityModel<EntityTriffidProjectile> {
    private final ModelPart whip;

    public ModelTriffidWhip() {
        textureWidth = 64;
        textureHeight = 64;

        whip = new ModelPart(this);
    }

    @Override
    public void setAngles(EntityTriffidProjectile entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        whip.render(matrices, vertices, light, overlay);
    }

    public void setRotationAngle(ModelPart modelPart, float x, float y, float z) {
        modelPart.pitch = x;
        modelPart.yaw = y;
        modelPart.roll = z;
    }
}
