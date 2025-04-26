package github.mcdatapack.blocktopia.block.custom;

import github.mcdatapack.blocktopia.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class BananaCropBlock extends CropBlock {
    public static final int MAX_AGE = 5;
    public static final IntProperty AGE = IntProperty.of("age", 0, MAX_AGE);
    private static final VoxelShape[] SHAPE_BY_AGE =
            new VoxelShape[]{
                    createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
                    createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
                    createCuboidShape(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),
                    createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
                    createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
                    createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0)};

    public BananaCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_BY_AGE[getAge(state)];
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModBlocks.BANANA_CROP;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return super.canPlantOnTop(floor, world, pos) || floor.isIn(BlockTags.LEAVES);
    }
}
