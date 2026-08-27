package github.mcdatapack.blocktopia;

import github.mcdatapack.blocktopia.block.FutureBlocks;
import github.mcdatapack.blocktopia.block.entity.ModBlockEntityTypes;
import github.mcdatapack.blocktopia.block.entity.custom.FluidTankBlockEntity;
import github.mcdatapack.blocktopia.block.entity.custom.SmallChestBlockEntity;
import github.mcdatapack.blocktopia.command.LocateMobCommand;
import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.data.FluidInteractionRegistry;
import github.mcdatapack.blocktopia.enchantment.ModEnchantments;
import github.mcdatapack.blocktopia.entity.ModBoats;
import github.mcdatapack.blocktopia.entity.ModEntityTypes;
import github.mcdatapack.blocktopia.entity.custom.MonkeyEntity;
import github.mcdatapack.blocktopia.entity.custom.abstracts.AbstractBirdEntity;
import github.mcdatapack.blocktopia.fluid.ModFluids;
import github.mcdatapack.blocktopia.handlers.ItemGroupModifyEventHandler;
import github.mcdatapack.blocktopia.handlers.LootHandler;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.block.LegacyBlocks;
import github.mcdatapack.blocktopia.handlers.TradeHandler;
import github.mcdatapack.blocktopia.item.FutureItems;
import github.mcdatapack.blocktopia.item.LegacyItems;
import github.mcdatapack.blocktopia.api.CustomPiglinTrading;
import github.mcdatapack.blocktopia.api.VillagerLevelTradeCountRegistry;
import github.mcdatapack.blocktopia.worldgen.tree.decorator.ModTreeDecoratorTypes;
import github.mcdatapack.blocktopia.worldgen.tree.foilageplacer.ModFoliagePlacerTypes;
import github.mcdatapack.blocktopia.worldgen.tree.trunkplacer.ModTrunkPlacerTypes;
import github.mcdatapack.blocktopia.villager.ModVillagers;
import github.mcdatapack.blocktopia.item.ModItemGroups;
import github.mcdatapack.blocktopia.item.ModItems;
import github.mcdatapack.blocktopia.loottable.ModLootTables;
import github.mcdatapack.blocktopia.potion.ModPotions;
import github.mcdatapack.blocktopia.recipe.ModRecipes;
import github.mcdatapack.blocktopia.screen.ModScreenHandlerTypes;
import github.mcdatapack.blocktopia.worldgen.biome.ModBiomes;
import github.mcdatapack.blocktopia.worldgen.biome.ModBiomeModifications;
import github.mcdatapack.blocktopia.worldgen.dimension.terrablender.BlocktopiaOverworldRegion;
import github.mcdatapack.blocktopia.worldgen.dimension.terrablender.BlocktopiaSurfaceRules;
import github.mcdatapack.blocktopia.worldgen.spawn.ModSpawnRestrictions;
import github.mcdatapack.blocktopia.worldgen.structure.ModProcessorLists;
import github.mcdatapack.blocktopia.worldgen.structure.ModStructurePools;
import github.mcdatapack.blocktopia.worldgen.structure.ModStructures;
import github.mcdatapack.blocktopia.worldgen.structure.ModStructureSets;
import github.mcdatapack.blocktopia.worldgen.structure.processor.ModStructureProcessorTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.*;
import net.fabricmc.fabric.api.transfer.v1.fluid.*;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.EmptyItemFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerType;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

import static github.mcdatapack.blocktopia.block.FutureBlocks.*;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.*;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.TALL_GRASS_1_7;
import static github.mcdatapack.blocktopia.item.LegacyItems.*;

public class Blocktopia implements ModInitializer, TerraBlenderApi {
    public static final Logger LOGGER = LoggerFactory.getLogger("Blocktopia");

    static {
        BlocktopiaConfig.register();
    }

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Blocktopia");
        long start = System.currentTimeMillis();

        FluidInteractionRegistry.init();

        ModBlocks.load();
        LegacyBlocks.load();
        FutureBlocks.load();
        ModItems.load();
        LegacyItems.load();
        FutureItems.load();

