package github.mcdatapack.blocktopia.renderer;

import github.mcdatapack.blocktopia.entity.MonkeyEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.util.Map;

public class MonkeyRenderer extends MobEntityRenderer<MonkeyEntity, MonkeyModel<MonkeyEntity>> {
    private static final Map<MonkeyEntity.Variants, Identifier> TEXTURE = MonkeyEntity.Variants.textures();

    public MonkeyRenderer(EntityRendererFactory.Context context) {
        super(context, new MonkeyModel<>(context.getPart(ModelLayerInit.MONKEY)), 0.6F);
    }

    @Override
    public Identifier getTexture(MonkeyEntity entity) {
        return TEXTURE.get(entity.getVariant());
    }

    @Override
    public void render(MonkeyEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5F, 0.5F, 0.5F);
        } else {
            matrixStack.scale(1, 1, 1);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
