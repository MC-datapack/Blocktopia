package github.mcdatapack.blocktopia.list;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class TagList {
    public TagList() {
    }

    public static class Blocks {
        public static final TagKey<Block> LEGACY_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Blocktopia.id("legacy_blocks"));
        public static final TagKey<Block> PALM_LOGS = TagKey.of(RegistryKeys.BLOCK, Blocktopia.id("palm_logs"));
        public static final TagKey<Block> GOLDEN_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Blocktopia.id("golden_blocks"));
        public static final TagKey<Block> IRON_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Blocktopia.id("iron_blocks"));
        public static final TagKey<Block> DIAMOND_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Blocktopia.id("diamond_blocks"));
        public static final TagKey<Block> LEGACY_COBBLESTONE = TagKey.of(RegistryKeys.BLOCK, Blocktopia.id("legacy_cobblestone"));
    }

    public static class Items {
        public static final TagKey<Item> LEGACY_BLOCKS = TagKey.of(RegistryKeys.ITEM, Blocktopia.id("legacy_blocks"));
        public static final TagKey<Item> PALM_LOGS = TagKey.of(RegistryKeys.ITEM, Blocktopia.id("palm_logs"));
        public static final TagKey<Item> GOLDEN_BLOCKS = TagKey.of(RegistryKeys.ITEM, Blocktopia.id("golden_blocks"));
        public static final TagKey<Item> IRON_BLOCKS = TagKey.of(RegistryKeys.ITEM, Blocktopia.id("iron_blocks"));
        public static final TagKey<Item> DIAMOND_BLOCKS = TagKey.of(RegistryKeys.ITEM, Blocktopia.id("diamond_blocks"));
        public static final TagKey<Item> LEGACY_COBBLESTONE = TagKey.of(RegistryKeys.ITEM, Blocktopia.id("legacy_cobblestone"));
    }
}
