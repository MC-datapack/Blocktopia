package github.mcdatapack.blocktopia.mixin.entity.villager;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.MerchantScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.MerchantScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerData;
import org.spongepowered.asm.mixin.*;

@Mixin(MerchantScreen.class)
public abstract class VillagerScreenMixin extends HandledScreen<MerchantScreenHandler> {
    public VillagerScreenMixin(MerchantScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Shadow @Final private static Identifier EXPERIENCE_BAR_BACKGROUND_TEXTURE;
    @Shadow @Final private static Identifier EXPERIENCE_BAR_CURRENT_TEXTURE;
    @Shadow @Final private static Identifier EXPERIENCE_BAR_RESULT_TEXTURE;
    @Shadow @Final private static Text TRADES_TEXT;
    @Unique
    private static final int MAX_LEVEL = 10;

    /**
     * @author Mc-datapack (Timo_11)
     * @reason Make the Level visible for Villager levels above 5
     */
    @Overwrite
    public void drawForeground(DrawContext context, int mouseX, int mouseY) {
        int i = this.handler.getLevelProgress();
        if (i > 0 && i <= MAX_LEVEL && this.handler.isLeveled()) {
            Text text = Text.translatable("merchant.title", this.title, Text.translatable("merchant.level." + i));
            int j = this.textRenderer.getWidth(text);
            int k = 49 + this.backgroundWidth / 2 - j / 2;
            context.drawText(this.textRenderer, text, k, 6, 4210752, false);
        } else {
            context.drawText(this.textRenderer, this.title, 49 + this.backgroundWidth / 2 - this.textRenderer.getWidth(this.title) / 2, 6, 4210752, false);
        }

        context.drawText(this.textRenderer, this.playerInventoryTitle, this.playerInventoryTitleX, this.playerInventoryTitleY, 4210752, false);
        int l = this.textRenderer.getWidth(TRADES_TEXT);
        context.drawText(this.textRenderer, TRADES_TEXT, 5 - l / 2 + 48, 6, 4210752, false);
    }

    /**
     * @author Mc-datapack (Timo_11)
     * @reason Make the Experience Bar visible for Villager levels above 5
     */
    @Overwrite
    private void drawLevelInfo(DrawContext context, int x, int y, TradeOffer offer) {
        int i = handler.getLevelProgress();
        int j = handler.getExperience();
        if (i < MAX_LEVEL) {
            context.drawGuiTexture(EXPERIENCE_BAR_BACKGROUND_TEXTURE, x + 136, y + 16, 0, 102, 5);
            int k = VillagerData.getLowerLevelExperience(i);
            if (j >= k && VillagerData.canLevelUp(i)) {
                float f = 102.0F / (VillagerData.getUpperLevelExperience(i) - k);
                int m = Math.min(MathHelper.floor(f * (j - k)), 102);
                context.drawGuiTexture(EXPERIENCE_BAR_CURRENT_TEXTURE, 102, 5, 0, 0, x + 136, y + 16, 0, m, 5);
                int n = this.handler.getMerchantRewardedExperience();
                if (n > 0) {
                    int o = Math.min(MathHelper.floor(n * f), 102 - m);
                    context.drawGuiTexture(EXPERIENCE_BAR_RESULT_TEXTURE, 102, 5, m, 0, x + 136 + m, y + 16, 0, o, 5);
                }
            }
        }
    }
}
