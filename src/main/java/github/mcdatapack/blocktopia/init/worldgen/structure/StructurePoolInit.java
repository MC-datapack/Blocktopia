package github.mcdatapack.blocktopia.init.worldgen.structure;

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

public class StructurePoolInit {
    public static final RegistryKey<StructurePool> BANANA_TREE_HOUSE_POOL = StructurePools.of("blocktopia:banana_tree_house");

    public static void bootstrap(Registerable<StructurePool> poolRegisterable) {
        RegistryEntryLookup<StructurePool> registryEntryLookup2 = poolRegisterable.getRegistryLookup(RegistryKeys.TEMPLATE_POOL);
        RegistryEntry<StructurePool> registryEntry2 = registryEntryLookup2.getOrThrow(StructurePools.EMPTY);
        poolRegisterable.register(
                BANANA_TREE_HOUSE_POOL, new StructurePool(
                        registryEntry2, ImmutableList.of(Pair.of(StructurePoolElement.ofLegacySingle("blocktopia:banana_tree_house"), 1)), StructurePool.Projection.RIGID)
        );
    }
}
