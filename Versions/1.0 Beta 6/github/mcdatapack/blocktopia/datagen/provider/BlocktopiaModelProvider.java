package github.mcdatapack.blocktopia.datagen.provider;

import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import java.util.Optional;

import github.mcdatapack.blocktopia.list.TagList;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.class_1802;
import net.minecraft.class_2960;
import net.minecraft.class_4910;
import net.minecraft.class_4910.class_4913;
import net.minecraft.class_4915;
import net.minecraft.class_4942;
import net.minecraft.class_4943;
import net.minecraft.class_5794;

public class BlocktopiaModelProvider extends FabricModelProvider {

    public BlocktopiaModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(class_4910 blockStateModelGenerator) {
        blockStateModelGenerator.method_25641(BlockInit.PAPER_BLOCK);
        blockStateModelGenerator.method_25641(BlockInit.GUNPOWDER_BLOCK);
        blockStateModelGenerator.method_25641(BlockInit.SMALL_CHEST);
        blockStateModelGenerator.method_25641(BlockInit.PALM_LEAVES);
        blockStateModelGenerator.method_25545(BlockInit.PALM_SAPLING, BlockInit.POTTED_PALM_SAPLING, class_4913.field_22840);
        blockStateModelGenerator.method_25676(BlockInit.PALM_LOG)
                .method_25730(BlockInit.PALM_LOG).method_25728(BlockInit.PALM_WOOD);
        blockStateModelGenerator.method_25676(BlockInit.STRIPPED_PALM_LOG)
                .method_25730(BlockInit.STRIPPED_PALM_LOG).method_25728(BlockInit.STRIPPED_PALM_WOOD);
        var palmFamaly = new class_5794.class_5795(BlockInit.PALM_PLANKS)
                .method_33482(BlockInit.PALM_BUTTON)
                .method_33490(BlockInit.PALM_FENCE)
                .method_33491(BlockInit.PALM_FENCE_GATE)
                .method_33494(BlockInit.PALM_PRESSURE_PLATE)
                .method_33483(BlockInit.PALM_SIGN, BlockInit.PALM_WALL_SIGN)
                .method_33492(BlockInit.PALM_SLAB)
                .method_33493(BlockInit.PALM_STAIRS)
                .method_33489(BlockInit.PALM_DOOR)
                .method_33496(BlockInit.PALM_TRAPDOOR)
                .method_33484("wooden")
                .method_33487("has_planks")
                .method_33481();
        blockStateModelGenerator.method_25650(palmFamaly.method_33469())
                .method_33522(palmFamaly);
        blockStateModelGenerator.method_46190(BlockInit.STRIPPED_PALM_LOG, BlockInit.PALM_HANGING_SIGN, BlockInit.PALM_WALL_HANGING_SIGN);



        blockStateModelGenerator.method_25676(LegacyBlocks.LOG_C0_0_14A)
                .method_25730(LegacyBlocks.LOG_C0_0_14A);
        blockStateModelGenerator.method_25641(LegacyBlocks.LEAVES_C0_0_14A);
        blockStateModelGenerator.method_25641(LegacyBlocks.LEAVES_C0_0_15A);
        blockStateModelGenerator.method_25641(LegacyBlocks.LEAVES_C0_24ST);
        blockStateModelGenerator.method_25545(LegacyBlocks.SAPLING_RD161348, LegacyBlocks.POTTED_SAPLING_RD161348, class_4913.field_22840);
        blockStateModelGenerator.method_25545(LegacyBlocks.SAPLING_C0_0_13A, LegacyBlocks.POTTED_SAPLING_C0_0_13A, class_4913.field_22840);
        blockStateModelGenerator.method_25545(LegacyBlocks.SAPLING_C0_24ST, LegacyBlocks.POTTED_SAPLING_C0_24ST, class_4913.field_22840);
        blockStateModelGenerator.method_25641(LegacyBlocks.BEDROCK_C0_0_12A);
        blockStateModelGenerator.method_25641(LegacyBlocks.SAND_C0_0_14A);
        blockStateModelGenerator.method_25641(LegacyBlocks.SAND_C0_0_15A);
        blockStateModelGenerator.method_25641(LegacyBlocks.SAND_B1_9PRE6);
        blockStateModelGenerator.method_25641(LegacyBlocks.GRAVEL_C0_0_14A);
        blockStateModelGenerator.method_25641(LegacyBlocks.GRAVEL_C0_0_15A);
        blockStateModelGenerator.method_25641(LegacyBlocks.GRAVEL_B1_9PRE5);
        blockStateModelGenerator.method_25641(LegacyBlocks.GRAVEL_1_3);
        blockStateModelGenerator.method_25641(LegacyBlocks.COAL_ORE_C0_0_14A);
        blockStateModelGenerator.method_25641(LegacyBlocks.COAL_ORE_1_14);
        blockStateModelGenerator.method_25641(LegacyBlocks.IRON_ORE_C0_0_14A);
        blockStateModelGenerator.method_25641(LegacyBlocks.IRON_ORE_1_14);
        blockStateModelGenerator.method_25641(LegacyBlocks.IRON_ORE_1_14_1);
        blockStateModelGenerator.method_25641(LegacyBlocks.GOLD_ORE_C0_0_14A);
        blockStateModelGenerator.method_25641(LegacyBlocks.GOLD_ORE_C0_26ST);
        blockStateModelGenerator.method_25641(LegacyBlocks.GOLD_ORE_1_14);
        blockStateModelGenerator.method_25641(LegacyBlocks.SPONGE_C0_0_19A);
        blockStateModelGenerator.method_25641(LegacyBlocks.SPONGE_1_8);
        blockStateModelGenerator.method_25641(LegacyBlocks.WET_SPONGE_1_8);
        blockStateModelGenerator.method_25641(LegacyBlocks.GLASS_C0_0_19A);
        blockStateModelGenerator.method_25641(LegacyBlocks.WHITE_CLOTH);
        blockStateModelGenerator.method_25641(LegacyBlocks.LIGHT_GRAY_CLOTH_C0_0_20A);
        blockStateModelGenerator.method_25641(LegacyBlocks.LIGHT_GRAY_CLOTH_C0_28A);
        blockStateModelGenerator.method_25641(LegacyBlocks.DARK_GRAY_CLOTH_C0_0_20A);
        blockStateModelGenerator.method_25641(LegacyBlocks.DARK_GRAY_CLOTH_C0_28A);
        blockStateModelGenerator.method_25641(LegacyBlocks.RED_CLOTH);
        blockStateModelGenerator.method_25641(LegacyBlocks.ORANGE_CLOTH);
        blockStateModelGenerator.method_25641(LegacyBlocks.YELLOW_CLOTH);
        blockStateModelGenerator.method_25641(LegacyBlocks.CHARTREUSE_CLOTH);
        blockStateModelGenerator.method_25641(LegacyBlocks.SPRING_GREEN_CLOTH);
        blockStateModelGenerator.method_25641(LegacyBlocks.CYAN_CLOTH);
        blockStateModelGenerator.method_25641(LegacyBlocks.CAPRI_CLOTH);
        blockStateModelGenerator.method_25641(LegacyBlocks.ULTRAMARINE_CLOTH);
        blockStateModelGenerator.method_25641(LegacyBlocks.VIOLET_CLOTH);
        blockStateModelGenerator.method_25641(LegacyBlocks.PURPLE_CLOTH);
        blockStateModelGenerator.method_25641(LegacyBlocks.MAGENTA_CLOTH);
        blockStateModelGenerator.method_25641(LegacyBlocks.ROSE_CLOTH);
        blockStateModelGenerator.method_25641(LegacyBlocks.GOLD_BLOCK_C0_0_20A);
        blockStateModelGenerator.method_25641(LegacyBlocks.GOLD_BLOCK_A1_2_0);
        blockStateModelGenerator.method_25641(LegacyBlocks.GOLD_BLOCK_B1_9PRE5);
        blockStateModelGenerator.method_25545(LegacyBlocks.DANDELION_C0_0_20A, LegacyBlocks.POTTED_DANDELIONS_C0_0_20A, class_4913.field_22840);
        blockStateModelGenerator.method_25545(LegacyBlocks.ROSE_C0_0_20A, LegacyBlocks.POTTED_ROSE_C0_0_20A, class_4913.field_22840);
        blockStateModelGenerator.method_25545(LegacyBlocks.POPPY_1_7, LegacyBlocks.POTTED_POPPY_1_7, class_4913.field_22840);
        blockStateModelGenerator.method_25545(LegacyBlocks.BROWN_MUSHROOM_C0_0_20A, LegacyBlocks.POTTED_BROWN_MUSHROOM_C0_0_20A, class_4913.field_22840);
        blockStateModelGenerator.method_25545(LegacyBlocks.RED_MUSHROOM_C0_0_20A, LegacyBlocks.POTTED_RED_MUSHROOM_C0_0_20A, class_4913.field_22840);
        blockStateModelGenerator.method_25641(LegacyBlocks.IRON_BLOCK_A1_2_0);
        blockStateModelGenerator.method_25641(LegacyBlocks.IRON_BLOCK_B1_9PRE5);
        blockStateModelGenerator.method_25641(LegacyBlocks.MOSSY_COBBLESTONE_C0_26ST);
        blockStateModelGenerator.method_25641(LegacyBlocks.MOSSY_COBBLESTONE_B1_8);
        blockStateModelGenerator.method_25641(LegacyBlocks.BRICKS_C0_26ST);
        blockStateModelGenerator.method_25641(LegacyBlocks.BRICKS_A1_0_11);
        blockStateModelGenerator.method_25641(LegacyBlocks.OBSIDIAN_C0_28A);
        blockStateModelGenerator.method_25641(LegacyBlocks.DIAMOND_ORE_IN20100128);
        blockStateModelGenerator.method_25641(LegacyBlocks.DIAMOND_ORE_1_14);
        blockStateModelGenerator.method_25641(LegacyBlocks.DIAMOND_BLOCK_A1_2_0);
        blockStateModelGenerator.method_25641(LegacyBlocks.DIAMOND_BLOCK_B1_9PRE5);
        var legacy_rd20090515 = new class_5794.class_5795(LegacyBlocks.WOODEN_PLANKS_RD20090515)
                .method_33493(LegacyBlocks.WOODEN_STAIRS_RD20090515)
                .method_33490(LegacyBlocks.WOODEN_FENCE_RD20090515)
                .method_33484("wooden")
                .method_33487("has_planks")
                .method_33481();
        blockStateModelGenerator.method_25650(legacy_rd20090515.method_33469())
                .method_33522(legacy_rd20090515);
        var legacy_rd161348 = new class_5794.class_5795(LegacyBlocks.WOODEN_PLANKS_RD161348)
                .method_33493(LegacyBlocks.WOODEN_STAIRS_RD161348)
                .method_33490(LegacyBlocks.WOODEN_FENCE_RD161348)
                .method_33484("wooden")
                .method_33487("has_planks")
                .method_33481();
        blockStateModelGenerator.method_25650(legacy_rd161348.method_33469())
                .method_33522(legacy_rd161348);
        var legacy_c0_0_14a = new class_5794.class_5795(LegacyBlocks.WOODEN_PLANKS_C0_0_14A)
                .method_33493(LegacyBlocks.WOODEN_STAIRS_C0_0_14A)
                .method_33490(LegacyBlocks.WOODEN_FENCE_C0_0_14A)
                .method_33484("wooden")
                .method_33487("has_planks")
                .method_33481();
        blockStateModelGenerator.method_25650(legacy_c0_0_14a.method_33469())
                .method_33522(legacy_c0_0_14a);
        var legacy_c0_0_15a = new class_5794.class_5795(LegacyBlocks.WOODEN_PLANKS_C0_0_15A)
                .method_33493(LegacyBlocks.WOODEN_STAIRS_INF20100629)
                .method_33489(LegacyBlocks.WOODEN_DOOR_INF20100607)
                .method_33483(LegacyBlocks.SIGN_INF20100607, LegacyBlocks.WALL_SIGN_INF20100607)
                .method_33490(LegacyBlocks.WOODEN_FENCE_A1_0_17)
                .method_33484("wooden")
                .method_33487("has_planks").method_33481();
        blockStateModelGenerator.method_25650(legacy_c0_0_15a.method_33469())
                .method_33522(legacy_c0_0_15a);
        var legacy_b1_9pre5 = new class_5794.class_5795(LegacyBlocks.WOODEN_PLANKS_B1_9PRE5)
                .method_33493(LegacyBlocks.WOODEN_STAIRS_B1_9PRE5)
                .method_33490(LegacyBlocks.WOODEN_FENCE_B1_9PRE5)
                .method_33484("wooden")
                .method_33487("has_planks")
                .method_33481();
        blockStateModelGenerator.method_25650(legacy_b1_9pre5.method_33469())
                .method_33522(legacy_b1_9pre5);
        var cobblestone_rd20090515 = new class_5794.class_5795(LegacyBlocks.COBBLESTONE_RD20090515)
                .method_33493(LegacyBlocks.COBBLESTONE_STAIRS_RD20090515)
                .method_33484("cobblestone")
                .method_33487("has_cobblestone")
                .method_33481();
        blockStateModelGenerator.method_25650(cobblestone_rd20090515.method_33469())
                .method_33522(cobblestone_rd20090515);
        var cobblestone_c0_0_14a = new class_5794.class_5795(LegacyBlocks.COBBLESTONE_C_0_0_14A)
                .method_33493(LegacyBlocks.COBBLESTONE_STAIRS_C0_0_14A)
                .method_33484("cobblestone")
                .method_33487("has_cobblestone")
                .method_33481();
        blockStateModelGenerator.method_25650(cobblestone_c0_0_14a.method_33469())
                .method_33522(cobblestone_c0_0_14a);
        var cobblestone_b1_7 = new class_5794.class_5795(LegacyBlocks.COBBLESTONE_B1_7)
                .method_33493(LegacyBlocks.COBBLESTONE_STAIRS_B1_7)
                .method_33484("cobblestone").method_33487("has_cobblestone")
                .method_33481();
        blockStateModelGenerator.method_25650(cobblestone_b1_7.method_33469())
                .method_33522(cobblestone_b1_7);
        blockStateModelGenerator.method_25677(LegacyBlocks.TORCH_IN20100124_2, LegacyBlocks.WALL_TORCH_IN20100124_2);
        blockStateModelGenerator.method_25641(LegacyBlocks.REDSTONE_ORE_A1_0_1);
        blockStateModelGenerator.method_25641(LegacyBlocks.REDSTONE_ORE_1_14);
        blockStateModelGenerator.method_25677(LegacyBlocks.REDSTONE_TORCH_A1_0_1, LegacyBlocks.REDSTONE_WALL_TORCH_A1_0_1);
        blockStateModelGenerator.method_25641(LegacyBlocks.ICE_A1_0_4);
        blockStateModelGenerator.method_25641(LegacyBlocks.SNOW_BLOCK_A1_0_5);
        blockStateModelGenerator.method_25641(LegacyBlocks.CLAY_BLOCK_A1_0_11);
        blockStateModelGenerator.method_25641(LegacyBlocks.NETHERRACK_A1_2_0);
        blockStateModelGenerator.method_25641(LegacyBlocks.NETHERRACK_B1_9PRE5);
        blockStateModelGenerator.method_25641(LegacyBlocks.SOUL_SAND_A1_2_0);
        blockStateModelGenerator.method_25641(LegacyBlocks.GLOWSTONE_A1_2_0);
        blockStateModelGenerator.method_25641(LegacyBlocks.GLOWSTONE_B1_9PRE5);
    }

