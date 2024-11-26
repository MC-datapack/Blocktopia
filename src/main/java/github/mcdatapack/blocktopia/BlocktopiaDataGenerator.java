package github.mcdatapack.blocktopia;

import github.mcdatapack.blocktopia.datagen.generator.BlocktopiaWorldGenerator;
import github.mcdatapack.blocktopia.datagen.provider.*;
import github.mcdatapack.blocktopia.init.worldgen.*;
import net.fabricmc.fabric.api.datagen.v1.*;

import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class BlocktopiaDataGenerator implements DataGeneratorEntrypoint {

    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(BlocktopiaModelProvider::new);
        pack.addProvider(BlocktopiaBlockLootTableProvider::new);
        pack.addProvider(BlocktopiaTagProvider.BlocktopiaBlockTagProvider::new);
        pack.addProvider(BlocktopiaTagProvider.BlocktopiaItemTagProvider::new);
        pack.addProvider(BlocktopiaRecipeProvider::new);
        pack.addProvider(BlocktopiaWorldGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeatureInit::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeatureInit::bootstrap);
    }
}
