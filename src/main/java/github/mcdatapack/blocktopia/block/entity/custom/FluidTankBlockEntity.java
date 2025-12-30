package github.mcdatapack.blocktopia.block.entity.custom;

import github.mcdatapack.blocktopia.block.custom.FluidTankBlock;
import github.mcdatapack.blocktopia.block.entity.ModBlockEntityTypes;
import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.network.BlockPosPayload;
import github.mcdatapack.blocktopia.screen.custom.screenhandler.FluidTankScreenHandler;
import github.mcdatapack.blocktopia.util.TickableBlockEntity;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.SingleFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageView;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.stream.IntStream;

public class FluidTankBlockEntity extends BlockEntity implements TickableBlockEntity, ExtendedScreenHandlerFactory<BlockPosPayload>, SidedInventory {
    public static final Text NAME = Text.translatable("container.blocktopia.fluid_tank");

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);

    private final InventoryStorage inventoryStorage = InventoryStorage.of(this, null);

    private final ContainerItemContext fluidItemContext = ContainerItemContext.ofSingleSlot(this.inventoryStorage.getSlot(0));

    @Override
    public int[] getAvailableSlots(Direction side) {
        return getControllerOrSelf().getRawAvailableSlots(side);
    }

    public int[] getRawAvailableSlots(Direction side) {
        return IntStream.range(0, inventory.size()).toArray();
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction side) {
        return getControllerOrSelf().canInsertRaw(slot, stack, side);
    }

    public boolean canInsertRaw(int slot, ItemStack stack, Direction side) {
        return inventory.getFirst().isEmpty() && stack.getCount() == 1;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        return getControllerOrSelf().canExtractRaw(slot, stack, side);
    }

    public boolean canExtractRaw(int slot, ItemStack stack, Direction side) {
        return tookFluid && ContainerItemContext.withConstant(stack).find(FluidStorage.ITEM) != null;
    }

    @Override
    public int size() {
        return inventory.size();
    }

    @Override
    public ItemStack getStack(int slot) {
        return getControllerOrSelf().inventory.get(slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        getControllerOrSelf().inventory.set(slot, stack);
        markDirty();
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack stack = Inventories.splitStack(getControllerOrSelf().inventory, slot, amount);
        if (!stack.isEmpty()) markDirty();
        return stack;
    }

    @Override
    public ItemStack removeStack(int slot) {
        ItemStack stack = Inventories.removeStack(getControllerOrSelf().inventory, slot);
        markDirty();
        return stack;
    }

    @Override
    public boolean isEmpty() {
        return getControllerOrSelf().inventory.stream().allMatch(ItemStack::isEmpty);
    }

    @Override
    public void clear() {
        getControllerOrSelf().inventory.clear();
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    public final class ResizableFluidStorage extends SingleFluidStorage {
        public long capacity = BlocktopiaConfig.getConfig().fluidTankCapacity;

        @Override
        protected long getCapacity(FluidVariant variant) {
            return capacity;
        }

        public void setCapacity(long capacity) {
            this.capacity = capacity;
        }

        @Override
        protected void onFinalCommit() {
            update();
        }
    }

    private final ResizableFluidStorage fluidStorage = new ResizableFluidStorage() ;

    public FluidTankBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.FLUID_TANK, pos, state);
    }

    private boolean tookFluid;

    @Override
    public void tick() {
        if (world == null || world.isClient) return;

        FluidTankBlockEntity controller = getController();
        if (controller != this) return;

        int connectedCount = controller.getConnectedTankCount();
        long totalCapacity = connectedCount * BlocktopiaConfig.getConfig().fluidTankCapacity;
        controller.fluidStorage.setCapacity(totalCapacity);

        if (tookFluid && inventory.getFirst().isEmpty())
            tookFluid = false;
        else if (tookFluid)
            return;


        if (controller.inventory.isEmpty() || !controller.isValid(controller.inventory.getFirst(), 0)) return;

        Storage<FluidVariant> itemFluidStorage = this.fluidItemContext.find(FluidStorage.ITEM);
        if (itemFluidStorage == null)
            return;

        FluidVariant match = null;
        for (StorageView<FluidVariant> storageView : itemFluidStorage.nonEmptyViews()) {
            if (storageView.isResourceBlank())
                continue;

            try (Transaction transaction = Transaction.openOuter()) {
                if (this.fluidStorage.insert(storageView.getResource(), FluidConstants.BUCKET, transaction) > 0) {
                    match = storageView.getResource();
                    break;
                }
            }
        }

        if (match != null && !match.isBlank()) {
            try (Transaction transaction = Transaction.openOuter()) {
                long inserted = this.fluidStorage.insert(match, FluidConstants.BUCKET, transaction);
                long extracted = itemFluidStorage.extract(match, inserted, transaction);
                tookFluid = true;
                if (extracted < FluidConstants.BUCKET) {
                    long extra = FluidConstants.BUCKET - extracted;
                    this.fluidStorage.extract(match, extra, transaction);
                }
                transaction.commit();
            }
        }

        try (Transaction transaction = Transaction.openOuter()) {
            for (StorageView<FluidVariant> tankView : this.fluidStorage.nonEmptyViews()) {
                FluidVariant fluidInTank = tankView.getResource();
                long available = tankView.getAmount();

                if (available >= FluidConstants.BOTTLE) {
                    long inserted = itemFluidStorage.insert(fluidInTank, FluidConstants.BOTTLE, transaction);
                    if (inserted > 0) {
                        this.fluidStorage.extract(fluidInTank, inserted, transaction);
                        tookFluid = true;
                        transaction.commit();
                        break;
                    } else {
                        inserted = itemFluidStorage.insert(fluidInTank, FluidConstants.BUCKET, transaction);
                        if (inserted > 0) {
                            this.fluidStorage.extract(fluidInTank, inserted, transaction);
                            tookFluid = true;
                            transaction.commit();
                            break;
                        }
                    }
                }
            }
        }
    }

    private FluidTankBlockEntity getControllerOrSelf() {
        FluidTankBlockEntity controller = getController();
        return controller != null ? controller : this;
    }

    public FluidTankBlockEntity getController() {
        if (world == null) return null;

        Direction.Axis axis = getConnectionAxis();
        BlockPos current = this.pos;

        while (true) {
            BlockPos prev = current.offset(Direction.from(axis, Direction.AxisDirection.NEGATIVE));
            BlockEntity be = world.getBlockEntity(prev);
            if (!(be instanceof FluidTankBlockEntity tank)) break;

            if (tank.getConnectionAxis() != axis) break;

            current = prev;
        }

        BlockEntity controller = world.getBlockEntity(current);
        return controller instanceof FluidTankBlockEntity tank ? tank : this;
    }

    public boolean isConnected(Direction direction) {
        if (!getConnectionAxis().test(direction)) return false;
        return world.getBlockState(pos.offset(direction)).getBlock() instanceof FluidTankBlock &&
                world.getBlockState(pos.offset(direction)).get(FluidTankBlock.CONNECTION_AXIS).test(direction);
    }

    public int getConnectedTankCount() {
        Direction.Axis axis = getConnectionAxis();
        int count = 1;

        BlockPos current = this.pos;
        while (true) {
            BlockPos next = current.offset(Direction.from(axis, Direction.AxisDirection.POSITIVE));
            BlockEntity be = world.getBlockEntity(next);
            if (!(be instanceof FluidTankBlockEntity)) break;

            FluidTankBlockEntity tank = (FluidTankBlockEntity) be;
            if (tank.getConnectionAxis() != axis) break;

            count++;
            current = next;
        }

        current = this.pos;
        while (true) {
            BlockPos prev = current.offset(Direction.from(axis, Direction.AxisDirection.NEGATIVE));
            BlockEntity be = world.getBlockEntity(prev);
            if (!(be instanceof FluidTankBlockEntity)) break;

            FluidTankBlockEntity tank = (FluidTankBlockEntity) be;
            if (tank.getConnectionAxis() != axis) break;

            count++;
            current = prev;
        }

        return count;
    }

    private boolean isTank(BlockState state) {
        return state.getBlock() instanceof FluidTankBlock;
    }

    public Direction.Axis getConnectionAxis() {
        if (world == null) return Direction.Axis.Y;
        BlockState state = world.getBlockState(pos);
        return state.contains(FluidTankBlock.CONNECTION_AXIS)
                ? state.get(FluidTankBlock.CONNECTION_AXIS)
                : Direction.Axis.Y;
    }

    public FluidTankBlock.TankSegmentType getSegmentType() {
        if (world == null) return FluidTankBlock.TankSegmentType.SINGLE;
        BlockState state = world.getBlockState(pos);
        return state.contains(FluidTankBlock.SEGMENT_TYPE)
                ? state.get(FluidTankBlock.SEGMENT_TYPE)
                : FluidTankBlock.TankSegmentType.SINGLE;
    }


    @Override
    public BlockPosPayload getScreenOpeningData(ServerPlayerEntity player) {
        FluidTankBlockEntity controller = getController();
        return new BlockPosPayload(controller.getPos());
    }

    @Override
    public Text getDisplayName() {
        return NAME;
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new FluidTankScreenHandler(syncId, playerInventory, this);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);

        if (nbt.contains("Inventory", NbtElement.COMPOUND_TYPE)) {
            Inventories.readNbt(nbt.getCompound("Inventory"), this.inventory, registryLookup);
        }

        if (nbt.contains("FluidTank", NbtElement.COMPOUND_TYPE)) {
            this.fluidStorage.readNbt(nbt.getCompound("FluidTank"), registryLookup);
        }

        if (nbt.contains("FluidCapacity", NbtElement.LONG_TYPE)) {
            getControllerOrSelf().fluidStorage.setCapacity(nbt.getLong("FluidCapacity"));
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);

        NbtCompound inventoryNbt = new NbtCompound();
        Inventories.writeNbt(inventoryNbt, this.inventory, registryLookup);
        nbt.put("Inventory", inventoryNbt);

        NbtCompound fluidNbt = new NbtCompound();
        this.fluidStorage.writeNbt(fluidNbt, registryLookup);
        nbt.put("FluidTank", fluidNbt);

        nbt.putLong("FluidCapacity", fluidStorage.getCapacity());
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        NbtCompound nbt = super.toInitialChunkDataNbt(registryLookup);
        writeNbt(nbt, registryLookup);
        return nbt;
    }

    private void update() {
        markDirty();
        if (world != null)
            world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
    }

    public boolean isValid(ItemStack stack, int slot) {
        if (stack.isEmpty()) return true;
        if (slot != 0) return false;

        Storage<FluidVariant> storage = ContainerItemContext.withConstant(stack).find(FluidStorage.ITEM);
        return storage != null;
    }

    public InventoryStorage getInventoryProvider(Direction direction) {
        return inventoryStorage;
    }

    public FluidTankBlockEntity.ResizableFluidStorage getFluidTankProvider(Direction direction) {
        FluidTankBlockEntity controller = getController();
        return controller.fluidStorage;
    }

    public long getCapacity() {
        return getControllerOrSelf().fluidStorage.capacity;
    }

    public Inventory getInventory() {
        return this;
    }

    public FluidTankBlockEntity.ResizableFluidStorage getFluidTank() {
        FluidTankBlockEntity controller = getController();
        return controller.fluidStorage;
    }
}
