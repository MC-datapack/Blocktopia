package github.mcdatapack.blocktopia.worldgen.feature;

import com.google.common.collect.ImmutableList;
import github.mcdatapack.blocktopia.Blocktopia;

import static github.mcdatapack.blocktopia.block.ModBlocks.*;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.*;

import github.mcdatapack.blocktopia.block.FutureBlocks;
import github.mcdatapack.blocktopia.block.custom.ExtendedLeavesBlock;
import github.mcdatapack.blocktopia.worldgen.tree.decorator.LeavesTreeDecorator;
import github.mcdatapack.blocktopia.worldgen.tree.decorator.HangingMossTreeDecorator;
import github.mcdatapack.blocktopia.worldgen.tree.foilageplacer.ExtremeFoliagePlacer;
import github.mcdatapack.blocktopia.worldgen.tree.trunkplacer.ExtremeTrunkPlacer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MushroomBlock;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.CocoaBeansTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.MegaJungleTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public interface ModConfiguredFeatures {
    RegistryKey<ConfiguredFeature<?, ?>> TROPICAL_MOSS_VEGETATION_KEY = registerKey("tropical_moss_vegetation");
    RegistryKey<ConfiguredFeature<?, ?>> TROPICAL_MOSS_PATCH_KEY = registerKey("tropical_moss_patch");
    RegistryKey<ConfiguredFeature<?, ?>> TROPICAL_MOSS_PATCH_BONEMEAL_KEY = registerKey("tropical_moss_patch_bonemeal");

    RegistryKey<ConfiguredFeature<?, ?>> PALE_MOSS_VEGETATION_KEY = registerKey("pale_moss_vegetation");
    RegistryKey<ConfiguredFeature<?, ?>> PALE_MOSS_PATCH_KEY = registerKey("pale_moss_patch");
    RegistryKey<ConfiguredFeature<?, ?>> PALE_MOSS_PATCH_BONEMEAL_KEY = registerKey("pale_moss_patch_bonemeal");

    RegistryKey<ConfiguredFeature<?, ?>> PALM_TREE_KEY = registerKey("palm_tree");
    RegistryKey<ConfiguredFeature<?, ?>> GIANT_3x3BANANA_TREE_KEY = registerKey("giant_3x3_banana_tree");
    RegistryKey<ConfiguredFeature<?, ?>> GIANT_3x3CORN_TREE_KEY = registerKey("giant_3x3_corn_tree");
    RegistryKey<ConfiguredFeature<?, ?>> BIGGEST_CORN_TREE_KEY = registerKey("biggest_corn_tree");
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
    RegistryKey<ConfiguredFeature<?, ?>> LAPIS_ORE_B1_2_KEY = registerKey("lapis_ore_b1_2");
    RegistryKey<ConfiguredFeature<?, ?>> LAPIS_ORE_1_14_KEY = registerKey("lapis_ore_1_14");
    RegistryKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby_ore");
    RegistryKey<ConfiguredFeature<?, ?>> EMERALD_ORE_1_3_KEY = registerKey("emerald_ore_1_3");
    RegistryKey<ConfiguredFeature<?, ?>> EMERALD_ORE_1_14_KEY = registerKey("emerald_ore_1_14");
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
    RegistryKey<ConfiguredFeature<?, ?>> ALLIUM_1_7_KEY = registerKey("allium_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> ALLIUM_1_7_PATCH_KEY = registerKey("allium_1_7_patch");
    RegistryKey<ConfiguredFeature<?, ?>> AZURE_BLUET_1_7_KEY = registerKey("azure_bluet_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> AZURE_BLUET_1_7_PATCH_KEY = registerKey("azure_bluet_1_7_patch");
    RegistryKey<ConfiguredFeature<?, ?>> BLUE_ORCHID_1_7_KEY = registerKey("blue_orchid_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> BLUE_ORCHID_1_7_PATCH_KEY = registerKey("blue_orchid_1_7_patch");
    RegistryKey<ConfiguredFeature<?, ?>> LILAC_1_7_KEY = registerKey("lilac_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> LILAC_1_7_PATCH_KEY = registerKey("lilac_1_7_patch");
    RegistryKey<ConfiguredFeature<?, ?>> PEONY_1_7_KEY = registerKey("peony_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> PEONY_1_7_PATCH_KEY = registerKey("peony_1_7_patch");
    RegistryKey<ConfiguredFeature<?, ?>> ROSE_BUSH_1_7_KEY = registerKey("rose_bush_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> ROSE_BUSH_1_7_PATCH_KEY = registerKey("rose_bush_1_7_patch");
    RegistryKey<ConfiguredFeature<?, ?>> SUNFLOWER_1_7_KEY = registerKey("sunflower_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> SUNFLOWER_1_7_PATCH_KEY = registerKey("sunflower_1_7_patch");
    RegistryKey<ConfiguredFeature<?, ?>> OXEYE_DAISY_1_7_KEY = registerKey("oxeye_daisy_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> OXEYE_DAISY_1_7_PATCH_KEY = registerKey("oxeye_daisy_1_7_patch");
    RegistryKey<ConfiguredFeature<?, ?>> RED_TULIP_1_7_KEY = registerKey("red_tulip_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> RED_TULIP_1_7_PATCH_KEY = registerKey("red_tulip_1_7_patch");
    RegistryKey<ConfiguredFeature<?, ?>> ORANGE_TULIP_1_7_KEY = registerKey("orange_tulip_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> ORANGE_TULIP_1_7_PATCH_KEY = registerKey("orange_tulip_1_7_patch");
    RegistryKey<ConfiguredFeature<?, ?>> WHITE_TULIP_1_7_KEY = registerKey("white_tulip_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> WHITE_TULIP_1_7_PATCH_KEY = registerKey("white_tulip_1_7_patch");
    RegistryKey<ConfiguredFeature<?, ?>> PINK_TULIP_1_7_KEY = registerKey("pink_tulip_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> PINK_TULIP_1_7_PATCH_KEY = registerKey("pink_tulip_1_7_patch");


    RegistryKey<ConfiguredFeature<?, ?>> HUGE_BROWN_MUSHROOM_B1_8_KEY = registerKey("huge_brown_mushroom_b1_8");
    RegistryKey<ConfiguredFeature<?, ?>> HUGE_RED_MUSHROOM_B1_8_KEY = registerKey("huge_red_mushroom_b1_8");

    RegistryKey<ConfiguredFeature<?, ?>> TREE_C0_24ST_KEY = registerKey("tree_c0_24st");
    RegistryKey<ConfiguredFeature<?, ?>> BIRCH_B1_5_KEY = registerKey("birch_b1_5");
    RegistryKey<ConfiguredFeature<?, ?>> BIRCH_1_7_KEY = registerKey("birch_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> SPRUCE_B1_5_KEY = registerKey("spruce_b1_5");
    RegistryKey<ConfiguredFeature<?, ?>> SPRUCE_1_7_KEY = registerKey("spruce_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> JUNGLE_1_2_KEY = registerKey("jungle_1_2");
    RegistryKey<ConfiguredFeature<?, ?>> JUNGLE_1_7_KEY = registerKey("jungle_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> MEGA_JUNGLE_1_2_KEY = registerKey("mega_jungle_1_2");
    RegistryKey<ConfiguredFeature<?, ?>> MEGA_JUNGLE_1_7_KEY = registerKey("mega_jungle_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> ACACIA_1_7_KEY = registerKey("acacia_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> DARK_OAK_1_7_KEY = registerKey("dark_oak_1_7");
    RegistryKey<ConfiguredFeature<?, ?>> PALE_OAK_KEY = registerKey("pale_oak");
    RegistryKey<ConfiguredFeature<?, ?>> PALE_OAK_BONEMEAL_KEY = registerKey("pale_oak_bonemeal");


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

        register(context, PALE_MOSS_VEGETATION_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                new WeightedBlockStateProvider(
                        DataPool.<BlockState>builder()
                                .add(FutureBlocks.PALE_MOSS_CARPET.getDefaultState(), 25)
                                .build()
                )
        ));
        register(context, PALE_MOSS_PATCH_KEY, Feature.VEGETATION_PATCH, new VegetationPatchFeatureConfig(
                BlockTags.MOSS_REPLACEABLE,
                BlockStateProvider.of(FutureBlocks.PALE_MOSS),
                PlacedFeatures.createEntry(configuredFeatureLookup.getOrThrow(PALE_MOSS_VEGETATION_KEY)),
                VerticalSurfaceType.FLOOR,
                ConstantIntProvider.create(1),
                0.0F,
                5,
                0.8F,
                UniformIntProvider.create(4, 7),
                0.3F
        ));
        register(context, PALE_MOSS_PATCH_BONEMEAL_KEY, Feature.VEGETATION_PATCH, new VegetationPatchFeatureConfig(
                BlockTags.MOSS_REPLACEABLE,
                BlockStateProvider.of(FutureBlocks.PALE_MOSS),
                PlacedFeatures.createEntry(configuredFeatureLookup.getOrThrow(PALE_MOSS_VEGETATION_KEY)),
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
                new ExtremeFoliagePlacer(UniformIntProvider.create(7, 11), ConstantIntProvider.create(0), 16),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.05F),
                        new LeavesTreeDecorator(BANANA_LEAVES.getDefaultState().with(ExtendedLeavesBlock.PERSISTENT, Boolean.FALSE)),
                        new HangingMossTreeDecorator(BANANA_HANGING_MOSS.getDefaultState(), 0.8F, 1F, 0.15)))
                .build());
        register(context, GIANT_3x3CORN_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(CORN_LOG),
                new ExtremeTrunkPlacer(32, 24, 24),
                SimpleBlockStateProvider.of(CORN_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(7, 11), ConstantIntProvider.create(0), 16),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.01F),
                        new LeavesTreeDecorator(CORN_LEAVES.getDefaultState().with(ExtendedLeavesBlock.PERSISTENT, Boolean.FALSE)),
                        new HangingMossTreeDecorator(CORN_HANGING_MOSS.getDefaultState(), 0.8F, 1F, 0.15)))
                .build());
        register(context, BIGGEST_CORN_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(CORN_LOG),
                new ExtremeTrunkPlacer(32, 24, 24, true),
                SimpleBlockStateProvider.of(CORN_LEAVES),
                new ExtremeFoliagePlacer(ConstantIntProvider.create(11), ConstantIntProvider.create(0), 16),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.01F),
                        new LeavesTreeDecorator(CORN_LEAVES.getDefaultState().with(ExtendedLeavesBlock.PERSISTENT, Boolean.FALSE)),
                        new HangingMossTreeDecorator(CORN_HANGING_MOSS.getDefaultState(), 0.8F, 1F, 0.15)))
                .build());
        register(context, GIANT_3x3POISONED_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(POISONED_LOG),
                new ExtremeTrunkPlacer(32, 24, 24),
                SimpleBlockStateProvider.of(POISONED_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(7, 11), ConstantIntProvider.create(0), 16),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.5F),
                        new LeavesTreeDecorator(POISONED_LEAVES.getDefaultState().with(ExtendedLeavesBlock.PERSISTENT, Boolean.FALSE)),
                        new HangingMossTreeDecorator(POISONED_HANGING_MOSS.getDefaultState(), 0.8F, 1F, 0.15)))
                .build());
        register(context, GIANT_3x3FLOWERING_CHERRY_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(Blocks.CHERRY_LOG),
                new ExtremeTrunkPlacer(32, 20, 20),
                SimpleBlockStateProvider.of(FLOWERING_CHERRY_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(7, 11), ConstantIntProvider.create(0), 14),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new LeavesTreeDecorator(FLOWERING_CHERRY_LEAVES.getDefaultState().with(ExtendedLeavesBlock.PERSISTENT, Boolean.FALSE)),
                        new HangingMossTreeDecorator(FLOWERING_CHERRY_HANGING_MOSS.getDefaultState(), 0.8F, 1F, 0.15)))
                .build());
        register(context, GIANT_3x3MAHOGANY_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(MAHOGANY_LOG),
                new ExtremeTrunkPlacer(48, 24, 24),
                SimpleBlockStateProvider.of(MAHOGANY_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(7, 11), ConstantIntProvider.create(0), 16),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.05F),
                        new HangingMossTreeDecorator(MAHOGANY_HANGING_MOSS.getDefaultState(), 0.8F, 1F, 0.15)))
                .build());
        register(context, GIANT_BANANA_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(BANANA_LOG),
                new MegaJungleTrunkPlacer(24, 16, 16),
                SimpleBlockStateProvider.of(BANANA_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(3, 6), ConstantIntProvider.create(0), 10),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.05F)))
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
                        new LeavesVineTreeDecorator(0.05F)))
                .build());
        register(context, BANANA_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(BANANA_LOG),
                new StraightTrunkPlacer(16, 10, 10),
                SimpleBlockStateProvider.of(BANANA_LEAVES),
                new ExtremeFoliagePlacer(UniformIntProvider.create(2, 4), ConstantIntProvider.create(0), 6),
                new TwoLayersFeatureSize(1, 1, 1))
                .decorators(List.of(
                        new CocoaBeansTreeDecorator(0.5F),
                        new LeavesVineTreeDecorator(0.05F)))
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
                        new LeavesVineTreeDecorator(0.05F)))
                .build());
        register(context, GLOW_FLOWER_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(GLOW_FLOWER.getDefaultState().with(Properties.WATERLOGGED, false))
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

        register(context, HUGE_RED_MUSHROOM_B1_8_KEY, Feature.HUGE_RED_MUSHROOM, new HugeMushroomFeatureConfig(
                BlockStateProvider.of(RED_MUSHROOM_BLOCK_B1_8.getDefaultState().with(MushroomBlock.DOWN, false)),
                BlockStateProvider.of(MUSHROOM_STEM_B1_8.getDefaultState().with(MushroomBlock.UP, false).with(MushroomBlock.DOWN, false)),
                2
        ));
        register(context, HUGE_BROWN_MUSHROOM_B1_8_KEY, Feature.HUGE_RED_MUSHROOM, new HugeMushroomFeatureConfig(
                BlockStateProvider.of(BROWN_MUSHROOM_BLOCK_B1_8.getDefaultState().with(MushroomBlock.UP, true).with(MushroomBlock.DOWN, false)),
                BlockStateProvider.of(MUSHROOM_STEM_B1_8.getDefaultState().with(MushroomBlock.UP, false).with(MushroomBlock.DOWN, false)),
                3
        ));
        register(context, ALLIUM_1_7_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(ALLIUM_1_7)
        ));
        register(context, ALLIUM_1_7_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.ALLIUM_1_7_KEY)
        ));
        register(context, AZURE_BLUET_1_7_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(AZURE_BLUET_1_7)
        ));
        register(context, AZURE_BLUET_1_7_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.AZURE_BLUET_1_7_KEY)
        ));
        register(context, BLUE_ORCHID_1_7_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(BLUE_ORCHID_1_7)
        ));
        register(context, BLUE_ORCHID_1_7_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.BLUE_ORCHID_1_7_KEY)
        ));
        register(context, LILAC_1_7_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(LILAC_1_7)
        ));
        register(context, LILAC_1_7_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.LILAC_1_7_KEY)
        ));
        register(context, PEONY_1_7_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(PEONY_1_7)
        ));
        register(context, PEONY_1_7_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.PEONY_1_7_KEY)
        ));
        register(context, ROSE_BUSH_1_7_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(ROSE_BUSH_1_7)
        ));
        register(context, ROSE_BUSH_1_7_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.ROSE_BUSH_1_7_KEY)
        ));
        register(context, SUNFLOWER_1_7_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(SUNFLOWER_1_7)
        ));
        register(context, SUNFLOWER_1_7_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.SUNFLOWER_1_7_KEY)
        ));
        register(context, OXEYE_DAISY_1_7_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(OXEYE_DAISY_1_7)
        ));
        register(context, OXEYE_DAISY_1_7_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.OXEYE_DAISY_1_7_KEY)
        ));
        register(context, RED_TULIP_1_7_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(RED_TULIP_1_7)
        ));
        register(context, RED_TULIP_1_7_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.RED_TULIP_1_7_KEY)
        ));
        register(context, ORANGE_TULIP_1_7_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(ORANGE_TULIP_1_7)
        ));
        register(context, ORANGE_TULIP_1_7_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.ORANGE_TULIP_1_7_KEY)
        ));
        register(context, WHITE_TULIP_1_7_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(WHITE_TULIP_1_7)
        ));
        register(context, WHITE_TULIP_1_7_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.WHITE_TULIP_1_7_KEY)
        ));
        register(context, PINK_TULIP_1_7_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(WHITE_TULIP_1_7)
        ));
        register(context, PINK_TULIP_1_7_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                32, 10, 5, registryLookup.getOrThrow(ModPlacedFeatures.PINK_TULIP_1_7_KEY)
        ));





        register(context, TREE_C0_24ST_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(LOG_C0_0_14A),
                new StraightTrunkPlacer(4, 2, 0),
                SimpleBlockStateProvider.of(LEAVES_C0_24ST),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        ).build());
        register(context, BIRCH_B1_5_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(BIRCH_LOG_B1_2),
                new StraightTrunkPlacer(5,2,0),
                SimpleBlockStateProvider.of(BIRCH_LEAVES_B1_2),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        ).build());
        register(context, SPRUCE_B1_5_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(SPRUCE_LOG_B1_2),
                new StraightTrunkPlacer(5,2,1),
                SimpleBlockStateProvider.of(SPRUCE_LEAVES_B1_2),
                new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
                new TwoLayersFeatureSize(2, 0, 2)
        ).build());
        register(context, BIRCH_1_7_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(BIRCH_LOG_1_7),
                new StraightTrunkPlacer(5,2,0),
                SimpleBlockStateProvider.of(BIRCH_LEAVES_B1_2),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        ).build());
        register(context, SPRUCE_1_7_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(SPRUCE_LOG_1_7),
                new StraightTrunkPlacer(5,2,1),
                SimpleBlockStateProvider.of(SPRUCE_LEAVES_B1_2),
                new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
                new TwoLayersFeatureSize(2, 0, 2)
        ).build());
        register(context, MEGA_JUNGLE_1_2_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(JUNGLE_LOG_1_2),
                        new MegaJungleTrunkPlacer(10, 2, 19),
                        BlockStateProvider.of(JUNGLE_LEAVES_1_2),
                        new JungleFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                        new TwoLayersFeatureSize(1, 1, 2)
        ).build());
        register(context, MEGA_JUNGLE_1_7_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(JUNGLE_LOG_1_7),
                new MegaJungleTrunkPlacer(10, 2, 19),
                BlockStateProvider.of(JUNGLE_LEAVES_1_2),
                new JungleFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 1, 2)
        ).build());
        register(context, JUNGLE_1_2_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(JUNGLE_LOG_1_2),
                        new StraightTrunkPlacer(4, 8, 0),
                        BlockStateProvider.of(JUNGLE_LEAVES_1_2),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).ignoreVines().build());
        register(context, JUNGLE_1_7_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(JUNGLE_LOG_1_7),
                        new StraightTrunkPlacer(4, 8, 0),
                        BlockStateProvider.of(JUNGLE_LEAVES_1_2),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines().build());
        register(context, ACACIA_1_7_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ACACIA_LOG_1_7),
                new ForkingTrunkPlacer(5, 2, 2),
                BlockStateProvider.of(ACACIA_LEAVES_1_7),
                new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),
                new TwoLayersFeatureSize(1, 0, 2)
        ).ignoreVines().build());
        register(context, DARK_OAK_1_7_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(DARK_OAK_LOG_1_7),
                new DarkOakTrunkPlacer(6, 2, 1),
                BlockStateProvider.of(DARK_OAK_LEAVES_1_7),
                new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
        ).ignoreVines().build());

        ConfiguredFeatures.register(context, PALE_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(FutureBlocks.PALE_OAK_LOG),
                        new DarkOakTrunkPlacer(6, 2, 1),
                        BlockStateProvider.of(FutureBlocks.PALE_OAK_LEAVES),
                        new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                        new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
                ).decorators(ImmutableList.of(new HangingMossTreeDecorator(FutureBlocks.PALE_HANGING_MOSS.getDefaultState(), 0.15F, 0.4F, 0.5, 0.8F))).ignoreVines().build()
        );
        ConfiguredFeatures.register(context, PALE_OAK_BONEMEAL_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(FutureBlocks.PALE_OAK_LOG),
                        new DarkOakTrunkPlacer(6, 2, 1),
                        BlockStateProvider.of(FutureBlocks.PALE_OAK_LEAVES),
                        new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                        new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
                ).ignoreVines().build()
        );

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
        List<OreFeatureConfig.Target> overworldTargetsLapis_IN20100128 = List.of(
                OreFeatureConfig.createTarget(overworldOreReplaceables, LAPIS_ORE_B1_2.getDefaultState()));
        List<OreFeatureConfig.Target> overworldTargetsLapis_1_14 = List.of(
                OreFeatureConfig.createTarget(overworldOreReplaceables, LAPIS_ORE_1_14.getDefaultState()));
        List<OreFeatureConfig.Target> overworldTargetsRuby = List.of(
                OreFeatureConfig.createTarget(overworldOreReplaceables, RUBY_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldTargetsEmerald1_3 = List.of(
                OreFeatureConfig.createTarget(overworldOreReplaceables, EMERALD_ORE_1_3.getDefaultState()));
        List<OreFeatureConfig.Target> overworldTargetsEmerald1_14 = List.of(
                OreFeatureConfig.createTarget(overworldOreReplaceables, EMERALD_ORE_1_14.getDefaultState()));


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
        register(context, LAPIS_ORE_B1_2_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsLapis_IN20100128, 9, 0));
        register(context, LAPIS_ORE_1_14_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsLapis_1_14, 9, 0));
        register(context, RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsRuby, 12, 0.125F));
        register(context, EMERALD_ORE_1_3_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsEmerald1_3, 9, 0));
        register(context, EMERALD_ORE_1_14_KEY, Feature.ORE, new OreFeatureConfig(overworldTargetsEmerald1_14, 9, 0));
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
