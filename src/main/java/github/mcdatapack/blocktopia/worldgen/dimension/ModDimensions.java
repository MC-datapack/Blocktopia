package github.mcdatapack.blocktopia.worldgen.dimension;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;

import java.util.OptionalLong;

public interface ModDimensions {
    RegistryKey<DimensionOptions> TROPICS_KEY = RegistryKey.of(RegistryKeys.DIMENSION, Blocktopia.id("tropics"));
    RegistryKey<World> TROPICS_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD, Blocktopia.id("tropics"));
    RegistryKey<DimensionType> TROPICS_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Blocktopia.id("tropics"));
    RegistryKey<ChunkGeneratorSettings> TROPICS_SETTINGS = RegistryKey.of(RegistryKeys.CHUNK_GENERATOR_SETTINGS, Blocktopia.id("tropics"));

    static void bootstrapDimensionType(Registerable<DimensionType> context) {
        context.register(TROPICS_TYPE, new DimensionType(
                OptionalLong.empty(),
                false,
                false,
                false,
                true,
                1.0,
                true,
                true,
                -64,
                1024 + 64,
                1024,
                BlockTags.INFINIBURN_OVERWORLD,
                DimensionTypes.OVERWORLD_ID,
                1,
                new DimensionType.MonsterSettings(true, true, UniformIntProvider.create(0, 5), 0)));
    }
}
