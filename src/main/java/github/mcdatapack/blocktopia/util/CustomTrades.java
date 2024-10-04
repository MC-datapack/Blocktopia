package github.mcdatapack.blocktopia.util;

import github.mcdatapack.blocktopia.villager.CustomVillager;
import java.util.Optional;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;

import static github.mcdatapack.blocktopia.init.blocks.LegacyBlocks.*;

public class CustomTrades {
    public CustomTrades() {
    }

    public static void load() {
        TradeOfferHelper.registerVillagerOffers(CustomVillager.LEGACY_VILLAGER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(COBBLESTONE_RD20090515, 20),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(COBBLESTONE_C_0_0_14A, 20),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(COBBLESTONE_B1_7, 20),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(WHITE_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(LIGHT_GRAY_CLOTH_C0_0_20A, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(LIGHT_GRAY_CLOTH_C0_28A, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(DARK_GRAY_CLOTH_C0_0_20A, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(DARK_GRAY_CLOTH_C0_28A, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(RED_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(ORANGE_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new TradeOffer (
                        new TradedItem(Items.EMERALD, 1),
                            new ItemStack(YELLOW_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(CHARTREUSE_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(SPRING_GREEN_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(CYAN_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(CAPRI_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(ULTRAMARINE_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(VIOLET_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(PURPLE_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(MAGENTA_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(ROSE_CLOTH, 15),
                            12, 1, 0.75F
                    ));
            });
        TradeOfferHelper.registerVillagerOffers(CustomVillager.LEGACY_VILLAGER, 2,
                (factories) -> {
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(TNT_C0_26ST, 8),
                            12, 5, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(TNT_C0_28A, 8),
                            12, 5, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(MOSSY_COBBLESTONE_C0_26ST, 8),
                            12, 5, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(MOSSY_COBBLESTONE_B1_8, 8),
                            12, 5, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(BRICKS_C0_26ST, 8),
                            12, 5, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(BRICKS_A1_0_11, 8),
                            12, 5, 0.75F
                    ));
            });
        TradeOfferHelper.registerVillagerOffers(CustomVillager.LEGACY_VILLAGER, 3,
                (factories) -> {
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(WOODEN_PLANKS_RD20090515, 8),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(WOODEN_PLANKS_RD161348, 8),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(WOODEN_PLANKS_C0_0_14A, 8),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(WOODEN_PLANKS_C0_0_15A, 8),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(WOODEN_PLANKS_B1_9PRE5, 8),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(LOG_C0_0_14A, 4),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(SNOW_BLOCK_A1_0_5, 4),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(CLAY_BLOCK_A1_0_11, 4),
                            12, 10, 0.75F
                    ));
            });
        TradeOfferHelper.registerVillagerOffers(CustomVillager.LEGACY_VILLAGER, 4,
                (factories) -> {
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 4),
                            new ItemStack(GOLD_BLOCK_C0_0_20A, 1),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 4),
                            new ItemStack(GOLD_BLOCK_C0_26ST, 1),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 4),
                            new ItemStack(GOLD_BLOCK_A1_2_0, 1),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 4),
                            new ItemStack(GOLD_BLOCK_B1_9PRE5, 1),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 4),
                            new ItemStack(IRON_BLOCK_C0_26ST, 1),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 4),
                            new ItemStack(IRON_BLOCK_A1_2_0, 1),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 4),
                            new ItemStack(IRON_BLOCK_B1_9PRE5, 1),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 12),
                            new ItemStack(DIAMOND_BLOCK_IN20100128, 1),
                            12, 10, 0.125F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 12),
                            new ItemStack(DIAMOND_BLOCK_A1_2_0, 1),
                            12, 10, 0.125F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 12),
                            new ItemStack(DIAMOND_BLOCK_B1_9PRE5, 1),
                            12, 10, 0.125F
                    ));
            });
        TradeOfferHelper.registerVillagerOffers(CustomVillager.LEGACY_VILLAGER, 5,
                (factories) -> {
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 6),
                            new ItemStack(OBSIDIAN_C0_28A, 1),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new TradeOffer (
                            new TradedItem(Items.EMERALD, 64),
                            Optional.of(new TradedItem(OBSIDIAN_C0_28A, 20)),
                            new ItemStack(BEDROCK_C0_0_12A, 1),
                            12, 30, 0.75F
                    ));
            });
    }
}
