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
        TagKey<Block> LEGACY_COBBLESTONE = block("legacy_cobblestone");

        TagKey<Block> PALE_OAK_LOGS = block("pale_oak_logs");

        TagKey<Block> CHAIRS = block("chairs");

        TagKey<Block> OAK_CHAIRS = block("chairs/oak");
        TagKey<Block> BIRCH_CHAIRS = block("chairs/birch");
        TagKey<Block> SPRUCE_CHAIRS = block("chairs/spruce");
        TagKey<Block> JUNGLE_CHAIRS = block("chairs/jungle");
        TagKey<Block> ACACIA_CHAIRS = block("chairs/acacia");
        TagKey<Block> DARK_OAK_CHAIRS = block("chairs/dark_oak");
        TagKey<Block> CRIMSON_CHAIRS = block("chairs/crimson");
        TagKey<Block> WARPED_CHAIRS = block("chairs/warped");
        TagKey<Block> MANGROVE_CHAIRS = block("chairs/mangrove");
        TagKey<Block> BAMBOO_CHAIRS = block("chairs/bamboo");
        TagKey<Block> CHERRY_CHAIRS = block("chairs/cherry");
        TagKey<Block> PALM_CHAIRS = block("chairs/palm");
        TagKey<Block> BANANA_CHAIRS = block("chairs/banana");
        TagKey<Block> CORN_CHAIRS = block("chairs/corn");
        TagKey<Block> POISONED_CHAIRS = block("chairs/poisoned");
        TagKey<Block> MAHOGANY_CHAIRS = block("chairs/mahogany");
        TagKey<Block> PALE_OAK_CHAIRS = block("chairs/pale_oak");

        TagKey<Block> CLASSIC_SPONGE_REPLACEABLE = block("classic_sponge_replaceable");

        TagKey<Block> COCOA_BEANS_PLACEABLE = block("cocoa_beans_placeable");
    }

    interface Items {
        TagKey<Item> LEGACY_BLOCKS = item("legacy_blocks");
        TagKey<Item> PALM_LOGS = item("palm_logs");
        TagKey<Item> BANANA_LOGS = item("banana_logs");
        TagKey<Item> CORN_LOGS = item("corn_logs");
        TagKey<Item> POISONED_LOGS = item("poisoned_logs");
        TagKey<Item> MAHOGANY_LOGS = item("mahogany_logs");
        TagKey<Item> LEGACY_COBBLESTONE = item("legacy_cobblestone");

        TagKey<Item> PALE_OAK_LOGS = item("pale_oak_logs");

        TagKey<Item> CHAIRS = item("chairs");

        TagKey<Item> OAK_CHAIRS = item("chairs/oak");
        TagKey<Item> BIRCH_CHAIRS = item("chairs/birch");
        TagKey<Item> SPRUCE_CHAIRS = item("chairs/spruce");
        TagKey<Item> JUNGLE_CHAIRS = item("chairs/jungle");
        TagKey<Item> ACACIA_CHAIRS = item("chairs/acacia");
        TagKey<Item> DARK_OAK_CHAIRS = item("chairs/dark_oak");
        TagKey<Item> CRIMSON_CHAIRS = item("chairs/crimson");
        TagKey<Item> WARPED_CHAIRS = item("chairs/warped");
        TagKey<Item> MANGROVE_CHAIRS = item("chairs/mangrove");
        TagKey<Item> BAMBOO_CHAIRS = item("chairs/bamboo");
        TagKey<Item> CHERRY_CHAIRS = item("chairs/cherry");
        TagKey<Item> PALM_CHAIRS = item("chairs/palm");
        TagKey<Item> BANANA_CHAIRS = item("chairs/banana");
        TagKey<Item> CORN_CHAIRS = item("chairs/corn");
        TagKey<Item> POISONED_CHAIRS = item("chairs/poisoned");
        TagKey<Item> MAHOGANY_CHAIRS = item("chairs/mahogany");
        TagKey<Item> PALE_OAK_CHAIRS = item("chairs/pale_oak");

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
