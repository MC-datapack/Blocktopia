package github.mcdatapack.blocktopia.tree.decorator;

import com.mojang.serialization.MapCodec;

import github.mcdatapack.blocktopia.init.worldgen.TreeDecoratorTypeInit;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class LeavesTreeDecorator extends TreeDecorator {
    public static final MapCodec<LeavesTreeDecorator> CODEC = BlockState.CODEC .fieldOf("blockstate") .xmap(LeavesTreeDecorator::new, treeDecorator -> treeDecorator.blockState);

    private final BlockState blockState;

    public LeavesTreeDecorator(BlockState blockState) {
        this.blockState = blockState;
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return TreeDecoratorTypeInit.LEAVES_TREE_DECORATOR;
    }

    @Override
    public void generate(Generator generator) {
        Random random = generator.getRandom();
        generator.getLogPositions().forEach(pos -> {
            if (random.nextInt(3) > 0) {
                BlockPos blockPos = pos.west();
                if (generator.isAir(blockPos)) {
                    generator.replace(blockPos, this.blockState);
                }
            }

            if (random.nextInt(3) > 0) {
                BlockPos blockPos = pos.east();
                if (generator.isAir(blockPos)) {
                    generator.replace(blockPos, this.blockState);
                }
            }

            if (random.nextInt(3) > 0) {
                BlockPos blockPos = pos.north();
                if (generator.isAir(blockPos)) {
                    generator.replace(blockPos, this.blockState);
                }
            }

            if (random.nextInt(3) > 0) {
                BlockPos blockPos = pos.south();
                if (generator.isAir(blockPos)) {
                    generator.replace(pos, this.blockState);
                }
            }
        });
    }
}
