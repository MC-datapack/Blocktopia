package github.mcdatapack.blocktopia.datagen.provider;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.ChairBlock;
import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import github.mcdatapack.blocktopia.list.TagList;
import github.mcdatapack.blocktopia.recipe.LegacyCutterRecipeJSONBuilder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.Blocks;
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

import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class BlocktopiaRecipeProvider extends FabricRecipeProvider {
    public BlocktopiaRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        chairRecipe(BlockInit.OAK_CHAIR, exporter);
        chairRecipe(BlockInit.SPRUCE_CHAIR, exporter);
        chairRecipe(BlockInit.BIRCH_CHAIR, exporter);
        chairRecipe(BlockInit.JUNGLE_CHAIR, exporter);
        chairRecipe(BlockInit.ACACIA_CHAIR, exporter);
        chairRecipe(BlockInit.DARK_OAK_CHAIR, exporter);
        chairRecipe(BlockInit.CRIMSON_CHAIR, exporter);
        chairRecipe(BlockInit.WARPED_CHAIR, exporter);
        chairRecipe(BlockInit.MANGROVE_CHAIR, exporter);
        chairRecipe(BlockInit.CHERRY_CHAIR, exporter);
        chairRecipe(BlockInit.PALM_CHAIR, exporter);
        chairRecipe(BlockInit.BANANA_CHAIR, exporter);
        chairRecipe(BlockInit.CORN_CHAIR, exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.LEGACY_CUTTER)
                .input(STONECUTTER)
                .input(CRAFTER)
                .criterion(hasItem(STONECUTTER), conditionsFromItem(STONECUTTER))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.XP_TRAP)
                .input('A', EXPERIENCE_BOTTLE)
                .input('B', ItemTags.TRAPDOORS)
                .input('C', ItemInit.ENCHANTED_DIAMOND_CHERRY)
                .input('D', OBSIDIAN)
                .input('E', ItemInit.BANANA)
                .pattern("DAB")
                .pattern("CEC")
                .pattern("BAD")
                .criterion(hasItem(ItemInit.ENCHANTED_DIAMOND_CHERRY), conditionsFromItem(ItemInit.ENCHANTED_DIAMOND_CHERRY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ItemInit.RABBIT_TRINKET, 1)
                .input('A', RABBIT_FOOT)
                .input('B', RABBIT_HIDE)
                .input('C', COOKED_RABBIT)
                .pattern("BCB")
                .pattern("CAC")
                .pattern("BCB")
                .criterion(hasItem(RABBIT_FOOT), conditionsFromItem(RABBIT_FOOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ItemInit.FISH_TRINKET, 1)
                .input('A', PUFFERFISH)
                .input('B', SALMON)
                .input('C', COD)
                .pattern("BCB")
                .pattern("CAC")
                .pattern("BCB")
                .criterion(hasItem(PUFFERFISH), conditionsFromItem(PUFFERFISH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.EXTENDED_REPEATER_TICK, 1)
                .input('A', REPEATER)
                .input('B', DIAMOND)
                .input('C', GOLDEN_BLOCKS)
                .pattern("BBB")
                .pattern("CAC")
                .pattern("BBB")
                .criterion(hasItem(REPEATER), conditionsFromItem(REPEATER))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.EXTENDED_REPEATER_SECOND, 1)
                .input(CLOCK)
                .input(BlockInit.EXTENDED_REPEATER_TICK)
                .criterion(hasItem(BlockInit.EXTENDED_REPEATER_TICK), conditionsFromItem(BlockInit.EXTENDED_REPEATER_TICK))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.EXTENDED_REPEATER_MINUTE, 1)
                .input(CLOCK)
                .input(BlockInit.EXTENDED_REPEATER_SECOND)
                .criterion(hasItem(BlockInit.EXTENDED_REPEATER_SECOND), conditionsFromItem(BlockInit.EXTENDED_REPEATER_SECOND))
                .offerTo(exporter);
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BlockInit.FIREWORK_BLOCK)
                .input('A', FIREWORK_ROCKET)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(FIREWORK_ROCKET), conditionsFromItem(FIREWORK_ROCKET))
                .offerTo(exporter, "firework_block_1");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, FIREWORK_ROCKET, 9)
                .input(BlockInit.FIREWORK_BLOCK)
                .criterion(hasItem(FIREWORK_ROCKET), conditionsFromItem(FIREWORK_ROCKET))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, BlockInit.FIREWORK_BLOCK, 3)
                .input(BlockInit.PAPER_BLOCK)
                .input(BlockInit.GUNPOWDER_BLOCK)
                .criterion(hasItem(FIREWORK_ROCKET), conditionsFromItem(FIREWORK_ROCKET))
                .offerTo(exporter,"firework_block_2");


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
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemInit.GOLDEN_CHERRY)
                .input('A', GOLD_INGOT)
                .input('B', ItemInit.CHERRY)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ItemInit.CHERRY), conditionsFromItem(ItemInit.CHERRY))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemInit.ENCHANTED_GOLDEN_CHERRY)
                .input('A', GOLD_BLOCK)
                .input('B', ItemInit.GOLDEN_CHERRY)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ItemInit.CHERRY), conditionsFromItem(ItemInit.CHERRY))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemInit.DIAMOND_CHERRY)
                .input('A', DIAMOND)
                .input('B', ItemInit.ENCHANTED_GOLDEN_CHERRY)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ItemInit.CHERRY), conditionsFromItem(ItemInit.CHERRY))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemInit.ENCHANTED_DIAMOND_CHERRY)
                .input('A', DIAMOND_BLOCKS)
                .input('B', ItemInit.DIAMOND_CHERRY)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ItemInit.CHERRY), conditionsFromItem(ItemInit.CHERRY))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemInit.NETHERITE_CHERRY)
                .input('A', NETHERITE_INGOT)
                .input('B', ItemInit.ENCHANTED_DIAMOND_CHERRY)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ItemInit.CHERRY), conditionsFromItem(ItemInit.CHERRY))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemInit.ENCHANTED_NETHERITE_CHERRY)
                .input('A', NETHERITE_BLOCK)
                .input('B', ItemInit.NETHERITE_CHERRY)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ItemInit.CHERRY), conditionsFromItem(ItemInit.CHERRY))
                .offerTo(exporter);



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
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.PALM_WOOD)
                .input('A', BlockInit.PALM_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(PALM_LOGS), conditionsFromTag(PALM_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.STRIPPED_PALM_WOOD)
                .input('A', BlockInit.STRIPPED_PALM_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(PALM_LOGS), conditionsFromTag(PALM_LOGS))
                .offerTo(exporter);
        var palmFamily = new BlockFamily.Builder(BlockInit.PALM_PLANKS)
                .button(BlockInit.PALM_BUTTON)
                .fence(BlockInit.PALM_FENCE)
                .fenceGate(BlockInit.PALM_FENCE_GATE)
                .pressurePlate(BlockInit.PALM_PRESSURE_PLATE)
                .slab(BlockInit.PALM_SLAB)
                .stairs(BlockInit.PALM_STAIRS)
                .door(BlockInit.PALM_DOOR)
                .trapdoor(BlockInit.PALM_TRAPDOOR)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();
        generateFamily(exporter, palmFamily, FeatureSet.empty());










        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.BANANA_PLANKS, 4)
                .input(BANANA_LOGS)
                .criterion(hasTag(BANANA_LOGS), conditionsFromTag(BANANA_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.BANANA_SLAB, 6)
                .input('A', BlockInit.BANANA_PLANKS)
                .pattern("AAA")
                .criterion(hasItem(BlockInit.BANANA_PLANKS), conditionsFromItem(BlockInit.BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.BANANA_STAIRS, 4)
                .input('A', BlockInit.BANANA_PLANKS)
                .pattern("A  ").pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(BlockInit.BANANA_PLANKS), conditionsFromItem(BlockInit.BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.BANANA_FENCE, 3)
                .input('A', BlockInit.BANANA_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(BlockInit.BANANA_PLANKS), conditionsFromItem(BlockInit.BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.BANANA_FENCE_GATE)
                .input('A', BlockInit.BANANA_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("BAB")
                .pattern("BAB")
                .criterion(hasItem(BlockInit.BANANA_PLANKS), conditionsFromItem(BlockInit.BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.BANANA_DOOR, 3)
                .input('A', BlockInit.BANANA_PLANKS)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .criterion(hasItem(BlockInit.BANANA_PLANKS), conditionsFromItem(BlockInit.BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.BANANA_TRAPDOOR, 2)
                .input('A', BlockInit.BANANA_PLANKS)
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(BlockInit.BANANA_PLANKS), conditionsFromItem(BlockInit.BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BlockInit.BANANA_BUTTON)
                .input('A', BlockInit.BANANA_PLANKS)
                .pattern("A")
                .criterion(hasItem(BlockInit.BANANA_PLANKS), conditionsFromItem(BlockInit.BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BlockInit.BANANA_PRESSURE_PLATE)
                .input('A', BlockInit.BANANA_PLANKS)
                .pattern("AA")
                .criterion(hasItem(BlockInit.BANANA_PLANKS), conditionsFromItem(BlockInit.BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ItemInit.BANANA_BOAT)
                .input('A', BlockInit.BANANA_PLANKS)
                .pattern("A A")
                .pattern("AAA")
                .criterion(hasItem(BlockInit.BANANA_PLANKS), conditionsFromItem(BlockInit.BANANA_PLANKS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ItemInit.BANANA_CHEST_BOAT)
                .input(ItemInit.BANANA_BOAT)
                .input(ConventionalItemTags.WOODEN_CHESTS)
                .criterion(hasItem(BlockInit.BANANA_PLANKS), conditionsFromItem(BlockInit.BANANA_PLANKS))
                .criterion(hasItem(CHEST), conditionsFromItem(CHEST)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.BANANA_WOOD)
                .input('A', BlockInit.BANANA_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(BANANA_LOGS), conditionsFromTag(BANANA_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.STRIPPED_BANANA_WOOD)
                .input('A', BlockInit.STRIPPED_BANANA_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(BANANA_LOGS), conditionsFromTag(BANANA_LOGS))
                .offerTo(exporter);
        var bananaFamily = new BlockFamily.Builder(BlockInit.BANANA_PLANKS)
                .button(BlockInit.BANANA_BUTTON)
                .fence(BlockInit.BANANA_FENCE)
                .fenceGate(BlockInit.BANANA_FENCE_GATE)
                .pressurePlate(BlockInit.BANANA_PRESSURE_PLATE)
                .slab(BlockInit.BANANA_SLAB)
                .stairs(BlockInit.BANANA_STAIRS)
                .door(BlockInit.BANANA_DOOR)
                .trapdoor(BlockInit.BANANA_TRAPDOOR)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();
        generateFamily(exporter, bananaFamily, FeatureSet.empty());






        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CORN_PLANKS, 4)
                .input(CORN_LOGS)
                .criterion(hasTag(CORN_LOGS), conditionsFromTag(CORN_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CORN_SLAB, 6)
                .input('A', BlockInit.CORN_PLANKS)
                .pattern("AAA")
                .criterion(hasItem(BlockInit.CORN_PLANKS), conditionsFromItem(BlockInit.CORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CORN_STAIRS, 4)
                .input('A', BlockInit.CORN_PLANKS)
                .pattern("A  ").pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(BlockInit.CORN_PLANKS), conditionsFromItem(BlockInit.CORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CORN_FENCE, 3)
                .input('A', BlockInit.CORN_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(BlockInit.CORN_PLANKS), conditionsFromItem(BlockInit.CORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CORN_FENCE_GATE)
                .input('A', BlockInit.CORN_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("BAB")
                .pattern("BAB")
                .criterion(hasItem(BlockInit.CORN_PLANKS), conditionsFromItem(BlockInit.CORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CORN_DOOR, 3)
                .input('A', BlockInit.CORN_PLANKS)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .criterion(hasItem(BlockInit.CORN_PLANKS), conditionsFromItem(BlockInit.CORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CORN_TRAPDOOR, 2)
                .input('A', BlockInit.CORN_PLANKS)
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(BlockInit.CORN_PLANKS), conditionsFromItem(BlockInit.CORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BlockInit.CORN_BUTTON)
                .input('A', BlockInit.CORN_PLANKS)
                .pattern("A")
                .criterion(hasItem(BlockInit.CORN_PLANKS), conditionsFromItem(BlockInit.CORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BlockInit.CORN_PRESSURE_PLATE)
                .input('A', BlockInit.CORN_PLANKS)
                .pattern("AA")
                .criterion(hasItem(BlockInit.CORN_PLANKS), conditionsFromItem(BlockInit.CORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ItemInit.CORN_BOAT)
                .input('A', BlockInit.CORN_PLANKS)
                .pattern("A A")
                .pattern("AAA")
                .criterion(hasItem(BlockInit.CORN_PLANKS), conditionsFromItem(BlockInit.CORN_PLANKS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ItemInit.CORN_CHEST_BOAT)
                .input(ItemInit.CORN_BOAT)
                .input(ConventionalItemTags.WOODEN_CHESTS)
                .criterion(hasItem(BlockInit.CORN_PLANKS), conditionsFromItem(BlockInit.CORN_PLANKS))
                .criterion(hasItem(CHEST), conditionsFromItem(CHEST)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.CORN_WOOD)
                .input('A', BlockInit.CORN_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(CORN_LOGS), conditionsFromTag(CORN_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockInit.STRIPPED_CORN_WOOD)
                .input('A', BlockInit.STRIPPED_CORN_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(CORN_LOGS), conditionsFromTag(CORN_LOGS))
                .offerTo(exporter);
        var cornFamily = new BlockFamily.Builder(BlockInit.CORN_PLANKS)
                .button(BlockInit.CORN_BUTTON)
                .fence(BlockInit.CORN_FENCE)
                .fenceGate(BlockInit.CORN_FENCE_GATE)
                .pressurePlate(BlockInit.CORN_PRESSURE_PLATE)
                .slab(BlockInit.CORN_SLAB)
                .stairs(BlockInit.CORN_STAIRS)
                .door(BlockInit.CORN_DOOR)
                .trapdoor(BlockInit.CORN_TRAPDOOR)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();
        generateFamily(exporter, cornFamily, FeatureSet.empty());











        //Legacy Recipes
        legacyCutterRecipe(exporter, Blocks.COBBLESTONE, COBBLESTONE_B1_7, COBBLESTONE_C_0_0_14A, COBBLESTONE_RD20090515);
        legacyCutterRecipe(exporter, Blocks.OAK_PLANKS, WOODEN_PLANKS_B1_9PRE5, WOODEN_PLANKS_C0_0_15A, WOODEN_PLANKS_C0_0_14A, WOODEN_PLANKS_RD161348, WOODEN_PLANKS_RD20090515);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_PLANKS_C0_0_14A, 4)
                .input(LOG_C0_0_14A)
                .criterion(hasItem(LOG_C0_0_14A), conditionsFromItem(LOG_C0_0_14A))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_PLANKS_C0_0_15A, 8)
                .input(LOG_C0_0_14A)
                .input(LOG_C0_0_14A)
                .criterion(hasItem(LOG_C0_0_14A), conditionsFromItem(LOG_C0_0_14A))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_PLANKS_B1_9PRE5, 12)
                .input(LOG_C0_0_14A)
                .input(LOG_C0_0_14A)
                .input(LOG_C0_0_14A)
                .criterion(hasItem(LOG_C0_0_14A), conditionsFromItem(LOG_C0_0_14A))
                .offerTo(exporter);
        legacyCutterRecipe(exporter, OAK_LOG, LOG_C0_0_14A);
        legacyCutterRecipe(exporter, OAK_LEAVES, LEAVES_C0_24ST, LEAVES_C0_0_15A, LEAVES_C0_0_14A);
        legacyCutterRecipe(exporter, OAK_SAPLING, SAPLING_C0_24ST, SAPLING_C0_0_13A, SAPLING_RD161348);
        legacyCutterRecipe(exporter, BEDROCK, BEDROCK_C0_0_12A);
        legacyCutterRecipe(exporter, SAND, SAND_B1_9PRE6, SAND_C0_0_15A, SAND_C0_0_14A);
        legacyCutterRecipe(exporter, GRAVEL, GRAVEL_1_3, GRAVEL_B1_9PRE5, GRAVEL_C0_0_15A, GRAVEL_C0_0_14A);
        legacyCutterRecipe(exporter, COAL_ORE, COAL_ORE_1_14, COAL_ORE_C0_0_14A);
        legacyCutterRecipe(exporter, IRON_ORE, IRON_ORE_1_14_1, IRON_ORE_1_14, IRON_ORE_C0_0_14A);
        legacyCutterRecipe(exporter, GOLD_ORE, GOLD_ORE_1_14, GOLD_ORE_C0_26ST, GOLD_ORE_C0_0_14A);
        legacyCutterRecipe(exporter, SPONGE, SPONGE_1_8, SPONGE_C0_0_19A);
        legacyCutterRecipe(exporter, WET_SPONGE, WET_SPONGE_1_8);
        legacyCutterRecipe(exporter, GLASS, GLASS_C0_0_19A);
        legacyCutterRecipe(exporter, GOLD_BLOCK, GOLD_BLOCK_B1_9PRE5, GOLD_BLOCK_A1_2_0, GOLD_BLOCK_C0_26ST, GOLD_BLOCK_C0_0_20A);
        legacyCutterRecipe(exporter, DANDELION, DANDELION_C0_0_20A);
        legacyCutterRecipe(exporter, POPPY, ROSE_C0_0_20A, POPPY_1_7);
        legacyCutterRecipe(exporter, BROWN_MUSHROOM, BROWN_MUSHROOM_C0_0_20A);
        legacyCutterRecipe(exporter, RED_MUSHROOM, RED_MUSHROOM_C0_0_20A);
        legacyCutterRecipe(exporter, IRON_BLOCK, IRON_BLOCK_B1_9PRE5, IRON_BLOCK_A1_2_0, IRON_BLOCK_C0_26ST);
        legacyCutterRecipe(exporter, TNT, TNT_C0_28A, TNT_C0_26ST);
        legacyCutterRecipe(exporter, MOSSY_COBBLESTONE, MOSSY_COBBLESTONE_C0_26ST, MOSSY_COBBLESTONE_C0_26ST);
        legacyCutterRecipe(exporter, BRICKS, BRICKS_A1_0_11, BRICKS_C0_26ST);
        legacyCutterRecipe(exporter, BOOKSHELF, BOOKSHELF_B1_9PRE5, BOOKSHELF_C0_26ST);
        legacyCutterRecipe(exporter, OBSIDIAN, OBSIDIAN_C0_28A);
        legacyCutterRecipe(exporter, DIAMOND_ORE, DIAMOND_ORE_1_14, DIAMOND_ORE_IN20100128);
        legacyCutterRecipe(exporter, DIAMOND_BLOCK, DIAMOND_BLOCK_B1_9PRE5, DIAMOND_BLOCK_A1_2_0, DIAMOND_BLOCK_IN20100128);
        legacyCutterRecipe(exporter, CRAFTING_TABLE, CRAFTING_TABLE_1_14, CRAFTING_TABLE_IN20100131);
        legacyCutterRecipe(exporter, FURNACE, FURNACE_B1_2, FURNACE_IN20100219);
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
        legacyCutterRecipe(exporter, LADDER, LADDER_INF20100607, LADDER_INF20100618);
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
        legacyCutterRecipe(exporter, TORCH, ItemInit.TORCH_IN20100124_2);
        legacyCutterRecipe(exporter, OAK_DOOR, WOODEN_DOOR_INF20100607);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_DOOR_INF20100607)
                .input('A', WOODEN_PLANKS_C0_0_15A)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .criterion(hasItem(WOODEN_PLANKS_C0_0_15A), conditionsFromItem(WOODEN_PLANKS_C0_0_15A))
                .offerTo(exporter);
        legacyCutterRecipe(exporter, REDSTONE_ORE, REDSTONE_ORE_1_14, REDSTONE_ORE_A1_0_1);
        legacyCutterRecipe(exporter, REDSTONE_TORCH, REDSTONE_TORCH_A1_0_1);
        legacyCutterRecipe(exporter, SNOW, SNOW_A1_0_4);
        legacyCutterRecipe(exporter, SNOW_BLOCK, SNOW_BLOCK_A1_0_5);
        legacyCutterRecipe(exporter, ICE, ICE_A1_0_4);
        legacyCutterRecipe(exporter, CLAY, CLAY_BLOCK_A1_0_11);
        legacyCutterRecipe(exporter, OAK_FENCE, WOODEN_FENCE_B1_9PRE5, WOODEN_FENCE_A1_0_17, WOODEN_FENCE_C0_0_14A, WOODEN_FENCE_RD161348, WOODEN_FENCE_RD20090515);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_FENCE_RD20090515)
                .input('A', WOODEN_PLANKS_RD20090515)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(WOODEN_PLANKS_RD20090515), conditionsFromItem(WOODEN_PLANKS_RD20090515))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_FENCE_RD161348)
                .input('A', WOODEN_PLANKS_RD161348)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(WOODEN_PLANKS_RD161348), conditionsFromItem(WOODEN_PLANKS_RD161348))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_FENCE_C0_0_14A)
                .input('A', WOODEN_PLANKS_C0_0_14A)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(WOODEN_PLANKS_C0_0_14A), conditionsFromItem(WOODEN_PLANKS_C0_0_14A))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_FENCE_A1_0_17)
                .input('A', WOODEN_PLANKS_C0_0_15A)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(WOODEN_PLANKS_C0_0_15A), conditionsFromItem(WOODEN_PLANKS_C0_0_15A))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_FENCE_B1_9PRE5)
                .input('A', WOODEN_PLANKS_B1_9PRE5)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(WOODEN_PLANKS_B1_9PRE5), conditionsFromItem(WOODEN_PLANKS_B1_9PRE5))
                .offerTo(exporter);
        legacyCutterRecipe(exporter, NETHERRACK, NETHERRACK_B1_9PRE5, NETHERRACK_A1_2_0);
        legacyCutterRecipe(exporter, SOUL_SAND, SOUL_SAND_A1_2_0);
        legacyCutterRecipe(exporter, GLOWSTONE, GLOWSTONE_B1_9PRE5, GLOWSTONE_A1_2_0);
        legacyCutterRecipe(exporter, CARVED_PUMPKIN, CARVED_PUMPKIN_A1_2_0);
        legacyCutterRecipe(exporter, JACK_O_LANTERN, JACK_O_LANTERN_A1_2_0);
    }

    private static @NotNull String hasTag(@NotNull TagKey<Item> tag) {
        return "has_" + tag.id().toString();
    }

    private void chairRecipe(ChairBlock block, RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, block)
                .input('A', block.plank)
                .pattern("A  ")
                .pattern("AAA")
                .pattern("A A")
                .criterion(hasItem(block.plank), conditionsFromItem(block.plank))
                .offerTo(exporter);
    }

    private static void legacyCutterRecipe(RecipeExporter exporter, ItemConvertible base, /* newest to oldest*/ ItemConvertible... legacyVariants) {
        for (int i = 0; i < legacyVariants.length; i++) {
            ItemConvertible item = legacyVariants[i];
            ItemConvertible fromItem = i == 0 ? base : legacyVariants[i-1];
            LegacyCutterRecipeJSONBuilder.create(Ingredient.ofItems(fromItem), item.asItem(), 1)
                    .criterion(hasItem(base), conditionsFromItem(base))
                    .offerTo(exporter, Blocktopia.id("legacy_cutter/" + Registries.ITEM.getId(fromItem.asItem()).getPath()) + "_to_" + Registries.ITEM.getId(item.asItem()).getPath());
        }
        ItemConvertible item = legacyVariants[legacyVariants.length-1];
        LegacyCutterRecipeJSONBuilder.create(Ingredient.ofItems(item), base.asItem(), 1)
                .criterion(hasItem(base), conditionsFromItem(base))
                .offerTo(exporter, Blocktopia.id("legacy_cutter/" + Registries.ITEM.getId(item.asItem()).getPath() + "_to_" + Registries.ITEM.getId(base.asItem()).getPath()));
    }
}
