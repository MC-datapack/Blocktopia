package github.mcdatapack.blocktopia.boat.api;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_5321;

public class BlocktopiaBoatTypeRegistry {
    private static final class_2960 REGISTRY_ID = class_2960.method_60655("blocktopia", "boat");
    private static final class_5321<class_2378<BlocktopiaBoatType>> REGISTRY_KEY = class_5321.method_29180(REGISTRY_ID);

    public static final class_2378<BlocktopiaBoatType> INSTANCE = FabricRegistryBuilder.createSimple(REGISTRY_KEY).buildAndRegister();

    public static class_5321<BlocktopiaBoatType> createKey(class_2960 id) {
        return class_5321.method_29179(REGISTRY_KEY, id);
    }
}
