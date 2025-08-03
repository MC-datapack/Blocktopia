package github.mcdatapack.blocktopia.mixin.entity.villager;

import github.mcdatapack.blocktopia.api.VillagerLevelTradeCountRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.TradeOffers;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VillagerEntity.class)
public abstract class VillagerEntityMixin extends MerchantEntity {
    public VillagerEntityMixin(EntityType<? extends MerchantEntity> entityType, World world) {
        super(entityType, world);
    }

    @Redirect(method = "fillRecipes", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/VillagerEntity;fillRecipesFromPool(Lnet/minecraft/village/TradeOfferList;[Lnet/minecraft/village/TradeOffers$Factory;I)V"))
    private void fillRecipesFromPool(VillagerEntity instance, TradeOfferList tradeOffers, TradeOffers.Factory[] factories, int i) {
        fillRecipesFromPool(tradeOffers, factories,
                VillagerLevelTradeCountRegistry.VILLAGER_LEVEL_TRADE_COUNT_MAP.getOrDefault(instance.getVillagerData().getProfession(), i));
    }
}
