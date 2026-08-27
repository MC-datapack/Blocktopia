package github.mcdatapack.blocktopia.datagen.generator;

import github.mcdatapack.blocktopia.datagen.custom.BlocktopiaEnchantmentGenerator;
import github.mcdatapack.blocktopia.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.EntityTypePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class BowLootingGenerator extends BlocktopiaEnchantmentGenerator {
    public BowLootingGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        addEnchantment(entries, Enchantments.LOOTING, Enchantment.builder(
                        Enchantment.definition(
                                wrapper.getOrThrow(ModTags.Items.BOW_LOOTING_ENCHANTABLE),
                                2,
                                3,
                                Enchantment.leveledCost(15, 9),
                                Enchantment.leveledCost(65, 9),
                                4,
                                AttributeModifierSlot.MAINHAND
                        )
                )
                .addEffect(
                        EnchantmentEffectComponentTypes.EQUIPMENT_DROPS,
                        EnchantmentEffectTarget.ATTACKER,
                        EnchantmentEffectTarget.VICTIM,
                        new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(0.01F)),
                        EntityPropertiesLootCondition.builder(
                                LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.create()
                                        .type(EntityTypePredicate.create(EntityType.PLAYER))
                        )
                ));
    }
}
