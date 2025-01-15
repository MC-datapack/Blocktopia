package github.mcdatapack.blocktopia.init.worldgen;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.config.BlocktopiaConfigData;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import github.mcdatapack.blocktopia.list.TagList;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;
import java.util.Map;

public class PlacedFeatureInit {
    private static final BlocktopiaConfigData.WorldgenFeatureConfig config = BlocktopiaConfig.getConfig().worldgenConfig.worldgenFeatures;

    public static final RegistryKey<PlacedFeature> PALM_TREE_KEY = registerKey("palm_tree");
    public static final RegistryKey<PlacedFeature> BANANA_TREE_KEY = registerKey("banana_tree");
    public static final RegistryKey<PlacedFeature> FLOWERING_CHERRY_KEY = registerKey("flowering_cherry");
    public static final RegistryKey<PlacedFeature> GLOW_FLOWER_KEY = registerKey("glow_flower");
    public static final RegistryKey<PlacedFeature> GLOW_FLOWER_PATCH_KEY = registerKey("glow_flower_patch");
    //Of Vanilla
    public static final RegistryKey<PlacedFeature> MEGA_JUNGLE_TREE = registerKey("mega_jungle_tree");
    public static final RegistryKey<PlacedFeature> JUNGLE_TREE = registerKey("jungle_tree");
    //Legacy
    public static final RegistryKey<PlacedFeature> COAL_ORE_C0_0_14A_KEY = registerKey("coal_ore_c0_0_14a");
    public static final RegistryKey<PlacedFeature> COAL_ORE_1_14_KEY = registerKey("coal_ore_1_14");
    public static final RegistryKey<PlacedFeature> IRON_ORE_C0_0_14A_KEY = registerKey("iron_ore_c0_0_14a");
    public static final RegistryKey<PlacedFeature> IRON_ORE_1_14_KEY = registerKey("iron_ore_1_14");
    public static final RegistryKey<PlacedFeature> IRON_ORE_1_14_1_KEY = registerKey("iron_ore_1_14_4");
    public static final RegistryKey<PlacedFeature> GOLD_ORE_C0_0_14A_KEY = registerKey("gold_ore_c0_0_14a");
    public static final RegistryKey<PlacedFeature> GOLD_ORE_C0_26ST_KEY = registerKey("gold_ore_c0_26st");
    public static final RegistryKey<PlacedFeature> GOLD_ORE_1_14_KEY = registerKey("gold_ore_1_14");
    public static final RegistryKey<PlacedFeature> DIAMOND_ORE_IN20100128_KEY = registerKey("diamond_ore_in20100128");
    public static final RegistryKey<PlacedFeature> DIAMOND_ORE_1_14_KEY = registerKey("diamond_ore_1_14");
    //public static final RegistryKey<PlacedFeature> LAPIS_ORE_B1_2_KEY = registerKey("lapis_ore_b1_2");
    //public static final RegistryKey<PlacedFeature> LAPIS_ORE_1_14_KEY = registerKey("lapis_ore_1_14");
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
    //public static final RegistryKey<PlacedFeature> BIRCH_B1_5_KEY = registerKey("birch_b1_5");
    //public static final RegistryKey<PlacedFeature> SPRUCE_B1_5_KEY = registerKey("spruce_b1_5");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context, PALM_TREE_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.PALM_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(config.features.palm.triesPerChunk, 0.1F, 6), BlockInit.PALM_SAPLING));
        register(context, BANANA_TREE_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.BANANA_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(128, 0.1F, 128), BlockInit.BANANA_SAPLING)
        );
        register(context, GLOW_FLOWER_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.GLOW_FLOWER_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.replaceable())));
        register(context, GLOW_FLOWER_PATCH_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.GLOW_FLOWER_PATCH_KEY),
                List.of(RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

        register(context, FLOWERING_CHERRY_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.FLOWERING_CHERRY_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(96, 0.1F, 128), BlockInit.FLOWERING_CHERRY_SAPLING)
        );


        register(context, MEGA_JUNGLE_TREE, registryLookup.getOrThrow(TreeConfiguredFeatures.MEGA_JUNGLE_TREE),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(32, 0.1F, 16), Blocks.JUNGLE_SAPLING
                ));
        register(context, JUNGLE_TREE, registryLookup.getOrThrow(TreeConfiguredFeatures.JUNGLE_TREE),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(32, 0.1F, 16), Blocks.JUNGLE_SAPLING
                ));

        register(context, TREE_C0_24ST_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.TREE_C0_24ST_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(config.features.tree_c0_24st.triesPerChunk, 0.1F, 1), LegacyBlocks.SAPLING_C0_24ST));
        //register(context, BIRCH_B1_5_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.BIRCH_B1_5_KEY),
        //         VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
        //                 PlacedFeatures.createCountExtraModifier(config.features.birch_b1_5.triesPerChunk, 0.1F, 1), LegacyBlocks.BIRCH_SAPLING_B1_5));
        //register(context, SPRUCE_B1_5_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.SPRUCE_B1_5_KEY),
        //         VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
        //                PlacedFeatures.createCountExtraModifier(config.features.spruce_b1_5.triesPerChunk, 0.1F, 1), LegacyBlocks.SPRUCE_SAPLING_B1_5));

        register(context, COAL_ORE_C0_0_14A_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.COAL_ORE_C0_0_14A_KEY),
                Modifiers.modifiersCount(config.features.legacy_coal_ores.triesPerChunk,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(config.features.legacy_coal_ores.minY), YOffset.fixed(config.features.legacy_coal_ores.maxY))));
        register(context, COAL_ORE_1_14_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.COAL_ORE_1_14_KEY),
                Modifiers.modifiersCount(config.features.legacy_coal_ores.triesPerChunk,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(config.features.legacy_coal_ores.minY), YOffset.fixed(config.features.legacy_coal_ores.maxY))));
        register(context, IRON_ORE_C0_0_14A_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.IRON_ORE_C0_0_14A_KEY),
                Modifiers.modifiersCount(config.features.legacy_iron_ores.triesPerChunk,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(config.features.legacy_iron_ores.minY), YOffset.fixed(config.features.legacy_iron_ores.maxY))));
        register(context, IRON_ORE_1_14_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.IRON_ORE_1_14_KEY),
                Modifiers.modifiersCount(config.features.legacy_iron_ores.triesPerChunk,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(config.features.legacy_iron_ores.minY), YOffset.fixed(config.features.legacy_iron_ores.maxY))));
        register(context, IRON_ORE_1_14_1_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.IRON_ORE_1_14_1_KEY),
                Modifiers.modifiersCount(config.features.legacy_iron_ores.triesPerChunk,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(config.features.legacy_iron_ores.minY), YOffset.fixed(config.features.legacy_iron_ores.maxY))));
        register(context, GOLD_ORE_C0_0_14A_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.GOLD_ORE_C0_0_14A_KEY),
                Modifiers.modifiersCount(config.features.legacy_gold_ores.triesPerChunk,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(config.features.legacy_gold_ores.minY), YOffset.fixed(config.features.legacy_gold_ores.maxY))));
        register(context, GOLD_ORE_C0_26ST_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.GOLD_ORE_C0_26ST_KEY),
                Modifiers.modifiersCount(config.features.legacy_gold_ores.triesPerChunk,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(config.features.legacy_gold_ores.minY), YOffset.fixed(config.features.legacy_gold_ores.maxY))));
        register(context, GOLD_ORE_1_14_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.GOLD_ORE_1_14_KEY),
                Modifiers.modifiersCount(config.features.legacy_gold_ores.triesPerChunk,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(config.features.legacy_gold_ores.minY), YOffset.fixed(config.features.legacy_gold_ores.maxY))));
        register(context, DIAMOND_ORE_IN20100128_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.DIAMOND_ORE_IN20100128_KEY),
                Modifiers.modifiersCount(config.features.legacy_diamond_ores.triesPerChunk,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(config.features.legacy_diamond_ores.minY), YOffset.fixed(config.features.legacy_diamond_ores.maxY))));
        register(context, DIAMOND_ORE_1_14_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.DIAMOND_ORE_1_14_KEY),
                Modifiers.modifiersCount(config.features.legacy_diamond_ores.triesPerChunk,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(config.features.legacy_diamond_ores.minY), YOffset.fixed(config.features.legacy_diamond_ores.maxY))));
        //register(context, LAPIS_ORE_B1_2_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.LAPIS_ORE_B1_2_KEY),
        //        Modifiers.modifiersCount(config.features.legacy_lapis_ores.triesPerChunk,
        //                HeightRangePlacementModifier.uniform(YOffset.fixed(config.features.legacy_lapis_ores.minY), YOffset.fixed(config.features.legacy_lapis_ores.maxY))));
        //register(context, LAPIS_ORE_1_14_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.LAPIS_ORE_1_14_KEY),
        //        Modifiers.modifiersCount(config.features.legacy_lapis_ores.triesPerChunk,
        //                HeightRangePlacementModifier.uniform(YOffset.fixed(config.features.legacy_lapis_ores.minY), YOffset.fixed(config.features.legacy_lapis_ores.maxY))));

        register(context, DANDELION_C0_0_20A_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.DANDELION_C0_0_20A_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.replaceable())));
        register(context, DANDELION_C0_0_20A_PATCH_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.DANDELION_C0_0_20A_PATCH_KEY),
                List.of(RarityFilterPlacementModifier.of(config.features.dandelion_c0_0_20a.chance), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));
        register(context, ROSE_C0_0_20A_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.ROSE_C0_0_20A_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.replaceable())));
        register(context, ROSE_C0_0_20A_PATCH_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.ROSE_C0_0_20A_PATCH_KEY),
                List.of(RarityFilterPlacementModifier.of(config.features.rose_c0_0_20a.chance), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));
        register(context, POPPY_1_7_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.POPPY_1_7_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.replaceable())));
        register(context, POPPY_1_7_PATCH_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.POPPY_1_7_PATCH_KEY),
                List.of(RarityFilterPlacementModifier.of(config.features.poppy_1_7.chance), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));
        register(context, BROWN_MUSHROOM_C0_0_20A_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.BROWN_MUSHROOM_C0_0_20A_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.replaceable())));
        register(context, BROWN_MUSHROOM_C0_0_20A_PATCH_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.BROWN_MUSHROOM_C0_0_20A_PATCH_KEY),
                List.of(RarityFilterPlacementModifier.of(config.features.brown_mushroom_c0_0_20a.chance), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));
        register(context, RED_MUSHROOM_C0_0_20A_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.RED_MUSHROOM_C0_0_20A_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.replaceable())));
        register(context, RED_MUSHROOM_C0_0_20A_PATCH_KEY, registryLookup.getOrThrow(ConfiguredFeatureInit.RED_MUSHROOM_C0_0_20A_PATCH_KEY),
                List.of(RarityFilterPlacementModifier.of(config.features.red_mushroom_c0_0_20a.chance), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));
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
