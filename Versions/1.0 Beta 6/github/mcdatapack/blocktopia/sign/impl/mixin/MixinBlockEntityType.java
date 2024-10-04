package github.mcdatapack.blocktopia.sign.impl.mixin;

import github.mcdatapack.blocktopia.sign.api.BlocktopiaSign;
import net.minecraft.class_2248;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_7713;
import net.minecraft.class_7715;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_2591.class)
public class MixinBlockEntityType {
    @Inject(method = "supports", at = @At("HEAD"), cancellable = true)
    private void blocktopiaWood$signSupports(class_2680 state, CallbackInfoReturnable<Boolean> cir) {
        class_2248 block = state.method_26204();

        if (block instanceof BlocktopiaSign) {
            if (class_2591.field_40330.equals(this)) {
                if (!(block instanceof class_7713 || block instanceof class_7715)) {
                    return;
                }
            } else if (!class_2591.field_11911.equals(this)) {
                return;
            }

            cir.setReturnValue(true);
        }
    }
}
