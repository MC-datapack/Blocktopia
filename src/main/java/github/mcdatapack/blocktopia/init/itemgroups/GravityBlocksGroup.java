package github.mcdatapack.blocktopia.init.itemgroups;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class GravityBlocksGroup {
    private static final Text GRAVITY_BLOCKS_TITLE = Text.translatable("itemGroup.blocktopia.gravity_blocks");
    public static final ItemGroup GRAVITY_BLOCKS_GROUP = register("gravity_blocks_group", FabricItemGroup.builder()
            .displayName(GRAVITY_BLOCKS_TITLE)
            .icon(BlockInit.PAPER_BLOCK.asItem()::getDefaultStack)
            .entries((displayContext, entries) -> {
                entries.add(Blocks.SAND);
                entries.add(LegacyBlocks.SAND_C0_0_14A);
                entries.add(LegacyBlocks.SAND_C0_0_15A);
                entries.add(LegacyBlocks.SAND_B1_9PRE6);
                entries.add(Blocks.SUSPICIOUS_SAND);
                entries.add(Blocks.GRAVEL);
                entries.add(LegacyBlocks.GRAVEL_C0_0_14A);
                entries.add(LegacyBlocks.GRAVEL_C0_0_15A);
                entries.add(LegacyBlocks.GRAVEL_B1_9PRE5);
                entries.add(LegacyBlocks.GRAVEL_1_3);
                entries.add(Blocks.SUSPICIOUS_GRAVEL);
                entries.add(Blocks.WHITE_CONCRETE_POWDER);
                entries.add(Blocks.LIGHT_GRAY_CONCRETE_POWDER);
                entries.add(Blocks.GRAY_CONCRETE_POWDER);
                entries.add(Blocks.BLACK_CONCRETE_POWDER);
                entries.add(Blocks.BROWN_CONCRETE_POWDER);
                entries.add(Blocks.PURPLE_CONCRETE_POWDER);
                entries.add(Blocks.MAGENTA_CONCRETE_POWDER);
                entries.add(Blocks.PINK_CONCRETE_POWDER);
                entries.add(Blocks.RED_CONCRETE_POWDER);
                entries.add(Blocks.ORANGE_CONCRETE_POWDER);
                entries.add(Blocks.YELLOW_CONCRETE_POWDER);
                entries.add(Blocks.LIME_CONCRETE_POWDER);
                entries.add(Blocks.GREEN_CONCRETE_POWDER);
                entries.add(Blocks.CYAN_CONCRETE_POWDER);
                entries.add(Blocks.LIGHT_BLUE_CONCRETE_POWDER);
                entries.add(Blocks.BLUE_CONCRETE_POWDER);
                entries.add(Blocks.ANVIL);
                entries.add(Blocks.DAMAGED_ANVIL);
                entries.add(Blocks.CHIPPED_ANVIL);
                entries.add(BlockInit.PAPER_BLOCK);
                entries.add(BlockInit.GUNPOWDER_BLOCK);
            }).build());


    public static <T extends ItemGroup> T register(String name, T itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, Blocktopia.id(name), itemGroup);
    }

    public static void load() {}
}
