package github.mcdatapack.blocktopia.sign.impl.client.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import github.mcdatapack.blocktopia.sign.api.BlocktopiaSign;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2625;
import net.minecraft.class_3879;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4719;
import net.minecraft.class_4722;
import net.minecraft.class_4730;
import net.minecraft.class_837;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_837.class)
@Environment(EnvType.CLIENT)
public abstract class MixinSignBlockEntityRenderer {
    @Unique
    protected class_2625 blocktopia$renderedBlockEntity;

    @WrapOperation(
            method = "render(Lnet/minecraft/block/entity/SignBlockEntity;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/block/BlockState;Lnet/minecraft/block/AbstractSignBlock;Lnet/minecraft/block/WoodType;Lnet/minecraft/client/model/Model;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/block/entity/SignBlockEntityRenderer;renderSign(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/block/WoodType;Lnet/minecraft/client/model/Model;)V")
    )
    @SuppressWarnings("unused")
    private void blocktopiaWood$setRenderedBlockEntity(class_837 instance, class_4587 matrices,
                                                      class_4597 verticesProvider, int light, int overlay,
                                                      class_4719 type, class_3879 model, Operation<Void> original, class_2625 signBlockEntity) {
        this.blocktopia$renderedBlockEntity = signBlockEntity;
        original.call(instance, matrices, verticesProvider, light, overlay, type, model);
        this.blocktopia$renderedBlockEntity = null;
    }

    @Inject(method = "getTextureId", at = @At("HEAD"), cancellable = true)
    private void blocktopiaWood$rendererSignTextureId(CallbackInfoReturnable<class_4730> cir) {
        if (this.blocktopia$renderedBlockEntity != null) {
            if (this.blocktopia$renderedBlockEntity.method_11010().method_26204() instanceof BlocktopiaSign signBlock) {
                cir.setReturnValue(new class_4730(class_4722.field_21708, signBlock.getTexture()));
            }
        }
    }
}
