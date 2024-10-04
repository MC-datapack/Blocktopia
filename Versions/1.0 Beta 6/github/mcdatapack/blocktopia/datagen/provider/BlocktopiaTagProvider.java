package github.mcdatapack.blocktopia.datagen.provider;

import github.mcdatapack.blocktopia.init.ItemInit;
import static github.mcdatapack.blocktopia.init.blocks.BlockInit.*;
import static github.mcdatapack.blocktopia.init.blocks.LegacyBlocks.*;
import github.mcdatapack.blocktopia.list.TagList;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_3481;
import net.minecraft.class_3489;
import net.minecraft.class_7225;
import org.jetbrains.annotations.Nullable;

public class BlocktopiaTagProvider {
    public static class BlocktopiaBlockTagProvider extends FabricTagProvider.BlockTagProvider {
        public BlocktopiaBlockTagProvider(FabricDataOutput output, CompletableFuture<class_7225.class_7874> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void method_10514(class_7225.class_7874 wrapperLookup) {
            method_10512(class_3481.field_33713).add(SMALL_CHEST).add(BOOKSHELF_C0_26ST).add(BOOKSHELF_B1_9PRE5).add(CRAFTING_TABLE_IN20100131).add(CRAFTING_TABLE_1_14).add(LADDER_INF20100607).add(LADDER_INF20100618).add(CARVED_PUMPKIN_A1_2_0).add(JACK_O_LANTERN_A1_2_0).setReplace(false);
            method_10512(class_3481.field_33714).add(PAPER_BLOCK).add(PALM_LEAVES).add(LEAVES_C0_0_14A).add(LEAVES_C0_0_15A).add(LEAVES_C0_24ST).add(SPONGE_C0_0_19A).add(SPONGE_1_8).add(WET_SPONGE_1_8).setReplace(false);
            method_10512(class_3481.field_33715).add(COBBLESTONE_RD20090515).add(COBBLESTONE_C_0_0_14A).add(COBBLESTONE_B1_7).add(COAL_ORE_C0_0_14A).add(COAL_ORE_1_14).add(IRON_ORE_C0_0_14A).add(IRON_ORE_1_14).add(IRON_ORE_1_14_1).add(GOLD_ORE_C0_0_14A).add(GOLD_ORE_C0_26ST).add(GOLD_ORE_1_14).add(GOLD_BLOCK_C0_0_20A).add(GOLD_BLOCK_C0_26ST).add(GOLD_BLOCK_A1_2_0).add(GOLD_BLOCK_B1_9PRE5).add(STONE_SLAB_C0_26ST).add(IRON_BLOCK_C0_26ST).add(IRON_BLOCK_A1_2_0).add(IRON_BLOCK_B1_9PRE5).add(MOSSY_COBBLESTONE_C0_26ST).add(MOSSY_COBBLESTONE_B1_8).add(BRICKS_C0_26ST).add(BRICKS_A1_0_11).add(OBSIDIAN_C0_28A).add(DIAMOND_ORE_IN20100128).add(DIAMOND_ORE_1_14).add(DIAMOND_BLOCK_IN20100128).add(DIAMOND_BLOCK_A1_2_0).add(DIAMOND_BLOCK_B1_9PRE5).add(FURNACE_IN20100219).add(LIT_FURNACE_IN20100219).add(FURNACE_B1_2).add(LIT_FURNACE_B1_2).add(COBBLESTONE_STAIRS_RD20090515).add(COBBLESTONE_STAIRS_C0_0_14A).add(COBBLESTONE_STAIRS_B1_7).add(REDSTONE_ORE_A1_0_1).add(REDSTONE_ORE_1_14).add(ICE_A1_0_4).add(NETHERRACK_A1_2_0).add(NETHERRACK_B1_9PRE5).add(GLOWSTONE_A1_2_0).add(GLOWSTONE_B1_9PRE5).setReplace(false);
            method_10512(class_3481.field_33716).add(GUNPOWDER_BLOCK).add(SAND_C0_0_14A).add(SAND_C0_0_15A).add(SAND_B1_9PRE6).add(GRAVEL_C0_0_14A).add(GRAVEL_C0_0_15A).add(GRAVEL_B1_9PRE5).add(GRAVEL_1_3).add(SNOW_A1_0_4).add(SNOW_BLOCK_A1_0_5).add(CLAY_BLOCK_A1_0_11).add(SOUL_SAND_A1_2_0).setReplace(false);
            method_10512(class_3481.field_33717).add(OBSIDIAN_C0_28A).setReplace(false);
            method_10512(class_3481.field_33718).add(GOLD_ORE_C0_0_14A).add(GOLD_ORE_C0_26ST).add(GOLD_ORE_1_14).add(GOLD_BLOCK_C0_0_20A).add(GOLD_BLOCK_C0_26ST).add(GOLD_BLOCK_A1_2_0).add(GOLD_BLOCK_B1_9PRE5).add(DIAMOND_ORE_IN20100128).add(DIAMOND_ORE_1_14).add(DIAMOND_BLOCK_IN20100128).add(DIAMOND_BLOCK_A1_2_0).add(DIAMOND_BLOCK_B1_9PRE5).add(REDSTONE_ORE_A1_0_1).add(REDSTONE_ORE_1_14).setReplace(false);
            method_10512(class_3481.field_33719).add(IRON_ORE_C0_0_14A).add(IRON_ORE_1_14).add(IRON_ORE_1_14_1).add(IRON_BLOCK_C0_26ST).add(IRON_BLOCK_A1_2_0).add(IRON_BLOCK_B1_9PRE5).setReplace(false);
            method_10512(TagList.Blocks.LEGACY_BLOCKS).add(COBBLESTONE_RD20090515).add(COBBLESTONE_C_0_0_14A).add(COBBLESTONE_B1_7).add(WOODEN_PLANKS_RD20090515).add(WOODEN_PLANKS_RD161348).add(WOODEN_PLANKS_C0_0_14A).add(WOODEN_PLANKS_C0_0_15A).add(WOODEN_PLANKS_B1_9PRE5).add(SAPLING_RD161348).add(SAPLING_C0_0_13A).add(SAPLING_C0_24ST).add(BEDROCK_C0_0_12A).add(SAND_C0_0_14A).add(SAND_C0_0_15A).add(SAND_B1_9PRE6).add(GRAVEL_C0_0_14A).add(GRAVEL_C0_0_15A).add(GRAVEL_B1_9PRE5).add(GRAVEL_1_3).add(COAL_ORE_C0_0_14A).add(COAL_ORE_1_14).add(IRON_ORE_C0_0_14A).add(IRON_ORE_1_14).add(IRON_ORE_1_14_1).add(GOLD_ORE_C0_0_14A).add(GOLD_ORE_C0_26ST).add(GOLD_ORE_1_14).add(LOG_C0_0_14A).add(LEAVES_C0_0_14A).add(LEAVES_C0_0_15A).add(LEAVES_C0_24ST).add(SPONGE_C0_0_19A).add(SPONGE_1_8).add(WET_SPONGE_1_8).add(GLASS_C0_0_19A).add(WHITE_CLOTH).add(LIGHT_GRAY_CLOTH_C0_0_20A).add(LIGHT_GRAY_CLOTH_C0_28A).add(DARK_GRAY_CLOTH_C0_0_20A).add(DARK_GRAY_CLOTH_C0_28A).add(RED_CLOTH).add(ORANGE_CLOTH).add(YELLOW_CLOTH).add(CHARTREUSE_CLOTH).add(SPRING_GREEN_CLOTH).add(CYAN_CLOTH).add(CAPRI_CLOTH).add(ULTRAMARINE_CLOTH).add(VIOLET_CLOTH).add(PURPLE_CLOTH).add(MAGENTA_CLOTH).add(ROSE_CLOTH).add(GOLD_BLOCK_C0_0_20A).add(GOLD_BLOCK_C0_26ST).add(GOLD_BLOCK_A1_2_0).add(GOLD_BLOCK_B1_9PRE5).add(DANDELION_C0_0_20A).add(ROSE_C0_0_20A).add(POPPY_1_7).add(RED_MUSHROOM_C0_0_20A).add(BROWN_MUSHROOM_C0_0_20A).add(STONE_SLAB_C0_26ST).add(IRON_BLOCK_C0_26ST).add(IRON_BLOCK_A1_2_0).add(IRON_BLOCK_B1_9PRE5).add(TNT_C0_26ST).add(TNT_C0_28A).add(MOSSY_COBBLESTONE_C0_26ST).add(MOSSY_COBBLESTONE_B1_8).add(BRICKS_C0_26ST).add(BRICKS_A1_0_11).add(BOOKSHELF_C0_26ST).add(BOOKSHELF_B1_9PRE5).add(OBSIDIAN_C0_28A).add(TORCH_IN20100124_2).add(WALL_TORCH_IN20100124_2).add(DIAMOND_ORE_IN20100128).add(DIAMOND_ORE_1_14).add(DIAMOND_BLOCK_IN20100128).add(DIAMOND_BLOCK_A1_2_0).add(DIAMOND_BLOCK_B1_9PRE5).add(CRAFTING_TABLE_IN20100131).add(CRAFTING_TABLE_1_14).add(FURNACE_IN20100219).add(LIT_FURNACE_IN20100219).add(FURNACE_B1_2).add(LIT_FURNACE_B1_2).add(LADDER_INF20100607).add(LADDER_INF20100618).add(SIGN_INF20100607).add(WALL_SIGN_INF20100607).add(WOODEN_DOOR_INF20100607).add(WOODEN_STAIRS_RD20090515).add(WOODEN_STAIRS_RD161348).add(WOODEN_STAIRS_C0_0_14A).add(WOODEN_STAIRS_INF20100629).add(WOODEN_STAIRS_B1_9PRE5).add(COBBLESTONE_STAIRS_RD20090515).add(COBBLESTONE_STAIRS_C0_0_14A).add(COBBLESTONE_STAIRS_B1_7).add(REDSTONE_ORE_A1_0_1).add(REDSTONE_ORE_1_14).add(REDSTONE_TORCH_A1_0_1).add(REDSTONE_WALL_TORCH_A1_0_1).add(SNOW_A1_0_4).add(ICE_A1_0_4).add(SNOW_BLOCK_A1_0_5).add(CLAY_BLOCK_A1_0_11).add(WOODEN_FENCE_RD20090515).add(WOODEN_FENCE_RD161348).add(WOODEN_FENCE_C0_0_14A).add(WOODEN_FENCE_A1_0_17).add(WOODEN_FENCE_B1_9PRE5).add(NETHERRACK_A1_2_0).add(NETHERRACK_B1_9PRE5).add(SOUL_SAND_A1_2_0).add(GLOWSTONE_A1_2_0).add(GLOWSTONE_B1_9PRE5).add(CARVED_PUMPKIN_A1_2_0).add(JACK_O_LANTERN_A1_2_0);
            method_10512(TagList.Blocks.PALM_LOGS).add(PALM_LOG).add(STRIPPED_PALM_LOG).add(PALM_WOOD).add(STRIPPED_PALM_WOOD);
            method_10512(TagList.Blocks.GOLDEN_BLOCKS).add(class_2246.field_10205).add(GOLD_BLOCK_C0_0_20A).add(GOLD_BLOCK_C0_26ST).add(GOLD_BLOCK_A1_2_0).add(GOLD_BLOCK_B1_9PRE5);
            method_10512(TagList.Blocks.IRON_BLOCKS).add(class_2246.field_10085).add(IRON_BLOCK_C0_26ST).add(IRON_BLOCK_A1_2_0).add(IRON_BLOCK_B1_9PRE5);
            method_10512(TagList.Blocks.DIAMOND_BLOCKS).add(class_2246.field_10201).add(DIAMOND_BLOCK_IN20100128).add(DIAMOND_BLOCK_A1_2_0).add(DIAMOND_BLOCK_B1_9PRE5);
            method_10512(TagList.Blocks.LEGACY_COBBLESTONE).add(COBBLESTONE_RD20090515).add(COBBLESTONE_C_0_0_14A).add(COBBLESTONE_B1_7);
            method_10512(class_3481.field_25588).add(NETHERRACK_A1_2_0).add(NETHERRACK_B1_9PRE5).setReplace(false);
            method_10512(class_3481.field_23119).add(SOUL_SAND_A1_2_0).setReplace(false);
            method_10512(class_3481.field_40103).add(PALM_HANGING_SIGN).setReplace(false);
            method_10512(class_3481.field_17753).add(BEDROCK_C0_0_12A).setReplace(false);
            method_10512(class_3481.field_25147).add(PALM_FENCE_GATE).setReplace(false);
            method_10512(class_3481.field_25590).add(BEDROCK_C0_0_12A).setReplace(false);
            method_10512(class_3481.field_15503).add(PALM_LEAVES).add(LEAVES_C0_0_14A).add(LEAVES_C0_0_15A).add(LEAVES_C0_24ST).setReplace(false);
            method_10512(class_3481.field_23210).method_26792(TagList.Blocks.PALM_LOGS).add(LOG_C0_0_14A).setReplace(false);
            method_10512(class_3481.field_15471).add(PALM_PLANKS).add(WOODEN_PLANKS_RD20090515).add(WOODEN_PLANKS_RD161348).add(WOODEN_PLANKS_C0_0_14A).add(WOODEN_PLANKS_C0_0_15A).add(WOODEN_PLANKS_B1_9PRE5).setReplace(false);
            method_10512(class_3481.field_15462).add(PALM_SAPLING).add(SAPLING_RD161348).add(SAPLING_C0_0_13A).add(SAPLING_C0_24ST).setReplace(false);
            method_10512(class_3481.field_15469).add(STONE_SLAB_C0_26ST).setReplace(false);
            method_10512(class_3481.field_15459).add(COBBLESTONE_STAIRS_RD20090515).add(COBBLESTONE_STAIRS_C0_0_14A).add(COBBLESTONE_STAIRS_B1_7).setReplace(false);
            method_10512(class_3481.field_15472).add(PALM_SIGN).add(SIGN_INF20100607).setReplace(false);
            method_10512(class_3481.field_40104).add(PALM_WALL_HANGING_SIGN).setReplace(false);
            method_10512(class_3481.field_15492).add(PALM_WALL_SIGN).add(WALL_SIGN_INF20100607).setReplace(false);
            method_10512(class_3481.field_17754).add(BEDROCK_C0_0_12A).setReplace(false);
            method_10512(class_3481.field_15499).add(PALM_BUTTON).setReplace(false);
            method_10512(class_3481.field_15494).add(PALM_DOOR).add(WOODEN_DOOR_INF20100607).setReplace(false);
            method_10512(class_3481.field_17619).add(PALM_FENCE).add(WOODEN_FENCE_RD20090515).add(WOODEN_FENCE_RD161348).add(WOODEN_FENCE_C0_0_14A).add(WOODEN_FENCE_A1_0_17).add(WOODEN_FENCE_B1_9PRE5).setReplace(false);
            method_10512(class_3481.field_15477).add(PALM_PRESSURE_PLATE).setReplace(false);
            method_10512(class_3481.field_15468).add(PALM_SLAB).setReplace(false);
            method_10512(class_3481.field_15502).add(PALM_STAIRS).add(WOODEN_STAIRS_RD20090515).add(WOODEN_STAIRS_RD161348).add(WOODEN_STAIRS_C0_0_14A).add(WOODEN_STAIRS_INF20100629).add(WOODEN_STAIRS_B1_9PRE5).setReplace(false);
            method_10512(class_3481.field_15491).add(PALM_TRAPDOOR).setReplace(false);
            method_10512(class_3481.field_15481).add(WHITE_CLOTH).add(LIGHT_GRAY_CLOTH_C0_0_20A).add(LIGHT_GRAY_CLOTH_C0_28A).add(DARK_GRAY_CLOTH_C0_0_20A).add(DARK_GRAY_CLOTH_C0_28A).add(RED_CLOTH).add(ORANGE_CLOTH).add(YELLOW_CLOTH).add(CHARTREUSE_CLOTH).add(SPRING_GREEN_CLOTH).add(CYAN_CLOTH).add(CAPRI_CLOTH).add(ULTRAMARINE_CLOTH).add(VIOLET_CLOTH).add(PURPLE_CLOTH).add(MAGENTA_CLOTH).add(ROSE_CLOTH).setReplace(false);
            method_10512(class_3481.field_44472).add(BOOKSHELF_C0_26ST).add(BOOKSHELF_B1_9PRE5).setReplace(false);
            method_10512(class_3481.field_22414).add(LADDER_INF20100607).add(LADDER_INF20100618).setReplace(false);
        }
    }

