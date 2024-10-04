package github.mcdatapack.blocktopia.boat.impl.entity;

import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatTypeRegistry;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

public interface BlocktopiaBoatHolder {
    static final String BOAT_KEY = "BlocktopiaBoat";

    BlocktopiaBoatType getBlocktopiaBoat();

    void setBlocktopiaBoat(BlocktopiaBoatType boat);

    default boolean hasValidBlocktopiaBoat() {
        return this.getBlocktopiaBoat() != null;
    }

    default void readBlocktopiaBoatFromNbt(NbtCompound nbt) {
        Identifier id = Identifier.tryParse(nbt.getString(BOAT_KEY));
        if (id != null) {
            BlocktopiaBoatType boat = BlocktopiaBoatTypeRegistry.INSTANCE.get(id);
            if (boat != null) {
                this.setBlocktopiaBoat(boat);
            }
        }
    }

    default void writeBlocktopiaBoatToNbt(NbtCompound nbt) {
        Identifier boatId = BlocktopiaBoatTypeRegistry.INSTANCE.getId(this.getBlocktopiaBoat());
        if (boatId != null) {
            nbt.putString(BOAT_KEY, boatId.toString());
        }
    }

    default BoatEntity.Type getImpersonatedBoatType() {
        return this.getBlocktopiaBoat().isRaft() ? BoatEntity.Type.BAMBOO : BoatEntity.Type.OAK;
    }
}
