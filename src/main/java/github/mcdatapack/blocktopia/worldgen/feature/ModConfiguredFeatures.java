package github.mcdatapack.blocktopia.worldgen.feature;

import github.mcdatapack.blocktopia.Blocktopia;
import static github.mcdatapack.blocktopia.block.ModBlocks.*;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.*;

import github.mcdatapack.blocktopia.block.custom.ExtendedLeavesBlock;
import github.mcdatapack.blocktopia.worldgen.tree.decorator.LeavesTreeDecorator;
import github.mcdatapack.blocktopia.worldgen.tree.foilageplacer.ExtremeFoliagePlacer;
import github.mcdatapack.blocktopia.worldgen.tree.trunkplacer.ExtremeTrunkPlacer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.CocoaBeansTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.MegaJungleTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public interface ModConfiguredFeatures {
    RegistryKey<ConfiguredFeature<?, ?>> TROPICAL_MOSS_VEGETATION_KEY = registerKey("tropical_moss_vegetation");
    RegistryKey<ConfiguredFeature<?, ?>> TROPICAL_MOSS_PATCH_KEY = registerKey("tropical_moss_patch");
    RegistryKey<ConfiguredFeature<?, ?>> TROPICAL_MOSS_PATCH_BONEMEAL_KEY = registerKey("tropical_moss_patch_bonemeal");

    RegistryKey<ConfiguredFeature<?, ?>> PALM_TREE_KEY = registerKey("palm_tree");
    RegistryKey<ConfiguredFeature<?, ?>> GIANT_3x3BANANA_TREE_KEY = registerKey("giant_3x3_banana_tree");
    RegistryKey<ConfiguredFeature<?, ?>> GIANT_3x3CORN_TREE_KEY = registerKey("giant_3x3_corn_tree");
    RegistryKey<ConfiguredFeature<?, ?>> GIANT_3x3FLOWERING_CHERRY_KEY = registerKey("giant_3x3_flowering_cherry");
    RegistryKey<ConfiguredFeature<?, ?>> GIANT_3x3POISONED_TREE_KEY = registerKey("giant_3x3_poisoned_tree");
    RegistryKey<ConfiguredFeature<?, ?>> GIANT_3x3MAHOGANY_TREE_KEY = registerKey("giant_3x3_mahogany_tree");
    RegistryKey<ConfiguredFeature<?, ?>> GIANT_BANANA_TREE_KEY = registerKey("giant_banana_tree");
    RegistryKey<ConfiguredFeature<?, ?>> GIANT_CORN_TREE_KEY = registerKey("giant_corn_tree");
    RegistryKey<ConfiguredFeature<?, ?>> GIANT_FLOWERING_CHERRY_KEY = registerKey("giant_flowering_cherry");
    RegistryKey<ConfiguredFeature<?, ?>> GIANT_POISONED_TREE_KEY = registerKey("giant_poisoned_tree");
    RegistryKey<ConfiguredFeature<?, ?>> GIANT_MAHOGANY_TREE_KEY = registerKey("giant_mahogany_tree");
    RegistryKey<ConfiguredFeature<?, ?>> BANANA_TREE_KEY = registerKey("banana_tree");
    RegistryKey<ConfiguredFeature<?, ?>> CORN_TREE_KEY = registerKey("corn_tree");
    RegistryKey<ConfiguredFeature<?, ?>> FLOWERING_CHERRY_KEY = registerKey("flowering_cherry_tree");
    RegistryKey<ConfiguredFeature<?, ?>> POISONED_TREE_KEY = registerKey("poisoned_tree");
    RegistryKey<ConfiguredFeature<?, ?>> MAHOGANY_TREE_KEY = registerKey("mahogany_tree");
    RegistryKey<ConfiguredFeature<?, ?>> GLOW_FLOWER_KEY = registerKey("glow_flower");
    RegistryKey<ConfiguredFeature<?, ?>> GLOW_FLOWER_PATCH_KEY = registerKey("glow_flower_patch");
    //Legacy
    RegistryKey<ConfiguredFeature<?, ?>> COAL_ORE_C0_0_14A_KEY = registerKey("coal_ore_c0_0_14a");
    RegistryKey<ConfiguredFeature<?, ?>> COAL_ORE_1_14_KEY = registerKey("coal_ore_1_14");
    RegistryKey<ConfiguredFeature<?, ?>> IRON_ORE_C0_0_14A_KEY = registerKey("iron_ore_c0_0_14a");
    RegistryKey<ConfiguredFeature<?, ?>> IRON_ORE_1_14_KEY = registerKey("iron_ore_1_14");
    RegistryKey<ConfiguredFeature<?, ?>> IRON_ORE_1_14_1_KEY = registerKey("iron_ore_1_14_4");
    RegistryKey<ConfiguredFeature<?, ?>> GOLD_ORE_C0_0_14A_KEY = registerKey("gold_ore_c0_0_14a");
    RegistryKey<ConfiguredFeature<?, ?>> GOLD_ORE_C0_26ST_KEY = registerKey("gold_ore_c0_26st");
    RegistryKey<ConfiguredFeature<?, ?>> GOLD_ORE_1_14_KEY = registerKey("gold_ore_1_14");
    RegistryKey<ConfiguredFeature<?, ?>> DIAMOND_ORE_IN20100128_KEY = registerKey("diamond_ore_in20100128");
    RegistryKey<ConfiguredFeature<?, ?>> DIAMOND_ORE_1_14_KEY = registerKey("diamond_ore_1_14");
    //RegistryKey<ConfiguredFeature<?, ?>> LAPIS_ORE_B1_2_KEY = registerKey("lapis_ore_b1_2");
    //RegistryKey<ConfiguredFeature<?, ?>> LAPIS_ORE_1_14_KEY = registerKey("lapis_ore_1_14");
    RegistryKey<ConfiguredFeature<?, ?>> DANDELION_C0_0_20A_KEY = registerKey("dandelion_c0_0_20a");
    RegistryKey<ConfiguredFeature<?, ?>> DANDELION_C0_0_20A_PATCH_KEY = registerKey("dandelion_c0_0_20a_patch");
    RegistryKey<ConfiguredFeature<?, ?>> ROSE_C0_0_20A_KEY = registerKey("rose_c0_0_20a");
    RegistryKey<ConfiguredFeature<?, ?>> ROSE_C0_0_20A_PATCH_KEY = registerKey("rose_c0_0_20a_patch");
    RegistryKey<ConfiguredFeature<?, ?>> POPPY_1_7_KEY = registerKey("poppy_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> POPPY_1_7_PATCH_KEY = registerKey("poppy_1_7_patch");
    RegistryKey<ConfiguredFeature<?, ?>> BROWN_MUSHROOM_C0_0_20A_KEY = registerKey("brown_mushroom_c0_0_20a");
    RegistryKey<ConfiguredFeature<?, ?>> BROWN_MUSHROOM_C0_0_20A_PATCH_KEY = registerKey("brown_mushroom_c0_0_20a_patch");
    RegistryKey<ConfiguredFeature<?, ?>> RED_MUSHROOM_C0_0_20A_KEY = registerKey("red_mushroom_c0_0_20a");
    RegistryKey<ConfiguredFeature<?, ?>> RED_MUSHROOM_C0_0_20A_PATCH_KEY = registerKey("red_mushroom_c0_0_20a_patch");

    RegistryKey<ConfiguredFeature<?, ?>> TREE_C0_24ST_KEY = registerKey("tree_c0_24st");
    //RegistryKey<ConfiguredFeature<?, ?>> BIRCH_B1_5_KEY = registerKey("birch_b1_5");
    //RegistryKey<ConfiguredFeature<?, ?>> SPRUCE_B1_5_KEY = registerKey("spruce_b1_5");


    static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatureLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntryLookup<PlacedFeature> registryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RuleTest overworldOreReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);

        register(context, TROPICAL_MOSS_VEGETATION_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                new WeightedBlockStateProvider(
                        DataPool.<BlockState>builder()
                                .add(Blocks.FLOWERING_AZALEA.getDefaultState(), 4)
                                .add(Blocks.AZALEA.getDefaultState(), 7)
                                .add(TROPICAL_MOSS_CARPET.getDefaultState(), 25)
                                .add(Blocks.SHORT_GRASS.getDefaultState(), 50)
                                .add(Blocks.TALL_GRASS.getDefaultState(), 10)
                                .build()
                )
        ));
        register(context, TROPICAL_MOSS_PATCH_KEY, Feature.VEGETATION_PATCH, new VegetationPatchFeatureConfig(
                BlockTags.MOSS_REPLACEABLE,
                BlockStateProvider.of(TROPICAL_MOSS),
                PlacedFeatures.createEntry(configuredFeatureLookup.getOrThrow(TROPICAL_MOSS_VEGETATION_KEY)),
                VerticalSurfaceType.FLOOR,
                ConstantIntProvider.create(1),
                0.0F,
                5,
                0.8F,
                UniformIntProvider.create(4, 7),
                0.3F
        ));
        register(context, TROPICAL_MOSS_PATCH_BONEMEAL_KEY, Feature.VEGETATION_PATCH, new VegetationPatchFeatureConfig(
                BlockTags.MOSS_REPLACEABLE,
                BlockStateProvider.of(TROPICAL_MOSS),
                PlacedFeatures.createEntry(configuredFeatureLookup.getOrThrow(TROPICAL_MOSS_VEGETATION_KEY)),
                VerticalSurfaceType.FLOOR,
                ConstantIntProvider.create(1),
                0.0F,
                5,
                0.6F,
                UniformIntProvider.create(4, 7),
                0.75F
        ));

        register(context, PALM_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(PALM_LOG),
                new ForkingTrunkPlacer(4, 4, 6),
                SimpleBlockStateProvider.of(PALM_LEAVES),
                new AcaciaFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(4, 1, 4)
        ).build());
        register(context, GIANT_3x3BANANA_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(BANANA_LOG),
                new ExtremeTrunkPlacer(48, 24, 24),
                SimpleBlockStateProvider.of(BANANA_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(5, 9), ConstantIntProvider.create(0), 16),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.8F),
                        new LeavesTreeDecorator(BANANA_LEAVES.getDefaultState().with(ExtendedLeavesBlock.PERSISTENT, Boolean.FALSE))))
                .build());
        register(context, GIANT_3x3CORN_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(CORN_LOG),
                new ExtremeTrunkPlacer(32, 24, 24),
                SimpleBlockStateProvider.of(CORN_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(5, 9), ConstantIntProvider.create(0), 16),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.01F),
                        new LeavesTreeDecorator(CORN_LEAVES.getDefaultState().with(ExtendedLeavesBlock.PERSISTENT, Boolean.FALSE))))
                .build());
        register(context, GIANT_3x3POISONED_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(POISONED_LOG),
                new ExtremeTrunkPlacer(32, 24, 24),
                SimpleBlockStateProvider.of(POISONED_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(5, 9), ConstantIntProvider.create(0), 16),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.5F),
                        new LeavesTreeDecorator(POISONED_LEAVES.getDefaultState().with(ExtendedLeavesBlock.PERSISTENT, Boolean.FALSE))))
                .build());
        register(context, GIANT_3x3FLOWERING_CHERRY_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(Blocks.CHERRY_LOG),
                new ExtremeTrunkPlacer(24, 20, 20),
                SimpleBlockStateProvider.of(FLOWERING_CHERRY_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(3, 7), ConstantIntProvider.create(0), 14),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new LeavesTreeDecorator(FLOWERING_CHERRY_LEAVES.getDefaultState().with(ExtendedLeavesBlock.PERSISTENT, Boolean.FALSE))))
                .build());
        register(context, GIANT_3x3MAHOGANY_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(MAHOGANY_LOG),
                new ExtremeTrunkPlacer(48, 24, 24),
                SimpleBlockStateProvider.of(MAHOGANY_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(5, 9), ConstantIntProvider.create(0), 16),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.8F)))
                .build());
        register(context, GIANT_BANANA_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(BANANA_LOG),
                new MegaJungleTrunkPlacer(24, 16, 16),
                SimpleBlockStateProvider.of(BANANA_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(3, 6), ConstantIntProvider.create(0), 10),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.8F)))
                .build());
        register(context, GIANT_CORN_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(CORN_LOG),
                new MegaJungleTrunkPlacer(24, 16, 16),
                SimpleBlockStateProvider.of(CORN_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(3, 6), ConstantIntProvider.create(0), 10),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.01F)))
                .build());
        register(context, GIANT_POISONED_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(POISONED_LOG),
                new MegaJungleTrunkPlacer(24, 16, 16),
                SimpleBlockStateProvider.of(POISONED_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(3, 6), ConstantIntProvider.create(0), 10),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.5F)))
                .build());
        register(context, GIANT_FLOWERING_CHERRY_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(Blocks.CHERRY_LOG),
                new MegaJungleTrunkPlacer(20, 12, 12),
                SimpleBlockStateProvider.of(FLOWERING_CHERRY_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(2, 5), ConstantIntProvider.create(0), 8),
                new TwoLayersFeatureSize(1, 1, 1))
                .build());
        register(context, GIANT_MAHOGANY_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(MAHOGANY_LOG),
                new MegaJungleTrunkPlacer(24, 16, 16),
                SimpleBlockStateProvider.of(MAHOGANY_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(3, 6), ConstantIntProvider.create(0), 10),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.8F)))
                .build());
        register(context, BANANA_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(BANANA_LOG),
                new StraightTrunkPlacer(16, 10, 10),
                SimpleBlockStateProvider.of(BANANA_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(2, 4), ConstantIntProvider.create(0), 6),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.8F)))
                .build());
        register(context, CORN_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(CORN_LOG),
                new StraightTrunkPlacer(16, 10, 10),
                SimpleBlockStateProvider.of(CORN_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(2, 4), ConstantIntProvider.create(0), 6),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.01F)))
                .build());
        register(context, POISONED_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(POISONED_LOG),
                new StraightTrunkPlacer(16, 10, 10),
                SimpleBlockStateProvider.of(POISONED_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(2, 4), ConstantIntProvider.create(0), 6),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.5F)))
                .build());
        register(context, FLOWERING_CHERRY_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(Blocks.CHERRY_LOG),
                new StraightTrunkPlacer(12, 6, 6),
                SimpleBlockStateProvider.of(FLOWERING_CHERRY_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(1, 3), ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(1, 1, 1))
                .build());
        register(context, MAHOGANY_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(MAHOGANY_LOG),
                new StraightTrunkPlacer(16, 10, 10),
                SimpleBlockStateProvider.of(MAHOGANY_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(2, 4), ConstantIntProvider.create(0), 6),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.8F)))
                .build());
        register(context, GLOW_FLOWER_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(GLOW_FLOWER)
        ));
        register(context, GLOW_FLOWER_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                500, 64, 40, registryLookup.getOrThrow(ModPlacedFeatures.GLOW_FLOWER_KEY)
        ));


        register(context, DANDELION_C0_0_20A_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(DANDELION_C0_0_20A)
        ));
        register(context, DANDELION_C0_0_20A_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.DANDELION_C0_0_20A_KEY)
        ));
        register(context, ROSE_C0_0_20A_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(ROSE_C0_0_20A)
        ));
        register(context, ROSE_C0_0_20A_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.ROSE_C0_0_20A_KEY)
        ));
        register(context, POPPY_1_7_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(POPPY_1_7)
        ));
        register(context, POPPY_1_7_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.POPPY_1_7_KEY)
        ));
        register(context, BROWN_MUSHROOM_C0_0_20A_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(BROWN_MUSHROOM_C0_0_20A)
        ));
        register(context, BROWN_MUSHROOM_C0_0_20A_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.BROWN_MUSHROOM_C0_0_20A_KEY)
        ));
        register(context, RED_MUSHROOM_C0_0_20A_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(RED_MUSHROOM_C0_0_20A)
        ));
        register(context, RED_MUSHROOM_C0_0_20A_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.RED_MUSHROOM_C0_0_20A_KEY)
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


        register(context, COAL_ORE_C0_0_14A_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsCoal_C0_0_14A, 17, 0));
        register(context, COAL_ORE_1_14_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsCoal_1_14, 17, 0));
        register(context, IRON_ORE_C0_0_14A_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsIron_C0_0_14A, 9, 0));
        register(context, IRON_ORE_1_14_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsIron_1_14, 9, 0));
        register(context, IRON_ORE_1_14_1_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsIron_1_14_1, 9, 0));
        register(context, GOLD_ORE_C0_0_14A_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsGold_C0_0_14A, 9, 0));
        register(context, GOLD_ORE_C0_26ST_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsGold_C0_24ST, 9, 0));
        register(context, GOLD_ORE_1_14_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsGold_1_14, 9, 0));
        register(context, DIAMOND_ORE_IN20100128_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsDiamond_IN20100128, 9, 0));
        register(context, DIAMOND_ORE_1_14_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsDiamond_1_14, 9, 0));
        //register(context, LAPIS_ORE_B1_2_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsLapis_IN20100128, 9, 0));
        //register(context, LAPIS_ORE_1_14_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsLapis_1_14, 9, 0));
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
