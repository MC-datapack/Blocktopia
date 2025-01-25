package github.mcdatapack.blocktopia;

import github.mcdatapack.blocktopia.block.entity.SmallChestBlockEntity;
import github.mcdatapack.blocktopia.boat.impl.BlocktopiaBoatTrackedData;
import github.mcdatapack.blocktopia.boat.impl.entity.BlocktopiaBoatEntity;
import github.mcdatapack.blocktopia.boat.impl.entity.BlocktopiaChestBoatEntity;
import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.entity.MonkeyEntity;
import github.mcdatapack.blocktopia.handlers.LootHandler;
import github.mcdatapack.blocktopia.init.*;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import github.mcdatapack.blocktopia.init.worldgen.*;
import github.mcdatapack.blocktopia.util.CustomTrades;
import github.mcdatapack.blocktopia.init.VillagerInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
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
    public static final Logger LOGGER = LoggerFactory.getLogger("Blocktopia");
    private static final float DIMENSIONS_WIDTH = 1.375F;
    private static final float DIMENSIONS_HEIGHT = 0.5625F;
    private static final Identifier BOAT_ID = Identifier.of(id("boat").toString());
    public static final EntityType<BlocktopiaBoatEntity> BOAT
            = EntityType.Builder.<BlocktopiaBoatEntity>create(BlocktopiaBoatEntity::new, SpawnGroup.MISC).dimensions(DIMENSIONS_WIDTH, DIMENSIONS_HEIGHT).build(BOAT_ID.toString());
    private static final Identifier CHEST_BOAT_ID = Identifier.of(id("chest_boat").toString());
    public static final EntityType<BlocktopiaChestBoatEntity> CHEST_BOAT
            = EntityType.Builder.<BlocktopiaChestBoatEntity>create(BlocktopiaChestBoatEntity::new, SpawnGroup.MISC)
            .dimensions(DIMENSIONS_WIDTH, DIMENSIONS_HEIGHT).build(CHEST_BOAT_ID.toString());

    public static final int glowFloweringCherry, glowBanana;
    public static final boolean isMoreToolsAndArmorInstalled;

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Blocktopia");
        LOGGER.debug("Loading Items, Blocks and Entities");
        FluidInit.load();
        ItemInit.load();
        BlockInit.load();
        LegacyBlocks.load();
        BoatInit.load();
        TrunkPlacerTypeInit.load();
        FoliagePlacerTypeInit.load();
        TreeDecoratorTypeInit.load();
        LOGGER.debug("Applying Biome Modifications");
        BiomeModificationInit.load(BlocktopiaConfig.getConfig().worldgenConfig.worldgenFeatures.features);
        BiomeInit.load();
        LOGGER.debug("Loading Block Entities");
        BlockEntityTypeInit.load();
        ScreenHandlerTypeInit.load();
        LOGGER.debug("Loading Entities");
        EntityInit.load();
        FabricDefaultAttributeRegistry.register(EntityInit.MONKEY, MonkeyEntity.createMonkeyAttributes());
        if (BlocktopiaConfig.getConfig().villagerConfig.blocktopiaVillagers) {
            LOGGER.debug("Loading Custom Villagers");
            VillagerInit.load();
        }
        CustomTrades.load(BlocktopiaConfig.getConfig().villagerConfig.maxUses);
        EnchantmentInit.load();
        LOGGER.debug("Event handling");
        LootHandler.registerListeners();
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.addBefore(Items.CHEST, BlockInit.SMALL_CHEST.asItem()));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.addBefore(Items.CHEST, BlockInit.SMALL_CHEST.asItem()));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> entries.addAfter(Items.FROG_SPAWN_EGG, ItemInit.GIANT_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> entries.addBefore(Items.HUSK_SPAWN_EGG, ItemInit.ILLUSIONER_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> entries.addBefore(Items.MOOSHROOM_SPAWN_EGG, ItemInit.MONKEY_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.addAfter(Items.MYCELIUM, BlockInit.SANDY_DIRT));
        ItemStorage.SIDED.registerForBlockEntity(SmallChestBlockEntity::getInventoryProvider, BlockEntityTypeInit.SMALL_CHEST_BLOCK_ENTITY);
        CompostingChanceRegistry.INSTANCE.add(ItemInit.BANANA, 0.5F);
        CompostingChanceRegistry.INSTANCE.add(ItemInit.CHERRY, 1.0F);
        LOGGER.debug("Loading Blocktopia Special Boats");
        BlocktopiaBoatTrackedData.register();
        Registry.register(Registries.ENTITY_TYPE, BOAT_ID, BOAT);
        Registry.register(Registries.ENTITY_TYPE, CHEST_BOAT_ID, CHEST_BOAT);
        LOGGER.debug("Loading Creative Tabs");
        ItemGroupInit.load();
        LOGGER.info("Loaded Blocktopia");
    }

    @Override
    public void onTerraBlenderInitialized() {
        if (!BlocktopiaConfig.getConfig().worldgenConfig.worldgenFeatures.biomes.palm_island && !BlocktopiaConfig.getConfig().worldgenConfig.worldgenFeatures.biomes.rain_forest) return;
        Regions.register(new BlocktopiaOverworldRegion(id("overworld"), RegionType.OVERWORLD, BlocktopiaConfig.getConfig().worldgenConfig.weight));

        if (BlocktopiaConfig.getConfig().worldgenConfig.worldgenFeatures.biomes.sandy_dirt_in_palm_island) {
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, "blocktopia", BlocktopiaSurfaceRules.makeRules());
        }
    }

    static {
        BlocktopiaConfig.register();
        glowFloweringCherry = BlocktopiaConfig.getConfig().glowingFloweringCherryLeaves;
        glowBanana = BlocktopiaConfig.getConfig().glowingBananaLeaves;
        boolean isMoreToolsAndArmorInstalledTemp = true;
        try {
            Class.forName("github.mcdatapack.more_tools_and_armor.MoreToolsAndArmor");
        } catch (ClassNotFoundException e) {
            isMoreToolsAndArmorInstalledTemp = false;
        }
        isMoreToolsAndArmorInstalled = isMoreToolsAndArmorInstalledTemp;
    }

    public static Identifier id(String path) {
        return Identifier.of("blocktopia", path);
    }

    public static Identifier idTrinket(String path) {
        return Identifier.of("trinkets", path);
    }
}
