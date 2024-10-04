package github.mcdatapack.blocktopia.boat.api;

import github.mcdatapack.blocktopia.boat.impl.BlocktopiaBoatTypeImpl;
import net.minecraft.item.Item;

public interface BlocktopiaBoatType {
    boolean isRaft();
    Item getItem();
    Item getChestItem();
    Item getPlanks();
    public static class Builder {
        private boolean raft;
        private Item item;
        private Item chestItem;
        private Item planks;
        public BlocktopiaBoatType build() {
            return new BlocktopiaBoatTypeImpl(this.raft, this.item, this.chestItem, this.planks);
        }
        public Builder raft() {
            this.raft = true;
            return this;
        }
        public Builder item(Item item) {
            this.item = item;
            return this;
        }
        public Builder chestItem(Item chestItem) {
            this.chestItem = chestItem;
            return this;
        }
        public Builder planks(Item planks) {
            this.planks = planks;
            return this;
        }
    }
}
