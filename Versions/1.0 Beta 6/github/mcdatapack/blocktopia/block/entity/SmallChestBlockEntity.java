package github.mcdatapack.blocktopia.block.entity;

import github.mcdatapack.blocktopia.init.BlockEntityTypeInit;
import github.mcdatapack.blocktopia.network.BlockPosPayload;
import github.mcdatapack.blocktopia.screenhandler.SmallChestInventoryScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.minecraft.class_1262;
import net.minecraft.class_1277;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2596;
import net.minecraft.class_2602;
import net.minecraft.class_2622;
import net.minecraft.class_2680;
import net.minecraft.class_3222;
import net.minecraft.class_7225;
import org.jetbrains.annotations.Nullable;

public class SmallChestBlockEntity extends class_2586 implements ExtendedScreenHandlerFactory<BlockPosPayload> {
    public static final class_2561 TITLE = class_2561.method_43471("container.blocktopia.small_chest");
    private final class_1277 inventory = new class_1277(9) {
        @Override
        public void method_5431() {
            super.method_5431();
            update();
        }
    };
    private final InventoryStorage inventoryStorage = InventoryStorage.of(inventory, null);

    public SmallChestBlockEntity(class_2338 pos, class_2680 state) {
        super(BlockEntityTypeInit.SMALL_CHEST_BLOCK_ENTITY, pos, state);
    }

    @Override
    public BlockPosPayload getScreenOpeningData(class_3222 player) {
        return new BlockPosPayload(this.field_11867);
    }

    public class_2561 method_5476() {
        return TITLE;
    }

    @Override
    @Nullable
    public class_1703 createMenu(int syncId, class_1661 playerInventory, class_1657 player) {
        return new SmallChestInventoryScreenHandler(syncId, playerInventory, this);
    }

    @Override
    protected void method_11014(class_2487 nbt, class_7225.class_7874 registryLookup) {
        super.method_11014(nbt, registryLookup);
        class_1262.method_5429(nbt, this.inventory.method_54454(), registryLookup);
    }

    @Override
    protected void method_11007(class_2487 nbt, class_7225.class_7874 registryLookup) {
        class_1262.method_5426(nbt, this.inventory.method_54454(), registryLookup);
        super.method_11007(nbt, registryLookup);
    }

    @Override
    @Nullable
    public class_2596<class_2602> method_38235() {
        return class_2622.method_38585(this);
    }

    @Override
    public class_2487 method_16887(class_7225.class_7874 registryLookup) {
        var nbt = super.method_16887(registryLookup);
        method_11007(nbt, registryLookup);
        return nbt;
    }

    private void update() {
        method_5431();
        if (field_11863 != null) {
            field_11863.method_8413(field_11867, method_11010(), method_11010(), class_2248.field_31036);
        }

    }

    public InventoryStorage getInventoryProvider(class_2350 direction) {
        return inventoryStorage;
    }

    public class_1277 getInventory() {
        return this.inventory;
    }
}
