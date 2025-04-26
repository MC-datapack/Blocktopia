package github.mcdatapack.blocktopia.fluid;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface ModFluids {
    FlowableFluid TROPICAL_WATER = Registry.register(Registries.FLUID, Blocktopia.id("tropical_water"), new TropicalWaterFluid.Still());
    FlowableFluid FLOWING_TROPICAL_WATER = Registry.register(Registries.FLUID, Blocktopia.id("flowing_tropical_water"), new TropicalWaterFluid.Flowing());
    FluidBlock TROPICAL_WATER_BLOCK = ModBlocks.registerWithoutItem("tropical_water", new FluidBlock(TROPICAL_WATER, AbstractBlock.Settings.copy(Blocks.WATER)));

    static void load() {}
}
