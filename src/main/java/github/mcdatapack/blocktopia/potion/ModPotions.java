package github.mcdatapack.blocktopia.potion;

import github.mcdatapack.blocktopia.statuseffect.ModStatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public interface ModPotions {
    RegistryEntry<Potion> STRONG_XP_BOOST = register("strong_xp_boost", new Potion("xp_boost",new StatusEffectInstance(ModStatusEffects.XP_BOOST, 1800, 1)));
    RegistryEntry<Potion> XP_BOOST = register("xp_boost", new Potion("xp_boost", new StatusEffectInstance(ModStatusEffects.XP_BOOST, 3600)));
    RegistryEntry<Potion> LONG_XP_BOOST = register("long_xp_boost", new Potion("xp_boost", new StatusEffectInstance(ModStatusEffects.XP_BOOST, 9600)));

    RegistryEntry<Potion> STRONG_XP_REMOVER = register("strong_xp_remover", new Potion("xp_remover", new StatusEffectInstance(ModStatusEffects.XP_REMOVER, 1800, 1)));
    RegistryEntry<Potion> XP_REMOVER = register("xp_remover", new Potion("xp_remover", new StatusEffectInstance(ModStatusEffects.XP_REMOVER, 3600)));
    RegistryEntry<Potion> LONG_XP_REMOVER = register("long_xp_remover", new Potion("xp_remover", new StatusEffectInstance(ModStatusEffects.XP_REMOVER, 9600)));

    private static RegistryEntry<Potion> register(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.ofVanilla(name), potion);
    }

    static void load() {}
}
