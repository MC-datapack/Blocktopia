package github.mcdatapack.blocktopia.util;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;

public interface ModTags {
    interface Blocks {
        TagKey<Block> LEGACY_BLOCKS = block("legacy_blocks");
        TagKey<Block> PALM_LOGS = block("palm_logs");
        TagKey<Block> BANANA_LOGS = block("banana_logs");
        TagKey<Block> CORN_LOGS = block("corn_logs");
        TagKey<Block> POISONED_LOGS = block("poisoned_logs");
        TagKey<Block> MAHOGANY_LOGS = block("mahogany_logs");
        TagKey<Block> GOLDEN_BLOCKS = block("golden_blocks");
        TagKey<Block> IRON_BLOCKS = block("iron_blocks");
        TagKey<Block> DIAMOND_BLOCKS = block("diamond_blocks");
        TagKey<Block> LEGACY_COBBLESTONE = block("legacy_cobblestone");

        TagKey<Block> CHAIRS = block("chairs");

        TagKey<Block> CLASSIC_SPONGE_REPLACEABLE = block("classic_sponge_replaceable");
    }

    interface Items {
        TagKey<Item> LEGACY_BLOCKS = item("legacy_blocks");
        TagKey<Item> PALM_LOGS = item("palm_logs");
        TagKey<Item> BANANA_LOGS = item("banana_logs");
        TagKey<Item> CORN_LOGS = item("corn_logs");
        TagKey<Item> POISONED_LOGS = item("poisoned_logs");
        TagKey<Item> MAHOGANY_LOGS = item("mahogany_logs");
        TagKey<Item> GOLDEN_BLOCKS = item("golden_blocks");
        TagKey<Item> IRON_BLOCKS = item("iron_blocks");
        TagKey<Item> DIAMOND_BLOCKS = item("diamond_blocks");
        TagKey<Item> LEGACY_COBBLESTONE = item("legacy_cobblestone");

        TagKey<Item> CHAIRS = item("chairs");

        TagKey<Item> MONKEY_BREEDING_ITEMS = item("monkey_breeding_items");

        TagKey<Item> BOW_LOOTING_ENCHANTABLE = item("bow_looting_enchantable");
    }

    interface Fluids {
        TagKey<Fluid> CLASSIC_SPONGE_ABSORB = fluid("clasic_sponge_absorb");
        TagKey<Fluid> TROPICAL_WATER = fluid("tropical_water");
    }

    interface Biomes {
        TagKey<Biome> HAS_BANANA_TREE_HOUSE = biome("has_banana_tree_house");
        TagKey<Biome> HAS_MAHOGANY_TREE_HOUSE = biome("has_mahogany_tree_house");
        TagKey<Biome> HAS_FLOWERING_TREE_CHERRY_HOUSE = biome("has_flowering_cherry_tree_house");
        TagKey<Biome> HAS_CORN_TREE_HOUSE = biome("has_corn_tree_house");
        TagKey<Biome> HAS_POISONED_TREE_HOUSE = biome("has_poisoned_tree_house");
    }




    interface TrinketTags {
        TagKey<Item> RABBIT_SLOT = TagKey.of(RegistryKeys.ITEM, Blocktopia.idTrinkets("feet/rabbit"));
        TagKey<Item> FISH_SLOT = TagKey.of(RegistryKeys.ITEM, Blocktopia.idTrinkets("head/fish"));
        TagKey<Item> CAT_SLOT = TagKey.of(RegistryKeys.ITEM, Blocktopia.idTrinkets("feet/cat"));
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
