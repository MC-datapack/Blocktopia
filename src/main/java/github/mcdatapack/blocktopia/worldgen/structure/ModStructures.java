package github.mcdatapack.blocktopia.worldgen.structure;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.util.ModTags;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.StructureTerrainAdaptation;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.heightprovider.ConstantHeightProvider;
import net.minecraft.world.gen.structure.JigsawStructure;
import net.minecraft.world.gen.structure.Structure;

public interface ModStructures {
    RegistryKey<Structure> TREE_HOUSE_KEY = RegistryKey.of(RegistryKeys.STRUCTURE, Blocktopia.id("tree_house"));

    static void bootstrap(Registerable<Structure> structureRegisterable) {
        RegistryEntryLookup<Biome> biomeLookup = structureRegisterable.getRegistryLookup(RegistryKeys.BIOME);
        RegistryEntryLookup<StructurePool> structurePoolLookup = structureRegisterable.getRegistryLookup(RegistryKeys.TEMPLATE_POOL);
        structureRegisterable.register(
                TREE_HOUSE_KEY,
                new JigsawStructure(
                        new Structure.Config.Builder(biomeLookup.getOrThrow(ModTags.Biomes.HAS_TREE_HOUSES))
                                .terrainAdaptation(StructureTerrainAdaptation.BEARD_THIN)
                                .build(),
                        structurePoolLookup.getOrThrow(ModStructurePools.TREE_HOUSE),
                        8,
                        ConstantHeightProvider.create(YOffset.fixed(0)),
                        true,
                        Heightmap.Type.WORLD_SURFACE_WG
        ));
    }

    static void load() {}
}
