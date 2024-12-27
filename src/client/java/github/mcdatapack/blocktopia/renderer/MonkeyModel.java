package github.mcdatapack.blocktopia.renderer;

import github.mcdatapack.blocktopia.entity.MonkeyEntity;
import github.mcdatapack.blocktopia.renderer.animations.MonkeyAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class MonkeyModel<T extends MonkeyEntity> extends SinglePartEntityModel<T> {
	private final ModelPart monkey;
	private final ModelPart head;

	public MonkeyModel(ModelPart root) {
		this.monkey = root.getChild("monkey");
		this.head = monkey.getChild("body").getChild("head");
	}

	@SuppressWarnings("unused")
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData monkey = modelPartData.addChild("monkey", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = monkey.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left_front_leg = body.addChild("left_front_leg", ModelPartBuilder.create().uv(34, 42).cuboid(3.0F, -2.0F, -6.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leg = left_front_leg.addChild("leg", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = leg.addChild("cube_r1", ModelPartBuilder.create().uv(26, 33).cuboid(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -7.25F, -4.3375F, 0.0873F, 0.0F, 0.0F));

		ModelPartData cube_r2 = leg.addChild("cube_r2", ModelPartBuilder.create().uv(40, 9).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -2.25F, -5.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData left_back_leg = body.addChild("left_back_leg", ModelPartBuilder.create().uv(0, 38).cuboid(3.0F, -2.0F, 2.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 0.0F, 0.0F));

		ModelPartData leg3 = left_back_leg.addChild("leg3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r3 = leg3.addChild("cube_r3", ModelPartBuilder.create().uv(26, 13).cuboid(-2.0F, -6.0F, -1.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(4.375F, -7.0F, 2.1875F, -0.2182F, 0.0F, 0.0F));

		ModelPartData cube_r4 = leg3.addChild("cube_r4", ModelPartBuilder.create().uv(40, 25).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -2.1875F, 3.4375F, 0.3491F, 0.0F, 0.0F));

		ModelPartData right_front_leg = body.addChild("right_front_leg", ModelPartBuilder.create().uv(0, 44).cuboid(4.0F, -2.0F, -6.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-11.0F, 0.0F, 0.0F));

		ModelPartData leg2 = right_front_leg.addChild("leg2", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 0.0F, 0.0F));

		ModelPartData cube_r5 = leg2.addChild("cube_r5", ModelPartBuilder.create().uv(36, 33).cuboid(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -7.25F, -4.3375F, 0.0873F, 0.0F, 0.0F));

		ModelPartData cube_r6 = leg2.addChild("cube_r6", ModelPartBuilder.create().uv(40, 17).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -2.25F, -5.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData right_back_leg = body.addChild("right_back_leg", ModelPartBuilder.create().uv(12, 38).cuboid(5.0F, -2.0F, 2.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-11.0F, 0.0F, 0.0F));

		ModelPartData leg4 = right_back_leg.addChild("leg4", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 0.0F, 0.0F));

		ModelPartData cube_r7 = leg4.addChild("cube_r7", ModelPartBuilder.create().uv(26, 23).cuboid(-2.0F, -6.0F, -1.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(4.375F, -7.0F, 2.1875F, -0.2182F, 0.0F, 0.0F));

		ModelPartData cube_r8 = leg4.addChild("cube_r8", ModelPartBuilder.create().uv(24, 42).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -2.1875F, 3.4375F, 0.3491F, 0.0F, 0.0F));

		ModelPartData main = body.addChild("main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r9 = main.addChild("cube_r9", ModelPartBuilder.create().uv(0, 26).cuboid(-5.0F, -2.0F, -1.0F, 7.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.4375F, -12.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData cube_r10 = main.addChild("cube_r10", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -3.0F, -1.0F, 8.0F, 6.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -11.0F, -7.0F, 0.0436F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 13).cuboid(-4.0F, -17.0F, -11.0F, 7.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData mouth = head.addChild("mouth", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData top = mouth.addChild("top", ModelPartBuilder.create().uv(30, 0).cuboid(-3.0F, -14.0F, -13.0F, 5.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bottom = mouth.addChild("bottom", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r11 = bottom.addChild("cube_r11", ModelPartBuilder.create().uv(30, 5).cuboid(-3.0F, 0.0F, -2.0F, 5.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -12.0F, -11.0F, 0.3491F, 0.0F, 0.0F));

		ModelPartData tale = body.addChild("tale", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r12 = tale.addChild("cube_r12", ModelPartBuilder.create().uv(46, 0).cuboid(0.0F, -1.0F, -4.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -2.4375F, 12.5625F, -0.9163F, 0.0F, 0.0F));

		ModelPartData cube_r13 = tale.addChild("cube_r13", ModelPartBuilder.create().uv(44, 42).cuboid(0.0F, -1.0F, -4.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -5.0625F, 10.25F, -1.2654F, 0.0F, 0.0F));

		ModelPartData cube_r14 = tale.addChild("cube_r14", ModelPartBuilder.create().uv(10, 44).cuboid(0.0F, -1.0F, -4.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -8.1875F, 10.0F, -0.7854F, 0.0F, 0.0F));

		ModelPartData cube_r15 = tale.addChild("cube_r15", ModelPartBuilder.create().uv(30, 9).cuboid(0.0F, -1.0F, -4.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -10.5F, 8.0F, -0.3054F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);

		this.animateMovement(MonkeyAnimations.MONKEY_WALK, limbAngle, limbDistance, 2, 2.5F);
		this.updateAnimation(entity.idleAnimationState, MonkeyAnimations.MONKEY_IDLE, animationProgress, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
		monkey.render(matrices, vertices, light, overlay, color);
	}


	@Override
	public ModelPart getPart() {
		return monkey;
	}
}