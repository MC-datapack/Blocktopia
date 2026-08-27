package github.mcdatapack.blocktopia.mixin;

import github.mcdatapack.blocktopia.loottable.ModLootTables;
import github.mcdatapack.blocktopia.util.ModTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FishingBobberEntity.class)
public abstract class FishingBobberEntityMixin extends ProjectileEntity {
    public FishingBobberEntityMixin(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Redirect(method = "use", at = @At(value = "FIELD", target = "Lnet/minecraft/loot/LootTables;FISHING_GAMEPLAY:Lnet/minecraft/registry/RegistryKey;"))
    private RegistryKey<LootTable> getLootTable() {
        boolean tropicalWater = getWorld().getFluidState(getBlockPos()).isIn(ModTags.Fluids.TROPICAL_WATER);
        return tropicalWater ? ModLootTables.TROPICAL_FISHING : LootTables.FISHING_GAMEPLAY;
    }
}
