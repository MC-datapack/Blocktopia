package github.mcdatapack.blocktopia.item;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.FutureBlocks;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.block.LegacyBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Arrays;

import static github.mcdatapack.blocktopia.block.FutureBlocks.*;
import static github.mcdatapack.blocktopia.item.FutureItems.*;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.*;
import static github.mcdatapack.blocktopia.item.LegacyItems.*;
import static github.mcdatapack.blocktopia.item.ModItems.FUTURE_INGOT;

@SuppressWarnings("unused")
public interface ModItemGroups {
    RegistryKey<ItemGroup> LEGACY_BLOCKS_GROUP = register("legacy_blocks_group", FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.blocktopia.legacy_blocks"))
            .icon(LegacyBlocks.COBBLESTONE_RD20090515.asItem()::getDefaultStack)
            .entries((displayContext, entries) -> add(entries, COBBLESTONE_RD20090515, COBBLESTONE_C0_0_14A, COBBLESTONE_B1_7,
                    WOODEN_PLANKS_RD20090515, WOODEN_PLANKS_RD161348, WOODEN_PLANKS_C0_0_14A, WOODEN_PLANKS_C0_0_15A, WOODEN_PLANKS_B1_9PRE5,
                    SAPLING_RD161348, SAPLING_C0_0_13A, SAPLING_C0_24ST,
                    BEDROCK_C0_0_12A,
                    SAND_C0_0_14A, SAND_C0_0_15A, SAND_B1_9PRE6,
                    GRAVEL_C0_0_14A, GRAVEL_C0_0_15A, GRAVEL_B1_9PRE5, GRAVEL_1_3,
                    COAL_ORE_C0_0_14A, COAL_ORE_1_14,
                    IRON_ORE_C0_0_14A, IRON_ORE_1_14, IRON_ORE_1_14_1,
                    GOLD_ORE_C0_0_14A, GOLD_ORE_C0_26ST, GOLD_ORE_1_14,
                    LOG_C0_0_14A,
                    LEAVES_C0_0_14A, LEAVES_C0_0_15A, LEAVES_C0_24ST,
                    SPONGE_C0_0_19A, SPONGE_1_8,
                    WET_SPONGE_1_8,
                    GLASS_C0_0_19A,
                    WHITE_CLOTH,
                    LIGHT_GRAY_CLOTH_C0_0_20A, LIGHT_GRAY_CLOTH_C0_28A,
                    DARK_GRAY_CLOTH_C0_0_20A, DARK_GRAY_CLOTH_C0_28A,
                    RED_CLOTH,
                    ORANGE_CLOTH,
                    YELLOW_CLOTH,
                    CHARTREUSE_CLOTH,
                    SPRING_GREEN_CLOTH,
                    CYAN_CLOTH,
                    CAPRI_CLOTH,
                    ULTRAMARINE_CLOTH,
                    VIOLET_CLOTH,
                    PURPLE_CLOTH,
                    MAGENTA_CLOTH,
                    ROSE_CLOTH,
                    GOLD_BLOCK_C0_0_20A, GOLD_BLOCK_C0_26ST, GOLD_BLOCK_A1_2_0, GOLD_BLOCK_B1_9PRE5,
                    DANDELION_C0_0_20A,
                    ROSE_C0_0_20A,
                    POPPY_1_7,
                    RED_MUSHROOM_C0_0_20A,
                    BROWN_MUSHROOM_C0_0_20A,
                    STONE_SLAB_C0_26ST,
                    IRON_BLOCK_C0_26ST, IRON_BLOCK_A1_2_0, IRON_BLOCK_B1_9PRE5,
                    TNT_C0_26ST, TNT_C0_28A,
                    MOSSY_COBBLESTONE_C0_26ST, MOSSY_COBBLESTONE_B1_8,
                    BRICKS_C0_26ST, BRICKS_A1_0_11,
                    BOOKSHELF_C0_26ST, BOOKSHELF_B1_9PRE5,
                    OBSIDIAN_C0_28A,
                    TORCH_IN20100124_2,
                    DIAMOND_ORE_IN20100128, DIAMOND_ORE_1_14,
                    DIAMOND_BLOCK_IN20100128, DIAMOND_BLOCK_A1_2_0, DIAMOND_BLOCK_B1_9PRE5,
                    CRAFTING_TABLE_IN20100131, CRAFTING_TABLE_1_14,
                    FURNACE_IN20100219, FURNACE_B1_2,
                    WOODEN_DOOR_INF20100607,
                    SIGN_INF20100607,
                    LADDER_INF20100607, LADDER_INF20100618, RAIL_INF20100618,
                    WOODEN_STAIRS_RD20090515, WOODEN_STAIRS_RD161348, WOODEN_STAIRS_C0_0_14A, WOODEN_STAIRS_INF20100629, WOODEN_STAIRS_B1_9PRE5,
                    COBBLESTONE_STAIRS_RD20090515, COBBLESTONE_STAIRS_INF20100629, COBBLESTONE_STAIRS_B1_7,
                    REDSTONE_ORE_A1_0_1, REDSTONE_ORE_1_14,
                    REDSTONE_TORCH_A1_0_1,
                    SNOW_A1_0_4,
                    ICE_A1_0_4,
                    SNOW_BLOCK_A1_0_5,
                    WOODEN_FENCE_RD20090515, WOODEN_FENCE_RD161348, WOODEN_FENCE_C0_0_14A, WOODEN_FENCE_A1_0_17, WOODEN_FENCE_B1_9PRE5,
                    NETHERRACK_A1_2_0, NETHERRACK_B1_9PRE5,
                    SOUL_SAND_A1_2_0,
                    GLOWSTONE_A1_2_0, GLOWSTONE_B1_9PRE5,
                    CARVED_PUMPKIN_A1_2_0,
                    JACK_O_LANTERN_A1_2_0,
                    LIGHT_GRAY_WOOL_B1_2,
                    GRAY_WOOL_B1_2,
                    BLACK_WOOL_B1_2,
                    BROWN_WOOL_B1_2,
                    RED_WOOL_B1_2,
                    ORANGE_WOOL_B1_2,
                    YELLOW_WOOL_B1_2,
                    LIME_WOOL_B1_2 ,
                    GREEN_WOOL_B1_2,
                    CYAN_WOOL_B1_2 ,
                    LIGHT_BLUE_WOOL_B1_2,
                    BLUE_WOOL_B1_2 ,
                    PURPLE_WOOL_B1_2,
                    MAGENTA_WOOL_B1_2,
                    PINK_WOOL_B1_2,
                    LIGHT_GRAY_WOOL_1_2_4,
                    GRAY_WOOL_1_2_4,
                    BLACK_WOOL_1_2_4,
                    BROWN_WOOL_1_2_4,
                    RED_WOOL_1_2_4,
                    ORANGE_WOOL_1_2_4,
                    YELLOW_WOOL_1_2_4,
                    LIME_WOOL_1_2_4,
                    GREEN_WOOL_1_2_4,
                    CYAN_WOOL_1_2_4,
                    LIGHT_BLUE_WOOL_1_2_4,
                    BLUE_WOOL_1_2_4,
                    PURPLE_WOOL_1_2_4,
                    MAGENTA_WOOL_1_2_4,
                    PINK_WOOL_1_2_4,
                    CAKE_B1_2,
                    LAPIS_ORE_B1_2, LAPIS_ORE_1_14,
                    LAPIS_BLOCK_B1_2, LAPIS_BLOCK_1_6,
                    NOTE_BLOCK_B1_2,
                    SANDSTONE_B1_2, SANDSTONE_1_2_4,
                    BIRCH_LOG_B1_2, BIRCH_LOG_1_7,
                    BIRCH_LEAVES_B1_2,
                    SPRUCE_LOG_B1_2, SPRUCE_LOG_1_7,
                    SPRUCE_LEAVES_B1_2,
                    CRYING_OBSIDIAN_B1_3,
                    COBBLESTONE_SLAB_RD20090515, COBBLESTONE_SLAB_B1_3, COBBLESTONE_SLAB_B1_7,
                    WOODEN_SLAB_RD20090515, WOODEN_SLAB_RD161348, WOODEN_SLAB_C0_0_14A, WOODEN_SLAB_B1_3, WOODEN_SLAB_B1_9PRE5,
                    SANDSTONE_SLAB_B1_3, SANDSTONE_SLAB_1_2_4,
                    SMOOTH_STONE_B1_3,
                    BIRCH_SAPLING_B1_5,
                    SPRUCE_SAPLING_B1_5,
                    POWERED_RAIL_B1_5,
                    DETECTOR_RAIL_B1_5,
                    COBWEB_B1_5,
                    DEAD_BUSH_B1_6,
                    SHRUB_B1_6,
                    SHORT_GRASS_B1_6,
                    FERN_B1_6,
                    TRAPDOOR_B1_6,
                    STONE_BRICKS_B1_8,
                    CRACKED_STONE_BRICKS_B1_8,
                    MOSSY_STONE_BRICKS_B1_8,
                    INFESTED_COBBLESTONE_RD20090515,
                    INFESTED_COBBLESTONE_C0_0_14A,
                    INFESTED_COBBLESTONE_B1_8,
                    INFESTED_STONE_BRICKS_B1_8,
                    BRICK_SLAB_C0_26ST, BRICK_SLAB_B1_8,
                    STONE_BRICK_SLAB_B1_8,
                    BRICK_STAIRS_C0_26ST, BRICK_STAIRS_B1_8,
                    STONE_BRICK_STAIRS_B1_8,
                    GLASS_PANE_B1_8,
                    WOODEN_FENCE_GATE_RD20090515, WOODEN_FENCE_GATE_RD161348, WOODEN_FENCE_GATE_C0_0_14A, WOODEN_FENCE_GATE_B1_8, WOODEN_FENCE_GATE_B1_9PRE5,
                    VINES_B1_8,
                    MUSHROOM_STEM_B1_8,
                    RED_MUSHROOM_BLOCK_B1_8, BROWN_MUSHROOM_BLOCK_B1_8,
                    MELON_BLOCK_B1_8,
                    NETHER_BRICKS_B1_9PRE,
                    NETHER_BRICK_STAIRS_B1_9PRE,
                    NETHER_BRICK_FENCE_B1_9PRE,
                    LILY_PAD_B1_9PRE,
                    ENDSTONE_B1_9PRE4,
                    JUNGLE_LOG_1_2, JUNGLE_LOG_1_7,
                    JUNGLE_LEAVES_1_2,
                    JUNGLE_SAPLING_1_2,
                    REDSTONE_LAMP_1_2,
                    CHISELED_STONE_BRICKS_1_2,
                    BIRCH_PLANKS_1_2_4,
                    SPRUCE_PLANKS_1_2_4,
                    JUNGLE_PLANKS_1_2_4,
                    CUT_SANDSTONE_1_2_4,
                    CHISELED_SANDSTONE_1_2_4,
                    BIRCH_SLAB_1_3,
                    SPRUCE_SLAB_1_3,
                    JUNGLE_SLAB_1_3,
                    COCOA_1_3,
                    RUBY_ORE, EMERALD_ORE_1_3, EMERALD_ORE_1_14,
                    SANDSTONE_STAIRS_B1_2, SANDSTONE_STAIRS_1_3,
                    EMERALD_BLOCK_1_3,
                    BIRCH_STAIRS_1_3,
                    SPRUCE_STAIRS_1_3,
                    JUNGLE_STAIRS_1_3,
                    OAK_WOOD_1_3,
                    BIRCH_WOOD_1_3,
                    SPRUCE_WOOD_1_3,
                    JUNGLE_WOOD_1_3,
                    WOODEN_BUTTON_RD20090515, WOODEN_BUTTON_RD161348, WOODEN_BUTTON_C0_0_14A, WOODEN_BUTTON_C0_0_15A, WOODEN_BUTTON_1_4,
                    COBBLESTONE_WALL_RD20090515, COBBLESTONE_WALL_C0_0_14A, COBBLESTONE_WALL_1_4,
                    NETHER_BRICK_SLAB_1_4_6,
                    QUARTZ_ORE_1_5,
                    REDSTONE_BLOCK_1_5,
                    ACTIVATOR_RAIL_1_5,
                    QUARTZ_BLOCK_1_5,
                    CHISELED_QUARTZ_BLOCK_1_5,
                    QUARTZ_PILLAR_1_5,
                    QUARTZ_SLAB_1_5,
                    QUARTZ_STAIRS_1_5,
                    SMOOTH_SANDSTONE_1_5,
                    SMOOTH_QUARTZ_1_5,
                    WHITE_CLOTH_CARPET,
                    LIGHT_GRAY_CLOTH_CARPET_C0_0_20A,
                    LIGHT_GRAY_CLOTH_CARPET_C0_28A,
                    DARK_GRAY_CLOTH_CARPET_C0_0_20A,
                    DARK_GRAY_CLOTH_CARPET_C0_28A,
                    RED_CLOTH_CARPET,
                    ORANGE_CLOTH_CARPET,
                    YELLOW_CLOTH_CARPET,
                    CHARTREUSE_CLOTH_CARPET,
                    SPRING_GREEN_CLOTH_CARPET,
                    CYAN_CLOTH_CARPET,
                    CAPRI_CLOTH_CARPET,
                    ULTRAMARINE_CLOTH_CARPET,
                    VIOLET_CLOTH_CARPET,
                    PURPLE_CLOTH_CARPET,
                    MAGENTA_CLOTH_CARPET,
                    ROSE_CLOTH_CARPET,
                    GRAY_CARPET_B1_2,
                    BLACK_CARPET_B1_2,
                    BROWN_CARPET_B1_2,
                    RED_CARPET_B1_2,
                    ORANGE_CARPET_B1_2,
                    YELLOW_CARPET_B1_2,
                    LIME_CARPET_B1_2,
                    GREEN_CARPET_B1_2,
                    CYAN_CARPET_B1_2,
                    LIGHT_BLUE_CARPET_B1_2,
                    BLUE_CARPET_B1_2,
                    PURPLE_CARPET_B1_2,
                    MAGENTA_CARPET_B1_2,
                    PINK_CARPET_B1_2,
                    LIGHT_GRAY_CARPET_1_2_4,
                    GRAY_CARPET_1_2_4,
                    BLACK_CARPET_1_2_4,
                    BROWN_CARPET_1_2_4,
                    RED_CARPET_1_2_4,
                    ORANGE_CARPET_1_2_4,
                    YELLOW_CARPET_1_2_4,
                    LIME_CARPET_1_2_4,
                    GREEN_CARPET_1_2_4,
                    CYAN_CARPET_1_2_4,
                    LIGHT_BLUE_CARPET_1_2_4,
                    BLUE_CARPET_1_2_4,
                    PURPLE_CARPET_1_2_4,
                    MAGENTA_CARPET_1_2_4,
                    PINK_CARPET_1_2_4,
                    HAY_BALE_1_6,
                    TERRACOTTA_1_6,
                    COAL_BLOCK_1_6,
                    ALLIUM_1_7,
                    AZURE_BLUET_1_7,
                    BLUE_ORCHID_1_7,
                    LILAC_1_7,
                    PEONY_1_7,
                    ROSE_BUSH_1_7,
                    SUNFLOWER_1_7,
                    OXEYE_DAISY_1_7,
                    RED_TULIP_1_7,
                    ORANGE_TULIP_1_7,
                    WHITE_TULIP_1_7,
                    PINK_TULIP_1_7,
                    LARGE_FERN_1_7,
                    TALL_GRASS_1_7,
                    PACKED_ICE_1_7,
                    INFESTED_CRACKED_STONE_BRICKS_1_7,
                    INFESTED_MOSSY_STONE_BRICKS_1_7,
                    INFESTED_CHISELED_STONE_BRICKS_1_7,
                    RED_SAND_1_7,
                    WHITE_STAINED_GLASS_1_7,
                    ORANGE_STAINED_GLASS_1_7,
                    MAGENTA_STAINED_GLASS_1_7,
                    LIGHT_BLUE_STAINED_GLASS_1_7,
                    YELLOW_STAINED_GLASS_1_7,
                    LIME_STAINED_GLASS_1_7,
                    PINK_STAINED_GLASS_1_7,
                    GRAY_STAINED_GLASS_1_7,
                    LIGHT_GRAY_STAINED_GLASS_1_7,
                    CYAN_STAINED_GLASS_1_7,
                    PURPLE_STAINED_GLASS_1_7,
                    BLUE_STAINED_GLASS_1_7,
                    BROWN_STAINED_GLASS_1_7,
                    GREEN_STAINED_GLASS_1_7,
                    RED_STAINED_GLASS_1_7,
                    BLACK_STAINED_GLASS_1_7,
                    WHITE_STAINED_GLASS_PANE_1_7,
                    ORANGE_STAINED_GLASS_PANE_1_7,
                    MAGENTA_STAINED_GLASS_PANE_1_7,
                    LIGHT_BLUE_STAINED_GLASS_PANE_1_7,
                    YELLOW_STAINED_GLASS_PANE_1_7,
                    LIME_STAINED_GLASS_PANE_1_7,
                    PINK_STAINED_GLASS_PANE_1_7,
                    GRAY_STAINED_GLASS_PANE_1_7,
                    LIGHT_GRAY_STAINED_GLASS_PANE_1_7,
                    CYAN_STAINED_GLASS_PANE_1_7,
                    PURPLE_STAINED_GLASS_PANE_1_7,
                    BLUE_STAINED_GLASS_PANE_1_7,
                    BROWN_STAINED_GLASS_PANE_1_7,
                    GREEN_STAINED_GLASS_PANE_1_7,
                    RED_STAINED_GLASS_PANE_1_7,
                    BLACK_STAINED_GLASS_PANE_1_7,
                    ACACIA_LOG_1_7,
                    ACACIA_WOOD_1_7,
                    ACACIA_LEAVES_1_7,
                    ACACIA_SAPLING_1_7,
                    DARK_OAK_LOG_1_7,
                    DARK_OAK_WOOD_1_7,
                    DARK_OAK_LEAVES_1_7,
                    DARK_OAK_SAPLING_1_7,
                    ACACIA_PLANKS_1_7,
                    ACACIA_STAIRS_1_7,
                    ACACIA_SLAB_1_7,
                    DARK_OAK_PLANKS_1_7,
                    DARK_OAK_STAIRS_1_7,
                    DARK_OAK_SLAB_1_7,
                    GRANITE_1_8,
                    POLISHED_GRANITE_1_8,
                    DIORITE_1_8,
                    POLISHED_DIORITE_1_8,
                    ANDESITE_1_8,
                    POLISHED_ANDESITE_1_8,
                    SLIME_BLOCK_1_8,
                    PRISMARINE_1_8,
                    PRISMARINE_BRICKS_1_8,
                    DARK_PRISMARINE_1_8,
                    RED_SANDSTONE_1_8,
                    CUT_RED_SANDSTONE_1_8,
                    CHISELED_RED_SANDSTONE_1_8,
                    SMOOTH_RED_SANDSTONE_1_8,
                    RED_SANDSTONE_SLAB_1_8,
                    RED_SANDSTONE_STAIRS_1_8,
                    BIRCH_FENCE_1_8,
                    SPRUCE_FENCE_1_8,
                    JUNGLE_FENCE_1_8,
                    ACACIA_FENCE_1_8,
                    DARK_OAK_FENCE_1_8,
                    BIRCH_FENCE_GATE_1_8,
                    SPRUCE_FENCE_GATE_1_8,
                    JUNGLE_FENCE_GATE_1_8,
                    ACACIA_FENCE_GATE_1_8,
                    DARK_OAK_FENCE_GATE_1_8,
                    END_ROD_1_9,
                    ENDSTONE_BRICKS_1_9,
                    PURPUR_BLOCK_1_9,
                    PURPUR_PILLAR_1_9,
                    PURPUR_SLAB_1_9,
                    PURPUR_STAIRS_1_9,
                    BONE_BLOCK_1_10,
                    MAGMA_BLOCK_1_10,
                    NETHER_WART_BLOCK_1_10,
                    NETHER_WART_BLOCK_1_14,
                    RED_NETHER_BRICKS_1_10,
                    BIRCH_BUTTON_1_13,
                    SPRUCE_BUTTON_1_13,
                    JUNGLE_BUTTON_1_13,
                    ACACIA_BUTTON_1_13,
                    DARK_OAK_BUTTON_1_13,
                    BIRCH_PRESSURE_PLATE_1_13,
                    SPRUCE_PRESSURE_PLATE_1_13,
                    JUNGLE_PRESSURE_PLATE_1_13,
                    ACACIA_PRESSURE_PLATE_1_13,
                    DARK_OAK_PRESSURE_PLATE_1_13,
                    PRISMARINE_SLAB_1_13,
                    PRISMARINE_STAIRS_1_13
            )).build());
    RegistryKey<ItemGroup> LEGACY_ITEMS_GROUP = register("legacy_items_group", FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.blocktopia.legacy_items"))
            .icon(RUBY::getDefaultStack)
            .entries((displayContext, entries) -> add(entries,
                    QUIVER_IN20091231_2255, QUIVER_IN20100122_2251,
                    APPLE_IN20091231_2255, APPLE_1_4,
                    COAL_IN20100128, COAL_IN20100219, COAL_1_3,
                    DIAMOND_IN20100128, DIAMOND_1_3,
                    GOLD_INGOT_IN20100128, GOLD_INGOT_IN20100129,
                    IRON_INGOT_IN20100128, IRON_INGOT_IN20100129,
                    BOWL_IN20100130,
                    MUSHROOM_STEW_IN20100130,
                    SULPHUR,
                    STRING_IN20100130,
                    FEATHER_IN20100130, FEATHER_IN20100206,
                    BREAD_IN20100206, BREAD_1_4,
                    WHEAT_IN20100206,
                    FLINT_IN20100219, FLINT_1_3,
                    PORKCHOP_IN20100219, PORKCHOP_1_4,
                    COOKED_PORKCHOP_IN20100219, COOKED_PORKCHOP_B1_8, COOKED_PORKCHOP_1_4,
                    GOLDEN_APPLE_INF20100227,
                    LEATHER_A1_0_8,
                    PAPER_A1_0_11,
                    BOOK_A1_0_11,
                    CLAY_BALL_A1_0_11,
                    BRICK_A1_0_11,
                    SLIMEBALL_A1_0_11,
                    GLOWSTONE_DUST_A1_2_0,
                    FISH_A1_2_0,
                    COOKED_FISH_A1_2_0,
                    BONE_B1_2,
                    BONE_MEAL_B1_2,
                    BONE_MEAL_1_3,
                    COOKIE_B1_4,
                    CHICKEN_B1_8, CHICKEN_1_4,
                    COOKED_CHICKEN_B1_8, COOKED_CHICKEN_1_4,
                    BEEF_B1_8, BEEF_1_3, BEEF_1_4,
                    COOKED_BEEF_B1_8, COOKED_BEEF_1_3, COOKED_BEEF_1_4,
                    ROTTEN_FLESH_B1_8, ROTTEN_FLESH_1_3,
                    GHAST_TEAR_B1_9PRE,
                    GOLD_NUGGET_B1_9PRE,
                    GOLD_NUGGET_1_3,
                    BLAZE_POWDER_B1_9PRE2,
                    FERMENTED_SPIDER_EYE_B1_9PRE2,
                    MAGMA_CREAM_B1_9PRE2, MAGMA_CREAM_1_3,
                    SPIDER_EYE_B1_9PRE2,
                    GLISTERING_MELON_B1_9PRE4,
                    RUBY,
                    EMERALD_1_3,
                    ENCHANTED_GOLDEN_APPLE_1_3,
                    GOLDEN_CARROT_1_4,
                    BAKED_POTATO_1_4,
                    POISONOUS_POTATO_1_4,
                    NETHER_STAR_1_4,
                    PUMPKIN_PIE_1_4,
                    QUARTZ_1_5,
                    CLOWNFISH_1_7,
                    SALMON_1_7,
                    COOKED_SALMON_1_7,
                    PUFFERFISH_1_7,
                    PRISMARINE_CRYSTAL_1_8,
                    PRISMARINE_SHARD_1_8,
                    MUTTON_1_8,
                    COOKED_MUTTON_1_8,
                    RABBIT_1_8,
                    COOKED_RABBIT_1_8,
                    RABBIT_FOOT_1_8,
                    RABBIT_HIDE_1_8,
                    RABBIT_STEW_1_8
                ))
            .build());
    RegistryKey<ItemGroup> FUTURE_BLOCKS_AND_ITEMS = register("future_blocks_and_items", FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.blocktopia.future_blocks_and_items"))
            .icon(FutureBlocks.PALE_MOSS.asItem()::getDefaultStack)
            .entries((displayContext, entries) -> {
                add(entries, FUTURE_INGOT, PALE_OAK_LOG, STRIPPED_PALE_OAK_LOG, PALE_OAK_WOOD, STRIPPED_PALE_OAK_WOOD, PALE_OAK_LEAVES, PALE_OAK_SAPLING, PALE_OAK_PLANKS, PALE_OAK_DOOR, PALE_OAK_FENCE,
                        PALE_OAK_FENCE_GATE, PALE_OAK_STAIRS, PALE_OAK_SLAB, PALE_OAK_PRESSURE_PLATE, PALE_OAK_BUTTON, PALE_OAK_TRAPDOOR, PALE_OAK_SIGN, PALE_OAK_HANGING_SIGN, PALE_OAK_BOAT,
                        PALE_OAK_CHEST_BOAT, PALE_MOSS, PALE_MOSS_CARPET, PALE_HANGING_MOSS, CLOSED_EYEBLOSSOM, OPEN_EYEBLOSSOM, RESIN_CLUMP, RESIN_BRICK, RESIN_BLOCK, RESIN_BRICKS, RESIN_BRICK_STAIRS,
                        RESIN_BRICK_SLAB, RESIN_BRICK_WALL, CHISELED_RESIN_BRICKS, WILDFLOWERS, LEAF_LITTERS, SHORT_DRY_GRASS);
            })
            .build());
    RegistryKey<ItemGroup> NATURAL_BLOCKS_GROUP = register("natural_blocks_group", FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.blocktopia.natural_blocks"))
            .icon(ModBlocks.TROPICAL_MOSS.asItem()::getDefaultStack)
            .entries((displayContext, entries) -> {
                entries.add(ModBlocks.TROPICAL_MOSS);
                entries.add(ModBlocks.TROPICAL_MOSS_CARPET);
                entries.add(ModBlocks.SANDY_DIRT);
                entries.add(ModItems.TROPICAL_WATER_BUCKET);
                entries.add(ModBlocks.OAK_CHAIR[0]);
                entries.add(ModBlocks.SPRUCE_CHAIR[0]);
                entries.add(ModBlocks.BIRCH_CHAIR[0]);
                entries.add(ModBlocks.JUNGLE_CHAIR[0]);
                entries.add(ModBlocks.ACACIA_CHAIR[0]);
                entries.add(ModBlocks.DARK_OAK_CHAIR[0]);
                entries.add(ModBlocks.CRIMSON_CHAIR[0]);
                entries.add(ModBlocks.WARPED_CHAIR[0]);
                entries.add(ModBlocks.MANGROVE_CHAIR[0]);
                entries.add(ModBlocks.BAMBOO_CHAIR[0]);
                entries.add(ModBlocks.CHERRY_CHAIR[0]);
                entries.add(ModBlocks.PALM_LEAVES);
                entries.add(ModBlocks.PALM_SAPLING);
                entries.add(ModBlocks.PALM_LOG);
                entries.add(ModBlocks.STRIPPED_PALM_LOG);
                entries.add(ModBlocks.PALM_WOOD);
                entries.add(ModBlocks.STRIPPED_PALM_WOOD);
                entries.add(ModBlocks.PALM_PLANKS);
                entries.add(ModBlocks.PALM_STAIRS);
                entries.add(ModBlocks.PALM_SLAB);
                entries.add(ModBlocks.PALM_FENCE);
                entries.add(ModBlocks.PALM_FENCE_GATE);
                entries.add(ModBlocks.PALM_PRESSURE_PLATE);
                entries.add(ModBlocks.PALM_BUTTON);
                entries.add(ModBlocks.PALM_DOOR);
                entries.add(ModBlocks.PALM_TRAPDOOR);
                entries.add(ModBlocks.PALM_CHAIR[0]);
                entries.add(ModItems.PALM_BOAT);
                entries.add(ModItems.PALM_CHEST_BOAT);
                entries.add(ModBlocks.PALM_SIGN);
                entries.add(ModBlocks.PALM_HANGING_SIGN);
                entries.add(ModBlocks.BANANA_LEAVES);
                entries.add(ModBlocks.BANANA_SAPLING);
                entries.add(ModBlocks.BANANA_LOG);
                entries.add(ModBlocks.STRIPPED_BANANA_LOG);
                entries.add(ModBlocks.BANANA_WOOD);
                entries.add(ModBlocks.STRIPPED_BANANA_WOOD);
                entries.add(ModBlocks.BANANA_PLANKS);
                entries.add(ModBlocks.BANANA_STAIRS);
                entries.add(ModBlocks.BANANA_SLAB);
                entries.add(ModBlocks.BANANA_FENCE);
                entries.add(ModBlocks.BANANA_FENCE_GATE);
                entries.add(ModBlocks.BANANA_PRESSURE_PLATE);
                entries.add(ModBlocks.BANANA_BUTTON);
                entries.add(ModBlocks.BANANA_DOOR);
                entries.add(ModBlocks.BANANA_TRAPDOOR);
                entries.add(ModBlocks.BANANA_CHAIR[0]);
                entries.add(ModItems.BANANA_BOAT);
                entries.add(ModItems.BANANA_CHEST_BOAT);
                entries.add(ModBlocks.BANANA_SIGN);
                entries.add(ModBlocks.BANANA_HANGING_SIGN);
                entries.add(ModBlocks.CORN_LEAVES);
                entries.add(ModBlocks.CORN_SAPLING);
                entries.add(ModBlocks.CORN_LOG);
                entries.add(ModBlocks.STRIPPED_CORN_LOG);
                entries.add(ModBlocks.CORN_WOOD);
                entries.add(ModBlocks.STRIPPED_CORN_WOOD);
                entries.add(ModBlocks.CORN_PLANKS);
                entries.add(ModBlocks.CORN_STAIRS);
                entries.add(ModBlocks.CORN_SLAB);
                entries.add(ModBlocks.CORN_FENCE);
                entries.add(ModBlocks.CORN_FENCE_GATE);
                entries.add(ModBlocks.CORN_PRESSURE_PLATE);
                entries.add(ModBlocks.CORN_BUTTON);
                entries.add(ModBlocks.CORN_DOOR);
                entries.add(ModBlocks.CORN_TRAPDOOR);
                entries.add(ModBlocks.CORN_CHAIR[0]);
                entries.add(ModItems.CORN_BOAT);
                entries.add(ModItems.CORN_CHEST_BOAT);
                entries.add(ModBlocks.CORN_SIGN);
                entries.add(ModBlocks.CORN_HANGING_SIGN);
                entries.add(ModBlocks.POISONED_LEAVES);
                entries.add(ModBlocks.POISONED_SAPLING);
                entries.add(ModBlocks.POISONED_LOG);
                entries.add(ModBlocks.STRIPPED_POISONED_LOG);
                entries.add(ModBlocks.POISONED_WOOD);
                entries.add(ModBlocks.STRIPPED_POISONED_WOOD);
                entries.add(ModBlocks.POISONED_PLANKS);
                entries.add(ModBlocks.POISONED_STAIRS);
                entries.add(ModBlocks.POISONED_SLAB);
                entries.add(ModBlocks.POISONED_FENCE);
                entries.add(ModBlocks.POISONED_FENCE_GATE);
                entries.add(ModBlocks.POISONED_PRESSURE_PLATE);
                entries.add(ModBlocks.POISONED_BUTTON);
                entries.add(ModBlocks.POISONED_DOOR);
                entries.add(ModBlocks.POISONED_TRAPDOOR);
                entries.add(ModBlocks.POISONED_CHAIR[0]);
                entries.add(ModItems.POISONED_BOAT);
                entries.add(ModItems.POISONED_CHEST_BOAT);
                entries.add(ModBlocks.POISONED_SIGN);
                entries.add(ModBlocks.POISONED_HANGING_SIGN);
                entries.add(ModBlocks.MAHOGANY_LEAVES);
                entries.add(ModBlocks.MAHOGANY_SAPLING);
                entries.add(ModBlocks.MAHOGANY_LOG);
                entries.add(ModBlocks.STRIPPED_MAHOGANY_LOG);
                entries.add(ModBlocks.MAHOGANY_WOOD);
                entries.add(ModBlocks.STRIPPED_MAHOGANY_WOOD);
                entries.add(ModBlocks.MAHOGANY_PLANKS);
                entries.add(ModBlocks.MAHOGANY_STAIRS);
                entries.add(ModBlocks.MAHOGANY_SLAB);
                entries.add(ModBlocks.MAHOGANY_FENCE);
                entries.add(ModBlocks.MAHOGANY_FENCE_GATE);
                entries.add(ModBlocks.MAHOGANY_PRESSURE_PLATE);
                entries.add(ModBlocks.MAHOGANY_BUTTON);
                entries.add(ModBlocks.MAHOGANY_DOOR);
                entries.add(ModBlocks.MAHOGANY_TRAPDOOR);
                entries.add(ModBlocks.MAHOGANY_CHAIR[0]);
                entries.add(ModItems.MAHOGANY_BOAT);
                entries.add(ModItems.MAHOGANY_CHEST_BOAT);
                entries.add(ModBlocks.MAHOGANY_SIGN);
                entries.add(ModBlocks.MAHOGANY_HANGING_SIGN);
                entries.add(ModBlocks.FLOWERING_CHERRY_LEAVES);
                entries.add(ModBlocks.FLOWERING_CHERRY_SAPLING);
                entries.add(ModItems.CHERRY);
                entries.add(ModItems.GOLDEN_CHERRY);
                entries.add(ModItems.ENCHANTED_GOLDEN_CHERRY);
                entries.add(ModItems.DIAMOND_CHERRY);
                entries.add(ModItems.ENCHANTED_DIAMOND_CHERRY);
                entries.add(ModItems.NETHERITE_CHERRY);
                entries.add(ModItems.ENCHANTED_NETHERITE_CHERRY);
                entries.add(ModItems.DEEPSLATE_EMERALD_CHERRY);
                entries.add(ModItems.ENCHANTED_DEEPSLATE_EMERALD_CHERRY);
                entries.add(ModItems.END_DIAMOND_CHERRY);
                entries.add(ModItems.ENCHANTED_END_DIAMOND_CHERRY);
                entries.add(ModItems.COCONUT);
                entries.add(ModItems.GOLDEN_COCONUT);
                entries.add(ModItems.ENCHANTED_GOLDEN_COCONUT);
                entries.add(ModItems.BANANA);
                entries.add(ModBlocks.BANANA_CROP);
                entries.add(ModItems.ENCHANTED_GOLDEN_CARROT);
                entries.add(ModItems.GOLDEN_POTATO);
                entries.add(ModItems.ENCHANTED_GOLDEN_POTATO);
                entries.add(ModItems.GOLDEN_BAKED_POTATO);
                entries.add(ModItems.ENCHANTED_GOLDEN_BAKED_POTATO);
                entries.add(ModBlocks.GLOW_FLOWER);
            }).build());

