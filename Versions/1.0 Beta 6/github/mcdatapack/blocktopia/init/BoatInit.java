package github.mcdatapack.blocktopia.init;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatTypeRegistry;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_5321;

public class BoatInit {
    public static final class_2960 PALM_BOAT_ID = Blocktopia.id("palm_boat");
    public static final class_2960 PALM_CHEST_BOAT_ID = Blocktopia.id("palm_chest_boat");
    public static final class_5321<BlocktopiaBoatType> PALM_BOAT_KEY = BlocktopiaBoatTypeRegistry.createKey(PALM_BOAT_ID);
    public static BlocktopiaBoatType PALM_TYPE;

    public static BlocktopiaBoatType register(class_5321<BlocktopiaBoatType> key, BlocktopiaBoatType type) {
        return class_2378.method_39197(BlocktopiaBoatTypeRegistry.INSTANCE, key, type);
    }

    public static void load() {
        PALM_TYPE = register(PALM_BOAT_KEY, new BlocktopiaBoatType.Builder().item(ItemInit.PALM_BOAT).chestItem(ItemInit.PALM_CHEST_BOAT)
                .planks(BlockInit.PALM_PLANKS.method_8389()).build());
    }
}
