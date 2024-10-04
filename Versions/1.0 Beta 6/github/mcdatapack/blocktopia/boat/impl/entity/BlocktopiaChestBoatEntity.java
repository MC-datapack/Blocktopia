package github.mcdatapack.blocktopia.boat.impl.entity;

import java.util.Optional;
import net.minecraft.class_1299;
import net.minecraft.class_1690;
import net.minecraft.class_1792;
import net.minecraft.class_1937;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_2940;
import net.minecraft.class_2945;
import net.minecraft.class_7264;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import github.mcdatapack.blocktopia.boat.impl.BlocktopiaBoatTrackedData;

public class BlocktopiaChestBoatEntity extends class_7264 implements BlocktopiaBoatHolder {
    private static final class_2940<Optional<BlocktopiaBoatType>> BLOCKTOPIA_BOAT = class_2945.method_12791(BlocktopiaChestBoatEntity.class, BlocktopiaBoatTrackedData.HANDLER);

    public BlocktopiaChestBoatEntity(class_1299<? extends BlocktopiaChestBoatEntity> type, class_1937 world) {
        super(type, world);
    }

    public BlocktopiaChestBoatEntity(class_1937 world) {
        this(Blocktopia.CHEST_BOAT, world);
    }

    public BlocktopiaChestBoatEntity(class_1937 world, double x, double y, double z) {
        this(Blocktopia.CHEST_BOAT, world);

        this.method_5814(x, y, z);
        this.field_6014 = x;
        this.field_6036 = y;
        this.field_5969 = z;
    }

    @Override
    public BlocktopiaBoatType getBlocktopiaBoat() {
        return this.field_6011.method_12789(BLOCKTOPIA_BOAT).orElse(null);
    }

    @Override
    public void setBlocktopiaBoat(BlocktopiaBoatType boat) {
        this.field_6011.method_12778(BLOCKTOPIA_BOAT, Optional.of(boat));
    }

    @Override
    protected class_2561 method_23315() {
        if (this.getBlocktopiaBoat() == null) {
            return class_1299.field_38096.method_5897();
        }

        return super.method_23315();
    }

    @Override
    public class_1792 method_7557() {
        return this.getBlocktopiaBoat().getChestItem();
    }

    @Override
    public boolean method_5727(double cameraX, double cameraY, double cameraZ) {
        return this.hasValidBlocktopiaBoat() && super.method_5727(cameraX, cameraY, cameraZ);
    }

    @Override
    public void method_5773() {
        if (this.hasValidBlocktopiaBoat()) {
            super.method_5773();
        } else {
            this.method_31472();
        }
    }

    @Override
    public void method_47884(class_1690.class_1692 type) {
        return;
    }

    @Override
    public class_1690.class_1692 method_47827() {
        return this.getImpersonatedBoatType();
    }

    @Override
    protected void method_5693(class_2945.class_9222 builder) {
        super.method_5693(builder);
        builder.method_56912(BLOCKTOPIA_BOAT, Optional.empty());
    }

    @Override
    protected void method_5749(class_2487 nbt) {
        super.method_5749(nbt);
        this.readBlocktopiaBoatFromNbt(nbt);

        if (!this.hasValidBlocktopiaBoat()) {
            this.method_31472();
        }
    }

    @Override
    protected void method_5652(class_2487 nbt) {
        super.method_5652(nbt);
        this.writeBlocktopiaBoatToNbt(nbt);
    }
}
