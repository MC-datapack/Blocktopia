package github.mcdatapack.blocktopia.sign.impl.client.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import github.mcdatapack.blocktopia.sign.api.BlocktopiaSign;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2680;
import net.minecraft.class_332;
import net.minecraft.class_4719;
import net.minecraft.class_4722;
import net.minecraft.class_4730;
import net.minecraft.class_498;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_498.class)
@Environment(EnvType.CLIENT)
public class MixinSignEditScreen {
    @WrapOperation(
            method = "renderSignBackground",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/TexturedRenderLayers;getSignTextureId(Lnet/minecraft/block/WoodType;)Lnet/minecraft/client/util/SpriteIdentifier;")
    )
    @SuppressWarnings("unused")
    private class_4730 blocktopoiaWood$editSignTextureId(class_4719 type, Operation<class_4730> original, class_332 drawContext, class_2680 state) {
        if (state.method_26204() instanceof BlocktopiaSign signBlock) {
            return new class_4730(class_4722.field_21708, signBlock.getTexture());
        }

        return original.call(type);
    }
}
