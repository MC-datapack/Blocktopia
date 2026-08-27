package github.mcdatapack.blocktopia.worldgen.tree.trunkplacer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class ExtremeTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<ExtremeTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.intRange(0, 256).fieldOf("base_height").forGetter(placer -> placer.baseHeight),
                    Codec.intRange(0, 256).fieldOf("height_rand_a").forGetter(placer -> placer.firstRandomHeight),
                    Codec.intRange(0, 256).fieldOf("height_rand_b").forGetter(placer -> placer.secondRandomHeight),
                    Codec.BOOL.fieldOf("biggest").forGetter(placer -> placer.biggest)).apply(instance, ExtremeTrunkPlacer::new)
    );
    private BlockPos highestLogPos;
    private final boolean biggest;

    public ExtremeTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, boolean biggest) {
        super(baseHeight, heightRandA, heightRandB);
        this.biggest = biggest;
    }

    public ExtremeTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        this(baseHeight, heightRandA, heightRandB, false);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.EXTREME_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(
            TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config
    ) {
        List<FoliagePlacer.TreeNode> foliageNodes = new ArrayList<>();

        BlockPos blockPos = startPos.down();
        setToDirt(world, replacer, random, blockPos, config);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        highestLogPos = startPos;

        int size = biggest ? 9 : random.nextBetween(5, 9);
        int currentSize = size;
        int shrinkInterval = (height / 25) * Math.ceilDiv(size, 2);

        for (int y = 0; y < height; y++) {
            int startX = -currentSize / 2;
            int startZ = -currentSize / 2;

            for (int dx = startX; dx < startX + currentSize; dx++) {
                for (int dz = startZ; dz < startZ + currentSize; dz++) {
                    BlockPos logPos = startPos.add(dx, y, dz);
                    this.setLog(world, replacer, random, mutable, config, logPos);
                    if (logPos.getY() > highestLogPos.getY()) {
                        highestLogPos = logPos;
                    }
                }
            }

            // Shrink the trunk size at intervals
            if (y % shrinkInterval == 0 && currentSize > 4) {
                currentSize -= 1;
            }

            // Add random branches
            if (random.nextFloat() < 0.3F) {
                addThickBranch(world, replacer, random, mutable, config, startPos, y, currentSize, random, foliageNodes);
            }
        }
        foliageNodes.add(new FoliagePlacer.TreeNode(highestLogPos.up(), -9 + size, true));

        return ImmutableList.copyOf(foliageNodes);
    }

    private void addThickBranch(
            TestableWorld world,
            BiConsumer<BlockPos, BlockState> replacer,
            Random random,
            BlockPos.Mutable tmpPos,
            TreeFeatureConfig config,
            BlockPos startPos,
            int y,
            int trunkSize,
            Random rand,
            List<FoliagePlacer.TreeNode> foliageNodes
    ) {
        int branchLength = random.nextInt(4) + 4;
        int directionX = rand.nextBoolean() ? 1 : -1;
        int directionZ = rand.nextBoolean() ? 1 : -1;

        for (int i = 0; i < branchLength; i++) {
            int x = directionX * (trunkSize / 2 + i);
            int z = directionZ * (trunkSize / 2 + i);
            int yBranch = y + i / 2;

            BlockPos logPos = startPos.add(x, yBranch, z);
            this.setLog(world, replacer, random, tmpPos, config, logPos);
            if (logPos.getY() > highestLogPos.getY()) {
                highestLogPos = logPos;
            }

            for (int dx = -1; dx < 1; dx++) {
                for (int dz = -1; dz < 1; dz++) {
                    for (int dy = -1; dy < 1; dy++) {
                        this.setLog(world, replacer, random, tmpPos, config, logPos.add(dx, dy, dz));
                    }
                }
            }
        }
    }

    private void setLog(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos.Mutable tmpPos, TreeFeatureConfig config,
                        BlockPos pos) {
        tmpPos.set(pos);
        this.trySetState(world, replacer, random, tmpPos, config);
    }

    public BlockPos getHighestLogPos() {
        return highestLogPos;
    }
}
