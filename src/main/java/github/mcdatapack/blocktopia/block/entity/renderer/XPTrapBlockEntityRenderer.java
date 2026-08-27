package github.mcdatapack.blocktopia.block.entity.renderer;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.entity.custom.XPTrapBlockEntity;
import github.mcdatapack.blocktopia.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.FluidRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.World;

public class XPTrapBlockEntityRenderer implements BlockEntityRenderer<XPTrapBlockEntity> {

    private static final Identifier DEFAULT_TEXTURE = Blocktopia.id("textures/block/xp_trap.png");

    public XPTrapBlockEntityRenderer(BlockEntityRendererFactory.Context context) {}

    @Override
    public void render(XPTrapBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockPos pos = blockEntity.getPos();
        BlockState copiedBlockState = blockEntity.getCopiedBlockState();

        matrices.push();
        BlockRenderManager blockRenderManager = MinecraftClient.getInstance().getBlockRenderManager();

        if (copiedBlockState != null) {
            RenderLayer renderLayer = RenderLayers.getBlockLayer(copiedBlockState);
            renderBlock(copiedBlockState, pos, blockEntity.getWorld(), matrices, vertexConsumers, blockRenderManager, renderLayer, light, overlay);
        } else {
            RenderLayer renderLayer = RenderLayer.getSolid();
            renderDefaultBlock(pos, blockEntity.getWorld(), matrices, vertexConsumers, blockRenderManager, renderLayer, light, overlay);
        }
        matrices.pop();
    }

    private void renderBlock(BlockState state, BlockPos pos, BlockRenderView world, MatrixStack matrices, VertexConsumerProvider vertexConsumers, BlockRenderManager blockRenderManager, RenderLayer renderLayer, int light, int overlay) {
        blockRenderManager.renderBlock(state, pos, world, matrices, vertexConsumers.getBuffer(renderLayer), false, Random.create());
    }

    private void renderDefaultBlock(BlockPos pos, World world, MatrixStack matrices, VertexConsumerProvider vertexConsumers, BlockRenderManager blockRenderManager, RenderLayer renderLayer, int light, int overlay) {
        MinecraftClient.getInstance().getTextureManager().getTexture(DEFAULT_TEXTURE);
        BlockState defaultState = ModBlocks.XP_TRAP.getDefaultState();
        blockRenderManager.renderBlock(defaultState, pos, world, matrices, vertexConsumers.getBuffer(renderLayer), false, Random.create());
    }
}
