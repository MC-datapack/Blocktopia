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
    RegistryKey<StructureSet> BANANA_TREE_HOUSE = RegistryKey.of(RegistryKeys.STRUCTURE_SET, Blocktopia.id("banana_tree_house"));
    RegistryKey<StructureSet> MAHOGANY_TREE_HOUSE = RegistryKey.of(RegistryKeys.STRUCTURE_SET, Blocktopia.id("mahogany_tree_house"));
    RegistryKey<StructureSet> FLOWERING_CHERRY_TREE_HOUSE = RegistryKey.of(RegistryKeys.STRUCTURE_SET, Blocktopia.id("flowering_cherry_tree_house"));
    RegistryKey<StructureSet> CORN_TREE_HOUSE = RegistryKey.of(RegistryKeys.STRUCTURE_SET, Blocktopia.id("corn_tree_house"));
    RegistryKey<StructureSet> POISONED_TREE_HOUSE = RegistryKey.of(RegistryKeys.STRUCTURE_SET, Blocktopia.id("poisoned_tree_house"));

    static void bootstrap(Registerable<StructureSet> structureSetRegisterable) {
        RegistryEntryLookup<Structure> structureLookup = structureSetRegisterable.getRegistryLookup(RegistryKeys.STRUCTURE);
        RegistryEntryLookup<Biome> biomeLookup = structureSetRegisterable.getRegistryLookup(RegistryKeys.BIOME);

        structureSetRegisterable.register(
                BANANA_TREE_HOUSE,
                new StructureSet(structureLookup.getOrThrow(ModStructures.BANANA_TREE_HOUSE_KEY),
                        new RandomSpreadStructurePlacement(Vec3i.ZERO, StructurePlacement.FrequencyReductionMethod.DEFAULT, 1.0F,
                                14357700, Optional.empty(),12, 8, SpreadType.LINEAR))
        );
        structureSetRegisterable.register(
                MAHOGANY_TREE_HOUSE,
                new StructureSet(structureLookup.getOrThrow(ModStructures.MAHOGANY_TREE_HOUSE_KEY),
                        new RandomSpreadStructurePlacement(Vec3i.ZERO, StructurePlacement.FrequencyReductionMethod.DEFAULT, 1.0F,
                                14357700, Optional.empty(), 8, 4, SpreadType.LINEAR))
        );
        structureSetRegisterable.register(
                FLOWERING_CHERRY_TREE_HOUSE,
                new StructureSet(structureLookup.getOrThrow(ModStructures.FLOWERING_CHERRY_TREE_HOUSE_KEY),
                        new RandomSpreadStructurePlacement(Vec3i.ZERO, StructurePlacement.FrequencyReductionMethod.DEFAULT, 0.5F,
                                14357700, Optional.empty(), 14, 8, SpreadType.LINEAR))
        );
        structureSetRegisterable.register(
                CORN_TREE_HOUSE,
                new StructureSet(structureLookup.getOrThrow(ModStructures.CORN_TREE_HOUSE_KEY),
                        new RandomSpreadStructurePlacement(Vec3i.ZERO, StructurePlacement.FrequencyReductionMethod.DEFAULT, 0.25F,
                                14357700,  Optional.empty(), 24, 16, SpreadType.LINEAR))
        );
        structureSetRegisterable.register(
                POISONED_TREE_HOUSE,
                new StructureSet(structureLookup.getOrThrow(ModStructures.POISONED_TREE_HOUSE_KEY),
                        new RandomSpreadStructurePlacement(Vec3i.ZERO, StructurePlacement.FrequencyReductionMethod.DEFAULT, 0.44F,
                                14357700, Optional.empty(), 16, 12, SpreadType.LINEAR))
        );
    }

    static void load() {}
}
