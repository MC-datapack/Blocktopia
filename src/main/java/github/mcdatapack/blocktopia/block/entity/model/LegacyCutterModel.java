package github.mcdatapack.blocktopia.block.entity.model;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class LegacyCutterModel extends Model {
	public static final EntityModelLayer LAYER = new EntityModelLayer(Blocktopia.id("legacy_cutter"), "main");
	public static final Identifier TEXTURE_LOCATION = Blocktopia.id("textures/entity/legacy_cutter.png");

	private final ModelPart main;

	public LegacyCutterModel(ModelPart root) {
        super(RenderLayer::getEntitySolid);
        this.main = root.getChild("main");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -5.0F, -8.0F, 16.0F, 5.0F, 16.0F, new Dilation(0.0F))
				.uv(0, 21).cuboid(-7.0F, -6.0F, -7.0F, 14.0F, 1.0F, 14.0F, new Dilation(0.0F))
				.uv(0, 36).cuboid(-6.0F, -7.0F, -6.0F, 12.0F, 1.0F, 12.0F, new Dilation(0.0F))
				.uv(48, 36).cuboid(3.0F, -11.0F, -5.0F, 2.0F, 4.0F, 10.0F, new Dilation(0.0F))
				.uv(0, 49).cuboid(-5.0F, -11.0F, -5.0F, 2.0F, 4.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r1 = main.addChild("cube_r1", ModelPartBuilder.create().uv(52, 54).cuboid(-1.0F, -11.0F, -7.0F, 2.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, -4.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData cube_r2 = main.addChild("cube_r2", ModelPartBuilder.create().uv(28, 53).cuboid(-1.0F, -11.0F, -7.0F, 2.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, 4.0F, 0.0F, -1.5708F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
		main.render(matrices, vertices, light, overlay, color);
	}
}