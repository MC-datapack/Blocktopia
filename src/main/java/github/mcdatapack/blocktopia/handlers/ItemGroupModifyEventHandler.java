package github.mcdatapack.blocktopia.handlers;

import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class ItemGroupModifyEventHandler {
    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.addBefore(Items.CHEST, ModBlocks.SMALL_CHEST.asItem()));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ItemGroupModifyEventHandler::modifySpawnEggsEntries);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ItemGroupModifyEventHandler::modifyNaturalEntries);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ItemGroupModifyEventHandler::modifyBuildingBlocksEntries);
    }

    private static void modifyBuildingBlocksEntries(FabricItemGroupEntries entries) {
        entries.addAfter(Items.OAK_BUTTON, ModBlocks.OAK_CHAIR[0]);
        entries.addAfter(Items.SPRUCE_BUTTON, ModBlocks.SPRUCE_CHAIR[0]);
        entries.addAfter(Items.BIRCH_BUTTON, ModBlocks.BIRCH_CHAIR[0]);
        entries.addAfter(Items.JUNGLE_BUTTON, ModBlocks.JUNGLE_CHAIR[0]);
        entries.addAfter(Items.ACACIA_BUTTON, ModBlocks.ACACIA_CHAIR[0]);
        entries.addAfter(Items.DARK_OAK_BUTTON, ModBlocks.DARK_OAK_CHAIR[0]);
        entries.addAfter(Items.CRIMSON_BUTTON, ModBlocks.CRIMSON_CHAIR[0]);
        entries.addAfter(Items.WARPED_BUTTON, ModBlocks.WARPED_CHAIR[0]);
        entries.addAfter(Items.MANGROVE_BUTTON, ModBlocks.MANGROVE_CHAIR[0]);
        entries.addAfter(Items.BAMBOO_BUTTON, ModBlocks.BAMBOO_CHAIR[0]);
        entries.addAfter(Items.CHERRY_BUTTON, ModBlocks.CHERRY_CHAIR[0]);
    }

    private static void modifySpawnEggsEntries(FabricItemGroupEntries entries) {
        entries.addAfter(Items.FROG_SPAWN_EGG, ModItems.GIANT_SPAWN_EGG);
        entries.addBefore(Items.HUSK_SPAWN_EGG, ModItems.ILLUSIONER_SPAWN_EGG);
        entries.addBefore(Items.MOOSHROOM_SPAWN_EGG, ModItems.MONKEY_SPAWN_EGG);
    }

    private static void modifyNaturalEntries(FabricItemGroupEntries entries) {
        entries.addAfter(Items.MYCELIUM, ModBlocks.SANDY_DIRT);
        entries.addAfter(Items.MOSS_CARPET, ModBlocks.TROPICAL_MOSS, ModBlocks.TROPICAL_MOSS_CARPET);
    }
}
