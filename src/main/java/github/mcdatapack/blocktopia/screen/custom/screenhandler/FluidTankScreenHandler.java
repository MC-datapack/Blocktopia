package github.mcdatapack.blocktopia.screen.custom.screenhandler;

import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.block.entity.custom.FluidTankBlockEntity;
import github.mcdatapack.blocktopia.network.BlockPosPayload;
import github.mcdatapack.blocktopia.screen.ModScreenHandlerTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;

public class FluidTankScreenHandler extends ScreenHandler {
    private final FluidTankBlockEntity blockEntity;
    private final ScreenHandlerContext context;

    @SuppressWarnings("DataFlowIssue")
    public FluidTankScreenHandler(int syncId, PlayerInventory playerInventory, BlockPosPayload payload) {
        this(syncId, playerInventory, (FluidTankBlockEntity) playerInventory.player.getWorld().getBlockEntity(payload.pos()));
    }

    public FluidTankScreenHandler(int syncId, PlayerInventory playerInventory, FluidTankBlockEntity blockEntity) {
        super(ModScreenHandlerTypes.FLUID_TANK, syncId);

        this.blockEntity = blockEntity;
        this.context = ScreenHandlerContext.create(blockEntity.getWorld(), blockEntity.getPos());

        Inventory inventory = blockEntity.getInventory();
        checkSize(inventory, 1);
        inventory.onOpen(playerInventory.player);

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
        addSlot(new Slot(inventory, 0, 80, 33) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return inventory.isValid(0, stack);
            }
        });
    }

    private void addPlayerInventory(PlayerInventory playerInv) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(playerInv, 9 + (column + (row * 9)), 8 + (column * 18), 84 + (row * 18)));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInv) {
        for (int column = 0; column < 9; column++) {
            addSlot(new Slot(playerInv, column, 8 + (column * 18), 142));
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

            if (slotIndex == 0) {
                if (!insertItem(inSlot, 0, this.slots.size(), false))
                    return ItemStack.EMPTY;
            } else if (!insertItem(inSlot, 0, 0, true))
                return ItemStack.EMPTY;

            if (inSlot.isEmpty())
                slot.setStack(ItemStack.EMPTY);
            else
                slot.markDirty();
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return context.get((world, pos) -> world.getBlockState(pos).isOf(ModBlocks.FLUID_TANK)).orElse(false);
    }

    public FluidTankBlockEntity getBlockEntity() {
        return this.blockEntity;
    }
}
