package github.mcdatapack.blocktopia.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import github.mcdatapack.blocktopia.init.LootTableInit;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
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
            cir.setReturnValue(stack.isOf(Items.NETHERITE_INGOT) || stack.isOf(Items.NETHERITE_BLOCK));
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
        if (piglin.getOffHandStack().isOf(Items.NETHERITE_INGOT)) {
            return instance.getLootTable(LootTableInit.NETHERITE_PIGLIN_BARTERING_GAMEPLAY);
        } else if (piglin.getOffHandStack().isOf(Items.NETHERITE_BLOCK)) {
            return instance.getLootTable(LootTableInit.NETHERITE_BLOCK_PIGLIN_BARTERING_GAMEPLAY);
        } else if (piglin.getOffHandStack().isOf(Items.GOLD_INGOT)) {
            return instance.getLootTable(LootTables.PIGLIN_BARTERING_GAMEPLAY);
        }
        return null;
    }

    @WrapOperation(method = "loot", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private static boolean preventDiscardingStacks(ItemStack instance, Item item, Operation<Boolean> original) {
        return !instance.isOf(Items.NETHERITE_INGOT) && !instance.isOf(Items.NETHERITE_BLOCK) && original.call(instance, item);
    }

    @ModifyExpressionValue(method = "canGather", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/PiglinBrain;doesNotHaveGoldInOffHand(Lnet/minecraft/entity/mob/PiglinEntity;)Z"))
    private static boolean doesNotHaveBaterableItemInOffhand(boolean original, PiglinEntity entity) {
        return original && !entity.getOffHandStack().isOf(Items.NETHERITE_INGOT) && !entity.getOffHandStack().isOf(Items.NETHERITE_BLOCK);
    }
}
