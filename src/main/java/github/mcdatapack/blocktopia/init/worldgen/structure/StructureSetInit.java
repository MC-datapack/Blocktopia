package github.mcdatapack.blocktopia.init.worldgen.structure;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.StructureSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.gen.chunk.placement.SpreadType;
import net.minecraft.world.gen.structure.Structure;

public class StructureSetInit {
    public static final RegistryKey<StructureSet> BANANA_TREE_HOUSE = RegistryKey.of(RegistryKeys.STRUCTURE_SET, Blocktopia.id("banana_tree_house"));

    public static void bootstrap(Registerable<StructureSet> structureSetRegisterable) {
        RegistryEntryLookup<Structure> structureLookup = structureSetRegisterable.getRegistryLookup(RegistryKeys.STRUCTURE);
        RegistryEntryLookup<Biome> biomeLookup = structureSetRegisterable.getRegistryLookup(RegistryKeys.BIOME);

        structureSetRegisterable.register(
                BANANA_TREE_HOUSE,
                new StructureSet(structureLookup.getOrThrow(StructureInit.BANANA_TREE_HOUSE_KEY), new RandomSpreadStructurePlacement(8, 4, SpreadType.LINEAR, 14357700))
        );
    }
}
