package github.mcdatapack.blocktopia.mixin;

import github.mcdatapack.blocktopia.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.block.FluidBlock.FLOW_DIRECTIONS;

@Mixin(value = FluidBlock.class, priority = 100)
public abstract class FluidBlockMixin {
    @Shadow @Final protected FlowableFluid fluid;

    @Shadow protected abstract void playExtinguishSound(WorldAccess world, BlockPos pos);

    @Inject(method = "receiveNeighborFluids", at = @At("HEAD"), cancellable = true)
    private void onReceiveNeighborFluids(World world, BlockPos pos, BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        if (fluid.isIn(FluidTags.LAVA)) {
            boolean soulSoilUnder = world.getBlockState(pos.down()).isOf(Blocks.SOUL_SOIL);

            for (Direction direction : FLOW_DIRECTIONS) {
                BlockPos neighborPos = pos.offset(direction.getOpposite());
                FluidState neighborFluid = world.getFluidState(neighborPos);

                if (neighborFluid.isIn(ModTags.Fluids.TROPICAL_WATER)) {
                    Block block = world.getFluidState(pos).isStill() ? Blocks.CRYING_OBSIDIAN : Blocks.COBBLED_DEEPSLATE;
                    world.setBlockState(pos, block.getDefaultState());
                    playExtinguishSound(world, pos);
                    cir.setReturnValue(false);
                    return;
                }

                if (neighborFluid.isIn(FluidTags.WATER)) {
                    Block block = world.getFluidState(pos).isStill() ? Blocks.OBSIDIAN : Blocks.COBBLESTONE;
                    world.setBlockState(pos, block.getDefaultState());
                    playExtinguishSound(world, pos);
                    cir.setReturnValue(false);
                    return;
                }

                if (soulSoilUnder && world.getBlockState(neighborPos).isOf(Blocks.BLUE_ICE)) {
                    world.setBlockState(pos, Blocks.BASALT.getDefaultState());
                    playExtinguishSound(world, pos);
                    cir.setReturnValue(false);
                    return;
                }
            }
        }
    }
}
