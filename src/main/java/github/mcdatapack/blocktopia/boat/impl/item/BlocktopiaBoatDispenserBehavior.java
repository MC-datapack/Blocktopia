package github.mcdatapack.blocktopia.boat.impl.item;

import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatTypeRegistry;
import github.mcdatapack.blocktopia.boat.impl.entity.BlocktopiaBoatEntity;
import github.mcdatapack.blocktopia.boat.impl.entity.BlocktopiaChestBoatEntity;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class BlocktopiaBoatDispenserBehavior extends ItemDispenserBehavior {
    private static final DispenserBehavior FALLBACK_BEHAVIOR = new ItemDispenserBehavior();
    private static final double OFFSET_MULTIPLIER = 1.125F;

    private final RegistryKey<BlocktopiaBoatType> boatKey;
    private final boolean chest;

    public BlocktopiaBoatDispenserBehavior(RegistryKey<BlocktopiaBoatType> boatKey, boolean chest) {
        this.boatKey = boatKey;
        this.chest = chest;
    }

    @Override
    public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
        Direction facing = pointer.state().get(DispenserBlock.FACING);
        ServerWorld world = pointer.world();
        Vec3d centerPos = pointer.centerPos();

        double horizontalOffsetMultiplier = (OFFSET_MULTIPLIER + EntityType.BOAT.getWidth()) / 2.0d;
        double x = centerPos.getX() + facing.getOffsetX() * horizontalOffsetMultiplier;
        double y = centerPos.getY() + facing.getOffsetY() * OFFSET_MULTIPLIER;
        double z = centerPos.getZ() + facing.getOffsetZ() * horizontalOffsetMultiplier;

        BlockPos pos = pointer.pos().offset(facing);

        if (world.getFluidState(pos).isIn(FluidTags.WATER)) {
            y += 1.0d;
        } else if (!world.getBlockState(pos).isAir() || !world.getFluidState(pos.down()).isIn(FluidTags.WATER)) {
            return FALLBACK_BEHAVIOR.dispense(pointer, stack);
        }

        BlocktopiaBoatType boatType = BlocktopiaBoatTypeRegistry.INSTANCE.getOrThrow(this.boatKey);
        BoatEntity boatEntity;

        if (this.chest) {
            BlocktopiaChestBoatEntity chestBoat = new BlocktopiaChestBoatEntity(world, x, y, z);
            chestBoat.setBlocktopiaBoat(boatType);
            boatEntity = chestBoat;
        } else {
            BlocktopiaBoatEntity boat = new BlocktopiaBoatEntity(world, x, y, z);
            boat.setBlocktopiaBoat(boatType);
            boatEntity = boat;
        }

        boatEntity.setYaw(facing.asRotation());

        world.spawnEntity(boatEntity);

        stack.decrement(1);
        return stack;
    }

    @Override
    protected void playSound(BlockPointer pointer) {
        pointer.world().syncWorldEvent(1000, pointer.pos(), 0);
    }
}
