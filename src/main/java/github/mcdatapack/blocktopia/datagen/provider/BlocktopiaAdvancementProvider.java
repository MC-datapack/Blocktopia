package github.mcdatapack.blocktopia.datagen.provider;

import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.datagen.custom.BlocktopiaAdvancementGenerator;
import github.mcdatapack.blocktopia.worldgen.biome.ModBiomes;
import github.mcdatapack.blocktopia.worldgen.dimension.ModDimensions;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.advancement.*;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static github.mcdatapack.blocktopia.Blocktopia.id;

public class BlocktopiaAdvancementProvider extends BlocktopiaAdvancementGenerator {
    public BlocktopiaAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> exporter) {
        create(ModBlocks.SMALL_CHEST, "root",
                Optional.of(id("textures/block/cobblestone_rd20090515.png")), Optional.empty(), false, false, false)
                .criterion("download", tick())
                .build(exporter, id("root"));

        generateAdventureAdvancements(registryLookup, exporter);
        generateLegacyAdvancements(registryLookup, exporter);
    }

    private void generateAdventureAdvancements(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> exporter) {
        create(ModBlocks.BANANA_LOG, "rainforest",
                Optional.empty(), Optional.empty())
                .criterion("biome", conditionsFromBiome(ModBiomes.RAIN_FOREST_KEY))
                .parent(id("root"))
                .build(exporter, id("rainforest"));
        create(ModBlocks.MAHOGANY_LOG, "all logs", Optional.empty(), Optional.empty())
                .criterion(hasItem(ModBlocks.BANANA_LOG), conditionsFromItem(ModBlocks.BANANA_LOG))
                .criterion(hasItem(ModBlocks.MAHOGANY_LOG), conditionsFromItem(ModBlocks.MAHOGANY_LOG))
                .criterion(hasItem(ModBlocks.CORN_LOG), conditionsFromItem(ModBlocks.CORN_LOG))
                .criterion(hasItem(ModBlocks.POISONED_LOG), conditionsFromItem(ModBlocks.POISONED_LOG))
                .criterion(hasItem(ModBlocks.PALM_LOG), conditionsFromItem(ModBlocks.PALM_LOG))
                .parent(id("rainforest"))
                .build(exporter, id("all_logs"));
        create(ModBlocks.SANDY_DIRT, "palm_island",
                Optional.empty(), Optional.empty())
                .criterion("biome", conditionsFromBiome(ModBiomes.PALM_ISLAND_KEY))
                .parent(id("rainforest"))
                .build(exporter, id("palm_island"));
        create(Blocks.JUNGLE_LOG, "tropics",
                Optional.empty(), Optional.empty())
                .criterion("dimension", conditionsFromDimension(ModDimensions.TROPICS_LEVEL_KEY))
                .parent(id("palm_island"))
                .build(exporter, id("tropics"));
    }
    
    private void generateLegacyAdvancements(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> exporter) {

    }
}
