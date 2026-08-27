package github.mcdatapack.blocktopia.entity.renderer;

import github.mcdatapack.blocktopia.entity.ModEntityTypes;
import github.mcdatapack.blocktopia.entity.custom.MonkeyEntity;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.joml.Quaternionf;

public class MonkeySpawnEggRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    @Override
    public void render(ItemStack itemStack, ModelTransformationMode modelTransformationMode, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int i1) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.world == null)
            return;
        MonkeyEntity monkey = new MonkeyEntity(ModEntityTypes.MONKEY, client.world);
        matrixStack.push();
        matrixStack.translate(0.45, 0.15, 0.5);
        matrixStack.multiply(new Quaternionf(0.175, 0.25, 0.0, 0.85));
        client.getEntityRenderDispatcher().render(monkey, 0, 0, 0, 0, 0, matrixStack, vertexConsumerProvider, 255);
        matrixStack.pop();
    }
}
