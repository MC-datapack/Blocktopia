package github.mcdatapack.blocktopia.compat;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.data.FluidInteraction;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.registry.Registries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratorDisplay extends BasicDisplay {
    public GeneratorDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    public GeneratorDisplay(FluidInteraction recipe) {
        super(getInputList(recipe), List.of(EntryIngredient.of(EntryStacks.of(Registries.BLOCK.get(recipe.resultBlock())))));
    }

    private static List<EntryIngredient> getInputList(FluidInteraction recipe) {
        if(recipe == null) return Collections.emptyList();
        List<EntryIngredient> list = new ArrayList<>();
        list.add(EntryIngredients.of(Registries.FLUID.get(recipe.fluid())));
        list.add(EntryIngredients.of(Registries.BLOCK.get(recipe.neighborBlock())));
        list.add(EntryIngredients.of(Registries.BLOCK.get(recipe.baseBlock())));
        return list;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CategoryIdentifier.of(Blocktopia.id("generator"));
    }
}
