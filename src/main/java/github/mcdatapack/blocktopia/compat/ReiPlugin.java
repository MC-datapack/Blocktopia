package github.mcdatapack.blocktopia.compat;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.data.FluidInteractionRegistry;
import github.mcdatapack.blocktopia.recipe.LegacyCuttingRecipe;
import github.mcdatapack.blocktopia.recipe.ModRecipes;
import github.mcdatapack.blocktopia.recipe.WoodCuttingRecipe;
import github.mcdatapack.blocktopia.screen.custom.LegacyCutterScreen;
import github.mcdatapack.blocktopia.screen.custom.WoodCutterScreen;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;

public class ReiPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new LegacyCuttingRecipeCategory());
        registry.add(new WoodCuttingRecipeCategory());
        registry.add(new GeneratorRecipeCategory());
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(LegacyCuttingRecipe.class, ModRecipes.LEGACY_CUTTING_RECIPE_TYPE, LegacyCuttingDisplay::new);
        registry.registerRecipeFiller(WoodCuttingRecipe.class, ModRecipes.WOOD_CUTTING_RECIPE_TYPE, WoodCuttingDisplay::new);
        FluidInteractionRegistry.getAll()
                .forEach(interaction -> registry.add(new GeneratorDisplay(interaction)));
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), LegacyCutterScreen.class,
                CategoryIdentifier.of(Blocktopia.id("legacy_cutting")));
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), WoodCutterScreen.class,
                CategoryIdentifier.of(Blocktopia.id("woodcutting")));
    }
}
