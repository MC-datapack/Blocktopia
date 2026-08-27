package github.mcdatapack.blocktopia.recipe;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class WoodCuttingRecipeJSONBuilder implements CraftingRecipeJsonBuilder {
    private final Ingredient input;
    private final Item output;
    private final int count;
    @Nullable
    private String group;

    private final Map<String, AdvancementCriterion<?>> criteria = new LinkedHashMap<>();
    private final CuttingRecipe.RecipeFactory<WoodCuttingRecipe> recipeFactory;

    public WoodCuttingRecipeJSONBuilder(CuttingRecipe.RecipeFactory<WoodCuttingRecipe> factory, Ingredient input, ItemConvertible output, int count) {
        this.recipeFactory = factory;
        this.output = output.asItem();
        this.input = input;
        this.count = count;
    }

    public static WoodCuttingRecipeJSONBuilder create(Ingredient input, ItemConvertible output) {
        return new WoodCuttingRecipeJSONBuilder(WoodCuttingRecipe::new, input, output, 1);
    }

    public static WoodCuttingRecipeJSONBuilder create(Ingredient input, ItemConvertible output, int count) {
        return new WoodCuttingRecipeJSONBuilder(WoodCuttingRecipe::new, input, output, count);
    }

    public WoodCuttingRecipeJSONBuilder criterion(String name, AdvancementCriterion<?> criterion) {
        criteria.put(name, criterion);
        return this;
    }

    public WoodCuttingRecipeJSONBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getOutputItem() {
        return output;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void offerTo(RecipeExporter exporter, Identifier recipeId) {
        this.validate(recipeId);
        Advancement.Builder builder = exporter.getAdvancementBuilder()
                .criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId))
                .rewards(AdvancementRewards.Builder.recipe(recipeId))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR);
        this.criteria.forEach(builder::criterion);
        WoodCuttingRecipe cuttingRecipe = this.recipeFactory.create(Objects.requireNonNullElse(this.group, ""), this.input, new ItemStack(this.output, this.count));
        exporter.accept(recipeId, cuttingRecipe, builder.build(recipeId.withPrefixedPath("recipes/wood_cutting/")));
    }

    private void validate(Identifier recipeId) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeId);
        }
    }
}
