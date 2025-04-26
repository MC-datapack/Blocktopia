package github.mcdatapack.blocktopia.datagen.provider;

import com.google.common.collect.ImmutableMap;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.datagen.custom.BlocktopiaAdvancementGenerator;
import github.mcdatapack.blocktopia.worldgen.biome.ModBiomes;
import github.mcdatapack.blocktopia.worldgen.dimension.ModDimensions;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.*;
import net.minecraft.advancement.criterion.*;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
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

        generateTerrainAdvancements(registryLookup, exporter);
        generateLegacyAdvancements(registryLookup, exporter);
    }

    private void generateTerrainAdvancements(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> exporter) {
        create(ModBlocks.BANANA_LOG, "rainforest",
                Optional.empty(), Optional.empty())
                .criterion("biome", conditionsFromBiome(ModBiomes.RAIN_FOREST_KEY))
                .parent(id("root"))
                .build(exporter, id("rainforest"));
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



    private LocationPredicate.Builder biomeLocation(RegistryWrapper.WrapperLookup registryLookup, RegistryKey<Biome> biome) {
        return LocationPredicate.Builder.createBiome(registryLookup.getWrapperOrThrow(RegistryKeys.BIOME).getOrThrow(biome));
    }
}
