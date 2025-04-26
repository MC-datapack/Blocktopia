package github.mcdatapack.blocktopia.worldgen.spawn;

import github.mcdatapack.blocktopia.entity.ModEntityTypes;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.Heightmap;

public interface ModSpawnRestrictions {
    static void load() {
        SpawnRestriction.register(ModEntityTypes.MONKEY, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING, (type, world, spawnReason, pos, random) -> true);
        SpawnRestriction.register(ModEntityTypes.TOUCAN, SpawnLocationTypes.UNRESTRICTED,
                Heightmap.Type.MOTION_BLOCKING, (type, world, spawnReason, pos, random) -> true);
    }
}
