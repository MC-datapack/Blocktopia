package github.mcdatapack.blocktopia.datagen.generator;

import java.util.concurrent.CompletableFuture;

import com.mojang.logging.LogUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

public class BlocktopiaWorldGenerator extends FabricDynamicRegistryProvider {
    public BlocktopiaWorldGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, FabricDynamicRegistryProvider.Entries entries) {
        entries.addAll(log(registries.getWrapperOrThrow(log(RegistryKeys.CONFIGURED_FEATURE))));
        entries.addAll(log(registries.getWrapperOrThrow(log(RegistryKeys.PLACED_FEATURE))));
        entries.addAll(log(registries.getWrapperOrThrow(log(RegistryKeys.BIOME))));
        entries.addAll(log(registries.getWrapperOrThrow(log(RegistryKeys.TEMPLATE_POOL))));
        entries.addAll(log(registries.getWrapperOrThrow(log(RegistryKeys.STRUCTURE))));
        entries.addAll(log(registries.getWrapperOrThrow(log(RegistryKeys.STRUCTURE_SET))));
        entries.addAll(log(registries.getWrapperOrThrow(log(RegistryKeys.DIMENSION_TYPE))));
        entries.addAll(log(registries.getWrapperOrThrow(log(RegistryKeys.PROCESSOR_LIST))));
        log("finished");
    }

    @Override
    public String getName() {
        return "Blocktopia - World Generator";
    }

    private <T> T log(T log) {
        LogUtils.getLogger().info(log.toString());
        return log;
    }
}
