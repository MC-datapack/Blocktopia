package github.mcdatapack.blocktopia.entity.custom;

import github.mcdatapack.blocktopia.entity.custom.abstracts.AbstractBirdEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;

public class ToucanEntity extends AbstractBirdEntity {
    public ToucanEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }
}
