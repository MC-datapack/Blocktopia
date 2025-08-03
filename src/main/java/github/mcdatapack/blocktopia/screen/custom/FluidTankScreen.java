package github.mcdatapack.blocktopia.screen.custom;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.fluid.ModFluids;
import github.mcdatapack.blocktopia.screen.custom.screenhandler.FluidTankScreenHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRendering;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRenderHandler;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributes;
import net.fabricmc.fabric.impl.client.indigo.renderer.helper.TextureHelper;
import net.fabricmc.fabric.impl.client.rendering.fluid.FluidRenderHandlerInfo;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.block.FluidRenderer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.texture.SpriteLoader;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.awt.*;

public class FluidTankScreen extends HandledScreen<FluidTankScreenHandler> {
    private static final Identifier TEXTURE = Blocktopia.id("textures/gui/container/fluid_tank.png");

    public FluidTankScreen(FluidTankScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 166;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        context.drawTexture(TEXTURE, this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight);

        if (!handler.getBlockEntity().getFluidTank().isResourceBlank()) {
            Sprite fluidTexture = FluidRenderHandlerRegistry.INSTANCE.get(handler.getBlockEntity().getFluidTank().variant.getFluid())
                    .getFluidSprites(null, handler.getBlockEntity().getPos(), handler.getBlockEntity().getFluidTank().variant.getFluid().getDefaultState())[0];
            int color = FluidVariantRendering.getColor(handler.getBlockEntity().getFluidTank().variant, handler.getBlockEntity().getWorld(), handler.getBlockEntity().getPos());
            long fluidAmount = handler.getBlockEntity().getFluidTank().amount;
            long maxFluid = BlocktopiaConfig.getConfig().fluidTankCapacity;
            int fluidHeight = (int) ((fluidAmount / (float) maxFluid) * 69);

            int tankX = this.x + 140;
            int tankY = this.y + 10 + (69 - fluidHeight);
            int textureY = 166 - fluidHeight;
            if (handler.getBlockEntity().getFluidTank().variant.getFluid() instanceof WaterFluid) {
                Color color1 = new Color(color, true);
                context.setShaderColor(color1.getRed() / 200F, color1.getGreen() / 200F, color1.getRed() / 50F, color1.getAlpha() / 100F);
            }
            context.drawSprite(tankX, tankY, 0, 24, fluidHeight, fluidTexture);
            if (handler.getBlockEntity().getFluidTank().variant.getFluid() instanceof WaterFluid) {
                context.setShaderColor(1, 1, 1, 1);
            }
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);

        if (!handler.getBlockEntity().getFluidTank().isResourceBlank()) {
            if (mouseX >= this.x + 140 && mouseX <= this.x + 164 &&
                    mouseY >= this.y + 10 && mouseY <= this.y + 79) {

                context.drawTooltip(textRenderer, FluidVariantAttributes.getName(handler.getBlockEntity().getFluidTank().variant), mouseX, mouseY);
            }
        }
    }
}
