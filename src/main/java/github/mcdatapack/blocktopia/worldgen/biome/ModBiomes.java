package github.mcdatapack.blocktopia.worldgen.biome;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.registry.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;

public interface ModBiomes {
    RegistryKey<Biome> RAIN_FOREST_KEY = RegistryKey.of(RegistryKeys.BIOME, Blocktopia.id("rain_forest"));
    RegistryKey<Biome> PALM_ISLAND_KEY = RegistryKey.of(RegistryKeys.BIOME, Blocktopia.id("palm_island"));

    static void bootstrap(Registerable<Biome> biomeRegisterable) {
        RegistryEntryLookup<PlacedFeature> registryEntryLookup = biomeRegisterable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntryLookup<ConfiguredCarver<?>> registryEntryLookup2 = biomeRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);

        biomeRegisterable.register(RAIN_FOREST_KEY, BiomeGenerator.createRainForestBiome(registryEntryLookup, registryEntryLookup2));
        biomeRegisterable.register(PALM_ISLAND_KEY, BiomeGenerator.createPalmIslandBiome(registryEntryLookup, registryEntryLookup2));
    }

    static void load() {}
}
