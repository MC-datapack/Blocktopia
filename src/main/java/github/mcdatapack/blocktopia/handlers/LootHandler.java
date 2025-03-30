package github.mcdatapack.blocktopia.handlers;

import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;

public class LootHandler {
    public static void registerListeners() {
        if (BlocktopiaConfig.getConfig().enableLoot) {
            LootTableEvents.MODIFY.register((lootTable, builder, lootTableSource, wrapperLookup) -> {
                addItemsToLootTable(builder, LootTables.SHIPWRECK_SUPPLY_CHEST, lootTable,
                        new LootTableItem(ItemInit.COCONUT, UniformLootNumberProvider.create(2, 4)),
                        new LootTableItem(BlockInit.PALM_SAPLING, UniformLootNumberProvider.create(6, 8), 0.6F));
                addItemsToLootTable(builder, EntityType.WITCH.getLootTableId(), lootTable,
                        new LootTableItem(ItemInit.MONKEY_SPAWN_EGG, ConstantLootNumberProvider.create(1), 0.01F));
            });
        }
    }

    public static void addItemsToLootTable(LootTable.Builder builder, RegistryKey<LootTable> target, RegistryKey<LootTable> lottTable, LootTableItem... entries) {
        if (target.equals(lottTable)) {
            for (LootTableItem entry : entries) {
                addLootPool(builder, entry.item(), entry.count(), entry.chance());
            }
        }
    }

    public static void addLootPool(LootTable.Builder builder, ItemConvertible item, LootNumberProvider count, float chance) {
        builder.pool(LootPool.builder()
                .rolls(count)
                .with(ItemEntry.builder(item))
                .conditionally(RandomChanceLootCondition.builder(chance)));
    }

    public record LootTableItem(ItemConvertible item, LootNumberProvider count, float chance) {
        public LootTableItem(ItemConvertible item, float chance) {
            this(item, ConstantLootNumberProvider.create(1), chance);
        }
        public LootTableItem(ItemConvertible item, LootNumberProvider count) {
            this(item, count, 1.0F);
        }
    }
}
