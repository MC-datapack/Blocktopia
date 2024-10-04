package github.mcdatapack.blocktopia.villager;

import com.google.common.collect.ImmutableSet;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3417;
import net.minecraft.class_3852;
import net.minecraft.class_4158;
import net.minecraft.class_5321;
import net.minecraft.class_7923;
import net.minecraft.class_7924;


public class CustomVillager {
    public static final class_5321<class_4158> LEGACY_KEY = poiKey("legacy");
    public static final class_4158 LEGACY_POI = registerPoi("legacy", LegacyBlocks.CRAFTING_TABLE_IN20100131);
    public static final class_3852 LEGACY_VILLAGER = registerProfession("legacy", LEGACY_KEY);

    public static class_3852 registerProfession(String name, class_5321<class_4158> type) {
        return class_2378.method_10230(class_7923.field_41195, class_2960.method_60654(Blocktopia.id(name).toString()),
                new class_3852(name, entry -> entry.method_40225(type), entry -> entry.method_40225(type),
                        ImmutableSet.of(), ImmutableSet.of(), class_3417.field_20680));
    }

    public static class_4158 registerPoi(String name, class_2248 block) {
        return PointOfInterestHelper.register(class_2960.method_60654(Blocktopia.id(name).toString()), 1, 1, block);
    }

    public static class_5321<class_4158> poiKey(String name) {
        return class_5321.method_29179(class_7924.field_41212, class_2960.method_60654(Blocktopia.id(name).toString()));
    }

    public static void load() {
    }
}
