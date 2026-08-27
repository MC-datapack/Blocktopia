package github.mcdatapack.blocktopia.entity;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.entity.custom.ToucanEntity;
import github.mcdatapack.blocktopia.entity.custom.ChairEntity;
import github.mcdatapack.blocktopia.entity.custom.MonkeyEntity;
import github.mcdatapack.blocktopia.entity.custom.SpongeTNTEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface ModEntityTypes {
    EntityType<MonkeyEntity> MONKEY = register("monkey",
            EntityType.Builder.create(MonkeyEntity::new, SpawnGroup.AMBIENT).spawnableFarFromPlayer().dimensions(1, 1));
    EntityType<ChairEntity> CHAIR = register("chair",
            EntityType.Builder.create(ChairEntity::new, SpawnGroup.CREATURE).dimensions(0.5F, 0.5F));
    EntityType<ToucanEntity> TOUCAN = register("toucan",
            EntityType.Builder.create(ToucanEntity::new, SpawnGroup.AMBIENT).dimensions(1, 1).eyeHeight(0.65F));
    EntityType<SpongeTNTEntity> SPONGE_TNT = register("sponge_tnt",
            EntityType.Builder.<SpongeTNTEntity>create(SpongeTNTEntity::new, SpawnGroup.MISC)
                    .makeFireImmune()
                    .dimensions(1, 1)
                    .eyeHeight(0.15F)
                    .maxTrackingRange(10)
                    .trackingTickInterval(10));

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, Blocktopia.id(id), type.build(Blocktopia.id(id).toString()));
    }

    static void load() {}
}