    RegistryKey<ItemGroup> COLORED_BLOCKS_GROUP = register("colored_blocks", FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.blocktopia.colored_blocks"))
            .icon(ModBlocks.OAK_CHAIR[1].asItem()::getDefaultStack)
            .entries((displayContext, entries) -> {
                add(entries, ModBlocks.OAK_CHAIR);
                add(entries, ModBlocks.SPRUCE_CHAIR);
                add(entries, ModBlocks.BIRCH_CHAIR);
                add(entries, ModBlocks.JUNGLE_CHAIR);
                add(entries, ModBlocks.ACACIA_CHAIR);
                add(entries, ModBlocks.DARK_OAK_CHAIR);
                add(entries, ModBlocks.CRIMSON_CHAIR);
                add(entries, ModBlocks.WARPED_CHAIR);
                add(entries, ModBlocks.MANGROVE_CHAIR);
                add(entries, ModBlocks.BAMBOO_CHAIR);
                add(entries, ModBlocks.CHERRY_CHAIR);
                add(entries, ModBlocks.PALM_CHAIR);
                add(entries, ModBlocks.BANANA_CHAIR);
                add(entries, ModBlocks.CORN_CHAIR);
                add(entries, ModBlocks.POISONED_CHAIR);
                add(entries, ModBlocks.MAHOGANY_CHAIR);
                add(entries, ModBlocks.PALE_OAK_CHAIR);
            })
            .build());

