package github.mcdatapack.blocktopia.init.worldgen;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import net.minecraft.class_2975;
import net.minecraft.class_3031;
import net.minecraft.class_3037;
import net.minecraft.class_4643;
import net.minecraft.class_4645;
import net.minecraft.class_4646;
import net.minecraft.class_4656;
import net.minecraft.class_5139;
import net.minecraft.class_5140;
import net.minecraft.class_5204;
import net.minecraft.class_5321;
import net.minecraft.class_6016;
import net.minecraft.class_7891;
import net.minecraft.class_7924;
import net.minecraft.world.gen.feature.*;

public class ConfiguredFeatureInit {
    public static final class_5321<class_2975<?, ?>> PALM_TREE_KEY = registerKey("palm_tree");
    public static final class_5321<class_2975<?, ?>> TREE_C0_24ST_KEY = registerKey("tree_c0_0_14a");


    public static void bootstrap(class_7891<class_2975<?, ?>> context) {
        register(context, PALM_TREE_KEY, class_3031.field_24134, new class_4643.class_4644(
                class_4656.method_38432(BlockInit.PALM_LOG),
                new class_5139(4, 4, 6),
                class_4656.method_38432(BlockInit.PALM_LEAVES),
                new class_4645(class_6016.method_34998(4), class_6016.method_34998(0)),
                new class_5204(4, 1, 4)
        ).method_23445());
        register(context, TREE_C0_24ST_KEY, class_3031.field_24134, new class_4643.class_4644(
                class_4656.method_38432(LegacyBlocks.LOG_C0_0_14A),
                new class_5140(4, 2, 0),
                class_4656.method_38432(LegacyBlocks.LEAVES_C0_24ST),
                new class_4646(class_6016.method_34998(2), class_6016.method_34998(0), 3),
                new class_5204(1, 0, 1)
        ).method_23445());
    }

    private static class_5321<class_2975<?, ?>> registerKey(String name) {
        return class_5321.method_29179(class_7924.field_41239, Blocktopia.id(name));
    }

    private static <FC extends class_3037, F extends class_3031<FC>> void register(class_7891<class_2975<?, ?>> context,
                                                                                   class_5321<class_2975<?, ?>> key,
                                                                                   F feature, FC featureConfig) {
        context.method_46838(key, new class_2975<>(feature, featureConfig));
    }
}
