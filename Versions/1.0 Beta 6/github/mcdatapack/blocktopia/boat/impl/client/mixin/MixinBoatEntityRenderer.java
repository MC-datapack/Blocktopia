package github.mcdatapack.blocktopia.boat.impl.client.mixin;

import java.util.Map;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.datafixers.util.Pair;

import github.mcdatapack.blocktopia.boat.impl.BlocktopiaBoatEntityRenderer;
import github.mcdatapack.blocktopia.boat.impl.entity.BlocktopiaBoatHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1690;
import net.minecraft.class_2960;
import net.minecraft.class_554;
import net.minecraft.class_881;

@Mixin(class_881.class)
@Environment(EnvType.CLIENT)
public class MixinBoatEntityRenderer {
    @WrapOperation(method = "render*", at = @At(value = "INVOKE", target = "Ljava/util/Map;get(Ljava/lang/Object;)Ljava/lang/Object;"))
    @SuppressWarnings("unused")
    private Object blocktopiaBoat$getBoatTextureAndModel(
            Map<class_1690.class_1692, Pair<class_2960, class_554>> instance, Object type, Operation<Object> original, class_1690 entity) {
            if (entity instanceof BlocktopiaBoatHolder blocktopiaEntity &&
                (Object) this instanceof BlocktopiaBoatEntityRenderer blocktopiaRenderer) {
            return blocktopiaRenderer.getTextureAndModel(blocktopiaEntity);
        }
        return original.call(instance, type);
    }
}
