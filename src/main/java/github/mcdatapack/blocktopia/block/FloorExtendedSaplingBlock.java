package github.mcdatapack.blocktopia.block;

import github.mcdatapack.blocktopia.list.TagList;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class FloorExtendedSaplingBlock extends SaplingBlock {
    public FloorExtendedSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return !floor.isIn(TagList.Blocks.FLOOR_EXTENDED_SAPLING_UNALLOWED_FLOOR);
    }
}
