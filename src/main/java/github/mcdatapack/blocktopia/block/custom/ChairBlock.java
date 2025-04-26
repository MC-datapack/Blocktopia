package github.mcdatapack.blocktopia.block.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import github.mcdatapack.blocktopia.entity.custom.ChairEntity;
import github.mcdatapack.blocktopia.entity.ModEntityTypes;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChairBlock extends HorizontalFacingBlock {
    private static final MapCodec<ChairBlock> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(Block.CODEC.fieldOf("plank").forGetter(block -> block.plank),
                    Block.CODEC.fieldOf("seat").forGetter(block -> block.seat),
                    Settings.CODEC.fieldOf("settings").forGetter(ChairBlock::getSettings))
                    .apply(instance, ChairBlock::new));
    public final Block plank;
    public final Block seat;
    private static final VoxelShape SHAPE = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 16.0, 13.0);

    public ChairBlock(Block plank, Block seat, Settings settings) {
        super(settings);
        this.plank = plank;
        this.seat = seat;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient()) {
            Entity entity;
            List<ChairEntity> entities = world.getEntitiesByType(ModEntityTypes.CHAIR, new Box(pos), chair -> true);
            if(entities.isEmpty()) {
                entity = ModEntityTypes.CHAIR.spawn((ServerWorld) world, pos, SpawnReason.TRIGGERED);
            } else {
                entity = entities.getFirst();
            }

            player.startRiding(entity);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    public static class ChairBlocks {
        public static ChairBlock[] create(Block plank) {
            return new ChairBlock[]{
                    new ChairBlock(plank, plank, Settings.copy(plank)),
                    new ChairBlock(plank, Blocks.WHITE_WOOL, Settings.copy(plank)),
                    new ChairBlock(plank, Blocks.ORANGE_WOOL, Settings.copy(plank)),
                    new ChairBlock(plank, Blocks.MAGENTA_WOOL, Settings.copy(plank)),
                    new ChairBlock(plank, Blocks.LIGHT_BLUE_WOOL, Settings.copy(plank)),
                    new ChairBlock(plank, Blocks.YELLOW_WOOL, Settings.copy(plank)),
                    new ChairBlock(plank, Blocks.LIME_WOOL, Settings.copy(plank)),
                    new ChairBlock(plank, Blocks.PINK_WOOL, Settings.copy(plank)),
                    new ChairBlock(plank, Blocks.GRAY_WOOL, Settings.copy(plank)),
                    new ChairBlock(plank, Blocks.LIGHT_GRAY_WOOL, Settings.copy(plank)),
                    new ChairBlock(plank, Blocks.CYAN_WOOL, Settings.copy(plank)),
                    new ChairBlock(plank, Blocks.PURPLE_WOOL, Settings.copy(plank)),
                    new ChairBlock(plank, Blocks.BLUE_WOOL, Settings.copy(plank)),
                    new ChairBlock(plank, Blocks.BROWN_WOOL, Settings.copy(plank)),
                    new ChairBlock(plank, Blocks.GREEN_WOOL, Settings.copy(plank)),
                    new ChairBlock(plank, Blocks.RED_WOOL, Settings.copy(plank)),
                    new ChairBlock(plank, Blocks.BLACK_WOOL, Settings.copy(plank)),
            };
        }
    }
}
