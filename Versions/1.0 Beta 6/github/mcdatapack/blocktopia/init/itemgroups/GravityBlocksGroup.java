package github.mcdatapack.blocktopia.init.itemgroups;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.class_1761;
import net.minecraft.class_2246;
import net.minecraft.class_2378;
import net.minecraft.class_2561;
import net.minecraft.class_7923;

public class GravityBlocksGroup {
    private static final class_2561 GRAVITY_BLOCKS_TITLE = class_2561.method_43471("itemGroup.blocktopia.gravity_blocks");
    public static final class_1761 GRAVITY_BLOCKS_GROUP = register("gravity_blocks_group", FabricItemGroup.builder()
            .method_47321(GRAVITY_BLOCKS_TITLE)
            .method_47320(BlockInit.PAPER_BLOCK.method_8389()::method_7854)
            .method_47317((displayContext, entries) -> {
                entries.method_45421(class_2246.field_10102);
                entries.method_45421(LegacyBlocks.SAND_C0_0_14A);
                entries.method_45421(LegacyBlocks.SAND_C0_0_15A);
                entries.method_45421(LegacyBlocks.SAND_B1_9PRE6);
                entries.method_45421(class_2246.field_42728);
                entries.method_45421(class_2246.field_10255);
                entries.method_45421(LegacyBlocks.GRAVEL_C0_0_14A);
                entries.method_45421(LegacyBlocks.GRAVEL_C0_0_15A);
                entries.method_45421(LegacyBlocks.GRAVEL_B1_9PRE5);
                entries.method_45421(LegacyBlocks.GRAVEL_1_3);
                entries.method_45421(class_2246.field_43227);
                entries.method_45421(class_2246.field_10197);
                entries.method_45421(class_2246.field_10628);
                entries.method_45421(class_2246.field_10353);
                entries.method_45421(class_2246.field_10506);
                entries.method_45421(class_2246.field_10023);
                entries.method_45421(class_2246.field_10404);
                entries.method_45421(class_2246.field_10300);
                entries.method_45421(class_2246.field_10522);
                entries.method_45421(class_2246.field_10287);
                entries.method_45421(class_2246.field_10022);
                entries.method_45421(class_2246.field_10145);
                entries.method_45421(class_2246.field_10133);
                entries.method_45421(class_2246.field_10529);
                entries.method_45421(class_2246.field_10233);
                entries.method_45421(class_2246.field_10321);
                entries.method_45421(class_2246.field_10456);
                entries.method_45421(class_2246.field_10535);
                entries.method_45421(class_2246.field_10414);
                entries.method_45421(class_2246.field_10105);
                entries.method_45421(BlockInit.PAPER_BLOCK);
                entries.method_45421(BlockInit.GUNPOWDER_BLOCK);
            }).method_47324());


    public static <T extends class_1761> T register(String name, T itemGroup) {
        return class_2378.method_10230(class_7923.field_44687, Blocktopia.id(name), itemGroup);
    }

    public static void load() {}
}
