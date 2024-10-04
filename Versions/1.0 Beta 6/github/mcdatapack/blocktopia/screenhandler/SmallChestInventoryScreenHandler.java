package github.mcdatapack.blocktopia.screenhandler;

import github.mcdatapack.blocktopia.block.entity.SmallChestBlockEntity;
import github.mcdatapack.blocktopia.init.ScreenHandlerTypeInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.network.BlockPosPayload;
import net.minecraft.class_1277;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_3914;

public class SmallChestInventoryScreenHandler extends class_1703 {
    private final SmallChestBlockEntity blockEntity;
    private final class_3914 context;

    //Client Constructor
    public SmallChestInventoryScreenHandler(int syncId, class_1661 playerInventory, BlockPosPayload payload) {
        this(syncId, playerInventory, (SmallChestBlockEntity)playerInventory.field_7546.method_37908().method_8321(payload.pos()));
    }

    //Main Constructor
    public SmallChestInventoryScreenHandler(int syncId, class_1661 playerInventory, SmallChestBlockEntity blockEntity) {
        super(ScreenHandlerTypeInit.SMALL_CHEST_INVENTORY_SCREEN_HANDLER, syncId);

        this.blockEntity = blockEntity;
        this.context = class_3914.method_17392(this.blockEntity.method_10997(), this.blockEntity.method_11016());

        class_1277 inventory = this.blockEntity.getInventory();
        method_17359(inventory, 9);
        inventory.method_5435(playerInventory.field_7546);

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
        addBlockInventory(inventory);
    }

    private void addPlayerInventory(class_1661 playerInv) {
        for(int row = 1; row < 4; ++row) {
            for(int column = 0; column < 9; ++column) {
                method_7621(new class_1735(playerInv, column + row * 9, 8 + column * 18, 27 + row * 18));
            }
        }

    }

    private void addPlayerHotbar(class_1661 playerInv) {
        for(int column = 0; column < 9; ++column) {
            method_7621(new class_1735(playerInv, column, 8 + column * 18, 103));
        }

    }

    private void addBlockInventory(class_1277 playerInv) {
        for(int row = 0; row < 1; ++row) {
            for(int column = 0; column < 9; ++column) {
                method_7621(new class_1735(playerInv, column + row * 9, 8 + column * 18, 15 + row * 18));
            }
        }

    }

    @Override
    public void method_7595(class_1657 player) {
        super.method_7595(player);
        this.blockEntity.getInventory().method_5432(player);
    }

    @Override
    public class_1799 method_7601(class_1657 player, int slotIndex) {
        class_1799 newStack = class_1799.field_8037;
        class_1735 slot = method_7611(slotIndex);
        if (slot != null && slot.method_7681()) {
            class_1799 inSlot = slot.method_7677();
            newStack = inSlot.method_7972();
            if (slotIndex < 36) {
                if (!method_7616(inSlot, 36, this.field_7761.size(), true)) {
                    return class_1799.field_8037;
                }
            } else if (!method_7616(inSlot, 0, 36, false)) {
                return class_1799.field_8037;
            }

            if (inSlot.method_7960()) {
                slot.method_53512(class_1799.field_8037);
            } else {
                slot.method_7668();
            }
        }

        return newStack;
    }

    @Override
    public boolean method_7597(class_1657 player) {
        return method_17695(this.context, player, BlockInit.SMALL_CHEST);
    }
}
