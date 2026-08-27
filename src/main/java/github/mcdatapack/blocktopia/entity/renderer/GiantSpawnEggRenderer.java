package github.mcdatapack.blocktopia.entity.renderer;

import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.GiantEntity;
import net.minecraft.item.ItemStack;
import org.joml.Quaternionf;

public class GiantSpawnEggRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    @Override
    public void render(ItemStack itemStack, ModelTransformationMode modelTransformationMode, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int i1) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.world == null)
            return;
        GiantEntity giant = new GiantEntity(EntityType.GIANT, client.world);
        matrixStack.push();
        matrixStack.translate(0.5, 0.0, 0.5);
        matrixStack.multiply(new Quaternionf(0.0, 0.075, 0, 0.275));
        client.getEntityRenderDispatcher().render(giant, 0, 0, 0, 0, 0, matrixStack, vertexConsumerProvider, 255);
        matrixStack.pop();
    }
}
