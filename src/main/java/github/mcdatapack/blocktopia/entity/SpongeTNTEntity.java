package github.mcdatapack.blocktopia.entity;

import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.init.EntityInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SpongeTNTEntity extends TntEntity {
    public SpongeTNTEntity(EntityType<? extends TntEntity> entityType, World world) {
        super(entityType, world);
    }

    public SpongeTNTEntity(World world, double x, double y, double z, @Nullable LivingEntity igniter) {
        this(EntityInit.SPONGE_TNT, world);
        this.setPosition(x, y, z);
        double d = world.random.nextDouble() * (float) (Math.PI * 2);
        this.setVelocity(-Math.sin(d) * 0.02, 0.2F, -Math.cos(d) * 0.02);
        this.setFuse(80);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
        this.causingEntity = igniter;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        builder.add(FUSE, 80);
        builder.add(BLOCK_STATE, BlockInit.SPONGE_TNT.getDefaultState());
    }

    @Override
    public void explode() {
        this.getWorld()
                .createExplosion(
                        this,
                        Explosion.createDamageSource(this.getWorld(), this),
                        new ExplosionBehavior() {
                            @Override
                            public Optional<Float> getBlastResistance(Explosion explosion, BlockView world, BlockPos pos, BlockState blockState, FluidState fluidState) {
                                return !fluidState.isEmpty() ? Optional.of(fluidState.getBlastResistance() / 100) : super.getBlastResistance(explosion, world, pos, blockState, fluidState);
                            }
                        },
                        this.getX(),
                        this.getBodyY(0.0625),
                        this.getZ(),
                        BlocktopiaConfig.getConfig().spongeTntExplosionPower,
                        false,
                        World.ExplosionSourceType.TNT
                );
    }
}
