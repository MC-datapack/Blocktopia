package github.mcdatapack.blocktopia.datagen.provider;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.ModBlockFamilies;
import github.mcdatapack.blocktopia.block.custom.ChairBlock;
import github.mcdatapack.blocktopia.item.ModItems;
import github.mcdatapack.blocktopia.block.ModBlocks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import github.mcdatapack.blocktopia.recipe.LegacyCutterRecipeJSONBuilder;
import github.mcdatapack.blocktopia.recipe.WoodCuttingRecipeJSONBuilder;
import github.mcdatapack.more_tools_and_armor.init.BlockInit;
import github.mcdatapack.more_tools_and_armor.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;

import static github.mcdatapack.blocktopia.block.FutureBlocks.*;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.*;
import static github.mcdatapack.blocktopia.block.ModBlocks.*;
import static github.mcdatapack.blocktopia.item.FutureItems.*;
import static github.mcdatapack.blocktopia.item.LegacyItems.*;
import static github.mcdatapack.blocktopia.item.LegacyItems.RABBIT_STEW_1_8;
import static github.mcdatapack.blocktopia.item.ModItems.*;
import static github.mcdatapack.blocktopia.util.ModTags.Items.*;
import static net.minecraft.item.Items.*;

import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
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
        chairRecipe(ModBlocks.OAK_CHAIR, OAK_CHAIRS, exporter);
        chairRecipe(ModBlocks.SPRUCE_CHAIR, SPRUCE_CHAIRS, exporter);
        chairRecipe(ModBlocks.BIRCH_CHAIR, BIRCH_CHAIRS, exporter);
        chairRecipe(ModBlocks.JUNGLE_CHAIR, JUNGLE_CHAIRS, exporter);
        chairRecipe(ModBlocks.ACACIA_CHAIR, ACACIA_CHAIRS, exporter);
        chairRecipe(ModBlocks.DARK_OAK_CHAIR, DARK_OAK_CHAIRS, exporter);
        chairRecipe(ModBlocks.CRIMSON_CHAIR, CRIMSON_CHAIRS, exporter);
        chairRecipe(ModBlocks.WARPED_CHAIR, WARPED_CHAIRS, exporter);
        chairRecipe(ModBlocks.MANGROVE_CHAIR, MAHOGANY_CHAIRS, exporter);
        chairRecipe(ModBlocks.BAMBOO_CHAIR, BAMBOO_CHAIRS, exporter);
        chairRecipe(ModBlocks.CHERRY_CHAIR, CHERRY_CHAIRS, exporter);
        chairRecipe(ModBlocks.PALM_CHAIR, PALM_CHAIRS, exporter);
        chairRecipe(ModBlocks.BANANA_CHAIR, BANANA_CHAIRS, exporter);
        chairRecipe(ModBlocks.CORN_CHAIR, CORN_CHAIRS, exporter);
        chairRecipe(ModBlocks.POISONED_CHAIR, POISONED_CHAIRS, exporter);
        chairRecipe(ModBlocks.MAHOGANY_CHAIR, MAHOGANY_CHAIRS, exporter);
        chairRecipe(ModBlocks.PALE_OAK_CHAIR, PALE_OAK_CHAIRS, exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FLUID_TANK)
                .input('G', ConventionalItemTags.GLASS_PANES)
                .input('B', ConventionalItemTags.EMPTY_BUCKETS)
                .input('I', ConventionalItemTags.IRON_INGOTS)
                .pattern("III")
                .pattern("GBG")
                .pattern("III")
                .criterion(hasTag(ConventionalItemTags.GLASS_PANES), conditionsFromTag(ConventionalItemTags.GLASS_PANES))
                .criterion(hasTag(ConventionalItemTags.EMPTY_BUCKETS), conditionsFromTag(ConventionalItemTags.EMPTY_BUCKETS))
                .criterion(hasTag(ConventionalItemTags.IRON_INGOTS), conditionsFromTag(ConventionalItemTags.IRON_INGOTS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, FUTURE_INGOT)
                .input(ItemTags.LOGS)
                .input(ItemTags.SAPLINGS)
                .criterion(hasTag(ItemTags.LOGS), conditionsFromTag(ItemTags.LOGS))
                .criterion(hasTag(ItemTags.SAPLINGS), conditionsFromTag(ItemTags.SAPLINGS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CREATIVE_INGOT)
                .input('A', ModItems.CREATIVE_NUGGET)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(ModItems.CREATIVE_NUGGET),conditionsFromItem(ModItems.CREATIVE_NUGGET))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CREATIVE_NUGGET, 9)
                .input(ModItems.CREATIVE_INGOT)
                .criterion(hasItem(ModItems.CREATIVE_INGOT),conditionsFromItem(ModItems.CREATIVE_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TROPICAL_MOSS_CARPET, 3)
                .input('A', ModBlocks.TROPICAL_MOSS)
                .pattern("AA")
                .criterion(hasItem(ModBlocks.TROPICAL_MOSS), conditionsFromItem(ModBlocks.TROPICAL_MOSS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUPER)
                .input('A', ModItems.CREATIVE_INGOT)
                .input('B', ModBlocks.SMALL_CHEST)
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .criterion(hasItem(ModItems.CREATIVE_INGOT), conditionsFromItem(ModItems.CREATIVE_INGOT))
                .offerTo(exporter);

        offerSingleOutputShapelessRecipe(exporter, PURPLE_DYE, ModBlocks.GLOW_FLOWER, "purple_dye");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPONGE_TNT, 2)
                .input(SPONGE_C0_0_19A).input(TNT)
                .criterion(hasItem(TNT), conditionsFromItem(TNT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEGACY_CUTTER)
                .input('A', COBBLESTONE)
                .input('B', IRON_INGOT)
                .pattern(" B ")
                .pattern("AAA")
                .criterion(hasItem(COBBLESTONE), conditionsFromItem(COBBLESTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WOODCUTTER)
                .input('A', ItemTags.LOGS)
                .input('B', IRON_INGOT)
                .pattern(" B ")
                .pattern("AAA")
                .criterion(hasItem(OAK_LOG), conditionsFromItem(OAK_LOG))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.XP_TRAP)
                .input('A', EXPERIENCE_BOTTLE)
                .input('B', ItemTags.TRAPDOORS)
                .input('C', ModItems.ENCHANTED_DIAMOND_CHERRY)
                .input('D', OBSIDIAN)
                .input('E', ModItems.BANANA)
                .pattern("DAB")
                .pattern("CEC")
                .pattern("BAD")
                .criterion(hasItem(ModItems.ENCHANTED_DIAMOND_CHERRY), conditionsFromItem(ModItems.ENCHANTED_DIAMOND_CHERRY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.RABBIT_TRINKET, 1)
                .input('A', RABBIT_FOOT)
                .input('B', RABBIT_HIDE)
                .input('C', COOKED_RABBIT)
                .pattern("BCB")
                .pattern("CAC")
                .pattern("BCB")
                .criterion(hasItem(RABBIT_FOOT), conditionsFromItem(RABBIT_FOOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.FISH_TRINKET, 1)
                .input('A', PUFFERFISH)
                .input('B', SALMON)
                .input('C', COD)
                .pattern("BCB")
                .pattern("CAC")
                .pattern("BCB")
                .criterion(hasItem(PUFFERFISH), conditionsFromItem(PUFFERFISH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXTENDED_REPEATER_TICK, 1)
                .input('A', REPEATER)
                .input('B', DIAMOND)
                .input('C', GOLD_BLOCK)
                .pattern("BBB")
                .pattern("CAC")
                .pattern("BBB")
                .criterion(hasItem(REPEATER), conditionsFromItem(REPEATER))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXTENDED_REPEATER_SECOND, 1)
                .input(CLOCK)
                .input(ModBlocks.EXTENDED_REPEATER_TICK)
                .criterion(hasItem(ModBlocks.EXTENDED_REPEATER_TICK), conditionsFromItem(ModBlocks.EXTENDED_REPEATER_TICK))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXTENDED_REPEATER_MINUTE, 1)
                .input(CLOCK)
                .input(ModBlocks.EXTENDED_REPEATER_SECOND)
                .criterion(hasItem(ModBlocks.EXTENDED_REPEATER_SECOND), conditionsFromItem(ModBlocks.EXTENDED_REPEATER_SECOND))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GUNPOWDER_BLOCK)
                .input('A', GUNPOWDER)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(GUNPOWDER), conditionsFromItem(GUNPOWDER))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, GUNPOWDER, 9)
                .input(ModBlocks.GUNPOWDER_BLOCK)
                .criterion(hasItem(GUNPOWDER), conditionsFromItem(GUNPOWDER))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PAPER_BLOCK)
                .input('A', PAPER)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(PAPER), conditionsFromItem(PAPER))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, PAPER, 9)
                .input(ModBlocks.PAPER_BLOCK)
                .criterion(hasItem(PAPER), conditionsFromItem(PAPER))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FIREWORK_BLOCK)
                .input('A', FIREWORK_ROCKET)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(FIREWORK_ROCKET), conditionsFromItem(FIREWORK_ROCKET))
                .offerTo(exporter, "firework_block_1");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, FIREWORK_ROCKET, 9)
                .input(ModBlocks.FIREWORK_BLOCK)
                .criterion(hasItem(FIREWORK_ROCKET), conditionsFromItem(FIREWORK_ROCKET))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FIREWORK_BLOCK, 3)
                .input(ModBlocks.PAPER_BLOCK)
                .input(ModBlocks.GUNPOWDER_BLOCK)
                .criterion(hasItem(FIREWORK_ROCKET), conditionsFromItem(FIREWORK_ROCKET))
                .offerTo(exporter,"firework_block_2");


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SMALL_CHEST)
                .input('A', ItemTags.WOODEN_SLABS)
                .pattern("AAA")
                .pattern("A A")
                .pattern("AAA")
                .criterion(hasTag(ItemTags.WOODEN_SLABS), conditionsFromTag(ItemTags.WOODEN_SLABS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ENCHANTED_GOLDEN_APPLE)
                .input('A', GOLD_BLOCK)
                .input('B', APPLE)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(APPLE), conditionsFromItem(APPLE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ENCHANTED_GOLDEN_BAKED_POTATO)
                .input('A', GOLD_INGOT)
                .input('B', BAKED_POTATO)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(POTATO), conditionsFromItem(POTATO))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GOLDEN_BAKED_POTATO)
                .input('A', GOLD_NUGGET)
                .input('B', BAKED_POTATO)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(POTATO), conditionsFromItem(POTATO))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ENCHANTED_GOLDEN_CARROT)
                .input('A', GOLD_INGOT)
                .input('B', CARROT)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(CARROT), conditionsFromItem(CARROT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ENCHANTED_GOLDEN_COCONUT)
                .input('A', GOLD_BLOCK)
                .input('B', ModItems.COCONUT)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ModItems.COCONUT), conditionsFromItem(ModItems.COCONUT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GOLDEN_COCONUT)
                .input('A', GOLD_INGOT)
                .input('B', ModItems.COCONUT)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ModItems.COCONUT), conditionsFromItem(ModItems.COCONUT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ENCHANTED_GOLDEN_POTATO)
                .input('A', GOLD_INGOT)
                .input('B', POTATO)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(POTATO), conditionsFromItem(POTATO))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GOLDEN_POTATO)
                .input('A', GOLD_NUGGET)
                .input('B', POTATO)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(POTATO), conditionsFromItem(POTATO))
                .offerTo(exporter);
        List<ItemConvertible> golden_potato = List.of(ModItems.GOLDEN_POTATO);
        List<ItemConvertible> enchanted_golden_potato = List.of(ModItems.ENCHANTED_GOLDEN_POTATO);
        RecipeProvider.offerSmelting(exporter, golden_potato, RecipeCategory.FOOD, ModItems.GOLDEN_BAKED_POTATO, 1.0F, 200, "golden_baked_potato");
        RecipeProvider.offerSmelting(exporter, enchanted_golden_potato, RecipeCategory.FOOD, ModItems.ENCHANTED_GOLDEN_BAKED_POTATO, 1.0F, 200, "enchanted_golden_baked_potato");
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GOLDEN_CHERRY)
                .input('A', GOLD_INGOT)
                .input('B', ModItems.CHERRY)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ModItems.CHERRY), conditionsFromItem(ModItems.CHERRY))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ENCHANTED_GOLDEN_CHERRY)
                .input('A', GOLD_BLOCK)
                .input('B', ModItems.GOLDEN_CHERRY)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ModItems.CHERRY), conditionsFromItem(ModItems.CHERRY))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.DIAMOND_CHERRY)
                .input('A', DIAMOND)
                .input('B', ModItems.ENCHANTED_GOLDEN_CHERRY)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ModItems.CHERRY), conditionsFromItem(ModItems.CHERRY))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ENCHANTED_DIAMOND_CHERRY)
                .input('A', DIAMOND_BLOCK)
                .input('B', ModItems.DIAMOND_CHERRY)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ModItems.CHERRY), conditionsFromItem(ModItems.CHERRY))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.NETHERITE_CHERRY)
                .input('A', NETHERITE_INGOT)
                .input('B', ModItems.ENCHANTED_DIAMOND_CHERRY)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ModItems.CHERRY), conditionsFromItem(ModItems.CHERRY))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ENCHANTED_NETHERITE_CHERRY)
                .input('A', NETHERITE_BLOCK)
                .input('B', ModItems.NETHERITE_CHERRY)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ModItems.CHERRY), conditionsFromItem(ModItems.CHERRY))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.DEEPSLATE_EMERALD_CHERRY)
                .input('A', github.mcdatapack.more_tools_and_armor.init.ItemInit.DEEPSLATE_EMERALD)
                .input('B', ModItems.ENCHANTED_NETHERITE_CHERRY)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ModItems.CHERRY), conditionsFromItem(ModItems.CHERRY))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ENCHANTED_DEEPSLATE_EMERALD_CHERRY)
                .input('A', github.mcdatapack.more_tools_and_armor.init.BlockInit.DEEPSLATE_EMERALD_BLOCK)
                .input('B', ModItems.DEEPSLATE_EMERALD_CHERRY)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ModItems.CHERRY), conditionsFromItem(ModItems.CHERRY))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.END_DIAMOND_CHERRY)
                .input('A', ItemInit.END_EMERALD)
                .input('B', ModItems.ENCHANTED_DEEPSLATE_EMERALD_CHERRY)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ModItems.CHERRY), conditionsFromItem(ModItems.CHERRY))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ENCHANTED_END_DIAMOND_CHERRY)
                .input('A', BlockInit.END_EMERALD_BLOCK)
                .input('B', ModItems.END_DIAMOND_CHERRY)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .criterion(hasItem(ModItems.CHERRY), conditionsFromItem(ModItems.CHERRY))
                .offerTo(exporter);



        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_PLANKS, 4)
                .input(PALM_LOGS)
                .criterion(hasTag(PALM_LOGS), conditionsFromTag(PALM_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_SLAB, 6)
                .input('A', ModBlocks.PALM_PLANKS)
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.PALM_PLANKS), conditionsFromItem(ModBlocks.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_STAIRS, 4)
                .input('A', ModBlocks.PALM_PLANKS)
                .pattern("A  ").pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.PALM_PLANKS), conditionsFromItem(ModBlocks.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_FENCE, 3)
                .input('A', ModBlocks.PALM_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(ModBlocks.PALM_PLANKS), conditionsFromItem(ModBlocks.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_FENCE_GATE)
                .input('A', ModBlocks.PALM_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("BAB")
                .pattern("BAB")
                .criterion(hasItem(ModBlocks.PALM_PLANKS), conditionsFromItem(ModBlocks.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_DOOR, 3)
                .input('A', ModBlocks.PALM_PLANKS)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .criterion(hasItem(ModBlocks.PALM_PLANKS), conditionsFromItem(ModBlocks.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_TRAPDOOR, 2)
                .input('A', ModBlocks.PALM_PLANKS)
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.PALM_PLANKS), conditionsFromItem(ModBlocks.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.PALM_BUTTON)
                .input('A', ModBlocks.PALM_PLANKS)
                .pattern("A")
                .criterion(hasItem(ModBlocks.PALM_PLANKS), conditionsFromItem(ModBlocks.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.PALM_PRESSURE_PLATE)
                .input('A', ModBlocks.PALM_PLANKS)
                .pattern("AA")
                .criterion(hasItem(ModBlocks.PALM_PLANKS), conditionsFromItem(ModBlocks.PALM_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.PALM_BOAT)
                .input('A', ModBlocks.PALM_PLANKS)
                .pattern("A A")
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.PALM_PLANKS), conditionsFromItem(ModBlocks.PALM_PLANKS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.PALM_CHEST_BOAT)
                .input(ModItems.PALM_BOAT)
                .input(ConventionalItemTags.WOODEN_CHESTS)
                .criterion(hasItem(ModBlocks.PALM_PLANKS), conditionsFromItem(ModBlocks.PALM_PLANKS))
                .criterion(hasItem(CHEST), conditionsFromItem(CHEST)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_WOOD)
                .input('A', ModBlocks.PALM_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(PALM_LOGS), conditionsFromTag(PALM_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_PALM_WOOD)
                .input('A', ModBlocks.STRIPPED_PALM_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(PALM_LOGS), conditionsFromTag(PALM_LOGS))
                .offerTo(exporter);
        generateFamily(exporter, ModBlockFamilies.PALM, FeatureSet.empty());










        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BANANA_PLANKS, 4)
                .input(BANANA_LOGS)
                .criterion(hasTag(BANANA_LOGS), conditionsFromTag(BANANA_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BANANA_SLAB, 6)
                .input('A', BANANA_PLANKS)
                .pattern("AAA")
                .criterion(hasItem(BANANA_PLANKS), conditionsFromItem(BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BANANA_STAIRS, 4)
                .input('A', BANANA_PLANKS)
                .pattern("A  ").pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(BANANA_PLANKS), conditionsFromItem(BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BANANA_FENCE, 3)
                .input('A', BANANA_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(BANANA_PLANKS), conditionsFromItem(BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BANANA_FENCE_GATE)
                .input('A', BANANA_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("BAB")
                .pattern("BAB")
                .criterion(hasItem(BANANA_PLANKS), conditionsFromItem(BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BANANA_DOOR, 3)
                .input('A', BANANA_PLANKS)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .criterion(hasItem(BANANA_PLANKS), conditionsFromItem(BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BANANA_TRAPDOOR, 2)
                .input('A', BANANA_PLANKS)
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(BANANA_PLANKS), conditionsFromItem(BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.BANANA_BUTTON)
                .input('A', BANANA_PLANKS)
                .pattern("A")
                .criterion(hasItem(BANANA_PLANKS), conditionsFromItem(BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.BANANA_PRESSURE_PLATE)
                .input('A', BANANA_PLANKS)
                .pattern("AA")
                .criterion(hasItem(BANANA_PLANKS), conditionsFromItem(BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, BANANA_BOAT)
                .input('A', BANANA_PLANKS)
                .pattern("A A")
                .pattern("AAA")
                .criterion(hasItem(BANANA_PLANKS), conditionsFromItem(BANANA_PLANKS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, BANANA_CHEST_BOAT)
                .input(BANANA_BOAT)
                .input(ConventionalItemTags.WOODEN_CHESTS)
                .criterion(hasItem(BANANA_PLANKS), conditionsFromItem(BANANA_PLANKS))
                .criterion(hasItem(CHEST), conditionsFromItem(CHEST)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BANANA_WOOD)
                .input('A', ModBlocks.BANANA_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(BANANA_LOGS), conditionsFromTag(BANANA_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_BANANA_WOOD)
                .input('A', ModBlocks.STRIPPED_BANANA_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(BANANA_LOGS), conditionsFromTag(BANANA_LOGS))
                .offerTo(exporter);
        generateFamily(exporter, ModBlockFamilies.BANANA, FeatureSet.empty());






        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORN_PLANKS, 4)
                .input(CORN_LOGS)
                .criterion(hasTag(CORN_LOGS), conditionsFromTag(CORN_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORN_SLAB, 6)
                .input('A', ModBlocks.CORN_PLANKS)
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.CORN_PLANKS), conditionsFromItem(ModBlocks.CORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORN_STAIRS, 4)
                .input('A', ModBlocks.CORN_PLANKS)
                .pattern("A  ").pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.CORN_PLANKS), conditionsFromItem(ModBlocks.CORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORN_FENCE, 3)
                .input('A', ModBlocks.CORN_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(ModBlocks.CORN_PLANKS), conditionsFromItem(ModBlocks.CORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORN_FENCE_GATE)
                .input('A', ModBlocks.CORN_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("BAB")
                .pattern("BAB")
                .criterion(hasItem(ModBlocks.CORN_PLANKS), conditionsFromItem(ModBlocks.CORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORN_DOOR, 3)
                .input('A', ModBlocks.CORN_PLANKS)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .criterion(hasItem(ModBlocks.CORN_PLANKS), conditionsFromItem(ModBlocks.CORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORN_TRAPDOOR, 2)
                .input('A', ModBlocks.CORN_PLANKS)
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.CORN_PLANKS), conditionsFromItem(ModBlocks.CORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.CORN_BUTTON)
                .input('A', ModBlocks.CORN_PLANKS)
                .pattern("A")
                .criterion(hasItem(ModBlocks.CORN_PLANKS), conditionsFromItem(ModBlocks.CORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.CORN_PRESSURE_PLATE)
                .input('A', ModBlocks.CORN_PLANKS)
                .pattern("AA")
                .criterion(hasItem(ModBlocks.CORN_PLANKS), conditionsFromItem(ModBlocks.CORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, CORN_BOAT)
                .input('A', ModBlocks.CORN_PLANKS)
                .pattern("A A")
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.CORN_PLANKS), conditionsFromItem(ModBlocks.CORN_PLANKS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.CORN_CHEST_BOAT)
                .input(CORN_BOAT)
                .input(ConventionalItemTags.WOODEN_CHESTS)
                .criterion(hasItem(ModBlocks.CORN_PLANKS), conditionsFromItem(ModBlocks.CORN_PLANKS))
                .criterion(hasItem(CHEST), conditionsFromItem(CHEST)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORN_WOOD)
                .input('A', ModBlocks.CORN_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(CORN_LOGS), conditionsFromTag(CORN_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_CORN_WOOD)
                .input('A', ModBlocks.STRIPPED_CORN_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(CORN_LOGS), conditionsFromTag(CORN_LOGS))
                .offerTo(exporter);
        generateFamily(exporter, ModBlockFamilies.CORN, FeatureSet.empty());






        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POISONED_PLANKS, 4)
                .input(POISONED_LOGS)
                .criterion(hasTag(POISONED_LOGS), conditionsFromTag(POISONED_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POISONED_SLAB, 6)
                .input('A', ModBlocks.POISONED_PLANKS)
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.POISONED_PLANKS), conditionsFromItem(ModBlocks.POISONED_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POISONED_STAIRS, 4)
                .input('A', ModBlocks.POISONED_PLANKS)
                .pattern("A  ").pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.POISONED_PLANKS), conditionsFromItem(ModBlocks.POISONED_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POISONED_FENCE, 3)
                .input('A', ModBlocks.POISONED_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(ModBlocks.POISONED_PLANKS), conditionsFromItem(ModBlocks.POISONED_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POISONED_FENCE_GATE)
                .input('A', ModBlocks.POISONED_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("BAB")
                .pattern("BAB")
                .criterion(hasItem(ModBlocks.POISONED_PLANKS), conditionsFromItem(ModBlocks.POISONED_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POISONED_DOOR, 3)
                .input('A', ModBlocks.POISONED_PLANKS)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .criterion(hasItem(ModBlocks.POISONED_PLANKS), conditionsFromItem(ModBlocks.POISONED_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POISONED_TRAPDOOR, 2)
                .input('A', ModBlocks.POISONED_PLANKS)
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.POISONED_PLANKS), conditionsFromItem(ModBlocks.POISONED_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.POISONED_BUTTON)
                .input('A', ModBlocks.POISONED_PLANKS)
                .pattern("A")
                .criterion(hasItem(ModBlocks.POISONED_PLANKS), conditionsFromItem(ModBlocks.POISONED_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.POISONED_PRESSURE_PLATE)
                .input('A', ModBlocks.POISONED_PLANKS)
                .pattern("AA")
                .criterion(hasItem(ModBlocks.POISONED_PLANKS), conditionsFromItem(ModBlocks.POISONED_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.POISONED_BOAT)
                .input('A', ModBlocks.POISONED_PLANKS)
                .pattern("A A")
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.POISONED_PLANKS), conditionsFromItem(ModBlocks.POISONED_PLANKS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.POISONED_CHEST_BOAT)
                .input(ModItems.POISONED_BOAT)
                .input(ConventionalItemTags.WOODEN_CHESTS)
                .criterion(hasItem(ModBlocks.POISONED_PLANKS), conditionsFromItem(ModBlocks.POISONED_PLANKS))
                .criterion(hasItem(CHEST), conditionsFromItem(CHEST)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POISONED_WOOD)
                .input('A', ModBlocks.POISONED_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(POISONED_LOGS), conditionsFromTag(POISONED_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_POISONED_WOOD)
                .input('A', ModBlocks.STRIPPED_POISONED_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(POISONED_LOGS), conditionsFromTag(POISONED_LOGS))
                .offerTo(exporter);
        generateFamily(exporter, ModBlockFamilies.POISONED, FeatureSet.empty());








        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_PLANKS, 4)
                .input(MAHOGANY_LOGS)
                .criterion(hasTag(MAHOGANY_LOGS), conditionsFromTag(MAHOGANY_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_SLAB, 6)
                .input('A', ModBlocks.MAHOGANY_PLANKS)
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_STAIRS, 4)
                .input('A', ModBlocks.MAHOGANY_PLANKS)
                .pattern("A  ").pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_FENCE, 3)
                .input('A', ModBlocks.MAHOGANY_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_FENCE_GATE)
                .input('A', ModBlocks.MAHOGANY_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("BAB")
                .pattern("BAB")
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_DOOR, 3)
                .input('A', ModBlocks.MAHOGANY_PLANKS)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_TRAPDOOR, 2)
                .input('A', ModBlocks.MAHOGANY_PLANKS)
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MAHOGANY_BUTTON)
                .input('A', ModBlocks.MAHOGANY_PLANKS)
                .pattern("A")
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MAHOGANY_PRESSURE_PLATE)
                .input('A', ModBlocks.MAHOGANY_PLANKS)
                .pattern("AA")
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.MAHOGANY_BOAT)
                .input('A', ModBlocks.MAHOGANY_PLANKS)
                .pattern("A A")
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.MAHOGANY_CHEST_BOAT)
                .input(ModItems.MAHOGANY_BOAT)
                .input(ConventionalItemTags.WOODEN_CHESTS)
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .criterion(hasItem(CHEST), conditionsFromItem(CHEST)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_WOOD)
                .input('A', ModBlocks.MAHOGANY_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(MAHOGANY_LOGS), conditionsFromTag(MAHOGANY_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_MAHOGANY_WOOD)
                .input('A', ModBlocks.STRIPPED_MAHOGANY_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(MAHOGANY_LOGS), conditionsFromTag(MAHOGANY_LOGS))
                .offerTo(exporter);
        generateFamily(exporter, ModBlockFamilies.MAHOGANY, FeatureSet.empty());







        //Legacy Recipes
        offerLegacyCutterRecipe(exporter, Blocks.COBBLESTONE, COBBLESTONE_B1_7, COBBLESTONE_C0_0_14A, COBBLESTONE_RD20090515);
        offerLegacyCutterRecipe(exporter, Blocks.OAK_PLANKS, WOODEN_PLANKS_B1_9PRE5, WOODEN_PLANKS_C0_0_15A, WOODEN_PLANKS_C0_0_14A, WOODEN_PLANKS_RD161348, WOODEN_PLANKS_RD20090515);
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
        offerLegacyCutterRecipe(exporter, OAK_LOG, LOG_C0_0_14A);
        offerLegacyCutterRecipe(exporter, OAK_LEAVES, LEAVES_C0_24ST, LEAVES_C0_0_15A, LEAVES_C0_0_14A);
        offerLegacyCutterRecipe(exporter, OAK_SAPLING, SAPLING_C0_24ST, SAPLING_C0_0_13A, SAPLING_RD161348);
        offerLegacyCutterRecipe(exporter, BEDROCK, BEDROCK_C0_0_12A);
        offerLegacyCutterRecipe(exporter, SAND, SAND_B1_9PRE6, SAND_C0_0_15A, SAND_C0_0_14A);
        offerLegacyCutterRecipe(exporter, GRAVEL, GRAVEL_1_3, GRAVEL_B1_9PRE5, GRAVEL_C0_0_15A, GRAVEL_C0_0_14A);
        offerLegacyCutterRecipe(exporter, COAL_ORE, COAL_ORE_1_14, COAL_ORE_C0_0_14A);
        offerLegacyCutterRecipe(exporter, IRON_ORE, IRON_ORE_1_14_1, IRON_ORE_1_14, IRON_ORE_C0_0_14A);
        offerLegacyCutterRecipe(exporter, GOLD_ORE, GOLD_ORE_1_14, GOLD_ORE_C0_26ST, GOLD_ORE_C0_0_14A);
        offerLegacyCutterRecipe(exporter, SPONGE, SPONGE_1_8, SPONGE_C0_0_19A);
        offerLegacyCutterRecipe(exporter, WET_SPONGE, WET_SPONGE_1_8);
        offerLegacyCutterRecipe(exporter, GLASS, GLASS_C0_0_19A);
        offerLegacyCutterRecipe(exporter, GOLD_BLOCK, GOLD_BLOCK_B1_9PRE5, GOLD_BLOCK_A1_2_0, GOLD_BLOCK_C0_26ST, GOLD_BLOCK_C0_0_20A);
        offerLegacyCutterRecipe(exporter, DANDELION, DANDELION_C0_0_20A);
        offerLegacyCutterRecipe(exporter, POPPY, ROSE_C0_0_20A, POPPY_1_7);
        offerLegacyCutterRecipe(exporter, BROWN_MUSHROOM, BROWN_MUSHROOM_C0_0_20A);
        offerLegacyCutterRecipe(exporter, RED_MUSHROOM, RED_MUSHROOM_C0_0_20A);
        offerLegacyCutterRecipe(exporter, IRON_BLOCK, IRON_BLOCK_B1_9PRE5, IRON_BLOCK_A1_2_0, IRON_BLOCK_C0_26ST);
        offerLegacyCutterRecipe(exporter, TNT, TNT_C0_28A, TNT_C0_26ST);
        offerLegacyCutterRecipe(exporter, MOSSY_COBBLESTONE, MOSSY_COBBLESTONE_C0_26ST, MOSSY_COBBLESTONE_C0_26ST);
        offerLegacyCutterRecipe(exporter, BRICKS, BRICKS_A1_0_11, BRICKS_C0_26ST);
        offerLegacyCutterRecipe(exporter, BOOKSHELF, BOOKSHELF_B1_9PRE5, BOOKSHELF_C0_26ST);
        offerLegacyCutterRecipe(exporter, OBSIDIAN, OBSIDIAN_C0_28A);
        offerLegacyCutterRecipe(exporter, DIAMOND_ORE, DIAMOND_ORE_1_14, DIAMOND_ORE_IN20100128);
        offerLegacyCutterRecipe(exporter, DIAMOND_BLOCK, DIAMOND_BLOCK_B1_9PRE5, DIAMOND_BLOCK_A1_2_0, DIAMOND_BLOCK_IN20100128);
        offerLegacyCutterRecipe(exporter, CRAFTING_TABLE, CRAFTING_TABLE_1_14, CRAFTING_TABLE_IN20100131);
        offerLegacyCutterRecipe(exporter, FURNACE, FURNACE_B1_2, FURNACE_IN20100219);
        offerLegacyCutterRecipe(exporter, LADDER, LADDER_INF20100607, LADDER_INF20100618);
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_STAIRS_INF20100629)
                .input('A', COBBLESTONE_C0_0_14A)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(COBBLESTONE_C0_0_14A), conditionsFromItem(COBBLESTONE_C0_0_14A))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_STAIRS_B1_7)
                .input('A', COBBLESTONE_B1_7)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(COBBLESTONE_B1_7), conditionsFromItem(COBBLESTONE_B1_7))
                .offerTo(exporter);
        offerLegacyCutterRecipe(exporter, TORCH, TORCH_IN20100124_2);
        offerLegacyCutterRecipe(exporter, OAK_DOOR, WOODEN_DOOR_INF20100607);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WOODEN_DOOR_INF20100607)
                .input('A', WOODEN_PLANKS_C0_0_15A)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .criterion(hasItem(WOODEN_PLANKS_C0_0_15A), conditionsFromItem(WOODEN_PLANKS_C0_0_15A))
                .offerTo(exporter);
        offerLegacyCutterRecipe(exporter, REDSTONE_ORE, REDSTONE_ORE_1_14, REDSTONE_ORE_A1_0_1);
        offerLegacyCutterRecipe(exporter, REDSTONE_TORCH, REDSTONE_TORCH_A1_0_1);
        offerLegacyCutterRecipe(exporter, SNOW, SNOW_A1_0_4);
        offerLegacyCutterRecipe(exporter, SNOW_BLOCK, SNOW_BLOCK_A1_0_5);
        offerLegacyCutterRecipe(exporter, ICE, ICE_A1_0_4);
        offerLegacyCutterRecipe(exporter, CLAY, CLAY_BLOCK_A1_0_11);
        offerLegacyCutterRecipe(exporter, OAK_FENCE, WOODEN_FENCE_B1_9PRE5, WOODEN_FENCE_A1_0_17, WOODEN_FENCE_C0_0_14A, WOODEN_FENCE_RD161348, WOODEN_FENCE_RD20090515);
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
        offerLegacyCutterRecipe(exporter, NETHERRACK, NETHERRACK_B1_9PRE5, NETHERRACK_A1_2_0);
        offerLegacyCutterRecipe(exporter, SOUL_SAND, SOUL_SAND_A1_2_0);
        offerLegacyCutterRecipe(exporter, GLOWSTONE, GLOWSTONE_B1_9PRE5, GLOWSTONE_A1_2_0);
        offerLegacyCutterRecipe(exporter, CARVED_PUMPKIN, CARVED_PUMPKIN_A1_2_0);
        offerLegacyCutterRecipe(exporter, JACK_O_LANTERN, JACK_O_LANTERN_A1_2_0);
        offerLegacyCutterRecipe(exporter, LIGHT_GRAY_WOOL, LIGHT_GRAY_WOOL_1_2_4, LIGHT_GRAY_WOOL_B1_2);
        offerLegacyCutterRecipe(exporter, GRAY_WOOL, GRAY_WOOL_1_2_4, GRAY_WOOL_B1_2);
        offerLegacyCutterRecipe(exporter, BLACK_WOOL, BLACK_WOOL_1_2_4, BLACK_WOOL_B1_2);
        offerLegacyCutterRecipe(exporter, BROWN_WOOL, BROWN_WOOL_1_2_4, BROWN_WOOL_B1_2);
        offerLegacyCutterRecipe(exporter, RED_WOOL, RED_WOOL_1_2_4, RED_WOOL_B1_2);
        offerLegacyCutterRecipe(exporter, ORANGE_WOOL, ORANGE_WOOL_1_2_4, ORANGE_WOOL_B1_2);
        offerLegacyCutterRecipe(exporter, YELLOW_WOOL, YELLOW_WOOL_1_2_4, YELLOW_WOOL_B1_2);
        offerLegacyCutterRecipe(exporter, LIME_WOOL, LIME_WOOL_1_2_4, LIME_WOOL_B1_2);
        offerLegacyCutterRecipe(exporter, GREEN_WOOL, GREEN_WOOL_1_2_4, GREEN_WOOL_B1_2);
        offerLegacyCutterRecipe(exporter, CYAN_WOOL, CYAN_WOOL_1_2_4, CYAN_WOOL_B1_2);
        offerLegacyCutterRecipe(exporter, LIGHT_BLUE_WOOL, LIGHT_BLUE_WOOL_1_2_4, LIGHT_BLUE_WOOL_B1_2);
        offerLegacyCutterRecipe(exporter, BLUE_WOOL, BLUE_WOOL_1_2_4, BLUE_WOOL_B1_2);
        offerLegacyCutterRecipe(exporter, PURPLE_WOOL, PURPLE_WOOL_1_2_4, PURPLE_WOOL_B1_2);
        offerLegacyCutterRecipe(exporter, MAGENTA_WOOL, MAGENTA_WOOL_1_2_4, MAGENTA_WOOL_B1_2);
        offerLegacyCutterRecipe(exporter, PINK_WOOL, PINK_WOOL_1_2_4, PINK_WOOL_B1_2);
        offerLegacyCutterRecipe(exporter, CAKE, CAKE_B1_2);
        offerLegacyCutterRecipe(exporter, LAPIS_ORE, LAPIS_ORE_1_14, LAPIS_ORE_B1_2);
        offerLegacyCutterRecipe(exporter, LAPIS_BLOCK, LAPIS_BLOCK_1_6, LAPIS_BLOCK_B1_2);
        offerLegacyCutterRecipe(exporter, NOTE_BLOCK, NOTE_BLOCK_B1_2);
        offerLegacyCutterRecipe(exporter, SANDSTONE, SANDSTONE_1_2_4, SANDSTONE_B1_2);
        offerLegacyCutterRecipe(exporter, BIRCH_LOG, BIRCH_LOG_B1_2, BIRCH_LOG_1_7);
        offerLegacyCutterRecipe(exporter, BIRCH_LEAVES, BIRCH_LEAVES_B1_2);
        offerLegacyCutterRecipe(exporter, SPRUCE_LOG, SPRUCE_LOG_B1_2, SPRUCE_LOG_1_7);
        offerLegacyCutterRecipe(exporter, SPRUCE_LEAVES, SPRUCE_LEAVES_B1_2);
        offerLegacyCutterRecipe(exporter, CRYING_OBSIDIAN, CRYING_OBSIDIAN_B1_3);
        offerLegacyCutterRecipe(exporter, COBBLESTONE_SLAB, COBBLESTONE_SLAB_B1_7, COBBLESTONE_SLAB_B1_3, COBBLESTONE_SLAB_RD20090515);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_B1_7, COBBLESTONE_B1_7);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_SLAB_B1_3, COBBLESTONE_C0_0_14A);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_SLAB_RD20090515, COBBLESTONE_RD20090515);
        offerLegacyCutterRecipe(exporter, OAK_SLAB, WOODEN_SLAB_B1_9PRE5, WOODEN_SLAB_B1_3, WOODEN_SLAB_C0_0_14A, WOODEN_SLAB_RD161348, WOODEN_SLAB_RD20090515);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_SLAB_B1_9PRE5, WOODEN_PLANKS_B1_9PRE5);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_SLAB_B1_3, WOODEN_PLANKS_C0_0_15A);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_SLAB_C0_0_14A, WOODEN_PLANKS_C0_0_14A);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_SLAB_RD161348, WOODEN_PLANKS_RD161348);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WOODEN_SLAB_RD20090515, WOODEN_PLANKS_RD20090515);
        offerLegacyCutterRecipe(exporter, SANDSTONE_SLAB, SANDSTONE_SLAB_1_2_4, SANDSTONE_SLAB_B1_3);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_SLAB_1_2_4, SANDSTONE_1_2_4);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_SLAB_B1_3, SANDSTONE_B1_2);
        offerLegacyCutterRecipe(exporter, SMOOTH_STONE, SMOOTH_STONE_B1_3);
        offerLegacyCutterRecipe(exporter, BIRCH_SAPLING, BIRCH_SAPLING_B1_5);
        offerLegacyCutterRecipe(exporter, SPRUCE_SAPLING, SPRUCE_SAPLING_B1_5);
        offerLegacyCutterRecipe(exporter, POWERED_RAIL, POWERED_RAIL_B1_5);
        offerLegacyCutterRecipe(exporter, DETECTOR_RAIL, DETECTOR_RAIL_B1_5);
        offerLegacyCutterRecipe(exporter, COBWEB, COBWEB_B1_5);
        offerLegacyCutterRecipe(exporter, DEAD_BUSH, DEAD_BUSH_B1_6, SHRUB_B1_6);
        offerLegacyCutterRecipe(exporter, SHORT_GRASS, SHORT_GRASS_B1_6);
        offerLegacyCutterRecipe(exporter, FERN, FERN_B1_6);
        offerLegacyCutterRecipe(exporter, OAK_TRAPDOOR, TRAPDOOR_B1_6);
        offerLegacyCutterRecipe(exporter, STONE_BRICKS, STONE_BRICKS_B1_8);
        offerLegacyCutterRecipe(exporter, CRACKED_STONE_BRICKS, CRACKED_STONE_BRICKS_B1_8);
        offerLegacyCutterRecipe(exporter, MOSSY_STONE_BRICKS, MOSSY_STONE_BRICKS_B1_8);
        offerLegacyCutterRecipe(exporter, BRICK_SLAB, BRICK_SLAB_B1_8, BRICK_SLAB_C0_26ST);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BRICK_SLAB_B1_8, BRICKS_A1_0_11);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BRICK_SLAB_C0_26ST, BRICKS_C0_26ST);
        offerLegacyCutterRecipe(exporter, STONE_BRICK_SLAB, STONE_BRICK_SLAB_B1_8);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, STONE_BRICK_SLAB_B1_8, STONE_BRICKS_B1_8);
        offerLegacyCutterRecipe(exporter, BRICK_STAIRS, BRICK_STAIRS_B1_8, BRICK_STAIRS_C0_26ST);
        offerStairsRecipe(exporter, BRICK_STAIRS_B1_8, BRICKS_A1_0_11);
        offerStairsRecipe(exporter, BRICK_STAIRS_C0_26ST, BRICKS_C0_26ST);
        offerLegacyCutterRecipe(exporter, STONE_BRICK_STAIRS, STONE_BRICK_STAIRS_B1_8);
        offerStairsRecipe(exporter, STONE_BRICK_STAIRS_B1_8, STONE_BRICKS_B1_8);
        offerLegacyCutterRecipe(exporter, GLASS_PANE, GLASS_PANE_B1_8);
        offerLegacyCutterRecipe(exporter, OAK_FENCE_GATE, WOODEN_FENCE_GATE_B1_9PRE5, WOODEN_FENCE_GATE_B1_8,
                WOODEN_FENCE_GATE_C0_0_14A, WOODEN_FENCE_GATE_RD161348, WOODEN_FENCE_GATE_RD20090515);
        offerFenceGateRecipe(exporter, WOODEN_FENCE_GATE_B1_9PRE5, WOODEN_PLANKS_B1_9PRE5);
        offerFenceGateRecipe(exporter, WOODEN_FENCE_GATE_B1_8, WOODEN_PLANKS_C0_0_15A);
        offerFenceGateRecipe(exporter, WOODEN_FENCE_GATE_C0_0_14A, WOODEN_PLANKS_C0_0_14A);
        offerFenceGateRecipe(exporter, WOODEN_FENCE_GATE_RD161348, WOODEN_PLANKS_RD161348);
        offerFenceGateRecipe(exporter, WOODEN_FENCE_GATE_RD20090515, WOODEN_PLANKS_RD20090515);
        offerLegacyCutterRecipe(exporter, VINE, VINES_B1_8);
        offerLegacyCutterRecipe(exporter, MUSHROOM_STEM, MUSHROOM_STEM_B1_8);
        offerLegacyCutterRecipe(exporter, RED_MUSHROOM_BLOCK, RED_MUSHROOM_BLOCK_B1_8);
        offerLegacyCutterRecipe(exporter, BROWN_MUSHROOM_BLOCK, BROWN_MUSHROOM_BLOCK_B1_8);
        offerLegacyCutterRecipe(exporter, MELON, MELON_BLOCK_B1_8);
        offerLegacyCutterRecipe(exporter, NETHER_BRICKS, NETHER_BRICKS_B1_9PRE);
        offerLegacyCutterRecipe(exporter, NETHER_BRICK_STAIRS, NETHER_BRICK_STAIRS_B1_9PRE);
        offerStairsRecipe(exporter, NETHER_BRICK_STAIRS_B1_9PRE, NETHER_BRICKS_B1_9PRE);
        offerLegacyCutterRecipe(exporter, NETHER_BRICK_FENCE, NETHER_BRICK_FENCE_B1_9PRE);
        offerLegacyCutterRecipe(exporter, LILY_PAD, LILY_PAD_B1_9PRE);
        offerLegacyCutterRecipe(exporter, END_STONE, ENDSTONE_B1_9PRE4);
        offerLegacyCutterRecipe(exporter, JUNGLE_LOG, JUNGLE_LOG_1_7, JUNGLE_LOG_1_2);
        offerLegacyCutterRecipe(exporter, JUNGLE_LEAVES, JUNGLE_LEAVES_1_2);
        offerLegacyCutterRecipe(exporter, JUNGLE_SAPLING, JUNGLE_SAPLING_1_2);
        offerLegacyCutterRecipe(exporter, REDSTONE_LAMP, REDSTONE_LAMP_1_2);
        offerLegacyCutterRecipe(exporter, CHISELED_STONE_BRICKS, CHISELED_STONE_BRICKS_1_2);
        offerLegacyCutterRecipe(exporter, BIRCH_PLANKS, BIRCH_PLANKS_1_2_4);
        offerSingleOutputShapelessRecipe(exporter, BIRCH_PLANKS_1_2_4, BIRCH_LOG_1_7, "planks");
        offerSingleOutputShapelessRecipe(exporter, BIRCH_PLANKS_1_2_4, BIRCH_LOG_B1_2, "planks");
        offerLegacyCutterRecipe(exporter, SPRUCE_PLANKS, SPRUCE_PLANKS_1_2_4);
        offerSingleOutputShapelessRecipe(exporter, SPRUCE_PLANKS_1_2_4, SPRUCE_LOG_1_7, "planks");
        offerSingleOutputShapelessRecipe(exporter, SPRUCE_PLANKS_1_2_4, SPRUCE_LOG_B1_2, "planks");
        offerLegacyCutterRecipe(exporter, JUNGLE_PLANKS, JUNGLE_PLANKS_1_2_4);
        offerSingleOutputShapelessRecipe(exporter, JUNGLE_PLANKS_1_2_4, JUNGLE_LOG_1_7, "planks");
        offerSingleOutputShapelessRecipe(exporter, JUNGLE_PLANKS_1_2_4, JUNGLE_LOG_1_2, "planks");
        offerLegacyCutterRecipe(exporter, CUT_SANDSTONE, CUT_SANDSTONE_1_2_4);
        offerLegacyCutterRecipe(exporter, CHISELED_SANDSTONE, CHISELED_SANDSTONE_1_2_4);
        offerLegacyCutterRecipe(exporter, BIRCH_SLAB, BIRCH_SLAB_1_3);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BIRCH_SLAB_1_3, BIRCH_PLANKS_1_2_4);
        offerLegacyCutterRecipe(exporter, SPRUCE_SLAB, SPRUCE_SLAB_1_3);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SPRUCE_SLAB_1_3, SPRUCE_PLANKS_1_2_4);
        offerLegacyCutterRecipe(exporter, JUNGLE_SLAB, JUNGLE_SLAB_1_3);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JUNGLE_SLAB_1_3, JUNGLE_PLANKS_1_2_4);
        offerLegacyCutterRecipe(exporter, COCOA_BEANS, COCOA_1_3);
        offerLegacyCutterRecipe(exporter, EMERALD_ORE, EMERALD_ORE_1_14, EMERALD_ORE_1_3, RUBY_ORE);
        offerLegacyCutterRecipe(exporter, SANDSTONE_STAIRS, SANDSTONE_STAIRS_1_3, SANDSTONE_STAIRS_B1_2);
        offerStairsRecipe(exporter, SANDSTONE_STAIRS_1_3, SANDSTONE_1_2_4);
        offerStairsRecipe(exporter, SANDSTONE_STAIRS_B1_2, SANDSTONE_B1_2);
        offerLegacyCutterRecipe(exporter, EMERALD_BLOCK, EMERALD_BLOCK_1_3);
        offerLegacyCutterRecipe(exporter, BIRCH_STAIRS, BIRCH_STAIRS_1_3);
        offerStairsRecipe(exporter, BIRCH_STAIRS_1_3, BIRCH_PLANKS_1_2_4);
        offerLegacyCutterRecipe(exporter, SPRUCE_STAIRS, SPRUCE_STAIRS_1_3);
        offerStairsRecipe(exporter, SPRUCE_STAIRS_1_3, SPRUCE_PLANKS_1_2_4);
        offerLegacyCutterRecipe(exporter, JUNGLE_STAIRS, JUNGLE_STAIRS_1_3);
        offerStairsRecipe(exporter, JUNGLE_STAIRS_1_3, JUNGLE_PLANKS_1_2_4);
        offerLegacyCutterRecipe(exporter, OAK_WOOD, OAK_WOOD_1_3);
        offerLegacyCutterRecipe(exporter, BIRCH_WOOD, BIRCH_WOOD_1_3);
        offerLegacyCutterRecipe(exporter, SPRUCE_WOOD, SPRUCE_WOOD_1_3);
        offerLegacyCutterRecipe(exporter, JUNGLE_WOOD, JUNGLE_WOOD_1_3);
        offerLegacyCutterRecipe(exporter, OAK_BUTTON, WOODEN_BUTTON_1_4, WOODEN_BUTTON_C0_0_15A, WOODEN_BUTTON_C0_0_14A, WOODEN_BUTTON_RD161348, WOODEN_BUTTON_RD20090515);
        offerButtonRecipe(exporter, WOODEN_BUTTON_1_4, WOODEN_PLANKS_B1_9PRE5);
        offerButtonRecipe(exporter, WOODEN_BUTTON_C0_0_15A, WOODEN_PLANKS_C0_0_15A);
        offerButtonRecipe(exporter, WOODEN_BUTTON_C0_0_14A, WOODEN_PLANKS_C0_0_14A);
        offerButtonRecipe(exporter, WOODEN_BUTTON_RD161348, WOODEN_PLANKS_RD161348);
        offerButtonRecipe(exporter, WOODEN_BUTTON_RD20090515, WOODEN_PLANKS_RD20090515);
        offerLegacyCutterRecipe(exporter, COBBLESTONE_WALL, COBBLESTONE_WALL_1_4, COBBLESTONE_WALL_C0_0_14A, COBBLESTONE_WALL_RD20090515);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_WALL_1_4, COBBLESTONE_B1_7);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_WALL_C0_0_14A, COBBLESTONE_C0_0_14A);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_WALL_RD20090515, COBBLESTONE_RD20090515);
        offerLegacyCutterRecipe(exporter, NETHER_BRICK_SLAB, NETHER_BRICK_SLAB_1_4_6);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHER_BRICK_SLAB_1_4_6, NETHER_BRICKS_B1_9PRE);
        offerLegacyCutterRecipe(exporter, NETHER_QUARTZ_ORE, QUARTZ_ORE_1_5);
        offerLegacyCutterRecipe(exporter, REDSTONE_BLOCK, REDSTONE_BLOCK_1_5);
        offerLegacyCutterRecipe(exporter, ACTIVATOR_RAIL, ACTIVATOR_RAIL_1_5);
        offerLegacyCutterRecipe(exporter, QUARTZ_BLOCK, QUARTZ_BLOCK_1_5);
        offerLegacyCutterRecipe(exporter, CHISELED_QUARTZ_BLOCK, CHISELED_QUARTZ_BLOCK_1_5);
        offerLegacyCutterRecipe(exporter, QUARTZ_PILLAR, QUARTZ_PILLAR_1_5);
        offerLegacyCutterRecipe(exporter, QUARTZ_SLAB, QUARTZ_SLAB_1_5);
        offerLegacyCutterRecipe(exporter, QUARTZ_STAIRS, QUARTZ_STAIRS_1_5);
        offerLegacyCutterRecipe(exporter, SMOOTH_SANDSTONE, SMOOTH_SANDSTONE_1_5);
        offerLegacyCutterRecipe(exporter, SMOOTH_QUARTZ, SMOOTH_QUARTZ_1_5);
        offerCarpetRecipe(exporter, WHITE_CLOTH_CARPET, WHITE_CLOTH);
        offerCarpetRecipe(exporter, LIGHT_GRAY_CLOTH_CARPET_C0_0_20A, LIGHT_GRAY_CLOTH_C0_0_20A);
        offerCarpetRecipe(exporter, LIGHT_GRAY_CLOTH_CARPET_C0_28A, LIGHT_GRAY_CLOTH_C0_28A);
        offerCarpetRecipe(exporter, DARK_GRAY_CLOTH_CARPET_C0_0_20A, DARK_GRAY_CLOTH_C0_0_20A);
        offerCarpetRecipe(exporter, DARK_GRAY_CLOTH_CARPET_C0_28A, DARK_GRAY_CLOTH_C0_28A);
        offerCarpetRecipe(exporter, RED_CLOTH_CARPET, RED_CLOTH);
        offerCarpetRecipe(exporter, ORANGE_CLOTH_CARPET, ORANGE_CLOTH);
        offerCarpetRecipe(exporter, YELLOW_CLOTH_CARPET, YELLOW_CLOTH);
        offerCarpetRecipe(exporter, CHARTREUSE_CLOTH_CARPET, CHARTREUSE_CLOTH);
        offerCarpetRecipe(exporter, SPRING_GREEN_CLOTH_CARPET, SPRING_GREEN_CLOTH);
        offerCarpetRecipe(exporter, CYAN_CLOTH_CARPET, CYAN_CLOTH);
        offerCarpetRecipe(exporter, CAPRI_CLOTH_CARPET, CAPRI_CLOTH);
        offerCarpetRecipe(exporter, ULTRAMARINE_CLOTH_CARPET, ULTRAMARINE_CLOTH);
        offerCarpetRecipe(exporter, VIOLET_CLOTH_CARPET, VIOLET_CLOTH);
        offerCarpetRecipe(exporter, PURPLE_CLOTH_CARPET, PURPLE_CLOTH);
        offerCarpetRecipe(exporter, MAGENTA_CLOTH_CARPET, MAGENTA_CLOTH);
        offerCarpetRecipe(exporter, ROSE_CLOTH_CARPET, ROSE_CLOTH);
        offerCarpetRecipe(exporter, GRAY_CARPET_B1_2, GRAY_WOOL_B1_2);
        offerCarpetRecipe(exporter, BLACK_CARPET_B1_2, BLACK_WOOL_B1_2);
        offerCarpetRecipe(exporter, BROWN_CARPET_B1_2, BROWN_WOOL_B1_2);
        offerCarpetRecipe(exporter, RED_CARPET_B1_2, RED_WOOL_B1_2);
        offerCarpetRecipe(exporter, ORANGE_CARPET_B1_2, ORANGE_WOOL_B1_2);
        offerCarpetRecipe(exporter, YELLOW_CARPET_B1_2, YELLOW_WOOL_B1_2);
        offerCarpetRecipe(exporter, LIME_CARPET_B1_2, LIME_WOOL_B1_2);
        offerCarpetRecipe(exporter, GREEN_CARPET_B1_2, GREEN_WOOL_B1_2);
        offerCarpetRecipe(exporter, CYAN_CARPET_B1_2, CYAN_WOOL_B1_2);
        offerCarpetRecipe(exporter, LIGHT_BLUE_CARPET_B1_2, LIGHT_BLUE_WOOL_B1_2);
        offerCarpetRecipe(exporter, BLUE_CARPET_B1_2, BLUE_WOOL_B1_2);
        offerCarpetRecipe(exporter, PURPLE_CARPET_B1_2, PURPLE_WOOL_B1_2);
        offerCarpetRecipe(exporter, MAGENTA_CARPET_B1_2, MAGENTA_WOOL_B1_2);
        offerCarpetRecipe(exporter, PINK_CARPET_B1_2, PINK_WOOL_B1_2);
        offerCarpetRecipe(exporter, LIGHT_GRAY_CARPET_1_2_4, LIGHT_GRAY_WOOL_1_2_4);
        offerCarpetRecipe(exporter, GRAY_CARPET_1_2_4, GRAY_WOOL_1_2_4);
        offerCarpetRecipe(exporter, BLACK_CARPET_1_2_4, BLACK_WOOL_1_2_4);
        offerCarpetRecipe(exporter, BROWN_CARPET_1_2_4, BROWN_WOOL_1_2_4);
        offerCarpetRecipe(exporter, RED_CARPET_1_2_4, RED_WOOL_1_2_4);
        offerCarpetRecipe(exporter, ORANGE_CARPET_1_2_4, ORANGE_WOOL_1_2_4);
        offerCarpetRecipe(exporter, YELLOW_CARPET_1_2_4, YELLOW_WOOL_1_2_4);
        offerCarpetRecipe(exporter, LIME_CARPET_1_2_4, LIME_WOOL_1_2_4);
        offerCarpetRecipe(exporter, GREEN_CARPET_1_2_4, GREEN_WOOL_1_2_4);
        offerCarpetRecipe(exporter, CYAN_CARPET_1_2_4, CYAN_WOOL_1_2_4);
        offerCarpetRecipe(exporter, LIGHT_BLUE_CARPET_1_2_4, LIGHT_BLUE_WOOL_1_2_4);
        offerCarpetRecipe(exporter, BLUE_CARPET_1_2_4, BLUE_WOOL_1_2_4);
        offerCarpetRecipe(exporter, PURPLE_CARPET_1_2_4, PURPLE_WOOL_1_2_4);
        offerCarpetRecipe(exporter, MAGENTA_CARPET_1_2_4, MAGENTA_WOOL_1_2_4);
        offerCarpetRecipe(exporter, PINK_CARPET_1_2_4, PINK_WOOL_1_2_4);
        offerLegacyCutterRecipe(exporter, HAY_BLOCK, HAY_BALE_1_6);
        offerLegacyCutterRecipe(exporter, TERRACOTTA, TERRACOTTA_1_6);
        offerLegacyCutterRecipe(exporter, COAL_BLOCK, COAL_BLOCK_1_6);
        offerLegacyCutterRecipe(exporter, ALLIUM, ALLIUM_1_7);
        offerLegacyCutterRecipe(exporter, AZURE_BLUET, AZURE_BLUET_1_7);
        offerLegacyCutterRecipe(exporter, BLUE_ORCHID, BLUE_ORCHID_1_7);
        offerLegacyCutterRecipe(exporter, LILAC, LILAC_1_7);
        offerLegacyCutterRecipe(exporter, PEONY, PEONY_1_7);
        offerLegacyCutterRecipe(exporter, ROSE_BUSH, ROSE_BUSH_1_7);
        offerLegacyCutterRecipe(exporter, SUNFLOWER, SUNFLOWER_1_7);
        offerLegacyCutterRecipe(exporter, OXEYE_DAISY, OXEYE_DAISY_1_7);
        offerLegacyCutterRecipe(exporter, RED_TULIP, RED_TULIP_1_7);
        offerLegacyCutterRecipe(exporter, ORANGE_TULIP, ORANGE_TULIP_1_7);
        offerLegacyCutterRecipe(exporter, WHITE_TULIP, WHITE_TULIP_1_7);
        offerLegacyCutterRecipe(exporter, PINK_TULIP, PINK_TULIP_1_7);
        offerLegacyCutterRecipe(exporter, LARGE_FERN, LARGE_FERN_1_7);
        offerLegacyCutterRecipe(exporter, TALL_GRASS, TALL_GRASS_1_7);
        offerLegacyCutterRecipe(exporter, PACKED_ICE, PACKED_ICE_1_7);
        offerLegacyCutterRecipe(exporter, RED_SAND, RED_SAND_1_7);
        offerLegacyCutterRecipe(exporter, WHITE_STAINED_GLASS, WHITE_STAINED_GLASS_1_7);
        offerLegacyCutterRecipe(exporter, ORANGE_STAINED_GLASS, ORANGE_STAINED_GLASS_1_7);
        offerLegacyCutterRecipe(exporter, MAGENTA_STAINED_GLASS, MAGENTA_STAINED_GLASS_1_7);
        offerLegacyCutterRecipe(exporter, LIGHT_BLUE_STAINED_GLASS, LIGHT_BLUE_STAINED_GLASS_1_7);
        offerLegacyCutterRecipe(exporter, YELLOW_STAINED_GLASS, YELLOW_STAINED_GLASS_1_7);
        offerLegacyCutterRecipe(exporter, LIME_STAINED_GLASS, LIME_STAINED_GLASS_1_7);
        offerLegacyCutterRecipe(exporter, PINK_STAINED_GLASS, PINK_STAINED_GLASS_1_7);
        offerLegacyCutterRecipe(exporter, GRAY_STAINED_GLASS, GRAY_STAINED_GLASS_1_7);
        offerLegacyCutterRecipe(exporter, LIGHT_GRAY_STAINED_GLASS, LIGHT_GRAY_STAINED_GLASS_1_7);
        offerLegacyCutterRecipe(exporter, CYAN_STAINED_GLASS, CYAN_STAINED_GLASS_1_7);
        offerLegacyCutterRecipe(exporter, PURPLE_STAINED_GLASS, PURPLE_STAINED_GLASS_1_7);
        offerLegacyCutterRecipe(exporter, BLUE_STAINED_GLASS, BLUE_STAINED_GLASS_1_7);
        offerLegacyCutterRecipe(exporter, BROWN_STAINED_GLASS, BROWN_STAINED_GLASS_1_7);
        offerLegacyCutterRecipe(exporter, GREEN_STAINED_GLASS, GREEN_STAINED_GLASS_1_7);
        offerLegacyCutterRecipe(exporter, RED_STAINED_GLASS, RED_STAINED_GLASS_1_7);
        offerLegacyCutterRecipe(exporter, BLACK_STAINED_GLASS, BLACK_STAINED_GLASS_1_7);
        offerLegacyCutterRecipe(exporter, WHITE_STAINED_GLASS_PANE, WHITE_STAINED_GLASS_PANE_1_7);
        offerLegacyCutterRecipe(exporter, ORANGE_STAINED_GLASS_PANE, ORANGE_STAINED_GLASS_PANE_1_7);
        offerLegacyCutterRecipe(exporter, MAGENTA_STAINED_GLASS_PANE, MAGENTA_STAINED_GLASS_PANE_1_7);
        offerLegacyCutterRecipe(exporter, LIGHT_BLUE_STAINED_GLASS_PANE, LIGHT_BLUE_STAINED_GLASS_PANE_1_7);
        offerLegacyCutterRecipe(exporter, YELLOW_STAINED_GLASS_PANE, YELLOW_STAINED_GLASS_PANE_1_7);
        offerLegacyCutterRecipe(exporter, LIME_STAINED_GLASS_PANE, LIME_STAINED_GLASS_PANE_1_7);
        offerLegacyCutterRecipe(exporter, PINK_STAINED_GLASS_PANE, PINK_STAINED_GLASS_PANE_1_7);
        offerLegacyCutterRecipe(exporter, GRAY_STAINED_GLASS_PANE, GRAY_STAINED_GLASS_PANE_1_7);
        offerLegacyCutterRecipe(exporter, LIGHT_GRAY_STAINED_GLASS_PANE, LIGHT_GRAY_STAINED_GLASS_PANE_1_7);
        offerLegacyCutterRecipe(exporter, CYAN_STAINED_GLASS_PANE, CYAN_STAINED_GLASS_PANE_1_7);
        offerLegacyCutterRecipe(exporter, PURPLE_STAINED_GLASS_PANE, PURPLE_STAINED_GLASS_PANE_1_7);
        offerLegacyCutterRecipe(exporter, BLUE_STAINED_GLASS_PANE, BLUE_STAINED_GLASS_PANE_1_7);
        offerLegacyCutterRecipe(exporter, BROWN_STAINED_GLASS_PANE, BROWN_STAINED_GLASS_PANE_1_7);
        offerLegacyCutterRecipe(exporter, GREEN_STAINED_GLASS_PANE, GREEN_STAINED_GLASS_PANE_1_7);
        offerLegacyCutterRecipe(exporter, RED_STAINED_GLASS_PANE, RED_STAINED_GLASS_PANE_1_7);
        offerLegacyCutterRecipe(exporter, BLACK_STAINED_GLASS_PANE, BLACK_STAINED_GLASS_PANE_1_7);
        offerLegacyCutterRecipe(exporter, ACACIA_LOG, ACACIA_LOG_1_7);
        offerLegacyCutterRecipe(exporter, ACACIA_WOOD, ACACIA_WOOD_1_7);
        offerLegacyCutterRecipe(exporter, ACACIA_LEAVES, ACACIA_LEAVES_1_7);
        offerLegacyCutterRecipe(exporter, ACACIA_SAPLING, ACACIA_SAPLING_1_7);
        offerLegacyCutterRecipe(exporter, DARK_OAK_LOG, DARK_OAK_LOG_1_7);
        offerLegacyCutterRecipe(exporter, DARK_OAK_WOOD, DARK_OAK_WOOD_1_7);
        offerLegacyCutterRecipe(exporter, DARK_OAK_LEAVES, DARK_OAK_LEAVES_1_7);
        offerLegacyCutterRecipe(exporter, DARK_OAK_SAPLING, DARK_OAK_SAPLING_1_7);
        offerLegacyCutterRecipe(exporter, ACACIA_PLANKS, ACACIA_PLANKS_1_7);
        offerSingleOutputShapelessRecipe(exporter, ACACIA_PLANKS_1_7, ACACIA_LOG_1_7, "planks");
        offerLegacyCutterRecipe(exporter, ACACIA_STAIRS, ACACIA_STAIRS_1_7);
        offerStairsRecipe(exporter, ACACIA_STAIRS_1_7, ACACIA_PLANKS_1_7);
        offerLegacyCutterRecipe(exporter, ACACIA_SLAB, ACACIA_SLAB_1_7);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ACACIA_SLAB_1_7, ACACIA_PLANKS_1_7);
        offerLegacyCutterRecipe(exporter, DARK_OAK_PLANKS, DARK_OAK_PLANKS_1_7);
        offerSingleOutputShapelessRecipe(exporter, DARK_OAK_PLANKS_1_7, DARK_OAK_LOG_1_7, "planks");
        offerLegacyCutterRecipe(exporter, DARK_OAK_STAIRS, DARK_OAK_STAIRS_1_7);
        offerStairsRecipe(exporter, DARK_OAK_STAIRS_1_7, DARK_OAK_PLANKS_1_7);
        offerLegacyCutterRecipe(exporter, DARK_OAK_SLAB, DARK_OAK_SLAB_1_7);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DARK_OAK_SLAB_1_7, DARK_OAK_PLANKS_1_7);
        offerLegacyCutterRecipe(exporter, GRANITE, GRANITE_1_8);
        offerLegacyCutterRecipe(exporter, POLISHED_GRANITE, POLISHED_GRANITE_1_8);
        offerLegacyCutterRecipe(exporter, DIORITE, DIORITE_1_8);
        offerLegacyCutterRecipe(exporter, POLISHED_DIORITE, POLISHED_DIORITE_1_8);
        offerLegacyCutterRecipe(exporter, ANDESITE, ANDESITE_1_8);
        offerLegacyCutterRecipe(exporter, POLISHED_ANDESITE, POLISHED_ANDESITE_1_8);
        offerLegacyCutterRecipe(exporter, SLIME_BLOCK, SLIME_BLOCK_1_8);
        offerLegacyCutterRecipe(exporter, PRISMARINE, PRISMARINE_1_8);
        offerLegacyCutterRecipe(exporter, PRISMARINE_BRICKS, PRISMARINE_BRICKS_1_8);
        offerLegacyCutterRecipe(exporter, DARK_PRISMARINE, DARK_PRISMARINE_1_8);
        offerLegacyCutterRecipe(exporter, RED_SANDSTONE, RED_SANDSTONE_1_8);
        offerLegacyCutterRecipe(exporter, CUT_RED_SANDSTONE, CUT_RED_SANDSTONE_1_8);
        offerLegacyCutterRecipe(exporter, CHISELED_RED_SANDSTONE, CHISELED_RED_SANDSTONE_1_8);
        offerLegacyCutterRecipe(exporter, SMOOTH_RED_SANDSTONE, SMOOTH_RED_SANDSTONE_1_8);
        offerLegacyCutterRecipe(exporter, RED_SANDSTONE_SLAB, RED_SANDSTONE_SLAB_1_8);
        offerLegacyCutterRecipe(exporter, RED_SANDSTONE_STAIRS, RED_SANDSTONE_STAIRS_1_8);
        offerLegacyCutterRecipe(exporter, BIRCH_FENCE, BIRCH_FENCE_1_8);
        offerLegacyCutterRecipe(exporter, SPRUCE_FENCE, SPRUCE_FENCE_1_8);
        offerLegacyCutterRecipe(exporter, JUNGLE_FENCE, JUNGLE_FENCE_1_8);
        offerLegacyCutterRecipe(exporter, ACACIA_FENCE, ACACIA_FENCE_1_8);
        offerLegacyCutterRecipe(exporter, DARK_OAK_FENCE, DARK_OAK_FENCE_1_8);
        offerLegacyCutterRecipe(exporter, BIRCH_FENCE_GATE, BIRCH_FENCE_GATE_1_8);
        offerLegacyCutterRecipe(exporter, SPRUCE_FENCE_GATE, SPRUCE_FENCE_GATE_1_8);
        offerLegacyCutterRecipe(exporter, JUNGLE_FENCE_GATE, JUNGLE_FENCE_GATE_1_8);
        offerLegacyCutterRecipe(exporter, ACACIA_FENCE_GATE, ACACIA_FENCE_GATE_1_8);
        offerLegacyCutterRecipe(exporter, DARK_OAK_FENCE_GATE, DARK_OAK_FENCE_GATE_1_8);
        offerLegacyCutterRecipe(exporter, END_ROD, END_ROD_1_9);
        offerLegacyCutterRecipe(exporter, END_STONE_BRICKS, ENDSTONE_BRICKS_1_9);
        offerLegacyCutterRecipe(exporter, PURPUR_BLOCK, PURPUR_BLOCK_1_9);
        offerLegacyCutterRecipe(exporter, PURPUR_PILLAR, PURPUR_PILLAR_1_9);
        offerLegacyCutterRecipe(exporter, PURPUR_SLAB, PURPUR_SLAB_1_9);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPUR_SLAB_1_9, PURPUR_BLOCK_1_9);
        offerLegacyCutterRecipe(exporter, PURPUR_STAIRS, PURPUR_STAIRS_1_9);
        offerStairsRecipe(exporter, PURPUR_STAIRS_1_9, PURPUR_BLOCK_1_9);
        offerLegacyCutterRecipe(exporter, BONE_BLOCK, BONE_BLOCK_1_10);
        offerLegacyCutterRecipe(exporter, MAGMA_BLOCK, MAGMA_BLOCK_1_10);
        offerLegacyCutterRecipe(exporter, NETHER_WART_BLOCK, NETHER_WART_BLOCK_1_10);
        offerLegacyCutterRecipe(exporter, NETHER_WART_BLOCK, NETHER_WART_BLOCK_1_14);
        offerLegacyCutterRecipe(exporter, RED_NETHER_BRICKS, RED_NETHER_BRICKS_1_10);
        offerLegacyCutterRecipe(exporter, BIRCH_BUTTON, BIRCH_BUTTON_1_13);
        offerLegacyCutterRecipe(exporter, SPRUCE_BUTTON, SPRUCE_BUTTON_1_13);
        offerLegacyCutterRecipe(exporter, JUNGLE_BUTTON, JUNGLE_BUTTON_1_13);
        offerLegacyCutterRecipe(exporter, ACACIA_BUTTON, ACACIA_BUTTON_1_13);
        offerLegacyCutterRecipe(exporter, DARK_OAK_BUTTON, DARK_OAK_BUTTON_1_13);
        offerLegacyCutterRecipe(exporter, BIRCH_PRESSURE_PLATE, BIRCH_PRESSURE_PLATE_1_13);
        offerLegacyCutterRecipe(exporter, SPRUCE_PRESSURE_PLATE, SPRUCE_PRESSURE_PLATE_1_13);
        offerLegacyCutterRecipe(exporter, JUNGLE_PRESSURE_PLATE, JUNGLE_PRESSURE_PLATE_1_13);
        offerLegacyCutterRecipe(exporter, ACACIA_PRESSURE_PLATE, ACACIA_PRESSURE_PLATE_1_13);
        offerLegacyCutterRecipe(exporter, DARK_OAK_PRESSURE_PLATE, DARK_OAK_PRESSURE_PLATE_1_13);
        offerLegacyCutterRecipe(exporter, PRISMARINE_SLAB, PRISMARINE_SLAB_1_13);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PRISMARINE_SLAB_1_13, PRISMARINE_1_8);
        offerLegacyCutterRecipe(exporter, PRISMARINE_STAIRS, PRISMARINE_STAIRS_1_13);
        offerStairsRecipe(exporter, PRISMARINE_STAIRS_1_13, PRISMARINE_1_8);

        offerLegacyCutterRecipe(exporter, BOW, QUIVER_IN20091231_2255, QUIVER_IN20100122_2251);
        offerLegacyCutterRecipe(exporter, APPLE, APPLE_IN20091231_2255, APPLE_1_4);
        offerLegacyCutterRecipe(exporter, COAL, COAL_IN20100128, COAL_IN20100219, COAL_1_3);
        offerLegacyCutterRecipe(exporter, DIAMOND, DIAMOND_IN20100128, DIAMOND_1_3);
        offerLegacyCutterRecipe(exporter, GOLD_INGOT, GOLD_INGOT_IN20100128, GOLD_INGOT_IN20100129);
        offerLegacyCutterRecipe(exporter, IRON_INGOT, IRON_INGOT_IN20100128, IRON_INGOT_IN20100129);
        offerLegacyCutterRecipe(exporter, BOWL, BOWL_IN20100130);
        offerLegacyCutterRecipe(exporter, MUSHROOM_STEW, MUSHROOM_STEW_IN20100130);
        offerLegacyCutterRecipe(exporter, GUNPOWDER, SULPHUR);
        offerLegacyCutterRecipe(exporter, STRING, STRING_IN20100130);
        offerLegacyCutterRecipe(exporter, FEATHER, FEATHER_IN20100130, FEATHER_IN20100206);
        offerLegacyCutterRecipe(exporter, BREAD, BREAD_IN20100206, BREAD_1_4);
        offerLegacyCutterRecipe(exporter, WHEAT, WHEAT_IN20100206);
        offerLegacyCutterRecipe(exporter, FLINT, FLINT_IN20100219, FLINT_1_3);
        offerLegacyCutterRecipe(exporter, PORKCHOP, PORKCHOP_IN20100219, PORKCHOP_1_4);
        offerLegacyCutterRecipe(exporter, COOKED_PORKCHOP, COOKED_PORKCHOP_IN20100219, COOKED_PORKCHOP_B1_8, COOKED_PORKCHOP_1_4);
        offerLegacyCutterRecipe(exporter, GOLDEN_APPLE, GOLDEN_APPLE_INF20100227);
        offerLegacyCutterRecipe(exporter, LEATHER, LEATHER_A1_0_8);
        offerLegacyCutterRecipe(exporter, PAPER, PAPER_A1_0_11);
        offerLegacyCutterRecipe(exporter, BOOK, BOOK_A1_0_11);
        offerLegacyCutterRecipe(exporter, CLAY_BALL, CLAY_BALL_A1_0_11);
        offerLegacyCutterRecipe(exporter, BRICK, BRICK_A1_0_11);
        offerLegacyCutterRecipe(exporter, SLIME_BALL, SLIMEBALL_A1_0_11);
        offerLegacyCutterRecipe(exporter, GLOWSTONE_DUST, GLOWSTONE_DUST_A1_2_0);
        offerLegacyCutterRecipe(exporter, COD, FISH_A1_2_0);
        offerLegacyCutterRecipe(exporter, COOKED_COD, COOKED_FISH_A1_2_0);
        offerLegacyCutterRecipe(exporter, BONE, BONE_B1_2);
        offerLegacyCutterRecipe(exporter, BONE_MEAL, BONE_MEAL_B1_2, BONE_MEAL_1_3);
        offerLegacyCutterRecipe(exporter, COOKIE, COOKIE_B1_4);
        offerLegacyCutterRecipe(exporter, CHICKEN, CHICKEN_B1_8, CHICKEN_1_4);
        offerLegacyCutterRecipe(exporter, COOKED_CHICKEN, COOKED_CHICKEN_B1_8, COOKED_CHICKEN_1_4);
        offerLegacyCutterRecipe(exporter, BEEF, BEEF_B1_8, BEEF_1_3, BEEF_1_4);
        offerLegacyCutterRecipe(exporter, COOKED_BEEF, COOKED_BEEF_B1_8, COOKED_BEEF_1_3, COOKED_BEEF_1_4);
        offerLegacyCutterRecipe(exporter, ROTTEN_FLESH, ROTTEN_FLESH_B1_8, ROTTEN_FLESH_1_3);
        offerLegacyCutterRecipe(exporter, GHAST_TEAR, GHAST_TEAR_B1_9PRE);
        offerLegacyCutterRecipe(exporter, GOLD_NUGGET, GOLD_NUGGET_B1_9PRE, GOLD_NUGGET_1_3);
        offerLegacyCutterRecipe(exporter, BLAZE_POWDER, BLAZE_POWDER_B1_9PRE2);
        offerLegacyCutterRecipe(exporter, FERMENTED_SPIDER_EYE, FERMENTED_SPIDER_EYE_B1_9PRE2);
        offerLegacyCutterRecipe(exporter, MAGMA_CREAM, MAGMA_CREAM_B1_9PRE2, MAGMA_CREAM_1_3);
        offerLegacyCutterRecipe(exporter, SPIDER_EYE, SPIDER_EYE_B1_9PRE2);
        offerLegacyCutterRecipe(exporter, GLISTERING_MELON_SLICE, GLISTERING_MELON_B1_9PRE4);
        offerLegacyCutterRecipe(exporter, EMERALD, EMERALD_1_3);
        offerLegacyCutterRecipe(exporter, ENCHANTED_GOLDEN_APPLE, ENCHANTED_GOLDEN_APPLE_1_3);
        offerLegacyCutterRecipe(exporter, GOLDEN_CARROT, GOLDEN_CARROT_1_4);
        offerLegacyCutterRecipe(exporter, BAKED_POTATO, BAKED_POTATO_1_4);
        offerLegacyCutterRecipe(exporter, POISONOUS_POTATO, POISONOUS_POTATO_1_4);
        offerLegacyCutterRecipe(exporter, NETHER_STAR, NETHER_STAR_1_4);
        offerLegacyCutterRecipe(exporter, PUMPKIN_PIE, PUMPKIN_PIE_1_4);
        offerLegacyCutterRecipe(exporter, QUARTZ, QUARTZ_1_5);
        offerLegacyCutterRecipe(exporter, TROPICAL_FISH, CLOWNFISH_1_7);
        offerLegacyCutterRecipe(exporter, SALMON, SALMON_1_7);
        offerLegacyCutterRecipe(exporter, COOKED_SALMON, COOKED_SALMON_1_7);
        offerLegacyCutterRecipe(exporter, PUFFERFISH, PUFFERFISH_1_7);
        offerLegacyCutterRecipe(exporter, PRISMARINE_CRYSTALS, PRISMARINE_CRYSTAL_1_8);
        offerLegacyCutterRecipe(exporter, PRISMARINE_SHARD, PRISMARINE_SHARD_1_8);
        offerLegacyCutterRecipe(exporter, MUTTON, MUTTON_1_8);
        offerLegacyCutterRecipe(exporter, COOKED_MUTTON, COOKED_MUTTON_1_8);
        offerLegacyCutterRecipe(exporter, RABBIT, RABBIT_1_8);
        offerLegacyCutterRecipe(exporter, COOKED_RABBIT, COOKED_RABBIT_1_8);
        offerLegacyCutterRecipe(exporter, RABBIT_FOOT, RABBIT_FOOT_1_8);
        offerLegacyCutterRecipe(exporter, RABBIT_HIDE, RABBIT_HIDE_1_8);
        offerLegacyCutterRecipe(exporter, RABBIT_STEW, RABBIT_STEW_1_8);


        offerFutureCutterRecipe(exporter, PALE_OAK_LOG, 1);
        offerFutureCutterRecipe(exporter, PALE_OAK_SAPLING, 1);
        offerFutureCutterRecipe(exporter, PALE_MOSS, 1);
        offerFutureCutterRecipe(exporter, PALE_HANGING_MOSS, 1);
        offerFutureCutterRecipe(exporter, CLOSED_EYEBLOSSOM, 1);
        offerFutureCutterRecipe(exporter, OPEN_EYEBLOSSOM, 1);
        offerFutureCutterRecipe(exporter, RESIN_CLUMP, 1);
        offerFutureCutterRecipe(exporter, RESIN_BRICK, 1);
        offerFutureCutterRecipe(exporter, RESIN_BLOCK, 1);
        offerFutureCutterRecipe(exporter, RESIN_BRICKS, 1);
        offerFutureCutterRecipe(exporter, WILDFLOWERS, 1);
        offerFutureCutterRecipe(exporter, LEAF_LITTERS, 1);
        offerFutureCutterRecipe(exporter, SHORT_DRY_GRASS, 1);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, PALE_OAK_PLANKS, 4)
                .input(PALE_OAK_LOG)
                .criterion(hasTag(PALE_OAK_LOGS), conditionsFromTag(PALE_OAK_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, PALE_OAK_BOAT)
                .input('A', PALE_OAK_PLANKS)
                .pattern("A A")
                .pattern("AAA")
                .criterion(hasItem(PALE_OAK_PLANKS), conditionsFromItem(PALE_OAK_PLANKS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, PALE_OAK_CHEST_BOAT)
                .input(PALE_OAK_BOAT)
                .input(ConventionalItemTags.WOODEN_CHESTS)
                .criterion(hasItem(PALE_OAK_PLANKS), conditionsFromItem(PALE_OAK_PLANKS))
                .criterion(hasItem(CHEST), conditionsFromItem(CHEST)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, PALE_OAK_WOOD)
                .input('A', PALE_OAK_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(PALE_OAK_LOGS), conditionsFromTag(PALE_OAK_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, STRIPPED_PALE_OAK_WOOD)
                .input('A', STRIPPED_PALE_OAK_LOG)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasTag(PALE_OAK_LOGS), conditionsFromTag(PALE_OAK_LOGS))
                .offerTo(exporter);
        generateFamily(exporter, ModBlockFamilies.PALE_OAK, FeatureSet.empty());
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RESIN_BLOCK)
                .input('A', RESIN_CLUMP)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(RESIN_CLUMP), conditionsFromItem(RESIN_CLUMP))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, RESIN_CLUMP, 9)
                .input(RESIN_BLOCK)
                .criterion(hasItem(RESIN_BLOCK), conditionsFromItem(RESIN_BLOCK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RESIN_BRICKS)
                .input('A', RESIN_BRICK)
                .pattern("AA")
                .pattern("AA")
                .criterion(hasItem(RESIN_BRICK), conditionsFromItem(RESIN_BRICK))
                .offerTo(exporter);
        offerSmelting(exporter, List.of(RESIN_CLUMP), RecipeCategory.MISC, RESIN_BRICK, 0.1F, 200, "resin_brick");
        generateFamily(exporter, ModBlockFamilies.RESIN_BRICKS, FeatureSet.empty());
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RESIN_BRICK_SLAB, RESIN_BRICKS, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RESIN_BRICK_STAIRS, RESIN_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RESIN_BRICK_WALL, RESIN_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_RESIN_BRICKS, RESIN_BRICKS);




        offerWoodcutterRecipe(exporter, OAK_PLANKS,
                OAK_SLAB,
                OAK_STAIRS,
                OAK_DOOR,
                OAK_TRAPDOOR,
                OAK_FENCE,
                OAK_FENCE_GATE,
                OAK_PRESSURE_PLATE,
                OAK_BUTTON,
                OAK_SIGN,
                OAK_HANGING_SIGN,
                OAK_BOAT,
                OAK_CHEST_BOAT);
        offerWoodcutterRecipe(exporter, BIRCH_PLANKS,
                BIRCH_SLAB,
                BIRCH_STAIRS,
                BIRCH_DOOR,
                BIRCH_TRAPDOOR,
                BIRCH_FENCE,
                BIRCH_FENCE_GATE,
                BIRCH_PRESSURE_PLATE,
                BIRCH_BUTTON,
                BIRCH_SIGN,
                BIRCH_HANGING_SIGN,
                BIRCH_BOAT,
                BIRCH_CHEST_BOAT);
        offerWoodcutterRecipe(exporter, SPRUCE_PLANKS,
                SPRUCE_SLAB,
                SPRUCE_STAIRS,
                SPRUCE_DOOR,
                SPRUCE_TRAPDOOR,
                SPRUCE_FENCE,
                SPRUCE_FENCE_GATE,
                SPRUCE_PRESSURE_PLATE,
                SPRUCE_BUTTON,
                SPRUCE_SIGN,
                SPRUCE_HANGING_SIGN,
                SPRUCE_BOAT,
                SPRUCE_CHEST_BOAT);
        offerWoodcutterRecipe(exporter, JUNGLE_PLANKS,
                JUNGLE_SLAB,
                JUNGLE_STAIRS,
                JUNGLE_DOOR,
                JUNGLE_TRAPDOOR,
                JUNGLE_FENCE,
                JUNGLE_FENCE_GATE,
                JUNGLE_PRESSURE_PLATE,
                JUNGLE_BUTTON,
                JUNGLE_SIGN,
                JUNGLE_HANGING_SIGN,
                JUNGLE_BOAT,
                JUNGLE_CHEST_BOAT);
        offerWoodcutterRecipe(exporter, ACACIA_PLANKS,
                ACACIA_SLAB,
                ACACIA_STAIRS,
                ACACIA_DOOR,
                ACACIA_TRAPDOOR,
                ACACIA_FENCE,
                ACACIA_FENCE_GATE,
                ACACIA_PRESSURE_PLATE,
                ACACIA_BUTTON,
                ACACIA_SIGN,
                ACACIA_HANGING_SIGN,
                ACACIA_BOAT,
                ACACIA_CHEST_BOAT);
        offerWoodcutterRecipe(exporter, DARK_OAK_PLANKS,
                DARK_OAK_SLAB,
                DARK_OAK_STAIRS,
                DARK_OAK_DOOR,
                DARK_OAK_TRAPDOOR,
                DARK_OAK_FENCE,
                DARK_OAK_FENCE_GATE,
                DARK_OAK_PRESSURE_PLATE,
                DARK_OAK_BUTTON,
                DARK_OAK_SIGN,
                DARK_OAK_HANGING_SIGN,
                DARK_OAK_BOAT,
                DARK_OAK_CHEST_BOAT);
        offerWoodcutterRecipe(exporter, CRIMSON_PLANKS,
                CRIMSON_SLAB,
                CRIMSON_STAIRS,
                CRIMSON_DOOR,
                CRIMSON_TRAPDOOR,
                CRIMSON_FENCE,
                CRIMSON_FENCE_GATE,
                CRIMSON_PRESSURE_PLATE,
                CRIMSON_BUTTON,
                CRIMSON_SIGN,
                CRIMSON_HANGING_SIGN);
        offerWoodcutterRecipe(exporter, WARPED_PLANKS,
                WARPED_SLAB,
                WARPED_STAIRS,
                WARPED_DOOR,
                WARPED_TRAPDOOR,
                WARPED_FENCE,
                WARPED_FENCE_GATE,
                WARPED_PRESSURE_PLATE,
                WARPED_BUTTON,
                WARPED_SIGN,
                WARPED_HANGING_SIGN);
        offerWoodcutterRecipe(exporter, BAMBOO_PLANKS,
                BAMBOO_SLAB,
                BAMBOO_STAIRS,
                BAMBOO_DOOR,
                BAMBOO_TRAPDOOR,
                BAMBOO_FENCE,
                BAMBOO_FENCE_GATE,
                BAMBOO_PRESSURE_PLATE,
                BAMBOO_BUTTON,
                BAMBOO_SIGN,
                BAMBOO_HANGING_SIGN,
                BAMBOO_RAFT,
                BAMBOO_CHEST_RAFT);
        offerWoodcutterRecipe(exporter, MANGROVE_PLANKS,
                MANGROVE_SLAB,
                MANGROVE_STAIRS,
                MANGROVE_DOOR,
                MANGROVE_TRAPDOOR,
                MANGROVE_FENCE,
                MANGROVE_FENCE_GATE,
                MANGROVE_PRESSURE_PLATE,
                MANGROVE_BUTTON,
                MANGROVE_SIGN,
                MANGROVE_HANGING_SIGN,
                MANGROVE_BOAT,
                MANGROVE_CHEST_BOAT);
        offerWoodcutterRecipe(exporter, CHERRY_PLANKS,
                CHERRY_SLAB,
                CHERRY_STAIRS,
                CHERRY_DOOR,
                CHERRY_TRAPDOOR,
                CHERRY_FENCE,
                CHERRY_FENCE_GATE,
                CHERRY_PRESSURE_PLATE,
                CHERRY_BUTTON,
                CHERRY_SIGN,
                CHERRY_HANGING_SIGN,
                CHERRY_BOAT,
                CHERRY_CHEST_BOAT);
        offerWoodcutterRecipe(exporter, PALE_OAK_PLANKS,
                PALE_OAK_SLAB,
                PALE_OAK_STAIRS,
                PALE_OAK_DOOR,
                PALE_OAK_TRAPDOOR,
                PALE_OAK_FENCE,
                PALE_OAK_FENCE_GATE,
                PALE_OAK_PRESSURE_PLATE,
                PALE_OAK_BUTTON,
                PALE_OAK_SIGN,
                PALE_OAK_HANGING_SIGN,
                PALE_OAK_BOAT,
                PALE_OAK_CHEST_BOAT);
        offerWoodcutterRecipe(exporter, BANANA_PLANKS,
                BANANA_SLAB,
                BANANA_STAIRS,
                BANANA_DOOR,
                BANANA_TRAPDOOR,
                BANANA_FENCE,
                BANANA_FENCE_GATE,
                BANANA_PRESSURE_PLATE,
                BANANA_BUTTON,
                BANANA_SIGN,
                BANANA_HANGING_SIGN,
                BANANA_BOAT,
                BANANA_CHEST_BOAT);
        offerWoodcutterRecipe(exporter, CORN_PLANKS,
                CORN_SLAB,
                CORN_STAIRS,
                CORN_DOOR,
                CORN_TRAPDOOR,
                CORN_FENCE,
                CORN_FENCE_GATE,
                CORN_PRESSURE_PLATE,
                CORN_BUTTON,
                CORN_SIGN,
                CORN_HANGING_SIGN,
                CORN_BOAT,
                CORN_CHEST_BOAT);
        offerWoodcutterRecipe(exporter, POISONED_PLANKS,
                POISONED_SLAB,
                POISONED_STAIRS,
                POISONED_DOOR,
                POISONED_TRAPDOOR,
                POISONED_FENCE,
                POISONED_FENCE_GATE,
                POISONED_PRESSURE_PLATE,
                POISONED_BUTTON,
                POISONED_SIGN,
                POISONED_HANGING_SIGN,
                POISONED_BOAT,
                POISONED_CHEST_BOAT);
        offerWoodcutterRecipe(exporter, MAHOGANY_PLANKS,
                MAHOGANY_SLAB,
                MAHOGANY_STAIRS,
                MAHOGANY_DOOR,
                MAHOGANY_TRAPDOOR,
                MAHOGANY_FENCE,
                MAHOGANY_FENCE_GATE,
                MAHOGANY_PRESSURE_PLATE,
                MAHOGANY_BUTTON,
                MAHOGANY_SIGN,
                MAHOGANY_HANGING_SIGN,
                MAHOGANY_BOAT,
                MAHOGANY_CHEST_BOAT);
        offerWRecipe(exporter, ItemTags.PLANKS, CHEST, 1);
        offerWRecipe(exporter, ItemTags.PLANKS, BARREL, 1);
        offerWRecipe(exporter, ItemTags.PLANKS, CRAFTING_TABLE, 1);
        offerWRecipe(exporter, ItemTags.PLANKS, LADDER, 2);
        offerWRecipe(exporter, ItemTags.PLANKS, STICK, 4);
    }

    private static @NotNull String hasTag(@NotNull TagKey<Item> tag) {
        return "has_" + tag.id().toString();
    }

    private void chairRecipe(ChairBlock[] blocks, TagKey<Item> tag, RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, blocks[0])
                .input('A', blocks[0].plank)
                .pattern("A  ")
                .pattern("AAA")
                .pattern("A A")
                .criterion(hasItem(blocks[0].plank), conditionsFromItem(blocks[0].plank))
                .offerTo(exporter);
        blocks = Arrays.copyOfRange(blocks, 1, 23);
        for (ChairBlock chairBlock : blocks) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, chairBlock)
                    .input(tag)
                    .input(chairBlock.seat)
                    .criterion(hasItem(chairBlock.plank), conditionsFromItem(chairBlock.plank))
                    .offerTo(exporter);
        }
    }

    private static void offerWoodcutterRecipe(RecipeExporter exporter,
                                              ItemConvertible plank,
                                              ItemConvertible slab,
                                              ItemConvertible stairs,
                                              ItemConvertible door,
                                              ItemConvertible trapdoor,
                                              ItemConvertible fence,
                                              ItemConvertible fenceGate,
                                              ItemConvertible pressurePlate,
                                              ItemConvertible button,
                                              ItemConvertible sign,
                                              ItemConvertible hangingSign,
                                              ItemConvertible boat,
                                              ItemConvertible chestBoat) {
        offerWRecipe(exporter, plank, slab, 2);
        offerWRecipe(exporter, plank, stairs, 1);
        offerWRecipe(exporter, plank, door, 1);
        offerWRecipe(exporter, plank, trapdoor, 1);
        offerWRecipe(exporter, plank, fence, 3);
        offerWRecipe(exporter, plank, fenceGate, 1);
        offerWRecipe(exporter, plank, pressurePlate, 2);
        offerWRecipe(exporter, plank, button, 4);
        offerWRecipe(exporter, plank, sign, 2);
        offerWRecipe(exporter, plank, hangingSign, 1);
        offerWRecipe(exporter, plank, boat, 1);
        offerWRecipe(exporter, plank, chestBoat, 1);
    }

    private static void offerWoodcutterRecipe(RecipeExporter exporter,
                                              ItemConvertible plank,
                                              ItemConvertible slab,
                                              ItemConvertible stairs,
                                              ItemConvertible door,
                                              ItemConvertible trapdoor,
                                              ItemConvertible fence,
                                              ItemConvertible fenceGate,
                                              ItemConvertible pressurePlate,
                                              ItemConvertible button,
                                              ItemConvertible sign,
                                              ItemConvertible hangingSign) {
        offerWRecipe(exporter, plank, slab, 2);
        offerWRecipe(exporter, plank, stairs, 1);
        offerWRecipe(exporter, plank, door, 1);
        offerWRecipe(exporter, plank, trapdoor, 1);
        offerWRecipe(exporter, plank, fence, 3);
        offerWRecipe(exporter, plank, fenceGate, 1);
        offerWRecipe(exporter, plank, pressurePlate, 2);
        offerWRecipe(exporter, plank, button, 4);
        offerWRecipe(exporter, plank, sign, 2);
        offerWRecipe(exporter, plank, hangingSign, 1);
    }

    private static void offerLegacyCutterRecipe(RecipeExporter exporter, ItemConvertible base, ItemConvertible... legacyVariants) {
        Set<String> generated = new HashSet<>();

        for (int i = 0; i < legacyVariants.length; i++) {
            for (int j = i + 1; j < legacyVariants.length; j++) {
                offerLRecipe(exporter, legacyVariants[i], legacyVariants[j], base, generated);
                offerLRecipe(exporter, legacyVariants[j], legacyVariants[i], base, generated);
            }
        }

        for (ItemConvertible legacy : legacyVariants) {
            offerLRecipe(exporter, base, legacy, base, generated);
            offerLRecipe(exporter, legacy, base, base, generated);
        }
    }

    private static void offerFutureCutterRecipe(RecipeExporter exporter, ItemConvertible output, int count) {
        String id = Registries.ITEM.getId(FUTURE_INGOT).getPath() + "_to_" + Registries.ITEM.getId(output.asItem()).getPath();
        LegacyCutterRecipeJSONBuilder.create(Ingredient.ofItems(FUTURE_INGOT), output.asItem(), count)
                .criterion(hasItem(FUTURE_INGOT), conditionsFromItem(FUTURE_INGOT))
                .offerTo(exporter, Blocktopia.id("legacy_cutting/" + id));
    }

    private static void offerLRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output, ItemConvertible criterionItem, Set<String> generated) {
        String id = Registries.ITEM.getId(input.asItem()).getPath() + "_to_" + Registries.ITEM.getId(output.asItem()).getPath();
        if (generated.add(id)) {
            LegacyCutterRecipeJSONBuilder.create(Ingredient.ofItems(input), output.asItem(), 1)
                    .criterion(hasItem(criterionItem), conditionsFromItem(criterionItem))
                    .offerTo(exporter, Blocktopia.id("legacy_cutting/" + id));
        }
    }

    private static void offerWRecipe(RecipeExporter exporter, TagKey<Item> input, ItemConvertible output, int count) {
        WoodCuttingRecipeJSONBuilder.create(Ingredient.fromTag(input), output.asItem(), count)
                .criterion(hasTag(input), conditionsFromTag(input))
                .offerTo(exporter, Blocktopia.id("wood_cutting/" + input.id().getPath() + "_to_" + Registries.ITEM.getId(output.asItem()).getPath()));
    }

    private static void offerWRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output, int count) {
        WoodCuttingRecipeJSONBuilder.create(Ingredient.ofItems(input), output.asItem(), count)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, Blocktopia.id("wood_cutting/" + Registries.ITEM.getId(input.asItem()).getPath() + "_to_" + Registries.ITEM.getId(output.asItem()).getPath()));
    }


    private void offerStairsRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createStairsRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    private void offerFenceGateRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createFenceGateRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    private void offerButtonRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        offerSingleOutputShapelessRecipe(exporter, output, input, "wooden_button");
    }
}
