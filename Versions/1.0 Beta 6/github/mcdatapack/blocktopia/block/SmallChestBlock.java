package github.mcdatapack.blocktopia.block;

import github.mcdatapack.blocktopia.block.entity.SmallChestBlockEntity;
import github.mcdatapack.blocktopia.init.BlockEntityTypeInit;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2343;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_3965;
import org.jetbrains.annotations.Nullable;

public class SmallChestBlock extends class_2248 implements class_2343 {
    public SmallChestBlock(class_2251 settings) {
        super(settings);
    }

    @Override
    protected class_1269 method_55766(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_3965 hit) {
        if (!world.field_9236) {
            if (world.method_8321(pos) instanceof SmallChestBlockEntity smallChestBlockEntity) {
                player.method_17355(smallChestBlockEntity);
            }
        }

        return class_1269.method_29236(world.field_9236);
    }

    @Override
    @Nullable
    public class_2586 method_10123(class_2338 pos, class_2680 state) {
        return BlockEntityTypeInit.SMALL_CHEST_BLOCK_ENTITY.method_11032(pos, state);
    }
}