    RegistryKey<ItemGroup> OTHER_ITEMS_AND_BLOCKS_GROUP = register("other_items_and_blocks", FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.blocktopia.other_items_and_blocks"))
            .icon(ModBlocks.SMALL_CHEST.asItem()::getDefaultStack)
            .entries((displayContext, entries) -> {
                entries.add(ModBlocks.GUNPOWDER_BLOCK);
                entries.add(ModBlocks.PAPER_BLOCK);
                entries.add(ModBlocks.FIREWORK_BLOCK);
                entries.add(ModBlocks.SMALL_CHEST);
                entries.add(ModBlocks.DUPER);
                entries.add(ModBlocks.LEGACY_CUTTER);
                entries.add(ModBlocks.WOODCUTTER);
                entries.add(ModBlocks.XP_TRAP);
                entries.add(ModBlocks.SPONGE_TNT);
                entries.add(ModBlocks.EXTENDED_REPEATER_TICK);
                entries.add(ModBlocks.EXTENDED_REPEATER_SECOND);
                entries.add(ModBlocks.EXTENDED_REPEATER_MINUTE);
                entries.add(ModItems.CREATIVE_INGOT);
                entries.add(ModItems.CREATIVE_NUGGET);
                entries.add(ModItems.GIANT_SPAWN_EGG);
                entries.add(ModItems.ILLUSIONER_SPAWN_EGG);
                entries.add(ModItems.MONKEY_SPAWN_EGG);
                entries.add(ModItems.RABBIT_TRINKET);
                entries.add(ModItems.FISH_TRINKET);
                entries.add(ModItems.CAT_TRINKET);
            })
            .build());

    private static void add(ItemGroup.Entries entries, ItemConvertible... items) {
        Arrays.stream(items).forEach(entries::add);
    }

    private static RegistryKey<ItemGroup> register(String name, ItemGroup itemGroup) {
        Registry.register(Registries.ITEM_GROUP, Blocktopia.id(name), itemGroup);
        return Registries.ITEM_GROUP.getKey(itemGroup).get();
    }

    static void load() {}
}
