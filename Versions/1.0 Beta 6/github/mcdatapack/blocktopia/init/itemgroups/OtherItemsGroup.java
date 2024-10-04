package github.mcdatapack.blocktopia.init.itemgroups;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.class_1761;
import net.minecraft.class_2378;
import net.minecraft.class_2561;
import net.minecraft.class_7923;

public class OtherItemsGroup {
    private static final class_2561 OTHER_ITEMS_TITLE = class_2561.method_43471("itemGroup.blocktopia.other_items");
    public static final class_1761 OTHER_ITEMS_GROUP = register("other_items_group", FabricItemGroup.builder()
            .method_47321(OTHER_ITEMS_TITLE)
            .method_47320(BlockInit.SMALL_CHEST.method_8389()::method_7854)
            .method_47317((displayContext, entries) -> {
                entries.method_45421(BlockInit.SMALL_CHEST);
                entries.method_45421(ItemInit.COCONUT);
                entries.method_45421(ItemInit.GOLDEN_COCONUT);
                entries.method_45421(ItemInit.ENCHANTED_GOLDEN_COCONUT);
                entries.method_45421(ItemInit.ENCHANTED_GOLDEN_CARROT);
                entries.method_45421(ItemInit.GOLDEN_POTATO);
                entries.method_45421(ItemInit.ENCHANTED_GOLDEN_POTATO);
                entries.method_45421(ItemInit.GOLDEN_BAKED_POTATO);
                entries.method_45421(ItemInit.ENCHANTED_GOLDEN_BAKED_POTATO);
                entries.method_45421(ItemInit.GIANT_SPAWN_EGG);
                entries.method_45421(ItemInit.ILLUSIONER_SPAWN_EGG);
            }).method_47324());


    public static <T extends class_1761> T register(String name, T itemGroup) {
        return class_2378.method_10230(class_7923.field_44687, Blocktopia.id(name), itemGroup);
    }

    public static void load() {}
}
