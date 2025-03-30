package github.mcdatapack.blocktopia.init;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.entity.ChairEntity;
import github.mcdatapack.blocktopia.entity.MonkeyEntity;
import github.mcdatapack.blocktopia.entity.SpongeTNTEntity;
import github.mcdatapack.blocktopia.entity.abstracts.AbstractBirdEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EntityInit {
    public static final EntityType<MonkeyEntity> MONKEY = register("monkey",
            EntityType.Builder.create(MonkeyEntity::new, SpawnGroup.CREATURE).dimensions(1, 1));
    public static final EntityType<ChairEntity> CHAIR = register("monkey",
            EntityType.Builder.create(ChairEntity::new, SpawnGroup.CREATURE).dimensions(0.5F, 0.5F));
    public static final EntityType<AbstractBirdEntity> ABSTRACT_BIRD = register("abstract_bird",
            EntityType.Builder.create(AbstractBirdEntity::new, SpawnGroup.CREATURE).dimensions(0.5F, 0.5F));
    public static final EntityType<SpongeTNTEntity> SPONGE_TNT = register("sponge_tnt",
            EntityType.Builder.<SpongeTNTEntity>create(SpongeTNTEntity::new, SpawnGroup.MISC)
                    .makeFireImmune()
                    .dimensions(1, 1)
                    .eyeHeight(0.15F)
                    .maxTrackingRange(10)
                    .trackingTickInterval(10));

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, Blocktopia.id(id), type.build(id));
    }

    public static void load() {}
}
