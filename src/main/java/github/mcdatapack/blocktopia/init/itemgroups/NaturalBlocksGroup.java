package github.mcdatapack.blocktopia.init.itemgroups;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class NaturalBlocksGroup {
    private static final Text NATURAL_BLOCKS_TITLE = Text.translatable("itemGroup.blocktopia.natural_blocks");
    public static final ItemGroup NATURAL_BLOCKS_GROUP = register("natural_blocks_group", FabricItemGroup.builder()
            .displayName(NATURAL_BLOCKS_TITLE)
            .icon(BlockInit.PALM_LEAVES.asItem()::getDefaultStack)
            .entries((displayContext, entries) -> {
                entries.add(BlockInit.PALM_WOOD);
                entries.add(BlockInit.STRIPPED_PALM_WOOD);
                entries.add(BlockInit.PALM_LOG);
                entries.add(BlockInit.STRIPPED_PALM_LOG);
                entries.add(BlockInit.PALM_LEAVES);
                entries.add(BlockInit.PALM_SAPLING);
                entries.add(BlockInit.PALM_PLANKS);
                entries.add(BlockInit.PALM_STAIRS);
                entries.add(BlockInit.PALM_SLAB);
                entries.add(BlockInit.PALM_FENCE);
                entries.add(BlockInit.PALM_FENCE_GATE);
                entries.add(BlockInit.PALM_PRESSURE_PLATE);
                entries.add(BlockInit.PALM_BUTTON);
                entries.add(BlockInit.PALM_DOOR);
                entries.add(BlockInit.PALM_TRAPDOOR);
                entries.add(ItemInit.PALM_SIGN);
                entries.add(ItemInit.PALM_HANGING_SIGN);
                entries.add(ItemInit.PALM_BOAT);
                entries.add(ItemInit.PALM_CHEST_BOAT);
                entries.add(ItemInit.COCONUT);
                entries.add(LegacyBlocks.LEAVES_C0_0_14A);
                entries.add(LegacyBlocks.LEAVES_C0_0_15A);
                entries.add(LegacyBlocks.LEAVES_C0_24ST);
                entries.add(LegacyBlocks.LOG_C0_0_14A);
                entries.add(LegacyBlocks.SAPLING_RD161348);
                entries.add(LegacyBlocks.SAPLING_C0_0_13A);
                entries.add(LegacyBlocks.SAPLING_C0_24ST);
                entries.add(LegacyBlocks.ROSE_C0_0_20A);
                entries.add(LegacyBlocks.POPPY_1_7);
                entries.add(LegacyBlocks.DANDELION_C0_0_20A);
                entries.add(LegacyBlocks.RED_MUSHROOM_C0_0_20A);
                entries.add(LegacyBlocks.BROWN_MUSHROOM_C0_0_20A);
            }).build());

    public static <T extends ItemGroup> T register(String name, T itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, Blocktopia.id(name), itemGroup);
    }

    public static void load() {}
}
