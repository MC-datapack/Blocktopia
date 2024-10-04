package github.mcdatapack.blocktopia.screen;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.screenhandler.SmallChestInventoryScreenHandler;
import net.minecraft.class_1661;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_465;

public class SmallChestInventoryScreen extends class_465<SmallChestInventoryScreenHandler> {
    private static final class_2960 TEXTURE = Blocktopia.id("textures/gui/container/example_inventory_block.png");

    public SmallChestInventoryScreen(SmallChestInventoryScreenHandler handler, class_1661 inventory, class_2561 title) {
        super(handler, inventory, title);
        this.field_2792 = 176;
        this.field_2779 = 184;
        this.field_25270 = this.field_2779 - 94;
    }

    @Override
    protected void method_2389(class_332 context, float delta, int mouseX, int mouseY) {
        context.method_25302(TEXTURE, this.field_2776, this.field_2800, 0, 0, this.field_2792, this.field_2779);
    }

    @Override
    public void method_25394(class_332 context, int mouseX, int mouseY, float delta) {
        super.method_25394(context, mouseX, mouseY, delta);
        method_2380(context, mouseX, mouseY);
    }
}