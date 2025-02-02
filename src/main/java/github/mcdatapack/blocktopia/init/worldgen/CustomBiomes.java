package github.mcdatapack.blocktopia.init.worldgen;

import github.mcdatapack.blocktopia.init.EntityInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.*;

public class CustomBiomes {
    public static Biome createRainForestBiome(RegistryEntryLookup<PlacedFeature> registryEntryLookup, RegistryEntryLookup<ConfiguredCarver<?>> registryEntryLookupCarver) {
        BiomeEffects effects = new BiomeEffects.Builder()
                .fogColor(0xc0d8ff)
                .skyColor(0x77adff)
                .waterColor(0x3f76e4)
                .waterFogColor(0x050533)
                .build();
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
                addAllCarvers(generationSettings, registryEntryLookupCarver)
                .feature(GenerationStep.Feature.LAKES, registryEntryLookup.getOrThrow(MiscPlacedFeatures.LAKE_LAVA_UNDERGROUND))
                .feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, registryEntryLookup.getOrThrow(UndergroundPlacedFeatures.AMETHYST_GEODE))
                .feature(GenerationStep.Feature.UNDERGROUND_STRUCTURES, registryEntryLookup.getOrThrow(UndergroundPlacedFeatures.MONSTER_ROOM))
                .feature(GenerationStep.Feature.UNDERGROUND_STRUCTURES, registryEntryLookup.getOrThrow(UndergroundPlacedFeatures.MONSTER_ROOM_DEEP));
                addOres(generationSettings, registryEntryLookup)
                .feature(GenerationStep.Feature.FLUID_SPRINGS, registryEntryLookup.getOrThrow(MiscPlacedFeatures.SPRING_WATER))
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(PlacedFeatureInit.GLOW_FLOWER_PATCH_KEY))
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(VegetationPlacedFeatures.PATCH_SUGAR_CANE))
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(VegetationPlacedFeatures.VINES))

                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(PlacedFeatureInit.GIANT_3x3BANANA_TREE_KEY))
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(PlacedFeatureInit.GIANT_3x3CORN_TREE_KEY))
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(PlacedFeatureInit.GIANT_3x3FLOWERING_CHERRY_KEY))
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(PlacedFeatureInit.MEGA_JUNGLE_TREE))
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(PlacedFeatureInit.JUNGLE_TREE))
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(PlacedFeatureInit.GIANT_BANANA_TREE_KEY))
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(PlacedFeatureInit.GIANT_CORN_TREE_KEY))
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(PlacedFeatureInit.GIANT_FLOWERING_CHERRY_KEY))
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(PlacedFeatureInit.BANANA_TREE_KEY))
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(PlacedFeatureInit.CORN_TREE_KEY))
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(PlacedFeatureInit.FLOWERING_CHERRY_KEY))
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(PlacedFeatureInit.PALM_TREE_KEY));

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder()
                .spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityInit.MONKEY, 100, 4, 8))
                .spawn(SpawnGroup.UNDERGROUND_WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.GLOW_SQUID, 10, 4, 6))
                .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SPIDER, 5, 4, 4))
                .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 5, 4, 4))
                .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1))
                .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 5, 4, 4))
                .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.CREEPER, 5, 4, 4))
                .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 10, 4, 4))
                .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4))
                .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITCH, 100, 1, 1));

        return new Biome.Builder()
                .precipitation(true)
                .temperature(2)
                .downfall(2.0F)
                .effects(effects)
                .generationSettings(generationSettings.build())
                .spawnSettings(spawnSettings.build())
                .build();
    }

    public static Biome createPalmIslandBiome(RegistryEntryLookup<PlacedFeature> registryEntryLookup, RegistryEntryLookup<ConfiguredCarver<?>> registryEntryLookupCarver) {
        BiomeEffects effects = new BiomeEffects.Builder()
                .fogColor(0xc0d8ff)
                .skyColor(0x77adff)
                .waterColor(4445678)
                .waterFogColor(270131)
                .build();
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        addAllCarvers(generationSettings, registryEntryLookupCarver)
                .feature(GenerationStep.Feature.LAKES, registryEntryLookup.getOrThrow(MiscPlacedFeatures.LAKE_LAVA_UNDERGROUND))
                .feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, registryEntryLookup.getOrThrow(UndergroundPlacedFeatures.AMETHYST_GEODE))
                .feature(GenerationStep.Feature.UNDERGROUND_STRUCTURES, registryEntryLookup.getOrThrow(UndergroundPlacedFeatures.MONSTER_ROOM))
                .feature(GenerationStep.Feature.UNDERGROUND_STRUCTURES, registryEntryLookup.getOrThrow(UndergroundPlacedFeatures.MONSTER_ROOM_DEEP));
                addOres(generationSettings, registryEntryLookup)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(VegetationPlacedFeatures.PATCH_SUGAR_CANE))
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, registryEntryLookup.getOrThrow(PlacedFeatureInit.PALM_TREE_KEY));

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        return new Biome.Builder()
                .precipitation(true)
                .temperature(2)
                .downfall(2.0F)
                .effects(effects)
                .generationSettings(generationSettings.build())
                .spawnSettings(spawnSettings.build())
                .build();
    }

    private static GenerationSettings.Builder addAllCarvers(GenerationSettings.Builder input, RegistryEntryLookup<ConfiguredCarver<?>> registryEntryLookupCarver) {
        return input
                .carver(GenerationStep.Carver.AIR, registryEntryLookupCarver.getOrThrow(ConfiguredCarvers.CAVE))
                .carver(GenerationStep.Carver.AIR, registryEntryLookupCarver.getOrThrow(ConfiguredCarvers.CANYON))
                .carver(GenerationStep.Carver.AIR, registryEntryLookupCarver.getOrThrow(ConfiguredCarvers.CAVE_EXTRA_UNDERGROUND))
                .carver(GenerationStep.Carver.LIQUID, registryEntryLookupCarver.getOrThrow(ConfiguredCarvers.CAVE))
                .carver(GenerationStep.Carver.LIQUID, registryEntryLookupCarver.getOrThrow(ConfiguredCarvers.CANYON))
                .carver(GenerationStep.Carver.LIQUID, registryEntryLookupCarver.getOrThrow(ConfiguredCarvers.CAVE_EXTRA_UNDERGROUND));
    }

    private static GenerationSettings.Builder addOres(GenerationSettings.Builder input, RegistryEntryLookup<PlacedFeature> registryEntryLookup) {
        return input
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, registryEntryLookup.getOrThrow(OrePlacedFeatures.ORE_COAL_UPPER))
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, registryEntryLookup.getOrThrow(OrePlacedFeatures.ORE_COAL_LOWER))
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, registryEntryLookup.getOrThrow(OrePlacedFeatures.ORE_IRON_UPPER))
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, registryEntryLookup.getOrThrow(OrePlacedFeatures.ORE_IRON_MIDDLE))
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, registryEntryLookup.getOrThrow(OrePlacedFeatures.ORE_IRON_SMALL))
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, registryEntryLookup.getOrThrow(OrePlacedFeatures.ORE_GOLD))
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, registryEntryLookup.getOrThrow(OrePlacedFeatures.ORE_GOLD_LOWER))
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, registryEntryLookup.getOrThrow(OrePlacedFeatures.ORE_REDSTONE))
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, registryEntryLookup.getOrThrow(OrePlacedFeatures.ORE_REDSTONE_LOWER))
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, registryEntryLookup.getOrThrow(OrePlacedFeatures.ORE_DIAMOND))
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, registryEntryLookup.getOrThrow(OrePlacedFeatures.ORE_DIAMOND_MEDIUM))
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, registryEntryLookup.getOrThrow(OrePlacedFeatures.ORE_DIAMOND_LARGE))
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, registryEntryLookup.getOrThrow(OrePlacedFeatures.ORE_DIAMOND_BURIED))
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, registryEntryLookup.getOrThrow(OrePlacedFeatures.ORE_LAPIS))
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, registryEntryLookup.getOrThrow(OrePlacedFeatures.ORE_LAPIS_BURIED))
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, registryEntryLookup.getOrThrow(UndergroundPlacedFeatures.UNDERWATER_MAGMA));
    }

    private static SpawnSettings.Builder addStandardMobs(SpawnSettings.Builder builder) {
        DefaultBiomeFeatures.addFarmAnimals(builder);
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.HORSE, 5, 2, 6));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.DONKEY, 1, 1, 3));
        DefaultBiomeFeatures.addBatsAndMonsters(builder);
        return builder;
    }
}
