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
        //if (config.birch_b1_5.generate) {
        //    BiomeModifications.addFeature(
        //            BiomeSelectors.includeByKey(config.birch_b1_5.getGenerateIn()),
        //            GenerationStep.Feature.VEGETAL_DECORATION,
        //            ModPlacedFeatures.BIRCH_B1_5_KEY);
        //}
        //if (config.spruce_b1_5.generate) {
        //    BiomeModifications.addFeature(
        //            BiomeSelectors.includeByKey(config.spruce_b1_5.getGenerateIn()),
        //            GenerationStep.Feature.VEGETAL_DECORATION,
        //            ModPlacedFeatures.SPRUCE_B1_5_KEY);
        //}

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
        //if (config.legacy_lapis_ores.generate) {
        //    BiomeModifications.addFeature(
        //            BiomeSelectors.foundInOverworld(),
        //            GenerationStep.Feature.UNDERGROUND_ORES,
        //            ModPlacedFeatures.LAPIS_ORE_B1_2_KEY
        //    );
        //    BiomeModifications.addFeature(
        //            BiomeSelectors.foundInOverworld(),
        //            GenerationStep.Feature.UNDERGROUND_ORES,
        //            ModPlacedFeatures.LAPIS_ORE_1_14_KEY
        //    );
        //}


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
    }
}
