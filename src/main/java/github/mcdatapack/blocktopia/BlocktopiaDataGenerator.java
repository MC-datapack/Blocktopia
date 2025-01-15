package github.mcdatapack.blocktopia;

import github.mcdatapack.blocktopia.datagen.generator.BlocktopiaEnchantmentGenerator;
import github.mcdatapack.blocktopia.datagen.generator.BlocktopiaWorldGenerator;
import github.mcdatapack.blocktopia.datagen.provider.*;
import github.mcdatapack.blocktopia.init.worldgen.*;
import github.mcdatapack.blocktopia.init.worldgen.structure.StructureInit;
import github.mcdatapack.blocktopia.init.worldgen.structure.StructurePoolInit;
import github.mcdatapack.blocktopia.init.worldgen.structure.StructureSetInit;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import net.fabricmc.fabric.api.datagen.v1.*;

import net.minecraft.SharedConstants;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.MetadataProvider;
import net.minecraft.data.server.DynamicRegistriesProvider;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureManager;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class BlocktopiaDataGenerator implements DataGeneratorEntrypoint {
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(BlocktopiaModelProvider::new);
        pack.addProvider(BlocktopiaBlockLootTableProvider::new);
        pack.addProvider(BlocktopiaTagProvider.BlocktopiaBlockTagProvider::new);
        pack.addProvider(BlocktopiaTagProvider.BlocktopiaItemTagProvider::new);
        pack.addProvider(BlocktopiaTagProvider.BlocktopiaFluidTagProvider::new);
        pack.addProvider(BlocktopiaTagProvider.BlocktopiaBiomeTagProvider::new);
        pack.addProvider(BlocktopiaTagProvider.BlocktopiaPOITagProvider::new);
        pack.addProvider(BlocktopiaTagProvider.BlocktopiaEntityTagProvider::new);
        pack.addProvider(BlocktopiaRecipeProvider::new);
        pack.addProvider(BlocktopiaWorldGenerator::new);
        pack.addProvider(BlocktopiaEnchantmentGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeatureInit::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeatureInit::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.BIOME, BiomeInit::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.STRUCTURE, StructureInit::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.TEMPLATE_POOL, StructurePoolInit::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.STRUCTURE_SET, StructureSetInit::bootstrap);
    }
}
