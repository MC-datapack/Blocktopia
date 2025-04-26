package github.mcdatapack.blocktopia.statuseffect;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.statuseffect.custom.XPBoostEffect;
import github.mcdatapack.blocktopia.statuseffect.custom.XPRemoverEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

public interface ModStatusEffects {
    RegistryEntry<StatusEffect> XP_BOOST = Registry.registerReference(Registries.STATUS_EFFECT, Blocktopia.id("xp_boost"), new XPBoostEffect());
    RegistryEntry<StatusEffect> XP_REMOVER = Registry.registerReference(Registries.STATUS_EFFECT, Blocktopia.id("xp_remover"), new XPRemoverEffect());
}
