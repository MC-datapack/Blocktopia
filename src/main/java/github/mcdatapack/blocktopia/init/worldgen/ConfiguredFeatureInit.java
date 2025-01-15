package github.mcdatapack.blocktopia.init.worldgen;

import github.mcdatapack.blocktopia.Blocktopia;
import static github.mcdatapack.blocktopia.init.blocks.BlockInit.*;
import static github.mcdatapack.blocktopia.init.blocks.LegacyBlocks.*;

import github.mcdatapack.blocktopia.block.ExtendedLeavesBlock;
import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.config.BlocktopiaConfigData;
import net.minecraft.block.Blocks;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.treedecorator.CocoaBeansTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ConfiguredFeatureInit {
    private static final BlocktopiaConfigData.WorldgenFeatureConfig config = BlocktopiaConfig.getConfig().worldgenConfig.worldgenFeatures;

    public static final RegistryKey<ConfiguredFeature<?, ?>> PALM_TREE_KEY = registerKey("palm_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BANANA_TREE_KEY = registerKey("banana_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWERING_CHERRY_KEY = registerKey("flowering_cherry");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GLOW_FLOWER_KEY = registerKey("glow_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GLOW_FLOWER_PATCH_KEY = registerKey("glow_flower_patch");
    //Legacy
    public static final RegistryKey<ConfiguredFeature<?, ?>> COAL_ORE_C0_0_14A_KEY = registerKey("coal_ore_c0_0_14a");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COAL_ORE_1_14_KEY = registerKey("coal_ore_1_14");
    public static final RegistryKey<ConfiguredFeature<?, ?>> IRON_ORE_C0_0_14A_KEY = registerKey("iron_ore_c0_0_14a");
    public static final RegistryKey<ConfiguredFeature<?, ?>> IRON_ORE_1_14_KEY = registerKey("iron_ore_1_14");
    public static final RegistryKey<ConfiguredFeature<?, ?>> IRON_ORE_1_14_1_KEY = registerKey("iron_ore_1_14_4");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GOLD_ORE_C0_0_14A_KEY = registerKey("gold_ore_c0_0_14a");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GOLD_ORE_C0_26ST_KEY = registerKey("gold_ore_c0_26st");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GOLD_ORE_1_14_KEY = registerKey("gold_ore_1_14");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIAMOND_ORE_IN20100128_KEY = registerKey("diamond_ore_in20100128");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIAMOND_ORE_1_14_KEY = registerKey("diamond_ore_1_14");
    //public static final RegistryKey<ConfiguredFeature<?, ?>> LAPIS_ORE_B1_2_KEY = registerKey("lapis_ore_b1_2");
    //public static final RegistryKey<ConfiguredFeature<?, ?>> LAPIS_ORE_1_14_KEY = registerKey("lapis_ore_1_14");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DANDELION_C0_0_20A_KEY = registerKey("dandelion_c0_0_20a");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DANDELION_C0_0_20A_PATCH_KEY = registerKey("dandelion_c0_0_20a_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ROSE_C0_0_20A_KEY = registerKey("rose_c0_0_20a");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ROSE_C0_0_20A_PATCH_KEY = registerKey("rose_c0_0_20a_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> POPPY_1_7_KEY = registerKey("poppy_1_7");
    public static final RegistryKey<ConfiguredFeature<?, ?>> POPPY_1_7_PATCH_KEY = registerKey("poppy_1_7_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BROWN_MUSHROOM_C0_0_20A_KEY = registerKey("brown_mushroom_c0_0_20a");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BROWN_MUSHROOM_C0_0_20A_PATCH_KEY = registerKey("brown_mushroom_c0_0_20a_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_MUSHROOM_C0_0_20A_KEY = registerKey("red_mushroom_c0_0_20a");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_MUSHROOM_C0_0_20A_PATCH_KEY = registerKey("red_mushroom_c0_0_20a_patch");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TREE_C0_24ST_KEY = registerKey("tree_c0_24st");
    //public static final RegistryKey<ConfiguredFeature<?, ?>> BIRCH_B1_5_KEY = registerKey("birch_b1_5");
    //public static final RegistryKey<ConfiguredFeature<?, ?>> SPRUCE_B1_5_KEY = registerKey("spruce_b1_5");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RegistryEntryLookup<PlacedFeature> registryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RuleTest overworldOreReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);

        register(context, PALM_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(PALM_LOG),
                new ForkingTrunkPlacer(4, 4, 6),
                SimpleBlockStateProvider.of(PALM_LEAVES),
                new AcaciaFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(4, 1, 4)
        ).build());
        register(context, BANANA_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(BANANA_LOG),
                new ExtremeTrunkPlacer(32, 24, 24),
                SimpleBlockStateProvider.of(BANANA_LEAVES),
                new BlobFoliagePlacer(UniformIntProvider.create(5, 9), ConstantIntProvider.create(0), 16),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.8F),
                        new LeavesTreeDecorator(BANANA_LEAVES.getDefaultState().with(ExtendedLeavesBlock.PERSISTENT, Boolean.FALSE))))
                .build());
        register(context, FLOWERING_CHERRY_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(Blocks.CHERRY_LOG),
                new ExtremeTrunkPlacer(24, 20, 20),
                SimpleBlockStateProvider.of(FLOWERING_CHERRY_LEAVES),
                new BlobFoliagePlacer(UniformIntProvider.create(3, 7), ConstantIntProvider.create(0), 14),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new LeavesTreeDecorator(FLOWERING_CHERRY_LEAVES.getDefaultState().with(ExtendedLeavesBlock.PERSISTENT, Boolean.FALSE))))
                .build());
        register(context, GLOW_FLOWER_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(GLOW_FLOWER)
        ));
        register(context, GLOW_FLOWER_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(PlacedFeatureInit.GLOW_FLOWER_KEY)
        ));


        register(context, DANDELION_C0_0_20A_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(DANDELION_C0_0_20A)
        ));
        register(context, DANDELION_C0_0_20A_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(PlacedFeatureInit.DANDELION_C0_0_20A_KEY)
        ));
        register(context, ROSE_C0_0_20A_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(ROSE_C0_0_20A)
        ));
        register(context, ROSE_C0_0_20A_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(PlacedFeatureInit.ROSE_C0_0_20A_KEY)
        ));
        register(context, POPPY_1_7_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(POPPY_1_7)
        ));
        register(context, POPPY_1_7_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(PlacedFeatureInit.POPPY_1_7_KEY)
        ));
        register(context, BROWN_MUSHROOM_C0_0_20A_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(BROWN_MUSHROOM_C0_0_20A)
        ));
        register(context, BROWN_MUSHROOM_C0_0_20A_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(PlacedFeatureInit.BROWN_MUSHROOM_C0_0_20A_KEY)
        ));
        register(context, RED_MUSHROOM_C0_0_20A_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(RED_MUSHROOM_C0_0_20A)
        ));
        register(context, RED_MUSHROOM_C0_0_20A_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(PlacedFeatureInit.RED_MUSHROOM_C0_0_20A_KEY)
        ));


        register(context, TREE_C0_24ST_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(LOG_C0_0_14A),
                new StraightTrunkPlacer(4, 2, 0),
                SimpleBlockStateProvider.of(LEAVES_C0_24ST),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        ).build());
        //register(context, BIRCH_B1_5_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
        //        SimpleBlockStateProvider.of(BIRCH_LOG_B1_2),
        //        new StraightTrunkPlacer(5,2,0),
        //        SimpleBlockStateProvider.of(BIRCH_LEAVES_B1_2),
        //        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
        //        new TwoLayersFeatureSize(1, 0, 1)
        //).build());
        //register(context, SPRUCE_B1_5_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
        //        SimpleBlockStateProvider.of(SPRUCE_LOG_B1_2),
        //        new StraightTrunkPlacer(5,2,1),
        //        SimpleBlockStateProvider.of(SPRUCE_LEAVES_B1_2),
        //        new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
        //        new TwoLayersFeatureSize(2, 0, 2)
        //).build());

        List<OreFeatureConfig.Target> overworldTargetsCoal_C0_0_14A = List.of(
                OreFeatureConfig.createTarget(overworldOreReplaceables, COAL_ORE_C0_0_14A.getDefaultState()));
        List<OreFeatureConfig.Target> overworldTargetsCoal_1_14 = List.of(
                OreFeatureConfig.createTarget(overworldOreReplaceables, COAL_ORE_1_14.getDefaultState()));
        List<OreFeatureConfig.Target> overworldTargetsIron_C0_0_14A = List.of(
                OreFeatureConfig.createTarget(overworldOreReplaceables, IRON_ORE_C0_0_14A.getDefaultState()));
        List<OreFeatureConfig.Target> overworldTargetsIron_1_14 = List.of(
            OreFeatureConfig.createTarget(overworldOreReplaceables, IRON_ORE_1_14.getDefaultState()));
        List<OreFeatureConfig.Target> overworldTargetsIron_1_14_1 = List.of(
            OreFeatureConfig.createTarget(overworldOreReplaceables, IRON_ORE_1_14_1.getDefaultState()));
        List<OreFeatureConfig.Target> overworldTargetsGold_C0_0_14A = List.of(
                OreFeatureConfig.createTarget(overworldOreReplaceables, GOLD_ORE_C0_0_14A.getDefaultState()));
        List<OreFeatureConfig.Target> overworldTargetsGold_C0_24ST = List.of(
                OreFeatureConfig.createTarget(overworldOreReplaceables, GOLD_ORE_C0_26ST.getDefaultState()));
        List<OreFeatureConfig.Target> overworldTargetsGold_1_14 = List.of(
                OreFeatureConfig.createTarget(overworldOreReplaceables, GOLD_ORE_1_14.getDefaultState()));
        List<OreFeatureConfig.Target> overworldTargetsDiamond_IN20100128 = List.of(
                OreFeatureConfig.createTarget(overworldOreReplaceables, DIAMOND_ORE_IN20100128.getDefaultState()));
        List<OreFeatureConfig.Target> overworldTargetsDiamond_1_14 = List.of(
                OreFeatureConfig.createTarget(overworldOreReplaceables, DIAMOND_ORE_1_14.getDefaultState()));
        //List<OreFeatureConfig.Target> overworldTargetsLapis_IN20100128 = List.of(
        //        OreFeatureConfig.createTarget(overworldOreReplaceables, LAPIS_ORE_B1_2.getDefaultState()));
        //List<OreFeatureConfig.Target> overworldTargetsLapis_1_14 = List.of(
        //        OreFeatureConfig.createTarget(overworldOreReplaceables, LAPIS_ORE_1_14.getDefaultState()));


        register(context, COAL_ORE_C0_0_14A_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsCoal_C0_0_14A, config.features.legacy_coal_ores.size, 0));
        register(context, COAL_ORE_1_14_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsCoal_1_14, config.features.legacy_coal_ores.size, 0));
        register(context, IRON_ORE_C0_0_14A_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsIron_C0_0_14A, config.features.legacy_iron_ores.size, 0));
        register(context, IRON_ORE_1_14_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsIron_1_14, config.features.legacy_iron_ores.size, 0));
        register(context, IRON_ORE_1_14_1_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsIron_1_14_1, config.features.legacy_iron_ores.size, 0));
        register(context, GOLD_ORE_C0_0_14A_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsGold_C0_0_14A, config.features.legacy_gold_ores.size, 0));
        register(context, GOLD_ORE_C0_26ST_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsGold_C0_24ST, config.features.legacy_gold_ores.size, 0));
        register(context, GOLD_ORE_1_14_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsGold_1_14, config.features.legacy_gold_ores.size, 0));
        register(context, DIAMOND_ORE_IN20100128_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsDiamond_IN20100128, config.features.legacy_diamond_ores.size, 0));
        register(context, DIAMOND_ORE_1_14_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsDiamond_1_14, config.features.legacy_diamond_ores.size, 0));
        //register(context, LAPIS_ORE_B1_2_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsLapis_IN20100128, config.features.legacy_lapis_ores.size, 0));
        //register(context, LAPIS_ORE_1_14_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsLapis_1_14, config.features.legacy_lapis_ores.size, 0));
    }

    private static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Blocktopia.id(name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key,
                                                                                   F feature, FC featureConfig) {
        context.register(key, new ConfiguredFeature<>(feature, featureConfig));
    }
}
