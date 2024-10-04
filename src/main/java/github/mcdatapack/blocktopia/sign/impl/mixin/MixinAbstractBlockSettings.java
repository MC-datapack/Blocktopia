package github.mcdatapack.blocktopia.sign.impl.mixin;

import github.mcdatapack.blocktopia.sign.impl.BlockSettingsLock;
import net.minecraft.block.AbstractBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.Settings.class)
public class MixinAbstractBlockSettings implements BlockSettingsLock {
    @Unique
    private boolean blocktopia$locked = false;

    @Inject(method = "sounds", at = @At("HEAD"), cancellable = true)
    private void blocktopiaWood$preventSoundsOverride(CallbackInfoReturnable<AbstractBlock.Settings> cir) {
        if (this.blocktopia$locked) {
            cir.setReturnValue((AbstractBlock.Settings) (Object) this);
            this.blocktopia$locked = false;
        }
    }

    @Override
    public void lock() {
        this.blocktopia$locked = true;
    }
}
