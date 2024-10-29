package github.mcdatapack.blocktopia.init.worldgen;

import github.mcdatapack.blocktopia.Blocktopia;
import static github.mcdatapack.blocktopia.init.blocks.BlockInit.*;
import static github.mcdatapack.blocktopia.init.blocks.LegacyBlocks.*;

import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ConfiguredFeatureInit {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALM_TREE_KEY = registerKey("palm_tree");
    //Legacy
    public static final RegistryKey<ConfiguredFeature<?, ?>> COAL_ORE_C0_0_14A_KEY = registerKey("coal_ore_c0_0_14a");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COAL_ORE_1_14_KEY = registerKey("coal_ore_1_14");
    public static final RegistryKey<ConfiguredFeature<?, ?>> IRON_ORE_C0_0_14A_KEY = registerKey("iron_ore_c0_0_14a");
    public static final RegistryKey<ConfiguredFeature<?, ?>> IRON_ORE_1_14_KEY = registerKey("iron_ore_1_14");
    public static final RegistryKey<ConfiguredFeature<?, ?>> IRON_ORE_1_14_1_KEY = registerKey("iron_ore_1_14_4");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GOLD_ORE_C0_0_14A_KEY = registerKey("gold_ore_c0_0_14a");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GOLD_ORE_C0_26ST_KEY = registerKey("gold_ore_c0_26st");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GOLD_ORE_1_14_KEY = registerKey("gold_ore_1_14");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TREE_C0_24ST_KEY = registerKey("tree_c0_24st");
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

        register(context, COAL_ORE_C0_0_14A_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsCoal_C0_0_14A, 17, 0));
        register(context, COAL_ORE_1_14_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsCoal_1_14, 17, 0));
        register(context, IRON_ORE_C0_0_14A_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsIron_C0_0_14A, 9, 0));
        register(context, IRON_ORE_1_14_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsIron_1_14, 9, 0));
        register(context, IRON_ORE_1_14_1_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsIron_1_14_1, 9, 0));
        register(context, GOLD_ORE_C0_0_14A_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsGold_C0_0_14A, 9, 0));
        register(context, GOLD_ORE_C0_26ST_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsGold_C0_24ST, 9, 0));
        register(context, GOLD_ORE_1_14_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsGold_1_14, 9, 0));
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
