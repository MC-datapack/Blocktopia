package github.mcdatapack.blocktopia.boat.impl;

import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import net.minecraft.item.Item;

public class BlocktopiaBoatTypeImpl implements BlocktopiaBoatType {
    private final boolean raft;
    private final Item item;
    private final Item chestItem;
    private final Item planks;

    public BlocktopiaBoatTypeImpl(boolean raft, Item item, Item chestItem, Item planks) {
        this.raft = raft;
        this.item = item;
        this.chestItem = chestItem;
        this.planks = planks;
    }

    public boolean isRaft() {
        return this.raft;
    }

    public Item getItem() {
        return this.item;
    }

    public Item getChestItem() {
        return this.chestItem;
    }

    public Item getPlanks() {
        return this.planks;
    }
}
