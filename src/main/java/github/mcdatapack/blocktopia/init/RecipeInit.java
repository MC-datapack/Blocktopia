package github.mcdatapack.blocktopia.init;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.recipe.LegacyCutterRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RecipeInit {
    public static final RecipeSerializer LEGACY_CUTTER_RECIPE_SERIALIZER = Registry.register(Registries.RECIPE_SERIALIZER,
            Blocktopia.id(LegacyCutterRecipe.Serializer.ID), LegacyCutterRecipe.Serializer.INSTANCE);
    public static final RecipeType LEGACY_CUTTER_RECIPE_TYPE = Registry.register(Registries.RECIPE_TYPE, Blocktopia.id(LegacyCutterRecipe.Type.ID),
            LegacyCutterRecipe.Type.INSTANCE);

    public static void load() {}
}
