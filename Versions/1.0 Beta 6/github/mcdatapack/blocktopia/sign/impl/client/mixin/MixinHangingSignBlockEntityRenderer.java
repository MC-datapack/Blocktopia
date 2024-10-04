package github.mcdatapack.blocktopia.sign.impl.client.mixin;

import github.mcdatapack.blocktopia.sign.api.BlocktopiaSign;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_4722;
import net.minecraft.class_4730;
import net.minecraft.class_7761;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_7761.class)
@Environment(EnvType.CLIENT)
public abstract class MixinHangingSignBlockEntityRenderer extends MixinSignBlockEntityRenderer {
    @Inject(method = "getTextureId", at = @At("HEAD"), cancellable = true)
    private void blocktopiaWood$getHangingSignTextureId(CallbackInfoReturnable<class_4730> cir) {
        if (this.blocktopia$renderedBlockEntity != null) {
            if (this.blocktopia$renderedBlockEntity.method_11010().method_26204() instanceof BlocktopiaSign signBlock) {
                cir.setReturnValue(new class_4730(class_4722.field_21708, signBlock.getTexture()));
            }
        }
    }
}
