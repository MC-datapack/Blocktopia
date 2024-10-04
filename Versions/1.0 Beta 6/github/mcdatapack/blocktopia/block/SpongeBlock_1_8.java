package github.mcdatapack.blocktopia.block;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import net.minecraft.block.*;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2263;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2404;
import net.minecraft.class_2502;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3486;
import net.minecraft.class_3610;
import net.minecraft.class_4970;

public class SpongeBlock_1_8 extends class_2248 {
    public static final MapCodec<class_2502> CODEC = method_54094(class_2502::new);
    public static final int ABSORB_RADIUS = 6;
    public static final int ABSORB_LIMIT = 64;
    private static final class_2350[] DIRECTIONS = class_2350.values();

    @Override
    public MapCodec<class_2502> method_53969() {
        return field_46280;
    }

    public SpongeBlock_1_8(class_4970.class_2251 settings) {
        super(settings);
    }

    @Override
    protected void method_9615(class_2680 state, class_1937 world, class_2338 pos, class_2680 oldState, boolean notify) {
        if (!oldState.method_27852(state.method_26204())) {
            this.update(world, pos);
        }
    }

    @Override
    protected void method_9612(class_2680 state, class_1937 world, class_2338 pos, class_2248 sourceBlock, class_2338 sourcePos, boolean notify) {
        this.update(world, pos);
        super.method_9612(state, world, pos, sourceBlock, sourcePos, notify);
    }

    protected void update(class_1937 world, class_2338 pos) {
        if (this.absorbWater(world, pos)) {
            world.method_8652(pos, LegacyBlocks.WET_SPONGE_1_8.method_9564(), class_2248.field_31028);
            world.method_8396(null, pos, class_3417.field_45062, class_3419.field_15245, 1.0F, 1.0F);
        }
    }

    private boolean absorbWater(class_1937 world, class_2338 pos) {
        return class_2338.method_49925(pos, 6, 65, (currentPos, queuer) -> {
            for (class_2350 direction : field_23157) {
                queuer.accept(currentPos.method_10093(direction));
            }
        }, currentPos -> {
            if (currentPos.equals(pos)) {
                return true;
            } else {
                class_2680 blockState = world.method_8320(currentPos);
                class_3610 fluidState = world.method_8316(currentPos);
                if (!fluidState.method_15767(class_3486.field_15517)) {
                    return false;
                } else {
                    if (blockState.method_26204() instanceof class_2263 fluidDrainable && !fluidDrainable.method_9700(null, world, currentPos, blockState).method_7960()) {
                        return true;
                    }

                    if (blockState.method_26204() instanceof class_2404) {
                        world.method_8652(currentPos, class_2246.field_10124.method_9564(), class_2248.field_31036);
                    } else {
                        if (!blockState.method_27852(class_2246.field_9993) && !blockState.method_27852(class_2246.field_10463) && !blockState.method_27852(class_2246.field_10376) && !blockState.method_27852(class_2246.field_10238)) {
                            return false;
                        }

                        class_2586 blockEntity = blockState.method_31709() ? world.method_8321(currentPos) : null;
                        method_9610(blockState, world, currentPos, blockEntity);
                        world.method_8652(currentPos, class_2246.field_10124.method_9564(), class_2248.field_31036);
                    }

                    return true;
                }
            }
        }) > 1;
    }
}
