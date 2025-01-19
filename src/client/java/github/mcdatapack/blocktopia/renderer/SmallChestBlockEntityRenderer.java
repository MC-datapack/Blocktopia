package github.mcdatapack.blocktopia.renderer;

import github.mcdatapack.blocktopia.block.SmallChestBlock;
import github.mcdatapack.blocktopia.block.entity.SmallChestBlockEntity;
import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.models.SmallChestModel;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SmallChestBlockEntityRenderer implements BlockEntityRenderer<SmallChestBlockEntity> {
    private static final List<ItemTransformation> TRANSFORMATIONS = new ArrayList<>();

    static {
        Random random = ThreadLocalRandom.current();
        for (int index = 0; index < 36; index++) {
            TRANSFORMATIONS.add(new ItemTransformation(
                    (random.nextDouble() - 0.5) * 0.4375,
                    (random.nextDouble() - 0.5) * 0.4375,
                    random.nextInt(360))
            );
        }
    }

    private final BlockEntityRendererFactory.Context context;
    private final SmallChestModel model;

    public SmallChestBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        this.context = context;
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
            lid.pitch = MathHelper.lerp(tickDelta/BlocktopiaConfig.getConfig().smallChestConfig.closingSpeed, lidAngle, (float) maxAngle);
        }
        else if (numPlayersOpen == 0 && lidAngle > defaultAngle) {
            lid.pitch = MathHelper.lerp(tickDelta/BlocktopiaConfig.getConfig().smallChestConfig.closingSpeed, lidAngle, defaultAngle);
        }
        entity.lidAngle = lid.pitch;

        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(switch (entity.getCachedState().get(SmallChestBlock.FACING)) {
            case EAST -> 270;
            case SOUTH -> 180;
            case WEST -> 90;
            default -> 0;
        }));



        if (BlocktopiaConfig.getConfig().smallChestConfig.renderItems) {
            if (entity.lidAngle > 0.1) {
                SimpleInventory inventory = entity.getInventory();
                World world = entity.getWorld();

                for (int i = 0; i < inventory.getHeldStacks().size(); i++) {
                    ItemStack stack = inventory.getStack(i);
                    if (stack.isEmpty()) continue;

                    ItemTransformation transformation = TRANSFORMATIONS.get(i);

                    matrices.push();
                    matrices.translate(transformation.x(), 0.5, transformation.z());
                    matrices.scale(0.325F, 0.325F, 0.325F);
                    matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(transformation.rotation()));

                    this.context.getItemRenderer().renderItem(stack, ModelTransformationMode.FIXED,
                            light, overlay,
                            matrices, vertexConsumers,
                            world, 0);

                    matrices.pop();
                }
            }
        }

        this.model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntitySolid(SmallChestModel.TEXTURE_LOCATION)), light, overlay);
        lid.pitch = defaultAngle;
        matrices.pop();
    }
    public record ItemTransformation(double x, double z, int rotation) {}
}
