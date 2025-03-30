package github.mcdatapack.blocktopia.list;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class TrinketTags {
    public static final TagKey<Item> RABBIT_SLOT = TagKey.of(RegistryKeys.ITEM, Blocktopia.idTrinkets("feet/rabbit"));
    public static final TagKey<Item> FISH_SLOT = TagKey.of(RegistryKeys.ITEM, Blocktopia.idTrinkets("head/fish"));
    public static final TagKey<Item> CAT_SLOT = TagKey.of(RegistryKeys.ITEM, Blocktopia.idTrinkets("feet/cat"));
}
