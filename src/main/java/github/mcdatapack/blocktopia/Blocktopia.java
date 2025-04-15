package github.mcdatapack.blocktopia;

import github.mcdatapack.blocktopia.block.entity.SmallChestBlockEntity;
import github.mcdatapack.blocktopia.commands.LocateMobCommand;
import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.entity.MonkeyEntity;
import github.mcdatapack.blocktopia.entity.abstracts.AbstractBirdEntity;
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
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.fabricmc.fabric.api.transfer.v1.fluid.CauldronFluidContent;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
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
        RecipeInit.load();
        FluidInit.load();
        ItemInit.load();
        BlockInit.load();
        LegacyBlocks.load();
        BoatInit.load();
        TrunkPlacerTypeInit.load();
        FoliagePlacerTypeInit.load();
        TreeDecoratorTypeInit.load();
        PotionInit.load();
        BiomeModificationInit.load(BlocktopiaConfig.getConfig().worldgenConfig.worldgenFeatures.features);
        BiomeInit.load();
        BlockEntityTypeInit.load();
        ScreenHandlerTypeInit.load();
        EntityInit.load();
        FabricDefaultAttributeRegistry.register(EntityInit.MONKEY, MonkeyEntity.createMonkeyAttributes());
        FabricDefaultAttributeRegistry.register(EntityInit.ABSTRACT_BIRD, AbstractBirdEntity.createBirdAttributes());
        if (BlocktopiaConfig.getConfig().villagerConfig.blocktopiaVillagers) {
            VillagerInit.load();
        }
        CustomTrades.load(BlocktopiaConfig.getConfig().villagerConfig.maxUses);
        EnchantmentInit.load();
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
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            registerWithLongAndStrongAndNegative(builder, Items.EXPERIENCE_BOTTLE,
                    PotionInit.XP_BOOST, PotionInit.STRONG_XP_BOOST, PotionInit.LONG_XP_BOOST,
                    PotionInit.XP_REMOVER, PotionInit.STRONG_XP_REMOVER, PotionInit.LONG_XP_REMOVER);
        });
        VillagerInteractionRegistries.registerGiftLootTable(VillagerInit.LEGACY, LootTableInit.LEGACY_VILLAGER_GIFT_GAMEPLAY);
        VillagerInteractionRegistries.registerGiftLootTable(VillagerInit.BEEKEEPER, LootTableInit.BEEKEEPER_VILLAGER_GIFT_GAMEPLAY);
        VillagerInteractionRegistries.registerFood(ItemInit.CHERRY, 8);
        ItemGroupInit.load();

        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.JUNGLE_LOG)
                .destDimID(id("tropics"))
                .tintColor(26, 158, 10)
                .registerPortal();
        CustomPortalBuilder.beginPortal()
                .frameBlock(BlockInit.BANANA_LOG)
                .destDimID(id("tropics1"))
                .tintColor(26, 158, 10)
                .registerPortal();
        CauldronFluidContent.registerCauldron(BlockInit.TROPICAL_WATER_CAULDRON, FluidInit.TROPICAL_WATER, FluidConstants.BUCKET, null);

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
