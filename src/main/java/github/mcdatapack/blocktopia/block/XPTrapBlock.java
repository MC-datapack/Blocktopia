package github.mcdatapack.blocktopia.block;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.init.StatusEffectInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class XPTrapBlock extends Block {
    public static final MapCodec<RedstoneLampBlock> CODEC = createCodec(RedstoneLampBlock::new);
    public static final BooleanProperty ENABLED = Properties.ENABLED;

    public XPTrapBlock(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<RedstoneLampBlock> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(ENABLED, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient) {
            boolean bl = state.get(ENABLED);
            if (bl != world.isReceivingRedstonePower(pos)) {
                if (bl) {
                    world.scheduleBlockTick(pos, this, 4);
                } else {
                    world.setBlockState(pos, state.cycle(ENABLED), Block.NOTIFY_LISTENERS);
                }
            }
        }
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(ENABLED)) {
            PlayerEntity entity = world.getClosestPlayer(pos.getX(),pos.getY(), pos.getZ(), 10, true);
            if (entity != null) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffectInit.XP_REMOVER, 10 * 20));
            }
        }
        if (state.get(ENABLED) && !world.isReceivingRedstonePower(pos)) {
            world.setBlockState(pos, state.cycle(ENABLED), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ENABLED);
    }
}
