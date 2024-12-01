package github.mcdatapack.blocktopia.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class ConfigurableRepeaterBlock extends AbstractRedstoneGateBlock {
    public static final MapCodec<ConfigurableRepeaterBlock> CODEC = createCodec(ConfigurableRepeaterBlock::new);
    public static final BooleanProperty LOCKED = Properties.LOCKED;
    public static final IntProperty DELAY = IntProperty.of("delay", 1, 256);

    @Override
    public MapCodec<ConfigurableRepeaterBlock> getCodec() {
        return CODEC;
    }

    public ConfigurableRepeaterBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(
                this.stateManager
                        .getDefaultState()
                        .with(FACING, Direction.NORTH)
                        .with(DELAY, 1)
                        .with(LOCKED, false)
                        .with(POWERED, false)
        );
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.PASS;
        } else {
            world.setBlockState(pos, state.cycle(DELAY), Block.NOTIFY_ALL);
            return ActionResult.success(world.isClient);
        }
    }

    @Override
    protected int getUpdateDelayInternal(BlockState state) {
        return state.get(DELAY);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = super.getPlacementState(ctx);
        return blockState.with(LOCKED, Boolean.valueOf(this.isLocked(ctx.getWorld(), ctx.getBlockPos(), blockState)));
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
    ) {
        if (direction == Direction.DOWN && !this.canPlaceAbove(world, neighborPos, neighborState)) {
            return Blocks.AIR.getDefaultState();
        } else {
            return !world.isClient() && direction.getAxis() != state.get(FACING).getAxis()
                    ? state.with(LOCKED, Boolean.valueOf(this.isLocked(world, pos, state)))
                    : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }
    }

    @Override
    public boolean isLocked(WorldView world, BlockPos pos, BlockState state) {
        return this.getMaxInputLevelSides(world, pos, state) > 0;
    }

    @Override
    protected boolean getSideInputFromGatesOnly() {
        return true;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(POWERED)) {
            Direction direction = state.get(FACING);
            double d = pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.2;
            double e = pos.getY() + 0.4 + (random.nextDouble() - 0.5) * 0.2;
            double f = pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.2;
            float g = -5.0F;
            if (random.nextBoolean()) {
                g = state.get(DELAY) * 2 - 1;
            }

            g /= 16.0F;
            double h = g * direction.getOffsetX();
            double i = g * direction.getOffsetZ();
            world.addParticle(DustParticleEffect.DEFAULT, d + h, e, f + i, 0.0, 0.0, 0.0);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, DELAY, LOCKED, POWERED);
    }
}
