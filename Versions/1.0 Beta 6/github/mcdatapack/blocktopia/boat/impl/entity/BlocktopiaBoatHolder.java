package github.mcdatapack.blocktopia.boat.impl.entity;

import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatTypeRegistry;
import net.minecraft.class_1690;
import net.minecraft.class_2487;
import net.minecraft.class_2960;

public interface BlocktopiaBoatHolder {
    static final String BOAT_KEY = "BlocktopiaBoat";

    BlocktopiaBoatType getBlocktopiaBoat();

    void setBlocktopiaBoat(BlocktopiaBoatType boat);

    default boolean hasValidBlocktopiaBoat() {
        return this.getBlocktopiaBoat() != null;
    }

    default void readBlocktopiaBoatFromNbt(class_2487 nbt) {
        class_2960 id = class_2960.method_12829(nbt.method_10558(BOAT_KEY));
        if (id != null) {
            BlocktopiaBoatType boat = BlocktopiaBoatTypeRegistry.INSTANCE.method_10223(id);
            if (boat != null) {
                this.setBlocktopiaBoat(boat);
            }
        }
    }

    default void writeBlocktopiaBoatToNbt(class_2487 nbt) {
        class_2960 boatId = BlocktopiaBoatTypeRegistry.INSTANCE.method_10221(this.getBlocktopiaBoat());
        if (boatId != null) {
            nbt.method_10582(BOAT_KEY, boatId.toString());
        }
    }

    default class_1690.class_1692 getImpersonatedBoatType() {
        return this.getBlocktopiaBoat().isRaft() ? class_1690.class_1692.field_40161 : class_1690.class_1692.field_7727;
    }
}
