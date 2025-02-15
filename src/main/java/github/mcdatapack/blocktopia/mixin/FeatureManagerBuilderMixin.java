package github.mcdatapack.blocktopia.mixin;

import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.resource.featuretoggle.FeatureManager;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.resource.featuretoggle.FeatureUniverse;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(FeatureManager.Builder.class)
public class FeatureManagerBuilderMixin {
    @Shadow @Final private Map<Identifier, FeatureFlag> featureFlags;

    @Shadow @Final private FeatureUniverse universe;

    @Inject(method = "build", at = @At("RETURN"), cancellable = true)
    private void build(CallbackInfoReturnable<FeatureManager> cir) {
        FeatureSet featureSet = FeatureSet.of(universe, this.featureFlags.values());
        cir.setReturnValue(new FeatureManager(universe, featureSet, featureFlags));
    }
}
