package github.mcdatapack.blocktopia.boat.impl.item;

import java.util.List;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1297;
import net.minecraft.class_1301;
import net.minecraft.class_1657;
import net.minecraft.class_1690;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3468;
import net.minecraft.class_3959;
import net.minecraft.class_5321;
import net.minecraft.class_5712;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatTypeRegistry;
import github.mcdatapack.blocktopia.boat.impl.entity.BlocktopiaBoatEntity;
import github.mcdatapack.blocktopia.boat.impl.entity.BlocktopiaChestBoatEntity;

public class BlocktopiaBoatItem extends class_1792 {
    private static final Predicate<class_1297> RIDERS = class_1301.field_6155.and(class_1297::method_5863);

    private final class_5321<BlocktopiaBoatType> boatKey;
    private final boolean chest;

    public BlocktopiaBoatItem(class_5321<BlocktopiaBoatType> boatKey, boolean chest, class_1792.class_1793 settings) {
        super(settings);

        this.boatKey = boatKey;
        this.chest = chest;
    }

    public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
        class_1799 stack = user.method_5998(hand);

        class_239 hitResult = class_1792.method_7872(world, user, class_3959.class_242.field_1347);
        if (hitResult.method_17783() == class_239.class_240.field_1333) {
            return class_1271.method_22430(stack);
        }

        class_243 rotationVec = user.method_5828(1f);
        List<class_1297> riders = world.method_8333(user, user.method_5829().method_18804(rotationVec.method_1021(5d)).method_1014(1d), RIDERS);

        // Prevent collision with user
        if (!riders.isEmpty()) {
            class_243 eyePos = user.method_33571();
            for (class_1297 entity : riders) {
                class_238 box = entity.method_5829().method_1014(entity.method_5871());
                if (box.method_1006(eyePos)) {
                    return class_1271.method_22430(stack);
                }
            }
        }

        // Spawn boat entity
        if (hitResult.method_17783() == class_239.class_240.field_1332) {
            double x = hitResult.method_17784().field_1352;
            double y = hitResult.method_17784().field_1351;
            double z = hitResult.method_17784().field_1350;

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

            boatEntity.method_36456(user.method_36454());

            if (!world.method_8587(boatEntity, boatEntity.method_5829().method_1014(-0.1d))) {
                return class_1271.method_22431(stack);
            }

            if (!world.method_8608()) {
                world.method_8649(boatEntity);
                world.method_33596(user, class_5712.field_28738, class_2338.method_49638(hitResult.method_17784()));

                if (!user.method_31549().field_7477) {
                    stack.method_7934(1);
                }
            }

            user.method_7259(class_3468.field_15372.method_14956(this));
            return class_1271.method_29237(stack, world.method_8608());
        }

        return class_1271.method_22430(stack);
    }
}
