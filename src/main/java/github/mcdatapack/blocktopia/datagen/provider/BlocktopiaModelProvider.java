package github.mcdatapack.blocktopia.datagen.provider;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.FutureBlocks;
import github.mcdatapack.blocktopia.block.ModBlockFamilies;
import github.mcdatapack.blocktopia.block.custom.BananaCropBlock;
import github.mcdatapack.blocktopia.block.custom.ChairBlock;
import github.mcdatapack.blocktopia.block.custom.HangingMossBlock;
import github.mcdatapack.blocktopia.block.custom.VerticalSlabBlock;
import github.mcdatapack.blocktopia.fluid.ModFluids;
import github.mcdatapack.blocktopia.item.ModItems;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.block.LegacyBlocks;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import github.mcdatapack.blocktopia.api.BlockStateModelAccessor;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.impl.content.registry.util.ImmutableCollectionUtils;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.block.BlockModels;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import static github.mcdatapack.blocktopia.block.FutureBlocks.*;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.*;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.PINK_WOOL_1_2_4;
import static github.mcdatapack.blocktopia.item.FutureItems.*;
import static github.mcdatapack.blocktopia.item.LegacyItems.*;

public class BlocktopiaModelProvider extends FabricModelProvider {
    public BlocktopiaModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Map<Block, TexturedModel> map = ImmutableCollectionUtils.getAsMutableMap(((BlockStateModelAccessor)blockStateModelGenerator)::blocktopia$getTextureModels,
                ((BlockStateModelAccessor)blockStateModelGenerator)::blocktopia$setTextureModels);
        map.put(SANDSTONE_B1_2, TexturedModel.SIDE_TOP_BOTTOM_WALL.get(SANDSTONE_B1_2));
        map.put(SANDSTONE_1_2_4, TexturedModel.SIDE_TOP_BOTTOM_WALL.get(SANDSTONE_1_2_4));
        map.put(RED_SANDSTONE_1_8, TexturedModel.SIDE_TOP_BOTTOM_WALL.get(RED_SANDSTONE_1_8));
        map.put(QUARTZ_BLOCK_1_5, TexturedModel.CUBE_COLUMN.get(QUARTZ_BLOCK_1_5));
        map.put(
                CHISELED_QUARTZ_BLOCK_1_5,
                TexturedModel.CUBE_COLUMN
                        .get(CHISELED_QUARTZ_BLOCK_1_5)
                        .textures(textureMap -> textureMap.put(TextureKey.SIDE, TextureMap.getId(CHISELED_QUARTZ_BLOCK_1_5))
                                .put(TextureKey.BOTTOM, TextureMap.getSubId(CHISELED_QUARTZ_BLOCK_1_5, "_bottom")))
        );
        map.put(
                CHISELED_SANDSTONE_1_2_4,
                TexturedModel.CUBE_COLUMN
                        .get(SANDSTONE_1_2_4)
                        .textures(textureMap -> textureMap.put(TextureKey.SIDE, TextureMap.getId(CHISELED_SANDSTONE_1_2_4)))
        );
        map.put(
                CHISELED_RED_SANDSTONE_1_8,
                TexturedModel.CUBE_COLUMN
                        .get(RED_SANDSTONE_1_8)
                        .textures(textureMap -> textureMap.put(TextureKey.SIDE, TextureMap.getId(CHISELED_RED_SANDSTONE_1_8)))
        );

        registerAnvil(blockStateModelGenerator, ModBlocks.GOLD_ANVIL);
        registerAnvil(blockStateModelGenerator, ModBlocks.CHIPPED_GOLD_ANVIL);
        registerAnvil(blockStateModelGenerator, ModBlocks.DAMAGED_GOLD_ANVIL);
        registerAnvil(blockStateModelGenerator, ModBlocks.DIAMOND_ANVIL);
        registerAnvil(blockStateModelGenerator, ModBlocks.CHIPPED_DIAMOND_ANVIL);
        registerAnvil(blockStateModelGenerator, ModBlocks.DAMAGED_DIAMOND_ANVIL);
        registerAnvil(blockStateModelGenerator, ModBlocks.NETHERITE_ANVIL);
        registerAnvil(blockStateModelGenerator, ModBlocks.CHIPPED_NETHERITE_ANVIL);
        registerAnvil(blockStateModelGenerator, ModBlocks.DAMAGED_NETHERITE_ANVIL);

        blockStateModelGenerator.registerParentedItemModel(ModBlocks.FLUID_TANK, Blocktopia.id("block/fluid_tank"));

