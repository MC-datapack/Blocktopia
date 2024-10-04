package github.mcdatapack.blocktopia.datagen.provider;

import github.mcdatapack.blocktopia.init.ItemInit;
import static github.mcdatapack.blocktopia.init.blocks.BlockInit.*;
import static github.mcdatapack.blocktopia.init.blocks.LegacyBlocks.*;
import github.mcdatapack.blocktopia.list.TagList;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import org.jetbrains.annotations.Nullable;

public class BlocktopiaTagProvider {
    public static class BlocktopiaBlockTagProvider extends FabricTagProvider.BlockTagProvider {
        public BlocktopiaBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(SMALL_CHEST).add(BOOKSHELF_C0_26ST).add(BOOKSHELF_B1_9PRE5).add(CRAFTING_TABLE_IN20100131).add(CRAFTING_TABLE_1_14).add(LADDER_INF20100607).add(LADDER_INF20100618).add(CARVED_PUMPKIN_A1_2_0).add(JACK_O_LANTERN_A1_2_0).setReplace(false);
            getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(PAPER_BLOCK).add(PALM_LEAVES).add(LEAVES_C0_0_14A).add(LEAVES_C0_0_15A).add(LEAVES_C0_24ST).add(SPONGE_C0_0_19A).add(SPONGE_1_8).add(WET_SPONGE_1_8).setReplace(false);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(COBBLESTONE_RD20090515).add(COBBLESTONE_C_0_0_14A).add(COBBLESTONE_B1_7).add(COAL_ORE_C0_0_14A).add(COAL_ORE_1_14).add(IRON_ORE_C0_0_14A).add(IRON_ORE_1_14).add(IRON_ORE_1_14_1).add(GOLD_ORE_C0_0_14A).add(GOLD_ORE_C0_26ST).add(GOLD_ORE_1_14).add(GOLD_BLOCK_C0_0_20A).add(GOLD_BLOCK_C0_26ST).add(GOLD_BLOCK_A1_2_0).add(GOLD_BLOCK_B1_9PRE5).add(STONE_SLAB_C0_26ST).add(IRON_BLOCK_C0_26ST).add(IRON_BLOCK_A1_2_0).add(IRON_BLOCK_B1_9PRE5).add(MOSSY_COBBLESTONE_C0_26ST).add(MOSSY_COBBLESTONE_B1_8).add(BRICKS_C0_26ST).add(BRICKS_A1_0_11).add(OBSIDIAN_C0_28A).add(DIAMOND_ORE_IN20100128).add(DIAMOND_ORE_1_14).add(DIAMOND_BLOCK_IN20100128).add(DIAMOND_BLOCK_A1_2_0).add(DIAMOND_BLOCK_B1_9PRE5).add(FURNACE_IN20100219).add(LIT_FURNACE_IN20100219).add(FURNACE_B1_2).add(LIT_FURNACE_B1_2).add(COBBLESTONE_STAIRS_RD20090515).add(COBBLESTONE_STAIRS_C0_0_14A).add(COBBLESTONE_STAIRS_B1_7).add(REDSTONE_ORE_A1_0_1).add(REDSTONE_ORE_1_14).add(ICE_A1_0_4).add(NETHERRACK_A1_2_0).add(NETHERRACK_B1_9PRE5).add(GLOWSTONE_A1_2_0).add(GLOWSTONE_B1_9PRE5).setReplace(false);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(GUNPOWDER_BLOCK).add(SAND_C0_0_14A).add(SAND_C0_0_15A).add(SAND_B1_9PRE6).add(GRAVEL_C0_0_14A).add(GRAVEL_C0_0_15A).add(GRAVEL_B1_9PRE5).add(GRAVEL_1_3).add(SNOW_A1_0_4).add(SNOW_BLOCK_A1_0_5).add(CLAY_BLOCK_A1_0_11).add(SOUL_SAND_A1_2_0).setReplace(false);
            getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(OBSIDIAN_C0_28A).setReplace(false);
            getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(GOLD_ORE_C0_0_14A).add(GOLD_ORE_C0_26ST).add(GOLD_ORE_1_14).add(GOLD_BLOCK_C0_0_20A).add(GOLD_BLOCK_C0_26ST).add(GOLD_BLOCK_A1_2_0).add(GOLD_BLOCK_B1_9PRE5).add(DIAMOND_ORE_IN20100128).add(DIAMOND_ORE_1_14).add(DIAMOND_BLOCK_IN20100128).add(DIAMOND_BLOCK_A1_2_0).add(DIAMOND_BLOCK_B1_9PRE5).add(REDSTONE_ORE_A1_0_1).add(REDSTONE_ORE_1_14).setReplace(false);
            getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).add(IRON_ORE_C0_0_14A).add(IRON_ORE_1_14).add(IRON_ORE_1_14_1).add(IRON_BLOCK_C0_26ST).add(IRON_BLOCK_A1_2_0).add(IRON_BLOCK_B1_9PRE5).setReplace(false);
            getOrCreateTagBuilder(TagList.Blocks.LEGACY_BLOCKS).add(COBBLESTONE_RD20090515).add(COBBLESTONE_C_0_0_14A).add(COBBLESTONE_B1_7).add(WOODEN_PLANKS_RD20090515).add(WOODEN_PLANKS_RD161348).add(WOODEN_PLANKS_C0_0_14A).add(WOODEN_PLANKS_C0_0_15A).add(WOODEN_PLANKS_B1_9PRE5).add(SAPLING_RD161348).add(SAPLING_C0_0_13A).add(SAPLING_C0_24ST).add(BEDROCK_C0_0_12A).add(SAND_C0_0_14A).add(SAND_C0_0_15A).add(SAND_B1_9PRE6).add(GRAVEL_C0_0_14A).add(GRAVEL_C0_0_15A).add(GRAVEL_B1_9PRE5).add(GRAVEL_1_3).add(COAL_ORE_C0_0_14A).add(COAL_ORE_1_14).add(IRON_ORE_C0_0_14A).add(IRON_ORE_1_14).add(IRON_ORE_1_14_1).add(GOLD_ORE_C0_0_14A).add(GOLD_ORE_C0_26ST).add(GOLD_ORE_1_14).add(LOG_C0_0_14A).add(LEAVES_C0_0_14A).add(LEAVES_C0_0_15A).add(LEAVES_C0_24ST).add(SPONGE_C0_0_19A).add(SPONGE_1_8).add(WET_SPONGE_1_8).add(GLASS_C0_0_19A).add(WHITE_CLOTH).add(LIGHT_GRAY_CLOTH_C0_0_20A).add(LIGHT_GRAY_CLOTH_C0_28A).add(DARK_GRAY_CLOTH_C0_0_20A).add(DARK_GRAY_CLOTH_C0_28A).add(RED_CLOTH).add(ORANGE_CLOTH).add(YELLOW_CLOTH).add(CHARTREUSE_CLOTH).add(SPRING_GREEN_CLOTH).add(CYAN_CLOTH).add(CAPRI_CLOTH).add(ULTRAMARINE_CLOTH).add(VIOLET_CLOTH).add(PURPLE_CLOTH).add(MAGENTA_CLOTH).add(ROSE_CLOTH).add(GOLD_BLOCK_C0_0_20A).add(GOLD_BLOCK_C0_26ST).add(GOLD_BLOCK_A1_2_0).add(GOLD_BLOCK_B1_9PRE5).add(DANDELION_C0_0_20A).add(ROSE_C0_0_20A).add(POPPY_1_7).add(RED_MUSHROOM_C0_0_20A).add(BROWN_MUSHROOM_C0_0_20A).add(STONE_SLAB_C0_26ST).add(IRON_BLOCK_C0_26ST).add(IRON_BLOCK_A1_2_0).add(IRON_BLOCK_B1_9PRE5).add(TNT_C0_26ST).add(TNT_C0_28A).add(MOSSY_COBBLESTONE_C0_26ST).add(MOSSY_COBBLESTONE_B1_8).add(BRICKS_C0_26ST).add(BRICKS_A1_0_11).add(BOOKSHELF_C0_26ST).add(BOOKSHELF_B1_9PRE5).add(OBSIDIAN_C0_28A).add(TORCH_IN20100124_2).add(WALL_TORCH_IN20100124_2).add(DIAMOND_ORE_IN20100128).add(DIAMOND_ORE_1_14).add(DIAMOND_BLOCK_IN20100128).add(DIAMOND_BLOCK_A1_2_0).add(DIAMOND_BLOCK_B1_9PRE5).add(CRAFTING_TABLE_IN20100131).add(CRAFTING_TABLE_1_14).add(FURNACE_IN20100219).add(LIT_FURNACE_IN20100219).add(FURNACE_B1_2).add(LIT_FURNACE_B1_2).add(LADDER_INF20100607).add(LADDER_INF20100618).add(SIGN_INF20100607).add(WALL_SIGN_INF20100607).add(WOODEN_DOOR_INF20100607).add(WOODEN_STAIRS_RD20090515).add(WOODEN_STAIRS_RD161348).add(WOODEN_STAIRS_C0_0_14A).add(WOODEN_STAIRS_INF20100629).add(WOODEN_STAIRS_B1_9PRE5).add(COBBLESTONE_STAIRS_RD20090515).add(COBBLESTONE_STAIRS_C0_0_14A).add(COBBLESTONE_STAIRS_B1_7).add(REDSTONE_ORE_A1_0_1).add(REDSTONE_ORE_1_14).add(REDSTONE_TORCH_A1_0_1).add(REDSTONE_WALL_TORCH_A1_0_1).add(SNOW_A1_0_4).add(ICE_A1_0_4).add(SNOW_BLOCK_A1_0_5).add(CLAY_BLOCK_A1_0_11).add(WOODEN_FENCE_RD20090515).add(WOODEN_FENCE_RD161348).add(WOODEN_FENCE_C0_0_14A).add(WOODEN_FENCE_A1_0_17).add(WOODEN_FENCE_B1_9PRE5).add(NETHERRACK_A1_2_0).add(NETHERRACK_B1_9PRE5).add(SOUL_SAND_A1_2_0).add(GLOWSTONE_A1_2_0).add(GLOWSTONE_B1_9PRE5).add(CARVED_PUMPKIN_A1_2_0).add(JACK_O_LANTERN_A1_2_0);
            getOrCreateTagBuilder(TagList.Blocks.PALM_LOGS).add(PALM_LOG).add(STRIPPED_PALM_LOG).add(PALM_WOOD).add(STRIPPED_PALM_WOOD);
            getOrCreateTagBuilder(TagList.Blocks.GOLDEN_BLOCKS).add(Blocks.GOLD_BLOCK).add(GOLD_BLOCK_C0_0_20A).add(GOLD_BLOCK_C0_26ST).add(GOLD_BLOCK_A1_2_0).add(GOLD_BLOCK_B1_9PRE5);
            getOrCreateTagBuilder(TagList.Blocks.IRON_BLOCKS).add(Blocks.IRON_BLOCK).add(IRON_BLOCK_C0_26ST).add(IRON_BLOCK_A1_2_0).add(IRON_BLOCK_B1_9PRE5);
            getOrCreateTagBuilder(TagList.Blocks.DIAMOND_BLOCKS).add(Blocks.DIAMOND_BLOCK).add(DIAMOND_BLOCK_IN20100128).add(DIAMOND_BLOCK_A1_2_0).add(DIAMOND_BLOCK_B1_9PRE5);
            getOrCreateTagBuilder(TagList.Blocks.LEGACY_COBBLESTONE).add(COBBLESTONE_RD20090515).add(COBBLESTONE_C_0_0_14A).add(COBBLESTONE_B1_7);
            getOrCreateTagBuilder(BlockTags.INFINIBURN_OVERWORLD).add(NETHERRACK_A1_2_0).add(NETHERRACK_B1_9PRE5).setReplace(false);
            getOrCreateTagBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS).add(SOUL_SAND_A1_2_0).setReplace(false);
            getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(PALM_HANGING_SIGN).setReplace(false);
            getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE).add(BEDROCK_C0_0_12A).setReplace(false);
            getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(PALM_FENCE_GATE).setReplace(false);
            getOrCreateTagBuilder(BlockTags.INFINIBURN_END).add(BEDROCK_C0_0_12A).setReplace(false);
            getOrCreateTagBuilder(BlockTags.LEAVES).add(PALM_LEAVES).add(LEAVES_C0_0_14A).add(LEAVES_C0_0_15A).add(LEAVES_C0_24ST).setReplace(false);
            getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).addTag(TagList.Blocks.PALM_LOGS).add(LOG_C0_0_14A).setReplace(false);
            getOrCreateTagBuilder(BlockTags.PLANKS).add(PALM_PLANKS).add(WOODEN_PLANKS_RD20090515).add(WOODEN_PLANKS_RD161348).add(WOODEN_PLANKS_C0_0_14A).add(WOODEN_PLANKS_C0_0_15A).add(WOODEN_PLANKS_B1_9PRE5).setReplace(false);
            getOrCreateTagBuilder(BlockTags.SAPLINGS).add(PALM_SAPLING).add(SAPLING_RD161348).add(SAPLING_C0_0_13A).add(SAPLING_C0_24ST).setReplace(false);
            getOrCreateTagBuilder(BlockTags.SLABS).add(STONE_SLAB_C0_26ST).setReplace(false);
            getOrCreateTagBuilder(BlockTags.STAIRS).add(COBBLESTONE_STAIRS_RD20090515).add(COBBLESTONE_STAIRS_C0_0_14A).add(COBBLESTONE_STAIRS_B1_7).setReplace(false);
            getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(PALM_SIGN).add(SIGN_INF20100607).setReplace(false);
            getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(PALM_WALL_HANGING_SIGN).setReplace(false);
            getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(PALM_WALL_SIGN).add(WALL_SIGN_INF20100607).setReplace(false);
            getOrCreateTagBuilder(BlockTags.WITHER_IMMUNE).add(BEDROCK_C0_0_12A).setReplace(false);
            getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(PALM_BUTTON).setReplace(false);
            getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(PALM_DOOR).add(WOODEN_DOOR_INF20100607).setReplace(false);
            getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(PALM_FENCE).add(WOODEN_FENCE_RD20090515).add(WOODEN_FENCE_RD161348).add(WOODEN_FENCE_C0_0_14A).add(WOODEN_FENCE_A1_0_17).add(WOODEN_FENCE_B1_9PRE5).setReplace(false);
            getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(PALM_PRESSURE_PLATE).setReplace(false);
            getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(PALM_SLAB).setReplace(false);
            getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(PALM_STAIRS).add(WOODEN_STAIRS_RD20090515).add(WOODEN_STAIRS_RD161348).add(WOODEN_STAIRS_C0_0_14A).add(WOODEN_STAIRS_INF20100629).add(WOODEN_STAIRS_B1_9PRE5).setReplace(false);
            getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(PALM_TRAPDOOR).setReplace(false);
            getOrCreateTagBuilder(BlockTags.WOOL).add(WHITE_CLOTH).add(LIGHT_GRAY_CLOTH_C0_0_20A).add(LIGHT_GRAY_CLOTH_C0_28A).add(DARK_GRAY_CLOTH_C0_0_20A).add(DARK_GRAY_CLOTH_C0_28A).add(RED_CLOTH).add(ORANGE_CLOTH).add(YELLOW_CLOTH).add(CHARTREUSE_CLOTH).add(SPRING_GREEN_CLOTH).add(CYAN_CLOTH).add(CAPRI_CLOTH).add(ULTRAMARINE_CLOTH).add(VIOLET_CLOTH).add(PURPLE_CLOTH).add(MAGENTA_CLOTH).add(ROSE_CLOTH).setReplace(false);
            getOrCreateTagBuilder(BlockTags.ENCHANTMENT_POWER_PROVIDER).add(BOOKSHELF_C0_26ST).add(BOOKSHELF_B1_9PRE5).setReplace(false);
            getOrCreateTagBuilder(BlockTags.CLIMBABLE).add(LADDER_INF20100607).add(LADDER_INF20100618).setReplace(false);
        }
    }

    public static class BlocktopiaItemTagProvider extends FabricTagProvider.ItemTagProvider {
        public BlocktopiaItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            getOrCreateTagBuilder(ItemTags.EQUIPPABLE_ENCHANTABLE).add(CARVED_PUMPKIN_A1_2_0.asItem()).setReplace(false);
            getOrCreateTagBuilder(ItemTags.VANISHING_ENCHANTABLE).add(CARVED_PUMPKIN_A1_2_0.asItem()).setReplace(false);
            getOrCreateTagBuilder(TagList.Items.LEGACY_BLOCKS).add(COBBLESTONE_RD20090515.asItem()).add(COBBLESTONE_C_0_0_14A.asItem()).add(COBBLESTONE_B1_7.asItem()).add(WOODEN_PLANKS_RD20090515.asItem()).add(WOODEN_PLANKS_RD161348.asItem()).add(WOODEN_PLANKS_C0_0_14A.asItem()).add(WOODEN_PLANKS_C0_0_15A.asItem()).add(WOODEN_PLANKS_B1_9PRE5.asItem()).add(SAPLING_RD161348.asItem()).add(SAPLING_C0_0_13A.asItem()).add(SAPLING_C0_24ST.asItem()).add(BEDROCK_C0_0_12A.asItem()).add(SAND_C0_0_14A.asItem()).add(SAND_C0_0_15A.asItem()).add(SAND_B1_9PRE6.asItem()).add(GRAVEL_C0_0_14A.asItem()).add(GRAVEL_C0_0_15A.asItem()).add(GRAVEL_B1_9PRE5.asItem()).add(GRAVEL_1_3.asItem()).add(COAL_ORE_C0_0_14A.asItem()).add(COAL_ORE_1_14.asItem()).add(IRON_ORE_C0_0_14A.asItem()).add(IRON_ORE_1_14.asItem()).add(IRON_ORE_1_14_1.asItem()).add(GOLD_ORE_C0_0_14A.asItem()).add(GOLD_ORE_C0_26ST.asItem()).add(GOLD_ORE_1_14.asItem()).add(LOG_C0_0_14A.asItem()).add(LEAVES_C0_0_14A.asItem()).add(LEAVES_C0_0_15A.asItem()).add(LEAVES_C0_24ST.asItem()).add(SPONGE_C0_0_19A.asItem()).add(SPONGE_1_8.asItem()).add(WET_SPONGE_1_8.asItem()).add(GLASS_C0_0_19A.asItem()).add(WHITE_CLOTH.asItem()).add(LIGHT_GRAY_CLOTH_C0_0_20A.asItem()).add(LIGHT_GRAY_CLOTH_C0_28A.asItem()).add(DARK_GRAY_CLOTH_C0_0_20A.asItem()).add(DARK_GRAY_CLOTH_C0_28A.asItem()).add(RED_CLOTH.asItem()).add(ORANGE_CLOTH.asItem()).add(YELLOW_CLOTH.asItem()).add(CHARTREUSE_CLOTH.asItem()).add(SPRING_GREEN_CLOTH.asItem()).add(CYAN_CLOTH.asItem()).add(CAPRI_CLOTH.asItem()).add(ULTRAMARINE_CLOTH.asItem()).add(VIOLET_CLOTH.asItem()).add(PURPLE_CLOTH.asItem()).add(MAGENTA_CLOTH.asItem()).add(ROSE_CLOTH.asItem()).add(GOLD_BLOCK_C0_0_20A.asItem()).add(GOLD_BLOCK_C0_26ST.asItem()).add(GOLD_BLOCK_A1_2_0.asItem()).add(GOLD_BLOCK_B1_9PRE5.asItem()).add(DANDELION_C0_0_20A.asItem()).add(ROSE_C0_0_20A.asItem()).add(POPPY_1_7.asItem()).add(RED_MUSHROOM_C0_0_20A.asItem()).add(BROWN_MUSHROOM_C0_0_20A.asItem()).add(STONE_SLAB_C0_26ST.asItem()).add(IRON_BLOCK_C0_26ST.asItem()).add(IRON_BLOCK_A1_2_0.asItem()).add(IRON_BLOCK_B1_9PRE5.asItem()).add(TNT_C0_26ST.asItem()).add(TNT_C0_28A.asItem()).add(MOSSY_COBBLESTONE_C0_26ST.asItem()).add(MOSSY_COBBLESTONE_B1_8.asItem()).add(BRICKS_C0_26ST.asItem()).add(BRICKS_A1_0_11.asItem()).add(BOOKSHELF_C0_26ST.asItem()).add(BOOKSHELF_B1_9PRE5.asItem()).add(OBSIDIAN_C0_28A.asItem()).add(ItemInit.TORCH_IN20100124_2).add(DIAMOND_ORE_IN20100128.asItem()).add(DIAMOND_ORE_1_14.asItem()).add(DIAMOND_BLOCK_IN20100128.asItem()).add(DIAMOND_BLOCK_A1_2_0.asItem()).add(DIAMOND_BLOCK_B1_9PRE5.asItem()).add(CRAFTING_TABLE_IN20100131.asItem()).add(CRAFTING_TABLE_1_14.asItem()).add(FURNACE_IN20100219.asItem()).add(LIT_FURNACE_IN20100219.asItem()).add(FURNACE_B1_2.asItem()).add(LIT_FURNACE_B1_2.asItem()).add(LADDER_INF20100607.asItem()).add(LADDER_INF20100618.asItem()).add(ItemInit.SIGN_INF20100607).add(WOODEN_DOOR_INF20100607.asItem()).add(WOODEN_STAIRS_RD20090515.asItem()).add(WOODEN_STAIRS_RD161348.asItem()).add(WOODEN_STAIRS_C0_0_14A.asItem()).add(WOODEN_STAIRS_INF20100629.asItem()).add(WOODEN_STAIRS_B1_9PRE5.asItem()).add(COBBLESTONE_STAIRS_RD20090515.asItem()).add(COBBLESTONE_STAIRS_C0_0_14A.asItem()).add(COBBLESTONE_B1_7.asItem()).add(REDSTONE_ORE_A1_0_1.asItem()).add(REDSTONE_ORE_1_14.asItem()).add(REDSTONE_TORCH_A1_0_1.asItem()).add(REDSTONE_WALL_TORCH_A1_0_1.asItem()).add(SNOW_A1_0_4.asItem()).add(ICE_A1_0_4.asItem()).add(SNOW_BLOCK_A1_0_5.asItem()).add(CLAY_BLOCK_A1_0_11.asItem()).add(WOODEN_FENCE_RD20090515.asItem()).add(WOODEN_FENCE_RD161348.asItem()).add(WOODEN_FENCE_C0_0_14A.asItem()).add(WOODEN_FENCE_A1_0_17.asItem()).add(WOODEN_FENCE_B1_9PRE5.asItem()).add(NETHERRACK_A1_2_0.asItem()).add(NETHERRACK_B1_9PRE5.asItem()).add(SOUL_SAND_A1_2_0.asItem()).add(GLOWSTONE_A1_2_0.asItem()).add(GLOWSTONE_B1_9PRE5.asItem()).add(CARVED_PUMPKIN_A1_2_0.asItem()).add(JACK_O_LANTERN_A1_2_0.asItem());
            getOrCreateTagBuilder(TagList.Items.PALM_LOGS).add(PALM_LOG.asItem()).add(STRIPPED_PALM_LOG.asItem()).add(PALM_WOOD.asItem()).add(STRIPPED_PALM_WOOD.asItem());
            getOrCreateTagBuilder(TagList.Items.GOLDEN_BLOCKS).add(Items.GOLD_BLOCK).add(GOLD_BLOCK_C0_0_20A.asItem()).add(GOLD_BLOCK_C0_26ST.asItem()).add(GOLD_BLOCK_A1_2_0.asItem()).add(GOLD_BLOCK_B1_9PRE5.asItem());
            getOrCreateTagBuilder(TagList.Items.IRON_BLOCKS).add(Items.IRON_BLOCK).add(IRON_BLOCK_C0_26ST.asItem()).add(IRON_BLOCK_A1_2_0.asItem()).add(IRON_BLOCK_B1_9PRE5.asItem());
            getOrCreateTagBuilder(TagList.Items.DIAMOND_BLOCKS).add(Items.DIAMOND_BLOCK).add(DIAMOND_BLOCK_IN20100128.asItem()).add(DIAMOND_BLOCK_A1_2_0.asItem()).add(DIAMOND_BLOCK_B1_9PRE5.asItem());
            getOrCreateTagBuilder(TagList.Items.LEGACY_COBBLESTONE).add(COBBLESTONE_RD20090515.asItem()).add(COBBLESTONE_C_0_0_14A.asItem()).add(COBBLESTONE_B1_7.asItem());
            getOrCreateTagBuilder(ItemTags.FENCES).add(PALM_FENCE.asItem()).add(WOODEN_FENCE_RD161348.asItem()).add(WOODEN_FENCE_C0_0_14A.asItem()).add(WOODEN_FENCE_A1_0_17.asItem()).add(WOODEN_FENCE_B1_9PRE5.asItem()).setReplace(false);
            getOrCreateTagBuilder(ItemTags.BOATS).add(ItemInit.PALM_BOAT).setReplace(false);
            getOrCreateTagBuilder(ItemTags.CHEST_BOATS).add(ItemInit.PALM_CHEST_BOAT).setReplace(false);
            getOrCreateTagBuilder(ItemTags.HANGING_SIGNS).add(ItemInit.PALM_HANGING_SIGN).setReplace(false);
            getOrCreateTagBuilder(ItemTags.LEAVES).add(PALM_LEAVES.asItem()).add(LEAVES_C0_0_14A.asItem()).add(LEAVES_C0_0_15A.asItem()).add(LEAVES_C0_24ST.asItem()).setReplace(false);
            getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).addTag(TagList.Items.PALM_LOGS).add(LOG_C0_0_14A.asItem()).setReplace(false);
            getOrCreateTagBuilder(ItemTags.PLANKS).add(PALM_PLANKS.asItem()).add(WOODEN_PLANKS_RD20090515.asItem()).add(WOODEN_PLANKS_RD161348.asItem()).add(WOODEN_PLANKS_C0_0_14A.asItem()).add(WOODEN_PLANKS_C0_0_15A.asItem()).add(WOODEN_PLANKS_B1_9PRE5.asItem()).setReplace(false);
            getOrCreateTagBuilder(ItemTags.SAPLINGS).add(PALM_SAPLING.asItem()).add(SAPLING_RD161348.asItem()).add(SAPLING_C0_0_13A.asItem()).add(SAPLING_C0_24ST.asItem()).setReplace(false);
            getOrCreateTagBuilder(ItemTags.SIGNS).add(ItemInit.PALM_SIGN).add(ItemInit.SIGN_INF20100607).setReplace(false);
            getOrCreateTagBuilder(ItemTags.SLABS).add(STONE_SLAB_C0_26ST.asItem()).setReplace(false);
            getOrCreateTagBuilder(ItemTags.STAIRS).add(COBBLESTONE_STAIRS_RD20090515.asItem()).add(COBBLESTONE_STAIRS_C0_0_14A.asItem()).add(COBBLESTONE_STAIRS_B1_7.asItem()).setReplace(false);
            getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(PALM_BUTTON.asItem()).setReplace(false);
            getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(PALM_DOOR.asItem()).add(WOODEN_DOOR_INF20100607.asItem()).setReplace(false);
            getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(PALM_FENCE.asItem()).setReplace(false);
            getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(PALM_PRESSURE_PLATE.asItem()).setReplace(false);
            getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(PALM_SLAB.asItem()).setReplace(false);
            getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(PALM_STAIRS.asItem()).add(WOODEN_STAIRS_RD20090515.asItem()).add(WOODEN_STAIRS_RD161348.asItem()).add(WOODEN_STAIRS_C0_0_14A.asItem()).add(WOODEN_STAIRS_INF20100629.asItem()).add(WOODEN_STAIRS_B1_9PRE5.asItem()).setReplace(false);
            getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).add(PALM_TRAPDOOR.asItem()).setReplace(false);
            getOrCreateTagBuilder(ItemTags.WOOL).add(WHITE_CLOTH.asItem()).add(LIGHT_GRAY_CLOTH_C0_0_20A.asItem()).add(LIGHT_GRAY_CLOTH_C0_28A.asItem()).add(DARK_GRAY_CLOTH_C0_0_20A.asItem()).add(DARK_GRAY_CLOTH_C0_28A.asItem()).add(RED_CLOTH.asItem()).add(ORANGE_CLOTH.asItem()).add(YELLOW_CLOTH.asItem()).add(CHARTREUSE_CLOTH.asItem()).add(SPRING_GREEN_CLOTH.asItem()).add(CYAN_CLOTH.asItem()).add(CAPRI_CLOTH.asItem()).add(ULTRAMARINE_CLOTH.asItem()).add(VIOLET_CLOTH.asItem()).add(PURPLE_CLOTH.asItem()).add(MAGENTA_CLOTH.asItem()).add(ROSE_CLOTH.asItem()).setReplace(false);
        }
    }
}
