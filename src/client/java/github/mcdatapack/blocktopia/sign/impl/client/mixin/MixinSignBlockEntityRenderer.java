package github.mcdatapack.blocktopia.sign.impl.client.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import github.mcdatapack.blocktopia.sign.api.BlocktopiaSign;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SignBlockEntityRenderer.class)
@Environment(EnvType.CLIENT)
public abstract class MixinSignBlockEntityRenderer {
    @Unique
    protected SignBlockEntity blocktopia$renderedBlockEntity;

    @WrapOperation(
            method = "render(Lnet/minecraft/block/entity/SignBlockEntity;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/block/BlockState;Lnet/minecraft/block/AbstractSignBlock;Lnet/minecraft/block/WoodType;Lnet/minecraft/client/model/Model;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/block/entity/SignBlockEntityRenderer;renderSign(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/block/WoodType;Lnet/minecraft/client/model/Model;)V")
    )
    @SuppressWarnings("unused")
    private void blocktopiaWood$setRenderedBlockEntity(SignBlockEntityRenderer instance, MatrixStack matrices,
                                                      VertexConsumerProvider verticesProvider, int light, int overlay,
                                                      WoodType type, Model model, Operation<Void> original, SignBlockEntity signBlockEntity) {
        this.blocktopia$renderedBlockEntity = signBlockEntity;
        original.call(instance, matrices, verticesProvider, light, overlay, type, model);
        this.blocktopia$renderedBlockEntity = null;
    }

    @Inject(method = "getTextureId", at = @At("HEAD"), cancellable = true)
    private void blocktopiaWood$rendererSignTextureId(CallbackInfoReturnable<SpriteIdentifier> cir) {
        if (this.blocktopia$renderedBlockEntity != null) {
            if (this.blocktopia$renderedBlockEntity.getCachedState().getBlock() instanceof BlocktopiaSign signBlock) {
                cir.setReturnValue(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, signBlock.getTexture()));
            }
        }
    }
}
