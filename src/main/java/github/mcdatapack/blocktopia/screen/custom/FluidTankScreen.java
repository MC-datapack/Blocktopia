package github.mcdatapack.blocktopia.screen.custom;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.screen.custom.screenhandler.FluidTankScreenHandler;
import github.mcdatapack.blocktopia.screen.custom.widget.FluidWidget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class FluidTankScreen extends HandledScreen<FluidTankScreenHandler> {
    private static final Identifier TEXTURE = Blocktopia.id("textures/gui/container/fluid_tank.png");

    public FluidTankScreen(FluidTankScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 166;
    }

    @Override
    protected void init() {
        super.init();

        addDrawable(FluidWidget.builder(this.handler.getBlockEntity())
                        .bounds(this.x + 140, this.y + 9, 25, 70)
                        .build());
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        context.drawTexture(TEXTURE, this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
