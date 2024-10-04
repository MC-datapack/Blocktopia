package github.mcdatapack.blocktopia.init.blocks;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.SpongeBlock_1_8;
import github.mcdatapack.blocktopia.block.WetSpongeBlock_1_8;
import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.worldgen.ConfiguredFeatureInit;
import github.mcdatapack.blocktopia.list.BlockSetTypeList;
import github.mcdatapack.blocktopia.list.FoodList;
import github.mcdatapack.blocktopia.sign.api.block.BlocktopiaSignBlock;
import github.mcdatapack.blocktopia.sign.api.block.BlocktopiaWallSignBlock;
import java.util.Optional;

import net.minecraft.block.*;
import net.minecraft.class_1294;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_2248;
import net.minecraft.class_2276;
import net.minecraft.class_2323;
import net.minecraft.class_2346;
import net.minecraft.class_2354;
import net.minecraft.class_2356;
import net.minecraft.class_2378;
import net.minecraft.class_2381;
import net.minecraft.class_2397;
import net.minecraft.class_2398;
import net.minecraft.class_2399;
import net.minecraft.class_2431;
import net.minecraft.class_2449;
import net.minecraft.class_2458;
import net.minecraft.class_2459;
import net.minecraft.class_2473;
import net.minecraft.class_2482;
import net.minecraft.class_2488;
import net.minecraft.class_2492;
import net.minecraft.class_2498;
import net.minecraft.class_2502;
import net.minecraft.class_2510;
import net.minecraft.class_2527;
import net.minecraft.class_2530;
import net.minecraft.class_2555;
import net.minecraft.class_2766;
import net.minecraft.class_2960;
import net.minecraft.class_3619;
import net.minecraft.class_3620;
import net.minecraft.class_4970;
import net.minecraft.class_6019;
import net.minecraft.class_7923;
import net.minecraft.class_8813;
import net.minecraft.class_8923;

import static net.minecraft.class_2246.*;

