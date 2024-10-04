package github.mcdatapack.blocktopia.boat.impl.item;

import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatTypeRegistry;
import github.mcdatapack.blocktopia.boat.impl.entity.BlocktopiaBoatEntity;
import github.mcdatapack.blocktopia.boat.impl.entity.BlocktopiaChestBoatEntity;
import net.minecraft.class_1299;
import net.minecraft.class_1690;
import net.minecraft.class_1799;
import net.minecraft.class_2315;
import net.minecraft.class_2338;
import net.minecraft.class_2342;
import net.minecraft.class_2347;
import net.minecraft.class_2350;
import net.minecraft.class_2357;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import net.minecraft.class_3486;
import net.minecraft.class_5321;

public class BlocktopiaBoatDispenserBehavior extends class_2347 {
    private static final class_2357 FALLBACK_BEHAVIOR = new class_2347();
    private static final double OFFSET_MULTIPLIER = 1.125F;

    private final class_5321<BlocktopiaBoatType> boatKey;
    private final boolean chest;

    public BlocktopiaBoatDispenserBehavior(class_5321<BlocktopiaBoatType> boatKey, boolean chest) {
        this.boatKey = boatKey;
        this.chest = chest;
    }

    @Override
    public class_1799 method_10135(class_2342 pointer, class_1799 stack) {
        class_2350 facing = pointer.comp_1969().method_11654(class_2315.field_10918);
        class_3218 world = pointer.comp_1967();
        class_243 centerPos = pointer.method_53906();

        double horizontalOffsetMultiplier = (OFFSET_MULTIPLIER + class_1299.field_6121.method_17685()) / 2.0d;
        double x = centerPos.method_10216() + facing.method_10148() * horizontalOffsetMultiplier;
        double y = centerPos.method_10214() + facing.method_10164() * OFFSET_MULTIPLIER;
        double z = centerPos.method_10215() + facing.method_10165() * horizontalOffsetMultiplier;

        class_2338 pos = pointer.comp_1968().method_10093(facing);

        if (world.method_8316(pos).method_15767(class_3486.field_15517)) {
            y += 1.0d;
        } else if (!world.method_8320(pos).method_26215() || !world.method_8316(pos.method_10074()).method_15767(class_3486.field_15517)) {
            return FALLBACK_BEHAVIOR.dispense(pointer, stack);
        }

        BlocktopiaBoatType boatType = BlocktopiaBoatTypeRegistry.INSTANCE.method_31140(this.boatKey);
        class_1690 boatEntity;

        if (this.chest) {
            BlocktopiaChestBoatEntity chestBoat = new BlocktopiaChestBoatEntity(world, x, y, z);
            chestBoat.setBlocktopiaBoat(boatType);
            boatEntity = chestBoat;
        } else {
            BlocktopiaBoatEntity boat = new BlocktopiaBoatEntity(world, x, y, z);
            boat.setBlocktopiaBoat(boatType);
            boatEntity = boat;
        }

        boatEntity.method_36456(facing.method_10144());

        world.method_8649(boatEntity);

        stack.method_7934(1);
        return stack;
    }

    @Override
    protected void method_10136(class_2342 pointer) {
        pointer.comp_1967().method_20290(1000, pointer.comp_1968(), 0);
    }
}
