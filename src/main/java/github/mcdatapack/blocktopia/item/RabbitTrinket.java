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
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class RabbitTrinket extends TrinketItem {
    public RabbitTrinket(Settings settings) {
        super(settings);
    }

    @Override
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier id) {
        Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> modifiers = Multimaps.newMultimap(Maps.newLinkedHashMap(), ArrayList::new);
        EntityAttributeModifier speedModifier = new EntityAttributeModifier(id.withSuffixedPath("blocktopia/jump_strength"),
                1.0, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        EntityAttributeModifier saveFallDistanceModifier = new EntityAttributeModifier(id.withSuffixedPath("blocktopia/save_fall_distance"),
                1.0, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        modifiers.put(EntityAttributes.GENERIC_JUMP_STRENGTH, speedModifier);
        modifiers.put(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE, saveFallDistanceModifier);
        return modifiers;
    }
}
