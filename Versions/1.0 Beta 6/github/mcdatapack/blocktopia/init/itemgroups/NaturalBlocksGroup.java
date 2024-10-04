package github.mcdatapack.blocktopia.init.itemgroups;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.class_1761;
import net.minecraft.class_2378;
import net.minecraft.class_2561;
import net.minecraft.class_7923;

public class NaturalBlocksGroup {
    private static final class_2561 NATURAL_BLOCKS_TITLE = class_2561.method_43471("itemGroup.blocktopia.natural_blocks");
    public static final class_1761 NATURAL_BLOCKS_GROUP = register("natural_blocks_group", FabricItemGroup.builder()
            .method_47321(NATURAL_BLOCKS_TITLE)
            .method_47320(BlockInit.PALM_LEAVES.method_8389()::method_7854)
            .method_47317((displayContext, entries) -> {
                entries.method_45421(BlockInit.PALM_WOOD);
                entries.method_45421(BlockInit.STRIPPED_PALM_WOOD);
                entries.method_45421(BlockInit.PALM_LOG);
                entries.method_45421(BlockInit.STRIPPED_PALM_LOG);
                entries.method_45421(BlockInit.PALM_LEAVES);
                entries.method_45421(BlockInit.PALM_SAPLING);
                entries.method_45421(BlockInit.PALM_PLANKS);
                entries.method_45421(BlockInit.PALM_STAIRS);
                entries.method_45421(BlockInit.PALM_SLAB);
                entries.method_45421(BlockInit.PALM_FENCE);
                entries.method_45421(BlockInit.PALM_FENCE_GATE);
                entries.method_45421(BlockInit.PALM_PRESSURE_PLATE);
                entries.method_45421(BlockInit.PALM_BUTTON);
                entries.method_45421(BlockInit.PALM_DOOR);
                entries.method_45421(BlockInit.PALM_TRAPDOOR);
                entries.method_45421(ItemInit.PALM_SIGN);
                entries.method_45421(ItemInit.PALM_HANGING_SIGN);
                entries.method_45421(ItemInit.PALM_BOAT);
                entries.method_45421(ItemInit.PALM_CHEST_BOAT);
                entries.method_45421(ItemInit.COCONUT);
                entries.method_45421(LegacyBlocks.LEAVES_C0_0_14A);
                entries.method_45421(LegacyBlocks.LEAVES_C0_0_15A);
                entries.method_45421(LegacyBlocks.LEAVES_C0_24ST);
                entries.method_45421(LegacyBlocks.LOG_C0_0_14A);
                entries.method_45421(LegacyBlocks.SAPLING_RD161348);
                entries.method_45421(LegacyBlocks.SAPLING_C0_0_13A);
                entries.method_45421(LegacyBlocks.SAPLING_C0_24ST);
                entries.method_45421(LegacyBlocks.ROSE_C0_0_20A);
                entries.method_45421(LegacyBlocks.POPPY_1_7);
                entries.method_45421(LegacyBlocks.DANDELION_C0_0_20A);
                entries.method_45421(LegacyBlocks.RED_MUSHROOM_C0_0_20A);
                entries.method_45421(LegacyBlocks.BROWN_MUSHROOM_C0_0_20A);
            }).method_47324());

    public static <T extends class_1761> T register(String name, T itemGroup) {
        return class_2378.method_10230(class_7923.field_44687, Blocktopia.id(name), itemGroup);
    }

    public static void load() {}
}
