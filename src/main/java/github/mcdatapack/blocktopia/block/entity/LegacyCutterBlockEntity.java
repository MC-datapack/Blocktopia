package github.mcdatapack.blocktopia.block.entity;

import github.mcdatapack.blocktopia.init.BlockEntityTypeInit;
import github.mcdatapack.blocktopia.init.RecipeInit;
import github.mcdatapack.blocktopia.network.BlockPosPayload;
import github.mcdatapack.blocktopia.recipe.LegacyCutterRecipe;
import github.mcdatapack.blocktopia.screenhandler.LegacyCutterScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class LegacyCutterBlockEntity extends LockableContainerBlockEntity implements ExtendedScreenHandlerFactory<BlockPosPayload> {
    protected DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    public final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 20;

    public LegacyCutterBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityTypeInit.LEGACY_CUTTER, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> LegacyCutterBlockEntity.this.progress;
                    case 1 -> LegacyCutterBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> LegacyCutterBlockEntity.this.progress = value;
                    case 1 -> LegacyCutterBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public BlockPosPayload getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return new BlockPosPayload(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("container.blocktopia.legacy_cutter");
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.blocktopia.legacy_cutter");
    }

    @Override
    protected DefaultedList<ItemStack> getHeldStacks() {
        return inventory;
    }

    @Override
    protected void setHeldStacks(DefaultedList<ItemStack> inventory) {

    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new LegacyCutterScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }


    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, this.inventory, registryLookup);
        progress = nbt.getInt("progress");
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, this.inventory, registryLookup);
        nbt.putInt("progress", progress);
    }


    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        var nbt = super.toInitialChunkDataNbt(registryLookup);
        writeNbt(nbt, registryLookup);
        return nbt;
    }


    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()) {
            return;
        }

        if (isOutputSlotEmptyOrReceivable()) {
            if (this.hasRecipe()) {
                this.increaseCraftProgress();
                markDirty(world, pos, state);

                if (hasCraftingFinished()) {
                    this.craftItem();
                    this.resetProgress();
                }
            } else {
                this.resetProgress();
            }
        } else {
            this.resetProgress();
            markDirty(world, pos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
        this.propertyDelegate.set(0, progress);
    }

    private void craftItem() {
        Optional<RecipeEntry<LegacyCutterRecipe>> recipe = getCurrentRecipe();

        if (recipe.isPresent()) {
            ItemStack inputSlot = getStack(INPUT_SLOT);
            inputSlot.decrement(1);
            setStack(INPUT_SLOT, inputSlot);

            ItemStack resultStack = recipe.get().value().getResult(null);
            ItemStack outputStack = getStack(OUTPUT_SLOT);
            if (outputStack.isEmpty()) {
                setStack(OUTPUT_SLOT, resultStack.copy());
            } else {
                outputStack.increment(resultStack.getCount());
                setStack(OUTPUT_SLOT, outputStack);
            }
        }
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
        this.propertyDelegate.set(0, progress);
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<LegacyCutterRecipe>> recipe = getCurrentRecipe();
        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().value().getResult(null))
                && canInsertItemIntoOutputSlot(recipe.get().value().getResult(null).getItem());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return getStack(OUTPUT_SLOT).getItem() == item || getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private Optional<RecipeEntry<LegacyCutterRecipe>> getCurrentRecipe() {
        SimpleInventory inv = new SimpleInventory(inventory.size());
        for(int i = 0; i < inventory.size(); i++) {
            inv.setStack(i, getStack(i));
        }

        return getWorld().getRecipeManager().getFirstMatch(RecipeInit.LEGACY_CUTTER_RECIPE_TYPE, new SingleStackRecipeInput(getStack(INPUT_SLOT)), getWorld());
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return getStack(OUTPUT_SLOT).isEmpty() || getStack(OUTPUT_SLOT).getCount() < getStack(OUTPUT_SLOT).getMaxCount();
    }

    @Override
    public int size() {
        return inventory.size();
    }

    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }
}
