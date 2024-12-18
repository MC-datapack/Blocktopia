package github.mcdatapack.blocktopia.init.worldgen;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;
import java.util.Map;

public class PlacedFeatureInit {
    public static final RegistryKey<PlacedFeature> PALM_TREE_KEY = registerKey("palm_tree");

    //Legacy
    public static final RegistryKey<PlacedFeature> COAL_ORE_C0_0_14A_KEY = registerKey("coal_ore_c0_0_14a");
    public static final RegistryKey<PlacedFeature> COAL_ORE_1_14_KEY = registerKey("coal_ore_1_14");
    public static final RegistryKey<PlacedFeature> IRON_ORE_C0_0_14A_KEY = registerKey("iron_ore_c0_0_14a");
    public static final RegistryKey<PlacedFeature> IRON_ORE_1_14_KEY = registerKey("iron_ore_1_14");
    public static final RegistryKey<PlacedFeature> IRON_ORE_1_14_1_KEY = registerKey("iron_ore_1_14_4");
    public static final RegistryKey<PlacedFeature> GOLD_ORE_C0_0_14A_KEY = registerKey("gold_ore_c0_0_14a");
    public static final RegistryKey<PlacedFeature> GOLD_ORE_C0_26ST_KEY = registerKey("gold_ore_c0_26st");
    public static final RegistryKey<PlacedFeature> GOLD_ORE_1_14_KEY = registerKey("gold_ore_1_14");
    public static final RegistryKey<PlacedFeature> DANDELION_C0_0_20A_KEY = registerKey("dandelion_c0_0_20a");
    public static final RegistryKey<PlacedFeature> DANDELION_C0_0_20A_PATCH_KEY = registerKey("dandelion_c0_0_20a_patch");
    public static final RegistryKey<PlacedFeature> ROSE_C0_0_20A_KEY = registerKey("rose_c0_0_20a");
    public static final RegistryKey<PlacedFeature> ROSE_C0_0_20A_PATCH_KEY = registerKey("rose_c0_0_20a_patch");
    public static final RegistryKey<PlacedFeature> POPPY_1_7_KEY = registerKey("poppy_1_7");
    public static final RegistryKey<PlacedFeature> POPPY_1_7_PATCH_KEY = registerKey("poppy_1_7_patch");
    public static final RegistryKey<PlacedFeature> BROWN_MUSHROOM_C0_0_20A_KEY = registerKey("brown_mushroom_c0_0_20a");
    public static final RegistryKey<PlacedFeature> BROWN_MUSHROOM_C0_0_20A_PATCH_KEY = registerKey("brown_mushroom_c0_0_20a_patch");
    public static final RegistryKey<PlacedFeature> RED_MUSHROOM_C0_0_20A_KEY = registerKey("red_mushroom_c0_0_20a");
    public static final RegistryKey<PlacedFeature> RED_MUSHROOM_C0_0_20A_PATCH_KEY = registerKey("red_mushroom_c0_0_20a_patch");

    public static final RegistryKey<PlacedFeature> TREE_C0_24ST_KEY = registerKey("tree_c0_24st");
    public static final RegistryKey<PlacedFeature> BIRCH_B1_5_KEY = registerKey("birch_b1_5");
    public static final RegistryKey<PlacedFeature> SPRUCE_B1_5_KEY = registerKey("spruce_b1_5");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context, PALM_TREE_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.PALM_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.1F, 1), BlockInit.PALM_SAPLING));
        register(context, TREE_C0_24ST_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.TREE_C0_24ST_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.1F, 1), LegacyBlocks.SAPLING_C0_24ST));
        /*register(context, BIRCH_B1_5_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.BIRCH_B1_5_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.1F, 1), LegacyBlocks.BIRCH_SAPLING_B1_5));
       register(context, SPRUCE_B1_5_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.SPRUCE_B1_5_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.1F, 1), LegacyBlocks.SPRUCE_SAPLING_B1_5));*/

        register(context, COAL_ORE_C0_0_14A_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.COAL_ORE_C0_0_14A_KEY),
                Modifiers.modifiersCount(30, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(192))));
        register(context, COAL_ORE_1_14_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.COAL_ORE_1_14_KEY),
                Modifiers.modifiersCount(30, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(192))));
        register(context, IRON_ORE_C0_0_14A_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.IRON_ORE_C0_0_14A_KEY),
                Modifiers.modifiersCount(10, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(72))));
        register(context, IRON_ORE_1_14_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.IRON_ORE_1_14_KEY),
                Modifiers.modifiersCount(10, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(72))));
        register(context, IRON_ORE_1_14_1_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.IRON_ORE_1_14_1_KEY),
                Modifiers.modifiersCount(10, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(72))));
        register(context, GOLD_ORE_C0_0_14A_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.GOLD_ORE_C0_0_14A_KEY),
                Modifiers.modifiersCount(8, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(32))));
        register(context, GOLD_ORE_C0_26ST_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.GOLD_ORE_C0_26ST_KEY),
                Modifiers.modifiersCount(8, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(32))));
        register(context, GOLD_ORE_1_14_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.GOLD_ORE_1_14_KEY),
                Modifiers.modifiersCount(8, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(32))));

        register(context, DANDELION_C0_0_20A_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.DANDELION_C0_0_20A_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.replaceable())));
        register(context, DANDELION_C0_0_20A_PATCH_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.DANDELION_C0_0_20A_PATCH_KEY),
                List.of(RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));
        register(context, ROSE_C0_0_20A_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.ROSE_C0_0_20A_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.replaceable())));
        register(context, ROSE_C0_0_20A_PATCH_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.ROSE_C0_0_20A_PATCH_KEY),
                List.of(RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));
        register(context, POPPY_1_7_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.POPPY_1_7_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.replaceable())));
        register(context, POPPY_1_7_PATCH_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.POPPY_1_7_PATCH_KEY),
                List.of(RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));
        register(context, BROWN_MUSHROOM_C0_0_20A_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.BROWN_MUSHROOM_C0_0_20A_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.replaceable())));
        register(context, BROWN_MUSHROOM_C0_0_20A_PATCH_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.BROWN_MUSHROOM_C0_0_20A_PATCH_KEY),
                List.of(RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));
        register(context, RED_MUSHROOM_C0_0_20A_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.RED_MUSHROOM_C0_0_20A_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.replaceable())));
        register(context, RED_MUSHROOM_C0_0_20A_PATCH_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.RED_MUSHROOM_C0_0_20A_PATCH_KEY),
                List.of(RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));
    }

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Blocktopia.id(name));
    }

    private static void register(Registerable<PlacedFeature> context,
                                 RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> config,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }

    public static class Modifiers {
        public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
            return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
        }

        public static List<PlacementModifier> modifiersCount(int count, PlacementModifier heightModifier) {
            return modifiers(CountPlacementModifier.of(count), heightModifier);
        }

        public static List<PlacementModifier> modifiersRarity(int chance, PlacementModifier heightModifier) {
            return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
        }
    }
}
