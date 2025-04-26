package github.mcdatapack.blocktopia.entity.model;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.entity.custom.ToucanEntity;
import github.mcdatapack.blocktopia.entity.renderer.animations.MonkeyAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class ToucanModel extends SinglePartEntityModel<ToucanEntity> {
	public static final EntityModelLayer LAYER = new EntityModelLayer(Blocktopia.id("toucan"), "main");

	private final ModelPart main;
	private final ModelPart feet;
	private final ModelPart left;
	private final ModelPart right;
	private final ModelPart legs;
	private final ModelPart left2;
	private final ModelPart right2;
	private final ModelPart main2;
	private final ModelPart head;
	private final ModelPart wings;
	private final ModelPart left3;
	private final ModelPart right3;
	private final ModelPart tale;

	public ToucanModel(ModelPart root) {
		this.main = root.getChild("main");
		this.feet = this.main.getChild("feet");
		this.left = this.feet.getChild("left");
		this.right = this.feet.getChild("right");
		this.legs = this.main.getChild("legs");
		this.left2 = this.legs.getChild("left2");
		this.right2 = this.legs.getChild("right2");
		this.main2 = this.main.getChild("main2");
		this.head = this.main.getChild("head");
		this.wings = this.main.getChild("wings");
		this.left3 = this.wings.getChild("left3");
		this.right3 = this.wings.getChild("right3");
		this.tale = this.main.getChild("tale");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData feet = main.addChild("feet", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left = feet.addChild("left", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -2.0F));

		ModelPartData cube_r1 = left.addChild("cube_r1", ModelPartBuilder.create().uv(26, 1).cuboid(-1.0F, 1.0F, -1.0F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.375F, -1.0F, 1.1875F, 0.0F, -0.4363F, 0.0F));

		ModelPartData cube_r2 = left.addChild("cube_r2", ModelPartBuilder.create().uv(26, 0).cuboid(-1.0F, 1.0F, -1.0F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.3125F, 0.0F, 0.3491F, 0.0F));

		ModelPartData right = feet.addChild("right", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.8125F));

		ModelPartData cube_r3 = right.addChild("cube_r3", ModelPartBuilder.create().uv(26, 3).cuboid(-1.0F, 1.0F, -1.0F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.375F, -1.0F, 2.1875F, 0.0F, -0.4363F, 0.0F));

		ModelPartData cube_r4 = right.addChild("cube_r4", ModelPartBuilder.create().uv(26, 2).cuboid(-1.0F, 1.0F, -1.0F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 1.3125F, 0.0F, 0.3491F, 0.0F));

		ModelPartData legs = main.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left2 = legs.addChild("left2", ModelPartBuilder.create().uv(10, 22).cuboid(-1.25F, -2.0F, -2.25F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r5 = left2.addChild("cube_r5", ModelPartBuilder.create().uv(10, 25).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.75F, -1.875F, -1.6875F, -0.0873F, 0.0F, 0.0F));

		ModelPartData right2 = legs.addChild("right2", ModelPartBuilder.create().uv(26, 4).cuboid(-1.25F, -2.0F, 0.75F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.8125F));

		ModelPartData cube_r6 = right2.addChild("cube_r6", ModelPartBuilder.create().uv(18, 25).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.75F, -1.875F, 1.3125F, -3.0543F, 0.0F, 3.1416F));

		ModelPartData main2 = main.addChild("main2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r7 = main2.addChild("cube_r7", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -4.0F, -1.0F, 8.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(2.875F, -3.6875F, -1.125F, 0.0F, 0.0F, -0.48F));

		ModelPartData head = main.addChild("head", ModelPartBuilder.create().uv(0, 9).cuboid(1.0625F, -8.875F, -1.625F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(16, 9).cuboid(5.0F, -8.875F, -1.125F, 5.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r8 = head.addChild("cube_r8", ModelPartBuilder.create().uv(0, 22).cuboid(2.0F, -4.0F, -1.0F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(7.9375F, -4.75F, -0.125F, 0.0F, 0.0F, 0.0087F));

		ModelPartData wings = main.addChild("wings", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left3 = wings.addChild("left3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r9 = left3.addChild("cube_r9", ModelPartBuilder.create().uv(16, 16).cuboid(-5.0F, -4.0F, -1.0F, 6.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.8125F, -3.6875F, 3.875F, 0.0F, 0.0F, -0.2531F));

		ModelPartData right3 = wings.addChild("right3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r10 = right3.addChild("cube_r10", ModelPartBuilder.create().uv(0, 17).cuboid(-5.0F, -4.0F, -1.0F, 6.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.8125F, -3.6875F, -2.125F, 0.0F, 0.0F, -0.2531F));

		ModelPartData tale = main.addChild("tale", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r11 = tale.addChild("cube_r11", ModelPartBuilder.create().uv(14, 21).cuboid(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-5.625F, -2.6875F, 0.0F, 0.0F, 0.0F, -0.48F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(ToucanEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
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
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		main.render(matrices, vertexConsumer, light, overlay, color);
	}


	@Override
	public ModelPart getPart() {
		return main;
	}
}