package github.mcdatapack.blocktopia.block.custom;

import github.mcdatapack.blocktopia.worldgen.feature.ModConfiguredFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.MossBlock;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class TropicalMossBlock extends MossBlock {
    public TropicalMossBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.getRegistryManager()
                .getOptional(RegistryKeys.CONFIGURED_FEATURE)
                .flatMap(key -> key.getEntry(ModConfiguredFeatures.TROPICAL_MOSS_PATCH_BONEMEAL_KEY))
                .ifPresent(entry -> entry.value().generate(world, world.getChunkManager().getChunkGenerator(), random, pos.up()));
    }
}
