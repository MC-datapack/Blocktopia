package github.mcdatapack.blocktopia.list;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class TagList {
    public static class Blocks {
        public static final TagKey<Block> LEGACY_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Blocktopia.id("legacy_blocks"));
        public static final TagKey<Block> PALM_LOGS = TagKey.of(RegistryKeys.BLOCK, Blocktopia.id("palm_logs"));
        public static final TagKey<Block> BANANA_LOGS = TagKey.of(RegistryKeys.BLOCK, Blocktopia.id("banana_logs"));
        public static final TagKey<Block> GOLDEN_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Blocktopia.id("golden_blocks"));
        public static final TagKey<Block> IRON_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Blocktopia.id("iron_blocks"));
        public static final TagKey<Block> DIAMOND_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Blocktopia.id("diamond_blocks"));
        public static final TagKey<Block> LEGACY_COBBLESTONE = TagKey.of(RegistryKeys.BLOCK, Blocktopia.id("legacy_cobblestone"));
        public static final TagKey<Block> FLOOR_EXTENDED_SAPLING_UNALLOWED_FLOOR = TagKey.of(RegistryKeys.BLOCK, Blocktopia.id("floor_extended_sapling_unallowed_floor"));

        public static final TagKey<Block> CLASSIC_SPONGE_REPLACEABLE = TagKey.of(RegistryKeys.BLOCK, Blocktopia.id("classic_sponge_replaceable"));
    }

    public static class Items {
        public static final TagKey<Item> LEGACY_BLOCKS = TagKey.of(RegistryKeys.ITEM, Blocktopia.id("legacy_blocks"));
        public static final TagKey<Item> PALM_LOGS = TagKey.of(RegistryKeys.ITEM, Blocktopia.id("palm_logs"));
        public static final TagKey<Item> BANANA_LOGS = TagKey.of(RegistryKeys.ITEM, Blocktopia.id("banana_logs"));
        public static final TagKey<Item> GOLDEN_BLOCKS = TagKey.of(RegistryKeys.ITEM, Blocktopia.id("golden_blocks"));
        public static final TagKey<Item> IRON_BLOCKS = TagKey.of(RegistryKeys.ITEM, Blocktopia.id("iron_blocks"));
        public static final TagKey<Item> DIAMOND_BLOCKS = TagKey.of(RegistryKeys.ITEM, Blocktopia.id("diamond_blocks"));
        public static final TagKey<Item> LEGACY_COBBLESTONE = TagKey.of(RegistryKeys.ITEM, Blocktopia.id("legacy_cobblestone"));

        public static final TagKey<Item> MONKEY_BREEDING_ITEMS = TagKey.of(RegistryKeys.ITEM, Blocktopia.id("monkey_breeding_items"));
    }

    public static class Fluids {
        public static final TagKey<Fluid> CLASSIC_SPONGE_ABSORB = TagKey.of(RegistryKeys.FLUID, Blocktopia.id("clasic_sponge_absorb"));
    }
}
