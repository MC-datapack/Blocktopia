package github.mcdatapack.blocktopia.datagen.provider;

import github.mcdatapack.blocktopia.init.EntityInit;
import github.mcdatapack.blocktopia.init.FluidInit;
import github.mcdatapack.blocktopia.init.ItemInit;

import static github.mcdatapack.blocktopia.init.ItemInit.*;
import static github.mcdatapack.blocktopia.init.ItemInit.REDSTONE_TORCH_A1_0_1;
import static github.mcdatapack.blocktopia.init.blocks.BlockInit.*;
import static github.mcdatapack.blocktopia.init.blocks.LegacyBlocks.*;
import static github.mcdatapack.blocktopia.init.blocks.LegacyBlocks.TORCH_IN20100124_2;
import static net.minecraft.block.Blocks.*;
import static net.minecraft.item.Items.*;

import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import github.mcdatapack.blocktopia.init.worldgen.BiomeInit;
import github.mcdatapack.blocktopia.list.TagList;
import java.util.concurrent.CompletableFuture;

import github.mcdatapack.blocktopia.list.TrinketTags;
import github.mcdatapack.blocktopia.init.VillagerInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.*;
import net.minecraft.util.Identifier;
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
                    .addTag(TagList.Blocks.CHAIRS)
                    .add(SMALL_CHEST, BOOKSHELF_C0_26ST, BOOKSHELF_B1_9PRE5, CRAFTING_TABLE_IN20100131, CRAFTING_TABLE_1_14, LADDER_INF20100607, LADDER_INF20100618, CARVED_PUMPKIN_A1_2_0, JACK_O_LANTERN_A1_2_0);
            getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                    .add(PAPER_BLOCK)
                    .add(PALM_LEAVES, BANANA_LEAVES, CORN_LEAVES, POISONED_LEAVES, FLOWERING_CHERRY_LEAVES, LEAVES_C0_0_14A, LEAVES_C0_0_15A, LEAVES_C0_24ST, SPONGE_C0_0_19A, SPONGE_1_8, WET_SPONGE_1_8);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                    .add(COBBLESTONE_RD20090515, COBBLESTONE_C_0_0_14A, COBBLESTONE_B1_7, COAL_ORE_C0_0_14A, COAL_ORE_1_14, IRON_ORE_C0_0_14A, IRON_ORE_1_14, IRON_ORE_1_14_1, GOLD_ORE_C0_0_14A,
                            GOLD_ORE_C0_26ST, GOLD_ORE_1_14, GOLD_BLOCK_C0_0_20A, GOLD_BLOCK_C0_26ST, GOLD_BLOCK_A1_2_0, GOLD_BLOCK_B1_9PRE5, STONE_SLAB_C0_26ST, IRON_BLOCK_C0_26ST,
                            IRON_BLOCK_A1_2_0, IRON_BLOCK_B1_9PRE5, MOSSY_COBBLESTONE_C0_26ST, MOSSY_COBBLESTONE_B1_8, BRICKS_C0_26ST, BRICKS_A1_0_11, OBSIDIAN_C0_28A, DIAMOND_ORE_IN20100128,
                            DIAMOND_ORE_1_14, DIAMOND_BLOCK_IN20100128, DIAMOND_BLOCK_A1_2_0, DIAMOND_BLOCK_B1_9PRE5, FURNACE_IN20100219, LIT_FURNACE_IN20100219, FURNACE_B1_2, LIT_FURNACE_B1_2,
                            COBBLESTONE_STAIRS_RD20090515, COBBLESTONE_STAIRS_C0_0_14A, COBBLESTONE_STAIRS_B1_7, REDSTONE_ORE_A1_0_1, REDSTONE_ORE_1_14, ICE_A1_0_4, NETHERRACK_A1_2_0,
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
            getOrCreateTagBuilder(TagList.Blocks.LEGACY_BLOCKS)
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
                            WOODEN_STAIRS_C0_0_14A, WOODEN_STAIRS_INF20100629, WOODEN_STAIRS_B1_9PRE5, COBBLESTONE_STAIRS_RD20090515, COBBLESTONE_STAIRS_C0_0_14A, COBBLESTONE_STAIRS_B1_7,
                            REDSTONE_ORE_A1_0_1, REDSTONE_ORE_1_14, LegacyBlocks.REDSTONE_TORCH_A1_0_1, REDSTONE_WALL_TORCH_A1_0_1, SNOW_A1_0_4, ICE_A1_0_4, SNOW_BLOCK_A1_0_5, CLAY_BLOCK_A1_0_11,
                            WOODEN_FENCE_RD20090515, WOODEN_FENCE_RD161348, WOODEN_FENCE_C0_0_14A, WOODEN_FENCE_A1_0_17, WOODEN_FENCE_B1_9PRE5, NETHERRACK_A1_2_0,
                            NETHERRACK_B1_9PRE5, SOUL_SAND_A1_2_0, GLOWSTONE_A1_2_0, GLOWSTONE_B1_9PRE5, CARVED_PUMPKIN_A1_2_0, JACK_O_LANTERN_A1_2_0);
            getOrCreateTagBuilder(TagList.Blocks.PALM_LOGS)
                    .add(PALM_LOG, STRIPPED_PALM_LOG, PALM_WOOD, STRIPPED_PALM_WOOD);
            getOrCreateTagBuilder(TagList.Blocks.GOLDEN_BLOCKS)
                    .add(Blocks.GOLD_BLOCK, GOLD_BLOCK_C0_0_20A, GOLD_BLOCK_C0_26ST, GOLD_BLOCK_A1_2_0, GOLD_BLOCK_B1_9PRE5);
            getOrCreateTagBuilder(TagList.Blocks.IRON_BLOCKS)
                    .add(Blocks.IRON_BLOCK, IRON_BLOCK_C0_26ST, IRON_BLOCK_A1_2_0, IRON_BLOCK_B1_9PRE5);
            getOrCreateTagBuilder(TagList.Blocks.DIAMOND_BLOCKS)
                    .add(Blocks.DIAMOND_BLOCK, DIAMOND_BLOCK_IN20100128, DIAMOND_BLOCK_A1_2_0, DIAMOND_BLOCK_B1_9PRE5);
            getOrCreateTagBuilder(TagList.Blocks.LEGACY_COBBLESTONE)
                    .add(COBBLESTONE_RD20090515, COBBLESTONE_C_0_0_14A, COBBLESTONE_B1_7);
            getOrCreateTagBuilder(TagList.Blocks.BANANA_LOGS)
                    .add(BANANA_LOG, STRIPPED_BANANA_LOG, BANANA_WOOD, STRIPPED_BANANA_WOOD);
            getOrCreateTagBuilder(TagList.Blocks.CORN_LOGS)
                    .add(CORN_LOG, STRIPPED_CORN_LOG, CORN_WOOD, STRIPPED_CORN_WOOD);
            getOrCreateTagBuilder(TagList.Blocks.POISONED_LOGS)
                    .add(POISONED_LOG, STRIPPED_POISONED_LOG, POISONED_WOOD, STRIPPED_POISONED_WOOD);
            getOrCreateTagBuilder(BlockTags.INFINIBURN_OVERWORLD)
                    .add(NETHERRACK_A1_2_0, NETHERRACK_B1_9PRE5);
            getOrCreateTagBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS)
                    .add(SOUL_SAND_A1_2_0);
            getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE)
                    .add(BEDROCK_C0_0_12A);
            getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                    .add(PALM_FENCE_GATE, BANANA_FENCE_GATE, CORN_FENCE_GATE, POISONED_FENCE_GATE);
            getOrCreateTagBuilder(BlockTags.INFINIBURN_END)
                    .add(BEDROCK_C0_0_12A);
            getOrCreateTagBuilder(BlockTags.LEAVES)
                    .add(PALM_LEAVES, BANANA_LEAVES, CORN_LEAVES, POISONED_LEAVES, FLOWERING_CHERRY_LEAVES, LEAVES_C0_0_14A, LEAVES_C0_0_15A, LEAVES_C0_24ST);
            getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                    .addTag(TagList.Blocks.PALM_LOGS).addTag(TagList.Blocks.BANANA_LOGS).addTag(TagList.Blocks.CORN_LOGS).addTag(TagList.Blocks.POISONED_LOGS)
                    .add(LOG_C0_0_14A);
            getOrCreateTagBuilder(BlockTags.PLANKS)
                    .add(PALM_PLANKS, BANANA_PLANKS, CORN_PLANKS, POISONED_PLANKS, WOODEN_PLANKS_RD20090515, WOODEN_PLANKS_RD161348, WOODEN_PLANKS_C0_0_14A, WOODEN_PLANKS_C0_0_15A, WOODEN_PLANKS_B1_9PRE5);
            getOrCreateTagBuilder(BlockTags.SAPLINGS)
                    .add(PALM_SAPLING, BANANA_SAPLING, CORN_SAPLING, POISONED_SAPLING, FLOWERING_CHERRY_SAPLING, SAPLING_RD161348, SAPLING_C0_0_13A, SAPLING_C0_24ST);
            getOrCreateTagBuilder(BlockTags.SLABS)
                    .add(STONE_SLAB_C0_26ST);
            getOrCreateTagBuilder(BlockTags.STAIRS)
                    .add(COBBLESTONE_STAIRS_RD20090515, COBBLESTONE_STAIRS_C0_0_14A, COBBLESTONE_STAIRS_B1_7);
            getOrCreateTagBuilder(BlockTags.WITHER_IMMUNE)
                    .add(BEDROCK_C0_0_12A);
            getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                    .add(PALM_BUTTON, BANANA_BUTTON, CORN_BUTTON, POISONED_BUTTON);
            getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                    .add(PALM_DOOR, BANANA_DOOR, CORN_DOOR, POISONED_DOOR, WOODEN_DOOR_INF20100607);
            getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                    .add(PALM_FENCE, BANANA_FENCE, CORN_FENCE, POISONED_FENCE, WOODEN_FENCE_RD20090515, WOODEN_FENCE_RD161348, WOODEN_FENCE_C0_0_14A, WOODEN_FENCE_A1_0_17, WOODEN_FENCE_B1_9PRE5);
            getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                    .add(PALM_PRESSURE_PLATE, BANANA_PRESSURE_PLATE, CORN_PRESSURE_PLATE, POISONED_PRESSURE_PLATE);
            getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                    .add(PALM_SLAB, BANANA_SLAB, CORN_SLAB, POISONED_SLAB);
            getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                    .add(PALM_STAIRS, BANANA_STAIRS, CORN_STAIRS, POISONED_STAIRS, WOODEN_STAIRS_RD20090515, WOODEN_STAIRS_RD161348, WOODEN_STAIRS_C0_0_14A, WOODEN_STAIRS_INF20100629, WOODEN_STAIRS_B1_9PRE5);
            getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                    .add(PALM_TRAPDOOR, BANANA_TRAPDOOR, CORN_TRAPDOOR, POISONED_TRAPDOOR);
            getOrCreateTagBuilder(BlockTags.WOOL)
                    .add(WHITE_CLOTH, LIGHT_GRAY_CLOTH_C0_0_20A, LIGHT_GRAY_CLOTH_C0_28A, DARK_GRAY_CLOTH_C0_0_20A, DARK_GRAY_CLOTH_C0_28A, RED_CLOTH, ORANGE_CLOTH, YELLOW_CLOTH, CHARTREUSE_CLOTH,
                            SPRING_GREEN_CLOTH, CYAN_CLOTH, CAPRI_CLOTH, ULTRAMARINE_CLOTH, VIOLET_CLOTH, PURPLE_CLOTH, MAGENTA_CLOTH, ROSE_CLOTH);
            getOrCreateTagBuilder(BlockTags.ENCHANTMENT_POWER_PROVIDER)
                    .add(BOOKSHELF_C0_26ST, BOOKSHELF_B1_9PRE5);
            getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                    .add(LADDER_INF20100607, LADDER_INF20100618);
            getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                    .add(GLOW_FLOWER);
            getOrCreateTagBuilder(TagList.Blocks.CLASSIC_SPONGE_REPLACEABLE)
                    .add(Blocks.KELP, KELP_PLANT, Blocks.SEAGRASS, TALL_SEAGRASS, POWDER_SNOW);
            getOrCreateTagBuilder(TagList.Blocks.FLOOR_EXTENDED_SAPLING_UNALLOWED_FLOOR)
                    .addOptionalTag(BlockTags.LEAVES)
                    .addOptionalTag(BlockTags.LOGS)
                    .addOptionalTag(BlockTags.FLOWERS)
                    .addOptionalTag(BlockTags.ANVIL)
                    .addOptionalTag(BlockTags.ALL_HANGING_SIGNS)
                    .addOptionalTag(BlockTags.ALL_SIGNS)
                    .addOptionalTag(BlockTags.BANNERS)
                    .addOptionalTag(BlockTags.BEDS)
                    .addOptionalTag(BlockTags.CLIMBABLE)
                    .addOptionalTag(BlockTags.BUTTONS)
                    .addOptionalTag(BlockTags.DOORS)
                    .addOptionalTag(BlockTags.TRAPDOORS)
                    .addOptionalTag(BlockTags.FENCE_GATES)
                    .addOptionalTag(BlockTags.FENCES)
                    .addOptionalTag(BlockTags.WALLS)
                    .addOptionalTag(BlockTags.CORAL_PLANTS)
                    .addOptionalTag(BlockTags.WALL_CORALS)
                    .addOptionalTag(BlockTags.CANDLES)
                    .addOptionalTag(BlockTags.CANDLE_CAKES)
                    .addOptionalTag(BlockTags.CAMPFIRES)
                    .addOptionalTag(BlockTags.CAULDRONS)
                    .addOptionalTag(BlockTags.FIRE)
                    .addOptionalTag(BlockTags.FLOWER_POTS)
                    .addOptionalTag(BlockTags.ICE)
                    .addOptionalTag(BlockTags.AIR)
                    .addOptionalTag(BlockTags.SAPLINGS)
                    .addOptionalTag(Identifier.of("more_tools_and_armor", "needs_netherite_tool"))
                    .addOptionalTag(Identifier.of("more_tools_and_armor", "needs_deepslate_emerald_tool"))
                    .add(Blocks.BEDROCK, Blocks.REINFORCED_DEEPSLATE, Blocks.CAKE);
            getOrCreateTagBuilder(TagList.Blocks.CHAIRS)
                    .add(OAK_CHAIR)
                    .add(SPRUCE_CHAIR)
                    .add(BIRCH_CHAIR)
                    .add(JUNGLE_CHAIR)
                    .add(ACACIA_CHAIR)
                    .add(DARK_OAK_CHAIR)
                    .add(CRIMSON_CHAIR)
                    .add(WARPED_CHAIR)
                    .add(MANGROVE_CHAIR)
                    .add(CHERRY_CHAIR)
                    .add(PALM_CHAIR)
                    .add(BANANA_CHAIR)
                    .add(CORN_CHAIR)
                    .add(POISONED_CHAIR);
        }
    }

    public static class BlocktopiaItemTagProvider extends FabricTagProvider.ItemTagProvider {
        public BlocktopiaItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            getOrCreateTagBuilder(ItemTags.EQUIPPABLE_ENCHANTABLE)
                    .add(CARVED_PUMPKIN_A1_2_0.asItem());
            getOrCreateTagBuilder(ItemTags.VANISHING_ENCHANTABLE)
                    .add(CARVED_PUMPKIN_A1_2_0.asItem());
            getOrCreateTagBuilder(TagList.Items.LEGACY_BLOCKS)
                    .add(COBBLESTONE_RD20090515.asItem(), COBBLESTONE_C_0_0_14A.asItem(), COBBLESTONE_B1_7.asItem(), WOODEN_PLANKS_RD20090515.asItem(), WOODEN_PLANKS_RD161348.asItem(),
                            WOODEN_PLANKS_C0_0_14A.asItem(), WOODEN_PLANKS_C0_0_15A.asItem(), WOODEN_PLANKS_B1_9PRE5.asItem(), SAPLING_RD161348.asItem(), SAPLING_C0_0_13A.asItem(),
                            SAPLING_C0_24ST.asItem(), BEDROCK_C0_0_12A.asItem(), SAND_C0_0_14A.asItem(), SAND_C0_0_15A.asItem(), SAND_B1_9PRE6.asItem(), GRAVEL_C0_0_14A.asItem(),
                            GRAVEL_C0_0_15A.asItem(), GRAVEL_B1_9PRE5.asItem(), GRAVEL_1_3.asItem(), COAL_ORE_C0_0_14A.asItem(), COAL_ORE_1_14.asItem(), IRON_ORE_C0_0_14A.asItem(),
                            IRON_ORE_1_14.asItem(), IRON_ORE_1_14_1.asItem(), GOLD_ORE_C0_0_14A.asItem(), GOLD_ORE_C0_26ST.asItem(), GOLD_ORE_1_14.asItem(), LOG_C0_0_14A.asItem(),
                            LEAVES_C0_0_14A.asItem(), LEAVES_C0_0_15A.asItem(), LEAVES_C0_24ST.asItem(), SPONGE_C0_0_19A.asItem(), SPONGE_1_8.asItem(), WET_SPONGE_1_8.asItem(),
                            GLASS_C0_0_19A.asItem(), WHITE_CLOTH.asItem(), LIGHT_GRAY_CLOTH_C0_0_20A.asItem(), LIGHT_GRAY_CLOTH_C0_28A.asItem(), DARK_GRAY_CLOTH_C0_0_20A.asItem(),
                            DARK_GRAY_CLOTH_C0_28A.asItem(), RED_CLOTH.asItem(), ORANGE_CLOTH.asItem(), YELLOW_CLOTH.asItem(), CHARTREUSE_CLOTH.asItem(), SPRING_GREEN_CLOTH.asItem(),
                            CYAN_CLOTH.asItem(), CAPRI_CLOTH.asItem(), ULTRAMARINE_CLOTH.asItem(), VIOLET_CLOTH.asItem(), PURPLE_CLOTH.asItem(), MAGENTA_CLOTH.asItem(), ROSE_CLOTH.asItem(),
                            GOLD_BLOCK_C0_0_20A.asItem(), GOLD_BLOCK_C0_26ST.asItem(), GOLD_BLOCK_A1_2_0.asItem(), GOLD_BLOCK_B1_9PRE5.asItem(), DANDELION_C0_0_20A.asItem(), ROSE_C0_0_20A.asItem(),
                            POPPY_1_7.asItem(), RED_MUSHROOM_C0_0_20A.asItem(), BROWN_MUSHROOM_C0_0_20A.asItem(), STONE_SLAB_C0_26ST.asItem(), IRON_BLOCK_C0_26ST.asItem(), IRON_BLOCK_A1_2_0.asItem(),
                            IRON_BLOCK_B1_9PRE5.asItem(), TNT_C0_26ST.asItem(), TNT_C0_28A.asItem(), MOSSY_COBBLESTONE_C0_26ST.asItem(), MOSSY_COBBLESTONE_B1_8.asItem(), BRICKS_C0_26ST.asItem(),
                            BRICKS_A1_0_11.asItem(), BOOKSHELF_C0_26ST.asItem(), BOOKSHELF_B1_9PRE5.asItem(), OBSIDIAN_C0_28A.asItem(), ItemInit.TORCH_IN20100124_2, DIAMOND_ORE_IN20100128.asItem(),
                            DIAMOND_ORE_1_14.asItem(), DIAMOND_BLOCK_IN20100128.asItem(), DIAMOND_BLOCK_A1_2_0.asItem(), DIAMOND_BLOCK_B1_9PRE5.asItem(), CRAFTING_TABLE_IN20100131.asItem(),
                            CRAFTING_TABLE_1_14.asItem(), FURNACE_IN20100219.asItem(), LIT_FURNACE_IN20100219.asItem(), FURNACE_B1_2.asItem(), LIT_FURNACE_B1_2.asItem(), LADDER_INF20100607.asItem(),
                            LADDER_INF20100618.asItem(), WOODEN_DOOR_INF20100607.asItem(), WOODEN_STAIRS_RD20090515.asItem(), WOODEN_STAIRS_RD161348.asItem(),
                            WOODEN_STAIRS_C0_0_14A.asItem(), WOODEN_STAIRS_INF20100629.asItem(), WOODEN_STAIRS_B1_9PRE5.asItem(), COBBLESTONE_STAIRS_RD20090515.asItem(),
                            COBBLESTONE_STAIRS_C0_0_14A.asItem(), COBBLESTONE_B1_7.asItem(), REDSTONE_ORE_A1_0_1.asItem(), REDSTONE_ORE_1_14.asItem(), REDSTONE_TORCH_A1_0_1.asItem(),
                            REDSTONE_WALL_TORCH_A1_0_1.asItem(), SNOW_A1_0_4.asItem(), ICE_A1_0_4.asItem(), SNOW_BLOCK_A1_0_5.asItem(), CLAY_BLOCK_A1_0_11.asItem(), WOODEN_FENCE_RD20090515.asItem(),
                            WOODEN_FENCE_RD161348.asItem(), WOODEN_FENCE_C0_0_14A.asItem(), WOODEN_FENCE_A1_0_17.asItem(), WOODEN_FENCE_B1_9PRE5.asItem(), NETHERRACK_A1_2_0.asItem(),
                            NETHERRACK_B1_9PRE5.asItem(), SOUL_SAND_A1_2_0.asItem(), GLOWSTONE_A1_2_0.asItem(), GLOWSTONE_B1_9PRE5.asItem(), CARVED_PUMPKIN_A1_2_0.asItem(),
                            JACK_O_LANTERN_A1_2_0.asItem());
            getOrCreateTagBuilder(TagList.Items.PALM_LOGS)
                    .add(PALM_LOG.asItem(), STRIPPED_PALM_LOG.asItem(), PALM_WOOD.asItem(), STRIPPED_PALM_WOOD.asItem());
            getOrCreateTagBuilder(TagList.Items.GOLDEN_BLOCKS)
                    .add(Items.GOLD_BLOCK, GOLD_BLOCK_C0_0_20A.asItem(), GOLD_BLOCK_C0_26ST.asItem(), GOLD_BLOCK_A1_2_0.asItem(), GOLD_BLOCK_B1_9PRE5.asItem());
            getOrCreateTagBuilder(TagList.Items.IRON_BLOCKS)
                    .add(Items.IRON_BLOCK, IRON_BLOCK_C0_26ST.asItem(), IRON_BLOCK_A1_2_0.asItem(), IRON_BLOCK_B1_9PRE5.asItem());
            getOrCreateTagBuilder(TagList.Items.DIAMOND_BLOCKS)
                    .add(Items.DIAMOND_BLOCK, DIAMOND_BLOCK_IN20100128.asItem(), DIAMOND_BLOCK_A1_2_0.asItem(), DIAMOND_BLOCK_B1_9PRE5.asItem());
            getOrCreateTagBuilder(TagList.Items.LEGACY_COBBLESTONE)
                    .add(COBBLESTONE_RD20090515.asItem(), COBBLESTONE_C_0_0_14A.asItem(), COBBLESTONE_B1_7.asItem());
            getOrCreateTagBuilder(TagList.Items.BANANA_LOGS)
                    .add(BANANA_LOG.asItem(), STRIPPED_BANANA_LOG.asItem(), BANANA_WOOD.asItem(), STRIPPED_BANANA_WOOD.asItem());
            getOrCreateTagBuilder(TagList.Items.CORN_LOGS)
                    .add(CORN_LOG.asItem(), STRIPPED_CORN_LOG.asItem(), CORN_WOOD.asItem(), STRIPPED_CORN_WOOD.asItem());
            getOrCreateTagBuilder(TagList.Items.POISONED_LOGS)
                    .add(POISONED_LOG.asItem(), STRIPPED_POISONED_LOG.asItem(), POISONED_WOOD.asItem(), STRIPPED_POISONED_WOOD.asItem());
            getOrCreateTagBuilder(ItemTags.FENCES)
                    .add(PALM_FENCE.asItem(), BANANA_FENCE.asItem(), CORN_FENCE.asItem(), POISONED_FENCE.asItem(), WOODEN_FENCE_RD161348.asItem(), WOODEN_FENCE_C0_0_14A.asItem(), WOODEN_FENCE_A1_0_17.asItem(), WOODEN_FENCE_B1_9PRE5.asItem());
            getOrCreateTagBuilder(ItemTags.BOATS)
                    .add(ItemInit.PALM_BOAT, BANANA_BOAT, CORN_BOAT, POISONED_BOAT);
            getOrCreateTagBuilder(ItemTags.CHEST_BOATS)
                    .add(ItemInit.PALM_CHEST_BOAT, BANANA_CHEST_BOAT, CORN_CHEST_BOAT, POISONED_CHEST_BOAT);
            getOrCreateTagBuilder(ItemTags.LEAVES)
                    .add(PALM_LEAVES.asItem(), BANANA_LEAVES.asItem(), CORN_LEAVES.asItem(), POISONED_LEAVES.asItem(), FLOWERING_CHERRY_LEAVES.asItem(), LEAVES_C0_0_14A.asItem(), LEAVES_C0_0_15A.asItem(), LEAVES_C0_24ST.asItem());
            getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                    .addTag(TagList.Items.PALM_LOGS).addTag(TagList.Items.BANANA_LOGS).addTag(TagList.Items.CORN_LOGS).addTag(TagList.Items.POISONED_LOGS)
                    .add(LOG_C0_0_14A.asItem());
            getOrCreateTagBuilder(ItemTags.PLANKS)
                    .add( PALM_PLANKS.asItem(), BANANA_PLANKS.asItem(), CORN_PLANKS.asItem(), POISONED_PLANKS.asItem(), WOODEN_PLANKS_RD20090515.asItem(), WOODEN_PLANKS_RD161348.asItem(), WOODEN_PLANKS_C0_0_14A.asItem(),
                            WOODEN_PLANKS_C0_0_15A.asItem(), WOODEN_PLANKS_B1_9PRE5.asItem());
            getOrCreateTagBuilder(ItemTags.SAPLINGS)
                    .add( PALM_SAPLING.asItem(), BANANA_SAPLING.asItem(), CORN_SAPLING.asItem(), POISONED_SAPLING.asItem(), FLOWERING_CHERRY_SAPLING.asItem(), SAPLING_RD161348.asItem(), SAPLING_C0_0_13A.asItem(), SAPLING_C0_24ST.asItem());
            getOrCreateTagBuilder(ItemTags.SLABS)
                    .add( STONE_SLAB_C0_26ST.asItem());
            getOrCreateTagBuilder(ItemTags.STAIRS)
                    .add( COBBLESTONE_STAIRS_RD20090515.asItem(), COBBLESTONE_STAIRS_C0_0_14A.asItem(), COBBLESTONE_STAIRS_B1_7.asItem());
            getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                    .add( PALM_BUTTON.asItem(), BANANA_BUTTON.asItem(), CORN_BUTTON.asItem(), POISONED_BUTTON.asItem());
            getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                    .add( PALM_DOOR.asItem(), BANANA_DOOR.asItem(), CORN_DOOR.asItem(), POISONED_DOOR.asItem(), WOODEN_DOOR_INF20100607.asItem());
            getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                    .add( PALM_FENCE.asItem(), BANANA_FENCE.asItem());
            getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                    .add( PALM_PRESSURE_PLATE.asItem(), BANANA_PRESSURE_PLATE.asItem(), CORN_PRESSURE_PLATE.asItem(), POISONED_PRESSURE_PLATE.asItem());
            getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                    .add( PALM_SLAB.asItem(), BANANA_SLAB.asItem(), CORN_SLAB.asItem(), POISONED_SLAB.asItem());
            getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                    .add( PALM_STAIRS.asItem(), BANANA_STAIRS.asItem(), CORN_STAIRS.asItem(), POISONED_STAIRS.asItem(), WOODEN_STAIRS_RD20090515.asItem(), WOODEN_STAIRS_RD161348.asItem(), WOODEN_STAIRS_C0_0_14A.asItem(),
                            WOODEN_STAIRS_INF20100629.asItem(), WOODEN_STAIRS_B1_9PRE5.asItem());
            getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
                    .add( PALM_TRAPDOOR.asItem(), BANANA_TRAPDOOR.asItem(), CORN_TRAPDOOR.asItem(), POISONED_TRAPDOOR.asItem());
            getOrCreateTagBuilder(ItemTags.WOOL)
                    .add( WHITE_CLOTH.asItem(), LIGHT_GRAY_CLOTH_C0_0_20A.asItem(), LIGHT_GRAY_CLOTH_C0_28A.asItem(), DARK_GRAY_CLOTH_C0_0_20A.asItem(), DARK_GRAY_CLOTH_C0_28A.asItem(),
                            RED_CLOTH.asItem(), ORANGE_CLOTH.asItem(), YELLOW_CLOTH.asItem(), CHARTREUSE_CLOTH.asItem(), SPRING_GREEN_CLOTH.asItem(), CYAN_CLOTH.asItem(), CAPRI_CLOTH.asItem(),
                            ULTRAMARINE_CLOTH.asItem(), VIOLET_CLOTH.asItem(), PURPLE_CLOTH.asItem(), MAGENTA_CLOTH.asItem(), ROSE_CLOTH.asItem());
            getOrCreateTagBuilder(TagList.Items.MONKEY_BREEDING_ITEMS)
                    .add(COCONUT, BANANA);

            getOrCreateTagBuilder(TagList.Items.CHAIRS)
                    .add(OAK_CHAIR.asItem())
                    .add(SPRUCE_CHAIR.asItem())
                    .add(BIRCH_CHAIR.asItem())
                    .add(JUNGLE_CHAIR.asItem())
                    .add(ACACIA_CHAIR.asItem())
                    .add(DARK_OAK_CHAIR.asItem())
                    .add(CRIMSON_CHAIR.asItem())
                    .add(WARPED_CHAIR.asItem())
                    .add(MANGROVE_CHAIR.asItem())
                    .add(CHERRY_CHAIR.asItem())
                    .add(PALM_CHAIR.asItem())
                    .add(BANANA_CHAIR.asItem())
                    .add(CORN_CHAIR.asItem())
                    .add(POISONED_CHAIR.asItem());


            getOrCreateTagBuilder(TrinketTags.RABBIT_SLOT)
                    .add(RABBIT, COOKED_RABBIT, RABBIT_HIDE, RABBIT_FOOT, RABBIT_TRINKET);
            getOrCreateTagBuilder(TrinketTags.FISH_SLOT)
                    .add(FISH_TRINKET, COD, SALMON, TROPICAL_FISH, PUFFERFISH, COD_BUCKET, SALMON_BUCKET, TROPICAL_FISH_BUCKET, PUFFERFISH_BUCKET, COOKED_COD, COOKED_SALMON);
        }
    }

    public static class BlocktopiaFluidTagProvider extends FabricTagProvider.FluidTagProvider {
        public BlocktopiaFluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            getOrCreateTagBuilder(TagList.Fluids.CLASSIC_SPONGE_ABSORB)
                    .add(Fluids.WATER, Fluids.FLOWING_WATER, Fluids.LAVA, Fluids.FLOWING_LAVA, FluidInit.TROPICAL_WATER, FluidInit.FLOWING_TROPICAL_WATER);
            getOrCreateTagBuilder(FluidTags.WATER)
                    .add(FluidInit.TROPICAL_WATER, FluidInit.FLOWING_TROPICAL_WATER);
        }
    }

    public static class BlocktopiaBiomeTagProvider extends FabricTagProvider<Biome> {
        public BlocktopiaBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, RegistryKeys.BIOME, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            getOrCreateTagBuilder(TagList.Biomes.HAS_BANANA_TREE_HOUSE)
                    .add(BiomeInit.RAIN_FOREST_KEY);
        }
    }

    public static class BlocktopiaPOITagProvider extends FabricTagProvider<PointOfInterestType> {
        public BlocktopiaPOITagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, RegistryKeys.POINT_OF_INTEREST_TYPE, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE)
                    .add(VillagerInit.LEGACY_POI, VillagerInit.BEEKEEPER_POI);
        }
    }

    public static class BlocktopiaEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {
        public BlocktopiaEntityTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            getOrCreateTagBuilder(EntityTypeTags.FALL_DAMAGE_IMMUNE)
                    .add(EntityInit.MONKEY);
            getOrCreateTagBuilder(EntityTypeTags.WITHER_FRIENDS)
                    .add(EntityInit.MONKEY);
        }
    }
}
