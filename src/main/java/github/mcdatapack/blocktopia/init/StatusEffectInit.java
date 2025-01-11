package github.mcdatapack.blocktopia.init;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.statuseffects.XPBoostEffect;
import github.mcdatapack.blocktopia.statuseffects.XPRemoverEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

public class StatusEffectInit {
    public static final RegistryEntry<StatusEffect> XP_BOOST = Registry.registerReference(Registries.STATUS_EFFECT, Blocktopia.id("xp_boost"), new XPBoostEffect());
    public static final RegistryEntry<StatusEffect> XP_REMOVER = Registry.registerReference(Registries.STATUS_EFFECT, Blocktopia.id("xp_remover"), new XPRemoverEffect());
}
