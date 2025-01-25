package github.mcdatapack.blocktopia.util;

import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.VillagerInit;
import java.util.Optional;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;

import static github.mcdatapack.blocktopia.init.blocks.LegacyBlocks.*;
import static github.mcdatapack.more_tools_and_armor.init.ItemInit.*;

public class CustomTrades {
    private static final float priceMultiplier = 0.75F;

    public static void load(int maxUses) {
        if (BlocktopiaConfig.getConfig().villagerConfig.blocktopiaVillagers) {
            TradeOfferHelper.registerVillagerOffers(VillagerInit.LEGACY, 1,
                    factories -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(COBBLESTONE_RD20090515, 20),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(COBBLESTONE_C_0_0_14A, 20),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(COBBLESTONE_B1_7, 20),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(WHITE_CLOTH, 15),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(LIGHT_GRAY_CLOTH_C0_0_20A, 15),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(LIGHT_GRAY_CLOTH_C0_28A, 15),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(DARK_GRAY_CLOTH_C0_0_20A, 15),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(DARK_GRAY_CLOTH_C0_28A, 15),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(RED_CLOTH, 15),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(ORANGE_CLOTH, 15),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(YELLOW_CLOTH, 15),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(CHARTREUSE_CLOTH, 15),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(SPRING_GREEN_CLOTH, 15),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(CYAN_CLOTH, 15),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(CAPRI_CLOTH, 15),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(ULTRAMARINE_CLOTH, 15),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(VIOLET_CLOTH, 15),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(PURPLE_CLOTH, 15),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(MAGENTA_CLOTH, 15),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(ROSE_CLOTH, 15),
                                maxUses, 1, priceMultiplier
                        ));
                    });
            TradeOfferHelper.registerVillagerOffers(VillagerInit.LEGACY, 2,
                    (factories) -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(TNT_C0_26ST, 8),
                                maxUses, 5, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(TNT_C0_28A, 8),
                                maxUses, 5, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(MOSSY_COBBLESTONE_C0_26ST, 8),
                                maxUses, 5, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(MOSSY_COBBLESTONE_B1_8, 8),
                                maxUses, 5, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(BRICKS_C0_26ST, 8),
                                maxUses, 5, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(BRICKS_A1_0_11, 8),
                                maxUses, 5, priceMultiplier
                        ));
                    });
            TradeOfferHelper.registerVillagerOffers(VillagerInit.LEGACY, 3,
                    (factories) -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(WOODEN_PLANKS_RD20090515, 8),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(WOODEN_PLANKS_RD161348, 8),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(WOODEN_PLANKS_C0_0_14A, 8),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(WOODEN_PLANKS_C0_0_15A, 8),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(WOODEN_PLANKS_B1_9PRE5, 8),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(LOG_C0_0_14A, 4),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(SNOW_BLOCK_A1_0_5, 4),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 1),
                                new ItemStack(CLAY_BLOCK_A1_0_11, 4),
                                maxUses, 10, priceMultiplier
                        ));
                    });
            TradeOfferHelper.registerVillagerOffers(VillagerInit.LEGACY, 4,
                    (factories) -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 4),
                                new ItemStack(GOLD_BLOCK_C0_0_20A, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 4),
                                new ItemStack(GOLD_BLOCK_C0_26ST, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 4),
                                new ItemStack(GOLD_BLOCK_A1_2_0, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 4),
                                new ItemStack(GOLD_BLOCK_B1_9PRE5, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 4),
                                new ItemStack(IRON_BLOCK_C0_26ST, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 4),
                                new ItemStack(IRON_BLOCK_A1_2_0, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 4),
                                new ItemStack(IRON_BLOCK_B1_9PRE5, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, maxUses),
                                new ItemStack(DIAMOND_BLOCK_IN20100128, 1),
                                maxUses, 10, 0.12F
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, maxUses),
                                new ItemStack(DIAMOND_BLOCK_A1_2_0, 1),
                                maxUses, 10, 0.12F
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, maxUses),
                                new ItemStack(DIAMOND_BLOCK_B1_9PRE5, 1),
                                maxUses, 10, 0.12F
                        ));
                    });
            TradeOfferHelper.registerVillagerOffers(VillagerInit.LEGACY, 5,
                    (factories) -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 6),
                                new ItemStack(OBSIDIAN_C0_28A, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 64),
                                Optional.of(new TradedItem(OBSIDIAN_C0_28A, 20)),
                                new ItemStack(BEDROCK_C0_0_12A, 1),
                                maxUses, 30, priceMultiplier
                        ));
                    });


            TradeOfferHelper.registerVillagerOffers(VillagerInit.BEEKEEPER, 1,
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
            TradeOfferHelper.registerVillagerOffers(VillagerInit.BEEKEEPER, 2,
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
            TradeOfferHelper.registerVillagerOffers(VillagerInit.BEEKEEPER, 3,
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
            TradeOfferHelper.registerVillagerOffers(VillagerInit.BEEKEEPER, 4,
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
            TradeOfferHelper.registerVillagerOffers(VillagerInit.BEEKEEPER, 5,
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
            TradeOfferHelper.registerVillagerOffers(VillagerInit.MINER, 1,
                    factories -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.STONE, 2),
                                new ItemStack(Items.COAL, 1),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.DEEPSLATE, 2),
                                new ItemStack(Items.COAL, 1),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.GRANITE, 2),
                                new ItemStack(Items.COAL, 1),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.DIORITE, 2),
                                new ItemStack(Items.COAL, 1),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.ANDESITE, 2),
                                new ItemStack(Items.COAL, 1),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.TUFF, 2),
                                new ItemStack(Items.COAL, 1),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.NETHERRACK, 2),
                                new ItemStack(Items.COAL, 1),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.BASALT, 2),
                                new ItemStack(Items.COAL, 1),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.BLACKSTONE, 1),
                                new ItemStack(Items.COAL, 1),
                                maxUses, 1, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.END_STONE, 1),
                                new ItemStack(Items.COAL, 1),
                                maxUses, 1, priceMultiplier
                        ));
                    });
            TradeOfferHelper.registerVillagerOffers(VillagerInit.MINER, 2, 
                    factories -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.COAL, 1),
                                new ItemStack(Items.COPPER_INGOT, 1),
                                maxUses, 5, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.COPPER_INGOT, 4),
                                new ItemStack(Items.GOLD_INGOT, 1),
                                maxUses, 5, priceMultiplier
                        ));
                        if (BlocktopiaConfig.getConfig().villagerConfig.opTrades) {
                            factories.add((entity, random) -> new TradeOffer(
                                    new TradedItem(Items.EMERALD, 48),
                                    Optional.of(new TradedItem(DEEPSLATE_EMERALD, 1)),
                                    new ItemStack(DEEPSLATE_EMERALD_PICKAXE),
                                    maxUses, 10, priceMultiplier
                            ));
                            factories.add((entity, random) -> new TradeOffer(
                                    new TradedItem(Items.EMERALD, 48),
                                    Optional.of(new TradedItem(END_EMERALD, 2)),
                                    new ItemStack(DEEPSLATE_EMERALD_PICKAXE),
                                    maxUses, 10, priceMultiplier
                            ));
                        }
                    });
            TradeOfferHelper.registerVillagerOffers(VillagerInit.MINER, 3,
                    factories -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.GOLD_INGOT, 2),
                                new ItemStack(Items.IRON_INGOT, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.IRON_INGOT, 8),
                                new ItemStack(Items.DIAMOND, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        if (BlocktopiaConfig.getConfig().villagerConfig.opTrades) {
                            factories.add((entity, random) -> new TradeOffer(
                                    new TradedItem(Items.NETHERITE_INGOT, 2),
                                    Optional.of(new TradedItem(Items.EMERALD, 1)),
                                    new ItemStack(DEEPSLATE_EMERALD, 1),
                                    maxUses, 10, priceMultiplier
                            ));
                        }
                    });
            TradeOfferHelper.registerVillagerOffers(VillagerInit.MINER, 4,
                    factories -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.DIAMOND, 2),
                                Optional.of(new TradedItem(Items.LAVA_BUCKET, 1)),
                                new ItemStack(Items.NETHERITE_INGOT, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.DIAMOND, 2),
                                new ItemStack(Items.ENCHANTING_TABLE, 1),
                                maxUses, 10, priceMultiplier
                        ));
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.GRANITE, 1),
                                new ItemStack(Items.BOOKSHELF, 1),
                                maxUses, 10, priceMultiplier
                        ));
                    });
            TradeOfferHelper.registerVillagerOffers(VillagerInit.MINER, 5,
                    factories -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 4),
                                new ItemStack(NETHERITE_PAXEL, 1),
                                maxUses, 50, priceMultiplier
                        ));
            });
        }
        
        if (BlocktopiaConfig.getConfig().wanderingTraderTrades) {
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    (factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 5),
                                new ItemStack(BlockInit.PALM_SAPLING),
                                6, 1, priceMultiplier
                        )));
                        factories.add(((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 5),
                                new ItemStack(BlockInit.BANANA_SAPLING),
                                6, 1, priceMultiplier
                        )));
                        factories.add(((entity, random) -> new TradeOffer(
                                new TradedItem(Items.EMERALD, 5),
                                new ItemStack(BlockInit.FLOWERING_CHERRY_SAPLING),
                                6, 1, priceMultiplier
                        )));
                    }));
        }
    }
}
