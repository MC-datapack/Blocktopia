package github.mcdatapack.blocktopia.entity;

import github.mcdatapack.blocktopia.init.EntityInit;
import github.mcdatapack.blocktopia.list.TagList;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MonkeyEntity extends AnimalEntity {
    private static final TrackedData<Byte> MONKEY_FLAGS = DataTracker.registerData(MonkeyEntity.class, TrackedDataHandlerRegistry.BYTE);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public MonkeyEntity(EntityType<? extends MonkeyEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(MONKEY_FLAGS, (byte) 0);
    }

    private void updateAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            this.idleAnimationTimeout--;
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 1.2554));
        this.goalSelector.add(2, new TemptGoal(this, 0.45, Ingredient.fromTag(TagList.Items.MONKEY_BREEDING_ITEMS), false));
        this.goalSelector.add(3, new FollowParentGoal(this, 0.45));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 0.31));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 15));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            updateAnimationStates();
        } else {
            this.setClimbingWall(this.horizontalCollision);
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isIn(TagList.Items.MONKEY_BREEDING_ITEMS);
    }

    public static DefaultAttributeContainer.Builder createMonkeyAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE, 1000)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4F);
    }


    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return EntityInit.MONKEY.create(world);
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6, 1) : 0;
        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    public boolean isClimbing() {
        return this.horizontalCollision && this.isClimbingWall();
    }

    public boolean isClimbingWall() {
        return (this.dataTracker.get(MONKEY_FLAGS) & 1) != 0;
    }

    public void setClimbingWall(boolean climbing) {
        byte b = this.dataTracker.get(MONKEY_FLAGS);
        if (climbing) {
            b = (byte)(b | 1);
        } else {
            b = (byte)(b & -2);
        }
        this.dataTracker.set(MONKEY_FLAGS, b);
    }
}
