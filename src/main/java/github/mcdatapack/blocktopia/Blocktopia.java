package github.mcdatapack.blocktopia;

import github.mcdatapack.blocktopia.block.entity.ModBlockEntityTypes;
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
import net.fabricmc.fabric.api.transfer.v1.fluid.CauldronFluidContent;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

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
        CompostingChanceRegistry.INSTANCE.add(ModItems.BANANA, 0.5F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.CHERRY, 1.0F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.TROPICAL_MOSS, 0.7F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.TROPICAL_MOSS_CARPET, 0.35F);
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
