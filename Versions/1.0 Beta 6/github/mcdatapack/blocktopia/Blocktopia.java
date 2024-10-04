package github.mcdatapack.blocktopia;

import github.mcdatapack.blocktopia.block.entity.SmallChestBlockEntity;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatTypeRegistry;
import github.mcdatapack.blocktopia.boat.impl.BlocktopiaBoatTrackedData;
import github.mcdatapack.blocktopia.boat.impl.entity.BlocktopiaBoatEntity;
import github.mcdatapack.blocktopia.boat.impl.entity.BlocktopiaChestBoatEntity;
import github.mcdatapack.blocktopia.init.BlockEntityTypeInit;
import github.mcdatapack.blocktopia.init.BoatInit;
import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.ScreenHandlerTypeInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import github.mcdatapack.blocktopia.init.itemgroups.GravityBlocksGroup;
import github.mcdatapack.blocktopia.init.itemgroups.LegacyBlocksGroup;
import github.mcdatapack.blocktopia.init.itemgroups.NaturalBlocksGroup;
import github.mcdatapack.blocktopia.init.itemgroups.OtherItemsGroup;
import github.mcdatapack.blocktopia.init.worldgen.BiomeModificationInit;
import github.mcdatapack.blocktopia.util.CustomTrades;
import github.mcdatapack.blocktopia.villager.CustomVillager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_1802;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_7706;
import net.minecraft.class_7923;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blocktopia implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Blocktopia");
    public static final String MOD_ID = "blocktopia";
    private static final float DIMENSIONS_WIDTH = 1.375F;
    private static final float DIMENSIONS_HEIGHT = 0.5625F;
    private static final class_2378<BlocktopiaBoatType> registryInstance = BlocktopiaBoatTypeRegistry.INSTANCE;
    private static final class_2960 BOAT_ID = class_2960.method_60654(id("boat").toString());
    public static final class_1299<BlocktopiaBoatEntity> BOAT
            = class_1299.class_1300.<BlocktopiaBoatEntity>method_5903(BlocktopiaBoatEntity::new, class_1311.field_17715).method_17687(DIMENSIONS_WIDTH, DIMENSIONS_HEIGHT).build();
    private static final class_2960 CHEST_BOAT_ID = class_2960.method_60654(id("chest_boat").toString());
    public static final class_1299<BlocktopiaChestBoatEntity> CHEST_BOAT
            = class_1299.class_1300.<BlocktopiaChestBoatEntity>method_5903(BlocktopiaChestBoatEntity::new, class_1311.field_17715)
            .method_17687(DIMENSIONS_WIDTH, DIMENSIONS_HEIGHT).build();

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Blocktopia");
        LOGGER.info("Loading Items, Blocks and Entities");
        ItemInit.load();
        BlockInit.load();
        LegacyBlocks.load();
        BoatInit.load();
        LOGGER.info("Applying Biome Modifications");
        BiomeModificationInit.load(true, false);
        LOGGER.info("Loading Block Entities");
        BlockEntityTypeInit.load();
        ScreenHandlerTypeInit.load();
        LOGGER.info("Loading Creative Tabs");
        GravityBlocksGroup.load();
        LegacyBlocksGroup.load();
        NaturalBlocksGroup.load();
        OtherItemsGroup.load();
        LOGGER.info("Loading Custom Villagers");
        CustomVillager.load();
        CustomTrades.load();
        LOGGER.info("Event handling");
        ItemGroupEvents.modifyEntriesEvent(class_7706.field_40197).register((entries) -> {entries.addBefore(class_1802.field_8106, BlockInit.SMALL_CHEST);});
        ItemGroupEvents.modifyEntriesEvent(class_7706.field_40198).register((entries) -> {entries.addBefore(class_1802.field_8106, BlockInit.SMALL_CHEST);});
        ItemGroupEvents.modifyEntriesEvent(class_7706.field_40205).register((entries) -> {entries.addAfter(class_1802.field_37535, ItemInit.GIANT_SPAWN_EGG);});
        ItemGroupEvents.modifyEntriesEvent(class_7706.field_40205).register((entries) -> {entries.addBefore(class_1802.field_8760, ItemInit.ILLUSIONER_SPAWN_EGG);});
        ItemStorage.SIDED.registerForBlockEntity(SmallChestBlockEntity::getInventoryProvider, BlockEntityTypeInit.SMALL_CHEST_BLOCK_ENTITY);
        LOGGER.info("Loading Blocktopia Special Boats");
        BlocktopiaBoatTrackedData.register();
        class_2378.method_10230(class_7923.field_41177, BOAT_ID, BOAT);
        class_2378.method_10230(class_7923.field_41177, CHEST_BOAT_ID, CHEST_BOAT);
        LOGGER.info("Loaded Blocktopia");
    }

    public static class_2960 id(String path) {
        return class_2960.method_60655("blocktopia", path);
    }

    public static class_2960 idMinecraft(String path) {
        return class_2960.method_60655("minecraft", path);
    }
}
