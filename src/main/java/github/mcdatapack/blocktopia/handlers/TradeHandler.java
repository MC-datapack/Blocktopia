package github.mcdatapack.blocktopia.handlers;

import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.config.BlocktopiaConfigData;
import github.mcdatapack.blocktopia.item.LegacyItems;
import github.mcdatapack.blocktopia.item.ModItems;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.villager.ModVillagers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import github.mcdatapack.more_tools_and_armor.init.EnchantmentInit;
import github.mcdatapack.more_tools_and_armor.init.ItemInit;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

import static github.mcdatapack.blocktopia.Blocktopia.LOGGER;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.*;
import static github.mcdatapack.blocktopia.item.LegacyItems.*;

public class TradeHandler {
    private static final float priceMultiplier = 0.75F;

    public static void load(int maxUses) {
        BlocktopiaConfigData.VillagerConfig villagerConfig = BlocktopiaConfig.getConfig().villagerConfig;

        class TradeOffer extends net.minecraft.village.TradeOffer {
            public TradeOffer(TradedItem buyItem, ItemStack sellItem, int merchantExperience) {
                super(buyItem, sellItem, maxUses, merchantExperience, priceMultiplier);
            }

            public TradeOffer(TradedItem firstBuyItem, TradedItem secondBuyItem, ItemStack sellItem, int merchantExperience) {
                super(firstBuyItem, Optional.ofNullable(secondBuyItem), sellItem, maxUses, merchantExperience, priceMultiplier);
            }
        }

        if (villagerConfig.blocktopiaVillagers) {
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 1, f -> {
                ItemConvertible[] sells = {
                        WHITE_CLOTH, LIGHT_GRAY_CLOTH_C0_0_20A, LIGHT_GRAY_CLOTH_C0_28A, DARK_GRAY_CLOTH_C0_0_20A, DARK_GRAY_CLOTH_C0_28A, RED_CLOTH, ORANGE_CLOTH, YELLOW_CLOTH, CHARTREUSE_CLOTH,
                        SPRING_GREEN_CLOTH, CYAN_CLOTH, CAPRI_CLOTH, ULTRAMARINE_CLOTH, VIOLET_CLOTH, PURPLE_CLOTH, MAGENTA_CLOTH, ROSE_CLOTH,
                        LIGHT_GRAY_WOOL_B1_2, GRAY_WOOL_B1_2, BLACK_WOOL_B1_2, BROWN_WOOL_B1_2, RED_WOOL_B1_2, ORANGE_WOOL_B1_2, YELLOW_WOOL_B1_2, LIME_WOOL_B1_2, GREEN_WOOL_B1_2,
                        CYAN_WOOL_B1_2, LIGHT_BLUE_WOOL_B1_2, BLUE_WOOL_B1_2, PURPLE_WOOL_B1_2, MAGENTA_WOOL_B1_2, PINK_WOOL_B1_2,
                        LIGHT_GRAY_WOOL_1_2_4, GRAY_WOOL_1_2_4, BLACK_WOOL_1_2_4, BROWN_WOOL_1_2_4, RED_WOOL_1_2_4, ORANGE_WOOL_1_2_4, YELLOW_WOOL_1_2_4, LIME_WOOL_1_2_4, GREEN_WOOL_1_2_4,
                        CYAN_WOOL_1_2_4, LIGHT_BLUE_WOOL_1_2_4, BLUE_WOOL_1_2_4, PURPLE_WOOL_1_2_4, MAGENTA_WOOL_1_2_4, PINK_WOOL_1_2_4
                };

                for (ItemConvertible item : sells) {
                    f.add((e, r) -> new TradeOffer(new TradedItem(RUBY), new ItemStack(item, 8), 1));
                }
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 2, f -> {
                f.add((e, r) -> new TradeOffer(new TradedItem(COAL_IN20100128, 2), new ItemStack(RUBY, 1), 5));
                f.add((e, r) -> new TradeOffer(new TradedItem(COAL_IN20100219, 2), new ItemStack(RUBY, 1), 5));
                f.add((e, r) -> new TradeOffer(new TradedItem(COAL_1_3, 2), new ItemStack(RUBY, 1), 5));
                f.add((e, r) -> new TradeOffer(new TradedItem(IRON_ORE_C0_0_14A, 2), new ItemStack(RUBY), 5));
                f.add((e, r) -> new TradeOffer(new TradedItem(IRON_ORE_1_14, 2), new ItemStack(RUBY), 5));
                f.add((e, r) -> new TradeOffer(new TradedItem(IRON_ORE_1_14_1, 2), new ItemStack(RUBY), 5));
                f.add((e, r) -> new TradeOffer(new TradedItem(GOLD_ORE_C0_0_14A), new ItemStack(RUBY), 5));
                f.add((e, r) -> new TradeOffer(new TradedItem(GOLD_ORE_C0_26ST), new ItemStack(RUBY), 5));
                f.add((e, r) -> new TradeOffer(new TradedItem(GOLD_ORE_1_14), new ItemStack(RUBY), 5));
                f.add((e, r) -> new TradeOffer(new TradedItem(DIAMOND_IN20100128), new ItemStack(RUBY, 2), 5));
                f.add((e, r) -> new TradeOffer(new TradedItem(DIAMOND_1_3), new ItemStack(RUBY, 2), 5));
                f.add((e, r) -> new TradeOffer(new TradedItem(EMERALD_1_3, 2), new ItemStack(RUBY, 1), 5));
                f.add((e, r) -> new TradeOffer(new TradedItem(QUARTZ_1_5), new ItemStack(RUBY, 1), 5));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 3, f -> {
                final TradedItem RUBY = new TradedItem(LegacyItems.RUBY);


                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(LOG_C0_0_14A, 8), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(BIRCH_LOG_B1_2, 8), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(BIRCH_LOG_1_7, 8), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(SPRUCE_LOG_B1_2, 8), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(SPRUCE_LOG_1_7, 8), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(JUNGLE_LOG_1_2, 8), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(JUNGLE_LOG_1_7, 8), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(ACACIA_LOG_1_7, 8), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(DARK_OAK_LOG_1_7, 8), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(WOODEN_PLANKS_RD20090515, 32), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(WOODEN_PLANKS_RD161348, 32), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(WOODEN_PLANKS_C0_0_14A, 32), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(WOODEN_PLANKS_C0_0_15A, 32), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(WOODEN_PLANKS_B1_9PRE5, 32), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(BIRCH_PLANKS_1_2_4, 32), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(SPRUCE_PLANKS_1_2_4, 32), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(JUNGLE_PLANKS_1_2_4, 32), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(ACACIA_PLANKS_1_7, 32), 10));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(DARK_OAK_PLANKS_1_7, 32), 10));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 4, f -> {
                final TradedItem RUBY = new TradedItem(LegacyItems.RUBY);


                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(COBBLESTONE_RD20090515, 8), 20));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(COBBLESTONE_C0_0_14A, 8), 20));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(COBBLESTONE_B1_7, 8), 20));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(MOSSY_COBBLESTONE_C0_26ST, 8), 20));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(MOSSY_COBBLESTONE_B1_8, 8), 20));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(TNT_C0_26ST, 8), 20));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(TNT_C0_28A, 8), 20));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 5, f -> {
                final TradedItem RUBY = new TradedItem(LegacyItems.RUBY);


                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(SAPLING_RD161348, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(SAPLING_C0_0_13A, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(SAPLING_C0_24ST, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(DANDELION_C0_0_20A, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(ROSE_C0_0_20A, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(POPPY_1_7, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(RED_MUSHROOM_C0_0_20A, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(BROWN_MUSHROOM_C0_0_20A, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(DEAD_BUSH_B1_6, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(SHRUB_B1_6, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(SHORT_GRASS_B1_6, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(FERN_B1_6, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(VINES_B1_8, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(MELON_BLOCK_B1_8, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(LILY_PAD_B1_9PRE, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(JUNGLE_SAPLING_1_2, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(ALLIUM_1_7, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(AZURE_BLUET_1_7, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(BLUE_ORCHID_1_7, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(LILAC_1_7, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(PEONY_1_7, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(ROSE_BUSH_1_7, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(SUNFLOWER_1_7, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(OXEYE_DAISY_1_7, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(RED_TULIP_1_7, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(ORANGE_TULIP_1_7, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(WHITE_TULIP_1_7, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(PINK_TULIP_1_7, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(LARGE_FERN_1_7, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(TALL_GRASS_1_7, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(ACACIA_SAPLING_1_7, 8), 30));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(DARK_OAK_SAPLING_1_7, 8), 30));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 6, f -> {
                final TradedItem RUBY = new TradedItem(LegacyItems.RUBY);

                ItemConvertible[] glass = {
                        GLASS_C0_0_19A, WHITE_STAINED_GLASS_1_7, ORANGE_STAINED_GLASS_1_7, MAGENTA_STAINED_GLASS_1_7, LIGHT_BLUE_STAINED_GLASS_1_7, YELLOW_STAINED_GLASS_1_7,
                        LIME_STAINED_GLASS_1_7, PINK_STAINED_GLASS_1_7, GRAY_STAINED_GLASS_1_7, LIGHT_GRAY_STAINED_GLASS_1_7, CYAN_STAINED_GLASS_1_7, PURPLE_STAINED_GLASS_1_7,
                        BLUE_STAINED_GLASS_1_7, BROWN_STAINED_GLASS_1_7, GREEN_STAINED_GLASS_1_7, RED_STAINED_GLASS_1_7, BLACK_STAINED_GLASS_1_7
                };
                ItemConvertible[] glassPanes = {
                        WHITE_STAINED_GLASS_PANE_1_7, ORANGE_STAINED_GLASS_PANE_1_7, MAGENTA_STAINED_GLASS_PANE_1_7, LIGHT_BLUE_STAINED_GLASS_PANE_1_7, YELLOW_STAINED_GLASS_PANE_1_7,
                        LIME_STAINED_GLASS_PANE_1_7, PINK_STAINED_GLASS_PANE_1_7, GRAY_STAINED_GLASS_PANE_1_7, LIGHT_GRAY_STAINED_GLASS_PANE_1_7, CYAN_STAINED_GLASS_PANE_1_7, PURPLE_STAINED_GLASS_PANE_1_7,
                        BLUE_STAINED_GLASS_PANE_1_7, BROWN_STAINED_GLASS_PANE_1_7, GREEN_STAINED_GLASS_PANE_1_7, RED_STAINED_GLASS_PANE_1_7, BLACK_STAINED_GLASS_PANE_1_7
                };

                for (ItemConvertible item : glass) {
                    f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(item, 8), 60));
                }

                for (ItemConvertible item : glassPanes) {
                    f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(item, 21), 60));
                }
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 7, f -> {
                final TradedItem RUBY = new TradedItem(LegacyItems.RUBY);


                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(BOOKSHELF_C0_26ST, 4), 100));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(BOOKSHELF_B1_9PRE5, 4), 100));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(BRICKS_C0_26ST, 8), 100));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(BRICKS_A1_0_11, 8), 100));
                f.add((e, r) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 6), new ItemStack(GOLD_BLOCK_C0_0_20A), 100));
                f.add((e, r) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 6), new ItemStack(GOLD_BLOCK_C0_26ST), 100));
                f.add((e, r) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 6), new ItemStack(GOLD_BLOCK_A1_2_0), 100));
                f.add((e, r) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 6), new ItemStack(GOLD_BLOCK_B1_9PRE5), 100));
                f.add((e, r) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 5), new ItemStack(IRON_BLOCK_C0_26ST), 100));
                f.add((e, r) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 5), new ItemStack(IRON_BLOCK_A1_2_0), 100));
                f.add((e, r) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 5), new ItemStack(IRON_BLOCK_B1_9PRE5), 100));
                f.add((e, r) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 12), new ItemStack(DIAMOND_BLOCK_IN20100128), 100));
                f.add((e, r) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 12), new ItemStack(DIAMOND_BLOCK_A1_2_0), 100));
                f.add((e, r) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 12), new ItemStack(DIAMOND_BLOCK_B1_9PRE5), 100));
                f.add((e, r) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 4), new ItemStack(LAPIS_BLOCK_B1_2), 100));
                f.add((e, r) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 4), new ItemStack(LAPIS_BLOCK_1_6), 100));
                f.add((e, r) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 8), new ItemStack(EMERALD_BLOCK_1_3), 100));
                f.add((e, r) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 8), new ItemStack(REDSTONE_BLOCK_1_5), 100));
                f.add((e, r) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 6), new ItemStack(QUARTZ_BLOCK_1_5), 100));
                f.add((e, r) -> new TradeOffer(new TradedItem(LegacyItems.RUBY, 2), new ItemStack(COAL_BLOCK_1_6), 100));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 8, f -> {
                final TradedItem RUBY = new TradedItem(LegacyItems.RUBY);


                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(SPONGE_C0_0_19A, 4), 200));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(SPONGE_1_8, 4), 200));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(WET_SPONGE_1_8, 4), 200));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(PRISMARINE_1_8, 4), 200));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(PRISMARINE_BRICKS_1_8, 4), 200));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(DARK_PRISMARINE_1_8, 4), 200));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(END_ROD_1_9, 4), 200));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(ENDSTONE_BRICKS_1_9, 4), 200));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(PURPUR_BLOCK_1_9, 4), 200));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(PURPUR_PILLAR_1_9, 4), 200));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(ENDSTONE_B1_9PRE4, 4), 200));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 9, f -> {
                final TradedItem RUBY = new TradedItem(LegacyItems.RUBY);


                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(NETHERRACK_A1_2_0, 16), 500));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(NETHERRACK_B1_9PRE5, 16), 500));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(SOUL_SAND_A1_2_0, 16), 500));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(GLOWSTONE_A1_2_0, 4), 500));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(GLOWSTONE_B1_9PRE5, 4), 500));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(NETHER_BRICKS_B1_9PRE, 12), 500));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(NETHER_WART_BLOCK_1_10, 4), 500));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(NETHER_WART_BLOCK_1_14, 4), 500));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(RED_NETHER_BRICKS_1_10, 12), 500));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(MAGMA_BLOCK_1_10, 16), 500));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(GHAST_TEAR_B1_9PRE, 2), 500));
                f.add((e, r) -> new TradeOffer(RUBY, new ItemStack(GLOWSTONE_DUST_A1_2_0, 16), 500));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.LEGACY, 10, f -> {
                f.add((e, r) -> new TradeOffer(new TradedItem(RUBY, 64), new TradedItem(RUBY, 64), new ItemStack(NETHER_STAR_1_4), 1000));
                f.add((e, r) -> new TradeOffer(new TradedItem(RUBY, 64), new TradedItem(NETHER_STAR_1_4, 64), new ItemStack(BEDROCK_C0_0_12A), 1000));
                f.add((e, r) -> new TradeOffer(new TradedItem(RUBY, 2), new ItemStack(OBSIDIAN_C0_28A), 1000));
                f.add((e, r) -> new TradeOffer(new TradedItem(RUBY, 3), new ItemStack(CRYING_OBSIDIAN_B1_3), 1000));
            });

            TradeOfferHelper.registerVillagerOffers(ModVillagers.BEEKEEPER, 1,
                    (f) -> {
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 1), new ItemStack(Items.HONEYCOMB, 2), 1));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 1), new TradedItem(Items.HONEY_BOTTLE, 1), new ItemStack(Items.SLIME_BALL, 1), 1));
                    });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.BEEKEEPER, 2,
                    (f) -> {
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.PINK_PETALS, 24), new ItemStack(Items.HONEY_BOTTLE, 1), 5));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.PINK_PETALS, 64), new TradedItem(Items.CHERRY_SAPLING, 2), new ItemStack(Items.HONEY_BLOCK, 1), 5));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.SLIME_BALL, 1), new TradedItem(Items.GLASS_BOTTLE, 1), new ItemStack(Items.HONEY_BOTTLE, 1), 5));
                    });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.BEEKEEPER, 3,
                    f -> {
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.DANDELION, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.POPPY, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.BLUE_ORCHID, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.ALLIUM, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.AZURE_BLUET, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.RED_TULIP, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.ORANGE_TULIP, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.WHITE_TULIP, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.PINK_TULIP, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.OXEYE_DAISY, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.CORNFLOWER, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.LILY_OF_THE_VALLEY, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.TORCHFLOWER, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.FLOWERING_AZALEA_LEAVES, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.FLOWERING_AZALEA, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.MANGROVE_PROPAGULE, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.CHERRY_LEAVES, 1), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.PINK_PETALS, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.SPORE_BLOSSOM, 2), new ItemStack(Items.BEE_SPAWN_EGG, 1), 10));
                    });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.BEEKEEPER, 4,
                    (f) -> {
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.SUNFLOWER, 1), new ItemStack(Items.BEE_SPAWN_EGG, 1), 20));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.LILAC, 1), new ItemStack(Items.BEE_SPAWN_EGG, 1), 20));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.PEONY, 1), new ItemStack(Items.BEE_SPAWN_EGG, 1), 20));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.ROSE_BUSH, 1), new ItemStack(Items.BEE_SPAWN_EGG, 1), 20));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.PITCHER_PLANT, 1), new ItemStack(Items.BEE_SPAWN_EGG, 1), 20));
                    });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.BEEKEEPER, 5,
                    (f) -> {
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 1), new ItemStack(Items.HONEYCOMB, 4), 30));
                        f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 1), new ItemStack(Items.HONEY_BOTTLE, 4), 30));
                    });

            TradeOfferHelper.registerVillagerOffers(ModVillagers.FORGER, 1,
                    f -> {
                        f.add(new EnchantToolFactory(Items.IRON_SWORD, 15, maxUses, 1, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.IRON_AXE, 15, maxUses, 1, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.IRON_PICKAXE, 15, maxUses, 1, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.IRON_SHOVEL, 15, maxUses, 1, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.IRON_HOE, 15, maxUses, 1, priceMultiplier));
                        f.add(new EnchantToolFactory(ItemInit.IRON_PAXEL, 15, maxUses, 1, priceMultiplier));
                        f.add(new EnchantToolFactory(ItemInit.IRON_HAMMER, 15, maxUses, 1, priceMultiplier));
                    });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.FORGER, 2,
                    f -> {
                        f.add(new EnchantToolFactory(Items.SHEARS, 15, maxUses, 5, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.FLINT_AND_STEEL, 15, maxUses, 5, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.BRUSH, 15, maxUses, 5, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.SHIELD, 15, maxUses, 5, priceMultiplier));
            });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.FORGER, 3,
                    f -> {
                        f.add(new EnchantToolFactory(Items.BOW, 15, maxUses, 10, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.CROSSBOW, 15, maxUses, 10, priceMultiplier));
                    });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.FORGER, 4,
                    f -> {
                        f.add(new EnchantToolFactory(Items.IRON_HELMET, 15, maxUses, 20, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.IRON_CHESTPLATE, 15, maxUses, 20, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.IRON_LEGGINGS, 15, maxUses, 20, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.IRON_BOOTS, 15, maxUses, 20, priceMultiplier));
                    });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.FORGER, 5,
                    f -> {
                        f.add(new EnchantToolFactory(Items.TRIDENT, 15, maxUses, 30, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.ELYTRA, 15, maxUses, 30, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.MACE, 15, maxUses, 30, priceMultiplier));
                    });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.FORGER, 6,
                    f -> {
                        f.add(new EnchantToolFactory(Items.DIAMOND_SWORD, 15, maxUses, 60, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.DIAMOND_AXE, 15, maxUses, 60, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.DIAMOND_PICKAXE, 15, maxUses, 60, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.DIAMOND_SHOVEL, 15, maxUses, 60, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.DIAMOND_HOE, 15, maxUses, 60, priceMultiplier));
                        f.add(new EnchantToolFactory(ItemInit.DIAMOND_PAXEL, 15, maxUses, 60, priceMultiplier));
                        f.add(new EnchantToolFactory(ItemInit.DIAMOND_HAMMER, 15, maxUses, 60, priceMultiplier));
                    });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.FORGER, 7,
                    f -> {
                        f.add(new EnchantToolFactory(Items.DIAMOND_HELMET, 15, maxUses, 100, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.DIAMOND_CHESTPLATE, 15, maxUses, 100, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.DIAMOND_LEGGINGS, 15, maxUses, 100, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.DIAMOND_BOOTS, 15, maxUses, 100, priceMultiplier));
                    });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.FORGER, 8,
                    f -> {
                        f.add(new EnchantToolFactory(Items.NETHERITE_SWORD, 15, maxUses, 200, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.NETHERITE_AXE, 15, maxUses, 200, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.NETHERITE_PICKAXE, 15, maxUses, 200, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.NETHERITE_SHOVEL, 15, maxUses, 200, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.NETHERITE_HOE, 15, maxUses, 200, priceMultiplier));
                        f.add(new EnchantToolFactory(ItemInit.NETHERITE_PAXEL, 15, maxUses, 200, priceMultiplier));
                        f.add(new EnchantToolFactory(ItemInit.NETHERITE_HAMMER, 15, maxUses, 200, priceMultiplier));
                    });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.FORGER, 9,
                    f -> {
                        f.add(new EnchantToolFactory(Items.NETHERITE_HELMET, 15, maxUses, 500, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.NETHERITE_CHESTPLATE, 15, maxUses, 500, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.NETHERITE_LEGGINGS, 15, maxUses, 500, priceMultiplier));
                        f.add(new EnchantToolFactory(Items.NETHERITE_BOOTS, 15, maxUses, 500, priceMultiplier));
                    });
            TradeOfferHelper.registerVillagerOffers(ModVillagers.FORGER, 10,
                    f -> {
                        f.add((e, r) -> {
                            int i = r.nextBetween(1, 3);
                            ItemStack result = new ItemStack(Items.ENCHANTED_BOOK, 1);
                            Registry<Enchantment> enchantmentLookup = e.getWorld().getRegistryManager().get(RegistryKeys.ENCHANTMENT);
                            result.addEnchantment(enchantmentLookup.getEntry(enchantmentLookup.get(EnchantmentInit.RANGE)), i);
                            return new TradeOffer(new TradedItem(Items.BOOK),
                                    new TradedItem(Items.EMERALD, 16 + 16 * i), result, 1000);
                        });
                    });

            if (villagerConfig.bananaFarmerTrade) {
                TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, f -> {
                    f.add((e, r) -> new TradeOffer(new TradedItem(ModItems.BANANA, 18), new ItemStack(Items.EMERALD), 1));
                    f.add((e, r) -> new TradeOffer(new TradedItem(ModItems.CHERRY, 2), new ItemStack(Items.EMERALD), 1));
                });
            }

            if (BlocktopiaConfig.getConfig().wanderingTraderTrades) {
                TradeOfferHelper.registerWanderingTraderOffers(1, f -> {
                    f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 5), new ItemStack(ModBlocks.PALM_SAPLING), 1));
                    f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 5), new ItemStack(ModBlocks.BANANA_SAPLING), 1));
                    f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 5), new ItemStack(ModBlocks.CORN_SAPLING), 1));
                    f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 5), new ItemStack(ModBlocks.POISONED_SAPLING), 1));
                    f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 5), new ItemStack(ModBlocks.FLOWERING_CHERRY_SAPLING), 1));
                    f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 5), new ItemStack(ModBlocks.MAHOGANY_SAPLING), 1));
                    f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 1), new ItemStack(ModBlocks.GLOW_FLOWER), 1));
                    f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 1), new ItemStack(DANDELION_C0_0_20A), 1));
                    f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 1), new ItemStack(ROSE_C0_0_20A), 1));
                    f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 1), new ItemStack(POPPY_1_7), 1));
                    f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 1), new ItemStack(RED_MUSHROOM_C0_0_20A), 1));
                    f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 1), new ItemStack(BROWN_MUSHROOM_C0_0_20A), 1));
                    f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 5), new ItemStack(SAPLING_RD161348), 1));
                    f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 5), new ItemStack(SAPLING_C0_0_13A), 1));
                    f.add((e, r) -> new TradeOffer(new TradedItem(Items.EMERALD, 5), new ItemStack(SAPLING_C0_24ST), 1));
                });
            }
        }
    }

    public static class EnchantToolFactory implements TradeOffers.Factory {
        private final TradedItem tool;
        private final int basePrice, maxUses, experience;
        private final float multiplier;

        public EnchantToolFactory(Item item, int basePrice, int maxUses, int experience, float multiplier) {
            this.tool = new TradedItem(item);
            this.basePrice = basePrice;
            this.maxUses = maxUses;
            this.experience = experience;
            this.multiplier = multiplier;
        }

        @Override
        public TradeOffer create(Entity entity, Random random) {
            int i = 5 + random.nextInt(25);
            DynamicRegistryManager dynamicRegistryManager = entity.getWorld().getRegistryManager();
            Optional<RegistryEntryList.Named<Enchantment>> optional = dynamicRegistryManager.get(RegistryKeys.ENCHANTMENT)
                    .getEntryList(EnchantmentTags.ON_TRADED_EQUIPMENT);
            ItemStack itemStack = EnchantmentHelper.enchant(random, new ItemStack(this.tool.itemStack().getItem()), i, dynamicRegistryManager, optional);
            process(itemStack, entity, random);
            return new TradeOffer(tool, Optional.of(new TradedItem(Items.EMERALD, Math.min(64, basePrice + i))), itemStack,
                    this.maxUses, this.experience, this.multiplier);
        }

        public void process(ItemStack stack, Entity e, Random r) {
            Registry<Enchantment> enchantmentRegistry =  e.getRegistryManager().get(RegistryKeys.ENCHANTMENT);
            Stream<Enchantment> stream = enchantmentRegistry.stream()
                    .filter(entry -> !enchantmentRegistry.getKey(entry).orElseThrow().equals(EnchantmentInit.RANGE))
                    .filter(entry -> !enchantmentRegistry.getKey(entry).orElseThrow().equals(Enchantments.SWIFT_SNEAK))
                    .filter(entry -> !enchantmentRegistry.getKey(entry).orElseThrow().equals(Enchantments.SOUL_SPEED))
                    .filter(entry -> !enchantmentRegistry.getKey(entry).orElseThrow().equals(Enchantments.WIND_BURST))
                    .filter(entry -> entry.isAcceptableItem(stack))
                    .filter(entry -> {
                        for (RegistryEntry<Enchantment> en : stack.getEnchantments().getEnchantments())
                            if (en.value().exclusiveSet().contains(enchantmentRegistry.getEntry(entry)))
                                return false;
                        return true;
                    });
            List<Enchantment> list = stream.toList();
            Optional<Enchantment> optional = Util.getRandomOrEmpty(list, r);
            if (optional.isEmpty()) {
                LOGGER.warn("Couldn't find a compatible enchantment for {}", stack);
            } else {
                addEnchantmentToStack(stack, optional.get(), e, r);
            }
        }

        private static void addEnchantmentToStack(ItemStack stack, Enchantment enchantment, Entity e, Random random) {
            int i = MathHelper.nextInt(random, enchantment.getMinLevel(), enchantment.getMaxLevel());
            stack.addEnchantment(e.getWorld().getRegistryManager().get(RegistryKeys.ENCHANTMENT).getEntry(enchantment), i);
        }
    }
}
