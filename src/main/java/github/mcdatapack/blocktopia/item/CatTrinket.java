package github.mcdatapack.blocktopia.item;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class CatTrinket extends TrinketItem {
    private final StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.SATURATION, 200, 0, false, false);

    public CatTrinket(Settings settings) {
        super(settings);
    }

    @Override
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier id) {
        Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> modifiers = Multimaps.newMultimap(Maps.newLinkedHashMap(), ArrayList::new);
        EntityAttributeModifier speedModifier = new EntityAttributeModifier(id.withSuffixedPath("blocktopia/movement_speed"),
                2.25, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        EntityAttributeModifier saveFallDistanceModifier = new EntityAttributeModifier(id.withSuffixedPath("blocktopia/save_fall_distance"),
                50.0, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, speedModifier);
        modifiers.put(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE, saveFallDistanceModifier);
        return modifiers;
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
        entity.addStatusEffect(statusEffectInstance);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        entity.addStatusEffect(statusEffectInstance);
    }
}
