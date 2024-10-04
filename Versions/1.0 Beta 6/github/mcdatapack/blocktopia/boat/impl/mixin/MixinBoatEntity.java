package github.mcdatapack.blocktopia.boat.impl.mixin;

import github.mcdatapack.blocktopia.boat.impl.entity.BlocktopiaBoatHolder;
import net.minecraft.class_1690;
import net.minecraft.class_1935;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(class_1690.class)
public class MixinBoatEntity {
    @ModifyArg(method = "fall(DZLnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;)V",
            index = 0, at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/vehicle/BoatEntity;dropItem(Lnet/minecraft/item/ItemConvertible;)Lnet/minecraft/entity/ItemEntity;", ordinal = 0))
    private class_1935 blocktopiaBoat$replacePlanksDropItem(class_1935 original) {
        if (this instanceof BlocktopiaBoatHolder blocktopiaBoatHolder) {
            return blocktopiaBoatHolder.getBlocktopiaBoat().getPlanks();
        }
        return original;
    }
}
