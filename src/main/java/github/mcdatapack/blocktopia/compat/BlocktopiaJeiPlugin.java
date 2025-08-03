package github.mcdatapack.blocktopia.compat;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.recipe.ModRecipes;
import github.mcdatapack.blocktopia.recipe.WoodCuttingRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.MinecraftClient;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class BlocktopiaJeiPlugin implements IModPlugin {

    @Override
    public @NotNull Identifier getPluginUid() {
        return Blocktopia.id("jei");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new LegacyCuttingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new WoodCuttingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Objects.requireNonNull(MinecraftClient.getInstance().world).getRecipeManager();
        recipeManager.listAllOfType(ModRecipes.LEGACY_CUTTING_RECIPE_TYPE)
            .forEach(recipe -> {
                registration.addRecipes(LegacyCuttingRecipeCategory.TYPE, List.of(recipe));
            });
        recipeManager.listAllOfType(ModRecipes.WOOD_CUTTING_RECIPE_TYPE)
                .forEach(recipe -> {
                    registration.addRecipes(WoodCuttingRecipeCategory.TYPE, List.of(recipe));
                });
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalysts(LegacyCuttingRecipeCategory.TYPE,
                ModBlocks.LEGACY_CUTTER
        );
        registration.addRecipeCatalysts(WoodCuttingRecipeCategory.TYPE,
                ModBlocks.WOODCUTTER
        );
    }
}