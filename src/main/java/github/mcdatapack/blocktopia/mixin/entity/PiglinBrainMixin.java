package github.mcdatapack.blocktopia.mixin.entity;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import github.mcdatapack.blocktopia.api.CustomPiglinTrading;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.ReloadableRegistries;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinBrain.class)
public abstract class PiglinBrainMixin {
    @Inject(method = "acceptsForBarter", at = @At("RETURN"), cancellable = true)
    private static void acceptsForBarter(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue()) {
            cir.setReturnValue(CustomPiglinTrading.ITEMS_FOR_LOOT_TABLES.containsKey(stack.getItem()));
        }
    }

    @Redirect(method = "consumeOffHandItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/PiglinEntity;setStackInHand(Lnet/minecraft/util/Hand;Lnet/minecraft/item/ItemStack;)V"))
    private static void setStack(PiglinEntity piglin, Hand hand, ItemStack stack) {}

    @Inject(method = "consumeOffHandItem", at = @At("RETURN"))
    private static void deleteOffHandItem(PiglinEntity piglin, boolean barter, CallbackInfo ci) {
        piglin.setStackInHand(Hand.OFF_HAND, ItemStack.EMPTY);
    }

    @Redirect(method = "getBarteredItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/registry/ReloadableRegistries$Lookup;getLootTable(Lnet/minecraft/registry/RegistryKey;)Lnet/minecraft/loot/LootTable;"))
    private static LootTable getLootTable(ReloadableRegistries.Lookup instance, RegistryKey<LootTable> key, PiglinEntity piglin) {
        if (CustomPiglinTrading.ITEMS_FOR_LOOT_TABLES.containsKey(piglin.getOffHandStack().getItem())) {
            return instance.getLootTable(CustomPiglinTrading.ITEMS_FOR_LOOT_TABLES.get(piglin.getOffHandStack().getItem()));
        }
        return null;
    }

    @WrapOperation(method = "loot", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private static boolean preventDiscardingStacks(ItemStack instance, Item item, Operation<Boolean> original) {
        return !CustomPiglinTrading.ITEMS_FOR_LOOT_TABLES.containsKey(item) && original.call(instance, item);
    }

    @ModifyExpressionValue(method = "canGather", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/PiglinBrain;doesNotHaveGoldInOffHand(Lnet/minecraft/entity/mob/PiglinEntity;)Z"))
    private static boolean doesNotHaveBaterableItemInOffhand(boolean original, PiglinEntity entity) {
        return original && !CustomPiglinTrading.ITEMS_FOR_LOOT_TABLES.containsKey(entity.getOffHandStack().getItem());
    }
}
