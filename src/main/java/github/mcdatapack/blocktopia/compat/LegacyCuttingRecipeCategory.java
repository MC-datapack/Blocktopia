package github.mcdatapack.blocktopia.compat;

import com.mojang.serialization.Codec;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.recipe.LegacyCuttingRecipe;
import github.mcdatapack.blocktopia.recipe.ModRecipes;
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

public class LegacyCuttingRecipeCategory extends AbstractRecipeCategory<RecipeEntry<LegacyCuttingRecipe>> {
    public static final RecipeType<RecipeEntry<LegacyCuttingRecipe>> TYPE = mezz.jei.api.recipe.RecipeType.createFromVanilla(ModRecipes.LEGACY_CUTTING_RECIPE_TYPE);
    public static final int width = 82;
    public static final int height = 34;

    public LegacyCuttingRecipeCategory(IGuiHelper guiHelper) {
        super(
                TYPE,
                Text.translatable("container.blocktopia.legacy_cutter"),
                guiHelper.createDrawableItemLike(ModBlocks.LEGACY_CUTTER),
                82,
                34
        );
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeEntry<LegacyCuttingRecipe> recipeEntry, IFocusGroup focuses) {
        LegacyCuttingRecipe recipe = recipeEntry.value();

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
    public void createRecipeExtras(IRecipeExtrasBuilder builder, RecipeEntry<LegacyCuttingRecipe> recipe, IFocusGroup focuses) {
        builder.addRecipeArrow().setPosition(26, 9);
    }

    @Override
    public boolean isHandled(RecipeEntry<LegacyCuttingRecipe> recipeHolder) {
        LegacyCuttingRecipe recipe = recipeHolder.value();
        return !recipe.isIgnoredInRecipeBook();
    }

    @Override
    public Identifier getRegistryName(RecipeEntry<LegacyCuttingRecipe> recipe) {
        return recipe.id();
    }

    @Override
    public Codec<RecipeEntry<LegacyCuttingRecipe>> getCodec(ICodecHelper codecHelper, IRecipeManager recipeManager) {
        return codecHelper.getRecipeHolderCodec();
    }
}
