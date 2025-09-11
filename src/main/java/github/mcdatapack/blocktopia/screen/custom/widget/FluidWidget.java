package github.mcdatapack.blocktopia.screen.custom.widget;

import github.mcdatapack.blocktopia.block.entity.custom.FluidTankBlockEntity;
import github.mcdatapack.blocktopia.util.ScreenUtils;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Consumer;

public class FluidWidget implements Drawable, Widget {
    private final FluidTankBlockEntity blockEntity;

    private final int width, height;
    private int x, y;

    public FluidWidget(FluidTankBlockEntity blockEntity, int x, int y, int width, int height) {
        this.blockEntity = blockEntity;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public static Builder builder(FluidTankBlockEntity blockEntity) {
        return new Builder(blockEntity);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        FluidTankBlockEntity.ResizableFluidStorage fluidStorage = blockEntity.getFluidTank();

        long fluidAmount = fluidStorage.getAmount();
        if(fluidAmount <= 0)
            return;

        Fluid fluid = fluidStorage.variant.getFluid();
        long fluidCapacity = blockEntity.getCapacity();
        int fluidHeight = Math.round(((float) fluidAmount / fluidCapacity) * this.height);

        FluidRenderHandler fluidRenderHandler = FluidRenderHandlerRegistry.INSTANCE.get(fluid);
        if(fluidRenderHandler == null)
            return;

        BlockPos pos = blockEntity.getPos();
        FluidState fluidState = fluid.getDefaultState();
        World world = MinecraftClient.getInstance().world;
        if(world == null)
            return;

        Sprite sprite = fluidRenderHandler.getFluidSprites(world, pos, fluidState)[0];

        int tintColor = fluidRenderHandler.getFluidColor(world, pos, fluidState);
        float red = (tintColor >> 16 & 0xFF) / 255f;
        float green = (tintColor >> 8 & 0xFF) / 255f;
        float blue = (tintColor & 0xFF) / 255f;
        ScreenUtils.renderTiledSprite(context, sprite, this.x, this.y + this.height - fluidHeight, this.width, fluidHeight, red, green, blue, 1.0f);

        if(isPointWithinBounds(this.x, this.y, this.width, this.height, mouseX, mouseY)) {
            drawTooltip(context, mouseX, mouseY);
        }
    }

    protected void drawTooltip(DrawContext context, int mouseX, int mouseY) {
        FluidTankBlockEntity.ResizableFluidStorage fluidStorage = blockEntity.getFluidTank();

        Fluid fluid = fluidStorage.variant.getFluid();
        long fluidAmount = fluidStorage.getAmount();
        long fluidCapacity = blockEntity.getCapacity();

        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        if(fluid != null && fluidAmount > 0) {
            List<Text> texts = List.of(
                    Text.translatable(fluid.getDefaultState().getBlockState().getBlock().getTranslationKey()),
                    Text.literal("%s / %s B".formatted(getB(fluidAmount), getB(fluidCapacity)))
            );
            context.drawTooltip(textRenderer, texts, mouseX, mouseY);
        }
    }

    private static long getB(long amount) {
        return (long) ((float) amount / FluidConstants.BUCKET);
    }

    private static boolean isPointWithinBounds(int x, int y, int width, int height, int pointX, int pointY) {
        return pointX >= x && pointX <= x + width &&
                pointY >= y && pointY <= y + height;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void forEachChild(Consumer<ClickableWidget> consumer) {}

    public static class Builder {
        private final FluidTankBlockEntity blockEntity;
        private int x, y;
        private int width, height;

        public Builder(FluidTankBlockEntity blockEntity) {
            this.blockEntity = blockEntity;
        }

        public Builder x(int x) {
            this.x = x;
            return this;
        }

        public Builder y(int y) {
            this.y = y;
            return this;
        }

        public Builder position(int x, int y) {
            this.x = x;
            this.y = y;
            return this;
        }

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder size(int width, int height) {
            this.width = width;
            this.height = height;
            return this;
        }

        public Builder bounds(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            return this;
        }

        public FluidWidget build() {
            return new FluidWidget(this.blockEntity, this.x, this.y, this.width, this.height);
        }
    }
}