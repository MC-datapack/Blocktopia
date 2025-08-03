package github.mcdatapack.blocktopia.mixin.fluid;

import github.mcdatapack.blocktopia.util.ModTags;
import net.minecraft.block.*;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = LavaFluid.class, priority = 100)
public abstract class LavaFluidMixin extends FlowableFluid {
    @Shadow protected abstract void playExtinguishEvent(WorldAccess world, BlockPos pos);

    /**
     * @author Mc-datapack
     * @reason Tropical Water results in Deepslate
     */
    @Overwrite
    public void flow(WorldAccess world, BlockPos pos, BlockState state, Direction direction, FluidState fluidState) {
        if (direction == Direction.DOWN) {
            FluidState fluidState2 = world.getFluidState(pos);
            if (this.isIn(FluidTags.LAVA)) {
                if (fluidState2.isIn(ModTags.Fluids.TROPICAL_WATER)) {
                    if (state.getBlock() instanceof FluidBlock) {
                        world.setBlockState(pos, Blocks.DEEPSLATE.getDefaultState(), Block.NOTIFY_ALL);
                    }
                    playExtinguishEvent(world, pos);
                }
                if (fluidState2.isIn(FluidTags.WATER)) {
                    if (state.getBlock() instanceof FluidBlock) {
                        world.setBlockState(pos, Blocks.STONE.getDefaultState(), Block.NOTIFY_ALL);
                    }
                    playExtinguishEvent(world, pos);
                }

                return;
            }
        }

        if (state.getBlock() instanceof FluidFillable) {
            ((FluidFillable)state.getBlock()).tryFillWithFluid(world, pos, state, fluidState);
        } else {
            if (!state.isAir()) {
                this.beforeBreakingBlock(world, pos, state);
            }

            world.setBlockState(pos, fluidState.getBlockState(), Block.NOTIFY_ALL);
        }
    }
}
