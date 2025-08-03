package github.mcdatapack.blocktopia.handlers;

import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.item.LegacyItems;
import github.mcdatapack.blocktopia.item.ModItems;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.villager.ModVillagers;

import java.util.Optional;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

import static github.mcdatapack.blocktopia.block.LegacyBlocks.*;
import static github.mcdatapack.blocktopia.item.LegacyItems.GHAST_TEAR_B1_9PRE;
import static github.mcdatapack.blocktopia.item.LegacyItems.GLOWSTONE_DUST_A1_2_0;

public class TradeHandler {
    private static final float priceMultiplier = 0.75F;

    public static void load(int maxUses) {
        if (BlocktopiaConfig.getConfig().villagerConfig.blocktopiaVillagers) {
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 1, factories -> {//TODO: 1
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(WHITE_CLOTH, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LIGHT_GRAY_CLOTH_C0_0_20A, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LIGHT_GRAY_CLOTH_C0_28A, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(DARK_GRAY_CLOTH_C0_0_20A, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(DARK_GRAY_CLOTH_C0_28A, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(RED_CLOTH, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(ORANGE_CLOTH, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(YELLOW_CLOTH, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(CHARTREUSE_CLOTH, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(SPRING_GREEN_CLOTH, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(CYAN_CLOTH, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(CAPRI_CLOTH, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(ULTRAMARINE_CLOTH, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(VIOLET_CLOTH, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(PURPLE_CLOTH, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(MAGENTA_CLOTH, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(ROSE_CLOTH, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LIGHT_GRAY_WOOL_B1_2, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(GRAY_WOOL_B1_2, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BLACK_WOOL_B1_2, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BROWN_WOOL_B1_2, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(RED_WOOL_B1_2, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(ORANGE_WOOL_B1_2, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(YELLOW_WOOL_B1_2, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LIME_WOOL_B1_2 , 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(GREEN_WOOL_B1_2, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(CYAN_WOOL_B1_2 , 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LIGHT_BLUE_WOOL_B1_2, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BLUE_WOOL_B1_2 , 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(PURPLE_WOOL_B1_2, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(MAGENTA_WOOL_B1_2, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(PINK_WOOL_B1_2, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LIGHT_GRAY_WOOL_1_2_4, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(GRAY_WOOL_1_2_4, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BLACK_WOOL_1_2_4, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BROWN_WOOL_1_2_4, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(RED_WOOL_1_2_4, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(ORANGE_WOOL_1_2_4, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(YELLOW_WOOL_1_2_4, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LIME_WOOL_1_2_4, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(GREEN_WOOL_1_2_4, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(CYAN_WOOL_1_2_4, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LIGHT_BLUE_WOOL_1_2_4, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BLUE_WOOL_1_2_4, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(PURPLE_WOOL_1_2_4, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(MAGENTA_WOOL_1_2_4, 8), maxUses, 1, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(PINK_WOOL_1_2_4, 8), maxUses, 1, priceMultiplier));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 2, factories -> {//TODO: 5
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.COAL_IN20100128, 2), new ItemStack(LegacyItems.RUBY, 1), maxUses, 5, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.COAL_IN20100219, 2), new ItemStack(LegacyItems.RUBY, 1), maxUses, 5, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.COAL_1_3, 2), new ItemStack(LegacyItems.RUBY, 1), maxUses, 5, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(IRON_ORE_C0_0_14A, 2), new ItemStack(LegacyItems.RUBY), maxUses, 5, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(IRON_ORE_1_14, 2), new ItemStack(LegacyItems.RUBY), maxUses, 5, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(IRON_ORE_1_14_1, 2), new ItemStack(LegacyItems.RUBY), maxUses, 5, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(GOLD_ORE_C0_0_14A), new ItemStack(LegacyItems.RUBY), maxUses, 5, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(GOLD_ORE_C0_26ST), new ItemStack(LegacyItems.RUBY), maxUses, 5, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(GOLD_ORE_1_14), new ItemStack(LegacyItems.RUBY), maxUses, 5, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.DIAMOND_IN20100128), new ItemStack(LegacyItems.RUBY, 2), maxUses, 5, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.DIAMOND_1_3), new ItemStack(LegacyItems.RUBY, 2), maxUses, 5, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.EMERALD_1_3, 2), new ItemStack(LegacyItems.RUBY, 1), maxUses, 5, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.QUARTZ_1_5), new ItemStack(LegacyItems.RUBY, 1), maxUses, 5, priceMultiplier));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 3, factories -> {//TODO: 10
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LOG_C0_0_14A, 8), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BIRCH_LOG_B1_2, 8), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BIRCH_LOG_1_7, 8), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(SPRUCE_LOG_B1_2, 8), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(SPRUCE_LOG_1_7, 8), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(JUNGLE_LOG_1_2, 8), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(JUNGLE_LOG_1_7, 8), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(ACACIA_LOG_1_7, 8), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(DARK_OAK_LOG_1_7, 8), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(WOODEN_PLANKS_RD20090515, 32), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(WOODEN_PLANKS_RD161348, 32), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(WOODEN_PLANKS_C0_0_14A, 32), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(WOODEN_PLANKS_C0_0_15A, 32), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(WOODEN_PLANKS_B1_9PRE5, 32), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BIRCH_PLANKS_1_2_4, 32), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(SPRUCE_PLANKS_1_2_4, 32), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(JUNGLE_PLANKS_1_2_4, 32), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(ACACIA_PLANKS_1_7, 32), maxUses, 10, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(DARK_OAK_PLANKS_1_7, 32), maxUses, 10, priceMultiplier));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 4, factories -> {//TODO: 20
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(COBBLESTONE_RD20090515, 8), maxUses, 20, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(COBBLESTONE_C0_0_14A, 8), maxUses, 20, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(COBBLESTONE_B1_7, 8), maxUses, 20, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(MOSSY_COBBLESTONE_C0_26ST, 8), maxUses, 20, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(MOSSY_COBBLESTONE_B1_8, 8), maxUses, 20, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(TNT_C0_26ST, 8), maxUses, 20, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(TNT_C0_28A, 8), maxUses, 20, priceMultiplier));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 5, factories -> {//TODO: 30
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(SAPLING_RD161348, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(SAPLING_C0_0_13A, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(SAPLING_C0_24ST, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(DANDELION_C0_0_20A, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(ROSE_C0_0_20A, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(POPPY_1_7, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(RED_MUSHROOM_C0_0_20A, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BROWN_MUSHROOM_C0_0_20A, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(DEAD_BUSH_B1_6, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(SHRUB_B1_6, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(SHORT_GRASS_B1_6, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(FERN_B1_6, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(VINES_B1_8, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(MELON_BLOCK_B1_8, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LILY_PAD_B1_9PRE, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(JUNGLE_SAPLING_1_2, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(ALLIUM_1_7, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(AZURE_BLUET_1_7, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BLUE_ORCHID_1_7, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LILAC_1_7, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(PEONY_1_7, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(ROSE_BUSH_1_7, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(SUNFLOWER_1_7, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(OXEYE_DAISY_1_7, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(RED_TULIP_1_7, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(ORANGE_TULIP_1_7, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(WHITE_TULIP_1_7, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(PINK_TULIP_1_7, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LARGE_FERN_1_7, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(TALL_GRASS_1_7, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(ACACIA_SAPLING_1_7, 8), maxUses, 30, priceMultiplier));
                factories.add((entiy, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(DARK_OAK_SAPLING_1_7, 8), maxUses, 30, priceMultiplier));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 6, factories -> {//TODO: 50
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(GLASS_C0_0_19A, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(WHITE_STAINED_GLASS_1_7, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(ORANGE_STAINED_GLASS_1_7, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(MAGENTA_STAINED_GLASS_1_7, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LIGHT_BLUE_STAINED_GLASS_1_7, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(YELLOW_STAINED_GLASS_1_7, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LIME_STAINED_GLASS_1_7, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(PINK_STAINED_GLASS_1_7, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(GRAY_STAINED_GLASS_1_7, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LIGHT_GRAY_STAINED_GLASS_1_7, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(CYAN_STAINED_GLASS_1_7, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(PURPLE_STAINED_GLASS_1_7, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BLUE_STAINED_GLASS_1_7, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BROWN_STAINED_GLASS_1_7, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(GREEN_STAINED_GLASS_1_7, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(RED_STAINED_GLASS_1_7, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BLACK_STAINED_GLASS_1_7, 8), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(GLASS_PANE_B1_8, 21), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(WHITE_STAINED_GLASS_PANE_1_7, 21), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(ORANGE_STAINED_GLASS_PANE_1_7, 21), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(MAGENTA_STAINED_GLASS_PANE_1_7, 21), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LIGHT_BLUE_STAINED_GLASS_PANE_1_7, 21), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(YELLOW_STAINED_GLASS_PANE_1_7, 21), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LIME_STAINED_GLASS_PANE_1_7, 21), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(PINK_STAINED_GLASS_PANE_1_7, 21), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(GRAY_STAINED_GLASS_PANE_1_7, 21), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(LIGHT_GRAY_STAINED_GLASS_PANE_1_7, 21), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(CYAN_STAINED_GLASS_PANE_1_7, 21), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(PURPLE_STAINED_GLASS_PANE_1_7, 21), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BLUE_STAINED_GLASS_PANE_1_7, 21), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BROWN_STAINED_GLASS_PANE_1_7, 21), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(GREEN_STAINED_GLASS_PANE_1_7, 21), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(RED_STAINED_GLASS_PANE_1_7, 21), maxUses, 50, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BLACK_STAINED_GLASS_PANE_1_7, 21), maxUses, 50, priceMultiplier));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 7, factories -> {//TODO: 100
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BOOKSHELF_C0_26ST, 4), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BOOKSHELF_B1_9PRE5, 4), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BRICKS_C0_26ST, 8), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(BRICKS_A1_0_11, 8), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 6), new ItemStack(GOLD_BLOCK_C0_0_20A), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 6), new ItemStack(GOLD_BLOCK_C0_26ST), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 6), new ItemStack(GOLD_BLOCK_A1_2_0), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 6), new ItemStack(GOLD_BLOCK_B1_9PRE5), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 5), new ItemStack(IRON_BLOCK_C0_26ST), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 5), new ItemStack(IRON_BLOCK_A1_2_0), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 5), new ItemStack(IRON_BLOCK_B1_9PRE5), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 12), new ItemStack(DIAMOND_BLOCK_IN20100128), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 12), new ItemStack(DIAMOND_BLOCK_A1_2_0), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 12), new ItemStack(DIAMOND_BLOCK_B1_9PRE5), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 4), new ItemStack(LAPIS_BLOCK_B1_2), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 4), new ItemStack(LAPIS_BLOCK_1_6), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 8), new ItemStack(EMERALD_BLOCK_1_3), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 8), new ItemStack(REDSTONE_BLOCK_1_5), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 6), new ItemStack(QUARTZ_BLOCK_1_5), maxUses, 100, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 2), new ItemStack(COAL_BLOCK_1_6), maxUses, 100, priceMultiplier));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 8, factories -> {//TODO: 200
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(SPONGE_C0_0_19A, 4), maxUses, 200, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(SPONGE_1_8, 4), maxUses, 200, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(WET_SPONGE_1_8, 4), maxUses, 200, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(PRISMARINE_1_8, 4), maxUses, 200, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(PRISMARINE_BRICKS_1_8, 4), maxUses, 200, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(DARK_PRISMARINE_1_8, 4), maxUses, 200, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY),  new ItemStack(END_ROD_1_9, 4), maxUses, 200, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY),  new ItemStack(ENDSTONE_BRICKS_1_9, 4), maxUses, 200, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY),  new ItemStack(PURPUR_BLOCK_1_9, 4), maxUses, 200, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY),  new ItemStack(PURPUR_PILLAR_1_9, 4), maxUses, 200, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY),  new ItemStack(ENDSTONE_B1_9PRE4, 4), maxUses, 200, priceMultiplier));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 9, factories -> {//TODO: 500
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(NETHERRACK_A1_2_0, 16), maxUses, 500, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(NETHERRACK_B1_9PRE5, 16), maxUses, 500, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(SOUL_SAND_A1_2_0, 16), maxUses, 500, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(GLOWSTONE_A1_2_0, 4), maxUses, 500, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(GLOWSTONE_B1_9PRE5, 4), maxUses, 500, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(NETHER_BRICKS_B1_9PRE, 12), maxUses, 500, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(NETHER_WART_BLOCK_1_10, 4), maxUses, 500, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(NETHER_WART_BLOCK_1_14, 4), maxUses, 500, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(RED_NETHER_BRICKS_1_10, 12), maxUses, 500, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(MAGMA_BLOCK_1_10, 16), maxUses, 500, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(GHAST_TEAR_B1_9PRE, 2), maxUses, 500, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY), new ItemStack(GLOWSTONE_DUST_A1_2_0, 16), maxUses, 500, priceMultiplier));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 10, factories -> {//TODO: 1000
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 64), Optional.of(new TradedItem(LegacyItems.RUBY, 64)), new ItemStack(LegacyItems.NETHER_STAR_1_4), maxUses, 1000, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 64), Optional.of(new TradedItem(LegacyItems.NETHER_STAR_1_4, 64)), new ItemStack(BEDROCK_C0_0_12A), maxUses, 1000, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 2), new ItemStack(OBSIDIAN_C0_28A), maxUses, 1000, priceMultiplier));
                factories.add((entity, random) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 3), new ItemStack(CRYING_OBSIDIAN_B1_3), maxUses, 1000, priceMultiplier));
            });//TODO 10

            TradeOfferHelper.registerVillagerOffers(ModVillagers.BEEKEEPER, 1,
                    (factories) -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(Items.HONEYCOMB, 2),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                Optional.of(new TradedItem(Items.HONEY_BOTTLE, 1)),
                                new ItemStack(Items.SLIME_BALL, 1),
                                maxUses, 1, priceMultiplier
                        ));
                    });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.BEEKEEPER, 2,
                    (factories) -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.PINK_PETALS, 24),
                                new ItemStack(Items.HONEY_BOTTLE, 1),
                                maxUses, 5, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.PINK_PETALS, 64),
                                Optional.of(new TradedItem(Items.CHERRY_SAPLING, 2)),
                                new ItemStack(Items.HONEY_BLOCK, 1),
                                maxUses, 5, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.SLIME_BALL, 1),
                                Optional.of(new TradedItem(Items.GLASS_BOTTLE, 1)),
                                new ItemStack(Items.HONEY_BOTTLE, 1),
                                maxUses, 5, priceMultiplier
                        ));
                    });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.BEEKEEPER, 3,
                    factories -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.DANDELION, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.POPPY, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.BLUE_ORCHID, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.ALLIUM, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.AZURE_BLUET, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.RED_TULIP, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.ORANGE_TULIP, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.WHITE_TULIP, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.PINK_TULIP, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.OXEYE_DAISY, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.CORNFLOWER, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.LILY_OF_THE_VALLEY, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.TORCHFLOWER, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.FLOWERING_AZALEA_LEAVES, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.FLOWERING_AZALEA, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.MANGROVE_PROPAGULE, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.CHERRY_LEAVES, 1),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.PINK_PETALS, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.SPORE_BLOSSOM, 2),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 10, priceMultiplier
                        ));
                    });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.BEEKEEPER, 4,
                    (factories) -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.SUNFLOWER, 1),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 20, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.LILAC, 1),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 20, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.PEONY, 1),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 20, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.ROSE_BUSH, 1),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 20, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.PITCHER_PLANT, 1),
                                new ItemStack(Items.BEE_SPAWN_EGG, 1),
                                maxUses, 20, priceMultiplier
                        ));
                    });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.BEEKEEPER, 5,
                    (factories) -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(Items.HONEYCOMB, 4),
                                maxUses, 30, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(Items.HONEY_BOTTLE, 4),
                                maxUses, 30, priceMultiplier
                        ));
                    });
        }

        if (BlocktopiaConfig.getConfig().villagerConfig.bananaFarmerTrade) {
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
                factories.add((entity, random) -> new TradeOffer(
                        new TradedItem(ModItems.BANANA, 18),
                        new ItemStack(Items.EMERALD),
                        maxUses, 1, priceMultiplier
                ));
                factories.add((entity, random) -> new TradeOffer(
                        new TradedItem(ModItems.CHERRY, 2),
                        new ItemStack(Items.EMERALD),
                        maxUses, 1, priceMultiplier
                ));
            });
        }
        
        if (BlocktopiaConfig.getConfig().wanderingTraderTrades) {
            TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 5),
                                new ItemStack(ModBlocks.PALM_SAPLING),
                                6, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 5),
                                new ItemStack(ModBlocks.BANANA_SAPLING),
                                6, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                        new TradedItem(Items.EMERALD, 5),
                        new ItemStack(ModBlocks.CORN_SAPLING),
                        6, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                        new TradedItem(Items.EMERALD, 5),
                        new ItemStack(ModBlocks.POISONED_SAPLING),
                        6, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 5),
                                new ItemStack(ModBlocks.FLOWERING_CHERRY_SAPLING),
                                6, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(ModBlocks.GLOW_FLOWER),
                                6, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(DANDELION_C0_0_20A),
                                6, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(ROSE_C0_0_20A),
                                6, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(POPPY_1_7),
                                6, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(RED_MUSHROOM_C0_0_20A),
                                6, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(BROWN_MUSHROOM_C0_0_20A),
                                6, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 5),
                                new ItemStack(SAPLING_RD161348),
                                6, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 5),
                                new ItemStack(SAPLING_C0_0_13A),
                                6, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 5),
                                new ItemStack(SAPLING_C0_24ST),
                                6, 1, priceMultiplier
                        ));
                    });
        }
    }
}
