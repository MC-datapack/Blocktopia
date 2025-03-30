package github.mcdatapack.blocktopia.datagen.generator;

import github.mcdatapack.blocktopia.datagen.generator.custom.BlocktopiaEnchantmentGenerator;
import github.mcdatapack.blocktopia.enchantments.effects.SpawnEggEffect;
import github.mcdatapack.blocktopia.init.EnchantmentInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class SilkSwingGenerator extends BlocktopiaEnchantmentGenerator {
    public SilkSwingGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        entries.add(EnchantmentInit.SILK_SWING_KEY, Enchantment.builder(
                Enchantment.definition(
                        swordEnchantable,
                        1,
                        1,
                        Enchantment.leveledCost(2, 4),
                        Enchantment.leveledCost(2, 6),
                        6,
                        AttributeModifierSlot.HAND
                )).addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                new SpawnEggEffect(EnchantmentLevelBasedValue.linear(1, 1))).build(EnchantmentInit.SILK_SWING_KEY.getValue()));
    }
}
