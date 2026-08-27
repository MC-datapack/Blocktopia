package github.mcdatapack.blocktopia.block.entity;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.block.entity.custom.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface ModBlockEntityTypes {
     BlockEntityType<SmallChestBlockEntity> SMALL_CHEST_BLOCK_ENTITY = register("small_chest",
            FabricBlockEntityTypeBuilder.create(SmallChestBlockEntity::new, ModBlocks.SMALL_CHEST));
     BlockEntityType<XPTrapBlockEntity> XP_TRAP = register("xp_trap",
             FabricBlockEntityTypeBuilder.create(XPTrapBlockEntity::new, ModBlocks.XP_TRAP));
     BlockEntityType<DuperBlockEntity> DUPER = register("duper",
             FabricBlockEntityTypeBuilder.create(DuperBlockEntity::new, ModBlocks.DUPER));
     BlockEntityType<FluidTankBlockEntity> FLUID_TANK = register("fluid_tank",
             FabricBlockEntityTypeBuilder.create(FluidTankBlockEntity::new, ModBlocks.FLUID_TANK));


    private static <T extends BlockEntity> BlockEntityType<T> register(String name, FabricBlockEntityTypeBuilder<T> builder) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Blocktopia.id(name), builder.build());
    }
    static void load() {}
}
