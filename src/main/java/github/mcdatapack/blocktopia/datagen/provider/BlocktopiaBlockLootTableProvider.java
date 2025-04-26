package github.mcdatapack.blocktopia.datagen.provider;

import java.util.concurrent.CompletableFuture;

import github.mcdatapack.blocktopia.block.custom.BananaCropBlock;
import github.mcdatapack.blocktopia.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import static github.mcdatapack.blocktopia.item.ModItems.BANANA;
import static github.mcdatapack.blocktopia.block.ModBlocks.*;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.*;

public class BlocktopiaBlockLootTableProvider extends FabricBlockLootTableProvider {
    public BlocktopiaBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(BANANA_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(BananaCropBlock.AGE, BananaCropBlock.MAX_AGE));
        this.addDrop(BANANA_CROP, this.cropDrops(BANANA_CROP, BANANA, BANANA_CROP.asItem(), builder2));

        addDrop(TROPICAL_MOSS);
        addDrop(TROPICAL_MOSS_CARPET);

        addDrop(PAPER_BLOCK);
        addDrop(GUNPOWDER_BLOCK);
        addDrop(FIREWORK_BLOCK);

        addDrop(LEGACY_CUTTER);
        addDrop(DUPER);

        addDrop(SPONGE_TNT);

        addDrop(FLOWERING_CHERRY_SAPLING);
        addPottedPlantDrops(POTTED_FLOWERING_CHERRY_SAPLING);

        addDrop(GLOW_FLOWER);
        addPottedPlantDrops(POTTED_GLOW_FLOWER);

        addDrop(PALM_LOG);
        addDrop(STRIPPED_PALM_LOG);
        addDrop(PALM_WOOD);
        addDrop(STRIPPED_PALM_WOOD);
        addDrop(PALM_SAPLING);
        addPottedPlantDrops(POTTED_PALM_SAPLING);
        addDrop(PALM_PLANKS);
        addDrop(PALM_FENCE);
        addDrop(PALM_FENCE_GATE);
        addDrop(PALM_STAIRS);
        addDrop(PALM_PRESSURE_PLATE);
        addDrop(PALM_BUTTON);
        addDrop(PALM_TRAPDOOR);

        addDrop(BANANA_LOG);
        addDrop(STRIPPED_BANANA_LOG);
        addDrop(BANANA_WOOD);
        addDrop(STRIPPED_BANANA_WOOD);
        addDrop(BANANA_SAPLING);
        addPottedPlantDrops(POTTED_BANANA_SAPLING);
        addDrop(BANANA_PLANKS);
        addDrop(BANANA_FENCE);
        addDrop(BANANA_FENCE_GATE);
        addDrop(BANANA_STAIRS);
        addDrop(BANANA_PRESSURE_PLATE);
        addDrop(BANANA_BUTTON);
        addDrop(BANANA_TRAPDOOR);


        addDrop(CORN_LOG);
        addDrop(STRIPPED_CORN_LOG);
        addDrop(CORN_WOOD);
        addDrop(STRIPPED_CORN_WOOD);
        addDrop(CORN_SAPLING);
        addPottedPlantDrops(POTTED_CORN_SAPLING);
        addDrop(CORN_PLANKS);
        addDrop(CORN_FENCE);
        addDrop(CORN_FENCE_GATE);
        addDrop(CORN_STAIRS);
        addDrop(CORN_PRESSURE_PLATE);
        addDrop(CORN_BUTTON);
        addDrop(CORN_TRAPDOOR);

        addDrop(POISONED_LOG);
        addDrop(STRIPPED_POISONED_LOG);
        addDrop(POISONED_WOOD);
        addDrop(STRIPPED_POISONED_WOOD);
        addDrop(POISONED_SAPLING);
        addPottedPlantDrops(POTTED_POISONED_SAPLING);
        addDrop(POISONED_PLANKS);
        addDrop(POISONED_FENCE);
        addDrop(POISONED_FENCE_GATE);
        addDrop(POISONED_STAIRS);
        addDrop(POISONED_PRESSURE_PLATE);
        addDrop(POISONED_BUTTON);
        addDrop(POISONED_TRAPDOOR);

