package github.mcdatapack.blocktopia.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class BlocktopiaConfig {
    public static BlocktopiaConfigData getConfig() {
        return AutoConfig.getConfigHolder(BlocktopiaConfigData.class).getConfig();
    }

    public static void saveConfig() {
        AutoConfig.getConfigHolder(BlocktopiaConfigData.class).save();
    }

    public static void register() {
        try {
            AutoConfig.register(BlocktopiaConfigData.class, JanksonConfigSerializer::new);
            ServerLifecycleEvents.START_DATA_PACK_RELOAD.register((s, m) -> AutoConfig.getConfigHolder(BlocktopiaConfigData.class).load());
        } catch (RuntimeException ignored) {}
    }
}
