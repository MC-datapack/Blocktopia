package github.mcdatapack.blocktopia.entity.renderer;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.entity.custom.MonkeyEntity;
import github.mcdatapack.blocktopia.entity.custom.ToucanEntity;
import github.mcdatapack.blocktopia.entity.model.MonkeyModel;
import github.mcdatapack.blocktopia.entity.model.ToucanModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ToucanRenderer extends MobEntityRenderer<ToucanEntity, ToucanModel> {
    private static final Identifier TEXTURE = Blocktopia.id("textures/entity/toucan.png");

    public ToucanRenderer(EntityRendererFactory.Context context) {
        super(context, new ToucanModel(context.getPart(ToucanModel.LAYER)), 0.6F);
    }

    @Override
    public Identifier getTexture(ToucanEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(ToucanEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5F, 0.5F, 0.5F);
        } else {
            matrixStack.scale(1, 1, 1);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
