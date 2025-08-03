package github.mcdatapack.blocktopia.worldgen.biome;

import github.mcdatapack.blocktopia.config.BlocktopiaConfigData;
import github.mcdatapack.blocktopia.worldgen.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public interface ModBiomeModifications {
    static void load(BlocktopiaConfigData.PlacedFeatureConfig config) {
        if (config.palm.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.palm.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.PALM_TREE_KEY);
        }

        if (config.tree_c0_24st.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.tree_c0_24st.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.TREE_C0_24ST_KEY);
        }

        if (config.birch_b1_5.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.birch_b1_5.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.BIRCH_B1_5_KEY);
        }

        if (config.birch_1_7.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.birch_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.BIRCH_1_7_KEY);
        }

        if (config.spruce_b1_5.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.spruce_b1_5.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.SPRUCE_B1_5_KEY);
        }

        if (config.spruce_1_7.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.spruce_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.SPRUCE_1_7_KEY);
        }

        if (config.jungle_1_2.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.jungle_1_2.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.JUNGLE_1_2_KEY);
        }

        if (config.jungle_1_7.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.jungle_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.JUNGLE_1_7_KEY);
        }

        if (config.acacia_1_7.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.acacia_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.ACACIA_1_7_KEY);
        }

        if (config.dark_oak_1_7.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.dark_oak_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.DARK_OAK_1_7_KEY);
        }

        if (config.huge_brown_mushroom_b1_8.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.huge_brown_mushroom_b1_8.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.HUGE_BROWN_MUSHROOM_B1_8_KEY
            );
        }

        if (config.huge_red_mushroom_b1_8.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.huge_red_mushroom_b1_8.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.HUGE_RED_MUSHROOM_B1_8_KEY
            );
        }

        if (config.legacy_coal_ores.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    ModPlacedFeatures.COAL_ORE_C0_0_14A_KEY
            );
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    ModPlacedFeatures.COAL_ORE_1_14_KEY
            );
        }

        if (config.legacy_iron_ores.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    ModPlacedFeatures.IRON_ORE_C0_0_14A_KEY
            );
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    ModPlacedFeatures.IRON_ORE_1_14_KEY
            );
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    ModPlacedFeatures.IRON_ORE_1_14_1_KEY
            );
        }

        if (config.legacy_gold_ores.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    ModPlacedFeatures.GOLD_ORE_C0_0_14A_KEY
            );
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    ModPlacedFeatures.GOLD_ORE_C0_26ST_KEY
            );
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    ModPlacedFeatures.GOLD_ORE_1_14_KEY
            );
        }

        if (config.legacy_diamond_ores.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    ModPlacedFeatures.DIAMOND_ORE_IN20100128_KEY
            );
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    ModPlacedFeatures.DIAMOND_ORE_1_14_KEY
            );
        }

        if (config.legacy_lapis_ores.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    ModPlacedFeatures.LAPIS_ORE_B1_2_KEY
            );
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    ModPlacedFeatures.LAPIS_ORE_1_14_KEY
            );
        }

        if (config.ruby_ores.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    ModPlacedFeatures.RUBY_ORE_KEY
            );
        }

        if (config.legacy_emerald_ores.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    ModPlacedFeatures.EMERALD_ORE_1_3_KEY
            );
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    ModPlacedFeatures.EMERALD_ORE_1_14_KEY
            );
        }


        if (config.dandelion_c0_0_20a.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.dandelion_c0_0_20a.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.DANDELION_C0_0_20A_PATCH_KEY
            );
        }

        if (config.rose_c0_0_20a.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.rose_c0_0_20a.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.ROSE_C0_0_20A_PATCH_KEY
            );
        }

        if (config.poppy_1_7.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.poppy_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.POPPY_1_7_PATCH_KEY
            );
        }

        if (config.brown_mushroom_c0_0_20a.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.brown_mushroom_c0_0_20a.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.BROWN_MUSHROOM_C0_0_20A_PATCH_KEY
            );
        }

        if (config.red_mushroom_c0_0_20a.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.red_mushroom_c0_0_20a.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.RED_MUSHROOM_C0_0_20A_PATCH_KEY
            );
        }

        if (config.allium_1_7.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.allium_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.ALLIUM_1_7_PATCH_KEY
            );
        }

        if (config.azure_bluet_1_7.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.azure_bluet_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.AZURE_BLUET_1_7_PATCH_KEY
            );
        }

        if (config.blue_orchid_1_7.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.blue_orchid_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.BLUE_ORCHID_1_7_PATCH_KEY
            );
        }

        if (config.lilac_1_7.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.lilac_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.LILAC_1_7_PATCH_KEY
            );
        }

        if (config.peony_1_7.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.peony_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.PEONY_1_7_KEY
            );
        }

        if (config.rose_bush_1_7.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.rose_bush_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.ROSE_BUSH_1_7_PATCH_KEY
            );
        }

        if (config.sunflower_1_7.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.sunflower_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.SUNFLOWER_1_7_PATCH_KEY
            );
        }

        if (config.oxeye_daisy_1_7.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.oxeye_daisy_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.OXEYE_DAISY_1_7_PATCH_KEY
            );
        }

        if (config.tulips_1_7.generate) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.tulips_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.RED_TULIP_1_7_PATCH_KEY
            );
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.tulips_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.ORANGE_TULIP_1_7_PATCH_KEY
            );
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.tulips_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.WHITE_TULIP_1_7_PATCH_KEY
            );
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(config.tulips_1_7.getGenerateIn()),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeatures.PINK_TULIP_1_7_PATCH_KEY
            );
        }
    }
}
