package github.mcdatapack.blocktopia.init.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class BiomeModificationInit {
    public BiomeModificationInit() {
    }

    public static void load(boolean Palm_Tree, boolean Tree_c0_24st) {
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

    }
}
