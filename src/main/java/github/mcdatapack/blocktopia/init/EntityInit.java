package github.mcdatapack.blocktopia.init;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.entity.MonkeyEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EntityInit {
    public static final EntityType<MonkeyEntity> MONKEY = Registry.register(Registries.ENTITY_TYPE, Blocktopia.id("monkey"),
            EntityType.Builder.create(MonkeyEntity::new, SpawnGroup.CREATURE).dimensions(1, 1).build());

    public static void load() {}
}
