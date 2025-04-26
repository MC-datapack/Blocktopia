package github.mcdatapack.blocktopia.recipe;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface ModRecipes {
    RecipeSerializer<LegacyCutterRecipe> LEGACY_CUTTER_RECIPE_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER, Blocktopia.id(LegacyCutterRecipe.Serializer.ID), LegacyCutterRecipe.Serializer.INSTANCE);
    RecipeType<LegacyCutterRecipe> LEGACY_CUTTER_RECIPE_TYPE =
            Registry.register(Registries.RECIPE_TYPE, Blocktopia.id(LegacyCutterRecipe.Type.ID), LegacyCutterRecipe.Type.INSTANCE);


    static void load() {}
}
