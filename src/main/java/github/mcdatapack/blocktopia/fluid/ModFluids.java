package github.mcdatapack.blocktopia.fluid;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface ModFluids {
    FlowableFluid TROPICAL_WATER = register("tropical_water", new TropicalWaterFluid.Still());
    FlowableFluid FLOWING_TROPICAL_WATER = register("flowing_tropical_water", new TropicalWaterFluid.Flowing());
    FluidBlock TROPICAL_WATER_BLOCK = ModBlocks.registerWithoutItem("tropical_water", AbstractBlock.Settings.copy(Blocks.WATER),
            settings -> new FluidBlock(TROPICAL_WATER, settings));
    BucketItem TROPICAL_WATER_BUCKET = ModItems.register("tropical_water_bucket", settings -> new BucketItem(ModFluids.TROPICAL_WATER, settings.maxCount(1)));

    static <T extends Fluid> T register(String name, T fluid) {
        return Registry.register(Registries.FLUID, Blocktopia.id(name), fluid);
    }

    static void load() {}
}
