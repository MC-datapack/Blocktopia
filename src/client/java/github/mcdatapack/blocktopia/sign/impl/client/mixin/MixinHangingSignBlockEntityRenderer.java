package github.mcdatapack.blocktopia.sign.impl.client.mixin;

import github.mcdatapack.blocktopia.sign.api.BlocktopiaSign;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HangingSignBlockEntityRenderer.class)
@Environment(EnvType.CLIENT)
public abstract class MixinHangingSignBlockEntityRenderer extends MixinSignBlockEntityRenderer {
    @Inject(method = "getTextureId", at = @At("HEAD"), cancellable = true)
    private void blocktopiaWood$getHangingSignTextureId(CallbackInfoReturnable<SpriteIdentifier> cir) {
        if (this.blocktopia$renderedBlockEntity != null) {
            if (this.blocktopia$renderedBlockEntity.getCachedState().getBlock() instanceof BlocktopiaSign signBlock) {
                cir.setReturnValue(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, signBlock.getTexture()));
            }
        }
    }
}
