package github.mcdatapack.blocktopia.sign.impl.client.mixin;

import github.mcdatapack.blocktopia.sign.api.BlocktopiaHangingSign;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2625;
import net.minecraft.class_2960;
import net.minecraft.class_7744;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_7744.class)
@Environment(EnvType.CLIENT)
public class MixinHangingSignEditScreen {
    @Shadow
    @Final
    @Mutable
    private class_2960 texture;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void blocktopiaWood$initSignTextureId(class_2625 signBlockEntity, boolean front, boolean filtered, CallbackInfo ci) {
        if (signBlockEntity.method_11010().method_26204() instanceof BlocktopiaHangingSign signBlock) {
            class_2960 guiTexture = signBlock.getGuiTexture();
            this.texture = guiTexture.method_48331(".png");
        }
    }
}
