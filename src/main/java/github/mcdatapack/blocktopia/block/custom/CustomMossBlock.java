package github.mcdatapack.blocktopia.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.MossBlock;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class CustomMossBlock extends MossBlock {
    protected final RegistryKey<ConfiguredFeature<?, ?>> feature;

    public CustomMossBlock(RegistryKey<ConfiguredFeature<?, ?>> feature, Settings settings) {
        super(settings);
        this.feature = feature;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.getRegistryManager()
                .getOptional(RegistryKeys.CONFIGURED_FEATURE)
                .flatMap(key -> key.getEntry(feature))
                .ifPresent(entry -> entry.value().generate(world, world.getChunkManager().getChunkGenerator(), random, pos.up()));
    }
}
