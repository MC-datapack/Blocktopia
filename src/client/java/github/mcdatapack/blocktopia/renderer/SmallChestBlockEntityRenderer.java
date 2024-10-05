package github.mcdatapack.blocktopia.renderer;

import github.mcdatapack.blocktopia.block.SmallChestBlock;
import github.mcdatapack.blocktopia.block.entity.SmallChestBlockEntity;
import github.mcdatapack.blocktopia.models.SmallChestModel;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class SmallChestBlockEntityRenderer implements BlockEntityRenderer<SmallChestBlockEntity> {
    private final SmallChestModel model;

    public SmallChestBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        this.model = new SmallChestModel(context.getLayerModelPart(SmallChestModel.LAYER));
    }

    @Override
    public void render(SmallChestBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.translate(0.5F, 0, 0.5F);
        ModelPart lid = this.model.getLid();
        int defaultAngle = 0;
        int numPlayersOpen = entity.getNumPlayersOpen();
        float lidAngle = entity.getLidAngle();
        double maxAngle = Math.toRadians(110);
        if (numPlayersOpen > 0 && lidAngle < maxAngle) {
            lid.pitch = MathHelper.lerp(tickDelta/8, lidAngle, (float) maxAngle);
        }
        else if (numPlayersOpen == 0 && lidAngle > defaultAngle) {
            lid.pitch = MathHelper.lerp(tickDelta/8, lidAngle, defaultAngle);
        }
        entity.lidAngle = lid.pitch;

        if (entity.getCachedState().get(SmallChestBlock.FACING) == Direction.EAST) {
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(270));
        }
        else if (entity.getCachedState().get(SmallChestBlock.FACING) == Direction.SOUTH) {
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
        }
        else if (entity.getCachedState().get(SmallChestBlock.FACING) == Direction.WEST) {
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90));
        }

        this.model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntitySolid(SmallChestModel.TEXTURE_LOCATION)), light, overlay);
        lid.pitch = defaultAngle;
        matrices.pop();
    }
}
