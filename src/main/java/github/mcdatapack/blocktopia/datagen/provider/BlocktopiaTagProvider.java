package github.mcdatapack.blocktopia.datagen.provider;

import github.mcdatapack.blocktopia.entity.ModEntityTypes;
import github.mcdatapack.blocktopia.fluid.ModFluids;

import static github.mcdatapack.blocktopia.item.ModItems.*;
import static github.mcdatapack.blocktopia.block.ModBlocks.*;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.*;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.TORCH_IN20100124_2;
import static net.minecraft.block.Blocks.*;
import static net.minecraft.item.Items.*;

import github.mcdatapack.blocktopia.block.LegacyBlocks;
import github.mcdatapack.blocktopia.worldgen.biome.ModBiomes;
import github.mcdatapack.blocktopia.item.ModItems;
import github.mcdatapack.blocktopia.util.ModTags;

import java.util.concurrent.CompletableFuture;

import github.mcdatapack.blocktopia.villager.ModVillagers;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.poi.PointOfInterestType;

public class BlocktopiaTagProvider {
    public static class BlocktopiaBlockTagProvider extends FabricTagProvider.BlockTagProvider {
        public BlocktopiaBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                    .addTag(ModTags.Blocks.CHAIRS)
                    .add(SMALL_CHEST, BOOKSHELF_C0_26ST, BOOKSHELF_B1_9PRE5, CRAFTING_TABLE_IN20100131, CRAFTING_TABLE_1_14, LADDER_INF20100607, LADDER_INF20100618, CARVED_PUMPKIN_A1_2_0, JACK_O_LANTERN_A1_2_0);
            getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                    .add(PAPER_BLOCK)
                    .add(PALM_LEAVES, BANANA_LEAVES, CORN_LEAVES, POISONED_LEAVES, MAHOGANY_LEAVES, FLOWERING_CHERRY_LEAVES, LEAVES_C0_0_14A, LEAVES_C0_0_15A, LEAVES_C0_24ST, SPONGE_C0_0_19A, SPONGE_1_8, WET_SPONGE_1_8);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                    .add(COBBLESTONE_RD20090515, COBBLESTONE_C_0_0_14A, COBBLESTONE_B1_7, COAL_ORE_C0_0_14A, COAL_ORE_1_14, IRON_ORE_C0_0_14A, IRON_ORE_1_14, IRON_ORE_1_14_1, GOLD_ORE_C0_0_14A,
                            GOLD_ORE_C0_26ST, GOLD_ORE_1_14, GOLD_BLOCK_C0_0_20A, GOLD_BLOCK_C0_26ST, GOLD_BLOCK_A1_2_0, GOLD_BLOCK_B1_9PRE5, STONE_SLAB_C0_26ST, IRON_BLOCK_C0_26ST,
                            IRON_BLOCK_A1_2_0, IRON_BLOCK_B1_9PRE5, MOSSY_COBBLESTONE_C0_26ST, MOSSY_COBBLESTONE_B1_8, BRICKS_C0_26ST, BRICKS_A1_0_11, OBSIDIAN_C0_28A, DIAMOND_ORE_IN20100128,
                            DIAMOND_ORE_1_14, DIAMOND_BLOCK_IN20100128, DIAMOND_BLOCK_A1_2_0, DIAMOND_BLOCK_B1_9PRE5, FURNACE_IN20100219, LIT_FURNACE_IN20100219, FURNACE_B1_2, LIT_FURNACE_B1_2,
                            COBBLESTONE_STAIRS_RD20090515, COBBLESTONE_STAIRS_INF20100629, COBBLESTONE_STAIRS_B1_7, REDSTONE_ORE_A1_0_1, REDSTONE_ORE_1_14, ICE_A1_0_4, NETHERRACK_A1_2_0,
                            NETHERRACK_B1_9PRE5, GLOWSTONE_A1_2_0, GLOWSTONE_B1_9PRE5, LEGACY_CUTTER);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                    .add(SANDY_DIRT, GUNPOWDER_BLOCK, FIREWORK_BLOCK, SAND_C0_0_14A, SAND_C0_0_15A, SAND_B1_9PRE6, GRAVEL_C0_0_14A, GRAVEL_C0_0_15A, GRAVEL_B1_9PRE5, GRAVEL_1_3, SNOW_A1_0_4,
                            SNOW_BLOCK_A1_0_5, CLAY_BLOCK_A1_0_11, SOUL_SAND_A1_2_0);
            getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                    .add(OBSIDIAN_C0_28A);
            getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                    .add(GOLD_ORE_C0_0_14A, GOLD_ORE_C0_26ST, GOLD_ORE_1_14, GOLD_BLOCK_C0_0_20A, GOLD_BLOCK_C0_26ST, GOLD_BLOCK_A1_2_0, GOLD_BLOCK_B1_9PRE5, DIAMOND_ORE_IN20100128,
                            DIAMOND_ORE_1_14, DIAMOND_BLOCK_IN20100128, DIAMOND_BLOCK_A1_2_0, DIAMOND_BLOCK_B1_9PRE5, REDSTONE_ORE_A1_0_1, REDSTONE_ORE_1_14);
            getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                    .add(IRON_ORE_C0_0_14A, IRON_ORE_1_14, IRON_ORE_1_14_1, IRON_BLOCK_C0_26ST, IRON_BLOCK_A1_2_0, IRON_BLOCK_B1_9PRE5);
            getOrCreateTagBuilder(ModTags.Blocks.LEGACY_BLOCKS)
                    .add(COBBLESTONE_RD20090515, COBBLESTONE_C_0_0_14A, COBBLESTONE_B1_7, WOODEN_PLANKS_RD20090515, WOODEN_PLANKS_RD161348, WOODEN_PLANKS_C0_0_14A, WOODEN_PLANKS_C0_0_15A,
                            WOODEN_PLANKS_B1_9PRE5, SAPLING_RD161348, SAPLING_C0_0_13A, SAPLING_C0_24ST, BEDROCK_C0_0_12A, SAND_C0_0_14A, SAND_C0_0_15A, SAND_B1_9PRE6, GRAVEL_C0_0_14A,
                            GRAVEL_C0_0_15A, GRAVEL_B1_9PRE5, GRAVEL_1_3, COAL_ORE_C0_0_14A, COAL_ORE_1_14, IRON_ORE_C0_0_14A, IRON_ORE_1_14, IRON_ORE_1_14_1, GOLD_ORE_C0_0_14A, GOLD_ORE_C0_26ST,
                            GOLD_ORE_1_14, LOG_C0_0_14A, LEAVES_C0_0_14A, LEAVES_C0_0_15A, LEAVES_C0_24ST, SPONGE_C0_0_19A, SPONGE_1_8, WET_SPONGE_1_8, GLASS_C0_0_19A, WHITE_CLOTH,
                            LIGHT_GRAY_CLOTH_C0_0_20A, LIGHT_GRAY_CLOTH_C0_28A, DARK_GRAY_CLOTH_C0_0_20A, DARK_GRAY_CLOTH_C0_28A, RED_CLOTH, ORANGE_CLOTH, YELLOW_CLOTH, CHARTREUSE_CLOTH,
                            SPRING_GREEN_CLOTH, CYAN_CLOTH, CAPRI_CLOTH, ULTRAMARINE_CLOTH, VIOLET_CLOTH, PURPLE_CLOTH, MAGENTA_CLOTH, ROSE_CLOTH, GOLD_BLOCK_C0_0_20A, GOLD_BLOCK_C0_26ST,
                            GOLD_BLOCK_A1_2_0, GOLD_BLOCK_B1_9PRE5, DANDELION_C0_0_20A, ROSE_C0_0_20A, POPPY_1_7, RED_MUSHROOM_C0_0_20A, BROWN_MUSHROOM_C0_0_20A, STONE_SLAB_C0_26ST,
                            IRON_BLOCK_C0_26ST, IRON_BLOCK_A1_2_0, IRON_BLOCK_B1_9PRE5, TNT_C0_26ST, TNT_C0_28A, MOSSY_COBBLESTONE_C0_26ST, MOSSY_COBBLESTONE_B1_8, BRICKS_C0_26ST, BRICKS_A1_0_11,
                            BOOKSHELF_C0_26ST, BOOKSHELF_B1_9PRE5, OBSIDIAN_C0_28A, TORCH_IN20100124_2, WALL_TORCH_IN20100124_2, DIAMOND_ORE_IN20100128, DIAMOND_ORE_1_14, DIAMOND_BLOCK_IN20100128,
                            DIAMOND_BLOCK_A1_2_0, DIAMOND_BLOCK_B1_9PRE5, CRAFTING_TABLE_IN20100131, CRAFTING_TABLE_1_14, FURNACE_IN20100219, LIT_FURNACE_IN20100219, FURNACE_B1_2, LIT_FURNACE_B1_2,
                            LADDER_INF20100607, LADDER_INF20100618, WOODEN_DOOR_INF20100607, WOODEN_STAIRS_RD20090515, WOODEN_STAIRS_RD161348,
                            WOODEN_STAIRS_C0_0_14A, WOODEN_STAIRS_INF20100629, WOODEN_STAIRS_B1_9PRE5, COBBLESTONE_STAIRS_RD20090515, COBBLESTONE_STAIRS_INF20100629, COBBLESTONE_STAIRS_B1_7,
                            REDSTONE_ORE_A1_0_1, REDSTONE_ORE_1_14, LegacyBlocks.REDSTONE_TORCH_A1_0_1, REDSTONE_WALL_TORCH_A1_0_1, SNOW_A1_0_4, ICE_A1_0_4, SNOW_BLOCK_A1_0_5, CLAY_BLOCK_A1_0_11,
                            WOODEN_FENCE_RD20090515, WOODEN_FENCE_RD161348, WOODEN_FENCE_C0_0_14A, WOODEN_FENCE_A1_0_17, WOODEN_FENCE_B1_9PRE5, NETHERRACK_A1_2_0,
                            NETHERRACK_B1_9PRE5, SOUL_SAND_A1_2_0, GLOWSTONE_A1_2_0, GLOWSTONE_B1_9PRE5, CARVED_PUMPKIN_A1_2_0, JACK_O_LANTERN_A1_2_0);
            getOrCreateTagBuilder(ModTags.Blocks.PALM_LOGS)
                    .add(PALM_LOG, STRIPPED_PALM_LOG, PALM_WOOD, STRIPPED_PALM_WOOD);
            getOrCreateTagBuilder(ModTags.Blocks.GOLDEN_BLOCKS)
                    .add(Blocks.GOLD_BLOCK, GOLD_BLOCK_C0_0_20A, GOLD_BLOCK_C0_26ST, GOLD_BLOCK_A1_2_0, GOLD_BLOCK_B1_9PRE5);
            getOrCreateTagBuilder(ModTags.Blocks.IRON_BLOCKS)
                    .add(Blocks.IRON_BLOCK, IRON_BLOCK_C0_26ST, IRON_BLOCK_A1_2_0, IRON_BLOCK_B1_9PRE5);
            getOrCreateTagBuilder(ModTags.Blocks.DIAMOND_BLOCKS)
                    .add(Blocks.DIAMOND_BLOCK, DIAMOND_BLOCK_IN20100128, DIAMOND_BLOCK_A1_2_0, DIAMOND_BLOCK_B1_9PRE5);
            getOrCreateTagBuilder(ModTags.Blocks.LEGACY_COBBLESTONE)
                    .add(COBBLESTONE_RD20090515, COBBLESTONE_C_0_0_14A, COBBLESTONE_B1_7);
            getOrCreateTagBuilder(ModTags.Blocks.BANANA_LOGS)
                    .add(BANANA_LOG, STRIPPED_BANANA_LOG, BANANA_WOOD, STRIPPED_BANANA_WOOD);
            getOrCreateTagBuilder(ModTags.Blocks.CORN_LOGS)
                    .add(CORN_LOG, STRIPPED_CORN_LOG, CORN_WOOD, STRIPPED_CORN_WOOD);
            getOrCreateTagBuilder(ModTags.Blocks.POISONED_LOGS)
                    .add(POISONED_LOG, STRIPPED_POISONED_LOG, POISONED_WOOD, STRIPPED_POISONED_WOOD);
            getOrCreateTagBuilder(ModTags.Blocks.MAHOGANY_LOGS)
                    .add(MAHOGANY_LOG, STRIPPED_MAHOGANY_LOG, MAHOGANY_WOOD, STRIPPED_MAHOGANY_WOOD);
            getOrCreateTagBuilder(BlockTags.INFINIBURN_OVERWORLD)
                    .add(NETHERRACK_A1_2_0, NETHERRACK_B1_9PRE5);
            getOrCreateTagBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS)
                    .add(SOUL_SAND_A1_2_0);
            getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE)
                    .add(BEDROCK_C0_0_12A);
            getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                    .add(PALM_FENCE_GATE, BANANA_FENCE_GATE, CORN_FENCE_GATE, POISONED_FENCE_GATE, MAHOGANY_FENCE_GATE);
            getOrCreateTagBuilder(BlockTags.INFINIBURN_END)
                    .add(BEDROCK_C0_0_12A);
            getOrCreateTagBuilder(BlockTags.LEAVES)
                    .add(PALM_LEAVES, BANANA_LEAVES, CORN_LEAVES, POISONED_LEAVES, MAHOGANY_LEAVES, FLOWERING_CHERRY_LEAVES, LEAVES_C0_0_14A, LEAVES_C0_0_15A, LEAVES_C0_24ST);
            getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                    .addTag(ModTags.Blocks.PALM_LOGS).addTag(ModTags.Blocks.BANANA_LOGS).addTag(ModTags.Blocks.CORN_LOGS).addTag(ModTags.Blocks.POISONED_LOGS).addTag(ModTags.Blocks.MAHOGANY_LOGS)
                    .add(LOG_C0_0_14A);
            getOrCreateTagBuilder(BlockTags.PLANKS)
                    .add(PALM_PLANKS, BANANA_PLANKS, CORN_PLANKS, POISONED_PLANKS, MAHOGANY_PLANKS, WOODEN_PLANKS_RD20090515, WOODEN_PLANKS_RD161348, WOODEN_PLANKS_C0_0_14A, WOODEN_PLANKS_C0_0_15A, WOODEN_PLANKS_B1_9PRE5);
            getOrCreateTagBuilder(BlockTags.SAPLINGS)
                    .add(PALM_SAPLING, BANANA_SAPLING, CORN_SAPLING, POISONED_SAPLING, MAHOGANY_SAPLING, FLOWERING_CHERRY_SAPLING, SAPLING_RD161348, SAPLING_C0_0_13A, SAPLING_C0_24ST);
            getOrCreateTagBuilder(BlockTags.SLABS)
                    .add(STONE_SLAB_C0_26ST);
            getOrCreateTagBuilder(BlockTags.STAIRS)
                    .add(COBBLESTONE_STAIRS_RD20090515, COBBLESTONE_STAIRS_INF20100629, COBBLESTONE_STAIRS_B1_7);
            getOrCreateTagBuilder(BlockTags.WITHER_IMMUNE)
                    .add(BEDROCK_C0_0_12A);
            getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                    .add(PALM_BUTTON, BANANA_BUTTON, CORN_BUTTON, POISONED_BUTTON, MAHOGANY_BUTTON);
            getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                    .add(PALM_DOOR, BANANA_DOOR, CORN_DOOR, POISONED_DOOR, MAHOGANY_DOOR, WOODEN_DOOR_INF20100607);
            getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                    .add(PALM_FENCE, BANANA_FENCE, CORN_FENCE, POISONED_FENCE, MAHOGANY_FENCE, WOODEN_FENCE_RD20090515, WOODEN_FENCE_RD161348, WOODEN_FENCE_C0_0_14A, WOODEN_FENCE_A1_0_17, WOODEN_FENCE_B1_9PRE5);
            getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                    .add(PALM_PRESSURE_PLATE, BANANA_PRESSURE_PLATE, CORN_PRESSURE_PLATE, POISONED_PRESSURE_PLATE, MAHOGANY_PRESSURE_PLATE);
            getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                    .add(PALM_SLAB, BANANA_SLAB, CORN_SLAB, POISONED_SLAB, MAHOGANY_SLAB);
            getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                    .add(PALM_STAIRS, BANANA_STAIRS, CORN_STAIRS, POISONED_STAIRS, MAHOGANY_STAIRS, WOODEN_STAIRS_RD20090515, WOODEN_STAIRS_RD161348, WOODEN_STAIRS_C0_0_14A, WOODEN_STAIRS_INF20100629, WOODEN_STAIRS_B1_9PRE5);
            getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                    .add(PALM_TRAPDOOR, BANANA_TRAPDOOR, CORN_TRAPDOOR, POISONED_TRAPDOOR, MAHOGANY_TRAPDOOR);
            getOrCreateTagBuilder(BlockTags.WOOL)
                    .add(WHITE_CLOTH, LIGHT_GRAY_CLOTH_C0_0_20A, LIGHT_GRAY_CLOTH_C0_28A, DARK_GRAY_CLOTH_C0_0_20A, DARK_GRAY_CLOTH_C0_28A, RED_CLOTH, ORANGE_CLOTH, YELLOW_CLOTH, CHARTREUSE_CLOTH,
                            SPRING_GREEN_CLOTH, CYAN_CLOTH, CAPRI_CLOTH, ULTRAMARINE_CLOTH, VIOLET_CLOTH, PURPLE_CLOTH, MAGENTA_CLOTH, ROSE_CLOTH);
            getOrCreateTagBuilder(BlockTags.ENCHANTMENT_POWER_PROVIDER)
                    .add(BOOKSHELF_C0_26ST, BOOKSHELF_B1_9PRE5);
            getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                    .add(LADDER_INF20100607, LADDER_INF20100618);
            getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                    .add(GLOW_FLOWER);
            getOrCreateTagBuilder(ModTags.Blocks.CLASSIC_SPONGE_REPLACEABLE)
                    .add(Blocks.KELP, KELP_PLANT, Blocks.SEAGRASS, TALL_SEAGRASS, POWDER_SNOW);
            getOrCreateTagBuilder(ModTags.Blocks.CHAIRS)
                    .add(OAK_CHAIR)
                    .add(SPRUCE_CHAIR)
                    .add(BIRCH_CHAIR)
                    .add(JUNGLE_CHAIR)
                    .add(ACACIA_CHAIR)
                    .add(DARK_OAK_CHAIR)
                    .add(CRIMSON_CHAIR)
                    .add(WARPED_CHAIR)
                    .add(MANGROVE_CHAIR)
                    .add(BAMBOO_CHAIR)
                    .add(CHERRY_CHAIR)
                    .add(PALM_CHAIR)
                    .add(BANANA_CHAIR)
                    .add(CORN_CHAIR)
                    .add(POISONED_CHAIR)
                    .add(MAHOGANY_CHAIR);
            getOrCreateTagBuilder(BlockTags.MAINTAINS_FARMLAND)
                    .add(BANANA_CROP);
            getOrCreateTagBuilder(BlockTags.DIRT)
                    .add(SANDY_DIRT, TROPICAL_MOSS);
        }
    }

    public static class BlocktopiaItemTagProvider extends FabricTagProvider.ItemTagProvider {
        public BlocktopiaItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            getOrCreateTagBuilder(ConventionalItemTags.BUCKETS)
                    .add(TROPICAL_WATER_BUCKET);
            getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED)
                    .add(NETHERITE_INGOT, Items.NETHERITE_BLOCK);
            getOrCreateTagBuilder(ItemTags.EQUIPPABLE_ENCHANTABLE)
                    .add(asItem(CARVED_PUMPKIN_A1_2_0));
            getOrCreateTagBuilder(ItemTags.VANISHING_ENCHANTABLE)
                    .add(asItem(CARVED_PUMPKIN_A1_2_0));
            getOrCreateTagBuilder(ModTags.Items.LEGACY_BLOCKS)
                    .add(asItem(COBBLESTONE_RD20090515, COBBLESTONE_C_0_0_14A, COBBLESTONE_B1_7, WOODEN_PLANKS_RD20090515, WOODEN_PLANKS_RD161348,
                            WOODEN_PLANKS_C0_0_14A, WOODEN_PLANKS_C0_0_15A, WOODEN_PLANKS_B1_9PRE5, SAPLING_RD161348, SAPLING_C0_0_13A,
                            SAPLING_C0_24ST, BEDROCK_C0_0_12A, SAND_C0_0_14A, SAND_C0_0_15A, SAND_B1_9PRE6, GRAVEL_C0_0_14A,
                            GRAVEL_C0_0_15A, GRAVEL_B1_9PRE5, GRAVEL_1_3, COAL_ORE_C0_0_14A, COAL_ORE_1_14, IRON_ORE_C0_0_14A,
                            IRON_ORE_1_14, IRON_ORE_1_14_1, GOLD_ORE_C0_0_14A, GOLD_ORE_C0_26ST, GOLD_ORE_1_14, LOG_C0_0_14A,
                            LEAVES_C0_0_14A, LEAVES_C0_0_15A, LEAVES_C0_24ST, SPONGE_C0_0_19A, SPONGE_1_8, WET_SPONGE_1_8,
                            GLASS_C0_0_19A, WHITE_CLOTH, LIGHT_GRAY_CLOTH_C0_0_20A, LIGHT_GRAY_CLOTH_C0_28A, DARK_GRAY_CLOTH_C0_0_20A,
                            DARK_GRAY_CLOTH_C0_28A, RED_CLOTH, ORANGE_CLOTH, YELLOW_CLOTH, CHARTREUSE_CLOTH, SPRING_GREEN_CLOTH,
                            CYAN_CLOTH, CAPRI_CLOTH, ULTRAMARINE_CLOTH, VIOLET_CLOTH, PURPLE_CLOTH, MAGENTA_CLOTH, ROSE_CLOTH,
                            GOLD_BLOCK_C0_0_20A, GOLD_BLOCK_C0_26ST, GOLD_BLOCK_A1_2_0, GOLD_BLOCK_B1_9PRE5, DANDELION_C0_0_20A, ROSE_C0_0_20A,
                            POPPY_1_7, RED_MUSHROOM_C0_0_20A, BROWN_MUSHROOM_C0_0_20A, STONE_SLAB_C0_26ST, IRON_BLOCK_C0_26ST, IRON_BLOCK_A1_2_0,
                            IRON_BLOCK_B1_9PRE5, TNT_C0_26ST, TNT_C0_28A, MOSSY_COBBLESTONE_C0_26ST, MOSSY_COBBLESTONE_B1_8, BRICKS_C0_26ST,
                            BRICKS_A1_0_11, BOOKSHELF_C0_26ST, BOOKSHELF_B1_9PRE5, OBSIDIAN_C0_28A, TORCH_IN20100124_2, DIAMOND_ORE_IN20100128,
                            DIAMOND_ORE_1_14, DIAMOND_BLOCK_IN20100128, DIAMOND_BLOCK_A1_2_0, DIAMOND_BLOCK_B1_9PRE5, CRAFTING_TABLE_IN20100131,
                            CRAFTING_TABLE_1_14, FURNACE_IN20100219, LIT_FURNACE_IN20100219, FURNACE_B1_2, LIT_FURNACE_B1_2, LADDER_INF20100607,
                            LADDER_INF20100618, WOODEN_DOOR_INF20100607, WOODEN_STAIRS_RD20090515, WOODEN_STAIRS_RD161348,
                            WOODEN_STAIRS_C0_0_14A, WOODEN_STAIRS_INF20100629, WOODEN_STAIRS_B1_9PRE5, COBBLESTONE_STAIRS_RD20090515,
                            COBBLESTONE_STAIRS_INF20100629, COBBLESTONE_B1_7, REDSTONE_ORE_A1_0_1, REDSTONE_ORE_1_14, REDSTONE_TORCH_A1_0_1,
                            REDSTONE_WALL_TORCH_A1_0_1, SNOW_A1_0_4, ICE_A1_0_4, SNOW_BLOCK_A1_0_5, CLAY_BLOCK_A1_0_11, WOODEN_FENCE_RD20090515,
                            WOODEN_FENCE_RD161348, WOODEN_FENCE_C0_0_14A, WOODEN_FENCE_A1_0_17, WOODEN_FENCE_B1_9PRE5, NETHERRACK_A1_2_0,
                            NETHERRACK_B1_9PRE5, SOUL_SAND_A1_2_0, GLOWSTONE_A1_2_0, GLOWSTONE_B1_9PRE5, CARVED_PUMPKIN_A1_2_0,
                            JACK_O_LANTERN_A1_2_0));
            getOrCreateTagBuilder(ModTags.Items.PALM_LOGS)
                    .add(asItem(PALM_LOG, STRIPPED_PALM_LOG, PALM_WOOD, STRIPPED_PALM_WOOD));
            getOrCreateTagBuilder(ModTags.Items.GOLDEN_BLOCKS)
                    .add(asItem(Items.GOLD_BLOCK, GOLD_BLOCK_C0_0_20A, GOLD_BLOCK_C0_26ST, GOLD_BLOCK_A1_2_0, GOLD_BLOCK_B1_9PRE5));
            getOrCreateTagBuilder(ModTags.Items.IRON_BLOCKS)
                    .add(asItem(Items.IRON_BLOCK, IRON_BLOCK_C0_26ST, IRON_BLOCK_A1_2_0, IRON_BLOCK_B1_9PRE5));
            getOrCreateTagBuilder(ModTags.Items.DIAMOND_BLOCKS)
                    .add(asItem(Items.DIAMOND_BLOCK, DIAMOND_BLOCK_IN20100128, DIAMOND_BLOCK_A1_2_0, DIAMOND_BLOCK_B1_9PRE5));
            getOrCreateTagBuilder(ModTags.Items.LEGACY_COBBLESTONE)
                    .add(asItem(COBBLESTONE_RD20090515, COBBLESTONE_C_0_0_14A, COBBLESTONE_B1_7));
            getOrCreateTagBuilder(ModTags.Items.BANANA_LOGS)
                    .add(asItem(BANANA_LOG, STRIPPED_BANANA_LOG, BANANA_WOOD, STRIPPED_BANANA_WOOD));
            getOrCreateTagBuilder(ModTags.Items.CORN_LOGS)
                    .add(asItem(CORN_LOG, STRIPPED_CORN_LOG, CORN_WOOD, STRIPPED_CORN_WOOD));
            getOrCreateTagBuilder(ModTags.Items.POISONED_LOGS)
                    .add(asItem(POISONED_LOG, STRIPPED_POISONED_LOG, POISONED_WOOD, STRIPPED_POISONED_WOOD));
            getOrCreateTagBuilder(ModTags.Items.MAHOGANY_LOGS)
                    .add(asItem(MAHOGANY_LOG, STRIPPED_MAHOGANY_LOG, MAHOGANY_WOOD, STRIPPED_MAHOGANY_WOOD));
            getOrCreateTagBuilder(ItemTags.FENCES)
                    .add(asItem(PALM_FENCE, BANANA_FENCE, CORN_FENCE, POISONED_FENCE, MAHOGANY_FENCE, WOODEN_FENCE_RD161348, WOODEN_FENCE_C0_0_14A, WOODEN_FENCE_A1_0_17, WOODEN_FENCE_B1_9PRE5));
            getOrCreateTagBuilder(ItemTags.BOATS)
                    .add(ModItems.PALM_BOAT, BANANA_BOAT, CORN_BOAT, POISONED_BOAT, MAHOGANY_BOAT);
            getOrCreateTagBuilder(ItemTags.CHEST_BOATS)
                    .add(ModItems.PALM_CHEST_BOAT, BANANA_CHEST_BOAT, CORN_CHEST_BOAT, POISONED_CHEST_BOAT, MAHOGANY_CHEST_BOAT);
            getOrCreateTagBuilder(ItemTags.LEAVES)
                    .add(asItem(PALM_LEAVES, BANANA_LEAVES, CORN_LEAVES, POISONED_LEAVES, MAHOGANY_LEAVES, FLOWERING_CHERRY_LEAVES, LEAVES_C0_0_14A, LEAVES_C0_0_15A, LEAVES_C0_24ST));
            getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                    .addTag(ModTags.Items.PALM_LOGS).addTag(ModTags.Items.BANANA_LOGS).addTag(ModTags.Items.CORN_LOGS).addTag(ModTags.Items.POISONED_LOGS).addTag(ModTags.Items.MAHOGANY_LOGS)
                    .add(asItem(LOG_C0_0_14A));
            getOrCreateTagBuilder(ItemTags.PLANKS)
                    .add(asItem(PALM_PLANKS, BANANA_PLANKS, CORN_PLANKS, POISONED_PLANKS, MAHOGANY_PLANKS, WOODEN_PLANKS_RD20090515, WOODEN_PLANKS_RD161348, WOODEN_PLANKS_C0_0_14A,
                            WOODEN_PLANKS_C0_0_15A, WOODEN_PLANKS_B1_9PRE5));
            getOrCreateTagBuilder(ItemTags.SAPLINGS)
                    .add(asItem(PALM_SAPLING, BANANA_SAPLING, CORN_SAPLING, POISONED_SAPLING, MAHOGANY_SAPLING, FLOWERING_CHERRY_SAPLING, SAPLING_RD161348, SAPLING_C0_0_13A, SAPLING_C0_24ST));
            getOrCreateTagBuilder(ItemTags.SLABS)
                    .add(asItem(STONE_SLAB_C0_26ST));
            getOrCreateTagBuilder(ItemTags.STAIRS)
                    .add(asItem(COBBLESTONE_STAIRS_RD20090515, COBBLESTONE_STAIRS_INF20100629, COBBLESTONE_STAIRS_B1_7));
            getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                    .add(asItem(PALM_BUTTON, BANANA_BUTTON, CORN_BUTTON, POISONED_BUTTON, MAHOGANY_BUTTON));
            getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                    .add(asItem(PALM_DOOR, BANANA_DOOR, CORN_DOOR, POISONED_DOOR, MAHOGANY_DOOR, WOODEN_DOOR_INF20100607));
            getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                    .add(asItem(PALM_FENCE, BANANA_FENCE));
            getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                    .add(asItem(PALM_PRESSURE_PLATE, BANANA_PRESSURE_PLATE, CORN_PRESSURE_PLATE, POISONED_PRESSURE_PLATE, MAHOGANY_PRESSURE_PLATE));
            getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                    .add(asItem(PALM_SLAB, BANANA_SLAB, CORN_SLAB, POISONED_SLAB, MAHOGANY_SLAB));
            getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                    .add(asItem(PALM_STAIRS, BANANA_STAIRS, CORN_STAIRS, POISONED_STAIRS, MAHOGANY_STAIRS, WOODEN_STAIRS_RD20090515, WOODEN_STAIRS_RD161348, WOODEN_STAIRS_C0_0_14A,
                            WOODEN_STAIRS_INF20100629, WOODEN_STAIRS_B1_9PRE5));
            getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
                    .add(asItem(PALM_TRAPDOOR, BANANA_TRAPDOOR, CORN_TRAPDOOR, POISONED_TRAPDOOR, MAHOGANY_TRAPDOOR));
            getOrCreateTagBuilder(ItemTags.WOOL)
                    .add(asItem(WHITE_CLOTH, LIGHT_GRAY_CLOTH_C0_0_20A, LIGHT_GRAY_CLOTH_C0_28A, DARK_GRAY_CLOTH_C0_0_20A, DARK_GRAY_CLOTH_C0_28A,
                            RED_CLOTH, ORANGE_CLOTH, YELLOW_CLOTH, CHARTREUSE_CLOTH, SPRING_GREEN_CLOTH, CYAN_CLOTH, CAPRI_CLOTH,
                            ULTRAMARINE_CLOTH, VIOLET_CLOTH, PURPLE_CLOTH, MAGENTA_CLOTH, ROSE_CLOTH));
            getOrCreateTagBuilder(ModTags.Items.MONKEY_BREEDING_ITEMS)
                    .add(COCONUT, BANANA);

            getOrCreateTagBuilder(ModTags.Items.CHAIRS)
                    .add(asItem(OAK_CHAIR))
                    .add(asItem(SPRUCE_CHAIR))
                    .add(asItem(BIRCH_CHAIR))
                    .add(asItem(JUNGLE_CHAIR))
                    .add(asItem(ACACIA_CHAIR))
                    .add(asItem(DARK_OAK_CHAIR))
                    .add(asItem(CRIMSON_CHAIR))
                    .add(asItem(WARPED_CHAIR))
                    .add(asItem(MANGROVE_CHAIR))
                    .add(asItem(BAMBOO_CHAIR))
                    .add(asItem(CHERRY_CHAIR))
                    .add(asItem(PALM_CHAIR))
                    .add(asItem(BANANA_CHAIR))
                    .add(asItem(CORN_CHAIR))
                    .add(asItem(POISONED_CHAIR))
                    .add(asItem(MAHOGANY_CHAIR));


            getOrCreateTagBuilder(ModTags.TrinketTags.RABBIT_SLOT)
                    .add(RABBIT, COOKED_RABBIT, RABBIT_HIDE, RABBIT_FOOT, RABBIT_TRINKET);
            getOrCreateTagBuilder(ModTags.TrinketTags.FISH_SLOT)
                    .add(FISH_TRINKET, COD, SALMON, TROPICAL_FISH, PUFFERFISH, COD_BUCKET, SALMON_BUCKET, TROPICAL_FISH_BUCKET, PUFFERFISH_BUCKET, COOKED_COD, COOKED_SALMON);
            getOrCreateTagBuilder(ModTags.TrinketTags.CAT_SLOT)
                    .add(CAT_TRINKET);

            getOrCreateTagBuilder(ModTags.Items.BOW_LOOTING_ENCHANTABLE)
                    .forceAddTag(ItemTags.SWORD_ENCHANTABLE).forceAddTag(ItemTags.BOW_ENCHANTABLE);
        }

        Item[] asItem(ItemConvertible... blocks) {
            Item[] items = new Item[blocks.length];
            for (int i = 0; i < blocks.length; i++) {
                items[i] = blocks[i].asItem();
            }
            return items;
        }
    }

    public static class BlocktopiaFluidTagProvider extends FabricTagProvider.FluidTagProvider {
        public BlocktopiaFluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            getOrCreateTagBuilder(ModTags.Fluids.CLASSIC_SPONGE_ABSORB)
                    .add(Fluids.WATER, Fluids.FLOWING_WATER, Fluids.LAVA, Fluids.FLOWING_LAVA, ModFluids.TROPICAL_WATER, ModFluids.FLOWING_TROPICAL_WATER);
            getOrCreateTagBuilder(FluidTags.WATER)
                    .add(ModFluids.TROPICAL_WATER, ModFluids.FLOWING_TROPICAL_WATER);
            getOrCreateTagBuilder(ModTags.Fluids.TROPICAL_WATER)
                    .add(ModFluids.TROPICAL_WATER, ModFluids.FLOWING_TROPICAL_WATER);
        }
    }

    public static class BlocktopiaBiomeTagProvider extends FabricTagProvider<Biome> {
        public BlocktopiaBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, RegistryKeys.BIOME, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            getOrCreateTagBuilder(ModTags.Biomes.HAS_BANANA_TREE_HOUSE)
                    .add(ModBiomes.RAIN_FOREST_KEY);
            getOrCreateTagBuilder(ModTags.Biomes.HAS_MAHOGANY_TREE_HOUSE)
                    .add(ModBiomes.RAIN_FOREST_KEY);
            getOrCreateTagBuilder(ModTags.Biomes.HAS_FLOWERING_TREE_CHERRY_HOUSE)
                    .add(ModBiomes.RAIN_FOREST_KEY);
            getOrCreateTagBuilder(ModTags.Biomes.HAS_CORN_TREE_HOUSE)
                    .add(ModBiomes.RAIN_FOREST_KEY);
            getOrCreateTagBuilder(ModTags.Biomes.HAS_POISONED_TREE_HOUSE)
                    .add(ModBiomes.RAIN_FOREST_KEY);
        }
    }

    public static class BlocktopiaPOITagProvider extends FabricTagProvider<PointOfInterestType> {
        public BlocktopiaPOITagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, RegistryKeys.POINT_OF_INTEREST_TYPE, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE)
                    .add(ModVillagers.LEGACY_POI, ModVillagers.BEEKEEPER_POI);
        }
    }

    public static class BlocktopiaEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {
        public BlocktopiaEntityTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            getOrCreateTagBuilder(EntityTypeTags.FALL_DAMAGE_IMMUNE)
                    .add(ModEntityTypes.MONKEY);
            getOrCreateTagBuilder(EntityTypeTags.WITHER_FRIENDS)
                    .add(ModEntityTypes.MONKEY);
        }
    }
}
