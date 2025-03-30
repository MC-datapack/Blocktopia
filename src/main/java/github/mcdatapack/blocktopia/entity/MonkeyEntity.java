package github.mcdatapack.blocktopia.entity;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.init.EntityInit;
import github.mcdatapack.blocktopia.list.TagList;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
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
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MonkeyEntity extends AnimalEntity {
    private static final TrackedData<Byte> MONKEY_CLIMBING = DataTracker.registerData(MonkeyEntity.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Integer> MONKEY_VARIANT = DataTracker.registerData(MonkeyEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public MonkeyEntity(EntityType<? extends MonkeyEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        Variants variant = Util.getRandom(Variants.values(), random);
        setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(MONKEY_CLIMBING, (byte) 0);
        builder.add(MONKEY_VARIANT, 0);
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
    protected EntityNavigation createNavigation(World world) {
        return new MonkeyNavigation(this, world);
    }

    @Override
    public void tick() {
        if (getVariant() == null) {
            setVariant(Variants.BROWN);
        }
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
        if (!(entity instanceof MonkeyEntity monkeyEntity)) return null;
        MonkeyEntity baby = EntityInit.MONKEY.create(world);
        Variants variant = Variants.getBreedVariant(this, monkeyEntity);
        assert baby != null;
        baby.setVariant(variant);
        return baby;
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
        return (this.dataTracker.get(MONKEY_CLIMBING) & 1) != 0;
    }

    public void setClimbingWall(boolean climbing) {
        byte b = this.dataTracker.get(MONKEY_CLIMBING);
        if (climbing) {
            b = (byte)(b | 1);
        } else {
            b = (byte)(b & -2);
        }
        this.dataTracker.set(MONKEY_CLIMBING, b);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(MONKEY_VARIANT, nbt.getInt("Variant"));
    }

    public Variants getVariant() {
        return Variants.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(MONKEY_VARIANT);
    }

    private void setVariant(Variants variant) {
        this.dataTracker.set(MONKEY_VARIANT, variant.getId() & 255);
    }

    @Override
    protected int getXpToDrop() {
        return 10 + this.getWorld().random.nextInt(10);
    }

    public enum Variants {
        BROWN(0, "brown"),
        RED(1, "red"),
        BLACK(2, "black");

        private static final Variants[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(Variants::getId)).toArray(Variants[]::new);
        private final int id;
        private final String fileName;

        Variants(int id, String fileName) {
            this.id = id;
            this.fileName = "textures/entity/monkey/" + fileName + ".png";
        }

        public int getId() {
            return id;
        }

        public String getFileName() {
            return fileName;
        }

        public static Variants byId(int id) {
            return BY_ID[id];
        }

        public static Map<Variants, Identifier> textures() {
            Map<Variants, Identifier> result = new HashMap<>();
            for (Variants variant : values()) {
                result.put(variant, Blocktopia.id(variant.getFileName()));
            }
            return result;
        }

        public static Variants getBreedVariant(MonkeyEntity obj1, MonkeyEntity obj2) {
            if (BlocktopiaConfig.getConfig().randomMonkeyVariant) {
                Util.getRandom(Variants.values(), obj1.random);
            }
            Variants variant1 = obj1.getVariant();
            Variants variant2 = obj2.getVariant();

            return Util.getRandom(new Variants[]{variant1, variant2}, obj1.random);
        }
    }
}
