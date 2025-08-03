package github.mcdatapack.blocktopia.recipe;

import github.mcdatapack.blocktopia.block.ModBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.world.World;

public class LegacyCuttingRecipe extends CuttingRecipe {
    public LegacyCuttingRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(ModRecipes.LEGACY_CUTTING_RECIPE_TYPE, ModRecipes.LEGACY_CUTTING_RECIPE_SERIALIZER, group, ingredient, result);
    }

    public boolean matches(SingleStackRecipeInput singleStackRecipeInput, World world) {
        return this.ingredient.test(singleStackRecipeInput.item());
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModBlocks.LEGACY_CUTTER);
    }
}