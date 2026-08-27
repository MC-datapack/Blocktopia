package github.mcdatapack.blocktopia.worldgen.tree.decorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;

import github.mcdatapack.blocktopia.block.custom.HangingMossBlock;
import github.mcdatapack.blocktopia.worldgen.feature.ModConfiguredFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;

public class HangingMossTreeDecorator extends TreeDecorator {
    public static final MapCodec<HangingMossTreeDecorator> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    BlockState.CODEC.fieldOf("state").forGetter(treeDecorator -> treeDecorator.state),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("leaves_probability").forGetter(treeDecorator -> treeDecorator.leavesProbability),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("trunk_probability").forGetter(treeDecorator -> treeDecorator.trunkProbability),
                            Codec.doubleRange(0.0, 1.0).fieldOf("stopChance").forGetter(treeDecorator -> treeDecorator.stopChance),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("groundProbability").forGetter(treeDecorator -> treeDecorator.groundProbability)
                    )
                    .apply(instance, HangingMossTreeDecorator::new)
    );
    private final BlockState state;
    private final float leavesProbability;
    private final float trunkProbability;
    private final float groundProbability;
    private final double stopChance;

    @Override
    protected TreeDecoratorType<?> getType() {
        return ModTreeDecoratorTypes.HANGING_MOSS_TREE_DECORATOR;
    }

    public HangingMossTreeDecorator(BlockState state, float leavesProbability, float trunkProbability, double stopChance, float groundProbability) {
        this.state = state;
        this.leavesProbability = leavesProbability;
        this.trunkProbability = trunkProbability;
        this.groundProbability = groundProbability;
        this.stopChance = stopChance;
    }

    public HangingMossTreeDecorator(BlockState state, float leavesProbability, float trunkProbability, double stopChance) {
        this(state, leavesProbability, trunkProbability, stopChance, 0);
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

    private void decorate(BlockPos pos, TreeDecorator.Generator generator) {
        while (generator.isAir(pos.down()) && !(generator.getRandom().nextFloat() < stopChance)) {
            generator.replace(pos, state.with(HangingMossBlock.TIP, false));
            pos = pos.down();
        }

        generator.replace(pos, state.with(HangingMossBlock.TIP, true));
    }
}
