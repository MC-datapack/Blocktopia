package github.mcdatapack.blocktopia.datagen.generator;

import github.mcdatapack.blocktopia.enchantments.effects.LightningEnchantmentEffect;
import github.mcdatapack.blocktopia.init.EnchantmentInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class BlocktopiaEnchantmentGenerator extends FabricDynamicRegistryProvider {

    public BlocktopiaEnchantmentGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        RegistryWrapper<Item> itemLookup = registries.getWrapperOrThrow(RegistryKeys.ITEM);
        RegistryEntryList<Item> swordEnchantable = itemLookup.getOrThrow(ItemTags.SWORD_ENCHANTABLE);

        register(entries, EnchantmentInit.THUNDERING_SMITE_KEY, Enchantment.builder(
                Enchantment.definition(
                        swordEnchantable,
                        8,
                        10,
                        Enchantment.leveledCost(2, 4),
                        Enchantment.leveledCost(2, 6),
                        7,
                        AttributeModifierSlot.HAND
                )).addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                new LightningEnchantmentEffect(EnchantmentLevelBasedValue.linear(1, 2))));
    }

    private static void register(Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder, ResourceCondition... resourceConditions) {
        entries.add(key, builder.build(key.getValue()), resourceConditions);
    }

    @Override
    public String getName() {
        return "Blocktopia - Enchantment Generator";
    }
}
