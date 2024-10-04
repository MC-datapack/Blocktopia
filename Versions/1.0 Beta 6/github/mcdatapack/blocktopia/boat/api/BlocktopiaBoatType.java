package github.mcdatapack.blocktopia.boat.api;

import github.mcdatapack.blocktopia.boat.impl.BlocktopiaBoatTypeImpl;
import net.minecraft.class_1792;

public interface BlocktopiaBoatType {
    boolean isRaft();
    class_1792 getItem();
    class_1792 getChestItem();
    class_1792 getPlanks();
    public static class Builder {
        private boolean raft;
        private class_1792 item;
        private class_1792 chestItem;
        private class_1792 planks;
        public BlocktopiaBoatType build() {
            return new BlocktopiaBoatTypeImpl(this.raft, this.item, this.chestItem, this.planks);
        }
        public Builder raft() {
            this.raft = true;
            return this;
        }
        public Builder item(class_1792 item) {
            this.item = item;
            return this;
        }
        public Builder chestItem(class_1792 chestItem) {
            this.chestItem = chestItem;
            return this;
        }
        public Builder planks(class_1792 planks) {
            this.planks = planks;
            return this;
        }
    }
}
