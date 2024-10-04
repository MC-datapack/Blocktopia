package github.mcdatapack.blocktopia.boat.api;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class BlocktopiaBoatTypeRegistry {
    private static final Identifier REGISTRY_ID = Identifier.of("blocktopia", "boat");
    private static final RegistryKey<Registry<BlocktopiaBoatType>> REGISTRY_KEY = RegistryKey.ofRegistry(REGISTRY_ID);

    public static final Registry<BlocktopiaBoatType> INSTANCE = FabricRegistryBuilder.createSimple(REGISTRY_KEY).buildAndRegister();

    public static RegistryKey<BlocktopiaBoatType> createKey(Identifier id) {
        return RegistryKey.of(REGISTRY_KEY, id);
    }
}
