package github.mcdatapack.blocktopia.block.custom;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.block.entity.custom.XPTrapBlockEntity;
import github.mcdatapack.blocktopia.statuseffect.ModStatusEffects;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class XPTrapBlock extends BlockWithEntity {
    public static final MapCodec<XPTrapBlock> CODEC = createCodec(XPTrapBlock::new);
    public static final BooleanProperty ENABLED = Properties.ENABLED;

    public XPTrapBlock(AbstractBlock.Settings settings) {
        super(settings.nonOpaque());
        this.setDefaultState(this.stateManager.getDefaultState().with(ENABLED, false));
    }

    @Override
    public MapCodec<XPTrapBlock> getCodec() {
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
            PlayerEntity entity = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, true);
            if (entity != null) {
                entity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.XP_REMOVER, 10 * 20));
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

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new XPTrapBlockEntity(pos, state);
    }

    @Override
    protected boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        if (world.getBlockEntity(pos) instanceof XPTrapBlockEntity blockEntity) {
            return blockEntity.getCopiedBlockState().isTransparent(world, pos);
        } else {
            return false;
        }
    }

    @Override
    public ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Block blockInHand = Block.getBlockFromItem(stack.getItem());
        BlockState stateInHand = Optional.ofNullable(blockInHand.getPlacementState(new ItemPlacementContext(player, hand, player.getStackInHand(hand), hit)))
                .orElse(blockInHand.getDefaultState());

        if (stateInHand.isFullCube(world, pos) &&
                (stateInHand.getRenderType() != BlockRenderType.INVISIBLE || stateInHand.isOf(ModBlocks.XP_TRAP))) {
            if (world.getBlockEntity(pos) instanceof XPTrapBlockEntity blockEntity) {
                blockEntity.setCopiedBlockState(stateInHand);
                world.setBlockState(pos, state);
            }
            return ItemActionResult.SUCCESS;
        }

        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
