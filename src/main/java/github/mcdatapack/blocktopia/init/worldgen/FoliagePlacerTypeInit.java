package github.mcdatapack.blocktopia.init.worldgen;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class FoliagePlacerTypeInit {


    private static <P extends FoliagePlacer> FoliagePlacerType<P> register(String id, MapCodec<P> codec) {
        return Registry.register(Registries.FOLIAGE_PLACER_TYPE, Blocktopia.id(id), new FoliagePlacerType<>(codec));
    }

    public static void load() {}
}
