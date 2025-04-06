package github.mcdatapack.blocktopia;

import github.mcdatapack.blocktopia.datagen.generator.*;
import github.mcdatapack.blocktopia.datagen.provider.*;
import github.mcdatapack.blocktopia.init.worldgen.*;
import github.mcdatapack.blocktopia.init.worldgen.structure.StructureInit;
import github.mcdatapack.blocktopia.init.worldgen.structure.StructurePoolInit;
import github.mcdatapack.blocktopia.init.worldgen.structure.StructureSetInit;
import net.fabricmc.fabric.api.datagen.v1.*;

import net.minecraft.data.MetadataProvider;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.text.Text;
import net.minecraft.world.gen.feature.ConfiguredFeature;

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
        //pack.addProvider(BlocktopiaAdvancementProvider::new);
        pack.addProvider(BlocktopiaWorldGenerator::new);

        FabricDataGenerator.Pack thunderingSmitePack = fabricDataGenerator.createBuiltinResourcePack(Blocktopia.id("thundering_smite"));
        thunderingSmitePack.addProvider((FabricDataGenerator.Pack.Factory<MetadataProvider>)
                outputx -> MetadataProvider.create(outputx, Text.translatable("dataPack.thundering_smite.description")));
        thunderingSmitePack.addProvider(ThunderingSmiteGenerator::new);

        FabricDataGenerator.Pack silkSwingPack = fabricDataGenerator.createBuiltinResourcePack(Blocktopia.id("silk_swing"));
        silkSwingPack.addProvider((FabricDataGenerator.Pack.Factory<MetadataProvider>)
                outputx -> MetadataProvider.create(outputx, Text.translatable("dataPack.silk_swing.description")));
        silkSwingPack.addProvider(SilkSwingGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeatureInit::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeatureInit::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.BIOME, BiomeInit::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.STRUCTURE, StructureInit::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.TEMPLATE_POOL, StructurePoolInit::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.STRUCTURE_SET, StructureSetInit::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, DimensionInit::bootstrapType);
    }
}
