package github.mcdatapack.blocktopia.block.custom;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.block.entity.custom.LegacyCutterBlockEntity;
import github.mcdatapack.blocktopia.block.entity.ModBlockEntityTypes;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LegacyCutterBlock extends BlockWithEntity implements BlockEntityProvider {
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

    public LegacyCutterBlock(Settings settings) {
        super(settings);
    }

    public void tick(World world, BlockPos pos, BlockState state, LegacyCutterBlockEntity blockEntity) {
        blockEntity.tick(world, pos, state);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getBlockEntity(pos) instanceof LegacyCutterBlockEntity l) {
            tick(world, pos, state, l);
        }
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LegacyCutterBlockEntity(pos, state);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof LegacyCutterBlockEntity legcutent) {
                ItemScatterer.spawn(world, pos, legcutent.getItems());
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = ((LegacyCutterBlockEntity) world.getBlockEntity(pos));

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntityTypes.LEGACY_CUTTER, (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
