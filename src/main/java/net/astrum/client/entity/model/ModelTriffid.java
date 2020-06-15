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
	private final ModelPart neck;
	private final ModelPart lower_neck;
	private final ModelPart middle_neck;
	private final ModelPart upper_middle_neck;
	private final ModelPart upper_neck;
	private final ModelPart head;
	private final ModelPart back;
	private final ModelPart front;
	private final ModelPart front_bottom_right;
	private final ModelPart front_bottom_left;
	private final ModelPart tongue;

	public ModelTriffid() {
		textureWidth = 128;
		textureHeight = 128;

		// LEGS
		legs = new ModelPart(this);
		legs.setPivot(0.0F, 24.0F, 0.0F);

		// LEG 1
		leg1 = new ModelPart(this);
		leg1.setPivot(-4.0F, 0.0F, 4.0F);
		legs.addChild(leg1);
		setRotationAngle(leg1, 0.0F, -0.7854F, 0.0F);

		top = new ModelPart(this);
		top.setPivot(0.0F, 0.0F, 0.0F);
		leg1.addChild(top);
		setRotationAngle(top, 0.3491F, 0.0F, 0.0F);
		top.setTextureOffset(0, 115).addCuboid(-0.8787F, -12.9478F, 2.7565F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		bottom = new ModelPart(this);
		bottom.setPivot(0.0F, 0.0F, 0.0F);
		leg1.addChild(bottom);
		bottom.setTextureOffset(0, 115).addCuboid(-0.8787F, -9.0F, 0.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);

		// LEG 2
		leg2 = new ModelPart(this);
		leg2.setPivot(-4.0F, 0.0F, -5.0F);
		legs.addChild(leg2);
		setRotationAngle(leg2, 0.0F, 0.7854F, 0.0F);

		top2 = new ModelPart(this);
		top2.setPivot(0.0F, 0.0F, 0.0F);
		leg2.addChild(top2);
		setRotationAngle(top2, -0.3491F, 0.0F, 0.0F);
		top2.setTextureOffset(0, 115).addCuboid(-1.9393F, -13.2899F, -7.0097F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		bottom2 = new ModelPart(this);
		bottom2.setPivot(0.0F, 0.0F, 0.0F);
		leg2.addChild(bottom2);
		bottom2.setTextureOffset(0, 115).addCuboid(-1.9393F, -9.0F, -4.0607F, 4.0F, 9.0F, 4.0F, 0.0F, false);

		// LEG 3
		leg3 = new ModelPart(this);
		leg3.setPivot(3.0F, 0.0F, 1.0F);
		legs.addChild(leg3);
		setRotationAngle(leg3, 0.0F, 1.5708F, 0.0F);

		top3 = new ModelPart(this);
		top3.setPivot(0.0F, 0.0F, 0.0F);
		leg3.addChild(top3);
		setRotationAngle(top3, 0.3491F, 0.0F, 0.0F);
		top3.setTextureOffset(0, 115).addCuboid(-1.0F, -11.2401F, 8.3062F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		bottom3 = new ModelPart(this);
		bottom3.setPivot(0.0F, 0.0F, 0.0F);
		leg3.addChild(bottom3);
		bottom3.setTextureOffset(0, 115).addCuboid(-1.0F, -9.0F, 6.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);

		// BODY
		body = new ModelPart(this);
		body.setPivot(-1.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 90).addCuboid(-3.375F, -26.0F, -5.5787F, 12.0F, 14.0F, 11.0F, 0.0F, false);

		// NECK
		neck = new ModelPart(this);
		neck.setPivot(9.0F, 12.0F, -3.0F);

		lower_neck = new ModelPart(this);
		lower_neck.setPivot(-2.0F, 3.0F, 0.0F);
		neck.addChild(lower_neck);
		setRotationAngle(lower_neck, 0.0F, 0.0F, 0.2618F);
		lower_neck.setTextureOffset(0, 72).addCuboid(-9.3752F, -26.0735F, 0.5F, 5.0F, 11.0F, 5.0F, 0.0F, false);

		middle_neck = new ModelPart(this);
		middle_neck.setPivot(-0.25F, 0.75F, 0.0F);
		neck.addChild(middle_neck);
		setRotationAngle(middle_neck, 0.0F, 0.0F, 0.0349F);
		middle_neck.setTextureOffset(20, 70).addCuboid(-3.0F, -38.0F, 1.0F, 3.0F, 14.0F, 4.0F, 0.0F, false);

		upper_middle_neck = new ModelPart(this);
		upper_middle_neck.setPivot(-2.3344F, -36.2616F, 2.75F);
		middle_neck.addChild(upper_middle_neck);
		setRotationAngle(upper_middle_neck, 0.0F, 0.0F, -0.6109F);
		upper_middle_neck.setTextureOffset(34, 78).addCuboid(-0.1818F, -6.0274F, -1.75F, 3.0F, 6.0F, 4.0F, 0.0F, false);

		upper_neck = new ModelPart(this);
		upper_neck.setPivot(-2.5F, -41.75F, 1.5F);
		neck.addChild(upper_neck);
		setRotationAngle(upper_neck, 0.0F, 0.0F, -1.1345F);
		upper_neck.setTextureOffset(34, 66).addCuboid(-2.5F, -7.5F, -0.5F, 3.0F, 8.0F, 4.0F, 0.0F, false);

		// HEAD
		head = new ModelPart(this);
		head.setPivot(0.0F, 24.0F, 0.0F);

		back = new ModelPart(this);
		back.setPivot(0.0F, 0.0F, 0.0F);
		head.addChild(back);
		back.setTextureOffset(0, 54).addCuboid(-7.0F, -59.5F, -3.75F, 7.0F, 8.0F, 8.0F, 0.0F, false);

		front = new ModelPart(this);
		front.setPivot(0.0F, 0.0F, 0.0F);
		head.addChild(front);
		front.setTextureOffset(0, 44).addCuboid(-16.25F, -60.25F, -3.25F, 11.0F, 3.0F, 7.0F, 0.0F, false);

		front_bottom_right = new ModelPart(this);
		front_bottom_right.setPivot(-10.75F, -53.75F, -3.75F);
		front.addChild(front_bottom_right);
		setRotationAngle(front_bottom_right, -1.0297F, 0.0F, 0.0F);
		front_bottom_right.setTextureOffset(0, 44).addCuboid(-5.5F, -1.9286F, -3.2425F, 11.0F, 3.0F, 7.0F, 0.0F, false);

		front_bottom_left = new ModelPart(this);
		front_bottom_left.setPivot(-10.75F, -53.4069F, 3.3358F);
		front.addChild(front_bottom_left);
		setRotationAngle(front_bottom_left, 1.0297F, 0.0F, 0.0F);
		front_bottom_left.setTextureOffset(0, 44).addCuboid(-5.5F, -1.2753F, -3.0177F, 11.0F, 3.0F, 7.0F, 0.0F, false);

		tongue = new ModelPart(this);
		tongue.setPivot(0.0F, 0.0F, 0.0F);
		head.addChild(tongue);
		tongue.setTextureOffset(0, 88).addCuboid(-29.75F, -56.25F, -0.25F, 23.0F, 1.0F, 1.0F, 0.0F, false);
		
	}

	public void setRotationAngle(ModelPart part, float x, float y, float z) {
		part.roll = z;
		part.pitch = x;
		part.yaw = y;
	}

    @Override
    public void setAngles(EntityTriffid entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
//		matrices.translate(0, 1.125, 0);

        legs.render(matrices, vertices, light, overlay);

        body.render(matrices, vertices, light, overlay);

        neck.render(matrices, vertices, light, overlay);

        head.render(matrices, vertices, light, overlay);
    }
}