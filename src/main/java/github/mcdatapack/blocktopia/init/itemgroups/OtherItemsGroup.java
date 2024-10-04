package github.mcdatapack.blocktopia.init.itemgroups;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class OtherItemsGroup {
    private static final Text OTHER_ITEMS_TITLE = Text.translatable("itemGroup.blocktopia.other_items");
    public static final ItemGroup OTHER_ITEMS_GROUP = register("other_items_group", FabricItemGroup.builder()
            .displayName(OTHER_ITEMS_TITLE)
            .icon(BlockInit.SMALL_CHEST.asItem()::getDefaultStack)
            .entries((displayContext, entries) -> {
                entries.add(BlockInit.SMALL_CHEST);
                entries.add(ItemInit.COCONUT);
                entries.add(ItemInit.GOLDEN_COCONUT);
                entries.add(ItemInit.ENCHANTED_GOLDEN_COCONUT);
                entries.add(ItemInit.ENCHANTED_GOLDEN_CARROT);
                entries.add(ItemInit.GOLDEN_POTATO);
                entries.add(ItemInit.ENCHANTED_GOLDEN_POTATO);
                entries.add(ItemInit.GOLDEN_BAKED_POTATO);
                entries.add(ItemInit.ENCHANTED_GOLDEN_BAKED_POTATO);
                entries.add(ItemInit.GIANT_SPAWN_EGG);
                entries.add(ItemInit.ILLUSIONER_SPAWN_EGG);
            }).build());


    public static <T extends ItemGroup> T register(String name, T itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, Blocktopia.id(name), itemGroup);
    }

    public static void load() {}
}
