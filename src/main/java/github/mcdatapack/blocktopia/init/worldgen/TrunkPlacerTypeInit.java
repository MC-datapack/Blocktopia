package github.mcdatapack.blocktopia.init.worldgen;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class TrunkPlacerTypeInit {
    public static final TrunkPlacerType<ExtremeTrunkPlacer> EXTREME_TRUNK_PLACER = register("extreme_trunk_placer", ExtremeTrunkPlacer.CODEC);

    private static <P extends TrunkPlacer> TrunkPlacerType<P> register(String id, MapCodec<P> codec) {
        return Registry.register(Registries.TRUNK_PLACER_TYPE, Blocktopia.id(id), new TrunkPlacerType<>(codec));
    }

    public static void load() {}
}
