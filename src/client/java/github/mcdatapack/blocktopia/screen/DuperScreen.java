package github.mcdatapack.blocktopia.screen;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.screenhandler.DuperScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DuperScreen extends HandledScreen<DuperScreenHandler> {
    private static final Identifier TEXTURE = Blocktopia.id("textures/gui/container/duper.png");

    public DuperScreen(DuperScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);

        this.backgroundWidth = 176;
        this.backgroundHeight = 176;
        this.playerInventoryTitleY = this.backgroundHeight - 105;
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
