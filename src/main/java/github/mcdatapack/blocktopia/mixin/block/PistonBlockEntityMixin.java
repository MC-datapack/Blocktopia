package github.mcdatapack.blocktopia.mixin.block;

import github.mcdatapack.blocktopia.block.LegacyBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.PistonBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PistonBlockEntity.class)
public class PistonBlockEntityMixin {
    @Redirect(method = "pushEntities", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private static boolean isOf2(BlockState instance, Block block) {
        return instance.isOf(block) || instance.isOf(LegacyBlocks.SLIME_BLOCK_1_8);
    }
}
