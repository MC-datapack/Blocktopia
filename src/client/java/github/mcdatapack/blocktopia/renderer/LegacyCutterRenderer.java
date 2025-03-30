package github.mcdatapack.blocktopia.renderer;

import github.mcdatapack.blocktopia.block.entity.LegacyCutterBlockEntity;
import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.models.LegacyCutterModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LegacyCutterRenderer implements BlockEntityRenderer<LegacyCutterBlockEntity> {
    private static List<ItemTransformation> TRANSFORMATIONS = new ArrayList<>();

    static {
        Random random = ThreadLocalRandom.current();
        for (int index = 0; index < 2; index++) {
            TRANSFORMATIONS.add(new ItemTransformation(
                    (random.nextDouble() - 0.5) * 0.1375,
                    (random.nextDouble() - 0.5) * 0.1375,
                    random.nextInt(360))
            );
        }
    }

    private final BlockEntityRendererFactory.Context context;
    private final LegacyCutterModel model;

    public LegacyCutterRenderer(BlockEntityRendererFactory.Context context) {
        this.context = context;
        this.model = new LegacyCutterModel(context.getLayerModelPart(LegacyCutterModel.LAYER));
    }

    @Override
    public void render(LegacyCutterBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.translate(0.5F, 1.5, 0.5F);

        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180));
        
        if (BlocktopiaConfig.getConfig().legacyCutterClientConfig.renderItems) {
            World world = entity.getWorld();
            for (int i = 0; i < entity.size(); i++) {
                ItemStack stack = entity.getStack(i);
                if (stack.isEmpty()) continue;

                ItemTransformation transformation = switch (i) {
                    case 0 -> new ItemTransformation(0.01375, 0.1375, 0);
                    case 1 -> new ItemTransformation(-0.01375, -0.1375, 0);
                    default -> null;
                };
                matrices.push();
                matrices.translate(transformation.x(), 0.8, transformation.z());
                matrices.scale(0.2325F, 0.20325F, 0.2325F);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(transformation.rotation()));

                this.context.getItemRenderer().renderItem(stack, ModelTransformationMode.FIXED,
                        light, overlay,
                        matrices, vertexConsumers,
                        world, 0);
                matrices.pop();
            }
        }

        this.model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntitySolid(LegacyCutterModel.TEXTURE_LOCATION)), light, overlay);
        matrices.pop();
    }

    public record ItemTransformation(double x, double z, int rotation) {}
}
