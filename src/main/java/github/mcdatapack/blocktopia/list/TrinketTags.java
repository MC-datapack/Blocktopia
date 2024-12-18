package github.mcdatapack.blocktopia.list;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class TrinketTags {
    public static TagKey<Item> RABBIT_SLOT = TagKey.of(RegistryKeys.ITEM, Blocktopia.idTrinket("feet/rabbit"));
    public static TagKey<Item> FISH_SLOT = TagKey.of(RegistryKeys.ITEM, Blocktopia.idTrinket("head/fish"));
}
