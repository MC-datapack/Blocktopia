package github.mcdatapack.blocktopia.block.custom;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.block.entity.custom.DuperBlockEntity;
import github.mcdatapack.blocktopia.block.entity.ModBlockEntityTypes;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
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

public class DuperBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final MapCodec<DuperBlock> CODEC = createCodec(DuperBlock::new);
    public static final VoxelShape SHAPE = VoxelShapes.union(
            VoxelShapes.cuboid(0, 0, 0, 1, 0.3125, 1),
            VoxelShapes.cuboid(0.75, 0.5, 0, 1, 1, 0.25),
            VoxelShapes.cuboid(0.75, 0.5, 0.75, 1, 1, 1),
            VoxelShapes.cuboid(0, 0.5, 0, 0.25, 1, 0.25),
            VoxelShapes.cuboid(0, 0.5, 0.75, 0.25, 1, 1),
            VoxelShapes.cuboid(0.75, 0.875, 0.25, 1, 1, 0.75),
            VoxelShapes.cuboid(0, 0.875, 0.25, 0.25, 1, 0.75),
            VoxelShapes.cuboid(0.75, 0.3125, 0, 1, 0.5, 1),
            VoxelShapes.cuboid(0, 0.3125, 0, 0.25, 0.5, 1),
            VoxelShapes.cuboid(0.25, 0.3125, 0, 0.75, 0.5, 0.25),
            VoxelShapes.cuboid(0.25, 0.3125, 0.75, 0.75, 0.5, 1),
            VoxelShapes.cuboid(0.125, 0.875, 0.4375, 0.875, 1, 0.5625),
            VoxelShapes.cuboid(0.125, 0.875, 0.4375, 0.875, 1, 0.5625)
    );


    public DuperBlock(Settings settings) {
        super(settings);
    }

    public void tick(World world, BlockPos pos, BlockState state, DuperBlockEntity blockEntity) {
        blockEntity.tick(world, pos, state);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getBlockEntity(pos) instanceof DuperBlockEntity l) {
            tick(world, pos, state, l);
        }
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DuperBlockEntity(pos, state);
    }


    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof DuperBlockEntity duperBlockEntity) {
                ItemScatterer.spawn(world, pos, duperBlockEntity.getItems());
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = ((DuperBlockEntity) world.getBlockEntity(pos));

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntityTypes.DUPER, (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
