package github.mcdatapack.blocktopia;

import github.mcdatapack.blocktopia.block.entity.SmallChestBlockEntity;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatTypeRegistry;
import github.mcdatapack.blocktopia.boat.impl.BlocktopiaBoatTrackedData;
import github.mcdatapack.blocktopia.boat.impl.entity.BlocktopiaBoatEntity;
import github.mcdatapack.blocktopia.boat.impl.entity.BlocktopiaChestBoatEntity;
import github.mcdatapack.blocktopia.entity.MonkeyEntity;
import github.mcdatapack.blocktopia.init.*;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import github.mcdatapack.blocktopia.init.worldgen.*;
import github.mcdatapack.blocktopia.util.CustomTrades;
import github.mcdatapack.blocktopia.villager.CustomVillager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
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
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class Blocktopia implements ModInitializer, TerraBlenderApi {
    public static boolean DevMode = false;
    public static final Logger LOGGER = LoggerFactory.getLogger("Blocktopia");
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
        LOGGER.debug("Loading Items, Blocks and Entities");
        ItemInit.load();
        BlockInit.load();
        LegacyBlocks.load();
        BoatInit.load();
        TrunkPlacerTypeInit.load();
        FoliagePlacerTypeInit.load();
        TreeDecoratorTypeInit.load();
        LOGGER.debug("Applying Biome Modifications");
        if (DevMode) BiomeModificationInit.load(true, true, true, true, 1.2, 1.23, 1.23,
                true, true, true, true, true);
        else BiomeModificationInit.load(true, false, false, false, 0, 0, 0,
                false, false, false, false, false);
        BiomeInit.load();
        LOGGER.debug("Loading Block Entities");
        BlockEntityTypeInit.load();
        ScreenHandlerTypeInit.load();
        LOGGER.debug("Loading Entities");
        EntityInit.load();
        FabricDefaultAttributeRegistry.register(EntityInit.MONKEY, MonkeyEntity.createMonkeyAttributes());
        LOGGER.debug("Loading Creative Tabs");
        ItemGroupInit.load();
        LOGGER.debug("Loading Custom Villagers");
        CustomVillager.load();
        CustomTrades.load(12);
        LOGGER.debug("Event handling");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.addBefore(Items.CHEST, BlockInit.SMALL_CHEST.asItem()));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.addBefore(Items.CHEST, BlockInit.SMALL_CHEST.asItem()));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> entries.addAfter(Items.FROG_SPAWN_EGG, ItemInit.GIANT_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> entries.addBefore(Items.HUSK_SPAWN_EGG, ItemInit.ILLUSIONER_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> entries.addBefore(Items.MOOSHROOM_SPAWN_EGG, ItemInit.MONKEY_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.addAfter(Items.MYCELIUM, BlockInit.SANDY_DIRT));
        ItemStorage.SIDED.registerForBlockEntity(SmallChestBlockEntity::getInventoryProvider, BlockEntityTypeInit.SMALL_CHEST_BLOCK_ENTITY);
        LOGGER.debug("Loading Blocktopia Special Boats");
        BlocktopiaBoatTrackedData.register();
        Registry.register(Registries.ENTITY_TYPE, BOAT_ID, BOAT);
        Registry.register(Registries.ENTITY_TYPE, CHEST_BOAT_ID, CHEST_BOAT);
        LOGGER.info("Loaded Blocktopia");
        if (DevMode) for (int i = 0; i <10; i++)  LOGGER.error("DevMode is enabled");
    }

    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new BlocktopiaOverworldRegion(id("overworld"), RegionType.OVERWORLD, 20));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, "blocktopia", BlocktopiaSurfaceRules.makeRules());
    }

    public static Identifier id(String path) {
        return Identifier.of("blocktopia", path);
    }

    public static Identifier idTrinket(String path) {
        return Identifier.of("trinkets", path);
    }
}
