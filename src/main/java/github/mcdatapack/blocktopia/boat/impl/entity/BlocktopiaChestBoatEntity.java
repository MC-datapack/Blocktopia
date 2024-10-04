package github.mcdatapack.blocktopia.boat.impl.entity;

import java.util.Optional;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import github.mcdatapack.blocktopia.boat.impl.BlocktopiaBoatTrackedData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class BlocktopiaChestBoatEntity extends ChestBoatEntity implements BlocktopiaBoatHolder {
    private static final TrackedData<Optional<BlocktopiaBoatType>> BLOCKTOPIA_BOAT = DataTracker.registerData(BlocktopiaChestBoatEntity.class, BlocktopiaBoatTrackedData.HANDLER);

    public BlocktopiaChestBoatEntity(EntityType<? extends BlocktopiaChestBoatEntity> type, World world) {
        super(type, world);
    }

    public BlocktopiaChestBoatEntity(World world) {
        this(Blocktopia.CHEST_BOAT, world);
    }

    public BlocktopiaChestBoatEntity(World world, double x, double y, double z) {
        this(Blocktopia.CHEST_BOAT, world);

        this.setPosition(x, y, z);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
    }

    @Override
    public BlocktopiaBoatType getBlocktopiaBoat() {
        return this.dataTracker.get(BLOCKTOPIA_BOAT).orElse(null);
    }

    @Override
    public void setBlocktopiaBoat(BlocktopiaBoatType boat) {
        this.dataTracker.set(BLOCKTOPIA_BOAT, Optional.of(boat));
    }

    @Override
    protected Text getDefaultName() {
        if (this.getBlocktopiaBoat() == null) {
            return EntityType.CHEST_BOAT.getName();
        }

        return super.getDefaultName();
    }

    @Override
    public Item asItem() {
        return this.getBlocktopiaBoat().getChestItem();
    }

    @Override
    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        return this.hasValidBlocktopiaBoat() && super.shouldRender(cameraX, cameraY, cameraZ);
    }

    @Override
    public void tick() {
        if (this.hasValidBlocktopiaBoat()) {
            super.tick();
        } else {
            this.discard();
        }
    }

    @Override
    public void setVariant(BoatEntity.Type type) {
        return;
    }

    @Override
    public BoatEntity.Type getVariant() {
        return this.getImpersonatedBoatType();
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(BLOCKTOPIA_BOAT, Optional.empty());
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.readBlocktopiaBoatFromNbt(nbt);

        if (!this.hasValidBlocktopiaBoat()) {
            this.discard();
        }
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        this.writeBlocktopiaBoatToNbt(nbt);
    }
}
