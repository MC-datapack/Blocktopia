package github.mcdatapack.blocktopia.util;

import github.mcdatapack.blocktopia.villager.CustomVillager;
import java.util.Optional;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1914;
import net.minecraft.class_9306;

import static github.mcdatapack.blocktopia.init.blocks.LegacyBlocks.*;

public class CustomTrades {
    public CustomTrades() {
    }

    public static void load() {
        TradeOfferHelper.registerVillagerOffers(CustomVillager.LEGACY_VILLAGER, 1,
                factories -> {
                    factories.add((entity, random) -> new class_1914(
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(COBBLESTONE_RD20090515, 20),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(COBBLESTONE_C_0_0_14A, 20),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(COBBLESTONE_B1_7, 20),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(WHITE_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(LIGHT_GRAY_CLOTH_C0_0_20A, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(LIGHT_GRAY_CLOTH_C0_28A, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(DARK_GRAY_CLOTH_C0_0_20A, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(DARK_GRAY_CLOTH_C0_28A, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(RED_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(ORANGE_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new class_1914 (
                        new class_9306(class_1802.field_8687, 1),
                            new class_1799(YELLOW_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) ->  new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(CHARTREUSE_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(SPRING_GREEN_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(CYAN_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(CAPRI_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(ULTRAMARINE_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(VIOLET_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(PURPLE_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(MAGENTA_CLOTH, 15),
                            12, 1, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(ROSE_CLOTH, 15),
                            12, 1, 0.75F
                    ));
            });
        TradeOfferHelper.registerVillagerOffers(CustomVillager.LEGACY_VILLAGER, 2,
                (factories) -> {
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(TNT_C0_26ST, 8),
                            12, 5, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(TNT_C0_28A, 8),
                            12, 5, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(MOSSY_COBBLESTONE_C0_26ST, 8),
                            12, 5, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(MOSSY_COBBLESTONE_B1_8, 8),
                            12, 5, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(BRICKS_C0_26ST, 8),
                            12, 5, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(BRICKS_A1_0_11, 8),
                            12, 5, 0.75F
                    ));
            });
        TradeOfferHelper.registerVillagerOffers(CustomVillager.LEGACY_VILLAGER, 3,
                (factories) -> {
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(WOODEN_PLANKS_RD20090515, 8),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(WOODEN_PLANKS_RD161348, 8),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(WOODEN_PLANKS_C0_0_14A, 8),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(WOODEN_PLANKS_C0_0_15A, 8),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(WOODEN_PLANKS_B1_9PRE5, 8),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(LOG_C0_0_14A, 4),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(SNOW_BLOCK_A1_0_5, 4),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 1),
                            new class_1799(CLAY_BLOCK_A1_0_11, 4),
                            12, 10, 0.75F
                    ));
            });
        TradeOfferHelper.registerVillagerOffers(CustomVillager.LEGACY_VILLAGER, 4,
                (factories) -> {
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 4),
                            new class_1799(GOLD_BLOCK_C0_0_20A, 1),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 4),
                            new class_1799(GOLD_BLOCK_C0_26ST, 1),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 4),
                            new class_1799(GOLD_BLOCK_A1_2_0, 1),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 4),
                            new class_1799(GOLD_BLOCK_B1_9PRE5, 1),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 4),
                            new class_1799(IRON_BLOCK_C0_26ST, 1),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 4),
                            new class_1799(IRON_BLOCK_A1_2_0, 1),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 4),
                            new class_1799(IRON_BLOCK_B1_9PRE5, 1),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 12),
                            new class_1799(DIAMOND_BLOCK_IN20100128, 1),
                            12, 10, 0.125F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 12),
                            new class_1799(DIAMOND_BLOCK_A1_2_0, 1),
                            12, 10, 0.125F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 12),
                            new class_1799(DIAMOND_BLOCK_B1_9PRE5, 1),
                            12, 10, 0.125F
                    ));
            });
        TradeOfferHelper.registerVillagerOffers(CustomVillager.LEGACY_VILLAGER, 5,
                (factories) -> {
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 6),
                            new class_1799(OBSIDIAN_C0_28A, 1),
                            12, 10, 0.75F
                    ));
                    factories.add((entity, random) -> new class_1914 (
                            new class_9306(class_1802.field_8687, 64),
                            Optional.of(new class_9306(OBSIDIAN_C0_28A, 20)),
                            new class_1799(BEDROCK_C0_0_12A, 1),
                            12, 30, 0.75F
                    ));
            });
    }
}
