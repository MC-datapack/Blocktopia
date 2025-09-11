/*package github.mcdatapack.blocktopia.compat;

import com.mojang.serialization.Codec;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.recipe.ModRecipes;
import github.mcdatapack.blocktopia.recipe.WoodCuttingRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.ICodecHelper;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.IRecipeManager;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class WoodCuttingRecipeCategory extends AbstractRecipeCategory<RecipeEntry<WoodCuttingRecipe>> {
    public static final RecipeType<RecipeEntry<WoodCuttingRecipe>> TYPE = mezz.jei.api.recipe.RecipeType.createFromVanilla(ModRecipes.WOOD_CUTTING_RECIPE_TYPE);
    public static final int width = 82;
    public static final int height = 34;

    public WoodCuttingRecipeCategory(IGuiHelper guiHelper) {
        super(
                TYPE,
                Text.translatable("container.blocktopia.woodcutter"),
                guiHelper.createDrawableItemLike(ModBlocks.WOODCUTTER),
                82,
                34
        );
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeEntry<WoodCuttingRecipe> recipeEntry, IFocusGroup focuses) {
        WoodCuttingRecipe recipe = recipeEntry.value();

        builder.addInputSlot(1, 9)
                .setStandardSlotBackground()
                .addIngredients(recipe.getIngredients().getFirst());

        MinecraftClient minecraft = MinecraftClient.getInstance();
        ClientWorld world = minecraft.world;
        if (world == null) {
            throw new NullPointerException("world must not be null.");
        }
        DynamicRegistryManager registryManager = world.getRegistryManager();
        ItemStack output = recipe.getResult(registryManager);

        builder.addOutputSlot(61,  9)
                .setOutputSlotBackground()
                .addItemStack(output);
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, RecipeEntry<WoodCuttingRecipe> recipe, IFocusGroup focuses) {
        builder.addRecipeArrow().setPosition(26, 9);
    }

    @Override
    public boolean isHandled(RecipeEntry<WoodCuttingRecipe> recipeHolder) {
        WoodCuttingRecipe recipe = recipeHolder.value();
        return !recipe.isIgnoredInRecipeBook();
    }

    @Override
    public Identifier getRegistryName(RecipeEntry<WoodCuttingRecipe> recipe) {
        return recipe.id();
    }

    @Override
    public Codec<RecipeEntry<WoodCuttingRecipe>> getCodec(ICodecHelper codecHelper, IRecipeManager recipeManager) {
        return codecHelper.getRecipeHolderCodec();
    }
}
*/