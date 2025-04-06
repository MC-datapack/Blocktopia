package github.mcdatapack.blocktopia.datagen.generator;

import github.mcdatapack.blocktopia.datagen.generator.custom.BlocktopiaEnchantmentGenerator;
import github.mcdatapack.blocktopia.enchantments.effects.LightningEnchantmentEffect;
import github.mcdatapack.blocktopia.init.EnchantmentInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ThunderingSmiteGenerator extends BlocktopiaEnchantmentGenerator {
    public ThunderingSmiteGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        addEnchantment(entries, EnchantmentInit.THUNDERING_SMITE_KEY, Enchantment.builder(
                Enchantment.definition(
                        swordEnchantable,
                        1,
                        10,
                        Enchantment.leveledCost(2, 4),
                        Enchantment.leveledCost(2, 6),
                        7,
                        AttributeModifierSlot.HAND
                )).addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                new LightningEnchantmentEffect(EnchantmentLevelBasedValue.linear(1, 2))));
    }
}
