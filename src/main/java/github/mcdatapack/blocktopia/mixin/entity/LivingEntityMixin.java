package github.mcdatapack.blocktopia.mixin.entity;

import github.mcdatapack.blocktopia.enchantment.ModEnchantments;
import github.mcdatapack.more_tools_and_armor.enums.ToolMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.SwordItem;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.concurrent.atomic.AtomicBoolean;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow protected abstract void drop(ServerWorld world, DamageSource damageSource);

    @Shadow protected abstract void dropXp(@Nullable Entity attacker);

    @Redirect(method = "onDeath", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;drop(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/damage/DamageSource;)V"))
    private void drop(LivingEntity instance, ServerWorld world, DamageSource damageSource) {
        if (damageSource.getAttacker() instanceof PlayerEntity playerEntity && hasSilkSwingEnchantment(playerEntity)) {
            if (hasXPMultiplier(playerEntity))
                dropXp(damageSource.getAttacker());
        } else {
            drop(world, damageSource);
        }
    }

    @Unique
    private boolean hasSilkSwingEnchantment(PlayerEntity playerEntity) {
        AtomicBoolean ret = new AtomicBoolean(false);
        playerEntity.getMainHandStack().getEnchantments().getEnchantments().forEach(enchantmentRegistryEntry -> {
            if (enchantmentRegistryEntry.getKey().isPresent() && enchantmentRegistryEntry.getKey().get().equals(ModEnchantments.SILK_SWING_KEY)) {
                ret.set(true);
            }
        });
        return ret.get();
    }

    @Unique
    private boolean hasXPMultiplier(PlayerEntity player) {
        return player.getMainHandStack().getItem() instanceof SwordItem swordItem && (swordItem.getMaterial() == ToolMaterials.DEEPSLATE_EMERALD
                || swordItem.getMaterial() == ToolMaterials.END_DIAMOND
                || swordItem.getMaterial() == ToolMaterials.VOID
                || swordItem.getMaterial() == ToolMaterials.ONETHDENDERITE
                || swordItem.getMaterial() == ToolMaterials.OLED
                || swordItem.getMaterial() == ToolMaterials.ANCIENT);
    }
}
