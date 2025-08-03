package github.mcdatapack.blocktopia.api;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.registry.RegistryKey;

import java.util.HashMap;
import java.util.Map;

public class CustomPiglinTrading {
    public static final Map<ItemConvertible, RegistryKey<LootTable>> ITEMS_FOR_LOOT_TABLES = new HashMap<>();

    static {
        addBarteringItem(Items.GOLD_INGOT, LootTables.PIGLIN_BARTERING_GAMEPLAY);
    }

    public static void addBarteringItem(ItemConvertible item, RegistryKey<LootTable> lootTable) {
        ITEMS_FOR_LOOT_TABLES.put(item, lootTable);
    }
}
