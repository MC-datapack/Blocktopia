package github.mcdatapack.blocktopia.block;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2398;
import net.minecraft.class_2565;
import net.minecraft.class_2680;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_4970;
import net.minecraft.class_5819;
import net.minecraft.class_6088;

public class WetSpongeBlock_1_8 extends class_2248 {
    public static final MapCodec<class_2565> CODEC = method_54094(class_2565::new);

    @Override
    public MapCodec<class_2565> method_53969() {
        return field_46280;
    }

    public WetSpongeBlock_1_8(class_4970.class_2251 settings) {
        super(settings);
    }

    @Override
    protected void method_9615(class_2680 state, class_1937 world, class_2338 pos, class_2680 oldState, boolean notify) {
        if (world.method_8597().comp_644()) {
            world.method_8652(pos, LegacyBlocks.SPONGE_1_8.method_9564(), class_2248.field_31036);
            world.method_20290(class_6088.field_31152, pos, 0);
            world.method_8396(null, pos, class_3417.field_49173, class_3419.field_15245, 1.0F, (1.0F + world.method_8409().method_43057() * 0.2F) * 0.7F);
        }
    }

    @Override
    public void method_9496(class_2680 state, class_1937 world, class_2338 pos, class_5819 random) {
        class_2350 direction = class_2350.method_10162(random);
        if (direction != class_2350.field_11036) {
            class_2338 blockPos = pos.method_10093(direction);
            class_2680 blockState = world.method_8320(blockPos);
            if (!state.method_26225() || !blockState.method_26206(world, blockPos, direction.method_10153())) {
                double d = (double)pos.method_10263();
                double e = (double)pos.method_10264();
                double f = (double)pos.method_10260();
                if (direction == class_2350.field_11033) {
                    e -= 0.05;
                    d += random.method_43058();
                    f += random.method_43058();
                } else {
                    e += random.method_43058() * 0.8;
                    if (direction.method_10166() == class_2350.class_2351.field_11048) {
                        f += random.method_43058();
                        if (direction == class_2350.field_11034) {
                            d++;
                        } else {
                            d += 0.05;
                        }
                    } else {
                        d += random.method_43058();
                        if (direction == class_2350.field_11035) {
                            f++;
                        } else {
                            f += 0.05;
                        }
                    }
                }

                world.method_8406(class_2398.field_11232, d, e, f, 0.0, 0.0, 0.0);
            }
        }
    }
}
