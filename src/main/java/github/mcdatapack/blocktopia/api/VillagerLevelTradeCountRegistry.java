package github.mcdatapack.blocktopia.api;

import net.minecraft.village.VillagerProfession;

import java.util.HashMap;
import java.util.Map;

public class VillagerLevelTradeCountRegistry {
    public static final Map<VillagerProfession, Integer> VILLAGER_LEVEL_TRADE_COUNT_MAP = new HashMap<>();

    public static void registerTradeCount(VillagerProfession profession, int count) {
        VILLAGER_LEVEL_TRADE_COUNT_MAP.put(profession, count);
    }
}
