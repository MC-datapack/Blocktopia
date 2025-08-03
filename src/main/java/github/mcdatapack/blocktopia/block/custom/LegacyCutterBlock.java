package github.mcdatapack.blocktopia.block.custom;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.screen.custom.screenhandler.LegacyCutterScreenHandler;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.text.Text;
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

public class LegacyCutterBlock extends Block {
    private static final VoxelShape SHAPE = VoxelShapes.union(
            VoxelShapes.cuboid(0, 0, 0, 1, 0.3125, 1),
            VoxelShapes.cuboid(0.0625, 0.3125, 0.0625, 0.9375, 0.375, 0.9375),
            VoxelShapes.cuboid(0.125, 0.375, 0.125, 0.875, 0.4375, 0.875),
            VoxelShapes.cuboid(0.1875, 0.4375, 0.1875, 0.3125, 0.6875, 0.8125),
            VoxelShapes.cuboid(0.6875, 0.4375, 0.1875, 0.8125, 0.6875, 0.8125),
            VoxelShapes.cuboid(0.6875, 0.4375, 0.3125, 0.8125, 0.6875, 0.6875),
            VoxelShapes.cuboid(0.6875, 0.4375, 0.1875, 0.8125, 0.6875, 0.8125)
    );
    public static final MapCodec<LegacyCutterBlock> CODEC = LegacyCutterBlock.createCodec(LegacyCutterBlock::new);
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final Text TITLE = Text.translatable("container.blocktopia.legacy_cutter");

    @Override
    public MapCodec<LegacyCutterBlock> getCodec() {
        return CODEC;
    }

    public LegacyCutterBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
            return ActionResult.CONSUME;
        }
    }

    @Nullable
    @Override
    protected NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory(
                (syncId, playerInventory, player) -> new LegacyCutterScreenHandler(syncId, playerInventory, ScreenHandlerContext.create(world, pos)), TITLE
        );
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected boolean hasSidedTransparency(BlockState state) {
        return true;
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
        builder.add(FACING);
    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }
}