    @Override
    public void generateItemModels(class_4915 itemModelGenerator) {
        itemModelGenerator.method_25733(ItemInit.COCONUT, class_4943.field_22938);
        itemModelGenerator.method_25733(ItemInit.GOLDEN_COCONUT, class_4943.field_22938);
        itemModelGenerator.method_25732(ItemInit.ENCHANTED_GOLDEN_COCONUT, ItemInit.GOLDEN_COCONUT, class_4943.field_22938);
        itemModelGenerator.method_25732(ItemInit.ENCHANTED_GOLDEN_CARROT, class_1802.field_8071, class_4943.field_22938);
        itemModelGenerator.method_25733(ItemInit.GOLDEN_POTATO, class_4943.field_22938);
        itemModelGenerator.method_25732(ItemInit.ENCHANTED_GOLDEN_POTATO, ItemInit.GOLDEN_POTATO, class_4943.field_22938);
        itemModelGenerator.method_25733(ItemInit.GOLDEN_BAKED_POTATO, class_4943.field_22938);
        itemModelGenerator.method_25732(ItemInit.ENCHANTED_GOLDEN_BAKED_POTATO, ItemInit.GOLDEN_BAKED_POTATO, class_4943.field_22938);
        itemModelGenerator.method_25733(ItemInit.PALM_BOAT, class_4943.field_22938);
        itemModelGenerator.method_25733(ItemInit.PALM_CHEST_BOAT, class_4943.field_22938);
        itemModelGenerator.method_25733(ItemInit.GIANT_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        itemModelGenerator.method_25733(ItemInit.ILLUSIONER_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
    }

    public static final class_4942 TEMPLATE_SPAWN_EGG = item("template_spawn_egg");
    private static class_4942 item(String parent) {
        return new class_4942(Optional.of(class_2960.method_60654("item/" + parent)), Optional.empty());
    }
}