    public static class BlocktopiaItemTagProvider extends FabricTagProvider.ItemTagProvider {
        public BlocktopiaItemTagProvider(FabricDataOutput output, CompletableFuture<class_7225.class_7874> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void method_10514(class_7225.class_7874 wrapperLookup) {
            method_10512(class_3489.field_48312).add(CARVED_PUMPKIN_A1_2_0.method_8389()).setReplace(false);
            method_10512(class_3489.field_48314).add(CARVED_PUMPKIN_A1_2_0.method_8389()).setReplace(false);
            method_10512(TagList.Items.LEGACY_BLOCKS).add(COBBLESTONE_RD20090515.method_8389()).add(COBBLESTONE_C_0_0_14A.method_8389()).add(COBBLESTONE_B1_7.method_8389()).add(WOODEN_PLANKS_RD20090515.method_8389()).add(WOODEN_PLANKS_RD161348.method_8389()).add(WOODEN_PLANKS_C0_0_14A.method_8389()).add(WOODEN_PLANKS_C0_0_15A.method_8389()).add(WOODEN_PLANKS_B1_9PRE5.method_8389()).add(SAPLING_RD161348.method_8389()).add(SAPLING_C0_0_13A.method_8389()).add(SAPLING_C0_24ST.method_8389()).add(BEDROCK_C0_0_12A.method_8389()).add(SAND_C0_0_14A.method_8389()).add(SAND_C0_0_15A.method_8389()).add(SAND_B1_9PRE6.method_8389()).add(GRAVEL_C0_0_14A.method_8389()).add(GRAVEL_C0_0_15A.method_8389()).add(GRAVEL_B1_9PRE5.method_8389()).add(GRAVEL_1_3.method_8389()).add(COAL_ORE_C0_0_14A.method_8389()).add(COAL_ORE_1_14.method_8389()).add(IRON_ORE_C0_0_14A.method_8389()).add(IRON_ORE_1_14.method_8389()).add(IRON_ORE_1_14_1.method_8389()).add(GOLD_ORE_C0_0_14A.method_8389()).add(GOLD_ORE_C0_26ST.method_8389()).add(GOLD_ORE_1_14.method_8389()).add(LOG_C0_0_14A.method_8389()).add(LEAVES_C0_0_14A.method_8389()).add(LEAVES_C0_0_15A.method_8389()).add(LEAVES_C0_24ST.method_8389()).add(SPONGE_C0_0_19A.method_8389()).add(SPONGE_1_8.method_8389()).add(WET_SPONGE_1_8.method_8389()).add(GLASS_C0_0_19A.method_8389()).add(WHITE_CLOTH.method_8389()).add(LIGHT_GRAY_CLOTH_C0_0_20A.method_8389()).add(LIGHT_GRAY_CLOTH_C0_28A.method_8389()).add(DARK_GRAY_CLOTH_C0_0_20A.method_8389()).add(DARK_GRAY_CLOTH_C0_28A.method_8389()).add(RED_CLOTH.method_8389()).add(ORANGE_CLOTH.method_8389()).add(YELLOW_CLOTH.method_8389()).add(CHARTREUSE_CLOTH.method_8389()).add(SPRING_GREEN_CLOTH.method_8389()).add(CYAN_CLOTH.method_8389()).add(CAPRI_CLOTH.method_8389()).add(ULTRAMARINE_CLOTH.method_8389()).add(VIOLET_CLOTH.method_8389()).add(PURPLE_CLOTH.method_8389()).add(MAGENTA_CLOTH.method_8389()).add(ROSE_CLOTH.method_8389()).add(GOLD_BLOCK_C0_0_20A.method_8389()).add(GOLD_BLOCK_C0_26ST.method_8389()).add(GOLD_BLOCK_A1_2_0.method_8389()).add(GOLD_BLOCK_B1_9PRE5.method_8389()).add(DANDELION_C0_0_20A.method_8389()).add(ROSE_C0_0_20A.method_8389()).add(POPPY_1_7.method_8389()).add(RED_MUSHROOM_C0_0_20A.method_8389()).add(BROWN_MUSHROOM_C0_0_20A.method_8389()).add(STONE_SLAB_C0_26ST.method_8389()).add(IRON_BLOCK_C0_26ST.method_8389()).add(IRON_BLOCK_A1_2_0.method_8389()).add(IRON_BLOCK_B1_9PRE5.method_8389()).add(TNT_C0_26ST.method_8389()).add(TNT_C0_28A.method_8389()).add(MOSSY_COBBLESTONE_C0_26ST.method_8389()).add(MOSSY_COBBLESTONE_B1_8.method_8389()).add(BRICKS_C0_26ST.method_8389()).add(BRICKS_A1_0_11.method_8389()).add(BOOKSHELF_C0_26ST.method_8389()).add(BOOKSHELF_B1_9PRE5.method_8389()).add(OBSIDIAN_C0_28A.method_8389()).add(ItemInit.TORCH_IN20100124_2).add(DIAMOND_ORE_IN20100128.method_8389()).add(DIAMOND_ORE_1_14.method_8389()).add(DIAMOND_BLOCK_IN20100128.method_8389()).add(DIAMOND_BLOCK_A1_2_0.method_8389()).add(DIAMOND_BLOCK_B1_9PRE5.method_8389()).add(CRAFTING_TABLE_IN20100131.method_8389()).add(CRAFTING_TABLE_1_14.method_8389()).add(FURNACE_IN20100219.method_8389()).add(LIT_FURNACE_IN20100219.method_8389()).add(FURNACE_B1_2.method_8389()).add(LIT_FURNACE_B1_2.method_8389()).add(LADDER_INF20100607.method_8389()).add(LADDER_INF20100618.method_8389()).add(ItemInit.SIGN_INF20100607).add(WOODEN_DOOR_INF20100607.method_8389()).add(WOODEN_STAIRS_RD20090515.method_8389()).add(WOODEN_STAIRS_RD161348.method_8389()).add(WOODEN_STAIRS_C0_0_14A.method_8389()).add(WOODEN_STAIRS_INF20100629.method_8389()).add(WOODEN_STAIRS_B1_9PRE5.method_8389()).add(COBBLESTONE_STAIRS_RD20090515.method_8389()).add(COBBLESTONE_STAIRS_C0_0_14A.method_8389()).add(COBBLESTONE_B1_7.method_8389()).add(REDSTONE_ORE_A1_0_1.method_8389()).add(REDSTONE_ORE_1_14.method_8389()).add(REDSTONE_TORCH_A1_0_1.method_8389()).add(REDSTONE_WALL_TORCH_A1_0_1.method_8389()).add(SNOW_A1_0_4.method_8389()).add(ICE_A1_0_4.method_8389()).add(SNOW_BLOCK_A1_0_5.method_8389()).add(CLAY_BLOCK_A1_0_11.method_8389()).add(WOODEN_FENCE_RD20090515.method_8389()).add(WOODEN_FENCE_RD161348.method_8389()).add(WOODEN_FENCE_C0_0_14A.method_8389()).add(WOODEN_FENCE_A1_0_17.method_8389()).add(WOODEN_FENCE_B1_9PRE5.method_8389()).add(NETHERRACK_A1_2_0.method_8389()).add(NETHERRACK_B1_9PRE5.method_8389()).add(SOUL_SAND_A1_2_0.method_8389()).add(GLOWSTONE_A1_2_0.method_8389()).add(GLOWSTONE_B1_9PRE5.method_8389()).add(CARVED_PUMPKIN_A1_2_0.method_8389()).add(JACK_O_LANTERN_A1_2_0.method_8389());
            method_10512(TagList.Items.PALM_LOGS).add(PALM_LOG.method_8389()).add(STRIPPED_PALM_LOG.method_8389()).add(PALM_WOOD.method_8389()).add(STRIPPED_PALM_WOOD.method_8389());
            method_10512(TagList.Items.GOLDEN_BLOCKS).add(class_1802.field_8494).add(GOLD_BLOCK_C0_0_20A.method_8389()).add(GOLD_BLOCK_C0_26ST.method_8389()).add(GOLD_BLOCK_A1_2_0.method_8389()).add(GOLD_BLOCK_B1_9PRE5.method_8389());
            method_10512(TagList.Items.IRON_BLOCKS).add(class_1802.field_8773).add(IRON_BLOCK_C0_26ST.method_8389()).add(IRON_BLOCK_A1_2_0.method_8389()).add(IRON_BLOCK_B1_9PRE5.method_8389());
            method_10512(TagList.Items.DIAMOND_BLOCKS).add(class_1802.field_8603).add(DIAMOND_BLOCK_IN20100128.method_8389()).add(DIAMOND_BLOCK_A1_2_0.method_8389()).add(DIAMOND_BLOCK_B1_9PRE5.method_8389());
            method_10512(TagList.Items.LEGACY_COBBLESTONE).add(COBBLESTONE_RD20090515.method_8389()).add(COBBLESTONE_C_0_0_14A.method_8389()).add(COBBLESTONE_B1_7.method_8389());
            method_10512(class_3489.field_16585).add(PALM_FENCE.method_8389()).add(WOODEN_FENCE_RD161348.method_8389()).add(WOODEN_FENCE_C0_0_14A.method_8389()).add(WOODEN_FENCE_A1_0_17.method_8389()).add(WOODEN_FENCE_B1_9PRE5.method_8389()).setReplace(false);
            method_10512(class_3489.field_15536).add(ItemInit.PALM_BOAT).setReplace(false);
            method_10512(class_3489.field_38080).add(ItemInit.PALM_CHEST_BOAT).setReplace(false);
            method_10512(class_3489.field_40108).add(ItemInit.PALM_HANGING_SIGN).setReplace(false);
            method_10512(class_3489.field_15558).add(PALM_LEAVES.method_8389()).add(LEAVES_C0_0_14A.method_8389()).add(LEAVES_C0_0_15A.method_8389()).add(LEAVES_C0_24ST.method_8389()).setReplace(false);
            method_10512(class_3489.field_23212).method_26792(TagList.Items.PALM_LOGS).add(LOG_C0_0_14A.method_8389()).setReplace(false);
            method_10512(class_3489.field_15537).add(PALM_PLANKS.method_8389()).add(WOODEN_PLANKS_RD20090515.method_8389()).add(WOODEN_PLANKS_RD161348.method_8389()).add(WOODEN_PLANKS_C0_0_14A.method_8389()).add(WOODEN_PLANKS_C0_0_15A.method_8389()).add(WOODEN_PLANKS_B1_9PRE5.method_8389()).setReplace(false);
            method_10512(class_3489.field_15528).add(PALM_SAPLING.method_8389()).add(SAPLING_RD161348.method_8389()).add(SAPLING_C0_0_13A.method_8389()).add(SAPLING_C0_24ST.method_8389()).setReplace(false);
            method_10512(class_3489.field_15533).add(ItemInit.PALM_SIGN).add(ItemInit.SIGN_INF20100607).setReplace(false);
            method_10512(class_3489.field_15535).add(STONE_SLAB_C0_26ST.method_8389()).setReplace(false);
            method_10512(class_3489.field_15526).add(COBBLESTONE_STAIRS_RD20090515.method_8389()).add(COBBLESTONE_STAIRS_C0_0_14A.method_8389()).add(COBBLESTONE_STAIRS_B1_7.method_8389()).setReplace(false);
            method_10512(class_3489.field_15555).add(PALM_BUTTON.method_8389()).setReplace(false);
            method_10512(class_3489.field_15552).add(PALM_DOOR.method_8389()).add(WOODEN_DOOR_INF20100607.method_8389()).setReplace(false);
            method_10512(class_3489.field_17620).add(PALM_FENCE.method_8389()).setReplace(false);
            method_10512(class_3489.field_15540).add(PALM_PRESSURE_PLATE.method_8389()).setReplace(false);
            method_10512(class_3489.field_15534).add(PALM_SLAB.method_8389()).setReplace(false);
            method_10512(class_3489.field_15557).add(PALM_STAIRS.method_8389()).add(WOODEN_STAIRS_RD20090515.method_8389()).add(WOODEN_STAIRS_RD161348.method_8389()).add(WOODEN_STAIRS_C0_0_14A.method_8389()).add(WOODEN_STAIRS_INF20100629.method_8389()).add(WOODEN_STAIRS_B1_9PRE5.method_8389()).setReplace(false);
            method_10512(class_3489.field_15550).add(PALM_TRAPDOOR.method_8389()).setReplace(false);
            method_10512(class_3489.field_15544).add(WHITE_CLOTH.method_8389()).add(LIGHT_GRAY_CLOTH_C0_0_20A.method_8389()).add(LIGHT_GRAY_CLOTH_C0_28A.method_8389()).add(DARK_GRAY_CLOTH_C0_0_20A.method_8389()).add(DARK_GRAY_CLOTH_C0_28A.method_8389()).add(RED_CLOTH.method_8389()).add(ORANGE_CLOTH.method_8389()).add(YELLOW_CLOTH.method_8389()).add(CHARTREUSE_CLOTH.method_8389()).add(SPRING_GREEN_CLOTH.method_8389()).add(CYAN_CLOTH.method_8389()).add(CAPRI_CLOTH.method_8389()).add(ULTRAMARINE_CLOTH.method_8389()).add(VIOLET_CLOTH.method_8389()).add(PURPLE_CLOTH.method_8389()).add(MAGENTA_CLOTH.method_8389()).add(ROSE_CLOTH.method_8389()).setReplace(false);
        }
    }
}
