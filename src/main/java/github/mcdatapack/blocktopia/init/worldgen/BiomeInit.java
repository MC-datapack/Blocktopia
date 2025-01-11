package github.mcdatapack.blocktopia.init.worldgen;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.registry.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;

public class BiomeInit {
    public static final RegistryKey<Biome> RAIN_FOREST_KEY = RegistryKey.of(RegistryKeys.BIOME, Blocktopia.id("rain_forest"));
    public static final RegistryKey<Biome> PALM_ISLAND_KEY = RegistryKey.of(RegistryKeys.BIOME, Blocktopia.id("palm_island"));

    public static void bootstrap(Registerable<Biome> biomeRegisterable) {
        RegistryEntryLookup<PlacedFeature> registryEntryLookup = biomeRegisterable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntryLookup<ConfiguredCarver<?>> registryEntryLookup2 = biomeRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);

        biomeRegisterable.register(RAIN_FOREST_KEY, CustomBiomes.createRainForestBiome(registryEntryLookup, registryEntryLookup2));
        biomeRegisterable.register(PALM_ISLAND_KEY, CustomBiomes.createPalmIslandBiome(registryEntryLookup, registryEntryLookup2));
    }

    public static void load() {}
}
