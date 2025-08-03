package github.mcdatapack.blocktopia.worldgen.tree.sapling;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.worldgen.feature.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

public interface ModSaplingGenerators {
    SaplingGenerator PALM = new ExtendedSaplingGenerator.Builder()
            .regularVariant(ModConfiguredFeatures.PALM_TREE_KEY)
            .build(Blocktopia.id("palm"));
    SaplingGenerator BANANA = new ExtendedSaplingGenerator.Builder()
            .regularVariant(ModConfiguredFeatures.BANANA_TREE_KEY)
            .megaVariant(ModConfiguredFeatures.GIANT_BANANA_TREE_KEY)
            .mega3x3Variant(ModConfiguredFeatures.GIANT_3x3BANANA_TREE_KEY)
            .build(Blocktopia.id("banana"));
    SaplingGenerator FLOWERING_CHERRY = new ExtendedSaplingGenerator.Builder()
            .regularVariant(ModConfiguredFeatures.FLOWERING_CHERRY_KEY)
            .megaVariant(ModConfiguredFeatures.GIANT_FLOWERING_CHERRY_KEY)
            .mega3x3Variant(ModConfiguredFeatures.GIANT_3x3FLOWERING_CHERRY_KEY)
            .build(Blocktopia.id("flowering_cherry"));
    SaplingGenerator CORN = new ExtendedSaplingGenerator.Builder()
            .regularVariant(ModConfiguredFeatures.CORN_TREE_KEY)
            .megaVariant(ModConfiguredFeatures.GIANT_CORN_TREE_KEY)
            .mega3x3Variant(ModConfiguredFeatures.GIANT_3x3CORN_TREE_KEY)
            .build(Blocktopia.id("corn"));
    SaplingGenerator POISONED = new ExtendedSaplingGenerator.Builder()
            .regularVariant(ModConfiguredFeatures.POISONED_TREE_KEY)
            .megaVariant(ModConfiguredFeatures.GIANT_POISONED_TREE_KEY)
            .mega3x3Variant(ModConfiguredFeatures.GIANT_3x3POISONED_TREE_KEY)
            .build(Blocktopia.id("corn"));
    SaplingGenerator MAHOGANY = new ExtendedSaplingGenerator.Builder()
            .regularVariant(ModConfiguredFeatures.MAHOGANY_TREE_KEY)
            .megaVariant(ModConfiguredFeatures.GIANT_MAHOGANY_TREE_KEY)
            .mega3x3Variant(ModConfiguredFeatures.GIANT_3x3MAHOGANY_TREE_KEY)
            .build(Blocktopia.id("mahogany"));

    SaplingGenerator LEGACY_C0_24ST = new ExtendedSaplingGenerator.Builder()
            .regularVariant(ModConfiguredFeatures.TREE_C0_24ST_KEY)
            .build(Blocktopia.id("legacy_c0_24st"));
    SaplingGenerator BIRCH_B1_5 = new ExtendedSaplingGenerator.Builder()
            .regularVariant(ModConfiguredFeatures.BIRCH_B1_5_KEY)
            .rareRegularVariant(ModConfiguredFeatures.BIRCH_1_7_KEY)
            .build(Blocktopia.id("birch_b1_5"));
    SaplingGenerator SPRUCE_B1_5 = new ExtendedSaplingGenerator.Builder()
            .regularVariant(ModConfiguredFeatures.SPRUCE_B1_5_KEY)
            .rareRegularVariant(ModConfiguredFeatures.SPRUCE_1_7_KEY)
            .build(Blocktopia.id("spruce_b1_5"));
    SaplingGenerator JUNGLE_1_2 = new ExtendedSaplingGenerator.Builder()
            .rareChance(0.4F)
            .regularVariant(ModConfiguredFeatures.JUNGLE_1_2_KEY)
            .rareRegularVariant(ModConfiguredFeatures.JUNGLE_1_7_KEY)
            .megaVariant(ModConfiguredFeatures.MEGA_JUNGLE_1_2_KEY)
            .rareMegaVariant(ModConfiguredFeatures.MEGA_JUNGLE_1_7_KEY)
            .build(Blocktopia.id("jungle_1_2"));
    SaplingGenerator ACACIA_1_7 = new ExtendedSaplingGenerator.Builder()
            .regularVariant(ModConfiguredFeatures.ACACIA_1_7_KEY)
            .build(Blocktopia.id("acacia_1_7"));
    SaplingGenerator DARK_OAK_1_7 = new ExtendedSaplingGenerator.Builder()
            .megaVariant(ModConfiguredFeatures.DARK_OAK_1_7_KEY)
            .build(Blocktopia.id("dark_oak_1_7"));
    SaplingGenerator PALE_OAK = new ExtendedSaplingGenerator.Builder()
            .megaVariant(ModConfiguredFeatures.PALE_OAK_BONEMEAL_KEY)
            .build(Blocktopia.id("pale_oak"));
}