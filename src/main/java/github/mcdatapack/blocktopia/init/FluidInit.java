package github.mcdatapack.blocktopia.init;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.fluid.TropicalWaterFluid;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import net.minecraft.block.*;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class FluidInit {
    public static final FlowableFluid TROPICAL_WATER = Registry.register(Registries.FLUID, Blocktopia.id("tropical_water"), new TropicalWaterFluid.Still());
    public static final FlowableFluid FLOWING_TROPICAL_WATER = Registry.register(Registries.FLUID, Blocktopia.id("flowing_tropical_water"), new TropicalWaterFluid.Flowing());
    public static final FluidBlock TROPICAL_WATER_BLOCK = BlockInit.registerWithoutItem("tropical_water", new FluidBlock(TROPICAL_WATER, AbstractBlock.Settings.copy(Blocks.WATER)));

    public static void load() {}
}
