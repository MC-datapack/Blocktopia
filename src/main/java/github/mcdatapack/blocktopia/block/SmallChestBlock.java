package github.mcdatapack.blocktopia.block;

import github.mcdatapack.blocktopia.block.entity.SmallChestBlockEntity;
import github.mcdatapack.blocktopia.init.BlockEntityTypeInit;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class SmallChestBlock extends Block implements BlockEntityProvider {
    public static VoxelShape DefaultShape() {
        return VoxelShapes.union(
                VoxelShapes.cuboid(0.125, 0.0625, 0.125, 0.875, 0.5625, 0.1875),
                VoxelShapes.cuboid(0.125, 0.5625, 0.125, 0.875, 0.75, 0.875),
                VoxelShapes.cuboid(0.4375, 0.5, 0.0625, 0.5625, 0.6875, 0.125),
                VoxelShapes.cuboid(0.125, 0.0625, 0.8125, 0.875, 0.5625, 0.875),
                VoxelShapes.cuboid(0.125, 0.0625, 0.1875, 0.1875, 0.5625, 0.8125),
                VoxelShapes.cuboid(0.8125, 0.0625, 0.1875, 0.875, 0.5625, 0.8125),
                VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 0.0625, 0.875)
        ).simplify();
    }
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final Map<Direction, VoxelShape> Shapes = new HashMap<>();

    public SmallChestBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
        for (Direction direction : Direction.values()) {
            Shapes.put(direction, calculateShapes(direction, DefaultShape()));
        }
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return Shapes.get(state.get(FACING));
    }


    private static VoxelShape calculateShapes(Direction to, VoxelShape shape) {
        final VoxelShape[] buffer = {shape, VoxelShapes.empty()};

        final int times = (to.getHorizontal() - Direction.NORTH.getHorizontal() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) ->
                    buffer[1] = VoxelShapes.union(buffer[1],
                            VoxelShapes.cuboid(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = VoxelShapes.empty();
        }

        return buffer[0];
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            if (world.getBlockEntity(pos) instanceof SmallChestBlockEntity smallChestBlockEntity) {
                player.openHandledScreen(smallChestBlockEntity);
            }
        }

        return ActionResult.success(world.isClient);
    }

    @Override
    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityTypeInit.SMALL_CHEST_BLOCK_ENTITY.instantiate(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }
}
