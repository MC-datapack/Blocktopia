package github.mcdatapack.blocktopia.init.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.OverworldBiomeCreator;
import net.minecraft.world.gen.GenerationStep;


public class BiomeModificationInit {
    public static void load(boolean Palm_Tree,
                            boolean Tree_c0_24st,
                            boolean Brich_b1_5,
                            boolean Spruce_b1_5,
                            double Legacy_Coal_Ores,
                            double Legacy_Iron_Ores,
                            double Legacy_Gold_Ores,
                            boolean Dandelion_c0_0_20a,
                            boolean Rose_c0_0_20a,
                            boolean Poppy_1_7,
                            boolean Brown_Mushroom_c0_0_20a,
                            boolean Red_Mushroom_c0_0_20a) {
        if (Palm_Tree) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    PlacedFeatureInit.PALM_TREE_KEY);
        }

        if (Tree_c0_24st) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    PlacedFeatureInit.TREE_C0_24ST_KEY);
        }
        /*if (Brich_b1_5) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    PlacedFeatureInit.BIRCH_B1_5_KEY);
        }
        if (Spruce_b1_5) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(BiomeKeys.TAIGA, BiomeKeys.SNOWY_TAIGA),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    PlacedFeatureInit.SPRUCE_B1_5_KEY);
        }*/


        if (Legacy_Coal_Ores == 1 || Legacy_Coal_Ores == 1.2) {
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    PlacedFeatureInit.COAL_ORE_C0_0_14A_KEY
            );
        }
        if (Legacy_Coal_Ores == 2 || Legacy_Coal_Ores == 1.2) {
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    PlacedFeatureInit.COAL_ORE_1_14_KEY
            );
        }



        if (Legacy_Iron_Ores == 1 || Legacy_Iron_Ores == 1.2 || Legacy_Iron_Ores == 1.3 || Legacy_Iron_Ores == 1.23) {
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    PlacedFeatureInit.IRON_ORE_C0_0_14A_KEY
            );
        }
        if (Legacy_Iron_Ores == 2 || Legacy_Iron_Ores == 1.2 || Legacy_Iron_Ores == 1.23) {
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    PlacedFeatureInit.IRON_ORE_1_14_KEY
            );
        }
        if (Legacy_Iron_Ores == 3 || Legacy_Iron_Ores == 1.3 || Legacy_Iron_Ores == 1.23) {
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    PlacedFeatureInit.IRON_ORE_1_14_1_KEY
            );
        }



        if (Legacy_Gold_Ores == 1 || Legacy_Gold_Ores == 1.2 || Legacy_Gold_Ores == 1.3 || Legacy_Gold_Ores == 1.23) {
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    PlacedFeatureInit.GOLD_ORE_C0_0_14A_KEY
            );
        }
        if (Legacy_Gold_Ores == 2 || Legacy_Gold_Ores == 1.2 || Legacy_Gold_Ores == 1.23) {
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    PlacedFeatureInit.GOLD_ORE_C0_26ST_KEY
            );
        }
        if (Legacy_Gold_Ores == 3 || Legacy_Gold_Ores == 1.3 || Legacy_Gold_Ores == 1.23) {
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    PlacedFeatureInit.GOLD_ORE_1_14_KEY
            );
        }


        if (Dandelion_c0_0_20a) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    PlacedFeatureInit.DANDELION_C0_0_20A_PATCH_KEY
            );
        }

        if (Rose_c0_0_20a) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    PlacedFeatureInit.ROSE_C0_0_20A_PATCH_KEY
            );
        }

        if (Poppy_1_7) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    PlacedFeatureInit.POPPY_1_7_PATCH_KEY
            );
        }

        if (Brown_Mushroom_c0_0_20a) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    PlacedFeatureInit.BROWN_MUSHROOM_C0_0_20A_PATCH_KEY
            );
        }

        if (Red_Mushroom_c0_0_20a) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    PlacedFeatureInit.RED_MUSHROOM_C0_0_20A_PATCH_KEY
            );
        }
    }
}
