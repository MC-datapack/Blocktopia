package github.mcdatapack.blocktopia.mixin;

import com.mojang.datafixers.Products;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TrunkPlacer.class)
public class TrunkPlacerMixin {
    @Inject(method = "fillTrunkPlacerFields", at = @At("RETURN"), cancellable = true)
    private static <P extends TrunkPlacer> void fillTrunkPlacerFields(RecordCodecBuilder.Instance<P> instance, CallbackInfoReturnable<Products.P3<RecordCodecBuilder.Mu<P>, Integer, Integer, Integer>> cir) {
        cir.setReturnValue(instance.group(
                Codec.intRange(0, 128).fieldOf("base_height").forGetter(placer -> placer.baseHeight),
                Codec.intRange(0, 128).fieldOf("height_rand_a").forGetter(placer -> placer.firstRandomHeight),
                Codec.intRange(0, 128).fieldOf("height_rand_b").forGetter(placer -> placer.secondRandomHeight)
        ));
    }
}
