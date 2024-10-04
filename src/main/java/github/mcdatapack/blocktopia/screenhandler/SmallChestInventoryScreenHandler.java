package github.mcdatapack.blocktopia.screenhandler;

import github.mcdatapack.blocktopia.block.entity.SmallChestBlockEntity;
import github.mcdatapack.blocktopia.init.ScreenHandlerTypeInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.network.BlockPosPayload;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;

public class SmallChestInventoryScreenHandler extends ScreenHandler {
    private final SmallChestBlockEntity blockEntity;
    private final ScreenHandlerContext context;

    //Client Constructor
    public SmallChestInventoryScreenHandler(int syncId, PlayerInventory playerInventory, BlockPosPayload payload) {
        this(syncId, playerInventory, (SmallChestBlockEntity)playerInventory.player.getWorld().getBlockEntity(payload.pos()));
    }

    //Main Constructor
    public SmallChestInventoryScreenHandler(int syncId, PlayerInventory playerInventory, SmallChestBlockEntity blockEntity) {
        super(ScreenHandlerTypeInit.SMALL_CHEST_INVENTORY_SCREEN_HANDLER, syncId);

        this.blockEntity = blockEntity;
        this.context = ScreenHandlerContext.create(this.blockEntity.getWorld(), this.blockEntity.getPos());

        SimpleInventory inventory = this.blockEntity.getInventory();
        checkSize(inventory, 9);
        inventory.onOpen(playerInventory.player);

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
        addBlockInventory(inventory);
    }

    private void addPlayerInventory(PlayerInventory playerInv) {
        for(int row = 1; row < 4; ++row) {
            for(int column = 0; column < 9; ++column) {
                addSlot(new Slot(playerInv, column + row * 9, 8 + column * 18, 27 + row * 18));
            }
        }

    }

    private void addPlayerHotbar(PlayerInventory playerInv) {
        for(int column = 0; column < 9; ++column) {
            addSlot(new Slot(playerInv, column, 8 + column * 18, 103));
        }

    }

    private void addBlockInventory(SimpleInventory playerInv) {
        for(int row = 0; row < 1; ++row) {
            for(int column = 0; column < 9; ++column) {
                addSlot(new Slot(playerInv, column + row * 9, 8 + column * 18, 15 + row * 18));
            }
        }

    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.blockEntity.getInventory().onClose(player);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = getSlot(slotIndex);
        if (slot != null && slot.hasStack()) {
            ItemStack inSlot = slot.getStack();
            newStack = inSlot.copy();
            if (slotIndex < 36) {
                if (!insertItem(inSlot, 36, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!insertItem(inSlot, 0, 36, false)) {
                return ItemStack.EMPTY;
            }

            if (inSlot.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, BlockInit.SMALL_CHEST);
    }
}
