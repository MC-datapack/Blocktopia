package github.mcdatapack.blocktopia.loottable;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public interface ModLootTables {
    RegistryKey<LootTable> BANANA_TREE_HOUSE= of("chests/banana_farmer");
    RegistryKey<LootTable> MAHOGANY_TREE_HOUSE = of("chests/mahogany_tree_house");
    RegistryKey<LootTable> CORN_TREE_HOUSE = of("chests/corn_tree_house");
    RegistryKey<LootTable> POISONED_TREE_HOUSE = of("chests/poisoned_tree_house");
    RegistryKey<LootTable> FLOWERING_CHERRY_TREE_HOUSE = of("chests/flowering_cherry_tree_house");
    RegistryKey<LootTable> LEGACY_VILLAGER_GIFT = of("gameplay/hero_of_the_village/legacy_gift");
    RegistryKey<LootTable> BEEKEEPER_VILLAGER_GIFT = of("gameplay/hero_of_the_village/beekeeper_gift");
    RegistryKey<LootTable> NETHERITE_PIGLIN_BARTERING = of("gameplay/netherite_piglin_bartering");
    RegistryKey<LootTable> NETHERITE_BLOCK_PIGLIN_BARTERING = of("gameplay/netherite_block_piglin_bartering");
    RegistryKey<LootTable> BEDROCK_C0_0_12A_PIGLIN_BARTERING = of("gameplay/bedrock_c0_0_12a_piglin_bartering");

    private static RegistryKey<LootTable> of(String path) {
        return RegistryKey.of(RegistryKeys.LOOT_TABLE, Blocktopia.id(path));
    }

    static void load() {}
}
