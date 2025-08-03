package github.mcdatapack.blocktopia.statuseffect;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.statuseffect.custom.HealthAddOrRemoveEffect;
import github.mcdatapack.blocktopia.statuseffect.custom.XPBoostEffect;
import github.mcdatapack.blocktopia.statuseffect.custom.XPRemoverEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

import java.awt.*;

public interface ModStatusEffects {
    RegistryEntry<StatusEffect> XP_BOOST = Registry.registerReference(Registries.STATUS_EFFECT, Blocktopia.id("xp_boost"), new XPBoostEffect());
    RegistryEntry<StatusEffect> XP_REMOVER = Registry.registerReference(Registries.STATUS_EFFECT, Blocktopia.id("xp_remover"), new XPRemoverEffect());
    RegistryEntry<StatusEffect> HEALTH_ADD = Registry.registerReference(Registries.STATUS_EFFECT, Blocktopia.id("health_add"),
            new HealthAddOrRemoveEffect(StatusEffectCategory.BENEFICIAL, Color.GREEN.getRGB(), false));
    RegistryEntry<StatusEffect> HEALTH_REMOVE = Registry.registerReference(Registries.STATUS_EFFECT, Blocktopia.id("health_remove"),
            new HealthAddOrRemoveEffect(StatusEffectCategory.BENEFICIAL, Color.RED.getRGB(), true));
}
