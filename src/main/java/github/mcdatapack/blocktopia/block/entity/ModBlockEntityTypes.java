package github.mcdatapack.blocktopia.block.entity;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.block.entity.custom.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Util;

public interface ModBlockEntityTypes {
     BlockEntityType<SmallChestBlockEntity> SMALL_CHEST_BLOCK_ENTITY = register("small_chest",
            BlockEntityType.Builder.create(SmallChestBlockEntity::new, ModBlocks.SMALL_CHEST));
     BlockEntityType<XPTrapBlockEntity> XP_TRAP = register("xp_trap",
            BlockEntityType.Builder.create(XPTrapBlockEntity::new, ModBlocks.XP_TRAP));
     BlockEntityType<DuperBlockEntity> DUPER = register("duper",
            BlockEntityType.Builder.create(DuperBlockEntity::new, ModBlocks.DUPER));
     BlockEntityType<FluidTankBlockEntity> FLUID_TANK = register("fluid_tank",
             BlockEntityType.Builder.create(FluidTankBlockEntity::new, ModBlocks.FLUID_TANK));


    private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType.Builder<T> builder) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Blocktopia.id(name),
                builder.build(Util.getChoiceType(TypeReferences.BLOCK_ENTITY, Blocktopia.id(name).toString())));
    }
    static void load() {}
}
