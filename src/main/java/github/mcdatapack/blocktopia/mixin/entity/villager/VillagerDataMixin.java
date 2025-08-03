package github.mcdatapack.blocktopia.mixin.entity.villager;

import net.minecraft.village.VillagerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VillagerData.class)
public class VillagerDataMixin {
    @Shadow @Mutable public static int MAX_LEVEL = 10;
    @Shadow @Mutable private static int[] LEVEL_BASE_EXPERIENCE = {0, 10, 70, 150, 250, 500, 1250, 1550, 2250, 5500};

    @Inject(method = "canLevelUp", at = @At("RETURN"), cancellable = true)
    private static void canLevelUp(int level, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(level >= 1 && level < MAX_LEVEL);
    }
}
