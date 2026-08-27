package github.mcdatapack.blocktopia.block.custom;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.enums.SlabType;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class VerticalSlabBlock extends Block implements Waterloggable {
    public static final MapCodec<VerticalSlabBlock> CODEC = createCodec(VerticalSlabBlock::new);
    public static final EnumProperty<VerticalSlabType> TYPE = EnumProperty.of("type", VerticalSlabType.class);
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final Map<Direction, VoxelShape> SHAPE = ImmutableMap.<Direction, VoxelShape>builder()
            .put(Direction.WEST, Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 16.0))
            .put(Direction.EAST, Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 16.0))
            .put(Direction.SOUTH, Block.createCuboidShape(0.0, 0.0, 8.0, 16.0, 16.0, 16.0))
            .put(Direction.NORTH, Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 8.0))
            .build();

    @Override
    public MapCodec<VerticalSlabBlock> getCodec() {
        return CODEC;
    }

    public VerticalSlabBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState()
                .with(TYPE, VerticalSlabType.SINGLE)
                .with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH));
    }

    @Override
    protected boolean hasSidedTransparency(BlockState state) {
        return state.get(TYPE) != VerticalSlabType.DOUBLE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TYPE, FACING, WATERLOGGED);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VerticalSlabType slabType = state.get(TYPE);
        return switch (slabType) {
            case DOUBLE -> VoxelShapes.fullCube();
            case SINGLE -> SHAPE.get(state.get(FACING));
        };
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        BlockState blockState = ctx.getWorld().getBlockState(blockPos);
        if (blockState.isOf(this)) {
            return blockState.with(TYPE, VerticalSlabType.DOUBLE).with(WATERLOGGED, false);
        } else {
            FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
            return this.getDefaultState()
                    .with(TYPE, VerticalSlabType.SINGLE)
                    .with(FACING, ctx.getHorizontalPlayerFacing())
                    .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        }
    }

    @Override
    protected boolean canReplace(BlockState state, ItemPlacementContext context) {
        ItemStack itemStack = context.getStack();
        VerticalSlabType slabType = state.get(TYPE);
        if (slabType == VerticalSlabType.DOUBLE || !itemStack.isOf(this.asItem())) {
            return false;
        } else if (context.canReplaceExisting()) {
            Direction direction = context.getSide();
            return direction == state.get(FACING).getOpposite();
        } else {
            return true;
        }
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        return state.get(TYPE) != VerticalSlabType.DOUBLE && Waterloggable.super.tryFillWithFluid(world, pos, state, fluidState);
    }

    @Override
    public boolean canFillWithFluid(@Nullable PlayerEntity player, BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
        return state.get(TYPE) != VerticalSlabType.DOUBLE && Waterloggable.super.canFillWithFluid(player, world, pos, state, fluid);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
    ) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        if (type == NavigationType.WATER) {
            return state.getFluidState().isIn(FluidTags.WATER);
        }
        return false;
    }

    public enum VerticalSlabType implements StringIdentifiable {
        SINGLE("single"),
        DOUBLE("double");

        public final String id;

        VerticalSlabType(String id) {
            this.id = id;
        }

        @Override
        public String asString() {
            return id;
        }
    }
}
