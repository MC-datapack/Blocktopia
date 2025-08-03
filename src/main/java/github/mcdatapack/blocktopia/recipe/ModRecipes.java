package github.mcdatapack.blocktopia.recipe;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface ModRecipes {
    RecipeSerializer<LegacyCuttingRecipe> LEGACY_CUTTING_RECIPE_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER, Blocktopia.id("legacy_cutting"), new CuttingRecipe.Serializer<>(LegacyCuttingRecipe::new));
    RecipeType<LegacyCuttingRecipe> LEGACY_CUTTING_RECIPE_TYPE =
            Registry.register(Registries.RECIPE_TYPE, Blocktopia.id("legacy_cutting"), new RecipeType<LegacyCuttingRecipe>() {
                @Override
                public String toString() {
                    return "blocktopia:legacy_cutting";
                }
            });
    RecipeSerializer<WoodCuttingRecipe> WOOD_CUTTING_RECIPE_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER, Blocktopia.id("wood_cutting"), new CuttingRecipe.Serializer<>(WoodCuttingRecipe::new));
    RecipeType<WoodCuttingRecipe> WOOD_CUTTING_RECIPE_TYPE =
            Registry.register(Registries.RECIPE_TYPE, Blocktopia.id("wood_cutting"), new RecipeType<WoodCuttingRecipe>() {
                @Override
                public String toString() {
                    return "blocktopia:wood_cutting";
                }
            });



    static void load() {}
}