        blockStateModelGenerator.registerCrop(ModBlocks.BANANA_CROP, BananaCropBlock.AGE, 0, 1, 2, 3, 4, 5);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPONGE_TNT);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PAPER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GUNPOWDER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FIREWORK_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PALM_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.PALM_SAPLING, ModBlocks.POTTED_PALM_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(ModBlocks.PALM_LOG)
                .log(ModBlocks.PALM_LOG).wood(ModBlocks.PALM_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_PALM_LOG)
                .log(ModBlocks.STRIPPED_PALM_LOG).wood(ModBlocks.STRIPPED_PALM_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.PALM.getBaseBlock())
                .family(ModBlockFamilies.PALM);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_PALM_LOG, ModBlocks.PALM_HANGING_SIGN, ModBlocks.PALM_WALL_HANGING_SIGN);


        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BANANA_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BANANA_SAPLING, ModBlocks.POTTED_BANANA_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(ModBlocks.BANANA_LOG)
                .log(ModBlocks.BANANA_LOG).wood(ModBlocks.BANANA_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_BANANA_LOG)
                .log(ModBlocks.STRIPPED_BANANA_LOG).wood(ModBlocks.STRIPPED_BANANA_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.BANANA.getBaseBlock())
                .family(ModBlockFamilies.BANANA);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_BANANA_LOG, ModBlocks.BANANA_HANGING_SIGN, ModBlocks.BANANA_WALL_HANGING_SIGN);



        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CORN_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CORN_SAPLING, ModBlocks.POTTED_CORN_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(ModBlocks.CORN_LOG)
                .log(ModBlocks.CORN_LOG).wood(ModBlocks.CORN_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_CORN_LOG)
                .log(ModBlocks.STRIPPED_CORN_LOG).wood(ModBlocks.STRIPPED_CORN_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.CORN.getBaseBlock())
                .family(ModBlockFamilies.CORN);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_CORN_LOG, ModBlocks.CORN_HANGING_SIGN, ModBlocks.CORN_WALL_HANGING_SIGN);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POISONED_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.POISONED_SAPLING, ModBlocks.POTTED_POISONED_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(ModBlocks.POISONED_LOG)
                .log(ModBlocks.POISONED_LOG).wood(ModBlocks.POISONED_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_POISONED_LOG)
                .log(ModBlocks.STRIPPED_POISONED_LOG).wood(ModBlocks.STRIPPED_POISONED_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.POISONED.getBaseBlock())
                .family(ModBlockFamilies.POISONED);
        //blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_POISONED_LOG, ModBlocks.POISONED_HANGING_SIGN, ModBlocks.POISONED_WALL_HANGING_SIGN);


        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAHOGANY_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.MAHOGANY_SAPLING, ModBlocks.POTTED_MAHOGANY_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(ModBlocks.MAHOGANY_LOG)
                .log(ModBlocks.MAHOGANY_LOG).wood(ModBlocks.MAHOGANY_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MAHOGANY_LOG)
                .log(ModBlocks.STRIPPED_MAHOGANY_LOG).wood(ModBlocks.STRIPPED_MAHOGANY_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.MAHOGANY.getBaseBlock())
                .family(ModBlockFamilies.MAHOGANY);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_MAHOGANY_LOG, ModBlocks.MAHOGANY_HANGING_SIGN, ModBlocks.MAHOGANY_WALL_HANGING_SIGN);


        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOWERING_CHERRY_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.FLOWERING_CHERRY_SAPLING, ModBlocks.POTTED_FLOWERING_CHERRY_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_FLOWER, ModBlocks.POTTED_GLOW_FLOWER, BlockStateModelGenerator.TintType.NOT_TINTED);



        blockStateModelGenerator.registerLog(LegacyBlocks.LOG_C0_0_14A)
                .log(LOG_C0_0_14A)
                .wood(OAK_WOOD_1_3);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.LEAVES_C0_0_14A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.LEAVES_C0_0_15A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.LEAVES_C0_24ST);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.SAPLING_RD161348, LegacyBlocks.POTTED_SAPLING_RD161348, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.SAPLING_C0_0_13A, LegacyBlocks.POTTED_SAPLING_C0_0_13A, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.SAPLING_C0_24ST, LegacyBlocks.POTTED_SAPLING_C0_24ST, BlockStateModelGenerator.TintType.NOT_TINTED);
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
        blockStateModelGenerator.registerGlassPane(LegacyBlocks.GLASS_C0_0_19A, LegacyBlocks.GLASS_PANE_B1_8);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.WHITE_CLOTH, WHITE_CLOTH_CARPET);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.LIGHT_GRAY_CLOTH_C0_0_20A,LegacyBlocks.LIGHT_GRAY_CLOTH_CARPET_C0_0_20A);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.LIGHT_GRAY_CLOTH_C0_28A,LegacyBlocks.LIGHT_GRAY_CLOTH_CARPET_C0_28A);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.DARK_GRAY_CLOTH_C0_0_20A,LegacyBlocks.DARK_GRAY_CLOTH_CARPET_C0_0_20A);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.DARK_GRAY_CLOTH_C0_28A,LegacyBlocks.DARK_GRAY_CLOTH_CARPET_C0_28A);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.RED_CLOTH,LegacyBlocks.RED_CLOTH_CARPET);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.ORANGE_CLOTH,LegacyBlocks.ORANGE_CLOTH_CARPET);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.YELLOW_CLOTH,LegacyBlocks.YELLOW_CLOTH_CARPET);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.CHARTREUSE_CLOTH,LegacyBlocks.CHARTREUSE_CLOTH_CARPET);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.SPRING_GREEN_CLOTH,LegacyBlocks.SPRING_GREEN_CLOTH_CARPET);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.CYAN_CLOTH,LegacyBlocks.CYAN_CLOTH_CARPET);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.CAPRI_CLOTH,LegacyBlocks.CAPRI_CLOTH_CARPET);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.ULTRAMARINE_CLOTH,LegacyBlocks.ULTRAMARINE_CLOTH_CARPET);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.VIOLET_CLOTH,LegacyBlocks.VIOLET_CLOTH_CARPET);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.PURPLE_CLOTH,LegacyBlocks.PURPLE_CLOTH_CARPET);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.MAGENTA_CLOTH,LegacyBlocks.MAGENTA_CLOTH_CARPET);
        blockStateModelGenerator.registerWoolAndCarpet(LegacyBlocks.ROSE_CLOTH,LegacyBlocks.ROSE_CLOTH_CARPET);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GOLD_BLOCK_C0_0_20A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GOLD_BLOCK_A1_2_0);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GOLD_BLOCK_B1_9PRE5);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.DANDELION_C0_0_20A, LegacyBlocks.POTTED_DANDELIONS_C0_0_20A, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.ROSE_C0_0_20A, LegacyBlocks.POTTED_ROSE_C0_0_20A, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.POPPY_1_7, LegacyBlocks.POTTED_POPPY_1_7, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.BROWN_MUSHROOM_C0_0_20A, LegacyBlocks.POTTED_BROWN_MUSHROOM_C0_0_20A, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.RED_MUSHROOM_C0_0_20A, LegacyBlocks.POTTED_RED_MUSHROOM_C0_0_20A, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.IRON_BLOCK_A1_2_0);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.IRON_BLOCK_B1_9PRE5);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.MOSSY_COBBLESTONE_C0_26ST);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.MOSSY_COBBLESTONE_B1_8);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.OBSIDIAN_C0_28A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.DIAMOND_ORE_IN20100128);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.DIAMOND_ORE_1_14);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.DIAMOND_BLOCK_A1_2_0);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.DIAMOND_BLOCK_B1_9PRE5);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.WOODEN_RD20080515.getBaseBlock())
                .family(ModBlockFamilies.WOODEN_RD20080515);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.WOODEN_RD161348.getBaseBlock())
                .family(ModBlockFamilies.WOODEN_RD161348);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.WOODEN_C0_0_14A.getBaseBlock())
                .family(ModBlockFamilies.WOODEN_C0_0_14A);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.WOODEN_C0_0_15A.getBaseBlock())
                .family(ModBlockFamilies.WOODEN_C0_0_15A);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.WOODEN_B1_9PRE5.getBaseBlock())
                .family(ModBlockFamilies.WOODEN_B1_9PRE5);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.COBBLESTONE_RD20090515.getBaseBlock())
                .family(ModBlockFamilies.COBBLESTONE_RD20090515);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.COBBLESTONE_C0_0_14A.getBaseBlock())
                .family(ModBlockFamilies.COBBLESTONE_C0_0_14A);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.COBBLESTONE_B1_7.getBaseBlock())
                .family(ModBlockFamilies.COBBLESTONE_B1_7);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.BRICKS_C0_26ST.getBaseBlock())
                .family(ModBlockFamilies.BRICKS_C0_26ST);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.BRICKS_A1_0_11.getBaseBlock())
                .family(ModBlockFamilies.BRICKS_A1_0_11);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.STONE_BRICKS_B1_8.getBaseBlock())
                .family(ModBlockFamilies.STONE_BRICKS_B1_8);
        blockStateModelGenerator.registerTurnableRail(RAIL_INF20100618);
        blockStateModelGenerator.registerStraightRail(POWERED_RAIL_B1_5);
        blockStateModelGenerator.registerStraightRail(DETECTOR_RAIL_B1_5);
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
        blockStateModelGenerator.registerWoolAndCarpet(LIGHT_GRAY_WOOL_B1_2, LIGHT_GRAY_CARPET_B1_2);
        blockStateModelGenerator.registerWoolAndCarpet(GRAY_WOOL_B1_2, GRAY_CARPET_B1_2);
        blockStateModelGenerator.registerWoolAndCarpet(BLACK_WOOL_B1_2, BLACK_CARPET_B1_2);
        blockStateModelGenerator.registerWoolAndCarpet(BROWN_WOOL_B1_2, BROWN_CARPET_B1_2);
        blockStateModelGenerator.registerWoolAndCarpet(RED_WOOL_B1_2, RED_CARPET_B1_2);
        blockStateModelGenerator.registerWoolAndCarpet(ORANGE_WOOL_B1_2, ORANGE_CARPET_B1_2);
        blockStateModelGenerator.registerWoolAndCarpet(YELLOW_WOOL_B1_2, YELLOW_CARPET_B1_2);
        blockStateModelGenerator.registerWoolAndCarpet(LIME_WOOL_B1_2, LIME_CARPET_B1_2);
        blockStateModelGenerator.registerWoolAndCarpet(GREEN_WOOL_B1_2, GREEN_CARPET_B1_2);
        blockStateModelGenerator.registerWoolAndCarpet(CYAN_WOOL_B1_2, CYAN_CARPET_B1_2);
        blockStateModelGenerator.registerWoolAndCarpet(LIGHT_BLUE_WOOL_B1_2, LIGHT_BLUE_CARPET_B1_2);
        blockStateModelGenerator.registerWoolAndCarpet(BLUE_WOOL_B1_2, BLUE_CARPET_B1_2);
        blockStateModelGenerator.registerWoolAndCarpet(PURPLE_WOOL_B1_2, PURPLE_CARPET_B1_2);
        blockStateModelGenerator.registerWoolAndCarpet(MAGENTA_WOOL_B1_2, MAGENTA_CARPET_B1_2);
        blockStateModelGenerator.registerWoolAndCarpet(PINK_WOOL_B1_2, PINK_CARPET_B1_2);
        blockStateModelGenerator.registerWoolAndCarpet(LIGHT_GRAY_WOOL_1_2_4, LIGHT_GRAY_CARPET_1_2_4);
        blockStateModelGenerator.registerWoolAndCarpet(GRAY_WOOL_1_2_4, GRAY_CARPET_1_2_4);
        blockStateModelGenerator.registerWoolAndCarpet(BLACK_WOOL_1_2_4, BLACK_CARPET_1_2_4);
        blockStateModelGenerator.registerWoolAndCarpet(BROWN_WOOL_1_2_4, BROWN_CARPET_1_2_4);
        blockStateModelGenerator.registerWoolAndCarpet(RED_WOOL_1_2_4, RED_CARPET_1_2_4);
        blockStateModelGenerator.registerWoolAndCarpet(ORANGE_WOOL_1_2_4, ORANGE_CARPET_1_2_4);
        blockStateModelGenerator.registerWoolAndCarpet(YELLOW_WOOL_1_2_4, YELLOW_CARPET_1_2_4);
        blockStateModelGenerator.registerWoolAndCarpet(LIME_WOOL_1_2_4, LIME_CARPET_1_2_4);
        blockStateModelGenerator.registerWoolAndCarpet(GREEN_WOOL_1_2_4, GREEN_CARPET_1_2_4);
        blockStateModelGenerator.registerWoolAndCarpet(CYAN_WOOL_1_2_4, CYAN_CARPET_1_2_4);
        blockStateModelGenerator.registerWoolAndCarpet(LIGHT_BLUE_WOOL_1_2_4, LIGHT_BLUE_CARPET_1_2_4);
        blockStateModelGenerator.registerWoolAndCarpet(BLUE_WOOL_1_2_4, BLUE_CARPET_1_2_4);
        blockStateModelGenerator.registerWoolAndCarpet(PURPLE_WOOL_1_2_4, PURPLE_CARPET_1_2_4);
        blockStateModelGenerator.registerWoolAndCarpet(MAGENTA_WOOL_1_2_4, MAGENTA_CARPET_1_2_4);
        blockStateModelGenerator.registerWoolAndCarpet(PINK_WOOL_1_2_4, PINK_CARPET_1_2_4);
        registerCake(blockStateModelGenerator, CAKE_B1_2);
        blockStateModelGenerator.registerSimpleCubeAll(LAPIS_ORE_B1_2);
        blockStateModelGenerator.registerSimpleCubeAll(LAPIS_ORE_1_14);
        blockStateModelGenerator.registerSimpleCubeAll(LAPIS_BLOCK_B1_2);
        blockStateModelGenerator.registerSimpleCubeAll(LAPIS_BLOCK_1_6);
        blockStateModelGenerator.registerSimpleCubeAll(NOTE_BLOCK_B1_2);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.SANDSTONE_B1_2.getBaseBlock())
                .family(ModBlockFamilies.SANDSTONE_B1_2);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.SANDSTONE_1_2_4.getBaseBlock())
                .family(ModBlockFamilies.SANDSTONE_1_2_4);
        blockStateModelGenerator.registerLog(SPRUCE_LOG_B1_2)
                 .log(SPRUCE_LOG_B1_2)
                .wood(SPRUCE_WOOD_1_3);
        blockStateModelGenerator.registerLog(SPRUCE_LOG_1_7)
                .log(SPRUCE_LOG_1_7);
        blockStateModelGenerator.registerLog(BIRCH_LOG_B1_2)
                .log(BIRCH_LOG_B1_2)
                .wood(BIRCH_WOOD_1_3);
        blockStateModelGenerator.registerLog(BIRCH_LOG_1_7)
                .log(BIRCH_LOG_1_7);
        blockStateModelGenerator.registerSingleton(BIRCH_LEAVES_B1_2, TexturedModel.LEAVES);
        blockStateModelGenerator.registerSingleton(SPRUCE_LEAVES_B1_2, TexturedModel.LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(CRYING_OBSIDIAN_B1_3);
        blockStateModelGenerator.registerSimpleCubeAll(SMOOTH_STONE_B1_3);
        blockStateModelGenerator.registerFlowerPotPlant(SPRUCE_SAPLING_B1_5, POTTED_SPRUCE_SAPLING_B1_5, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(BIRCH_SAPLING_B1_5, POTTED_BIRCH_SAPLING_B1_5, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCross(COBWEB_B1_5, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(SHRUB_B1_6, POTTED_SHRUB_B1_6, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(DEAD_BUSH_B1_6, POTTED_DEAD_BUSH_B1_6, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(SHORT_GRASS_B1_6, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(FERN_B1_6, POTTED_FERN_B1_6, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerParented(COBBLESTONE_RD20090515, INFESTED_COBBLESTONE_RD20090515);
        blockStateModelGenerator.registerParented(COBBLESTONE_C0_0_14A, INFESTED_COBBLESTONE_C0_0_14A);
        blockStateModelGenerator.registerParented(COBBLESTONE_B1_7, INFESTED_COBBLESTONE_B1_8);
        blockStateModelGenerator.registerParented(STONE_BRICKS_B1_8, INFESTED_STONE_BRICKS_B1_8);
        blockStateModelGenerator.registerSimpleCubeAll(MOSSY_STONE_BRICKS_B1_8);
        blockStateModelGenerator.registerWallPlant(VINES_B1_8);
        Identifier insideTexture = Blocktopia.id("block/mushroom_block_inside_b1_8");
        registerMushroomBlock(blockStateModelGenerator, insideTexture, MUSHROOM_STEM_B1_8);
        registerMushroomBlock(blockStateModelGenerator, insideTexture, RED_MUSHROOM_BLOCK_B1_8);
        registerMushroomBlock(blockStateModelGenerator, insideTexture, BROWN_MUSHROOM_BLOCK_B1_8);
        blockStateModelGenerator.registerSingleton(MELON_BLOCK_B1_8, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.NETHER_BRICKS_B1_9PRE.getBaseBlock())
                        .family(ModBlockFamilies.NETHER_BRICKS_B1_9PRE);
        registerLilyPad(blockStateModelGenerator, LILY_PAD_B1_9PRE);
        blockStateModelGenerator.registerSimpleCubeAll(ENDSTONE_B1_9PRE4);
        blockStateModelGenerator.registerLog(JUNGLE_LOG_1_2)
                .log(JUNGLE_LOG_1_2)
                .wood(JUNGLE_WOOD_1_3);
        blockStateModelGenerator.registerLog(JUNGLE_LOG_1_7)
                .log(JUNGLE_LOG_1_7);
        blockStateModelGenerator.registerSingleton(JUNGLE_LEAVES_1_2, TexturedModel.LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(JUNGLE_SAPLING_1_2, POTTED_JUNGLE_SAPLING_1_2, BlockStateModelGenerator.TintType.NOT_TINTED);
        Identifier identifier = TexturedModel.CUBE_ALL.upload(REDSTONE_LAMP_1_2, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(REDSTONE_LAMP_1_2, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector
                .accept(VariantsBlockStateSupplier.create(REDSTONE_LAMP_1_2)
                        .coordinate(BlockStateModelGenerator.createBooleanModelMap(Properties.LIT, identifier2, identifier)));
        blockStateModelGenerator.registerSimpleCubeAll(CHISELED_STONE_BRICKS_1_2);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.BIRCH_1_2_4.getBaseBlock())
                        .family(ModBlockFamilies.BIRCH_1_2_4);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.SPRUCE_1_2_4.getBaseBlock())
                        .family(ModBlockFamilies.SPRUCE_1_2_4);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.JUNGLE_1_2_4.getBaseBlock())
                        .family(ModBlockFamilies.JUNGLE_1_2_4);
        TextureMap Textures = new TextureMap()
                .put(TextureKey.TOP, Blocktopia.id("block/sandstone_1_2_4_top"))
                .put(TextureKey.SIDE, Blocktopia.id("block/cut_sandstone_1_2_4"))
                .put(TextureKey.BOTTOM, Blocktopia.id("block/sandstone_1_2_4_bottom"));
        blockStateModelGenerator.registerSingleton(CUT_SANDSTONE_1_2_4, TexturedModel.makeFactory(block -> Textures, Models.CUBE_BOTTOM_TOP));
        registerCocoaBeans(blockStateModelGenerator, COCOA_1_3);
        blockStateModelGenerator.registerSimpleCubeAll(RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(EMERALD_ORE_1_3);
        blockStateModelGenerator.registerSimpleCubeAll(EMERALD_ORE_1_14);
        blockStateModelGenerator.registerSimpleCubeAll(EMERALD_BLOCK_1_3);
        blockStateModelGenerator.registerSimpleCubeAll(QUARTZ_ORE_1_5);
        blockStateModelGenerator.registerSimpleCubeAll(REDSTONE_BLOCK_1_5);
        blockStateModelGenerator.registerStraightRail(ACTIVATOR_RAIL_1_5);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.QUARTZ_1_5.getBaseBlock())
                .family(ModBlockFamilies.QUARTZ_1_5);
        blockStateModelGenerator.registerAxisRotated(QUARTZ_PILLAR_1_5, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerSingleton(SMOOTH_SANDSTONE_1_5, TexturedModel.makeFactory(block -> new TextureMap()
                .put(TextureKey.TOP, TextureMap.getSubId(SANDSTONE_1_2_4, "_top"))
                .put(TextureKey.SIDE, TextureMap.getId(SMOOTH_SANDSTONE_1_5))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(SANDSTONE_1_2_4, "_bottom")), Models.CUBE_BOTTOM_TOP));
        blockStateModelGenerator.registerSimpleCubeAll(SMOOTH_QUARTZ_1_5);
        blockStateModelGenerator.registerAxisRotated(HAY_BALE_1_6, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerSimpleCubeAll(TERRACOTTA_1_6);
        blockStateModelGenerator.registerSimpleCubeAll(COAL_BLOCK_1_6);
        blockStateModelGenerator.registerFlowerPotPlant(ALLIUM_1_7, POTTED_ALLIUM_1_7, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(AZURE_BLUET_1_7, POTTED_AZURE_BLUET_1_7, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(BLUE_ORCHID_1_7, POTTED_BLUE_ORCHID_1_7, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(LILAC_1_7, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(PEONY_1_7, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ROSE_BUSH_1_7, BlockStateModelGenerator.TintType.NOT_TINTED);
        registerSunflower(blockStateModelGenerator, SUNFLOWER_1_7);
        blockStateModelGenerator.registerFlowerPotPlant(OXEYE_DAISY_1_7, POTTED_OXEYE_DAISY_1_7, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(RED_TULIP_1_7, POTTED_RED_TULIP_1_7, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ORANGE_TULIP_1_7, POTTED_ORANGE_TULIP_1_7, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(WHITE_TULIP_1_7, POTTED_WHITE_TULIP_1_7, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(PINK_TULIP_1_7, POTTED_PINK_TULIP_1_7, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(LARGE_FERN_1_7, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerDoubleBlock(TALL_GRASS_1_7, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerParented(CRACKED_STONE_BRICKS_B1_8, INFESTED_CRACKED_STONE_BRICKS_1_7);
        blockStateModelGenerator.registerParented(MOSSY_STONE_BRICKS_B1_8, INFESTED_MOSSY_STONE_BRICKS_1_7);
        blockStateModelGenerator.registerParented(CHISELED_STONE_BRICKS_1_2, INFESTED_CHISELED_STONE_BRICKS_1_7);
        blockStateModelGenerator.registerSimpleCubeAll(RED_SAND_1_7);
        blockStateModelGenerator.registerGlassPane(WHITE_STAINED_GLASS_1_7, WHITE_STAINED_GLASS_PANE_1_7);
        blockStateModelGenerator.registerGlassPane(ORANGE_STAINED_GLASS_1_7, ORANGE_STAINED_GLASS_PANE_1_7);
        blockStateModelGenerator.registerGlassPane(MAGENTA_STAINED_GLASS_1_7, MAGENTA_STAINED_GLASS_PANE_1_7);
        blockStateModelGenerator.registerGlassPane(LIGHT_BLUE_STAINED_GLASS_1_7, LIGHT_BLUE_STAINED_GLASS_PANE_1_7);
        blockStateModelGenerator.registerGlassPane(YELLOW_STAINED_GLASS_1_7, YELLOW_STAINED_GLASS_PANE_1_7);
        blockStateModelGenerator.registerGlassPane(LIME_STAINED_GLASS_1_7, LIME_STAINED_GLASS_PANE_1_7);
        blockStateModelGenerator.registerGlassPane(PINK_STAINED_GLASS_1_7, PINK_STAINED_GLASS_PANE_1_7);
        blockStateModelGenerator.registerGlassPane(GRAY_STAINED_GLASS_1_7, GRAY_STAINED_GLASS_PANE_1_7);
        blockStateModelGenerator.registerGlassPane(LIGHT_GRAY_STAINED_GLASS_1_7, LIGHT_GRAY_STAINED_GLASS_PANE_1_7);
        blockStateModelGenerator.registerGlassPane(CYAN_STAINED_GLASS_1_7, CYAN_STAINED_GLASS_PANE_1_7);
        blockStateModelGenerator.registerGlassPane(PURPLE_STAINED_GLASS_1_7, PURPLE_STAINED_GLASS_PANE_1_7);
        blockStateModelGenerator.registerGlassPane(BLUE_STAINED_GLASS_1_7, BLUE_STAINED_GLASS_PANE_1_7);
        blockStateModelGenerator.registerGlassPane(BROWN_STAINED_GLASS_1_7, BROWN_STAINED_GLASS_PANE_1_7);
        blockStateModelGenerator.registerGlassPane(GREEN_STAINED_GLASS_1_7, GREEN_STAINED_GLASS_PANE_1_7);
        blockStateModelGenerator.registerGlassPane(RED_STAINED_GLASS_1_7, RED_STAINED_GLASS_PANE_1_7);
        blockStateModelGenerator.registerGlassPane(BLACK_STAINED_GLASS_1_7, BLACK_STAINED_GLASS_PANE_1_7);
        blockStateModelGenerator.registerLog(ACACIA_LOG_1_7)
                .log(ACACIA_LOG_1_7).wood(ACACIA_WOOD_1_7);
        blockStateModelGenerator.registerSingleton(ACACIA_LEAVES_1_7, TexturedModel.LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(ACACIA_SAPLING_1_7, POTTED_ACACIA_SAPLING_1_7, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(DARK_OAK_LOG_1_7)
                .log(DARK_OAK_LOG_1_7).wood(DARK_OAK_WOOD_1_7);
        blockStateModelGenerator.registerSingleton(DARK_OAK_LEAVES_1_7, TexturedModel.LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(DARK_OAK_SAPLING_1_7, POTTED_DARK_OAK_SAPLING_1_7, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.ACACIA_1_7.getBaseBlock())
                .family(ModBlockFamilies.ACACIA_1_7);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.DARK_OAK_1_7.getBaseBlock())
                .family(ModBlockFamilies.DARK_OAK_1_7);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.GRANITE_1_8.getBaseBlock())
                .family(ModBlockFamilies.GRANITE_1_8);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.DIORITE_1_8.getBaseBlock())
                .family(ModBlockFamilies.DIORITE_1_8);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.ANDESITE_1_8.getBaseBlock())
                .family(ModBlockFamilies.ANDESITE_1_8);
        blockStateModelGenerator.registerSimpleCubeAll(POLISHED_DIORITE_1_8);
        blockStateModelGenerator.registerSimpleCubeAll(POLISHED_ANDESITE_1_8);
        blockStateModelGenerator.registerSimpleCubeAll(POLISHED_GRANITE_1_8);
        blockStateModelGenerator.registerSimpleCubeAll(SLIME_BLOCK_1_8);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.PRISMARINE_1_8.getBaseBlock())
                .family(ModBlockFamilies.PRISMARINE_1_8);
        blockStateModelGenerator.registerSimpleCubeAll(PRISMARINE_BRICKS_1_8);
        blockStateModelGenerator.registerSimpleCubeAll(DARK_PRISMARINE_1_8);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.RED_SANDSTONE_1_8.getBaseBlock())
                .family(ModBlockFamilies.RED_SANDSTONE_1_8);
        blockStateModelGenerator.registerSingleton(SMOOTH_RED_SANDSTONE_1_8, TexturedModel.makeFactory(block -> new TextureMap()
                .put(TextureKey.TOP, TextureMap.getSubId(RED_SANDSTONE_1_8, "_top"))
                .put(TextureKey.SIDE, TextureMap.getId(SMOOTH_RED_SANDSTONE_1_8))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(RED_SANDSTONE_1_8, "_bottom")), Models.CUBE_BOTTOM_TOP));
        blockStateModelGenerator.registerSingleton(CUT_RED_SANDSTONE_1_8, TexturedModel.makeFactory(block -> new TextureMap()
                .put(TextureKey.TOP, Blocktopia.id("block/red_sandstone_1_8_top"))
                .put(TextureKey.SIDE, Blocktopia.id("block/cut_red_sandstone_1_8"))
                .put(TextureKey.BOTTOM, Blocktopia.id("block/red_sandstone_1_8_bottom")), Models.CUBE_BOTTOM_TOP));
        blockStateModelGenerator.registerRod(END_ROD_1_9);
        blockStateModelGenerator.registerSimpleCubeAll(ENDSTONE_BRICKS_1_9);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.PURPUR_1_9.getBaseBlock())
                .family(ModBlockFamilies.PURPUR_1_9);
        blockStateModelGenerator.registerAxisRotated(PURPUR_PILLAR_1_9, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BONE_BLOCK_1_10, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(MAGMA_BLOCK_1_10);
        blockStateModelGenerator.registerSimpleCubeAll(NETHER_WART_BLOCK_1_10);
        blockStateModelGenerator.registerSimpleCubeAll(NETHER_WART_BLOCK_1_14);
        blockStateModelGenerator.registerSimpleCubeAll(RED_NETHER_BRICKS_1_10);
        blockStateModelGenerator.registerSimpleCubeAll(PACKED_ICE_1_7);



        blockStateModelGenerator.registerSimpleCubeAll(PALE_OAK_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(PALE_OAK_SAPLING, POTTED_PALE_OAK_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(PALE_OAK_LOG)
                .log(PALE_OAK_LOG).wood(PALE_OAK_WOOD);
        blockStateModelGenerator.registerLog(STRIPPED_PALE_OAK_LOG)
                .log(STRIPPED_PALE_OAK_LOG).wood(STRIPPED_PALE_OAK_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.PALE_OAK.getBaseBlock())
                .family(ModBlockFamilies.PALE_OAK);
        blockStateModelGenerator.registerHangingSign(STRIPPED_PALE_OAK_LOG, PALE_OAK_HANGING_SIGN, PALE_OAK_WALL_HANGING_SIGN);
        blockStateModelGenerator.registerWoolAndCarpet(PALE_MOSS, PALE_MOSS_CARPET);
        registerHangingMoss(blockStateModelGenerator, PALE_HANGING_MOSS);
        blockStateModelGenerator.registerFlowerPotPlant(CLOSED_EYEBLOSSOM, POTTED_CLOSED_EYEBOSSOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(OPEN_EYEBLOSSOM, POTTED_OPEN_EYEBOSSOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerSimpleCubeAll(RESIN_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.RESIN_BRICKS.getBaseBlock())
                .family(ModBlockFamilies.RESIN_BRICKS);
        blockStateModelGenerator.registerFlowerbed(WILDFLOWERS);
        blockStateModelGenerator.registerFlowerbed(LEAF_LITTERS);
        blockStateModelGenerator.registerTintableCross(SHORT_DRY_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);


        blockStateModelGenerator.registerTorch(COPPER_TORCH, WALL_COPPER_TORCH);
        registerLantern(blockStateModelGenerator, WAXED_COPPER_LANTERN, COPPER_LANTERN);
        registerLantern(blockStateModelGenerator, WAXED_EXPOSED_COPPER_LANTERN, EXPOSED_COPPER_LANTERN);
        registerLantern(blockStateModelGenerator, WAXED_WEATHERED_COPPER_LANTERN, WEATHERED_COPPER_LANTERN);
        registerLantern(blockStateModelGenerator, WAXED_OXIDIZED_COPPER_LANTERN, OXIDIZED_COPPER_LANTERN);
        registerCopperBars(blockStateModelGenerator, WAXED_COPPER_BARS, COPPER_BARS);
        registerCopperBars(blockStateModelGenerator, WAXED_WEATHERED_COPPER_BARS, WEATHERED_COPPER_BARS);
        registerCopperBars(blockStateModelGenerator, WAXED_EXPOSED_COPPER_BARS, EXPOSED_COPPER_BARS);
        registerCopperBars(blockStateModelGenerator, WAXED_OXIDIZED_COPPER_BARS, OXIDIZED_COPPER_BARS);
        registerChain(blockStateModelGenerator, WAXED_COPPER_CHAIN, COPPER_CHAIN);
        registerChain(blockStateModelGenerator, WAXED_WEATHERED_COPPER_CHAIN, WEATHERED_COPPER_CHAIN);
        registerChain(blockStateModelGenerator, WAXED_EXPOSED_COPPER_CHAIN, EXPOSED_COPPER_CHAIN);
        registerChain(blockStateModelGenerator, WAXED_OXIDIZED_COPPER_CHAIN, OXIDIZED_COPPER_CHAIN);
        registerLightningRod(blockStateModelGenerator, WAXED_LIGHTNING_ROD, Blocks.LIGHTNING_ROD);
        registerLightningRod(blockStateModelGenerator, WAXED_WEATHERED_LIGHTNING_ROD, WEATHERED_LIGHTNING_ROD);
        registerLightningRod(blockStateModelGenerator, WAXED_EXPOSED_LIGHTNING_ROD, EXPOSED_LIGHTNING_ROD);
        registerLightningRod(blockStateModelGenerator, WAXED_OXIDIZED_LIGHTNING_ROD, OXIDIZED_LIGHTNING_ROD);
        blockStateModelGenerator.registerTintableCross(GOLDEN_DANDELION, BlockStateModelGenerator.TintType.NOT_TINTED);

        registerHangingMoss(blockStateModelGenerator, ModBlocks.BANANA_HANGING_MOSS);
        registerHangingMoss(blockStateModelGenerator, ModBlocks.CORN_HANGING_MOSS);
        registerHangingMoss(blockStateModelGenerator, ModBlocks.POISONED_HANGING_MOSS);
        registerHangingMoss(blockStateModelGenerator, ModBlocks.MAHOGANY_HANGING_MOSS);
        registerHangingMoss(blockStateModelGenerator, ModBlocks.FLOWERING_CHERRY_HANGING_MOSS);





        blockStateModelGenerator.registerSingleton(ModBlocks.DUPER, TexturedModel.CUBE_ALL);
        blockStateModelGenerator.registerParentedItemModel(ModBlocks.DUPER, Identifier.ofVanilla("builtin/entity"));
        blockStateModelGenerator.registerWoolAndCarpet(ModBlocks.TROPICAL_MOSS, ModBlocks.TROPICAL_MOSS_CARPET);

        Identifier topTexture = Identifier.ofVanilla("block/sand");
        Identifier sideTexture = Blocktopia.id("block/sandy_dirt");
        Identifier bottomTexture = Identifier.ofVanilla("block/dirt");

        TextureMap textures = new TextureMap()
                .put(TextureKey.TOP, topTexture)
                .put(TextureKey.SIDE, sideTexture)
                .put(TextureKey.BOTTOM, bottomTexture);

        blockStateModelGenerator.registerSingleton(ModBlocks.SANDY_DIRT, TexturedModel.makeFactory(block -> textures, Models.CUBE_BOTTOM_TOP));

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.XP_TRAP);

        TextureMap textureMap = new TextureMap()
                .put(TextureKey.DIRT, TextureMap.getId(ModBlocks.TROPICAL_MOSS))
                .put(TextureKey.TOP, TextureMap.getId(ModBlocks.TROPICAL_FARM_LAND));
        blockStateModelGenerator.registerSingleton(ModBlocks.TROPICAL_FARM_LAND, TexturedModel.makeFactory(block -> textureMap, Models.TEMPLATE_FARMLAND));

        registerChair(blockStateModelGenerator,ModBlocks.OAK_CHAIR);
        registerChair(blockStateModelGenerator,ModBlocks.SPRUCE_CHAIR);
        registerChair(blockStateModelGenerator,ModBlocks.BIRCH_CHAIR);
        registerChair(blockStateModelGenerator,ModBlocks.JUNGLE_CHAIR);
        registerChair(blockStateModelGenerator,ModBlocks.ACACIA_CHAIR);
        registerChair(blockStateModelGenerator,ModBlocks.DARK_OAK_CHAIR);
        registerChair(blockStateModelGenerator,ModBlocks.CRIMSON_CHAIR);
        registerChair(blockStateModelGenerator,ModBlocks.WARPED_CHAIR);
        registerChair(blockStateModelGenerator,ModBlocks.MANGROVE_CHAIR);
        registerChair(blockStateModelGenerator,ModBlocks.BAMBOO_CHAIR);
        registerChair(blockStateModelGenerator,ModBlocks.CHERRY_CHAIR);
        registerChair(blockStateModelGenerator,ModBlocks.PALM_CHAIR);
        registerChair(blockStateModelGenerator,ModBlocks.BANANA_CHAIR);
        registerChair(blockStateModelGenerator,ModBlocks.CORN_CHAIR);
        registerChair(blockStateModelGenerator,ModBlocks.POISONED_CHAIR);
        registerChair(blockStateModelGenerator,ModBlocks.MAHOGANY_CHAIR);
        registerChair(blockStateModelGenerator,ModBlocks.PALE_OAK_CHAIR);
        registerChair(blockStateModelGenerator, ModBlocks.WOODEN_CHAIR_RD20090515);
        registerChair(blockStateModelGenerator, ModBlocks.WOODEN_CHAIR_RD161348);
        registerChair(blockStateModelGenerator, ModBlocks.WOODEN_CHAIR_C0_0_14A);
        registerChair(blockStateModelGenerator, ModBlocks.WOODEN_CHAIR_C0_0_15A);
        registerChair(blockStateModelGenerator, ModBlocks.WOODEN_CHAIR_B1_9PRE5);
        registerChair(blockStateModelGenerator, ModBlocks.BIRCH_CHAIR_1_2_4);
        registerChair(blockStateModelGenerator, ModBlocks.SPRUCE_CHAIR_1_2_4);
        registerChair(blockStateModelGenerator, ModBlocks.JUNGLE_CHAIR_1_2_4);
        registerChair(blockStateModelGenerator, ModBlocks.ACACIA_CHAIR_1_7);
        registerChair(blockStateModelGenerator, ModBlocks.DARK_OAK_CHAIR_1_7);

        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_OAK_SLAB, Blocks.OAK_PLANKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_SPRUCE_SLAB, Blocks.SPRUCE_PLANKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_BIRCH_SLAB, Blocks.BIRCH_PLANKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_JUNGLE_SLAB, Blocks.JUNGLE_PLANKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_ACACIA_SLAB, Blocks.ACACIA_PLANKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_DARK_OAK_SLAB, Blocks.DARK_OAK_PLANKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_MANGROVE_SLAB, Blocks.MANGROVE_PLANKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_CHERRY_SLAB, Blocks.CHERRY_PLANKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_BAMBOO_SLAB, Blocks.BAMBOO_PLANKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_BAMBO_MOSAIC_SLAB, Blocks.BAMBOO_MOSAIC);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_CRIMSON_SLAB, Blocks.CRIMSON_PLANKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_WARPED_SLAB, Blocks.WARPED_PLANKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_STONE_SLAB, Blocks.STONE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_COBBLESTONE_SLAB, Blocks.COBBLESTONE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_MOSSY_COBBLESTONE_SLAB, Blocks.MOSSY_COBBLESTONE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_SMOOTH_STONE_SLAB, Blocks.SMOOTH_STONE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_STONE_BRICK_SLAB, Blocks.STONE_BRICKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_MOSSY_STONE_BRICK_SLAB, Blocks.MOSSY_STONE_BRICKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_GRANITE_SLAB, Blocks.GRANITE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_POLISHED_GRANITE_SLAB, Blocks.POLISHED_GRANITE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_DIORITE_SLAB, Blocks.DIORITE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_POLISHED_DIORITE_SLAB, Blocks.POLISHED_DIORITE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_ANDESITE_SLAB, Blocks.ANDESITE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_POLISHED_ANDESITE_SLAB, Blocks.POLISHED_ANDESITE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_COBBLED_DEEPSLATE_SLAB, Blocks.COBBLED_DEEPSLATE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_POLISHED_DEEPSLATE_SLAB, Blocks.POLISHED_DEEPSLATE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_DEEPSLATE_BRICK_SLAB, Blocks.DEEPSLATE_BRICKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_DEEPSLATE_TILE_SLAB, Blocks.DEEPSLATE_TILES);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_TUFF_SLAB, Blocks.TUFF);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_POLISHED_TUFF_SLAB, Blocks.POLISHED_TUFF);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_TUFF_BRICK_SLAB, Blocks.TUFF_BRICKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_BRICK_SLAB, Blocks.BRICKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_MUD_BRICK_SLAB, Blocks.MUD_BRICKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_SANDSTONE_SLAB, Blocks.SANDSTONE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_SMOOTH_SANDSTONE_SLAB, Blocks.SMOOTH_SANDSTONE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_CUT_SANDSTONE_SLAB, Blocks.CUT_SANDSTONE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_RED_SANDSTONE_SLAB, Blocks.RED_SANDSTONE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_SMOOTH_RED_SANDSTONE_SLAB, Blocks.SMOOTH_RED_SANDSTONE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_CUT_RED_SANDSTONE_SLAB, Blocks.CUT_RED_SANDSTONE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_PRISMARINE_SLAB, Blocks.PRISMARINE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_BRISMARINE_BRICK_SLAB, Blocks.PRISMARINE_BRICKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_DARK_PRISMARINE_SLAB, Blocks.DARK_PRISMARINE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_NETHER_BRICK_SLAB, Blocks.NETHER_BRICKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_RED_NETHER_BRICK_SLAB, Blocks.RED_NETHER_BRICKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_BLACKSTONE_SLAB, Blocks.BLACKSTONE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_POLISHED_BLACKSTONE_SLAB, Blocks.POLISHED_BLACKSTONE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB, Blocks.POLISHED_BLACKSTONE_BRICKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_ENDSTONE_BRICK_SLAB, Blocks.END_STONE_BRICKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_PURPUR_SLAB, Blocks.PURPUR_BLOCK);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_QUARTZ_SLAB, Blocks.QUARTZ_BLOCK);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_SMOOTH_QUARTZ_SLAB, Blocks.SMOOTH_QUARTZ);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_CUT_COPPER_SLAB, Blocks.CUT_COPPER);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.EXPOSED_VERTICAL_CUT_COPPER_SLAB, Blocks.EXPOSED_CUT_COPPER);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.WEATHERED_VERTICAL_CUT_COPPER_SLAB, Blocks.WEATHERED_CUT_COPPER);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.OXIDIZED_VERTICAL_CUT_COPPER_SLAB, Blocks.OXIDIZED_CUT_COPPER);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.WAXED_VERTICAL_CUT_COPPER_SLAB, Blocks.CUT_COPPER);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.WAXED_EXPOSED_VERTICAL_CUT_COPPER_SLAB, Blocks.EXPOSED_CUT_COPPER);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.WAXED_WEATHERED_VERTICAL_CUT_COPPER_SLAB, Blocks.WEATHERED_CUT_COPPER);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.WAXED_OXIDIZED_VERTICAL_CUT_COPPER_SLAB, Blocks.OXIDIZED_CUT_COPPER);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_COBBLESTONE_SLAB_RD20090515, LegacyBlocks.COBBLESTONE_RD20090515);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_COBBLESTONE_SLAB_B1_3, LegacyBlocks.COBBLESTONE_C0_0_14A);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_COBBLESTONE_SLAB_B1_7, LegacyBlocks.COBBLESTONE_B1_7);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_WOODEN_SLAB_RD20090515, LegacyBlocks.WOODEN_PLANKS_RD20090515);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_WOODEN_SLAB_RD161348, LegacyBlocks.WOODEN_PLANKS_RD161348);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_WOODEN_SLAB_C0_0_14A, LegacyBlocks.WOODEN_PLANKS_C0_0_14A);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_WOODEN_SLAB_B1_3, LegacyBlocks.WOODEN_PLANKS_C0_0_15A);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_WOODEN_SLAB_B1_9PRE5, LegacyBlocks.WOODEN_PLANKS_B1_9PRE5);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_SANDSTONE_SLAB_B1_3, LegacyBlocks.SANDSTONE_B1_2);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_SANDSTONE_SLAB_1_2_4, LegacyBlocks.SANDSTONE_1_2_4);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_BRICK_SLAB_C0_26ST, LegacyBlocks.BRICKS_C0_26ST);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_BRICK_SLAB_B1_8, LegacyBlocks.BRICKS_A1_0_11);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_STONE_BRICK_SLAB_B1_8, LegacyBlocks.STONE_BRICKS_B1_8);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_BIRCH_SLAB_1_3, LegacyBlocks.BIRCH_PLANKS_1_2_4);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_SPRUCE_SLAB_1_3, LegacyBlocks.SPRUCE_PLANKS_1_2_4);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_JUNGLE_SLAB_1_3, LegacyBlocks.JUNGLE_PLANKS_1_2_4);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_NETHER_BRICK_SLAB_1_4_6, LegacyBlocks.NETHER_BRICKS_B1_9PRE);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_RED_SANDSTONE_SLAB_1_8, LegacyBlocks.RED_SANDSTONE_1_8);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_PURPUR_SLAB_1_9, LegacyBlocks.PURPUR_BLOCK_1_9);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_PRISMARINE_SLAB_1_13, LegacyBlocks.PRISMARINE_1_8);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_PALE_OAK_SLAB, FutureBlocks.PALE_OAK_PLANKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_RESIN_BRICK_SLAB, FutureBlocks.RESIN_BRICKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_PALM_SLAB, ModBlocks.PALM_PLANKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_BANANA_SLAB, ModBlocks.BANANA_PLANKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_CORN_SLAB, ModBlocks.CORN_PLANKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_POISONED_SLAB, ModBlocks.POISONED_PLANKS);
        registerVerticalSlab(blockStateModelGenerator, ModBlocks.VERTICAL_MAHOGANY_SLAB, ModBlocks.MAHOGANY_PLANKS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        Item[] legacyItems = {QUIVER_IN20091231_2255, QUIVER_IN20100122_2251, APPLE_IN20091231_2255, APPLE_1_4, COAL_IN20100128, COAL_IN20100219, COAL_1_3, DIAMOND_IN20100128, DIAMOND_1_3, GOLD_INGOT_IN20100128, GOLD_INGOT_IN20100129, IRON_INGOT_IN20100128, IRON_INGOT_IN20100129, BOWL_IN20100130, MUSHROOM_STEW_IN20100130, SULPHUR, STRING_IN20100130, FEATHER_IN20100130, FEATHER_IN20100206, BREAD_IN20100206, BREAD_1_4, WHEAT_IN20100206, FLINT_IN20100219, FLINT_1_3, PORKCHOP_IN20100219, PORKCHOP_1_4, COOKED_PORKCHOP_IN20100219, COOKED_PORKCHOP_B1_8, COOKED_PORKCHOP_1_4, GOLDEN_APPLE_INF20100227, LEATHER_A1_0_8, PAPER_A1_0_11, BOOK_A1_0_11, CLAY_BALL_A1_0_11, BRICK_A1_0_11, SLIMEBALL_A1_0_11, GLOWSTONE_DUST_A1_2_0, FISH_A1_2_0, COOKED_FISH_A1_2_0, BONE_B1_2, BONE_MEAL_B1_2, BONE_MEAL_1_3, COOKIE_B1_4, CHICKEN_B1_8, CHICKEN_1_4, COOKED_CHICKEN_B1_8, COOKED_CHICKEN_1_4, BEEF_B1_8, BEEF_1_3, BEEF_1_4, COOKED_BEEF_B1_8, COOKED_BEEF_1_3, COOKED_BEEF_1_4, ROTTEN_FLESH_B1_8, ROTTEN_FLESH_1_3, GHAST_TEAR_B1_9PRE, GOLD_NUGGET_B1_9PRE, GOLD_NUGGET_1_3, BLAZE_POWDER_B1_9PRE2, FERMENTED_SPIDER_EYE_B1_9PRE2, MAGMA_CREAM_B1_9PRE2, MAGMA_CREAM_1_3, SPIDER_EYE_B1_9PRE2, GLISTERING_MELON_B1_9PRE4, RUBY, EMERALD_1_3, ENCHANTED_GOLDEN_APPLE_1_3, GOLDEN_CARROT_1_4, BAKED_POTATO_1_4, POISONOUS_POTATO_1_4, NETHER_STAR_1_4, PUMPKIN_PIE_1_4, QUARTZ_1_5, CLOWNFISH_1_7, SALMON_1_7, COOKED_SALMON_1_7, PUFFERFISH_1_7, PRISMARINE_CRYSTAL_1_8, PRISMARINE_SHARD_1_8, MUTTON_1_8, COOKED_MUTTON_1_8, RABBIT_1_8, COOKED_RABBIT_1_8, RABBIT_FOOT_1_8, RABBIT_HIDE_1_8, RABBIT_STEW_1_8};
        Arrays.stream(legacyItems)
                        .forEach(item -> itemModelGenerator.register(item, Models.GENERATED));

        itemModelGenerator.register(RESIN_CLUMP, Models.GENERATED);
        itemModelGenerator.register(RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(PALE_OAK_BOAT, Models.GENERATED);
        itemModelGenerator.register(PALE_OAK_CHEST_BOAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.DEEPSLATE_EMERALD_CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_DEEPSLATE_EMERALD_CHERRY, ModItems.DEEPSLATE_EMERALD_CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.END_DIAMOND_CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_END_DIAMOND_CHERRY, ModItems.END_DIAMOND_CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.CREATIVE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CREATIVE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COCONUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_COCONUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_GOLDEN_COCONUT, ModItems.GOLDEN_COCONUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_GOLDEN_CARROT, Items.GOLDEN_CARROT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_GOLDEN_POTATO, ModItems.GOLDEN_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_BAKED_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_GOLDEN_BAKED_POTATO, ModItems.GOLDEN_BAKED_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.PALM_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PALM_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BANANA_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BANANA_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.POISONED_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.POISONED_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAHOGANY_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAHOGANY_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GIANT_SPAWN_EGG, ITEM_RENDERER);
        itemModelGenerator.register(ModItems.ILLUSIONER_SPAWN_EGG, ITEM_RENDERER);
        itemModelGenerator.register(ModItems.CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_GOLDEN_CHERRY, ModItems.GOLDEN_CHERRY,Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_DIAMOND_CHERRY, ModItems.DIAMOND_CHERRY,Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_NETHERITE_CHERRY, ModItems.NETHERITE_CHERRY,Models.GENERATED);
        itemModelGenerator.register(ModItems.RABBIT_TRINKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.FISH_TRINKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAT_TRINKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.MONKEY_SPAWN_EGG, ITEM_RENDERER);
        itemModelGenerator.register(ModItems.BANANA, Models.GENERATED);
        itemModelGenerator.register(ModFluids.TROPICAL_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPAWNER_MINECART, Models.GENERATED);
        itemModelGenerator.register(ModItems.FUTURE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.THERMORGANIC_FUEL, Models.GENERATED);
        itemModelGenerator.register(COPPER_NUGGET, Models.GENERATED);
    }

    private static final Model VERTICAL_SLAB_NORTH = block("vertical_slab_north", TextureKey.SIDE, TextureKey.BOTTOM, TextureKey.TOP);
    private static final Model VERTICAL_SLAB_WEST = block("vertical_slab_west", TextureKey.SIDE, TextureKey.BOTTOM, TextureKey.TOP);
    private static final Model VERTICAL_SLAB_SOUTH = block("vertical_slab_south", TextureKey.SIDE, TextureKey.BOTTOM, TextureKey.TOP);
    private static final Model VERTICAL_SLAB_EAST = block("vertical_slab_east", TextureKey.SIDE, TextureKey.BOTTOM, TextureKey.TOP);

    public final void registerVerticalSlab(BlockStateModelGenerator generator, Block verticalSlab, Block base) {
        TexturedModel model = ((BlockStateModelAccessor)generator).blocktopia$getTextureModels().get(base);
        Identifier north = TexturedModel.makeFactory(block -> model != null ? model.getTextures() :
                new TextureMap()
                        .put(TextureKey.SIDE, TextureMap.getId(base))
                        .put(TextureKey.BOTTOM, TextureMap.getId(base))
                        .put(TextureKey.TOP, TextureMap.getId(base)), VERTICAL_SLAB_NORTH)
                        .upload(verticalSlab, "_north", generator.modelCollector);
        Identifier west = TexturedModel.makeFactory(block -> model != null ? model.getTextures() :
                        new TextureMap()
                                .put(TextureKey.SIDE, TextureMap.getId(base))
                                .put(TextureKey.BOTTOM, TextureMap.getId(base))
                                .put(TextureKey.TOP, TextureMap.getId(base)), VERTICAL_SLAB_WEST)
                .upload(verticalSlab, "_west", generator.modelCollector);
        Identifier south = TexturedModel.makeFactory(block -> model != null ? model.getTextures() :
                        new TextureMap()
                                .put(TextureKey.SIDE, TextureMap.getId(base))
                                .put(TextureKey.BOTTOM, TextureMap.getId(base))
                                .put(TextureKey.TOP, TextureMap.getId(base)), VERTICAL_SLAB_SOUTH)
                .upload(verticalSlab, "_south", generator.modelCollector);
        Identifier east = TexturedModel.makeFactory(block -> model != null ? model.getTextures() :
                        new TextureMap()
                                .put(TextureKey.SIDE, TextureMap.getId(base))
                                .put(TextureKey.BOTTOM, TextureMap.getId(base))
                                .put(TextureKey.TOP, TextureMap.getId(base)), VERTICAL_SLAB_EAST)
                .upload(verticalSlab, "_east", generator.modelCollector);
        Identifier block = TextureMap.getId(base);

        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(verticalSlab)
                .coordinate(
                        BlockStateVariantMap.create(VerticalSlabBlock.TYPE, VerticalSlabBlock.FACING)
                                .register(VerticalSlabBlock.VerticalSlabType.DOUBLE, Direction.NORTH,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, block))
                                .register(VerticalSlabBlock.VerticalSlabType.DOUBLE, Direction.SOUTH,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, block))
                                .register(VerticalSlabBlock.VerticalSlabType.DOUBLE, Direction.WEST,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, block))
                                .register(VerticalSlabBlock.VerticalSlabType.DOUBLE, Direction.EAST,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, block))

                                .register(VerticalSlabBlock.VerticalSlabType.SINGLE, Direction.NORTH,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, north))
                                .register(VerticalSlabBlock.VerticalSlabType.SINGLE, Direction.SOUTH,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, south))
                                .register(VerticalSlabBlock.VerticalSlabType.SINGLE, Direction.WEST,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, west))
                                .register(VerticalSlabBlock.VerticalSlabType.SINGLE, Direction.EAST,
                                        BlockStateVariant.create().put(VariantSettings.MODEL, east))
                ));
        generator.registerParentedItemModel(verticalSlab, ModelIds.getBlockSubModelId(verticalSlab, "_north"));
    }

    private static final Model CHAIN = vanillaBlock("chain", TextureKey.PARTICLE, TextureKey.ALL);

    public final void registerChain(BlockStateModelGenerator generator, Block waxed, Block unwaxed) {
        generator.registerAxisRotated(unwaxed,
                TexturedModel.makeFactory(block -> new TextureMap()
                        .put(TextureKey.PARTICLE, ModelIds.getBlockModelId(unwaxed))
                        .put(TextureKey.ALL, ModelIds.getBlockModelId(unwaxed)), CHAIN));
        generator.registerAxisRotated(waxed,
                TexturedModel.makeFactory(block -> new TextureMap()
                        .put(TextureKey.PARTICLE, ModelIds.getBlockModelId(unwaxed))
                        .put(TextureKey.ALL, ModelIds.getBlockModelId(unwaxed)), CHAIN));
        Models.GENERATED.upload(ModelIds.getItemModelId(waxed.asItem()), TextureMap.layer0(ModelIds.getItemModelId(unwaxed.asItem())), generator.modelCollector);
        Models.GENERATED.upload(ModelIds.getItemModelId(unwaxed.asItem()), TextureMap.layer0(ModelIds.getItemModelId(unwaxed.asItem())), generator.modelCollector);
    }

    public final void registerHangingMoss(BlockStateModelGenerator generator, Block block) {
        generator.registerItemModel(block);
        Identifier identifier = generator.createSubModel(block, "", Models.CROSS, TextureMap::cross);
        Identifier identifier1 = generator.createSubModel(block, "_tip", Models.CROSS, TextureMap::cross);
        generator.blockStateCollector
                .accept(
                        VariantsBlockStateSupplier.create(block)
                                .coordinate(
                                        BlockStateVariantMap.create(HangingMossBlock.TIP)
                                                .register(Boolean.FALSE, BlockStateVariant.create().put(VariantSettings.MODEL, identifier))
                                                .register(Boolean.TRUE, BlockStateVariant.create().put(VariantSettings.MODEL, identifier1))
                                )
                );
    }

    private static final Model LIGHTNING_ROD = vanillaBlock("lightning_rod", TextureKey.TEXTURE, TextureKey.PARTICLE);
    private static final Model LIGHTNING_ROD_ON = vanillaBlock("lightning_rod_on", TextureKey.TEXTURE, TextureKey.PARTICLE);
    private void registerLightningRod(BlockStateModelGenerator generator, Block waxed, Block unwaxed) {
        Identifier onModel = ModelIds.getBlockSubModelId(unwaxed, "_on");
        Identifier offModel = ModelIds.getBlockModelId(unwaxed);
        if (unwaxed != Blocks.LIGHTNING_ROD) {
            onModel = LIGHTNING_ROD_ON.upload(ModelIds.getBlockSubModelId(unwaxed, "_on"), new TextureMap()
                    .put(TextureKey.TEXTURE, ModelIds.getBlockModelId(unwaxed))
                    .put(TextureKey.PARTICLE, ModelIds.getBlockModelId(unwaxed)), generator.modelCollector);
            offModel = LIGHTNING_ROD.upload(unwaxed, new TextureMap()
                    .put(TextureKey.TEXTURE, ModelIds.getBlockModelId(unwaxed))
                    .put(TextureKey.PARTICLE, ModelIds.getBlockModelId(unwaxed)), generator.modelCollector);
        }
        VariantsBlockStateSupplier supplier = VariantsBlockStateSupplier.create(waxed, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(waxed)))
                .coordinate(generator.createUpDefaultFacingVariantMap())
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(Properties.POWERED, onModel, offModel));
        generator.blockStateCollector.accept(supplier);
        if (unwaxed != Blocks.LIGHTNING_ROD) {
            VariantsBlockStateSupplier supplier2 = VariantsBlockStateSupplier.create(unwaxed, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(unwaxed)))
                    .coordinate(generator.createUpDefaultFacingVariantMap())
                    .coordinate(BlockStateModelGenerator.createBooleanModelMap(Properties.POWERED, onModel, offModel));
            generator.blockStateCollector.accept(supplier2);
        }

        generator.registerParentedItemModel(waxed, ModelIds.getItemModelId(unwaxed.asItem()));
    }


    public final void registerLantern(BlockStateModelGenerator generator, Block lantern, Block unwaxed) {
        Identifier identifier = TexturedModel.TEMPLATE_LANTERN.upload(unwaxed, generator.modelCollector);
        Identifier identifier2 = TexturedModel.TEMPLATE_HANGING_LANTERN.upload(unwaxed, generator.modelCollector);
        generator.registerParentedItemModel(lantern, ModelIds.getItemModelId(unwaxed.asItem()));
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(lantern).coordinate(BlockStateModelGenerator.createBooleanModelMap(Properties.HANGING, identifier2, identifier)));
        generator.registerItemModel(unwaxed.asItem());
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(unwaxed).coordinate(BlockStateModelGenerator.createBooleanModelMap(Properties.HANGING, identifier2, identifier)));
    }

    private void registerSunflower(BlockStateModelGenerator generator, Block sunflower) {
        generator.registerItemModel(sunflower, "_front");
        Identifier identifier = ModelIds.getBlockSubModelId(sunflower, "_top");
        Identifier identifier2 = generator.createSubModel(sunflower, "_bottom", BlockStateModelGenerator.TintType.NOT_TINTED.getCrossModel(), TextureMap::cross);
        generator.registerDoubleBlock(sunflower, identifier, identifier2);
    }

    private void registerCocoaBeans(BlockStateModelGenerator generator, Block cocoa) {
        generator.registerItemModel(cocoa);
        generator.blockStateCollector
                .accept(
                        VariantsBlockStateSupplier.create(cocoa)
                                .coordinate(
                                        BlockStateVariantMap.create(Properties.AGE_2)
                                                .register(0, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cocoa, "_stage0")))
                                                .register(1, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cocoa, "_stage1")))
                                                .register(2, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cocoa, "_stage2")))
                                )
                                .coordinate(BlockStateModelGenerator.createSouthDefaultHorizontalRotationStates())
                );
    }

    private static final TextureKey BARS = TextureKey.of("bars");
    private static final Model BAR_POST_ENDS = vanillaBlock("iron_bars_post_ends", BARS, TextureKey.EDGE);
    private static final Model BAR_POST = vanillaBlock("iron_bars_post", BARS, TextureKey.EDGE);
    private static final Model BAR_CAP = vanillaBlock("iron_bars_cap", BARS, TextureKey.EDGE);
    private static final Model BAR_CAP_ALT = vanillaBlock("iron_bars_cap_alt", BARS, TextureKey.EDGE);
    private static final Model BAR_SIDE = vanillaBlock("iron_bars_side", BARS, TextureKey.EDGE);
    private static final Model BAR_SIDE_ALT = vanillaBlock("iron_bars_side_alt", BARS, TextureKey.EDGE);
    private void registerCopperBars(BlockStateModelGenerator generator, Block waxed, Block unwaxed) {
        Identifier identifier1 = BAR_POST_ENDS.upload(ModelIds.getBlockSubModelId(unwaxed, "_post_ends"), new TextureMap()
                .put(BARS, ModelIds.getBlockModelId(unwaxed))
                .put(TextureKey.EDGE, ModelIds.getBlockModelId(unwaxed)), generator.modelCollector);
        Identifier identifier2 = BAR_POST.upload(ModelIds.getBlockSubModelId(unwaxed, "_post"), new TextureMap()
                .put(BARS, ModelIds.getBlockModelId(unwaxed))
                .put(TextureKey.EDGE, ModelIds.getBlockModelId(unwaxed)), generator.modelCollector);
        Identifier identifier3 = BAR_CAP.upload(ModelIds.getBlockSubModelId(unwaxed, "_cap"), new TextureMap()
                .put(BARS, ModelIds.getBlockModelId(unwaxed))
                .put(TextureKey.EDGE, ModelIds.getBlockModelId(unwaxed)), generator.modelCollector);
        Identifier identifier4 = BAR_CAP_ALT.upload(ModelIds.getBlockSubModelId(unwaxed, "_cap_alt"), new TextureMap()
                .put(BARS, ModelIds.getBlockModelId(unwaxed))
                .put(TextureKey.EDGE, ModelIds.getBlockModelId(unwaxed)), generator.modelCollector);
        Identifier identifier5 = BAR_SIDE.upload(ModelIds.getBlockSubModelId(unwaxed, "_side"), new TextureMap()
                .put(BARS, ModelIds.getBlockModelId(unwaxed))
                .put(TextureKey.EDGE, ModelIds.getBlockModelId(unwaxed)), generator.modelCollector);
        Identifier identifier6 = BAR_SIDE_ALT.upload(ModelIds.getBlockSubModelId(unwaxed, "_side_alt"), new TextureMap()
                .put(BARS, ModelIds.getBlockModelId(unwaxed))
                .put(TextureKey.EDGE, ModelIds.getBlockModelId(unwaxed)), generator.modelCollector);
        generator.blockStateCollector
                .accept(
                        MultipartBlockStateSupplier.create(waxed)
                                .with(BlockStateVariant.create().put(VariantSettings.MODEL, identifier1))
                                .with(
                                        When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, false),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier2)
                                )
                                .with(
                                        When.create().set(Properties.NORTH, true).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, false),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier3)
                                )
                                .with(
                                        When.create().set(Properties.NORTH, false).set(Properties.EAST, true).set(Properties.SOUTH, false).set(Properties.WEST, false),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier3).put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                )
                                .with(
                                        When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, true).set(Properties.WEST, false),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier4)
                                )
                                .with(
                                        When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, true),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier4).put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                )
                                .with(When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5))
                                .with(
                                        When.create().set(Properties.EAST, true),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier5).put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                )
                                .with(When.create().set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier6))
                                .with(
                                        When.create().set(Properties.WEST, true),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier6).put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                )
                );
        generator.blockStateCollector
                .accept(
                        MultipartBlockStateSupplier.create(unwaxed)
                                .with(BlockStateVariant.create().put(VariantSettings.MODEL, identifier1))
                                .with(
                                        When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, false),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier2)
                                )
                                .with(
                                        When.create().set(Properties.NORTH, true).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, false),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier3)
                                )
                                .with(
                                        When.create().set(Properties.NORTH, false).set(Properties.EAST, true).set(Properties.SOUTH, false).set(Properties.WEST, false),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier3).put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                )
                                .with(
                                        When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, true).set(Properties.WEST, false),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier4)
                                )
                                .with(
                                        When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, true),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier4).put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                )
                                .with(When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5))
                                .with(
                                        When.create().set(Properties.EAST, true),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier5).put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                )
                                .with(When.create().set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier6))
                                .with(
                                        When.create().set(Properties.WEST, true),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier6).put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                )
                );
        generator.registerParentedItemModel(waxed, ModelIds.getItemModelId(unwaxed.asItem()));
        generator.registerItemModel(unwaxed);
    }

    private void registerLilyPad(BlockStateModelGenerator generator, Block liliPad) {
        generator.registerItemModel(liliPad);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createBlockStateWithRandomHorizontalRotations(liliPad, ModelIds.getBlockModelId(liliPad)));
    }

    public final void registerMushroomBlock(BlockStateModelGenerator generator, Identifier insideTexture, Block mushroomBlock) {
        Identifier identifier = Models.TEMPLATE_SINGLE_FACE.upload(mushroomBlock, TextureMap.texture(mushroomBlock), generator.modelCollector);
        generator.blockStateCollector
                .accept(
                        MultipartBlockStateSupplier.create(mushroomBlock)
                                .with(When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier))
                                .with(
                                        When.create().set(Properties.EAST, true),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, true)
                                )
                                .with(
                                        When.create().set(Properties.SOUTH, true),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R180).put(VariantSettings.UVLOCK, true)
                                )
                                .with(
                                        When.create().set(Properties.WEST, true),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, true)
                                )
                                .with(
                                        When.create().set(Properties.UP, true),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, true)
                                )
                                .with(
                                        When.create().set(Properties.DOWN, true),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, true)
                                )
                                .with(When.create().set(Properties.NORTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, insideTexture))
                                .with(
                                        When.create().set(Properties.EAST, false),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, insideTexture)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                                .put(VariantSettings.UVLOCK, false)
                                )
                                .with(
                                        When.create().set(Properties.SOUTH, false),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, insideTexture)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                                                .put(VariantSettings.UVLOCK, false)
                                )
                                .with(
                                        When.create().set(Properties.WEST, false),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, insideTexture)
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                                .put(VariantSettings.UVLOCK, false)
                                )
                                .with(
                                        When.create().set(Properties.UP, false),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, insideTexture)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                                .put(VariantSettings.UVLOCK, false)
                                )
                                .with(
                                        When.create().set(Properties.DOWN, false),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, insideTexture)
                                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                                .put(VariantSettings.UVLOCK, false)
                                )
                );
        generator.registerParentedItemModel(mushroomBlock, TexturedModel.CUBE_ALL.upload(mushroomBlock, "_inventory", generator.modelCollector));
    }

    private void registerCake(BlockStateModelGenerator generator, Block cake) {
        generator.registerItemModel(cake);
        generator.blockStateCollector
                .accept(
                        VariantsBlockStateSupplier.create(cake)
                                .coordinate(
                                        BlockStateVariantMap.create(Properties.BITES)
                                                .register(0, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(cake)))
                                                .register(1, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cake, "_slice1")))
                                                .register(2, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cake, "_slice2")))
                                                .register(3, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cake, "_slice3")))
                                                .register(4, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cake, "_slice4")))
                                                .register(5, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cake, "_slice5")))
                                                .register(6, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(cake, "_slice6")))
                                )
                );
    }

    public final void registerAnvil(BlockStateModelGenerator generator, Block anvil) {
        generator.registerParentedItemModel(anvil, TextureMap.getId(anvil));
        String temp = Registries.BLOCK.getId(anvil).getPath();
        String stripped;
        if (temp.startsWith("chipped_"))
            stripped = temp.substring(8);
        else if (temp.startsWith("damaged_"))
            stripped = temp.substring(8);
        else
            stripped = temp;
        Identifier side = Blocktopia.id("block/" + stripped + "_side");
        Identifier identifier = generator.createSubModel(anvil, "", ANVIL, id -> new TextureMap()
                .put(TextureKey.TOP, TextureMap.getId(anvil))
                .put(BODY, side)
                .put(TextureKey.PARTICLE, side));
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(anvil, identifier)
                .coordinate(BlockStateModelGenerator.createSouthDefaultHorizontalRotationStates()));
    }


    public static final Model TEMPLATE_SPAWN_EGG = item("template_spawn_egg");
    public static final Model ITEM_RENDERER = new Model(Optional.of(Identifier.ofVanilla("builtin/entity")), Optional.empty());
    private static Model item(String parent) {
        return new Model(Optional.of(Identifier.ofVanilla("item/" + parent)), Optional.empty());
    }

    public static final TextureKey SEAT_TEXTURE = TextureKey.of("seat_texture");
    public static final TextureKey TEXTURE = TextureKey.of("texture");
    public static final TextureKey BODY = TextureKey.of("body");

    public static final Model CHAIR = block("chair", SEAT_TEXTURE, TEXTURE);
    public static final Model ANVIL = vanillaBlock("template_anvil", TextureKey.TOP, BODY, TextureKey.PARTICLE);

    private static Model block(String parent, TextureKey... requiredKeys) {
        return new Model(Optional.of(Blocktopia.id("block/" + parent)), Optional.empty(), requiredKeys);
    }
    private static Model vanillaBlock(String parent, TextureKey... requiredKeys) {
        return new Model(Optional.of(Identifier.ofVanilla("block/" + parent)), Optional.empty(), requiredKeys);
    }

    public void registerChair(BlockStateModelGenerator generator, ChairBlock[] blocks) {
        for (ChairBlock block : blocks) {
            generator.registerParentedItemModel(block, TextureMap.getId(block));
            Identifier identifier2 = generator.createSubModel(block, "", CHAIR, id -> new TextureMap()
                    .put(SEAT_TEXTURE, TextureMap.getId(block.seat))
                    .put(TEXTURE, TextureMap.getId(block.plank)));
            generator.blockStateCollector
                    .accept(VariantsBlockStateSupplier.create(block)
                            .coordinate(
                                    BlockStateVariantMap.create(ChairBlock.FACING)
                                            .register(Direction.EAST, BlockStateVariant.create()
                                                    .put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.MODEL, identifier2))
                                            .register(Direction.SOUTH, BlockStateVariant.create()
                                                    .put(VariantSettings.Y, VariantSettings.Rotation.R180).put(VariantSettings.MODEL, identifier2))
                                            .register(Direction.NORTH, BlockStateVariant.create()
                                                    .put(VariantSettings.Y, VariantSettings.Rotation.R0).put(VariantSettings.MODEL, identifier2))
                                            .register(Direction.WEST, BlockStateVariant.create()
                                                    .put(VariantSettings.Y, VariantSettings.Rotation.R270).put(VariantSettings.MODEL, identifier2))
                            ));
        }
    }
}
