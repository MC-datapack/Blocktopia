package github.mcdatapack.blocktopia.mixin;

import github.mcdatapack.blocktopia.init.EnchantmentInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.concurrent.atomic.AtomicBoolean;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow protected abstract void drop(ServerWorld world, DamageSource damageSource);

    @Redirect(method = "onDeath", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;drop(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/damage/DamageSource;)V"))
    private void drop(LivingEntity instance, ServerWorld world, DamageSource damageSource) {
        if (!(damageSource.getAttacker() instanceof PlayerEntity playerEntity && hasSilkSwingEnchantment(playerEntity))) {
            drop(world, damageSource);
        }
    }

    @Unique
    private boolean hasSilkSwingEnchantment(PlayerEntity playerEntity) {
        AtomicBoolean ret = new AtomicBoolean(false);
        playerEntity.getMainHandStack().getEnchantments().getEnchantments().forEach(enchantmentRegistryEntry -> {
            if (enchantmentRegistryEntry.getKey().isPresent() && enchantmentRegistryEntry.getKey().get().equals(EnchantmentInit.SILK_SWING_KEY)) {
                ret.set(true);
            }
        });
        return ret.get();
    }
}
