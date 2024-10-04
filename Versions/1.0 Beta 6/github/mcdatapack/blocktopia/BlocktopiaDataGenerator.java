package github.mcdatapack.blocktopia;

import github.mcdatapack.blocktopia.datagen.generator.BlocktopiaWorldGenerator;
import github.mcdatapack.blocktopia.datagen.provider.BlocktopiaBlockLootTableProvider;
import github.mcdatapack.blocktopia.datagen.provider.BlocktopiaModelProvider;
import github.mcdatapack.blocktopia.datagen.provider.BlocktopiaRecipeProvider;
import github.mcdatapack.blocktopia.datagen.provider.BlocktopiaTagProvider;
import github.mcdatapack.blocktopia.init.worldgen.ConfiguredFeatureInit;
import github.mcdatapack.blocktopia.init.worldgen.PlacedFeatureInit;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.class_7877;
import net.minecraft.class_7924;

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
    public void buildRegistry(class_7877 registryBuilder) {
        registryBuilder.method_46777(class_7924.field_41239, ConfiguredFeatureInit::bootstrap);
        registryBuilder.method_46777(class_7924.field_41245, PlacedFeatureInit::bootstrap);
    }
}
