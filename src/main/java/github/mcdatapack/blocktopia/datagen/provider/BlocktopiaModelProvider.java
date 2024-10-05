package github.mcdatapack.blocktopia.datagen.provider;

import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import java.util.Optional;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateModelGenerator.TintType;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class BlocktopiaModelProvider extends FabricModelProvider {

    public BlocktopiaModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.PAPER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.GUNPOWDER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.PALM_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(BlockInit.PALM_SAPLING, BlockInit.POTTED_PALM_SAPLING, TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(BlockInit.PALM_LOG)
                .log(BlockInit.PALM_LOG).wood(BlockInit.PALM_WOOD);
        blockStateModelGenerator.registerLog(BlockInit.STRIPPED_PALM_LOG)
                .log(BlockInit.STRIPPED_PALM_LOG).wood(BlockInit.STRIPPED_PALM_WOOD);
        var palmFamaly = new BlockFamily.Builder(BlockInit.PALM_PLANKS)
                .button(BlockInit.PALM_BUTTON)
                .fence(BlockInit.PALM_FENCE)
                .fenceGate(BlockInit.PALM_FENCE_GATE)
                .pressurePlate(BlockInit.PALM_PRESSURE_PLATE)
                .sign(BlockInit.PALM_SIGN, BlockInit.PALM_WALL_SIGN)
                .slab(BlockInit.PALM_SLAB)
                .stairs(BlockInit.PALM_STAIRS)
                .door(BlockInit.PALM_DOOR)
                .trapdoor(BlockInit.PALM_TRAPDOOR)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(palmFamaly.getBaseBlock())
                .family(palmFamaly);
        blockStateModelGenerator.registerHangingSign(BlockInit.STRIPPED_PALM_LOG, BlockInit.PALM_HANGING_SIGN, BlockInit.PALM_WALL_HANGING_SIGN);



        blockStateModelGenerator.registerLog(LegacyBlocks.LOG_C0_0_14A)
                .log(LegacyBlocks.LOG_C0_0_14A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.LEAVES_C0_0_14A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.LEAVES_C0_0_15A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.LEAVES_C0_24ST);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.SAPLING_RD161348, LegacyBlocks.POTTED_SAPLING_RD161348, TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.SAPLING_C0_0_13A, LegacyBlocks.POTTED_SAPLING_C0_0_13A, TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.SAPLING_C0_24ST, LegacyBlocks.POTTED_SAPLING_C0_24ST, TintType.NOT_TINTED);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.BEDROCK_C0_0_12A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.SAND_C0_0_14A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.SAND_C0_0_15A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.SAND_B1_9PRE6);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GRAVEL_C0_0_14A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GRAVEL_C0_0_15A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GRAVEL_B1_9PRE5);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GRAVEL_1_3);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.COAL_ORE_C0_0_14A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.COAL_ORE_1_14);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.IRON_ORE_C0_0_14A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.IRON_ORE_1_14);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.IRON_ORE_1_14_1);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GOLD_ORE_C0_0_14A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GOLD_ORE_C0_26ST);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GOLD_ORE_1_14);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.SPONGE_C0_0_19A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.SPONGE_1_8);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.WET_SPONGE_1_8);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GLASS_C0_0_19A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.WHITE_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.LIGHT_GRAY_CLOTH_C0_0_20A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.LIGHT_GRAY_CLOTH_C0_28A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.DARK_GRAY_CLOTH_C0_0_20A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.DARK_GRAY_CLOTH_C0_28A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.RED_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.ORANGE_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.YELLOW_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.CHARTREUSE_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.SPRING_GREEN_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.CYAN_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.CAPRI_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.ULTRAMARINE_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.VIOLET_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.PURPLE_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.MAGENTA_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.ROSE_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GOLD_BLOCK_C0_0_20A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GOLD_BLOCK_A1_2_0);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GOLD_BLOCK_B1_9PRE5);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.DANDELION_C0_0_20A, LegacyBlocks.POTTED_DANDELIONS_C0_0_20A, TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.ROSE_C0_0_20A, LegacyBlocks.POTTED_ROSE_C0_0_20A, TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.POPPY_1_7, LegacyBlocks.POTTED_POPPY_1_7, TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.BROWN_MUSHROOM_C0_0_20A, LegacyBlocks.POTTED_BROWN_MUSHROOM_C0_0_20A, TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.RED_MUSHROOM_C0_0_20A, LegacyBlocks.POTTED_RED_MUSHROOM_C0_0_20A, TintType.NOT_TINTED);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.IRON_BLOCK_A1_2_0);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.IRON_BLOCK_B1_9PRE5);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.MOSSY_COBBLESTONE_C0_26ST);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.MOSSY_COBBLESTONE_B1_8);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.BRICKS_C0_26ST);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.BRICKS_A1_0_11);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.OBSIDIAN_C0_28A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.DIAMOND_ORE_IN20100128);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.DIAMOND_ORE_1_14);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.DIAMOND_BLOCK_A1_2_0);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.DIAMOND_BLOCK_B1_9PRE5);
        var legacy_rd20090515 = new BlockFamily.Builder(LegacyBlocks.WOODEN_PLANKS_RD20090515)
                .stairs(LegacyBlocks.WOODEN_STAIRS_RD20090515)
                .fence(LegacyBlocks.WOODEN_FENCE_RD20090515)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(legacy_rd20090515.getBaseBlock())
                .family(legacy_rd20090515);
        var legacy_rd161348 = new BlockFamily.Builder(LegacyBlocks.WOODEN_PLANKS_RD161348)
                .stairs(LegacyBlocks.WOODEN_STAIRS_RD161348)
                .fence(LegacyBlocks.WOODEN_FENCE_RD161348)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(legacy_rd161348.getBaseBlock())
                .family(legacy_rd161348);
        var legacy_c0_0_14a = new BlockFamily.Builder(LegacyBlocks.WOODEN_PLANKS_C0_0_14A)
                .stairs(LegacyBlocks.WOODEN_STAIRS_C0_0_14A)
                .fence(LegacyBlocks.WOODEN_FENCE_C0_0_14A)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(legacy_c0_0_14a.getBaseBlock())
                .family(legacy_c0_0_14a);
        var legacy_c0_0_15a = new BlockFamily.Builder(LegacyBlocks.WOODEN_PLANKS_C0_0_15A)
                .stairs(LegacyBlocks.WOODEN_STAIRS_INF20100629)
                .door(LegacyBlocks.WOODEN_DOOR_INF20100607)
                .sign(LegacyBlocks.SIGN_INF20100607, LegacyBlocks.WALL_SIGN_INF20100607)
                .fence(LegacyBlocks.WOODEN_FENCE_A1_0_17)
                .group("wooden")
                .unlockCriterionName("has_planks").build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(legacy_c0_0_15a.getBaseBlock())
                .family(legacy_c0_0_15a);
        var legacy_b1_9pre5 = new BlockFamily.Builder(LegacyBlocks.WOODEN_PLANKS_B1_9PRE5)
                .stairs(LegacyBlocks.WOODEN_STAIRS_B1_9PRE5)
                .fence(LegacyBlocks.WOODEN_FENCE_B1_9PRE5)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(legacy_b1_9pre5.getBaseBlock())
                .family(legacy_b1_9pre5);
        var cobblestone_rd20090515 = new BlockFamily.Builder(LegacyBlocks.COBBLESTONE_RD20090515)
                .stairs(LegacyBlocks.COBBLESTONE_STAIRS_RD20090515)
                .group("cobblestone")
                .unlockCriterionName("has_cobblestone")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(cobblestone_rd20090515.getBaseBlock())
                .family(cobblestone_rd20090515);
        var cobblestone_c0_0_14a = new BlockFamily.Builder(LegacyBlocks.COBBLESTONE_C_0_0_14A)
                .stairs(LegacyBlocks.COBBLESTONE_STAIRS_C0_0_14A)
                .group("cobblestone")
                .unlockCriterionName("has_cobblestone")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(cobblestone_c0_0_14a.getBaseBlock())
                .family(cobblestone_c0_0_14a);
        var cobblestone_b1_7 = new BlockFamily.Builder(LegacyBlocks.COBBLESTONE_B1_7)
                .stairs(LegacyBlocks.COBBLESTONE_STAIRS_B1_7)
                .group("cobblestone").unlockCriterionName("has_cobblestone")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(cobblestone_b1_7.getBaseBlock())
                .family(cobblestone_b1_7);
        blockStateModelGenerator.registerTorch(LegacyBlocks.TORCH_IN20100124_2, LegacyBlocks.WALL_TORCH_IN20100124_2);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.REDSTONE_ORE_A1_0_1);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.REDSTONE_ORE_1_14);
        blockStateModelGenerator.registerTorch(LegacyBlocks.REDSTONE_TORCH_A1_0_1, LegacyBlocks.REDSTONE_WALL_TORCH_A1_0_1);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.ICE_A1_0_4);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.SNOW_BLOCK_A1_0_5);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.CLAY_BLOCK_A1_0_11);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.NETHERRACK_A1_2_0);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.NETHERRACK_B1_9PRE5);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.SOUL_SAND_A1_2_0);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GLOWSTONE_A1_2_0);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GLOWSTONE_B1_9PRE5);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ItemInit.COCONUT, Models.GENERATED);
        itemModelGenerator.register(ItemInit.GOLDEN_COCONUT, Models.GENERATED);
        itemModelGenerator.register(ItemInit.ENCHANTED_GOLDEN_COCONUT, ItemInit.GOLDEN_COCONUT, Models.GENERATED);
        itemModelGenerator.register(ItemInit.ENCHANTED_GOLDEN_CARROT, Items.GOLDEN_CARROT, Models.GENERATED);
        itemModelGenerator.register(ItemInit.GOLDEN_POTATO, Models.GENERATED);
        itemModelGenerator.register(ItemInit.ENCHANTED_GOLDEN_POTATO, ItemInit.GOLDEN_POTATO, Models.GENERATED);
        itemModelGenerator.register(ItemInit.GOLDEN_BAKED_POTATO, Models.GENERATED);
        itemModelGenerator.register(ItemInit.ENCHANTED_GOLDEN_BAKED_POTATO, ItemInit.GOLDEN_BAKED_POTATO, Models.GENERATED);
        itemModelGenerator.register(ItemInit.PALM_BOAT, Models.GENERATED);
        itemModelGenerator.register(ItemInit.PALM_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ItemInit.GIANT_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        itemModelGenerator.register(ItemInit.ILLUSIONER_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
    }

    public static final Model TEMPLATE_SPAWN_EGG = item("template_spawn_egg");
    private static Model item(String parent) {
        return new Model(Optional.of(Identifier.of("item/" + parent)), Optional.empty());
    }
}
