package github.mcdatapack.blocktopia.mixin.entity;

import github.mcdatapack.blocktopia.block.LegacyBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractMinecartEntity.class)
public class AbstractMinecartEntityMixin {
    @Redirect(method = "moveOnRail", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean isOfPoweredRail(BlockState instance, Block block) {
        return instance.isOf(block) || instance.isOf(LegacyBlocks.POWERED_RAIL_B1_5);
    }

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean isOfActivatorRail(BlockState instance, Block block) {
        return instance.isOf(block) || instance.isOf(LegacyBlocks.ACTIVATOR_RAIL_1_5);
    }
}
