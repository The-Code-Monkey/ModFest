package net.astrum.client.entity.model;

import net.astrum.common.entity.EntityTriffid;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ModelTriffid extends EntityModel<EntityTriffid> {
	private final ModelPart legs;
	private final ModelPart leg1;
	private final ModelPart top;
	private final ModelPart bottom;
	private final ModelPart leg2;
	private final ModelPart top2;
	private final ModelPart bottom2;
	private final ModelPart leg3;
	private final ModelPart top3;
	private final ModelPart bottom3;
	private final ModelPart body;
	private final ModelPart head;

	public ModelTriffid() {
		textureWidth = 64;
		textureHeight = 64;

		legs = new ModelPart(this);
//		legs.setRotationPoint(0.0F, 24.0F, 0.0F);

		leg1 = new ModelPart(this);
		leg1.setPivot(-4, 0, -5);
		leg1.yaw = -0.7854F;
		legs.addChild(leg1);
//		leg1.setRotationPoint(-4.0F, 0.0F, 5.0F);
//		setRotationAngle(leg1, 0.0F, -0.7854F, 0.0F);
		

		top = new ModelPart(this);
		leg1.addChild(top);
		top.setPivot(0, 0, 0);
		top.pitch = 0.3491F;
		top.setTextureOffset(0, 0).addCuboid(-2.0F, -8.25F, 1.75F, 3.0F, 4.0F, 3.0F, 0.0F, false);
//		top.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(top, 0.3491F, 0.0F, 0.0F);

		bottom = new ModelPart(this);
		leg1.addChild(bottom);
		bottom.setPivot(0, 0, 0);
		bottom.setTextureOffset(0, 0).addCuboid(-2.0F, -5.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
//		bottom.setRotationPoint(0.0F, 0.0F, 0.0F);

		leg2 = new ModelPart(this);
		leg2.setPivot(-4, 0, -5);
		leg2.yaw = 0.7854F;
		legs.addChild(leg2);
//		leg2.setRotationPoint(-4.0F, 0.0F, -5.0F);
//		setRotationAngle(leg2, 0.0F, 0.7854F, 0.0F);


		top2 = new ModelPart(this);
//		top2.setRotationPoint(0.0F, 0.0F, 0.0F);
		leg2.addChild(top2);
//		setRotationAngle(top2, -0.3491F, 0.0F, 0.0F);
		top2.setTextureOffset(0, 0).addCuboid(-2.0F, -8.25F, -4.75F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		bottom2 = new ModelPart(this);
//		bottom2.setRotationPoint(0.0F, 0.0F, 0.0F);
		leg2.addChild(bottom2);
		bottom2.setTextureOffset(0, 0).addCuboid(-2.0F, -5.0F, -3.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		leg3 = new ModelPart(this);
//		leg3.setRotationPoint(4.0F, 0.0F, 1.0F);
		legs.addChild(leg3);
//		setRotationAngle(leg3, 0.0F, 1.5708F, 0.0F);
		

		top3 = new ModelPart(this);
//		top3.setRotationPoint(0.0F, 0.0F, 0.0F);
		leg3.addChild(top3);
//		setRotationAngle(top3, 0.3491F, 0.0F, 0.0F);
		top3.setTextureOffset(0, 0).addCuboid(-0.5F, -8.25F, 1.75F, 3.0F, 4.0F, 3.0F, 0.0F, true);

		bottom3 = new ModelPart(this);
//		bottom3.setRotationPoint(0.0F, 0.0F, 0.0F);
		leg3.addChild(bottom3);
		bottom3.setTextureOffset(0, 0).addCuboid(-0.5F, -5.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, true);

		body = new ModelPart(this);
//		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		head = new ModelPart(this);
//		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		
	}

    @Override
    public void setAngles(EntityTriffid entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.translate(0, 1.125, 0);

        legs.render(matrices, vertices, light, overlay);
//        body.render(matrices, vertices, light, overlay);
//        head.render(matrices, vertices, light, overlay);
    }
}