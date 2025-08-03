package github.mcdatapack.blocktopia.mixin.block;

import com.llamalad7.mixinextras.sugar.Local;
import github.mcdatapack.blocktopia.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.CocoaBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CocoaBlock.class)
public class CocoaBlockMixin {
    @Inject(method = "canPlaceAt", at = @At("RETURN"), cancellable = true)
    private void canPlaceAt(BlockState state, WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir, @Local(ordinal = 1) BlockState blockState) {
        if (!cir.getReturnValue()) {
            cir.setReturnValue(blockState.isIn(ModTags.Blocks.COCOA_BEANS_PLACEABLE));
        }
    }
}
