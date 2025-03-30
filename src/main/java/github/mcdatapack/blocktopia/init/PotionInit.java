package github.mcdatapack.blocktopia.init;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class PotionInit {
    public static final RegistryEntry<Potion> STRONG_XP_BOOST = register("strong_xp_boost", new Potion(new StatusEffectInstance(StatusEffectInit.XP_BOOST, 1800, 1)));
    public static final RegistryEntry<Potion> XP_BOOST = register("xp_boost", new Potion(new StatusEffectInstance(StatusEffectInit.XP_BOOST, 3600)));
    public static final RegistryEntry<Potion> LONG_XP_BOOST = register("long_xp_boost", new Potion(new StatusEffectInstance(StatusEffectInit.XP_BOOST, 9600)));

    public static final RegistryEntry<Potion> STRONG_XP_REMOVER = register("strong_xp_remover", new Potion(new StatusEffectInstance(StatusEffectInit.XP_REMOVER, 1800, 1)));
    public static final RegistryEntry<Potion> XP_REMOVER = register("xp_remover", new Potion(new StatusEffectInstance(StatusEffectInit.XP_REMOVER, 3600)));
    public static final RegistryEntry<Potion> LONG_XP_REMOVER = register("long_xp_remover", new Potion(new StatusEffectInstance(StatusEffectInit.XP_REMOVER, 9600)));

    private static RegistryEntry<Potion> register(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.ofVanilla(name), potion);
    }

    public static void load() {}
}
