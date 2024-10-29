package github.mcdatapack.blocktopia.init.worldgen;

import github.mcdatapack.blocktopia.Blocktopia;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

import java.util.Optional;


//float Information: 0 = nothing; 1 = first; 2 = second; 3 = third...; 1.2 = first + second; 1.23 = first + second + third...;

public class BiomeModificationInit {
    public static void load(boolean Palm_Tree,
                            boolean Tree_c0_24st,
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
