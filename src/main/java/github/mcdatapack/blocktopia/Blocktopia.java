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
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blocktopia implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Blocktopia");
    public static final String MOD_ID = "blocktopia";
    private static final float DIMENSIONS_WIDTH = 1.375F;
    private static final float DIMENSIONS_HEIGHT = 0.5625F;
    private static final Registry<BlocktopiaBoatType> registryInstance = BlocktopiaBoatTypeRegistry.INSTANCE;
    private static final Identifier BOAT_ID = Identifier.of(id("boat").toString());
    public static final EntityType<BlocktopiaBoatEntity> BOAT
            = EntityType.Builder.<BlocktopiaBoatEntity>create(BlocktopiaBoatEntity::new, SpawnGroup.MISC).dimensions(DIMENSIONS_WIDTH, DIMENSIONS_HEIGHT).build();
    private static final Identifier CHEST_BOAT_ID = Identifier.of(id("chest_boat").toString());
    public static final EntityType<BlocktopiaChestBoatEntity> CHEST_BOAT
            = EntityType.Builder.<BlocktopiaChestBoatEntity>create(BlocktopiaChestBoatEntity::new, SpawnGroup.MISC)
            .dimensions(DIMENSIONS_WIDTH, DIMENSIONS_HEIGHT).build();

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
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((entries) -> {entries.addBefore(Items.CHEST, BlockInit.SMALL_CHEST);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register((entries) -> {entries.addBefore(Items.CHEST, BlockInit.SMALL_CHEST);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register((entries) -> {entries.addAfter(Items.FROG_SPAWN_EGG, ItemInit.GIANT_SPAWN_EGG);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register((entries) -> {entries.addBefore(Items.HUSK_SPAWN_EGG, ItemInit.ILLUSIONER_SPAWN_EGG);});
        ItemStorage.SIDED.registerForBlockEntity(SmallChestBlockEntity::getInventoryProvider, BlockEntityTypeInit.SMALL_CHEST_BLOCK_ENTITY);
        LOGGER.info("Loading Blocktopia Special Boats");
        BlocktopiaBoatTrackedData.register();
        Registry.register(Registries.ENTITY_TYPE, BOAT_ID, BOAT);
        Registry.register(Registries.ENTITY_TYPE, CHEST_BOAT_ID, CHEST_BOAT);
        LOGGER.info("Loaded Blocktopia");
    }

    public static Identifier id(String path) {
        return Identifier.of("blocktopia", path);
    }

    public static Identifier idMinecraft(String path) {
        return Identifier.of("minecraft", path);
    }
}
