package github.mcdatapack.blocktopia.init;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class LootTableInit {
    public static final RegistryKey<LootTable> BANANA_TREE_HOUSE_CHEST = of("chests/banana_tree_house");
    public static final RegistryKey<LootTable> LEGACY_VILLAGER_GIFT_GAMEPLAY = of("gameplay/hero_of_the_village/legacy_gift");
    public static final RegistryKey<LootTable> BEEKEEPER_VILLAGER_GIFT_GAMEPLAY = of("gameplay/hero_of_the_village/beekeeper_gift");
    public static final RegistryKey<LootTable> NETHERITE_PIGLIN_BARTERING_GAMEPLAY = of("gameplay/netherite_piglin_bartering");
    public static final RegistryKey<LootTable> NETHERITE_BLOCK_PIGLIN_BARTERING_GAMEPLAY = of("gameplay/netherite_block_piglin_bartering");

    private static RegistryKey<LootTable> of(String path) {
        return RegistryKey.of(RegistryKeys.LOOT_TABLE, Blocktopia.id(path));
    }
}
