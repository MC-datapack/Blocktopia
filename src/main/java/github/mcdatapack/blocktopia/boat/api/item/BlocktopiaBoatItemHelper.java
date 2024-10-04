package github.mcdatapack.blocktopia.boat.api.item;

import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import github.mcdatapack.blocktopia.boat.impl.item.BlocktopiaBoatDispenserBehavior;
import github.mcdatapack.blocktopia.boat.impl.item.BlocktopiaBoatItem;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.BlockPlacementDispenserBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public final class BlocktopiaBoatItemHelper {
    public static Item registerBoatItem(Identifier id, RegistryKey<BlocktopiaBoatType> boatKey, boolean chest) {
        return registerBoatItem(id, boatKey, chest, new Item.Settings().maxCount(1));
    }
    public static Item registerBoatItem(Identifier id, RegistryKey<BlocktopiaBoatType> boatKey, boolean chest, Item.Settings settings) {
        Item item = new BlocktopiaBoatItem(boatKey, chest, settings);
        Registry.register(Registries.ITEM, id, item);

        registerBoatDispenserBehavior(item, boatKey, chest);
        return item;
    }
    public static void registerBoatDispenserBehavior(ItemConvertible item, RegistryKey<BlocktopiaBoatType> boatKey, boolean chest) {
        DispenserBlock.registerBehavior(item, new BlocktopiaBoatDispenserBehavior(boatKey, chest));
    }
}
