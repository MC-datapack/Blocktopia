package github.mcdatapack.blocktopia.recipe;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class LegacyCutterRecipeJSONBuilder implements CraftingRecipeJsonBuilder {
    private final Ingredient input;
    private final Item output;
    private final int count;

    @Nullable
    private String group;
    private final Map<String, AdvancementCriterion<?>> criteria = new LinkedHashMap<>();
    private final LegacyCutterRecipe.RecipeFactory recipeFactory;

    public LegacyCutterRecipeJSONBuilder(LegacyCutterRecipe.RecipeFactory factory, Ingredient input, Item output, int count) {
        this.recipeFactory = factory;
        this.input = input;
        this.output = output;
        this.count = count;
    }

    public static LegacyCutterRecipeJSONBuilder create(Ingredient input, Item output, int count) {
        return new LegacyCutterRecipeJSONBuilder(LegacyCutterRecipe::new, input, output, count);
    }

    @Override
    public LegacyCutterRecipeJSONBuilder criterion(String name, AdvancementCriterion<?> criterion) {
        criteria.put(name, criterion);
        return this;
    }

    @Override
    public LegacyCutterRecipeJSONBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getOutputItem() {
        return output;
    }

    public Ingredient getInput() {
        return input;
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
        LegacyCutterRecipe cuttingRecipe = this.recipeFactory.create(this.input, new ItemStack(this.output, this.count));
        exporter.accept(recipeId, cuttingRecipe, builder.build(recipeId.withPrefixedPath("recipes/legacy_cutter/")));
    }

    private void validate(Identifier recipeId) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeId);
        }
    }
}
