package github.mcdatapack.blocktopia.init.worldgen;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class OverworldRegion extends Region {
    public OverworldRegion(Identifier name, RegionType type, int weight) {
        super(name, type, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        MultiNoiseUtil.NoiseHypercube noiseHypercube = new MultiNoiseUtil.NoiseHypercube(new MultiNoiseUtil.ParameterRange(3, 5),
                new MultiNoiseUtil.ParameterRange(-1, 0), new MultiNoiseUtil.ParameterRange(0, 1), new MultiNoiseUtil.ParameterRange(2, 2),
                new MultiNoiseUtil.ParameterRange(2, 2), new MultiNoiseUtil.ParameterRange(2, 2), 4);

        mapper.accept(Pair.of(noiseHypercube, BiomeInit.RAIN_FOREST_KEY));
    }
}
