package github.mcdatapack.blocktopia.enchantments.effects;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record SpawnEggEffect(EnchantmentLevelBasedValue enchantmentLevelBasedValue) implements EnchantmentEntityEffect {
    public static final MapCodec<SpawnEggEffect> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            EnchantmentLevelBasedValue.CODEC.fieldOf("level").forGetter(SpawnEggEffect::enchantmentLevelBasedValue))
        .apply(instance, SpawnEggEffect::new));

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity targetEntity, Vec3d pos) {
        if (targetEntity instanceof MobEntity mobEntity && mobEntity.isDead()) {
            SpawnEggItem spawnEggItem = SpawnEggItem.forEntity(mobEntity.getType());

            if (spawnEggItem != null) {
                ItemStack spawnEgg = new ItemStack(spawnEggItem);

                NbtCompound entityData = new NbtCompound();
                mobEntity.writeNbt(entityData);

                entityData.putString("id", mobEntity.getType().toString());

                entityData.remove("Pos");
                entityData.remove("Motion");
                entityData.remove("UUID");
                entityData.putFloat("Health", mobEntity.getMaxHealth());
                entityData.putShort("HurtTime", (short) 0);

                ComponentMap eggData = spawnEgg.getComponents();

                ComponentMap endData = ComponentMap.builder()
                        .addAll(eggData)
                        .add(DataComponentTypes.ENTITY_DATA, NbtComponent.of(entityData))
                        .build();

                spawnEgg.applyComponentsFrom(endData);

                mobEntity.dropStack(spawnEgg);
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
