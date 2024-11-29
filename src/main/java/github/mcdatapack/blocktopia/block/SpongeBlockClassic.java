package github.mcdatapack.blocktopia.block;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.list.TagList;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class SpongeBlockClassic extends Block {
    public static final MapCodec<SpongeBlock> CODEC = createCodec(SpongeBlock::new);
    public static final int ABSORB_RADIUS = 60;
    public static final int ABSORB_LIMIT = 640;
    private static final Direction[] DIRECTIONS = Direction.values();

    @Override
    public MapCodec<SpongeBlock> getCodec() {
        return CODEC;
    }

    public SpongeBlockClassic(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!oldState.isOf(state.getBlock())) {
            this.update(world, pos);
        }
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        this.update(world, pos);
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }

    protected void update(World world, BlockPos pos) {
        if (this.absorbWater(world, pos)) {
            world.playSound(null, pos, SoundEvents.BLOCK_SPONGE_ABSORB, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }

    private boolean absorbWater(World world, BlockPos pos) {
        return BlockPos.iterateRecursively(pos, ABSORB_RADIUS, ABSORB_LIMIT + 1, (currentPos, queuer) -> {
            for (Direction direction : DIRECTIONS) {
                queuer.accept(currentPos.offset(direction));
            }
        }, currentPos -> {
            if (currentPos.equals(pos)) {
                return true;
            } else {
                BlockState blockState = world.getBlockState(currentPos);
                FluidState fluidState = world.getFluidState(currentPos);
                if (!fluidState.isIn(TagList.Fluids.CLASSIC_SPONGE_ABSORB)) {
                    return false;
                } else {
                    if (blockState.getBlock() instanceof FluidDrainable fluidDrainable && !fluidDrainable.tryDrainFluid(null, world, currentPos, blockState).isEmpty()) {
                        return true;
                    }

                    if (blockState.getBlock() instanceof FluidBlock) {
                        world.setBlockState(currentPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
                    } else {
                        if (!blockState.isIn(TagList.Blocks.CLASSIC_SPONGE_REPLACEABLE)) {
                            return false;
                        }

                        BlockEntity blockEntity = blockState.hasBlockEntity() ? world.getBlockEntity(currentPos) : null;
                        dropStacks(blockState, world, currentPos, blockEntity);
                        world.setBlockState(currentPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
                    }
                    return true;
                }
            }
        }) > 1;
    }
}
