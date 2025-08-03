package github.mcdatapack.blocktopia.block.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import github.mcdatapack.blocktopia.block.FutureBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class EyeblossomBlock extends FlowerBlock {
    public static final MapCodec<EyeblossomBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(Codec.BOOL.fieldOf("open").forGetter(block -> block.state.open), createSettingsCodec()).apply(instance, EyeblossomBlock::new)
    );
    private final EyeblossomBlock.EyeblossomState state;

    @Override
    public MapCodec<? extends EyeblossomBlock> getCodec() {
        return CODEC;
    }

    public EyeblossomBlock(EyeblossomBlock.EyeblossomState state, AbstractBlock.Settings settings) {
        super(state.stewEffect, state.effectLengthInSeconds, settings);
        this.state = state;
    }

    public EyeblossomBlock(boolean open, AbstractBlock.Settings settings) {
        super(EyeblossomBlock.EyeblossomState.of(open).stewEffect, EyeblossomBlock.EyeblossomState.of(open).effectLengthInSeconds, settings);
        this.state = EyeblossomBlock.EyeblossomState.of(open);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.updateStateAndNotifyOthers(state, world, pos, random);

        super.randomTick(state, world, pos, random);
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.updateStateAndNotifyOthers(state, world, pos, random);

        super.scheduledTick(state, world, pos, random);
    }

    private boolean updateStateAndNotifyOthers(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.getDimension().natural()) {
            return false;
        } else if (world.isNight() == this.state.open) {
            return false;
        } else {
            EyeblossomBlock.EyeblossomState eyeblossomState = this.state.getOpposite();
            world.setBlockState(pos, eyeblossomState.getBlockState(), Block.NOTIFY_ALL);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(state));
            BlockPos.iterate(pos.add(-3, -2, -3), pos.add(3, 2, 3)).forEach(otherPos -> {
                BlockState blockState2 = world.getBlockState(otherPos);
                if (blockState2 == state) {
                    double d = Math.sqrt(pos.getSquaredDistance(otherPos));
                    int i = random.nextBetween((int)(d * 5.0), (int)(d * 10.0));
                    world.scheduleBlockTick(otherPos, state.getBlock(), i);
                }
            });
            return true;
        }
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient()
                && world.getDifficulty() != Difficulty.PEACEFUL
                && entity instanceof BeeEntity beeEntity
                && state.isIn(BlockTags.FLOWERS)
                && !beeEntity.hasStatusEffect(StatusEffects.POISON)) {
            beeEntity.addStatusEffect(this.getContactEffect());
        }
    }


    public StatusEffectInstance getContactEffect() {
        return new StatusEffectInstance(StatusEffects.POISON, 25);
    }

    public static enum EyeblossomState {
        OPEN(true, StatusEffects.BLINDNESS, 11.0F),
        CLOSED(false, StatusEffects.NAUSEA, 7.0F);

        final boolean open;
        final RegistryEntry<StatusEffect> stewEffect;
        final float effectLengthInSeconds;

        EyeblossomState(
                final boolean open,
                final RegistryEntry<StatusEffect> stewEffect,
                final float effectLengthInSeconds
        ) {
            this.open = open;
            this.stewEffect = stewEffect;
            this.effectLengthInSeconds = effectLengthInSeconds;
        }

        public Block getBlock() {
            return this.open ? FutureBlocks.OPEN_EYEBLOSSOM : FutureBlocks.CLOSED_EYEBLOSSOM;
        }

        public BlockState getBlockState() {
            return this.getBlock().getDefaultState();
        }

        public EyeblossomBlock.EyeblossomState getOpposite() {
            return of(!this.open);
        }

        public boolean isOpen() {
            return this.open;
        }

        public static EyeblossomBlock.EyeblossomState of(boolean open) {
            return open ? OPEN : CLOSED;
        }
    }
}
