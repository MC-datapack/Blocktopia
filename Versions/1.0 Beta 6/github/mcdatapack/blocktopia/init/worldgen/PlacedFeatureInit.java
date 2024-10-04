package github.mcdatapack.blocktopia.init.worldgen;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import java.util.List;
import net.minecraft.class_2975;
import net.minecraft.class_5321;
import net.minecraft.class_6796;
import net.minecraft.class_6797;
import net.minecraft.class_6817;
import net.minecraft.class_6819;
import net.minecraft.class_6880;
import net.minecraft.class_7871;
import net.minecraft.class_7891;
import net.minecraft.class_7924;


public class PlacedFeatureInit {
    public static final class_5321<class_6796> PALM_TREE_KEY = registerKey("palm_tree");
    public static final class_5321<class_6796> TREE_C0_24ST_KEY = registerKey("tree_c0_24st");

    public static void bootstrap(class_7891<class_6796> context) {
        class_7871<class_2975<?, ?>> registryLookup = context.method_46799(class_7924.field_41239);
        register(context, PALM_TREE_KEY, registryLookup.method_46747(ConfiguredFeatureInit.PALM_TREE_KEY),
                class_6819.method_39741(
                        class_6817.method_39736(0, 0.1F, 1), BlockInit.PALM_SAPLING));
        register(context, TREE_C0_24ST_KEY, registryLookup.method_46747(ConfiguredFeatureInit.TREE_C0_24ST_KEY),
                class_6819.method_39741(
                        class_6817.method_39736(0, 0.1F, 1), LegacyBlocks.SAPLING_C0_24ST));
    }

    private static class_5321<class_6796> registerKey(String name) {
        return class_5321.method_29179(class_7924.field_41245, Blocktopia.id(name));
    }

    private static void register(class_7891<class_6796> context,
                                 class_5321<class_6796> key,
                                 class_6880<class_2975<?, ?>> config,
                                 List<class_6797> modifiers) {
        context.method_46838(key, new class_6796(config, List.copyOf(modifiers)));
    }
}