public class LegacyBlocks {
    public static final class_2248 COBBLESTONE_RD20090515;
    public static final class_2248 COBBLESTONE_C_0_0_14A;
    public static final class_2248 COBBLESTONE_B1_7;
    public static final class_2248 WOODEN_PLANKS_RD20090515;
    public static final class_2248 WOODEN_PLANKS_RD161348;
    public static final class_2248 WOODEN_PLANKS_C0_0_14A;
    public static final class_2248 WOODEN_PLANKS_C0_0_15A;
    public static final class_2248 WOODEN_PLANKS_B1_9PRE5;
    public static final class_2248 LOG_C0_0_14A;
    public static final class_2397 LEAVES_C0_0_14A;
    public static final class_2397 LEAVES_C0_0_15A;
    public static final class_2397 LEAVES_C0_24ST;
    public static final class_2356 SAPLING_RD161348;
    public static final class_2248 POTTED_SAPLING_RD161348;
    public static final class_2356 SAPLING_C0_0_13A;
    public static final class_2248 POTTED_SAPLING_C0_0_13A;
    public static final class_2473 SAPLING_C0_24ST;
    public static final class_2248 POTTED_SAPLING_C0_24ST;
    public static final class_2248 BEDROCK_C0_0_12A;
    public static final class_2346 SAND_C0_0_14A;
    public static final class_2346 SAND_C0_0_15A;
    public static final class_2346 SAND_B1_9PRE6;
    public static final class_2346 GRAVEL_C0_0_14A;
    public static final class_2346 GRAVEL_C0_0_15A;
    public static final class_2346 GRAVEL_B1_9PRE5;
    public static final class_2346 GRAVEL_1_3;
    public static final class_2431 COAL_ORE_C0_0_14A;
    public static final class_2431 COAL_ORE_1_14;
    public static final class_2248 IRON_ORE_C0_0_14A;
    public static final class_2248 IRON_ORE_1_14;
    public static final class_2248 IRON_ORE_1_14_1;
    public static final class_2248 GOLD_ORE_C0_0_14A;
    public static final class_2248 GOLD_ORE_C0_26ST;
    public static final class_2248 GOLD_ORE_1_14;
    public static final class_2502 SPONGE_C0_0_19A;
    public static final SpongeBlock_1_8 SPONGE_1_8;
    public static final WetSpongeBlock_1_8 WET_SPONGE_1_8;
    public static final class_8923 GLASS_C0_0_19A;
    public static final class_2248 WHITE_CLOTH;
    public static final class_2248 LIGHT_GRAY_CLOTH_C0_0_20A;
    public static final class_2248 LIGHT_GRAY_CLOTH_C0_28A;
    public static final class_2248 DARK_GRAY_CLOTH_C0_0_20A;
    public static final class_2248 DARK_GRAY_CLOTH_C0_28A;
    public static final class_2248 RED_CLOTH;
    public static final class_2248 ORANGE_CLOTH;
    public static final class_2248 YELLOW_CLOTH;
    public static final class_2248 CHARTREUSE_CLOTH;
    public static final class_2248 SPRING_GREEN_CLOTH;
    public static final class_2248 CYAN_CLOTH;
    public static final class_2248 CAPRI_CLOTH;
    public static final class_2248 ULTRAMARINE_CLOTH;
    public static final class_2248 VIOLET_CLOTH;
    public static final class_2248 PURPLE_CLOTH;
    public static final class_2248 MAGENTA_CLOTH;
    public static final class_2248 ROSE_CLOTH;
    public static final class_2248 GOLD_BLOCK_C0_0_20A;
    public static final class_2248 GOLD_BLOCK_C0_26ST;
    public static final class_2248 GOLD_BLOCK_A1_2_0;
    public static final class_2248 GOLD_BLOCK_B1_9PRE5;
    public static final class_2356 DANDELION_C0_0_20A;
    public static final class_2248 POTTED_DANDELIONS_C0_0_20A;
    public static final class_2356 ROSE_C0_0_20A;
    public static final class_2248 POTTED_ROSE_C0_0_20A;
    public static final class_2356 POPPY_1_7;
    public static final class_2248 POTTED_POPPY_1_7;
    public static final class_2381 BROWN_MUSHROOM_C0_0_20A;
    public static final class_2248 POTTED_BROWN_MUSHROOM_C0_0_20A;
    public static final class_2381 RED_MUSHROOM_C0_0_20A;
    public static final class_2248 POTTED_RED_MUSHROOM_C0_0_20A;
    public static final class_2482 STONE_SLAB_C0_26ST;
    public static final class_2248 IRON_BLOCK_C0_26ST;
    public static final class_2248 IRON_BLOCK_A1_2_0;
    public static final class_2248 IRON_BLOCK_B1_9PRE5;
    public static final class_2530 TNT_C0_26ST;
    public static final class_2530 TNT_C0_28A;
    public static final class_2248 MOSSY_COBBLESTONE_C0_26ST;
    public static final class_2248 MOSSY_COBBLESTONE_B1_8;
    public static final class_2248 BRICKS_C0_26ST;
    public static final class_2248 BRICKS_A1_0_11;
    public static final class_2248 BOOKSHELF_C0_26ST;
    public static final class_2248 BOOKSHELF_B1_9PRE5;
    public static final class_2248 OBSIDIAN_C0_28A;
    public static final class_2431 DIAMOND_ORE_IN20100128;
    public static final class_2431 DIAMOND_ORE_1_14;
    public static final class_2248 DIAMOND_BLOCK_IN20100128;
    public static final class_2248 DIAMOND_BLOCK_A1_2_0;
    public static final class_2248 DIAMOND_BLOCK_B1_9PRE5;
    public static final class_2248 CRAFTING_TABLE_IN20100131;
    public static final class_2248 CRAFTING_TABLE_1_14;
    public static final class_2248 FURNACE_IN20100219;
    public static final class_2248 LIT_FURNACE_IN20100219;
    public static final class_2248 FURNACE_B1_2;
    public static final class_2248 LIT_FURNACE_B1_2;
    public static final class_2399 LADDER_INF20100607;
    public static final class_2399 LADDER_INF20100618;
    public static final class_2510 WOODEN_STAIRS_RD20090515;
    public static final class_2510 WOODEN_STAIRS_RD161348;
    public static final class_2510 WOODEN_STAIRS_C0_0_14A;
    public static final class_2510 WOODEN_STAIRS_INF20100629;
    public static final class_2510 WOODEN_STAIRS_B1_9PRE5;
    public static final class_2510 COBBLESTONE_STAIRS_RD20090515;
    public static final class_2510 COBBLESTONE_STAIRS_C0_0_14A;
    public static final class_2510 COBBLESTONE_STAIRS_B1_7;
    public static class_2960 SIGN_INF20100607_TEXTURE;
    public static final class_2527 TORCH_IN20100124_2;
    public static final class_2555 WALL_TORCH_IN20100124_2;
    public static final BlocktopiaSignBlock SIGN_INF20100607;
    public static final BlocktopiaWallSignBlock WALL_SIGN_INF20100607;
    public static final class_2323 WOODEN_DOOR_INF20100607;
    public static final class_2449 REDSTONE_ORE_A1_0_1;
    public static final class_2449 REDSTONE_ORE_1_14;
    public static final class_2459 REDSTONE_TORCH_A1_0_1;
    public static final class_2458 REDSTONE_WALL_TORCH_A1_0_1;
    public static final class_2488 SNOW_A1_0_4;
    public static final class_2248 ICE_A1_0_4;
    public static final class_2248 SNOW_BLOCK_A1_0_5;
    public static final class_2248 CLAY_BLOCK_A1_0_11;
    public static final class_2354 WOODEN_FENCE_RD20090515;
    public static final class_2354 WOODEN_FENCE_RD161348;
    public static final class_2354 WOODEN_FENCE_C0_0_14A;
    public static final class_2354 WOODEN_FENCE_A1_0_17;
    public static final class_2354 WOODEN_FENCE_B1_9PRE5;
    public static final class_2248 NETHERRACK_A1_2_0;
    public static final class_2248 NETHERRACK_B1_9PRE5;
    public static final class_2492 SOUL_SAND_A1_2_0;
    public static final class_2248 GLOWSTONE_A1_2_0;
    public static final class_2248 GLOWSTONE_B1_9PRE5;
    public static final class_2276 CARVED_PUMPKIN_A1_2_0;
    public static final class_2276 JACK_O_LANTERN_A1_2_0;

