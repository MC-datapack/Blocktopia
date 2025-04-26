package github.mcdatapack.blocktopia.worldgen.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.structure.processor.StructureProcessorList;

public interface ModStructurePools {
    RegistryKey<StructurePool> BANANA_TREE_HOUSE_POOL = StructurePools.of("blocktopia:banana_tree_house");
    RegistryKey<StructurePool> MAHOGANY_TREE_HOUSE_POOL = StructurePools.of("blocktopia:mahogany_tree_house");
    RegistryKey<StructurePool> FLOWERING_CHERRY_TREE_HOUSE_POOL = StructurePools.of("blocktopia:flowering_cherry_tree_house");
    RegistryKey<StructurePool> CORN_TREE_HOUSE_POOL = StructurePools.of("blocktopia:corn_tree_house");
    RegistryKey<StructurePool> POISONED_TREE_HOUSE_POOL = StructurePools.of("blocktopia:poisoned_tree_house");

    static void bootstrap(Registerable<StructurePool> poolRegisterable) {
        RegistryEntryLookup<StructurePool> registryEntryLookup2 = poolRegisterable.getRegistryLookup(RegistryKeys.TEMPLATE_POOL);
        RegistryEntryLookup<StructureProcessorList> structureProcessorListRegistryEntryLookup = poolRegisterable.getRegistryLookup(RegistryKeys.PROCESSOR_LIST);
        RegistryEntry<StructurePool> emptyFallback = registryEntryLookup2.getOrThrow(StructurePools.EMPTY);
        poolRegisterable.register(
                BANANA_TREE_HOUSE_POOL, new StructurePool(
                        emptyFallback, ImmutableList.of(Pair.of(StructurePoolElement.ofProcessedLegacySingle("blocktopia:banana_tree_house",
                        structureProcessorListRegistryEntryLookup.getOrThrow(ModProcessorLists.RANDOM_CHAIR)), 1)),
                        StructurePool.Projection.RIGID)
        );

        poolRegisterable.register(
                MAHOGANY_TREE_HOUSE_POOL, new StructurePool(
                        emptyFallback, ImmutableList.of(Pair.of(StructurePoolElement.ofProcessedLegacySingle("blocktopia:mahogany_tree_house",
                        structureProcessorListRegistryEntryLookup.getOrThrow(ModProcessorLists.RANDOM_CHAIR)), 1)),
                        StructurePool.Projection.RIGID)
        );

        poolRegisterable.register(
                FLOWERING_CHERRY_TREE_HOUSE_POOL, new StructurePool(
                        emptyFallback, ImmutableList.of(Pair.of(StructurePoolElement.ofProcessedLegacySingle("blocktopia:flowering_cherry_tree_house",
                        structureProcessorListRegistryEntryLookup.getOrThrow(ModProcessorLists.RANDOM_CHAIR)), 1)),
                        StructurePool.Projection.RIGID)
        );

        poolRegisterable.register(
                CORN_TREE_HOUSE_POOL, new StructurePool(
                        emptyFallback, ImmutableList.of(Pair.of(StructurePoolElement.ofProcessedLegacySingle("blocktopia:corn_tree_house",
                        structureProcessorListRegistryEntryLookup.getOrThrow(ModProcessorLists.RANDOM_CHAIR)), 1)),
                        StructurePool.Projection.RIGID)
        );

        poolRegisterable.register(
                POISONED_TREE_HOUSE_POOL, new StructurePool(
                        emptyFallback, ImmutableList.of(Pair.of(StructurePoolElement.ofProcessedLegacySingle("blocktopia:poisoned_tree_house",
                        structureProcessorListRegistryEntryLookup.getOrThrow(ModProcessorLists.RANDOM_CHAIR)), 1)),
                        StructurePool.Projection.RIGID)
        );
    }

    static void load() {}
}
