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
    RegistryKey<StructurePool> TREE_HOUSE = StructurePools.of("blocktopia:tree_house");

    static void bootstrap(Registerable<StructurePool> poolRegisterable) {
        RegistryEntryLookup<StructurePool> registryEntryLookup2 = poolRegisterable.getRegistryLookup(RegistryKeys.TEMPLATE_POOL);
        RegistryEntryLookup<StructureProcessorList> structureProcessorListRegistryEntryLookup = poolRegisterable.getRegistryLookup(RegistryKeys.PROCESSOR_LIST);
        RegistryEntry<StructurePool> emptyFallback = registryEntryLookup2.getOrThrow(StructurePools.EMPTY);
        RegistryEntry.Reference<StructureProcessorList> randomChair = structureProcessorListRegistryEntryLookup.getOrThrow(ModProcessorLists.RANDOM_CHAIR);
        RegistryEntry.Reference<StructureProcessorList> randomStone = structureProcessorListRegistryEntryLookup.getOrThrow(ModProcessorLists.RANDOM_STONE);
        RegistryEntry.Reference<StructureProcessorList> bananaProcessor = structureProcessorListRegistryEntryLookup.getOrThrow(ModProcessorLists.BANANA_PROCESSOR);
        RegistryEntry.Reference<StructureProcessorList> chairAnvilProcessor = structureProcessorListRegistryEntryLookup.getOrThrow(ModProcessorLists.CHAIR_ANVIL_PROCESSOR);
        poolRegisterable.register(
                TREE_HOUSE, new StructurePool(
                        emptyFallback, ImmutableList.of(
                                Pair.of(StructurePoolElement.ofProcessedLegacySingle("blocktopia:banana_tree_house", bananaProcessor), 50),
                                Pair.of(StructurePoolElement.ofProcessedLegacySingle("blocktopia:mahogany_tree_house", chairAnvilProcessor), 20),
                                Pair.of(StructurePoolElement.ofProcessedLegacySingle("blocktopia:flowering_cherry_tree_house", chairAnvilProcessor), 15),
                                Pair.of(StructurePoolElement.ofProcessedLegacySingle("blocktopia:corn_tree_house", randomChair), 5),
                                Pair.of(StructurePoolElement.ofProcessedLegacySingle("blocktopia:poisoned_tree_house", chairAnvilProcessor), 15)
                ), StructurePool.Projection.RIGID)
        );
    }

    static void load() {}
}
