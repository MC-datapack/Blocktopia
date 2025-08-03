package github.mcdatapack.blocktopia.worldgen.tree.decorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;

import github.mcdatapack.blocktopia.block.FutureBlocks;
import github.mcdatapack.blocktopia.block.custom.HangingMossBlock;
import github.mcdatapack.blocktopia.worldgen.feature.ModConfiguredFeatures;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;

public class PaleMossTreeDecorator extends TreeDecorator {
    public static final MapCodec<PaleMossTreeDecorator> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                            Codec.floatRange(0.0F, 1.0F).fieldOf("leaves_probability").forGetter(treeDecorator -> treeDecorator.leavesProbability),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("trunk_probability").forGetter(treeDecorator -> treeDecorator.trunkProbability),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("ground_probability").forGetter(treeDecorator -> treeDecorator.groundProbability)
                    )
                    .apply(instance, PaleMossTreeDecorator::new)
    );
    private final float leavesProbability;
    private final float trunkProbability;
    private final float groundProbability;

    @Override
    protected TreeDecoratorType<?> getType() {
        return ModTreeDecoratorTypes.PALE_MOSS_TREE_DECORATOR;
    }

    public PaleMossTreeDecorator(float leavesProbability, float trunkProbability, float groundProbability) {
        this.leavesProbability = leavesProbability;
        this.trunkProbability = trunkProbability;
        this.groundProbability = groundProbability;
    }

    @Override
    public void generate(TreeDecorator.Generator generator) {
        Random random = generator.getRandom();
        StructureWorldAccess structureWorldAccess = (StructureWorldAccess)generator.getWorld();
        List<BlockPos> list = Util.copyShuffled(generator.getLogPositions(), random);
        if (!list.isEmpty()) {
            Mutable<BlockPos> mutable = new MutableObject<>((BlockPos)list.getFirst());
            list.forEach(pos -> {
                if (pos.getY() < mutable.getValue().getY()) {
                    mutable.setValue(pos);
                }
            });
            BlockPos blockPos = mutable.getValue();
            if (random.nextFloat() < this.groundProbability) {
                structureWorldAccess.getRegistryManager()
                        .getOptional(RegistryKeys.CONFIGURED_FEATURE)
                        .flatMap(key -> key.getEntry(ModConfiguredFeatures.PALE_MOSS_PATCH_KEY))
                        .ifPresent(
                                entry -> entry.value()
                                        .generate(structureWorldAccess, structureWorldAccess.toServerWorld().getChunkManager().getChunkGenerator(), random, blockPos.up())
                        );
            }

            generator.getLogPositions().forEach(pos -> {
                if (random.nextFloat() < this.trunkProbability) {
                    BlockPos blockPosx = pos.down();
                    if (generator.isAir(blockPosx)) {
                        decorate(blockPosx, generator);
                    }
                }
            });
            generator.getLeavesPositions().forEach(pos -> {
                if (random.nextFloat() < this.leavesProbability) {
                    BlockPos blockPosx = pos.down();
                    if (generator.isAir(blockPosx)) {
                        decorate(blockPosx, generator);
                    }
                }
            });
        }
    }

    private static void decorate(BlockPos pos, TreeDecorator.Generator generator) {
        while (generator.isAir(pos.down()) && !(generator.getRandom().nextFloat() < 0.5)) {
            generator.replace(pos, FutureBlocks.PALE_HANGING_MOSS.getDefaultState().with(HangingMossBlock.TIP, false));
            pos = pos.down();
        }

        generator.replace(pos, FutureBlocks.PALE_HANGING_MOSS.getDefaultState().with(HangingMossBlock.TIP, true));
    }
}
