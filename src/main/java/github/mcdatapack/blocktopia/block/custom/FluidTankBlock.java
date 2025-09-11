package github.mcdatapack.blocktopia.block.custom;

import github.mcdatapack.blocktopia.block.entity.ModBlockEntityTypes;
import github.mcdatapack.blocktopia.block.entity.custom.FluidTankBlockEntity;
import github.mcdatapack.blocktopia.util.TickableBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class FluidTankBlock extends Block implements BlockEntityProvider, Waterloggable {
    public static final EnumProperty<TankSegmentType> SEGMENT_TYPE = EnumProperty.of("segment_type", TankSegmentType.class);
    public static final EnumProperty<Direction.Axis> CONNECTION_AXIS = EnumProperty.of("connection_axis", Direction.Axis.class);
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public FluidTankBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;

        BlockEntity be = world.getBlockEntity(pos);
        if (!(be instanceof FluidTankBlockEntity clickedTank)) return ActionResult.PASS;

        FluidTankBlockEntity controller = clickedTank.getController();
        if (controller != null) {
            player.openHandledScreen(controller);
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }


    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            if (world.getBlockEntity(pos) instanceof FluidTankBlockEntity blockEntity) {
                ItemScatterer.spawn(world, pos, blockEntity.getInventory());
                world.updateComparators(pos, this);
            }
        }

        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntityTypes.FLUID_TANK.instantiate(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return TickableBlockEntity.getTicker(world);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction.Axis axis = state.get(CONNECTION_AXIS);
        TankSegmentType type = state.get(SEGMENT_TYPE);
        if (axis == Direction.Axis.X) {
            if (type == TankSegmentType.START)
                return VoxelShapes.cuboid(0.25, 0, 0.25, 1, 0.8125, 0.75);
            else if (type == TankSegmentType.END)
                return VoxelShapes.cuboid(0, 0, 0.25, 0.75, 0.8125, 0.75);
            else if (type== TankSegmentType.MIDDLE)
                return VoxelShapes.cuboid(0, 0, 0.25, 1, 0.8125, 0.75);
        } else if (axis == Direction.Axis.Z) {
            if (type == TankSegmentType.START)
                return VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 0.8125, 1);
            else if (type == TankSegmentType.END)
                return VoxelShapes.cuboid(0.25, 0, 0, 0.75, 0.8125, 0.75);
            else if (type== TankSegmentType.MIDDLE)
                return VoxelShapes.cuboid(0.25, 0, 0, 0.75, 0.8125, 1);
        }
        return VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 0.8125, 0.75);
    }


    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        if (direction.getAxis().isHorizontal()) {
            Direction.Axis currentAxis = state.get(CONNECTION_AXIS);

            Direction.Axis newAxis = currentAxis == Direction.Axis.Y
                    ? getConnectionAxis(world, pos)
                    : currentAxis;

            TankSegmentType newSegment = getSegmentType(world, pos, newAxis);

            return state.with(CONNECTION_AXIS, newAxis).with(SEGMENT_TYPE, newSegment);
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();

        BlockState north = world.getBlockState(pos.north());
        BlockState south = world.getBlockState(pos.south());
        BlockState east  = world.getBlockState(pos.east());
        BlockState west  = world.getBlockState(pos.west());

        boolean canConnectZ = (isTank(north) && isUnconnected(north)) || (isTank(south) && isUnconnected(south));
        boolean canConnectX = (isTank(east)  && isUnconnected(east))  || (isTank(west)  && isUnconnected(west));

        Direction.Axis axis;
        if (canConnectX && !canConnectZ) {
            axis = Direction.Axis.X;
        } else if (canConnectZ && !canConnectX) {
            axis = Direction.Axis.Z;
        } else {
            axis = Direction.Axis.Y;
        }

        TankSegmentType segment = getSegmentType(world, pos, axis);

        return getDefaultState()
                .with(WATERLOGGED, world.getFluidState(pos).getFluid() == Fluids.WATER)
                .with(CONNECTION_AXIS, axis)
                .with(SEGMENT_TYPE, segment);
    }

    private boolean isConnectable(BlockState state, Direction.Axis axis) {
        if (!isTank(state)) return false;
        if (!state.contains(CONNECTION_AXIS)) return false;

        Direction.Axis neighborAxis = state.get(CONNECTION_AXIS);
        return neighborAxis == Direction.Axis.Y || neighborAxis == axis;
    }

    private boolean isUnconnected(BlockState state) {
        return state.contains(CONNECTION_AXIS) && state.get(CONNECTION_AXIS) == Direction.Axis.Y;
    }

    private Direction.Axis getConnectionAxis(WorldAccess world, BlockPos pos) {
        BlockState north = world.getBlockState(pos.north());
        BlockState south = world.getBlockState(pos.south());
        BlockState east  = world.getBlockState(pos.east());
        BlockState west  = world.getBlockState(pos.west());

        boolean canConnectZ = isConnectable(north, Direction.Axis.Z) || isConnectable(south, Direction.Axis.Z);
        boolean canConnectX = isConnectable(east, Direction.Axis.X)  || isConnectable(west, Direction.Axis.X);

        if (canConnectX && !canConnectZ) return Direction.Axis.X;
        if (canConnectZ && !canConnectX) return Direction.Axis.Z;
        return Direction.Axis.Y;
    }

    private TankSegmentType getSegmentType(WorldAccess world, BlockPos pos, Direction.Axis axis) {
        Direction positive = Direction.from(axis, Direction.AxisDirection.POSITIVE);
        Direction negative = Direction.from(axis, Direction.AxisDirection.NEGATIVE);

        boolean posConnected = isConnectable(world.getBlockState(pos.offset(positive)), axis);
        boolean negConnected = isConnectable(world.getBlockState(pos.offset(negative)), axis);

        if (posConnected && negConnected) return TankSegmentType.MIDDLE;
        if (posConnected) return TankSegmentType.START;
        if (negConnected) return TankSegmentType.END;
        return TankSegmentType.SINGLE;
    }


    private boolean isTank(BlockState state) {
        return state.getBlock() instanceof FluidTankBlock;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, CONNECTION_AXIS, SEGMENT_TYPE);
    }

    public enum TankSegmentType implements StringIdentifiable {
        SINGLE("single"),
        START("start"),
        MIDDLE("middle"),
        END("end");

        private final String name;

        TankSegmentType(String name) {
            this.name = name;
        }

        @Override
        public String asString() {
            return name;
        }
    }
}
