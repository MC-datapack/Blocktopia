package github.mcdatapack.blocktopia.init;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.enchantments.effects.LightningEnchantmentEffect;
import github.mcdatapack.blocktopia.enchantments.effects.SpawnEggEffect;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.item.Item;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.ItemTags;

public class EnchantmentInit {
    public static RegistryKey<Enchantment> THUNDERING_SMITE_KEY = RegistryKey.of(RegistryKeys.ENCHANTMENT, Blocktopia.id("thundering_smite"));
    public static RegistryKey<Enchantment> SILK_SWING_KEY = RegistryKey.of(RegistryKeys.ENCHANTMENT, Blocktopia.id("silk_swing"));

    public static final MapCodec<LightningEnchantmentEffect> LIGHTNING_EFFECT = register("lightning_effect", LightningEnchantmentEffect.CODEC);
    public static final MapCodec<SpawnEggEffect> SPAWN_EGG_EFFECT = register("spawn_egg_effect", SpawnEggEffect.CODEC);

    private static <T extends EnchantmentEntityEffect> MapCodec<T> register(String name, MapCodec<T> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Blocktopia.id(name), codec);
    }

    public static void load() {}
}
