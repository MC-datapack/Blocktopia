package github.mcdatapack.blocktopia.block.custom;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.util.ModTags;
import github.mcdatapack.more_tools_and_armor.list.TagList;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class HangingMossBlock extends Block implements Fertilizable {
    public static final MapCodec<HangingMossBlock> CODEC = createCodec(HangingMossBlock::new);
    private static final VoxelShape SHAPE = createColumnShape(14.0, 0.0, 16.0);
    private static final VoxelShape TIP_SHAPE = createColumnShape(14.0, 2.0, 16.0);
    public static final BooleanProperty TIP = BooleanProperty.of("tip");

    @Override
    public MapCodec<HangingMossBlock> getCodec() {
        return CODEC;
    }

    public HangingMossBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(TIP, true));
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(TIP) ? TIP_SHAPE : SHAPE;
    }

    @Override
    protected boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.offset(Direction.UP);
        BlockState blockState = world.getBlockState(blockPos);
        return canGrowOn(world, Direction.UP, blockPos, blockState) || blockState.isIn(ModTags.Blocks.HANGING_MOSS);
    }

    public static boolean canGrowOn(BlockView world, BlockPos pos, Direction direction) {
        BlockPos blockPos = pos.offset(direction);
        BlockState blockState = world.getBlockState(blockPos);
        return canGrowOn(world, direction, blockPos, blockState);
    }

    public static boolean canGrowOn(BlockView world, Direction direction, BlockPos pos, BlockState state) {
        return Block.isFaceFullSquare(state.getSidesShape(world, pos), direction.getOpposite())
                || Block.isFaceFullSquare(state.getCollisionShape(world, pos), direction.getOpposite());
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!canGrowOn(world, pos, Direction.UP)) {
            world.scheduleBlockTick(pos, this, 1);
        }


        return state.with(TIP, !world.getBlockState(pos.down()).isIn(ModTags.Blocks.HANGING_MOSS));
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!this.canPlaceAt(state, world, pos)) {
            world.breakBlock(pos, true);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TIP);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return this.canGrowInto(world.getBlockState(this.getTipPos(world, pos).down()));
    }

    private boolean canGrowInto(BlockState state) {
        return state.isAir();
    }

    public BlockPos getTipPos(BlockView world, BlockPos pos) {
        BlockPos.Mutable mutable = pos.mutableCopy();

        BlockState blockState;
        do {
            mutable.move(Direction.DOWN);
            blockState = world.getBlockState(mutable);
        } while (blockState.isOf(this));

        return mutable.offset(Direction.UP).toImmutable();
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockPos blockPos = this.getTipPos(world, pos).down();
        if (this.canGrowInto(world.getBlockState(blockPos))) {
            world.setBlockState(blockPos, state.with(TIP, true));
        }
    }

    public static VoxelShape createColumnShape(double sizeXz, double minY, double maxY) {
        return createColumnShape(sizeXz, sizeXz, minY, maxY);
    }

    public static VoxelShape createColumnShape(double sizeX, double sizeZ, double minY, double maxY) {
        double d = sizeX / 2.0;
        double e = sizeZ / 2.0;
        return createCuboidShape(8.0 - d, minY, 8.0 - e, 8.0 + d, maxY, 8.0 + e);
    }
}
