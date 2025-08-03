package github.mcdatapack.blocktopia;

import github.mcdatapack.blocktopia.block.entity.ModBlockEntityTypes;
import github.mcdatapack.blocktopia.block.entity.custom.FluidTankBlockEntity;
import github.mcdatapack.blocktopia.block.entity.custom.SmallChestBlockEntity;
import github.mcdatapack.blocktopia.command.LocateMobCommand;
import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
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
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.fabricmc.fabric.api.transfer.v1.fluid.*;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

import static github.mcdatapack.blocktopia.block.LegacyBlocks.*;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.TALL_GRASS_1_7;

public class Blocktopia implements ModInitializer, TerraBlenderApi {
    public static final Logger LOGGER = LoggerFactory.getLogger("Blocktopia");

    static {
        BlocktopiaConfig.register();
    }

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Blocktopia");
        LocateMobCommand.register();
        ModRecipes.load();
        ModFluids.load();
        ModItems.load();
        ModBlocks.load();
        LegacyBlocks.load();
        LegacyItems.load();
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
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.TROPICAL_MOSS, 0.7F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.TROPICAL_MOSS_CARPET, 0.35F);
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
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            registerWithLongAndStrongAndNegative(builder, Items.EXPERIENCE_BOTTLE,
                    ModPotions.XP_BOOST, ModPotions.STRONG_XP_BOOST, ModPotions.LONG_XP_BOOST,
                    ModPotions.XP_REMOVER, ModPotions.STRONG_XP_REMOVER, ModPotions.LONG_XP_REMOVER);
        });
        VillagerInteractionRegistries.registerGiftLootTable(ModVillagers.LEGACY, ModLootTables.LEGACY_VILLAGER_GIFT);
        VillagerInteractionRegistries.registerGiftLootTable(ModVillagers.BEEKEEPER, ModLootTables.BEEKEEPER_VILLAGER_GIFT);
        VillagerInteractionRegistries.registerFood(ModItems.BANANA, 1);
        VillagerInteractionRegistries.registerFood(ModItems.CHERRY, 8);
        VillagerInteractionRegistries.registerCompostable(ModItems.BANANA);
        VillagerInteractionRegistries.registerCompostable(ModItems.CHERRY);
        ModItemGroups.load();
        FluidVariantAttributes.register(ModFluids.TROPICAL_WATER, new FluidVariantAttributeHandler() {
            @Override
            public Text getName(FluidVariant fluidVariant) {
                return Text.translatable("fluid.blocktopia.tropical_water");
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
        CauldronFluidContent.registerCauldron(ModBlocks.TROPICAL_WATER_CAULDRON, ModFluids.TROPICAL_WATER, FluidConstants.BUCKET, null);
        VillagerType.BIOME_TO_TYPE.put(ModBiomes.RAIN_FOREST_KEY, VillagerType.JUNGLE);

        VillagerLevelTradeCountRegistry.registerTradeCount(ModVillagers.LEGACY, 5);
        CustomPiglinTrading.addBarteringItem(Items.NETHERITE_INGOT, ModLootTables.NETHERITE_PIGLIN_BARTERING);
        CustomPiglinTrading.addBarteringItem(Items.NETHERITE_BLOCK, ModLootTables.NETHERITE_BLOCK_PIGLIN_BARTERING);
        CustomPiglinTrading.addBarteringItem(LegacyBlocks.BEDROCK_C0_0_12A, ModLootTables.BEDROCK_C0_0_12A_PIGLIN_BARTERING);

        LOGGER.info("Loaded Blocktopia");
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
