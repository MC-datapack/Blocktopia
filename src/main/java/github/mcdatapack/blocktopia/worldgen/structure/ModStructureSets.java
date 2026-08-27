package github.mcdatapack.blocktopia.worldgen.structure;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.StructureSet;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.gen.chunk.placement.SpreadType;
import net.minecraft.world.gen.chunk.placement.StructurePlacement;
import net.minecraft.world.gen.structure.Structure;

import java.util.Optional;

public interface ModStructureSets {
    RegistryKey<StructureSet> TREE_HOUSE = RegistryKey.of(RegistryKeys.STRUCTURE_SET, Blocktopia.id("tree_house"));

    static void bootstrap(Registerable<StructureSet> structureSetRegisterable) {
        RegistryEntryLookup<Structure> structureLookup = structureSetRegisterable.getRegistryLookup(RegistryKeys.STRUCTURE);
        RegistryEntryLookup<Biome> biomeLookup = structureSetRegisterable.getRegistryLookup(RegistryKeys.BIOME);

        structureSetRegisterable.register(
                TREE_HOUSE,
                new StructureSet(structureLookup.getOrThrow(ModStructures.TREE_HOUSE_KEY),
                        new RandomSpreadStructurePlacement(Vec3i.ZERO, StructurePlacement.FrequencyReductionMethod.DEFAULT, 1.0F,
                                14357700, Optional.empty(),12, 8, SpreadType.LINEAR))
        );
    }

    static void load() {}
}