        addDrop(MAHOGANY_LOG);
        addDrop(STRIPPED_MAHOGANY_LOG);
        addDrop(MAHOGANY_WOOD);
        addDrop(STRIPPED_MAHOGANY_WOOD);
        addDrop(MAHOGANY_SAPLING);
        addPottedPlantDrops(POTTED_MAHOGANY_SAPLING);
        addDrop(MAHOGANY_PLANKS);
        addDrop(MAHOGANY_FENCE);
        addDrop(MAHOGANY_FENCE_GATE);
        addDrop(MAHOGANY_STAIRS);
        addDrop(MAHOGANY_PRESSURE_PLATE);
        addDrop(MAHOGANY_BUTTON);
        addDrop(MAHOGANY_TRAPDOOR);

        addDrop(COBBLESTONE_RD20090515);
        addDrop(COBBLESTONE_C_0_0_14A);
        addDrop(COBBLESTONE_B1_7);
        addDrop(WOODEN_PLANKS_RD20090515);
        addDrop(WOODEN_PLANKS_RD161348);
        addDrop(WOODEN_PLANKS_C0_0_14A);
        addDrop(WOODEN_PLANKS_C0_0_15A);
        addDrop(WOODEN_PLANKS_B1_9PRE5);
        addDrop(LOG_C0_0_14A);
        addDrop(SAPLING_RD161348);
        addPottedPlantDrops(POTTED_SAPLING_RD161348);
        addDrop(SAPLING_C0_0_13A);
        addPottedPlantDrops(POTTED_SAPLING_C0_0_13A);
        addDrop(SAPLING_C0_24ST);
        addPottedPlantDrops(POTTED_SAPLING_C0_24ST);
        addDrop(SAND_C0_0_14A);
        addDrop(SAND_C0_0_15A);
        addDrop(SAND_B1_9PRE6);
        addDrop(GRAVEL_C0_0_14A);
        addDrop(GRAVEL_C0_0_15A);
        addDrop(GRAVEL_B1_9PRE5);
        addDrop(GRAVEL_1_3);
        addDrop(IRON_ORE_C0_0_14A);
        addDrop(IRON_ORE_1_14);
        addDrop(IRON_ORE_1_14_1);
        addDrop(GOLD_ORE_C0_0_14A);
        addDrop(GOLD_ORE_C0_26ST);
        addDrop(GOLD_ORE_1_14);
        addDrop(SPONGE_C0_0_19A);
        addDrop(SPONGE_1_8);
        addDrop(WET_SPONGE_1_8);
        addDropWithSilkTouch(GLASS_C0_0_19A);
        addDrop(WHITE_CLOTH);
        addDrop(LIGHT_GRAY_CLOTH_C0_0_20A);
        addDrop(LIGHT_GRAY_CLOTH_C0_28A);
        addDrop(DARK_GRAY_CLOTH_C0_0_20A);
        addDrop(DARK_GRAY_CLOTH_C0_28A);
        addDrop(RED_CLOTH);
        addDrop(ORANGE_CLOTH);
        addDrop(YELLOW_CLOTH);
        addDrop(CHARTREUSE_CLOTH);
        addDrop(SPRING_GREEN_CLOTH);
        addDrop(CYAN_CLOTH);
        addDrop(CAPRI_CLOTH);
        addDrop(ULTRAMARINE_CLOTH);
        addDrop(VIOLET_CLOTH);
        addDrop(PURPLE_CLOTH);
        addDrop(MAGENTA_CLOTH);
        addDrop(ROSE_CLOTH);
        addDrop(GOLD_BLOCK_C0_0_20A);
        addDrop(GOLD_BLOCK_C0_26ST);
        addDrop(GOLD_BLOCK_A1_2_0);
        addDrop(GOLD_BLOCK_B1_9PRE5);
        addDrop(DANDELION_C0_0_20A);
        addPottedPlantDrops(POTTED_DANDELIONS_C0_0_20A);
        addDrop(ROSE_C0_0_20A);
        addPottedPlantDrops(POTTED_ROSE_C0_0_20A);
        addDrop(POPPY_1_7);
        addPottedPlantDrops(POTTED_POPPY_1_7);
        addDrop(BROWN_MUSHROOM_C0_0_20A);
        addPottedPlantDrops(POTTED_BROWN_MUSHROOM_C0_0_20A);
        addDrop(RED_MUSHROOM_C0_0_20A);
        addPottedPlantDrops(POTTED_RED_MUSHROOM_C0_0_20A);
        addDrop(IRON_BLOCK_C0_26ST);
        addDrop(IRON_BLOCK_A1_2_0);
        addDrop(IRON_BLOCK_B1_9PRE5);
        addDrop(TNT_C0_26ST);
        addDrop(TNT_C0_28A);
        addDrop(MOSSY_COBBLESTONE_C0_26ST);
        addDrop(MOSSY_COBBLESTONE_B1_8);
        addDrop(BRICKS_C0_26ST);
        addDrop(BRICKS_A1_0_11);
        addDrop(BOOKSHELF_C0_26ST);
        addDrop(BOOKSHELF_B1_9PRE5);
        addDrop(OBSIDIAN_C0_28A);
        addDrop(DIAMOND_BLOCK_IN20100128);
        addDrop(DIAMOND_BLOCK_A1_2_0);
        addDrop(DIAMOND_BLOCK_B1_9PRE5);
        addDrop(CRAFTING_TABLE_IN20100131);
        addDrop(CRAFTING_TABLE_1_14);
        addDrop(FURNACE_IN20100219);
        addDrop(LIT_FURNACE_IN20100219);
        addDrop(FURNACE_B1_2);
        addDrop(LIT_FURNACE_B1_2);
        addDrop(LADDER_INF20100607);
        addDrop(LADDER_INF20100618);
        addDrop(WOODEN_STAIRS_RD20090515);
        addDrop(WOODEN_STAIRS_RD161348);
        addDrop(WOODEN_STAIRS_C0_0_14A);
        addDrop(WOODEN_STAIRS_INF20100629);
        addDrop(WOODEN_STAIRS_B1_9PRE5);
        addDrop(COBBLESTONE_STAIRS_RD20090515);
        addDrop(COBBLESTONE_STAIRS_INF20100629);
        addDrop(COBBLESTONE_STAIRS_B1_7);
        addDrop(TORCH_IN20100124_2);
        addDrop(WALL_TORCH_IN20100124_2);
        addDrop(REDSTONE_TORCH_A1_0_1, REDSTONE_TORCH_A1_0_1);
        addDrop(REDSTONE_WALL_TORCH_A1_0_1, REDSTONE_TORCH_A1_0_1);
        addDropWithSilkTouch(ICE_A1_0_4);
        addDrop(CLAY_BLOCK_A1_0_11);
        addDrop(WOODEN_FENCE_RD20090515);
        addDrop(WOODEN_FENCE_RD161348);
        addDrop(WOODEN_FENCE_C0_0_14A);
        addDrop(WOODEN_FENCE_A1_0_17);
        addDrop(WOODEN_FENCE_B1_9PRE5);
        addDrop(NETHERRACK_A1_2_0);
        addDrop(NETHERRACK_B1_9PRE5);
        addDrop(SOUL_SAND_A1_2_0);
        addDrop(GLOWSTONE_A1_2_0);
        addDrop(GLOWSTONE_B1_9PRE5);
        addDrop(CARVED_PUMPKIN_A1_2_0);
        addDrop(JACK_O_LANTERN_A1_2_0);
        addDrop(EXTENDED_REPEATER_TICK);
        addDrop(EXTENDED_REPEATER_SECOND);
        addDrop(EXTENDED_REPEATER_MINUTE);

        addDrop(XP_TRAP);
        addDrop(SANDY_DIRT, block -> drops(block, Blocks.DIRT));

        addDrop(OAK_CHAIR);
        addDrop(SPRUCE_CHAIR);
        addDrop(BIRCH_CHAIR);
        addDrop(JUNGLE_CHAIR);
        addDrop(ACACIA_CHAIR);
        addDrop(DARK_OAK_CHAIR);
        addDrop(CRIMSON_CHAIR);
        addDrop(WARPED_CHAIR);
        addDrop(MANGROVE_CHAIR);
        addDrop(BAMBOO_CHAIR);
        addDrop(CHERRY_CHAIR);
        addDrop(PALM_CHAIR);
        addDrop(BANANA_CHAIR);
        addDrop(CORN_CHAIR);
        addDrop(POISONED_CHAIR);
        addDrop(MAHOGANY_CHAIR);
    }

    private void addDrop(Block[] blocks) {
        for (Block block : blocks)
            addDrop(block);
    }
}
