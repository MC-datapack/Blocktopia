package github.mcdatapack.blocktopia.datagen.provider;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.ModBlockFamilies;
import github.mcdatapack.blocktopia.block.custom.ChairBlock;
import github.mcdatapack.blocktopia.item.ModItems;
import github.mcdatapack.blocktopia.block.ModBlocks;
import java.util.List;
import java.util.concurrent.CompletableFuture;

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

import static github.mcdatapack.blocktopia.block.LegacyBlocks.*;
import static github.mcdatapack.blocktopia.util.ModTags.Items.*;
import static net.minecraft.item.Items.*;

import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
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
        chairRecipe(ModBlocks.OAK_CHAIR, exporter);
        chairRecipe(ModBlocks.SPRUCE_CHAIR, exporter);
        chairRecipe(ModBlocks.BIRCH_CHAIR, exporter);
        chairRecipe(ModBlocks.JUNGLE_CHAIR, exporter);
        chairRecipe(ModBlocks.ACACIA_CHAIR, exporter);
        chairRecipe(ModBlocks.DARK_OAK_CHAIR, exporter);
        chairRecipe(ModBlocks.CRIMSON_CHAIR, exporter);
        chairRecipe(ModBlocks.WARPED_CHAIR, exporter);
        chairRecipe(ModBlocks.MANGROVE_CHAIR, exporter);
        chairRecipe(ModBlocks.BAMBOO_CHAIR, exporter);
        chairRecipe(ModBlocks.CHERRY_CHAIR, exporter);
        chairRecipe(ModBlocks.PALM_CHAIR, exporter);
        chairRecipe(ModBlocks.BANANA_CHAIR, exporter);
        chairRecipe(ModBlocks.CORN_CHAIR, exporter);
        chairRecipe(ModBlocks.POISONED_CHAIR, exporter);

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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEGACY_CUTTER)
                .input(STONECUTTER)
                .input(CRAFTING_TABLE)
                .criterion(hasItem(STONECUTTER), conditionsFromItem(STONECUTTER))
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
                .input('C', GOLDEN_BLOCKS)
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
                .input('A', GOLDEN_BLOCKS)
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
                .input('A', DIAMOND_BLOCKS)
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










        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BANANA_PLANKS, 4)
                .input(BANANA_LOGS)
                .criterion(hasTag(BANANA_LOGS), conditionsFromTag(BANANA_LOGS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BANANA_SLAB, 6)
                .input('A', ModBlocks.BANANA_PLANKS)
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.BANANA_PLANKS), conditionsFromItem(ModBlocks.BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BANANA_STAIRS, 4)
                .input('A', ModBlocks.BANANA_PLANKS)
                .pattern("A  ").pattern("AA ")
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.BANANA_PLANKS), conditionsFromItem(ModBlocks.BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BANANA_FENCE, 3)
                .input('A', ModBlocks.BANANA_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("ABA")
                .pattern("ABA")
                .criterion(hasItem(ModBlocks.BANANA_PLANKS), conditionsFromItem(ModBlocks.BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BANANA_FENCE_GATE)
                .input('A', ModBlocks.BANANA_PLANKS)
                .input('B', ConventionalItemTags.WOODEN_RODS)
                .pattern("BAB")
                .pattern("BAB")
                .criterion(hasItem(ModBlocks.BANANA_PLANKS), conditionsFromItem(ModBlocks.BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BANANA_DOOR, 3)
                .input('A', ModBlocks.BANANA_PLANKS)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .criterion(hasItem(ModBlocks.BANANA_PLANKS), conditionsFromItem(ModBlocks.BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BANANA_TRAPDOOR, 2)
                .input('A', ModBlocks.BANANA_PLANKS)
                .pattern("AAA")
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.BANANA_PLANKS), conditionsFromItem(ModBlocks.BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.BANANA_BUTTON)
                .input('A', ModBlocks.BANANA_PLANKS)
                .pattern("A")
                .criterion(hasItem(ModBlocks.BANANA_PLANKS), conditionsFromItem(ModBlocks.BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.BANANA_PRESSURE_PLATE)
                .input('A', ModBlocks.BANANA_PLANKS)
                .pattern("AA")
                .criterion(hasItem(ModBlocks.BANANA_PLANKS), conditionsFromItem(ModBlocks.BANANA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.BANANA_BOAT)
                .input('A', ModBlocks.BANANA_PLANKS)
                .pattern("A A")
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.BANANA_PLANKS), conditionsFromItem(ModBlocks.BANANA_PLANKS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.BANANA_CHEST_BOAT)
                .input(ModItems.BANANA_BOAT)
                .input(ConventionalItemTags.WOODEN_CHESTS)
                .criterion(hasItem(ModBlocks.BANANA_PLANKS), conditionsFromItem(ModBlocks.BANANA_PLANKS))
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.CORN_BOAT)
                .input('A', ModBlocks.CORN_PLANKS)
                .pattern("A A")
                .pattern("AAA")
                .criterion(hasItem(ModBlocks.CORN_PLANKS), conditionsFromItem(ModBlocks.CORN_PLANKS))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.CORN_CHEST_BOAT)
                .input(ModItems.CORN_BOAT)
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_STAIRS_INF20100629)
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
        legacyCutterRecipe(exporter, TORCH, TORCH_IN20100124_2);
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

    private void chairRecipe(ChairBlock[] blocks, RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, blocks[0])
                .input('A', blocks[0].plank)
                .pattern("A  ")
                .pattern("AAA")
                .pattern("A A")
                .criterion(hasItem(blocks[0].plank), conditionsFromItem(blocks[0].plank))
                .offerTo(exporter);
        for (int i = 1; i < blocks.length; i++) {
            for (ChairBlock chairBlock : blocks) {
                ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, blocks[i])
                        .input(chairBlock)
                        .input(blocks[i].seat)
                        .criterion(hasItem(blocks[i].plank), conditionsFromItem(blocks[i].plank))
                        .offerTo(exporter, Registries.BLOCK.getId(blocks[i]).withSuffixedPath("_from_" + Registries.BLOCK.getId(chairBlock).getPath()));
            }
        }
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
