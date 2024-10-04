package github.mcdatapack.blocktopia.datagen.provider;

import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;

import static github.mcdatapack.blocktopia.init.blocks.LegacyBlocks.*;
import static github.mcdatapack.blocktopia.list.TagList.Items.*;
import static net.minecraft.item.Items.*;

import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.resource.featuretoggle.FeatureSet;
import org.jetbrains.annotations.NotNull;

public class BlocktopiaRecipeProvider extends FabricRecipeProvider {
    public BlocktopiaRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, GOLD_INGOT, 9)
                .input(GOLDEN_BLOCKS)
                .criterion(hasItem(GOLD_INGOT), conditionsFromItem(GOLD_INGOT))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, IRON_INGOT, 9).input(IRON_BLOCKS)
                .criterion(hasItem(IRON_INGOT), conditionsFromItem(IRON_INGOT))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, DIAMOND, 9)
                .input(DIAMOND_BLOCKS)
                .criterion(hasItem(DIAMOND), conditionsFromItem(DIAMOND))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BlockInit.GUNPOWDER_BLOCK)
                .input('A', GUNPOWDER)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(GUNPOWDER), conditionsFromItem(GUNPOWDER))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, GUNPOWDER, 9)
                .input(BlockInit.GUNPOWDER_BLOCK)
                .criterion(hasItem(GUNPOWDER), conditionsFromItem(GUNPOWDER))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BlockInit.PAPER_BLOCK)
                .input('A', PAPER)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(PAPER), conditionsFromItem(PAPER))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, PAPER, 9)
                .input(BlockInit.PAPER_BLOCK)
                .criterion(hasItem(PAPER), conditionsFromItem(PAPER))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BlockInit.SMALL_CHEST)
                .input('A', ItemTags.WOODEN_SLABS)
                .pattern("AAA")
                .pattern("A A")
                .pattern("AAA")
                .criterion(hasTag(ItemTags.WOODEN_SLABS), conditionsFromTag(ItemTags.WOODEN_SLABS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ENCHANTED_GOLDEN_APPLE)
                .input('A', GOLDEN_BLOCKS)
                .input('B', APPLE)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(APPLE), conditionsFromItem(APPLE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemInit.ENCHANTED_GOLDEN_BAKED_POTATO)
                .input('A', GOLD_INGOT)
                .input('B', BAKED_POTATO)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(POTATO), conditionsFromItem(POTATO))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemInit.GOLDEN_BAKED_POTATO)
                .input('A', GOLD_NUGGET)
                .input('B', BAKED_POTATO)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(POTATO), conditionsFromItem(POTATO))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemInit.ENCHANTED_GOLDEN_CARROT)
                .input('A', GOLD_INGOT)
                .input('B', CARROT)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(CARROT), conditionsFromItem(CARROT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemInit.ENCHANTED_GOLDEN_COCONUT)
                .input('A', GOLD_BLOCK)
                .input('B', ItemInit.COCONUT)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ItemInit.COCONUT), conditionsFromItem(ItemInit.COCONUT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemInit.GOLDEN_COCONUT)
                .input('A', GOLD_INGOT)
                .input('B', ItemInit.COCONUT)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ItemInit.COCONUT), conditionsFromItem(ItemInit.COCONUT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemInit.ENCHANTED_GOLDEN_POTATO)
                .input('A', GOLD_INGOT)
                .input('B', POTATO)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(POTATO), conditionsFromItem(POTATO))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemInit.GOLDEN_POTATO)
                .input('A', GOLD_NUGGET)
                .input('B', POTATO)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(POTATO), conditionsFromItem(POTATO))
                .offerTo(exporter);
        List<ItemConvertible> golden_potato = List.of(ItemInit.GOLDEN_POTATO);
        List<ItemConvertible> enchanted_golden_potato = List.of(ItemInit.ENCHANTED_GOLDEN_POTATO);
        RecipeProvider.offerSmelting(exporter, golden_potato, RecipeCategory.FOOD, ItemInit.GOLDEN_BAKED_POTATO, 1.0F, 200, "golden_baked_potato");
        RecipeProvider.offerSmelting(exporter, enchanted_golden_potato, RecipeCategory.FOOD, ItemInit.ENCHANTED_GOLDEN_BAKED_POTATO, 1.0F, 200, "enchanted_golden_baked_potato");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.PALM_PLANKS, 4)
                .input(PALM_LOGS)
                .criterion(hasTag(PALM_LOGS), conditionsFromTag(PALM_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.PALM_SLAB, 6)
                .input('A', BlockInit.PALM_PLANKS)
                .pattern("AAA")
                .criterion(hasItem(BlockInit.PALM_PLANKS), conditionsFromItem(BlockInit.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.PALM_STAIRS, 4)
                .input('A', BlockInit.PALM_PLANKS)
                .pattern("A  ").pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(BlockInit.PALM_PLANKS), conditionsFromItem(BlockInit.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.PALM_FENCE, 3)
                .input('A', BlockInit.PALM_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(BlockInit.PALM_PLANKS), conditionsFromItem(BlockInit.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.PALM_FENCE_GATE)
                .input('A', BlockInit.PALM_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("BAB")
                .pattern("BAB")
                .criterion(hasItem(BlockInit.PALM_PLANKS), conditionsFromItem(BlockInit.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.PALM_DOOR, 3)
                .input('A', BlockInit.PALM_PLANKS)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .criterion(hasItem(BlockInit.PALM_PLANKS), conditionsFromItem(BlockInit.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.PALM_TRAPDOOR, 2)
                .input('A', BlockInit.PALM_PLANKS)
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(BlockInit.PALM_PLANKS), conditionsFromItem(BlockInit.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BlockInit.PALM_BUTTON)
                .input('A', BlockInit.PALM_PLANKS)
                .pattern("A")
                .criterion(hasItem(BlockInit.PALM_PLANKS), conditionsFromItem(BlockInit.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BlockInit.PALM_PRESSURE_PLATE)
                .input('A', BlockInit.PALM_PLANKS)
                .pattern("AA")
                .criterion(hasItem(BlockInit.PALM_PLANKS), conditionsFromItem(BlockInit.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.PALM_SIGN, 3)
                .input('A', BlockInit.PALM_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("AAA")
                .pattern("AAA")
                .pattern(" B ")
                .criterion(hasItem(BlockInit.PALM_PLANKS), conditionsFromItem(BlockInit.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.PALM_HANGING_SIGN, 6)
                .input('A', BlockInit.STRIPPED_PALM_LOG)
                .input('B', ConventionalItemTags.CHAINS)
                .pattern("B B")
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(BlockInit.PALM_PLANKS), conditionsFromItem(BlockInit.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ItemInit.PALM_BOAT)
                .input('A', BlockInit.PALM_PLANKS)
                .pattern("A A")
                .pattern("AAA")
                .criterion(hasItem(BlockInit.PALM_PLANKS), conditionsFromItem(BlockInit.PALM_PLANKS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ItemInit.PALM_CHEST_BOAT)
                .input(ItemInit.PALM_BOAT)
                .input(ConventionalItemTags.WOODEN_CHESTS)
                .criterion(hasItem(BlockInit.PALM_PLANKS), conditionsFromItem(BlockInit.PALM_PLANKS))
                .criterion(hasItem(CHEST), conditionsFromItem(CHEST)).offerTo(exporter);
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
        generateFamily(exporter, palmFamaly, FeatureSet.empty());
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_RD20090515, COBBLESTONE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLESTONE, COBBLESTONE_RD20090515);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_C_0_0_14A, COBBLESTONE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLESTONE, COBBLESTONE_C_0_0_14A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_B1_7, COBBLESTONE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLESTONE, COBBLESTONE_B1_7);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_PLANKS_RD20090515, OAK_PLANKS);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_PLANKS, WOODEN_PLANKS_RD20090515);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_PLANKS_RD161348, OAK_PLANKS);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_PLANKS, WOODEN_PLANKS_RD161348);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_PLANKS_C0_0_14A, OAK_PLANKS);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_PLANKS_C0_0_14A, 4)
                .input(LOG_C0_0_14A)
                .criterion(hasItem(LOG_C0_0_14A), conditionsFromItem(LOG_C0_0_14A))
                .offerTo(exporter);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_PLANKS, WOODEN_PLANKS_C0_0_14A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_PLANKS_C0_0_15A, OAK_PLANKS);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_PLANKS_C0_0_15A, 8)
                .input(LOG_C0_0_14A)
                .input(LOG_C0_0_14A)
                .criterion(hasItem(LOG_C0_0_14A), conditionsFromItem(LOG_C0_0_14A))
                .offerTo(exporter);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_PLANKS, WOODEN_PLANKS_C0_0_15A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_PLANKS_B1_9PRE5, OAK_PLANKS);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_PLANKS_B1_9PRE5, 12)
                .input(LOG_C0_0_14A)
                .input(LOG_C0_0_14A)
                .input(LOG_C0_0_14A)
                .criterion(hasItem(LOG_C0_0_14A), conditionsFromItem(LOG_C0_0_14A))
                .offerTo(exporter);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_PLANKS, WOODEN_PLANKS_B1_9PRE5);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LOG_C0_0_14A, OAK_LOG);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_LOG, LOG_C0_0_14A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LEAVES_C0_0_14A, OAK_LEAVES);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_LEAVES, LEAVES_C0_0_14A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LEAVES_C0_0_15A, OAK_LEAVES);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_LEAVES, LEAVES_C0_0_15A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LEAVES_C0_24ST, OAK_LEAVES);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_LEAVES, LEAVES_C0_24ST);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SAPLING_RD161348, OAK_SAPLING);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_SAPLING, SAPLING_RD161348);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SAPLING_C0_0_13A, OAK_SAPLING);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_SAPLING, SAPLING_C0_0_13A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SAPLING_C0_24ST, OAK_SAPLING);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_SAPLING, SAPLING_C0_24ST);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BEDROCK_C0_0_12A, BEDROCK);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BEDROCK, BEDROCK_C0_0_12A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SAND_C0_0_14A, SAND);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SAND, SAND_C0_0_14A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SAND_C0_0_15A, SAND);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SAND, SAND_C0_0_15A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SAND_B1_9PRE6, SAND);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SAND, SAND_B1_9PRE6);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAVEL_C0_0_14A, GRAVEL);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAVEL, GRAVEL_C0_0_14A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAVEL_C0_0_15A, GRAVEL);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAVEL, GRAVEL_C0_0_15A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAVEL_B1_9PRE5, GRAVEL);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAVEL, GRAVEL_B1_9PRE5);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAVEL_1_3, GRAVEL);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAVEL, GRAVEL_1_3);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COAL_ORE_C0_0_14A, COAL_ORE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COAL_ORE, COAL_ORE_C0_0_14A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COAL_ORE_1_14, COAL_ORE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COAL_ORE, COAL_ORE_1_14);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, IRON_ORE_C0_0_14A, IRON_ORE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, IRON_ORE, IRON_ORE_C0_0_14A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, IRON_ORE_1_14, IRON_ORE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, IRON_ORE, IRON_ORE_1_14);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, IRON_ORE_1_14_1, IRON_ORE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, IRON_ORE, IRON_ORE_1_14_1);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GOLD_ORE_C0_0_14A, GOLD_ORE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GOLD_ORE, GOLD_ORE_C0_0_14A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GOLD_ORE_C0_26ST, GOLD_ORE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GOLD_ORE, GOLD_ORE_C0_26ST);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GOLD_ORE_1_14, GOLD_ORE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GOLD_ORE, GOLD_ORE_1_14);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SPONGE_C0_0_19A, SPONGE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SPONGE, SPONGE_C0_0_19A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SPONGE_1_8, SPONGE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SPONGE, SPONGE_1_8);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WET_SPONGE_1_8, WET_SPONGE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WET_SPONGE, WET_SPONGE_1_8);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GLASS_C0_0_19A, GLASS);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GLASS, GLASS_C0_0_19A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GOLD_BLOCK_C0_0_20A, GOLD_BLOCK);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GOLD_BLOCK, GOLD_BLOCK_C0_0_20A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GOLD_BLOCK_C0_26ST, GOLD_BLOCK);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GOLD_BLOCK, GOLD_BLOCK_C0_26ST);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GOLD_BLOCK_A1_2_0, GOLD_BLOCK);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GOLD_BLOCK, GOLD_BLOCK_A1_2_0);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GOLD_BLOCK_B1_9PRE5, GOLD_BLOCK);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GOLD_BLOCK, GOLD_BLOCK_B1_9PRE5);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DANDELION_C0_0_20A, DANDELION);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DANDELION, DANDELION_C0_0_20A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ROSE_C0_0_20A, POPPY);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POPPY, ROSE_C0_0_20A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POPPY_1_7, POPPY);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POPPY, POPPY_1_7);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_MUSHROOM_C0_0_20A, BROWN_MUSHROOM);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_MUSHROOM, BROWN_MUSHROOM_C0_0_20A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_MUSHROOM_C0_0_20A, RED_MUSHROOM);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_MUSHROOM, RED_MUSHROOM_C0_0_20A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, IRON_BLOCK_C0_26ST, IRON_BLOCK);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, IRON_BLOCK, IRON_BLOCK_C0_26ST);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, IRON_BLOCK_A1_2_0, IRON_BLOCK);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, IRON_BLOCK, IRON_BLOCK_A1_2_0);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, IRON_BLOCK_B1_9PRE5, IRON_BLOCK);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, IRON_BLOCK, IRON_BLOCK_B1_9PRE5);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TNT_C0_26ST, TNT);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TNT, TNT_C0_26ST);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TNT_C0_28A, TNT);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TNT, TNT_C0_28A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLESTONE_C0_26ST, MOSSY_COBBLESTONE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLESTONE, MOSSY_COBBLESTONE_C0_26ST);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLESTONE_B1_8, MOSSY_COBBLESTONE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLESTONE, MOSSY_COBBLESTONE_B1_8);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BRICKS_C0_26ST, BRICKS);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BRICKS, BRICKS_C0_26ST);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BRICKS_A1_0_11, BRICKS);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BRICKS, BRICKS_A1_0_11);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BOOKSHELF_C0_26ST, BOOKSHELF);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BOOKSHELF, BOOKSHELF_C0_26ST);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BOOKSHELF_B1_9PRE5, BOOKSHELF);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BOOKSHELF, BOOKSHELF_B1_9PRE5);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OBSIDIAN_C0_28A, OBSIDIAN);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OBSIDIAN, OBSIDIAN_C0_28A);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIAMOND_ORE_IN20100128, DIAMOND_ORE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIAMOND_ORE, DIAMOND_ORE_IN20100128);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIAMOND_ORE_1_14, DIAMOND_ORE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIAMOND_ORE, DIAMOND_ORE_1_14);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIAMOND_BLOCK_IN20100128, DIAMOND_BLOCK);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIAMOND_BLOCK, DIAMOND_BLOCK_IN20100128);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIAMOND_BLOCK_A1_2_0, DIAMOND_BLOCK);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIAMOND_BLOCK, DIAMOND_BLOCK_A1_2_0);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIAMOND_BLOCK_B1_9PRE5, DIAMOND_BLOCK);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIAMOND_BLOCK, DIAMOND_BLOCK_B1_9PRE5);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRAFTING_TABLE_IN20100131, CRAFTING_TABLE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRAFTING_TABLE, CRAFTING_TABLE_IN20100131);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRAFTING_TABLE_1_14, CRAFTING_TABLE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRAFTING_TABLE, CRAFTING_TABLE_1_14);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, FURNACE_IN20100219, FURNACE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, FURNACE, FURNACE_IN20100219);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, LIT_FURNACE_IN20100219)
                .input(FURNACE_IN20100219)
                .input(COAL)
                .criterion(hasItem(FURNACE_IN20100219), conditionsFromItem(FURNACE_IN20100219))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, FURNACE_IN20100219)
                .input(LIT_FURNACE_IN20100219)
                .input(WATER_BUCKET)
                .criterion(hasItem(FURNACE_IN20100219), conditionsFromItem(FURNACE_IN20100219))
                .offerTo(exporter);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, FURNACE_B1_2, FURNACE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, FURNACE, FURNACE_B1_2);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, LIT_FURNACE_B1_2)
                .input(FURNACE_B1_2)
                .input(COAL)
                .criterion(hasItem(FURNACE_B1_2), conditionsFromItem(FURNACE_B1_2))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, FURNACE_B1_2)
                .input(LIT_FURNACE_B1_2)
                .input(WATER_BUCKET)
                .criterion(hasItem(FURNACE_B1_2), conditionsFromItem(FURNACE_B1_2))
                .offerTo(exporter);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LADDER_INF20100607, LADDER);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LADDER, LADDER_INF20100607);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LADDER_INF20100618, LADDER);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LADDER, LADDER_INF20100618);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_STAIRS_RD20090515)
                .input('A', WOODEN_PLANKS_RD20090515)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(WOODEN_PLANKS_RD20090515), conditionsFromItem(WOODEN_PLANKS_RD20090515))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_STAIRS_RD161348)
                .input('A', WOODEN_PLANKS_RD161348)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(WOODEN_PLANKS_RD161348), conditionsFromItem(WOODEN_PLANKS_RD161348))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_STAIRS_C0_0_14A)
                .input('A', WOODEN_PLANKS_C0_0_14A)
                .pattern("A  ").pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(WOODEN_PLANKS_C0_0_14A), conditionsFromItem(WOODEN_PLANKS_C0_0_14A))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_STAIRS_INF20100629)
                .input('A', WOODEN_PLANKS_C0_0_15A)
                .pattern("A  ").pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(WOODEN_PLANKS_C0_0_15A), conditionsFromItem(WOODEN_PLANKS_C0_0_15A))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_STAIRS_B1_9PRE5)
                .input('A', WOODEN_PLANKS_B1_9PRE5)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(WOODEN_PLANKS_B1_9PRE5), conditionsFromItem(WOODEN_PLANKS_B1_9PRE5))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_STAIRS_RD20090515)
                .input('A', COBBLESTONE_RD20090515)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(COBBLESTONE_RD20090515), conditionsFromItem(COBBLESTONE_RD20090515))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_STAIRS_C0_0_14A)
                .input('A', COBBLESTONE_C_0_0_14A)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(COBBLESTONE_C_0_0_14A), conditionsFromItem(COBBLESTONE_C_0_0_14A))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_STAIRS_B1_7)
                .input('A', COBBLESTONE_B1_7)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(COBBLESTONE_B1_7), conditionsFromItem(COBBLESTONE_B1_7))
                .offerTo(exporter);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ItemInit.TORCH_IN20100124_2, TORCH);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TORCH, ItemInit.TORCH_IN20100124_2);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ItemInit.SIGN_INF20100607, OAK_SIGN);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_SIGN, ItemInit.SIGN_INF20100607);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ItemInit.SIGN_INF20100607)
                .input('A', WOODEN_PLANKS_C0_0_15A)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("AAA")
                .pattern("AAA")
                .pattern(" B ")
                .criterion(hasItem(WOODEN_PLANKS_C0_0_15A), conditionsFromItem(WOODEN_PLANKS_C0_0_15A))
                .offerTo(exporter);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_DOOR_INF20100607, OAK_DOOR);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_DOOR, WOODEN_DOOR_INF20100607);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_DOOR_INF20100607)
                .input('A', WOODEN_PLANKS_C0_0_15A)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .criterion(hasItem(WOODEN_PLANKS_C0_0_15A), conditionsFromItem(WOODEN_PLANKS_C0_0_15A))
                .offerTo(exporter);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, REDSTONE_ORE_A1_0_1, REDSTONE_ORE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, REDSTONE_ORE, REDSTONE_ORE_A1_0_1);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, REDSTONE_ORE_1_14, REDSTONE_ORE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, REDSTONE_ORE, REDSTONE_ORE_1_14);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, REDSTONE_TORCH_A1_0_1, REDSTONE_TORCH);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, REDSTONE_TORCH, REDSTONE_TORCH_A1_0_1);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SNOW_A1_0_4, SNOW);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SNOW, SNOW_A1_0_4);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SNOW_BLOCK_A1_0_5, SNOW_BLOCK);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SNOW_BLOCK, SNOW_BLOCK_A1_0_5);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ICE_A1_0_4, ICE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ICE, ICE_A1_0_4);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CLAY_BLOCK_A1_0_11, CLAY);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CLAY, CLAY_BLOCK_A1_0_11);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_FENCE_RD20090515, OAK_FENCE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_FENCE, WOODEN_FENCE_RD20090515);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_FENCE_RD20090515)
                .input('A', WOODEN_PLANKS_RD20090515)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(WOODEN_PLANKS_RD20090515), conditionsFromItem(WOODEN_PLANKS_RD20090515))
                .offerTo(exporter);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_FENCE_RD161348, OAK_FENCE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_FENCE, WOODEN_FENCE_RD161348);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_FENCE_RD161348)
                .input('A', WOODEN_PLANKS_RD161348)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(WOODEN_PLANKS_RD161348), conditionsFromItem(WOODEN_PLANKS_RD161348))
                .offerTo(exporter);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_FENCE_C0_0_14A, OAK_FENCE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_FENCE, WOODEN_FENCE_C0_0_14A);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_FENCE_C0_0_14A)
                .input('A', WOODEN_PLANKS_C0_0_14A)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(WOODEN_PLANKS_C0_0_14A), conditionsFromItem(WOODEN_PLANKS_C0_0_14A))
                .offerTo(exporter);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_FENCE_A1_0_17, OAK_FENCE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_FENCE, WOODEN_FENCE_A1_0_17);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_FENCE_A1_0_17)
                .input('A', WOODEN_PLANKS_C0_0_15A)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(WOODEN_PLANKS_C0_0_15A), conditionsFromItem(WOODEN_PLANKS_C0_0_15A))
                .offerTo(exporter);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_FENCE_B1_9PRE5, OAK_FENCE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, OAK_FENCE, WOODEN_FENCE_B1_9PRE5);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_FENCE_B1_9PRE5)
                .input('A', WOODEN_PLANKS_B1_9PRE5)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(WOODEN_PLANKS_B1_9PRE5), conditionsFromItem(WOODEN_PLANKS_B1_9PRE5))
                .offerTo(exporter);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHERRACK_A1_2_0, NETHERRACK);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHERRACK, NETHERRACK_A1_2_0);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHERRACK_B1_9PRE5, NETHERRACK);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHERRACK, NETHERRACK_B1_9PRE5);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SOUL_SAND_A1_2_0, SOUL_SAND);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SOUL_SAND, SOUL_SAND_A1_2_0);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GLOWSTONE_A1_2_0, GLOWSTONE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GLOWSTONE, GLOWSTONE_A1_2_0);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GLOWSTONE_B1_9PRE5, GLOWSTONE);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GLOWSTONE, GLOWSTONE_B1_9PRE5);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CARVED_PUMPKIN_A1_2_0, CARVED_PUMPKIN);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CARVED_PUMPKIN, CARVED_PUMPKIN_A1_2_0);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JACK_O_LANTERN_A1_2_0, JACK_O_LANTERN);
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JACK_O_LANTERN, JACK_O_LANTERN_A1_2_0);
    }

    private static @NotNull String hasTag(@NotNull TagKey<Item> tag) {
        return "has_" + tag.id().toString();
    }
}
