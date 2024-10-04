package github.mcdatapack.blocktopia.init.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.class_1972;
import net.minecraft.class_2893;

public class BiomeModificationInit {
    public BiomeModificationInit() {
    }

    public static void load(boolean Palm_Tree, boolean Tree_c0_24st) {
        if (Palm_Tree) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(class_1972.field_9408, class_1972.field_9441, class_1972.field_9439),
                    class_2893.class_2895.field_13178,
                    PlacedFeatureInit.PALM_TREE_KEY);
        }

        if (Tree_c0_24st) {
            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(class_1972.field_9409, class_1972.field_9414, class_1972.field_35120),
                    class_2893.class_2895.field_13178,
                    PlacedFeatureInit.TREE_C0_24ST_KEY);
        }

    }
}
