package github.mcdatapack.blocktopia.block.entity.model;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class DuperModel extends EntityModel<Entity> {
    public static final EntityModelLayer LAYER = new EntityModelLayer(Blocktopia.id("duper"), "main");
    public static final Identifier TEXTURE_LOCATION = Blocktopia.id("textures/entity/duper.png");
    private final ModelPart main;

    public DuperModel(ModelPart root) {
        this.main = root.getChild("main");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, 9.0F, -8.0F, 16.0F, 5.0F, 16.0F, new Dilation(0.0F))
                .uv(64, 18).cuboid(-8.0F, -2.0F, -8.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F))
                .uv(64, 30).cuboid(-8.0F, -2.0F, 4.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F))
                .uv(64, 42).cuboid(4.0F, -2.0F, -8.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F))
                .uv(44, 65).cuboid(4.0F, -2.0F, 4.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F))
                .uv(40, 21).cuboid(-8.0F, -2.0F, -4.0F, 4.0F, 2.0F, 8.0F, new Dilation(0.0F))
                .uv(40, 31).cuboid(4.0F, -2.0F, -4.0F, 4.0F, 2.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 21).cuboid(-8.0F, 6.0F, -8.0F, 4.0F, 3.0F, 16.0F, new Dilation(0.0F))
                .uv(0, 40).cuboid(4.0F, 6.0F, -8.0F, 4.0F, 3.0F, 16.0F, new Dilation(0.0F))
                .uv(64, 4).cuboid(-4.0F, 6.0F, -8.0F, 8.0F, 3.0F, 4.0F, new Dilation(0.0F))
                .uv(64, 11).cuboid(-4.0F, 6.0F, 4.0F, 8.0F, 3.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 59).cuboid(4.0F, -4.0F, -5.0F, 1.0F, 2.0F, 10.0F, new Dilation(0.0F))
                .uv(22, 61).cuboid(-5.0F, -4.0F, -5.0F, 1.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 10.0F, 0.0F));

        ModelPartData cube_r1 = main.addChild("cube_r1", ModelPartBuilder.create().uv(0, 71).cuboid(-1.0F, -2.0F, -9.0F, 1.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -2.0F, -5.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData cube_r2 = main.addChild("cube_r2", ModelPartBuilder.create().uv(60, 65).cuboid(-1.0F, -2.0F, -9.0F, 1.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -2.0F, 4.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData cube_r3 = main.addChild("cube_r3", ModelPartBuilder.create().uv(64, 0).cuboid(-6.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData cube_r4 = main.addChild("cube_r4", ModelPartBuilder.create().uv(44, 61).cuboid(-6.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        ModelPartData cube_r5 = main.addChild("cube_r5", ModelPartBuilder.create().uv(40, 51).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, 7.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData cube_r6 = main.addChild("cube_r6", ModelPartBuilder.create().uv(40, 41).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, -5.0F, 0.0F, 1.5708F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        main.render(matrices, vertexConsumer, light, overlay, color);
    }
}