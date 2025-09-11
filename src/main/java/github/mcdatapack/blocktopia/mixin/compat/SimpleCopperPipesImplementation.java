package github.mcdatapack.blocktopia.mixin.compat;

import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.block.entity.custom.FluidTankBlockEntity;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.lunade.copper.blocks.block_entity.leaking_pipes.LeakingPipeDrips;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluids;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(value = LeakingPipeDrips.class, remap = false)
public abstract class SimpleCopperPipesImplementation {
    @Shadow
    public static void register(Block block, LeakingPipeDrips.DripOn drip) {}

    @Inject(method = "init", at = @At("HEAD"))
    private static void init(CallbackInfo ci) {
        register(ModBlocks.FLUID_TANK, (lava, world, pos, state) -> {
            try (Transaction transaction = Transaction.openOuter()) {
                ((FluidTankBlockEntity) Objects.requireNonNull(world.getBlockEntity(pos)))
                        .getFluidTank()
                        .insert(lava ? FluidVariant.of(Fluids.LAVA) : FluidVariant.of(Fluids.WATER),
                                lava ? FluidConstants.BUCKET : FluidConstants.BOTTLE, transaction);
                transaction.commit();
            }
        });
    }
}
