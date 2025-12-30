package github.mcdatapack.blocktopia.compat;

import github.mcdatapack.blocktopia.Blocktopia;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.fluid.Fluids;
import net.minecraft.text.Text;

import java.util.LinkedList;
import java.util.List;

public class GeneratorRecipeCategory implements DisplayCategory<BasicDisplay> {

    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return CategoryIdentifier.of(Blocktopia.id("generator"));
    }

    @Override
    public Text getTitle() {
        return Text.literal("Generator");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(Fluids.LAVA);
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        final Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() - 35);
        List<Widget> widgets = new LinkedList<>();
        widgets.add(Widgets.createRecipeBase(new Rectangle(startPoint.x, startPoint.y, 175, 82)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 70, startPoint.y + 10))
                .entries(display.getInputEntries().getFirst()));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 45, startPoint.y + 34))
                .entries(display.getInputEntries().get(1)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 70, startPoint.y + 52))
                .entries(display.getInputEntries().get(2)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 70, startPoint.y + 34))
                .markOutput().entries(display.getOutputEntries().getFirst()));

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 74;
    }
}