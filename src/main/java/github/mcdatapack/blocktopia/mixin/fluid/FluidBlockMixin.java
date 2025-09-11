package github.mcdatapack.blocktopia.mixin.fluid;

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

    @Shadow protected abstract boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction);

    @Inject(method = "receiveNeighborFluids", at = @At("HEAD"), cancellable = true)
    private void onReceiveNeighborFluids(World world, BlockPos pos, BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        if (fluid.isIn(FluidTags.LAVA)) {
            boolean basaltCondition = world.getBlockState(pos.down()).isOf(Blocks.SOUL_SOIL);
            boolean dioriteCondition = world.getBlockState(pos.down()).isOf(Blocks.QUARTZ_BLOCK);
            boolean graniteCondition = world.getBlockState(pos.down()).isOf(Blocks.RED_SANDSTONE);
            boolean andesiteCondition = world.getBlockState(pos.down()).isOf(Blocks.POLISHED_DIORITE);
            boolean tuffCondition = world.getBlockState(pos.down()).isOf(Blocks.POLISHED_ANDESITE);
            boolean blackstoneCondition = world.getBlockState(pos.down()).isOf(Blocks.NETHER_BRICKS);
            boolean netherrackCondition = world.getBlockState(pos.down()).isOf(Blocks.RED_NETHER_BRICKS);
            boolean endstoneCondition = world.getBlockState(pos.down()).isOf(Blocks.PURPUR_BLOCK);

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

                if (world.getBlockState(neighborPos).isOf(Blocks.BLUE_ICE)) {
                    if (basaltCondition) {
                        world.setBlockState(pos, Blocks.BASALT.getDefaultState());
                        playExtinguishSound(world, pos);
                        cir.setReturnValue(false);
                        return;
                    } else if (blackstoneCondition) {
                        world.setBlockState(pos, Blocks.BLACKSTONE.getDefaultState());
                        playExtinguishSound(world, pos);
                        cir.setReturnValue(false);
                        return;
                    } else if (netherrackCondition) {
                        world.setBlockState(pos, Blocks.NETHERRACK.getDefaultState());
                        playExtinguishSound(world, pos);
                        cir.setReturnValue(false);
                        return;
                    }
                } else if (world.getBlockState(neighborPos).isOf(Blocks.PACKED_ICE)) {
                    if (dioriteCondition) {
                        world.setBlockState(pos, Blocks.DIORITE.getDefaultState());
                        playExtinguishSound(world, pos);
                        cir.setReturnValue(false);
                        return;
                    } else if (graniteCondition) {
                        world.setBlockState(pos, Blocks.GRANITE.getDefaultState());
                        playExtinguishSound(world, pos);
                        cir.setReturnValue(false);
                        return;
                    } else if (andesiteCondition) {
                        world.setBlockState(pos, Blocks.ANDESITE.getDefaultState());
                        playExtinguishSound(world, pos);
                        cir.setReturnValue(false);
                        return;
                    } else if (tuffCondition) {
                        world.setBlockState(pos, Blocks.TUFF.getDefaultState());
                        playExtinguishSound(world, pos);
                        cir.setReturnValue(false);
                        return;
                    }
                } else if (world.getBlockState(neighborPos).isOf(Blocks.ICE)) {
                    if (endstoneCondition) {
                        world.setBlockState(pos, Blocks.END_STONE.getDefaultState());
                        playExtinguishSound(world, pos);
                        cir.setReturnValue(false);
                        return;
                    }
                }
            }
        }
    }
}