    public LegacyBlocks() {
    }

    public static <T extends class_2248> T registerWithoutItem(String name, T block) {
        return class_2378.method_10230(class_7923.field_41175, Blocktopia.id(name), block);
    }
    public static <T extends class_2248> T register(String name, T block, class_1792.class_1793 settings) {
        T registered = registerWithoutItem(name, block);
        ItemInit.register(name, new class_1747(registered, settings));
        return registered;
    }
    public static <T extends class_2248> T register(String name, T block) {
        return register(name, block, new class_1792.class_1793());
    }
    public static void load() {}

    static {
        COBBLESTONE_RD20090515 = register("cobblestone_rd20090515", new class_2248(class_4970.class_2251.method_9630(field_10445)));
        COBBLESTONE_C_0_0_14A = register("cobblestone_c_0_0_14a", new class_2248(class_4970.class_2251.method_9630(field_10445)));
        COBBLESTONE_B1_7 = register("cobblestone_b1_7", new class_2248(class_4970.class_2251.method_9630(field_10445)));
        WOODEN_PLANKS_RD20090515 = register("wooden_planks_rd20090515", new class_2248(class_4970.class_2251.method_9630(field_10161)));
        WOODEN_PLANKS_RD161348 = register("wooden_planks_rd161348", new class_2248(class_4970.class_2251.method_9630(field_10161)));
        WOODEN_PLANKS_C0_0_14A = register("wooden_planks_c0_0_14a", new class_2248(class_4970.class_2251.method_9630(field_10161)));
        WOODEN_PLANKS_C0_0_15A = register("wooden_planks_c0_0_15a", new class_2248(class_4970.class_2251.method_9630(field_10161)));
        WOODEN_PLANKS_B1_9PRE5 = register("wooden_planks_b1_9pre5", new class_2248(class_4970.class_2251.method_9630(field_10161)));
        LOG_C0_0_14A = register("log_c0_0_14a", method_26117(class_3620.field_15996, class_3620.field_15996));
        LEAVES_C0_0_14A = register("leaves_c0_0_14a", new class_2397(class_4970.class_2251.method_9630(field_10503)));
        LEAVES_C0_0_15A = register("leaves_c0_0_15a", new class_2397(class_4970.class_2251.method_9630(field_10503)));
        LEAVES_C0_24ST = register("leaves_c0_24st", new class_2397(class_4970.class_2251.method_9630(field_10503)));
        SAPLING_RD161348 = register("sapling_rd161348", new class_2356(class_1294.field_16595, 4.0F, 
                class_4970.class_2251.method_9630(field_10394)));
        POTTED_SAPLING_RD161348 = register("potted_sapling_rd161348", method_50000(field_10394));
        SAPLING_C0_0_13A = register("sapling_c0_0_13a", new class_2356(class_1294.field_16595, 4.0F, class_4970.class_2251.method_9630(field_10394)));
        POTTED_SAPLING_C0_0_13A = register("potted_sapling_c0_0_13a", method_50000(SAPLING_C0_0_13A));
        SAPLING_C0_24ST = register("sapling_c0_24st", new class_2473(new class_8813(Blocktopia.id("sapling").toString(), 
                0.1F, 
                Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY), Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY), 
                Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY), Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY), 
                Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY), Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY)), 
                class_4970.class_2251.method_9630(field_10394)));
        POTTED_SAPLING_C0_24ST = registerWithoutItem("potted_sapling_c0_24st", method_50000(SAPLING_C0_24ST));
        BEDROCK_C0_0_12A = register("bedrock_c0_0_12a", new class_2248(class_4970.class_2251.method_9630(field_9987)));
        SAND_C0_0_14A = register("sand_c0_0_14a", new class_2346(class_4970.class_2251.method_9630(field_10102)) {
            @Override protected MapCodec<? extends class_2346> method_53969() {return null;}});
        SAND_C0_0_15A = register("sand_c0_0_15a", new class_2346(class_4970.class_2251.method_9630(field_10102)) {
            @Override protected MapCodec<? extends class_2346> method_53969() {return null;}});
        SAND_B1_9PRE6 = register("sand_b1_9pre6", new class_2346(class_4970.class_2251.method_9630(field_10102)) {
            @Override protected MapCodec<? extends class_2346> method_53969() {return null;}});
        GRAVEL_C0_0_14A = register("gravel_c0_0_14a", new class_2346(class_4970.class_2251.method_9630(field_10255)) {
            @Override protected MapCodec<? extends class_2346> method_53969() {return null;}});
        GRAVEL_C0_0_15A = register("gravel_c0_0_15a", new class_2346(class_4970.class_2251.method_9630(field_10255)) {
            @Override protected MapCodec<? extends class_2346> method_53969() {return null;}});
        GRAVEL_B1_9PRE5 = register("gravel_b1_9pre5", new class_2346(class_4970.class_2251.method_9630(field_10255)) {
            @Override protected MapCodec<? extends class_2346> method_53969() {return null;}});
        GRAVEL_1_3 = register("gravel_1_3", new class_2346(class_4970.class_2251.method_9630(field_10255)) {
            @Override protected MapCodec<? extends class_2346> method_53969() {return null;}});
        COAL_ORE_C0_0_14A = register("coal_ore_c0_0_14a", new class_2431(class_6019.method_35017(0, 2), class_4970.class_2251.method_9630(field_10418)));
        COAL_ORE_1_14 = register("coal_ore_1_14", new class_2431(class_6019.method_35017(0, 2), class_4970.class_2251.method_9630(field_10418)));
        IRON_ORE_C0_0_14A = register("iron_ore_c0_0_14a", new class_2248(class_4970.class_2251.method_9630(field_10212)));
        IRON_ORE_1_14 = register("iron_ore_1_14", new class_2248(class_4970.class_2251.method_9630(field_10212)));
        IRON_ORE_1_14_1 = register("iron_ore_1_14_1", new class_2248(class_4970.class_2251.method_9630(field_10212)));
        GOLD_ORE_C0_0_14A = register("gold_ore_c0_0_14a", new class_2248(class_4970.class_2251.method_9630(field_10571)));
        GOLD_ORE_C0_26ST = register("gold_ore_c0_26st", new class_2248(class_4970.class_2251.method_9630(field_10571)));
        GOLD_ORE_1_14 = register("gold_ore_1_14", new class_2248(class_4970.class_2251.method_9630(field_10571)));
        SPONGE_C0_0_19A = register("sponge_c0_0_19a", new class_2502(class_4970.class_2251.method_9630(field_10258)));
        SPONGE_1_8 = register("sponge_1_8", new SpongeBlock_1_8(class_4970.class_2251.method_9630(field_10258)));
        WET_SPONGE_1_8 = register("wet_sponge_1_8", new WetSpongeBlock_1_8(class_4970.class_2251.method_9630(field_10562)));
        GLASS_C0_0_19A = register("glass_c0_0_19a", new class_8923(class_4970.class_2251.method_9630(field_10033)));
        WHITE_CLOTH = register("withe_cloth", new class_2248(class_4970.class_2251.method_9630(field_10446)));
        LIGHT_GRAY_CLOTH_C0_0_20A = register("light_gray_cloth_c0_0_20a", new class_2248(class_4970.class_2251.method_9630(field_10222)));
        LIGHT_GRAY_CLOTH_C0_28A = register("light_gray_cloth_c0_28a", new class_2248(class_4970.class_2251.method_9630(field_10222)));
        DARK_GRAY_CLOTH_C0_0_20A = register("dark_gray_cloth_c0_0_20a", new class_2248(class_4970.class_2251.method_9630(field_10423)));
        DARK_GRAY_CLOTH_C0_28A = register("dark_gray_cloth_c0_28a", new class_2248(class_4970.class_2251.method_9630(field_10423)));
        RED_CLOTH = register("red_cloth", new class_2248(class_4970.class_2251.method_9630(field_10314)));
        ORANGE_CLOTH = register("orange_cloth", new class_2248(class_4970.class_2251.method_9630(field_10095)));
        YELLOW_CLOTH = register("yellow_cloth", new class_2248(class_4970.class_2251.method_9630(field_10490)));
        CHARTREUSE_CLOTH = register("chartreuse_cloth", new class_2248(class_4970.class_2251.method_9630(field_10028)));
        SPRING_GREEN_CLOTH = register("spring_green_cloth", new class_2248(class_4970.class_2251.method_9630(field_10170)));
        CYAN_CLOTH = register("cyan_cloth", new class_2248(class_4970.class_2251.method_9630(field_10619)));
        CAPRI_CLOTH = register("capri_cloth", new class_2248(class_4970.class_2251.method_9630(field_10294)));
        ULTRAMARINE_CLOTH = register("ultramarine_cloth", new class_2248(class_4970.class_2251.method_9630(field_10514)));
        VIOLET_CLOTH = register("violet_cloth", new class_2248(class_4970.class_2251.method_9630(field_10259)));
        PURPLE_CLOTH = register("purple_cloth", new class_2248(class_4970.class_2251.method_9630(field_10259)));
        MAGENTA_CLOTH = register("magenta_cloth", new class_2248(class_4970.class_2251.method_9630(field_10215)));
        ROSE_CLOTH = register("rose_cloth", new class_2248(class_4970.class_2251.method_9630(field_10459)));
        GOLD_BLOCK_C0_0_20A = register("gold_block_c0_0_20a", new class_2248(class_4970.class_2251.method_9630(field_10205)));
        GOLD_BLOCK_C0_26ST = register("gold_block_c0_26st", new class_2248(class_4970.class_2251.method_9630(field_10205)));
        GOLD_BLOCK_A1_2_0 = register("gold_block_a1_2_0", new class_2248(class_4970.class_2251.method_9630(field_10205)));
        GOLD_BLOCK_B1_9PRE5 = register("gold_block_b1_9pre5", new class_2248(class_4970.class_2251.method_9630(field_10205)));
        DANDELION_C0_0_20A = register("dandelion_c0_0_20a", new class_2356(class_1294.field_5922, 0.35F, class_4970.class_2251.method_9630(field_10182)));
        POTTED_DANDELIONS_C0_0_20A = registerWithoutItem("potted_dandelion_c0_0_20a", method_50000(DANDELION_C0_0_20A));
        ROSE_C0_0_20A = register("rose_c0_0_20a", new class_2356(class_1294.field_5925, 5.0F, class_4970.class_2251.method_9630(field_10449)));
        POTTED_ROSE_C0_0_20A = registerWithoutItem("potted_rose_c0_0_20a", method_50000(ROSE_C0_0_20A));
        POPPY_1_7 = register("poppy_1_7", new class_2356(class_1294.field_5925, 5.0F, class_4970.class_2251.method_9630(field_10449)));
        POTTED_POPPY_1_7 = registerWithoutItem("potted_poppy_1_7", method_50000(POPPY_1_7));
        BROWN_MUSHROOM_C0_0_20A = register("brown_mushroom_c0_0_20a", new class_2381(class_4970.class_2251.method_9630(field_10251)), new class_1792.class_1793().method_19265(FoodList.BROWN_MUSHROOM_C0_0_20A_SETTINGS));
        POTTED_BROWN_MUSHROOM_C0_0_20A = registerWithoutItem("potted_brown_mushroom_c0_0_20a", method_50000(BROWN_MUSHROOM_C0_0_20A));
        RED_MUSHROOM_C0_0_20A = register("red_mushroom_c0_0_20a", new class_2381(class_4970.class_2251.method_9630(field_10559)), new class_1792.class_1793().method_19265(FoodList.RED_MUSHROOM_C0_0_20A_SETTINGS));
        POTTED_RED_MUSHROOM_C0_0_20A = registerWithoutItem("potted_red_mushroom_c0_0_20a", method_50000(RED_MUSHROOM_C0_0_20A));
        STONE_SLAB_C0_26ST = register("stone_slab_c0_26st", new class_2482(class_4970.class_2251.method_9630(field_10136)));
        IRON_BLOCK_C0_26ST = register("iron_block_c0_26st", new class_2248(class_4970.class_2251.method_9630(field_10085)));
        IRON_BLOCK_A1_2_0 = register("iron_block_a1_2_0", new class_2248(class_4970.class_2251.method_9630(field_10085)));
        IRON_BLOCK_B1_9PRE5 = register("iron_block_b1_9pre5", new class_2248(class_4970.class_2251.method_9630(field_10085)));
        TNT_C0_26ST = register("tnt_c0_26st", new class_2530(class_4970.class_2251.method_9630(field_10375)));
        TNT_C0_28A = register("tnt_c0_28a", new class_2530(class_4970.class_2251.method_9630(field_10375)));
        MOSSY_COBBLESTONE_C0_26ST = register("mossy_cobblestone_c0_26st", new class_2248(class_4970.class_2251.method_9630(field_9989)));
        MOSSY_COBBLESTONE_B1_8 = register("mossy_cobblestone_b1_8", new class_2248(class_4970.class_2251.method_9630(field_9989)));
        BRICKS_C0_26ST = register("bricks_c0_26st", new class_2248(class_4970.class_2251.method_9630(field_10104)));
        BRICKS_A1_0_11 = register("bricks_a1_0_11", new class_2248(class_4970.class_2251.method_9630(field_10104)));
        BOOKSHELF_C0_26ST = register("bookshelf_c0_26st", new class_2248(class_4970.class_2251.method_9630(field_10504)));
        BOOKSHELF_B1_9PRE5 = register("bookshelf_b1_9pre5", new class_2248(class_4970.class_2251.method_9630(field_10504)));
        OBSIDIAN_C0_28A = register("obsidian_c0_28a", new class_2248(class_4970.class_2251.method_9630(field_10540)));
        DIAMOND_ORE_IN20100128 = register("diamond_ore_in20100128", new class_2431(class_6019.method_35017(3, 7), class_4970.class_2251.method_9630(field_10442)));
        DIAMOND_ORE_1_14 = register("diamond_ore_1_14", new class_2431(class_6019.method_35017(3, 7), class_4970.class_2251.method_9630(field_10442)));
        DIAMOND_BLOCK_IN20100128 = register("diamond_block_in20100128", new class_2248(class_4970.class_2251.method_9630(field_10201)));
        DIAMOND_BLOCK_A1_2_0 = register("diamond_block_a1_2_0", new class_2248(class_4970.class_2251.method_9630(field_10201)));
        DIAMOND_BLOCK_B1_9PRE5 = register("diamond_block_b1_9pre5", new class_2248(class_4970.class_2251.method_9630(field_10201)));
        CRAFTING_TABLE_IN20100131 = register("crafting_table_in20100131", new class_2248(class_4970.class_2251.method_9630(field_9980)));
        CRAFTING_TABLE_1_14 = register("crafting_table_1_14", new class_2248(class_4970.class_2251.method_9630(field_9980)));
        FURNACE_IN20100219 = register("furnace_in20100219", new class_2248(class_4970.class_2251.method_9637().method_31710(class_3620.field_16023).method_51368(class_2766.field_12653).method_29292().method_9632(3.5F)));
        LIT_FURNACE_IN20100219 = register("lit_furnace_in20100219", new class_2248(class_4970.class_2251.method_9637().method_31710(class_3620.field_16023).method_51368(class_2766.field_12653).method_29292().method_9632(3.5F).method_9631((state) -> {
            return 13;
        })));
        FURNACE_B1_2 = register("furnace_b1_2", new class_2248(class_4970.class_2251.method_9630(FURNACE_IN20100219)));
        LIT_FURNACE_B1_2 = register("lit_furnace_b1_2", new class_2248(class_4970.class_2251.method_9630(LIT_FURNACE_IN20100219)));
        LADDER_INF20100607 = register("ladder_inf20100607", new class_2399(class_4970.class_2251.method_9630(field_9983)));
        LADDER_INF20100618 = register("ladder_inf20100618", new class_2399(class_4970.class_2251.method_9630(field_9983)));
        WOODEN_STAIRS_RD20090515 = register("wooden_stairs_rd20090515", new class_2510(WOODEN_PLANKS_RD20090515.method_9564(), class_4970.class_2251.method_9630(field_10563)));
        WOODEN_STAIRS_RD161348 = register("wooden_stairs_rd161348", new class_2510(WOODEN_PLANKS_RD161348.method_9564(), class_4970.class_2251.method_9630(field_10563)));
        WOODEN_STAIRS_C0_0_14A = register("wooden_stairs_c0_0_14a", new class_2510(WOODEN_PLANKS_C0_0_14A.method_9564(), class_4970.class_2251.method_9630(field_10563)));
        WOODEN_STAIRS_INF20100629 = register("wooden_stairs_inf20100629", new class_2510(WOODEN_PLANKS_C0_0_15A.method_9564(), class_4970.class_2251.method_9630(field_10563)));
        WOODEN_STAIRS_B1_9PRE5 = register("wooden_stairs_b1_9pre5", new class_2510(WOODEN_PLANKS_B1_9PRE5.method_9564(), class_4970.class_2251.method_9630(field_10563)));
        COBBLESTONE_STAIRS_RD20090515 = register("cobblestone_stairs_rd20090515", new class_2510(COBBLESTONE_RD20090515.method_9564(), class_4970.class_2251.method_9630(field_10596)));
        COBBLESTONE_STAIRS_C0_0_14A = register("cobblestone_stairs_c0_0_14a", new class_2510(COBBLESTONE_C_0_0_14A.method_9564(), class_4970.class_2251.method_9630(field_10596)));
        COBBLESTONE_STAIRS_B1_7 = register("cobblestone_stairs_b1_7", new class_2510(COBBLESTONE_B1_7.method_9564(), class_4970.class_2251.method_9630(field_10596)));
        SIGN_INF20100607_TEXTURE = Blocktopia.id("entity/signs/wooden_c0_0_15a");
        TORCH_IN20100124_2 = registerWithoutItem("torch_in20100124_2", new class_2527(class_2398.field_11240, class_4970.class_2251.method_9637().method_9634().method_9618().method_9631((state) -> {return 14;}).method_9626(class_2498.field_11547).method_50012(class_3619.field_15971)));
        WALL_TORCH_IN20100124_2 = registerWithoutItem("wall_torch_in20100124_2", new class_2555(class_2398.field_11240, class_4970.class_2251.method_9637().method_9634().method_9618().method_9631((state) -> {
            return 14;
        }).method_9626(class_2498.field_11547).method_16228(TORCH_IN20100124_2).method_50012(class_3619.field_15971)));
        SIGN_INF20100607 = registerWithoutItem("sign_inf20100607", new BlocktopiaSignBlock(SIGN_INF20100607_TEXTURE, class_4970.class_2251.method_9637().method_31710(class_3620.field_15996).method_51369().method_51368(class_2766.field_12651).method_9634().method_9632(1.0F).method_50013()));
        WALL_SIGN_INF20100607 = registerWithoutItem("wall_sign_inf20100607", new BlocktopiaWallSignBlock(SIGN_INF20100607_TEXTURE, class_4970.class_2251.method_9637().method_31710(class_3620.field_15996).method_51369().method_51368(class_2766.field_12651).method_9634().method_9632(1.0F).method_16228(SIGN_INF20100607).method_50013()));
        WOODEN_DOOR_INF20100607 = register("wooden_door_inf20100607", new class_2323(BlockSetTypeList.WOODEN_C0_0_15A, class_4970.class_2251.method_9630(field_10149)));
        REDSTONE_ORE_A1_0_1 = register("redstone_ore_a1_0_1", new class_2449(class_4970.class_2251.method_9630(field_10080)));
        REDSTONE_ORE_1_14 = register("redstone_ore_1_14", new class_2449(class_4970.class_2251.method_9630(field_10080)));
        REDSTONE_TORCH_A1_0_1 = registerWithoutItem("redstone_torch_a1_0_1", new class_2459(class_4970.class_2251.method_9630(field_10523)));
        REDSTONE_WALL_TORCH_A1_0_1 = registerWithoutItem("redstone_wall_torch_a1_0_1", new class_2458(class_4970.class_2251.method_9630(field_10301).method_16228(REDSTONE_TORCH_A1_0_1)));
        SNOW_A1_0_4 = register("snow_a1_0_4", new class_2488(class_4970.class_2251.method_9630(field_10477)));
        ICE_A1_0_4 = register("ice_a1_0_4", new class_2248(class_4970.class_2251.method_9630(field_10295)));
        SNOW_BLOCK_A1_0_5 = register("snow_block_a1_0_5", new class_2248(class_4970.class_2251.method_9630(field_10491)));
        CLAY_BLOCK_A1_0_11 = register("clay_block_a1_0_11", new class_2248(class_4970.class_2251.method_9630(field_10460)));
        WOODEN_FENCE_RD20090515 = register("wooden_fence_rd20090515", new class_2354(class_4970.class_2251.method_9637().method_51369().method_51368(class_2766.field_12651).method_9632(2.0F).method_9626(class_2498.field_11547).method_50013()));
        WOODEN_FENCE_RD161348 = register("wooden_fence_rd161348", new class_2354(class_4970.class_2251.method_9637().method_51369().method_51368(class_2766.field_12651).method_9632(2.0F).method_9626(class_2498.field_11547).method_50013()));
        WOODEN_FENCE_C0_0_14A = register("wooden_fence_c0_0_14a", new class_2354(class_4970.class_2251.method_9637().method_51369().method_51368(class_2766.field_12651).method_9632(2.0F).method_9626(class_2498.field_11547).method_50013()));
        WOODEN_FENCE_A1_0_17 = register("wooden_fence_a1_0_17", new class_2354(class_4970.class_2251.method_9637().method_51369().method_51368(class_2766.field_12651).method_9632(2.0F).method_9626(class_2498.field_11547).method_50013()));
        WOODEN_FENCE_B1_9PRE5 = register("wooden_fence_b1_9pre5", new class_2354(class_4970.class_2251.method_9637().method_51369().method_51368(class_2766.field_12651).method_9632(2.0F).method_9626(class_2498.field_11547).method_50013()));
        NETHERRACK_A1_2_0 = register("netherrack_a1_2_0", new class_2248(class_4970.class_2251.method_9630(field_10515)));
        NETHERRACK_B1_9PRE5 = register("netherrack_b1_9pre5", new class_2248(class_4970.class_2251.method_9630(field_10515)));
        SOUL_SAND_A1_2_0 = register("soul_sand_a1_2_0", new class_2492(class_4970.class_2251.method_9630(field_10114)));
        GLOWSTONE_A1_2_0 = register("glowstone_a1_2_0", new class_2248(class_4970.class_2251.method_9630(field_10171)));
        GLOWSTONE_B1_9PRE5 = register("glowstone_b1_9pre5", new class_2248(class_4970.class_2251.method_9630(field_10171)));
        CARVED_PUMPKIN_A1_2_0 = register("carved_pumpkin_a1_2_0", new class_2276(class_4970.class_2251.method_9630(field_10147)));
        JACK_O_LANTERN_A1_2_0 = register("jack_o_lantern_a1_2_0", new class_2276(class_4970.class_2251.method_9630(field_10009)));
    }
}
