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
    RegistryKey<Structure> BANANA_TREE_HOUSE_KEY = RegistryKey.of(RegistryKeys.STRUCTURE, Blocktopia.id("banana_tree_house"));
    RegistryKey<Structure> MAHOGANY_TREE_HOUSE_KEY = RegistryKey.of(RegistryKeys.STRUCTURE, Blocktopia.id("mahogany_tree_house"));
    RegistryKey<Structure> FLOWERING_CHERRY_TREE_HOUSE_KEY = RegistryKey.of(RegistryKeys.STRUCTURE, Blocktopia.id("flowering_cherry_tree_house"));
    RegistryKey<Structure> CORN_TREE_HOUSE_KEY = RegistryKey.of(RegistryKeys.STRUCTURE, Blocktopia.id("corn_tree_house"));
    RegistryKey<Structure> POISONED_TREE_HOUSE_KEY = RegistryKey.of(RegistryKeys.STRUCTURE, Blocktopia.id("poisoned_tree_house"));

    static void bootstrap(Registerable<Structure> structureRegisterable) {
        RegistryEntryLookup<Biome> biomeLookup = structureRegisterable.getRegistryLookup(RegistryKeys.BIOME);
        RegistryEntryLookup<StructurePool> structurePoolLookup = structureRegisterable.getRegistryLookup(RegistryKeys.TEMPLATE_POOL);
        structureRegisterable.register(
                BANANA_TREE_HOUSE_KEY,
                new JigsawStructure(
                        new Structure.Config.Builder(biomeLookup.getOrThrow(ModTags.Biomes.HAS_BANANA_TREE_HOUSE))
                                .terrainAdaptation(StructureTerrainAdaptation.BEARD_THIN)
                                .build(),
                        structurePoolLookup.getOrThrow(ModStructurePools.BANANA_TREE_HOUSE_POOL),
                        8,
                        ConstantHeightProvider.create(YOffset.fixed(0)),
                        true,
                        Heightmap.Type.WORLD_SURFACE_WG
        ));
        structureRegisterable.register(
                MAHOGANY_TREE_HOUSE_KEY,
                new JigsawStructure(
                        new Structure.Config.Builder(biomeLookup.getOrThrow(ModTags.Biomes.HAS_MAHOGANY_TREE_HOUSE))
                                .terrainAdaptation(StructureTerrainAdaptation.BEARD_THIN)
                                .build(),
                        structurePoolLookup.getOrThrow(ModStructurePools.MAHOGANY_TREE_HOUSE_POOL),
                        8,
                        ConstantHeightProvider.create(YOffset.fixed(0)),
                        true,
                        Heightmap.Type.WORLD_SURFACE_WG
                ));
        structureRegisterable.register(
                FLOWERING_CHERRY_TREE_HOUSE_KEY,
                new JigsawStructure(
                        new Structure.Config.Builder(biomeLookup.getOrThrow(ModTags.Biomes.HAS_FLOWERING_TREE_CHERRY_HOUSE))
                                .terrainAdaptation(StructureTerrainAdaptation.BEARD_THIN)
                                .build(),
                        structurePoolLookup.getOrThrow(ModStructurePools.FLOWERING_CHERRY_TREE_HOUSE_POOL),
                        8,
                        ConstantHeightProvider.create(YOffset.fixed(0)),
                        true,
                        Heightmap.Type.WORLD_SURFACE_WG
                ));
        structureRegisterable.register(
                CORN_TREE_HOUSE_KEY,
                new JigsawStructure(
                        new Structure.Config.Builder(biomeLookup.getOrThrow(ModTags.Biomes.HAS_CORN_TREE_HOUSE))
                                .terrainAdaptation(StructureTerrainAdaptation.BEARD_THIN)
                                .build(),
                        structurePoolLookup.getOrThrow(ModStructurePools.CORN_TREE_HOUSE_POOL),
                        8,
                        ConstantHeightProvider.create(YOffset.fixed(0)),
                        true,
                        Heightmap.Type.WORLD_SURFACE_WG
                ));
        structureRegisterable.register(
                POISONED_TREE_HOUSE_KEY,
                new JigsawStructure(
                        new Structure.Config.Builder(biomeLookup.getOrThrow(ModTags.Biomes.HAS_POISONED_TREE_HOUSE))
                                .terrainAdaptation(StructureTerrainAdaptation.BEARD_THIN)
                                .build(),
                        structurePoolLookup.getOrThrow(ModStructurePools.POISONED_TREE_HOUSE_POOL),
                        8,
                        ConstantHeightProvider.create(YOffset.fixed(0)),
                        true,
                        Heightmap.Type.WORLD_SURFACE_WG
                ));
    }

    static void load() {}
}
