package github.mcdatapack.blocktopia.list;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;

public class TagList {
    public static class Blocks {
        public static final TagKey<Block> LEGACY_BLOCKS = block("legacy_blocks");
        public static final TagKey<Block> PALM_LOGS = block("palm_logs");
        public static final TagKey<Block> BANANA_LOGS = block("banana_logs");
        public static final TagKey<Block> CORN_LOGS = block("corn_logs");
        public static final TagKey<Block> POISONED_LOGS = block("corn_logs");
        public static final TagKey<Block> GOLDEN_BLOCKS = block("golden_blocks");
        public static final TagKey<Block> IRON_BLOCKS = block("iron_blocks");
        public static final TagKey<Block> DIAMOND_BLOCKS = block("diamond_blocks");
        public static final TagKey<Block> LEGACY_COBBLESTONE = block("legacy_cobblestone");
        public static final TagKey<Block> FLOOR_EXTENDED_SAPLING_UNALLOWED_FLOOR = block("floor_extended_sapling_unallowed_floor");

        public static final TagKey<Block> CHAIRS = block("chairs");

        public static final TagKey<Block> CLASSIC_SPONGE_REPLACEABLE = block("classic_sponge_replaceable");
    }

    public static class Items {
        public static final TagKey<Item> LEGACY_BLOCKS = item("legacy_blocks");
        public static final TagKey<Item> PALM_LOGS = item("palm_logs");
        public static final TagKey<Item> BANANA_LOGS = item("banana_logs");
        public static final TagKey<Item> CORN_LOGS = item("corn_logs");
        public static final TagKey<Item> POISONED_LOGS = item("poisoned_logs");
        public static final TagKey<Item> GOLDEN_BLOCKS = item("golden_blocks");
        public static final TagKey<Item> IRON_BLOCKS = item("iron_blocks");
        public static final TagKey<Item> DIAMOND_BLOCKS = item("diamond_blocks");
        public static final TagKey<Item> LEGACY_COBBLESTONE = item("legacy_cobblestone");

        public static final TagKey<Item> CHAIRS = item("chairs");

        public static final TagKey<Item> MONKEY_BREEDING_ITEMS = item("monkey_breeding_items");
    }

    public static class Fluids {
        public static final TagKey<Fluid> CLASSIC_SPONGE_ABSORB = fluid("clasic_sponge_absorb");
        public static final TagKey<Fluid> TROPICAL_WATER = fluid("tropical_water");
    }

    public static class Biomes {
        public static final TagKey<Biome> HAS_BANANA_TREE_HOUSE = biome("has_banana_tree_house");
    }






    private static TagKey<Block> block(String name) {
        return TagKey.of(RegistryKeys.BLOCK, Blocktopia.id(name));
    }

    private static TagKey<Item> item(String name) {
        return TagKey.of(RegistryKeys.ITEM, Blocktopia.id(name));
    }

    private static TagKey<Fluid> fluid(String name) {
        return TagKey.of(RegistryKeys.FLUID, Blocktopia.id(name));
    }

    private static TagKey<Biome> biome(String name) {
        return TagKey.of(RegistryKeys.BIOME, Blocktopia.id(name));
    }
}
