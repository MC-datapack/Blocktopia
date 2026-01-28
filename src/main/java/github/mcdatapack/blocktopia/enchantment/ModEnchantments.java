package github.mcdatapack.blocktopia.enchantment;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.enchantment.effects.IceLevelledBlockStateProvider;
import github.mcdatapack.blocktopia.enchantment.effects.LightningEnchantmentEffect;
import github.mcdatapack.blocktopia.enchantment.effects.ReplaceDiskEnchantmentEffectWithIce;
import github.mcdatapack.blocktopia.enchantment.effects.SpawnEggEffect;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.*;

public interface ModEnchantments {
    RegistryKey<Enchantment> THUNDERING_SMITE_KEY = RegistryKey.of(RegistryKeys.ENCHANTMENT, Blocktopia.id("thundering_smite"));
    RegistryKey<Enchantment> SILK_SWING_KEY = RegistryKey.of(RegistryKeys.ENCHANTMENT, Blocktopia.id("silk_swing"));

    MapCodec<LightningEnchantmentEffect> LIGHTNING_EFFECT = register("lightning_effect", LightningEnchantmentEffect.CODEC);
    MapCodec<SpawnEggEffect> SPAWN_EGG_EFFECT = register("spawn_egg_effect", SpawnEggEffect.CODEC);
    MapCodec<ReplaceDiskEnchantmentEffectWithIce> REPLACE_DISK_ENCHANTMENT_EFFECT_WITH_ICE = registerL("replace_disk_enchantment_with_ice", ReplaceDiskEnchantmentEffectWithIce.CODEC);

    private static <T extends EnchantmentEntityEffect> MapCodec<T> register(String name, MapCodec<T> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Blocktopia.id(name), codec);
    }

    private static <T extends EnchantmentEntityEffect> MapCodec<T> registerL(String name, MapCodec<T> codec) {
        return Registry.register(Registries.ENCHANTMENT_LOCATION_BASED_EFFECT_TYPE, Blocktopia.id(name), codec);
    }

    static void load() {}
}
