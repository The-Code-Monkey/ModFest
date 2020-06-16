package net.astrum.client.entity.model;

import net.astrum.common.entity.EntityTriffid;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class ModelTriffid extends EntityModel<EntityTriffid>  {
	private final ModelPart model;
	private final ModelPart legs;
	private final ModelPart front_right_leg;
	private final ModelPart front_right_leg_top;
	private final ModelPart front_right_leg_bottom;
	private final ModelPart front_left_leg;
	private final ModelPart front_left_leg_top;
	private final ModelPart front_left_leg_bottom;
	private final ModelPart rear_leg;
	private final ModelPart rear_leg_top;
	private final ModelPart rear_leg_bottom;
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

	private float pitch;
	private double animation;
	private long preTime;
	private float maxAngle = 0.1F;
	public float leaningPitch;

	public ModelTriffid() {
		textureWidth = 128;
		textureHeight = 128;

		model = new ModelPart(this);
		model.yaw = -1.575F;

		// LEGS
		legs = new ModelPart(this);
		legs.setPivot(0.0F, 24.0F, 0.0F);
		model.addChild(legs);

		// LEG 1
		front_right_leg = new ModelPart(this);
		front_right_leg.setPivot(-4.0F, 0.0F, 4.0F);
		legs.addChild(front_right_leg);
		setRotationAngle(front_right_leg, 0.0F, -0.7854F, 0.0F);

		front_right_leg_top = new ModelPart(this);
		front_right_leg_top.setPivot(0.0F, 0.0F, 0.0F);
		front_right_leg.addChild(front_right_leg_top);
		setRotationAngle(front_right_leg_top, 0.3491F, 0.0F, 0.0F);
		front_right_leg_top.setTextureOffset(0, 115).addCuboid(-0.8787F, -12.9478F, 2.7565F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		front_right_leg_bottom = new ModelPart(this);
		front_right_leg_bottom.setPivot(0.0F, 0.0F, 0.0F);
		front_right_leg.addChild(front_right_leg_bottom);
		front_right_leg_bottom.setTextureOffset(0, 115).addCuboid(-0.8787F, -9.0F, 0.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);

		// LEG 2
		front_left_leg = new ModelPart(this);
		front_left_leg.setPivot(-4.0F, 0.0F, -5.0F);
		legs.addChild(front_left_leg);
		setRotationAngle(front_left_leg, 0.0F, 0.7854F, 0.0F);

		front_left_leg_top = new ModelPart(this);
		front_left_leg_top.setPivot(0.0F, 0.0F, 0.0F);
		front_left_leg.addChild(front_left_leg_top);
		setRotationAngle(front_left_leg_top, -0.3491F, 0.0F, 0.0F);
		front_left_leg_top.setTextureOffset(0, 115).addCuboid(-1.9393F, -13.2899F, -7.0097F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		front_left_leg_bottom = new ModelPart(this);
		front_left_leg_bottom.setPivot(0.0F, 0.0F, 0.0F);
		front_left_leg.addChild(front_left_leg_bottom);
		front_left_leg_bottom.setTextureOffset(0, 115).addCuboid(-1.9393F, -9.0F, -4.0607F, 4.0F, 9.0F, 4.0F, 0.0F, false);

		// LEG 3
		rear_leg = new ModelPart(this);
		rear_leg.setPivot(3.0F, 0.0F, 1.0F);
		legs.addChild(rear_leg);
		setRotationAngle(rear_leg, 0.0F, 1.5708F, 0.0F);

		rear_leg_top = new ModelPart(this);
		rear_leg_top.setPivot(0.0F, 0.0F, 0.0F);
		rear_leg.addChild(rear_leg_top);
		setRotationAngle(rear_leg_top, 0.3491F, 0.0F, 0.0F);
		rear_leg_top.setTextureOffset(0, 115).addCuboid(-1.0F, -11.2401F, 8.3062F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		rear_leg_bottom = new ModelPart(this);
		rear_leg_bottom.setPivot(0.0F, 0.0F, 0.0F);
		rear_leg.addChild(rear_leg_bottom);
		rear_leg_bottom.setTextureOffset(0, 115).addCuboid(-1.0F, -9.0F, 6.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);

		// BODY
		body = new ModelPart(this);
		body.setPivot(-1.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 90).addCuboid(-3.375F, -26.0F, -5.5787F, 12.0F, 14.0F, 11.0F, 0.0F, false);
		model.addChild(body);

		// NECK
		neck = new ModelPart(this);
		neck.setPivot(9.0F, 12.0F, -3.0F);
		model.addChild(neck);

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
		head.setPivot(0.0F, -31.0F, 0.0F);
		model.addChild(head);

		back = new ModelPart(this);
		back.setPivot(0.0F, 55.0F, 0.0F);
		head.addChild(back);
		back.setTextureOffset(0, 54).addCuboid(-8.0F, -63.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		front = new ModelPart(this);
		front.setPivot(0.0F, 0.0F, 0.0F);
		head.addChild(front);
		front.setTextureOffset(0, 44).addCuboid(-16.25F, -9.5F, -3.25F, 11.0F, 3.0F, 7.0F, 0.0F, false);

		front_bottom_right = new ModelPart(this);
		front_bottom_right.setPivot(-10.75F, 0.0F, -3.75F);
		front.addChild(front_bottom_right);
		setRotationAngle(front_bottom_right, -1.0297F, 0.0F, 0.0F);
		front_bottom_right.setTextureOffset(0, 44).addCuboid(-5.36F, -2.7286F, -5.7425F, 11.0F, 3.0F, 7.0F, 0.0F, false);

		front_bottom_left = new ModelPart(this);
		front_bottom_left.setPivot(-10.75F, 0.0F, 3.3358F);
		front.addChild(front_bottom_left);
		setRotationAngle(front_bottom_left, 1.0297F, 0.0F, 0.0F);
		front_bottom_left.setTextureOffset(0, 44).addCuboid(-5.3F, -2.3753F, -1.9177F, 11.0F, 3.0F, 7.0F, 0.0F, false);

		tongue = new ModelPart(this);
		tongue.setPivot(0.0F, 0.0F, 0.0F);
		head.addChild(tongue);
		tongue.setTextureOffset(0, 88).addCuboid(-29.75F, -4.5F, -0.25F, 23.0F, 1.0F, 1.0F, 0.0F, false);
		
	}

	public void setRotationAngle(ModelPart part, float x, float y, float z) {
		part.roll = z;
		part.pitch = x;
		part.yaw = y;
	}

	@Override
	public void animateModel(EntityTriffid entity, float f, float g, float h) {
	}

	@Override
	public void setAngles(EntityTriffid entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		boolean rollTooBig = entity.getRoll() > 4;
		boolean isSwimming = entity.isSwimming();

		this.head.yaw = headYaw * 0.017453292F;
		this.head.roll = headPitch * -0.017453292F;
		if (rollTooBig) {
			this.head.pitch = -0.7853982F;
		} else if (this.leaningPitch > 0.0F) {
			if (isSwimming) {
				this.head.pitch = this.lerpAngle(this.head.pitch, -0.7853982F, this.leaningPitch);
			} else {
				this.head.pitch = this.lerpAngle(this.head.pitch, headPitch * 0.017453292F, this.leaningPitch);
			}
		}

		this.body.yaw = 0.0F;
		this.rear_leg.pivotZ = 0.0F;
		this.rear_leg.pivotX = -0.5F;

		float k = 1.0F;
		if (rollTooBig) {
			k = (float)entity.getVelocity().lengthSquared();
			k /= 0.2F;
			k *= k * k;
		}

		if (k < 1.0F) {
			k = 1.0F;
		}
	}

	protected float lerpAngle(float from, float to, float position)
	{
		float angle = (to - from) % 6.2831855F;

		if (angle < -3.1415927F)
		{
			angle += 6.2831855F;
		}

		if (angle >= 3.1415927F)
		{
			angle -= 6.2831855F;
		}

		return from + position * angle;
	}

	@Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
//		matrices.translate(0, 1.125, 0);

		model.render(matrices, vertices, light, overlay);

//        legs.render(matrices, vertices, light, overlay);
//
//        body.render(matrices, vertices, light, overlay);
//
//        neck.render(matrices, vertices, light, overlay);
//
//        head.render(matrices, vertices, light, overlay);
    }
}
