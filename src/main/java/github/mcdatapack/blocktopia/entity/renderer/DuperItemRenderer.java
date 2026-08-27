package github.mcdatapack.blocktopia.entity.renderer;

import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.block.entity.ModBlockEntityTypes;
import github.mcdatapack.blocktopia.entity.ModEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.joml.Quaternionf;

public class DuperItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    @Override
    public void render(ItemStack itemStack, ModelTransformationMode modelTransformationMode, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int i1) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.world == null)
            return;
        BlockPos pos = new BlockPos(0, 0, 0);
        BlockState state = ModBlocks.DUPER.getDefaultState();
        BlockEntity entity = ModBlockEntityTypes.DUPER.instantiate(pos, state);
        matrixStack.push();
        matrixStack.translate(0.04, 0.25, 0.25);
        matrixStack.multiply(new Quaternionf(0.175, 0.25, 0.05, 0.75));
        BlockEntityRenderDispatcher manager = client.getBlockEntityRenderDispatcher();
        manager.renderEntity(entity, matrixStack, vertexConsumerProvider, i, i1);
        matrixStack.pop();
    }
}
