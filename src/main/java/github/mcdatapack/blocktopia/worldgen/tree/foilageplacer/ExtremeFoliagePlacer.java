package github.mcdatapack.blocktopia.worldgen.tree.foilageplacer;

import com.mojang.datafixers.Products;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ExtremeFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<ExtremeFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            createCodec(instance).apply(instance, ExtremeFoliagePlacer::new));
    final int height;

    protected static <P extends ExtremeFoliagePlacer> Products.P3<RecordCodecBuilder.Mu<P>, IntProvider, IntProvider, Integer> createCodec(RecordCodecBuilder.Instance<P> builder) {
        return fillFoliagePlacerFields(builder).and(Codec.intRange(0, 16).fieldOf("height").forGetter(placer -> placer.height));
    }

    public ExtremeFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.EXTREME_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        for (int i = offset; i >= offset - foliageHeight; i--) {
            int j = Math.max(radius + treeNode.getFoliageRadius() - 1 - i / 2, 0);
            this.generateSquare(world, placer, random, config, treeNode.getCenter(), j, i, treeNode.isGiantTrunk());
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return dx == radius + 4 && dz == radius + 4 && (random.nextInt(3) == 0 || y == 0);
    }
}
