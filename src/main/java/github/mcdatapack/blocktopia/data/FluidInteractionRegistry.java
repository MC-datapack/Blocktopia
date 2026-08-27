package github.mcdatapack.blocktopia.data;

import com.google.gson.Gson;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.resource.ResourceType;

import java.util.Collection;
import java.util.Optional;

public class FluidInteractionRegistry {
    private static FluidInteractionLoader loader;

    public static void init() {
        loader = new FluidInteractionLoader(new Gson());
        ResourceManagerHelper.get(ResourceType.SERVER_DATA)
                .registerReloadListener(loader);
    }

    public static Optional<FluidInteraction> getMatch(Fluid fluid, Block neighbor, Block base) {
        return loader.getMatch(fluid, neighbor, base);
    }

    public static Collection<FluidInteraction> getAll() {
        return loader.getAll();
    }
}
