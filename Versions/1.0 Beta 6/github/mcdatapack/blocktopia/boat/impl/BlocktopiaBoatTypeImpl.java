package github.mcdatapack.blocktopia.boat.impl;

import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import net.minecraft.class_1792;

public class BlocktopiaBoatTypeImpl implements BlocktopiaBoatType {
    private final boolean raft;
    private final class_1792 item;
    private final class_1792 chestItem;
    private final class_1792 planks;

    public BlocktopiaBoatTypeImpl(boolean raft, class_1792 item, class_1792 chestItem, class_1792 planks) {
        this.raft = raft;
        this.item = item;
        this.chestItem = chestItem;
        this.planks = planks;
    }

    public boolean isRaft() {
        return this.raft;
    }

    public class_1792 getItem() {
        return this.item;
    }

    public class_1792 getChestItem() {
        return this.chestItem;
    }

    public class_1792 getPlanks() {
        return this.planks;
    }
}
