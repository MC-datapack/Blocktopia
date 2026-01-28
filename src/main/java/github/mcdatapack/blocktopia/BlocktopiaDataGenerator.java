package github.mcdatapack.blocktopia;

import github.mcdatapack.blocktopia.datagen.generator.*;
import github.mcdatapack.blocktopia.datagen.provider.*;
import github.mcdatapack.blocktopia.enchantment.ModEnchantments;
import github.mcdatapack.blocktopia.worldgen.biome.ModBiomes;
import github.mcdatapack.blocktopia.worldgen.dimension.ModDimensions;
import github.mcdatapack.blocktopia.worldgen.feature.*;
import github.mcdatapack.blocktopia.worldgen.structure.*;
import net.fabricmc.fabric.api.datagen.v1.*;

import net.minecraft.data.MetadataProvider;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

public class BlocktopiaDataGenerator implements DataGeneratorEntrypoint {
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        ModEnchantments.load();

        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(BlocktopiaLangProvider::new);
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
        pack.addProvider(EnchantmentGenerator::new);

        FabricDataGenerator.Pack thunderingSmitePack = fabricDataGenerator.createBuiltinResourcePack(Blocktopia.id("thundering_smite"));
        thunderingSmitePack.addProvider((FabricDataGenerator.Pack.Factory<MetadataProvider>)
                output -> MetadataProvider.create(output, Text.translatable("datapack.thundering_smite.description")));
        thunderingSmitePack.addProvider(ThunderingSmiteGenerator::new);

        FabricDataGenerator.Pack silkSwingPack = fabricDataGenerator.createBuiltinResourcePack(Blocktopia.id("silk_swing"));
        silkSwingPack.addProvider((FabricDataGenerator.Pack.Factory<MetadataProvider>)
                output -> MetadataProvider.create(output, Text.translatable("datapack.silk_swing.description")));
        silkSwingPack.addProvider(SilkSwingGenerator::new);
        FabricDataGenerator.Pack bowLootingPack = fabricDataGenerator.createBuiltinResourcePack(Blocktopia.id("bow_looting"));
        bowLootingPack.addProvider((FabricDataGenerator.Pack.Factory<MetadataProvider>)
                output -> MetadataProvider.create(output, Text.literal("")));
        bowLootingPack.addProvider(BowLootingGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.STRUCTURE, ModStructures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.TEMPLATE_POOL, ModStructurePools::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.STRUCTURE_SET, ModStructureSets::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, ModDimensions::bootstrapDimensionType);
        registryBuilder.addRegistry(RegistryKeys.PROCESSOR_LIST, ModProcessorLists::bootstrap);
    }
}
