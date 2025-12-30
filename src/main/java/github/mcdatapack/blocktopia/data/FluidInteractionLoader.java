package github.mcdatapack.blocktopia.data;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

import java.util.*;


public class FluidInteractionLoader extends JsonDataLoader implements IdentifiableResourceReloadListener {
    public static final Identifier ID = Identifier.of("blocktopia", "fluid_interactions");
    private final Map<Identifier, FluidInteraction> interactions = new HashMap<>();

    public FluidInteractionLoader(Gson gson) {
        super(gson, "fluid_interactions");
    }

    @Override
    protected void apply(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler) {
        interactions.clear();
        for (var entry : map.entrySet()) {
            FluidInteraction interaction = FluidInteraction.CODEC.parse(JsonOps.INSTANCE, entry.getValue()).getOrThrow();
            interactions.put(entry.getKey(), interaction);
        }
    }

    public Optional<FluidInteraction> getMatch(Fluid fluid, Block neighbor, Block base) {
        return interactions.values().stream()
                .filter(fluidInteraction ->
                        Registries.FLUID.get(fluidInteraction.fluid()) == fluid &&
                                Registries.BLOCK.get(fluidInteraction.neighborBlock()) == neighbor &&
                                Registries.BLOCK.get(fluidInteraction.baseBlock()) == base)
                .findFirst();
    }

    @Override
    public Identifier getFabricId() {
        return ID;
    }

    public Collection<FluidInteraction> getAll() {
        return interactions.values();
    }
}
