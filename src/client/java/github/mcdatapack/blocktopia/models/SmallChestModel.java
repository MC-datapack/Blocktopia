package github.mcdatapack.blocktopia.models;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SmallChestModel extends Model {
	public static final EntityModelLayer LAYER = new EntityModelLayer(Blocktopia.id("small_chest"), "main");
	public static final Identifier TEXTURE_LOCATION = Blocktopia.id("textures/entity/small_chest.png");

	public final ModelPart main;
	public final ModelPart lid;

	public SmallChestModel(ModelPart root) {
        super(RenderLayer::getEntitySolid);
        this.main = root.getChild("main");
		this.lid = this.main.getChild("lid");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create()
				.uv(37, 0)
				.cuboid(-6.0F, -3.5F, -6.0F, 12.0F, 8.0F, 1.0F,
						new Dilation(0.0F))
				.uv(36, 30)
				.cuboid(-6.0F, -3.5F, 5.0F, 12.0F, 8.0F, 1.0F,
						new Dilation(0.0F))
				.uv(23, 30)
				.cuboid(5.0F, -3.5F, -5.0F, 1.0F, 8.0F, 10.0F,
						new Dilation(0.0F))
				.uv(0, 30)
				.cuboid(-6.0F, -3.5F, -5.0F, 1.0F, 8.0F, 10.0F,
						new Dilation(0.0F))
				.uv(0, 16)
				.cuboid(-6.0F, -4.5F, -6.0F, 12.0F, 1.0F, 12.0F,
						new Dilation(0.0F)),
				ModelTransform.pivot(0.0F, 4.5F, 0.0F));

		ModelPartData lid = main.addChild("lid", ModelPartBuilder.create()
				.uv(0, 0)
				.cuboid(-6.0F, 0.0F, -12.0F, 12.0F, 3.0F, 12.0F,
						new Dilation(0.0F))
				.uv(0, 0)
				.cuboid(-1.0F, -1.0F, -13.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F)),
				ModelTransform.of(0.0F, 4.5F, 6.0F, 0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		this.main.render(matrices, vertexConsumer, light, overlay, color);
	}

	public ModelPart getLid() {
		return this.lid;
	}
}