package github.mcdatapack.blocktopia.mixin.block;

import github.mcdatapack.blocktopia.block.LegacyBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PistonHandler.class)
public class PistonHandlerMixin {
    @Redirect(method = "isBlockSticky", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private static boolean isOf1(BlockState instance, Block block) {
        if (block.equals(Blocks.SLIME_BLOCK)) {
            return instance.isOf(block) || instance.isOf(LegacyBlocks.SLIME_BLOCK_1_8);
        } else {
            return instance.isOf(block);
        }
    }

    @Redirect(method = "isAdjacentBlockStuck", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private static boolean isOf2(BlockState instance, Block block) {
        if (block.equals(Blocks.SLIME_BLOCK)) {
            return instance.isOf(block) || instance.isOf(LegacyBlocks.SLIME_BLOCK_1_8);
        } else {
            return instance.isOf(block);
        }
    }
}
