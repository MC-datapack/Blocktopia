package github.mcdatapack.blocktopia.boat.api.item;

import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import github.mcdatapack.blocktopia.boat.impl.item.BlocktopiaBoatDispenserBehavior;
import github.mcdatapack.blocktopia.boat.impl.item.BlocktopiaBoatItem;
import net.minecraft.class_1792;
import net.minecraft.class_1935;
import net.minecraft.class_2315;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_7923;

public final class BlocktopiaBoatItemHelper {
    public static class_1792 registerBoatItem(class_2960 id, class_5321<BlocktopiaBoatType> boatKey, boolean chest) {
        return registerBoatItem(id, boatKey, chest, new class_1792.class_1793().method_7889(1));
    }
    public static class_1792 registerBoatItem(class_2960 id, class_5321<BlocktopiaBoatType> boatKey, boolean chest, class_1792.class_1793 settings) {
        class_1792 item = new BlocktopiaBoatItem(boatKey, chest, settings);
        class_2378.method_10230(class_7923.field_41178, id, item);

        registerBoatDispenserBehavior(item, boatKey, chest);
        return item;
    }
    public static void registerBoatDispenserBehavior(class_1935 item, class_5321<BlocktopiaBoatType> boatKey, boolean chest) {
        class_2315.method_10009(item, new BlocktopiaBoatDispenserBehavior(boatKey, chest));
    }
}
