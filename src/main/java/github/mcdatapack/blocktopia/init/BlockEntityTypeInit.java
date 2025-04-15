package github.mcdatapack.blocktopia.init;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.entity.DuperBlockEntity;
import github.mcdatapack.blocktopia.block.entity.LegacyCutterBlockEntity;
import github.mcdatapack.blocktopia.block.entity.SmallChestBlockEntity;
import github.mcdatapack.blocktopia.block.entity.XPTrapBlockEntity;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Util;

public class BlockEntityTypeInit {
    public static final BlockEntityType<SmallChestBlockEntity> SMALL_CHEST_BLOCK_ENTITY = register("small_chest",
            BlockEntityType.Builder.create(SmallChestBlockEntity::new, BlockInit.SMALL_CHEST));
    public static final BlockEntityType<XPTrapBlockEntity> XP_TRAP = register("xp_trap",
            BlockEntityType.Builder.create(XPTrapBlockEntity::new, BlockInit.XP_TRAP));
    public static final BlockEntityType<LegacyCutterBlockEntity> LEGACY_CUTTER = register("legacy_cutter",
            BlockEntityType.Builder.create(LegacyCutterBlockEntity::new, BlockInit.LEGACY_CUTTER));
    public static final BlockEntityType<DuperBlockEntity> DUPER = register("duper",
            BlockEntityType.Builder.create(DuperBlockEntity::new, BlockInit.DUPER));


    public static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType.Builder<T> builder) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Blocktopia.id(name), builder.build(Util.getChoiceType(TypeReferences.BLOCK_ENTITY, name)));
    }
    public static void load() {}
}