        LocateMobCommand.register();
        ModRecipes.load();
        ModFluids.load();
        ModBoats.load();
        ModStructureProcessorTypes.load();
        ModTrunkPlacerTypes.load();
        ModFoliagePlacerTypes.load();
        ModTreeDecoratorTypes.load();
        ModPotions.load();
        ModBiomeModifications.load(BlocktopiaConfig.getConfig().worldgenConfig.worldgenFeatures.features);
        ModBiomes.load();
        ModStructures.load();
        ModStructureSets.load();
        ModStructurePools.load();
        ModProcessorLists.load();
        ModBlockEntityTypes.load();
        ModSpawnRestrictions.load();
        ModScreenHandlerTypes.load();
        ModLootTables.load();
        ModEntityTypes.load();
        TradeHandler.load(BlocktopiaConfig.getConfig().villagerConfig.maxUses);
        FabricDefaultAttributeRegistry.register(ModEntityTypes.MONKEY, MonkeyEntity.createMonkeyAttributes());
        FabricDefaultAttributeRegistry.register(ModEntityTypes.TOUCAN, AbstractBirdEntity.createBirdAttributes());
        if (BlocktopiaConfig.getConfig().villagerConfig.blocktopiaVillagers)
            ModVillagers.load();
        ModEnchantments.load();
        LootHandler.registerListeners();
        ItemGroupModifyEventHandler.register();
        ItemStorage.SIDED.registerForBlockEntity(SmallChestBlockEntity::getInventoryProvider, ModBlockEntityTypes.SMALL_CHEST_BLOCK_ENTITY);
        ItemStorage.SIDED.registerForBlockEntity(FluidTankBlockEntity::getInventoryProvider, ModBlockEntityTypes.FLUID_TANK);
        FluidStorage.SIDED.registerForBlockEntity(FluidTankBlockEntity::getFluidTankProvider, ModBlockEntityTypes.FLUID_TANK);
        CompostingChanceRegistry.INSTANCE.add(ModItems.BANANA, 0.5F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.CHERRY, 1.0F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.COCONUT, 1.0F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.TROPICAL_MOSS, 0.7F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.TROPICAL_MOSS_CARPET, 0.35F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.GLOW_FLOWER, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.LEAVES_C0_0_14A, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.LEAVES_C0_0_15A, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.LEAVES_C0_24ST, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.SAPLING_RD161348, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.SAPLING_C0_0_13A, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.SAPLING_C0_24ST, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.DANDELION_C0_0_20A, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.ROSE_C0_0_20A, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.POPPY_1_7, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.BROWN_MUSHROOM_C0_0_20A, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.RED_MUSHROOM_C0_0_20A, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.CARVED_PUMPKIN_A1_2_0, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.BIRCH_LEAVES_B1_2, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.BIRCH_SAPLING_B1_5, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.SPRUCE_LEAVES_B1_2, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.SPRUCE_SAPLING_B1_5, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.SHRUB_B1_6, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.SHORT_GRASS_B1_6, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.FERN_B1_6, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.VINES_B1_8, 0.5F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.MUSHROOM_STEM_B1_8, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.RED_MUSHROOM_BLOCK_B1_8, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.BROWN_MUSHROOM_BLOCK_B1_8, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(LegacyBlocks.MELON_BLOCK_B1_8, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ALLIUM_1_7, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(AZURE_BLUET_1_7, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(BLUE_ORCHID_1_7, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(LILAC_1_7, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(PEONY_1_7, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ROSE_BUSH_1_7, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(SUNFLOWER_1_7, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(OXEYE_DAISY_1_7, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(RED_TULIP_1_7, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ORANGE_TULIP_1_7, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(WHITE_TULIP_1_7, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(PINK_TULIP_1_7, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(LARGE_FERN_1_7, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(TALL_GRASS_1_7, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(JUNGLE_SAPLING_1_2, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(JUNGLE_LEAVES_1_2, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(LILY_PAD_B1_9PRE, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(COCOA_1_3, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ACACIA_LEAVES_1_7, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ACACIA_SAPLING_1_7, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(DARK_OAK_LEAVES_1_7, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(DARK_OAK_SAPLING_1_7, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.BANANA_CROP, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.PALM_LEAVES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.PALM_SAPLING, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.BANANA_LEAVES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.BANANA_SAPLING, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.MAHOGANY_LEAVES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.MAHOGANY_SAPLING, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.CORN_LEAVES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.CORN_SAPLING, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.POISONED_LEAVES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.POISONED_SAPLING, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.FLOWERING_CHERRY_LEAVES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.FLOWERING_CHERRY_SAPLING, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(WILDFLOWERS, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(LEAF_LITTERS, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(SHORT_DRY_GRASS, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(HAY_BALE_1_6, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(APPLE_IN20091231_2255, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(APPLE_1_4, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(BREAD_IN20100206, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(BREAD_1_4, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(WHEAT_IN20100206, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(COOKIE_B1_4, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(BAKED_POTATO_1_4, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(PUMPKIN_PIE_1_4, 1.0F);
        FuelRegistry.INSTANCE.add(ModItems.THERMORGANIC_FUEL, 160 * 200);
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            registerWithLongAndStrongAndNegative(builder, Items.EXPERIENCE_BOTTLE,
                    ModPotions.XP_BOOST, ModPotions.STRONG_XP_BOOST, ModPotions.LONG_XP_BOOST,
                    ModPotions.XP_REMOVER, ModPotions.STRONG_XP_REMOVER, ModPotions.LONG_XP_REMOVER);
        });
        VillagerInteractionRegistries.registerGiftLootTable(ModVillagers.LEGACY, ModLootTables.LEGACY_VILLAGER_GIFT);
        VillagerInteractionRegistries.registerGiftLootTable(ModVillagers.BEEKEEPER, ModLootTables.BEEKEEPER_VILLAGER_GIFT);
        VillagerInteractionRegistries.registerFood(ModItems.BANANA, 1);
        VillagerInteractionRegistries.registerFood(ModItems.CHERRY, 4);
        VillagerInteractionRegistries.registerCompostable(ModItems.BANANA);
        VillagerInteractionRegistries.registerCompostable(ModItems.CHERRY);
        ModItemGroups.load();
        FluidVariantAttributes.register(ModFluids.TROPICAL_WATER, new FluidVariantAttributeHandler() {
            @Override
            public Text getName(FluidVariant fluidVariant) {
                return Text.translatable("fluid.blocktopia.tropical_water");
            }

            @Override
            public int getTemperature(FluidVariant variant) {
                return 350/*K*/;
            }
        });

        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.JUNGLE_LOG)
                .destDimID(id("tropics"))
                .tintColor(26, 158, 10)
                .registerPortal();
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.CHERRY_LOG)
                .destDimID(id("tropics1"))
                .tintColor(26, 158, 10)
                .registerPortal();
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.BANANA_LOG)
                .destDimID(id("tropics1"))
                .tintColor(26, 158, 10)
                .registerPortal();
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.MAHOGANY_LOG)
                .destDimID(id("tropics1"))
                .tintColor(26, 158, 10)
                .registerPortal();
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.CORN_LOG)
                .destDimID(id("tropics1"))
                .tintColor(26, 158, 10)
                .registerPortal();
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.POISONED_LOG)
                .destDimID(id("tropics1"))
                .tintColor(26, 158, 10)
                .registerPortal();
        VillagerType.BIOME_TO_TYPE.put(ModBiomes.RAIN_FOREST_KEY, VillagerType.JUNGLE);

        VillagerLevelTradeCountRegistry.registerTradeCount(ModVillagers.LEGACY, 5);
        CustomPiglinTrading.addBarteringItem(Items.NETHERITE_INGOT, ModLootTables.NETHERITE_PIGLIN_BARTERING);
        CustomPiglinTrading.addBarteringItem(Items.NETHERITE_BLOCK, ModLootTables.NETHERITE_BLOCK_PIGLIN_BARTERING);

        OxidizableBlocksRegistry.registerWaxableBlockPair(FutureBlocks.COPPER_LANTERN, FutureBlocks.WAXED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(FutureBlocks.EXPOSED_COPPER_LANTERN, FutureBlocks.WAXED_EXPOSED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(FutureBlocks.WEATHERED_COPPER_LANTERN, FutureBlocks.WAXED_WEATHERED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(FutureBlocks.OXIDIZED_COPPER_LANTERN, FutureBlocks.WAXED_OXIDIZED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(FutureBlocks.COPPER_LANTERN, FutureBlocks.EXPOSED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(FutureBlocks.EXPOSED_COPPER_LANTERN, FutureBlocks.WEATHERED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(FutureBlocks.WEATHERED_COPPER_LANTERN, FutureBlocks.OXIDIZED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(FutureBlocks.COPPER_BARS, FutureBlocks.WAXED_COPPER_BARS);
        OxidizableBlocksRegistry.registerWaxableBlockPair(FutureBlocks.EXPOSED_COPPER_BARS, FutureBlocks.WAXED_EXPOSED_COPPER_BARS);
        OxidizableBlocksRegistry.registerWaxableBlockPair(FutureBlocks.WEATHERED_COPPER_BARS, FutureBlocks.WAXED_WEATHERED_COPPER_BARS);
        OxidizableBlocksRegistry.registerWaxableBlockPair(FutureBlocks.OXIDIZED_COPPER_BARS, FutureBlocks.WAXED_OXIDIZED_COPPER_BARS);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(FutureBlocks.COPPER_BARS, FutureBlocks.EXPOSED_COPPER_BARS);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(FutureBlocks.EXPOSED_COPPER_BARS, FutureBlocks.WEATHERED_COPPER_BARS);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(FutureBlocks.WEATHERED_COPPER_BARS, FutureBlocks.OXIDIZED_COPPER_BARS);
        OxidizableBlocksRegistry.registerWaxableBlockPair(FutureBlocks.COPPER_CHAIN, FutureBlocks.WAXED_COPPER_CHAIN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(FutureBlocks.EXPOSED_COPPER_CHAIN, FutureBlocks.WAXED_EXPOSED_COPPER_CHAIN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(FutureBlocks.WEATHERED_COPPER_CHAIN, FutureBlocks.WAXED_WEATHERED_COPPER_CHAIN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(FutureBlocks.OXIDIZED_COPPER_CHAIN, FutureBlocks.WAXED_OXIDIZED_COPPER_CHAIN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(FutureBlocks.COPPER_CHAIN, FutureBlocks.EXPOSED_COPPER_CHAIN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(FutureBlocks.EXPOSED_COPPER_CHAIN, FutureBlocks.WEATHERED_COPPER_CHAIN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(FutureBlocks.WEATHERED_COPPER_CHAIN, FutureBlocks.OXIDIZED_COPPER_CHAIN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(Blocks.LIGHTNING_ROD, FutureBlocks.WAXED_LIGHTNING_ROD);
        OxidizableBlocksRegistry.registerWaxableBlockPair(FutureBlocks.EXPOSED_LIGHTNING_ROD, FutureBlocks.WAXED_EXPOSED_LIGHTNING_ROD);
        OxidizableBlocksRegistry.registerWaxableBlockPair(FutureBlocks.WEATHERED_LIGHTNING_ROD, FutureBlocks.WAXED_WEATHERED_LIGHTNING_ROD);
        OxidizableBlocksRegistry.registerWaxableBlockPair(FutureBlocks.OXIDIZED_LIGHTNING_ROD, FutureBlocks.WAXED_OXIDIZED_LIGHTNING_ROD);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(Blocks.LIGHTNING_ROD, FutureBlocks.EXPOSED_LIGHTNING_ROD);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(FutureBlocks.EXPOSED_LIGHTNING_ROD, FutureBlocks.WEATHERED_LIGHTNING_ROD);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(FutureBlocks.WEATHERED_LIGHTNING_ROD, FutureBlocks.OXIDIZED_LIGHTNING_ROD);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.VERTICAL_CUT_COPPER_SLAB, ModBlocks.WAXED_VERTICAL_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.EXPOSED_VERTICAL_CUT_COPPER_SLAB, ModBlocks.WAXED_EXPOSED_VERTICAL_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.WEATHERED_VERTICAL_CUT_COPPER_SLAB, ModBlocks.WAXED_WEATHERED_VERTICAL_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModBlocks.OXIDIZED_VERTICAL_CUT_COPPER_SLAB, ModBlocks.WAXED_OXIDIZED_VERTICAL_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.VERTICAL_CUT_COPPER_SLAB, ModBlocks.EXPOSED_VERTICAL_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.EXPOSED_VERTICAL_CUT_COPPER_SLAB, ModBlocks.WEATHERED_VERTICAL_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModBlocks.WEATHERED_VERTICAL_CUT_COPPER_SLAB, ModBlocks.OXIDIZED_VERTICAL_CUT_COPPER_SLAB);

        TillableBlockRegistry.register(ModBlocks.TROPICAL_MOSS, itemUsageContext ->
                ModBlocks.TROPICAL_FARM_LAND.canPlaceAt(itemUsageContext.getWorld().getBlockState(itemUsageContext.getBlockPos()), itemUsageContext.getWorld(), itemUsageContext.getBlockPos()),
                ModBlocks.TROPICAL_FARM_LAND.getDefaultState());

        StrippableBlockRegistry.register(ModBlocks.PALM_LOG, ModBlocks.STRIPPED_PALM_LOG);
        StrippableBlockRegistry.register(ModBlocks.PALM_WOOD, ModBlocks.STRIPPED_PALM_WOOD);
        StrippableBlockRegistry.register(ModBlocks.BANANA_LOG, ModBlocks.STRIPPED_BANANA_LOG);
        StrippableBlockRegistry.register(ModBlocks.BANANA_WOOD, ModBlocks.STRIPPED_BANANA_WOOD);
        StrippableBlockRegistry.register(ModBlocks.CORN_LOG, ModBlocks.STRIPPED_CORN_LOG);
        StrippableBlockRegistry.register(ModBlocks.CORN_WOOD, ModBlocks.STRIPPED_CORN_WOOD);
        StrippableBlockRegistry.register(ModBlocks.POISONED_LOG, ModBlocks.STRIPPED_POISONED_LOG);
        StrippableBlockRegistry.register(ModBlocks.POISONED_WOOD, ModBlocks.STRIPPED_POISONED_WOOD);
        StrippableBlockRegistry.register(ModBlocks.MAHOGANY_LOG, ModBlocks.STRIPPED_MAHOGANY_LOG);
        StrippableBlockRegistry.register(ModBlocks.MAHOGANY_WOOD, ModBlocks.STRIPPED_MAHOGANY_WOOD);
        StrippableBlockRegistry.register(PALE_OAK_LOG, STRIPPED_PALE_OAK_LOG);
        StrippableBlockRegistry.register(PALE_OAK_WOOD, STRIPPED_PALE_OAK_WOOD);

        LOGGER.info("Loaded Blocktopia, took: {}ms", System.currentTimeMillis() - start);
    }

    @Override
    public void onTerraBlenderInitialized() {
        if (BlocktopiaConfig.getConfig().worldgenConfig.worldgenFeatures.biomes.palm_island && BlocktopiaConfig.getConfig().worldgenConfig.worldgenFeatures.biomes.rain_forest)
            Regions.register(new BlocktopiaOverworldRegion(id("overworld"), RegionType.OVERWORLD, BlocktopiaConfig.getConfig().worldgenConfig.weight));

        if (BlocktopiaConfig.getConfig().worldgenConfig.worldgenFeatures.biomes.sandy_dirt_in_palm_island)
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, "blocktopia", BlocktopiaSurfaceRules.palmIslandRule());
        if (BlocktopiaConfig.getConfig().worldgenConfig.worldgenFeatures.biomes.tropical_moss_in_rainforest)
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, "blocktopia", BlocktopiaSurfaceRules.rainForestRule());
    }

    public static Identifier id(String path) {
        return Identifier.of("blocktopia", path);
    }

    public static Identifier idTrinkets(String path) {
        return Identifier.of("trinkets", path);
    }

    @SuppressWarnings("SameParameterValue")
    private static void registerWithLongAndStrongAndNegative(BrewingRecipeRegistry.Builder builder, Item ingredient,
                                                             RegistryEntry<Potion> potion, RegistryEntry<Potion> strongPotion, RegistryEntry<Potion> longPotion,
                                                             RegistryEntry<Potion> negativePotion, RegistryEntry<Potion> negativeStrongPotion, RegistryEntry<Potion> negativeLongPotion) {
        registerWithLongAndStrong(builder, ingredient, potion, strongPotion, longPotion);
        builder.registerPotionRecipe(negativePotion, Items.GLOWSTONE_DUST, negativeStrongPotion);
        builder.registerPotionRecipe(negativePotion, Items.REDSTONE, negativeLongPotion);
        builder.registerPotionRecipe(potion, Items.FERMENTED_SPIDER_EYE, negativePotion);
        builder.registerPotionRecipe(longPotion, Items.FERMENTED_SPIDER_EYE, negativeLongPotion);
        builder.registerPotionRecipe(strongPotion, Items.FERMENTED_SPIDER_EYE, negativeStrongPotion);
    }

    private static void registerWithLongAndStrong(BrewingRecipeRegistry.Builder builder, Item ingredient,
                                                  RegistryEntry<Potion> potion, RegistryEntry<Potion> strongPotion, RegistryEntry<Potion> longPotion) {
        builder.registerRecipes(ingredient, potion);
        builder.registerPotionRecipe(potion, Items.GLOWSTONE_DUST, strongPotion);
        builder.registerPotionRecipe(potion, Items.REDSTONE, longPotion);
    }
}
