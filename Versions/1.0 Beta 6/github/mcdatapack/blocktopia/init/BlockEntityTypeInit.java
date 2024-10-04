package github.mcdatapack.blocktopia.init;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.entity.SmallChestBlockEntity;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import net.minecraft.class_2378;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_7923;

public class BlockEntityTypeInit {
    public static final class_2591<SmallChestBlockEntity> SMALL_CHEST_BLOCK_ENTITY = register("small_chest",
            class_2591.class_2592.method_20528(SmallChestBlockEntity::new, BlockInit.SMALL_CHEST).build());


    public static <T extends class_2586> class_2591<T> register(String name, class_2591<T> type) {
        return class_2378.method_10230(class_7923.field_41181, Blocktopia.id(name), type);
    }
    public static void load() {}
}
