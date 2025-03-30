package github.mcdatapack.blocktopia.mixin;

import net.minecraft.resource.featuretoggle.FeatureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

@Mixin(FeatureManager.Builder.class)
public class FeatureManagerBuilderMixin {
    @Redirect(method = "build", at = @At(value = "INVOKE", target = "Ljava/util/Map;copyOf(Ljava/util/Map;)Ljava/util/Map;"))
    private <K, V> Map<K, V> copyOf(Map<K, V> map) {
        return map;
    }
}
