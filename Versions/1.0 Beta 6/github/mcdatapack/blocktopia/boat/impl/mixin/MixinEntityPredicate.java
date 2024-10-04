package github.mcdatapack.blocktopia.boat.impl.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_2048;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_2048.class)
public class MixinEntityPredicate {
    @WrapOperation(
            method = "test(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/entity/Entity;)Z",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getType()Lnet/minecraft/entity/EntityType;")
    )
    private class_1299<?> blocktopiaWood$useVanillaBoatTypeForPredicates(class_1297 entity, Operation<class_1299<?>> operation) {
        class_1299<?> type = operation.call(entity);

        if (type == Blocktopia.BOAT) {
            return class_1299.field_6121;
        } else if (type == Blocktopia.CHEST_BOAT) {
            return class_1299.field_38096;
        }

        return type;
    }
}
