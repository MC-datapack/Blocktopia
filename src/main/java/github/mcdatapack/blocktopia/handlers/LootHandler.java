package github.mcdatapack.blocktopia.handlers;

import github.mcdatapack.blocktopia.block.LegacyBlocks;
import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.item.LegacyItems;
import github.mcdatapack.blocktopia.item.ModItems;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.loottable.ModLootTables;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
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
                        new LootTableItem(ModItems.COCONUT, UniformLootNumberProvider.create(2, 4)),
                        new LootTableItem(ModBlocks.PALM_SAPLING, UniformLootNumberProvider.create(6, 8), 0.6F));
                addItemsToLootTable(builder, EntityType.WITCH.getLootTableId(), lootTable,
                        new LootTableItem(ModItems.MONKEY_SPAWN_EGG, ConstantLootNumberProvider.create(1), 0.01F));
                addItemsToLootTable(builder, LootTables.END_CITY_TREASURE_CHEST, lootTable,
                        new LootTableItem(ModBlocks.FIREWORK_BLOCK, UniformLootNumberProvider.create(1, 5), 0.75F));
                addItemsToLootTable(builder, LootTables.VILLAGE_WEAPONSMITH_CHEST, lootTable,
                        new LootTableItem(LegacyItems.RUBY, UniformLootNumberProvider.create(1, 4), 0.75F));
                addItemsToLootTable(builder, LootTables.SHIPWRECK_TREASURE_CHEST, lootTable,
                        new LootTableItem(LegacyItems.RUBY, UniformLootNumberProvider.create(2, 5), 0.95F));
                addItemsToLootTable(builder, LootTables.BURIED_TREASURE_CHEST, lootTable,
                        new LootTableItem(LegacyItems.RUBY, UniformLootNumberProvider.create(1, 4), 0.85F));
                addItemsToLootTable(builder, LootTables.BASTION_TREASURE_CHEST, lootTable,
                        new LootTableItem(LegacyItems.RUBY, UniformLootNumberProvider.create(3, 7), 0.9F));
                addItemsToLootTable(builder, LootTables.END_CITY_TREASURE_CHEST, lootTable,
                        new LootTableItem(LegacyItems.RUBY, UniformLootNumberProvider.create(2, 9), 0.8F));
                addItemsToLootTable(builder, LootTables.ANCIENT_CITY_CHEST, lootTable,
                        new LootTableItem(LegacyBlocks.RUBY_ORE, UniformLootNumberProvider.create(2, 4)));
            });
        }
        LootTableEvents.MODIFY.register((lootTable, builder, lootTableSource, wrapperLookup) -> {
            addItemsToLootTable(builder, ModLootTables.FLOWERING_CHERRY_TREE_HOUSE, lootTable,
                    new LootTableItem(LegacyItems.RUBY, UniformLootNumberProvider.create(1, 3)),
                    new LootTableItem(Items.HONEY_BOTTLE, UniformLootNumberProvider.create(8, 14)));
        });
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
