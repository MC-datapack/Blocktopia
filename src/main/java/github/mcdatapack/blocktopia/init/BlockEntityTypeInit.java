package github.mcdatapack.blocktopia.init;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.entity.SmallChestBlockEntity;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BlockEntityTypeInit {
    public static final BlockEntityType<SmallChestBlockEntity> SMALL_CHEST_BLOCK_ENTITY = register("small_chest",
            BlockEntityType.Builder.create(SmallChestBlockEntity::new, BlockInit.SMALL_CHEST).build());


    public static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Blocktopia.id(name), type);
    }
    public static void load() {}
}
