package github.mcdatapack.blocktopia.datagen.generator;

import github.mcdatapack.blocktopia.datagen.custom.BlocktopiaEnchantmentGenerator;
import github.mcdatapack.blocktopia.enchantment.ModEnchantments;
import github.mcdatapack.blocktopia.enchantment.effects.ReplaceDiskEnchantmentEffectWithIce;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Blocks;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.effect.AttributeEnchantmentEffect;
import net.minecraft.enchantment.effect.DamageImmunityEnchantmentEffect;
import net.minecraft.enchantment.effect.entity.IgniteEnchantmentEffect;
import net.minecraft.enchantment.effect.entity.ReplaceDiskEnchantmentEffect;
import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
import net.minecraft.enchantment.effect.value.MultiplyEnchantmentEffect;
import net.minecraft.enchantment.effect.value.SetEnchantmentEffect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.*;
import net.minecraft.loot.context.LootContext;
import net.minecraft.predicate.TagPredicate;
import net.minecraft.predicate.entity.DamageSourcePredicate;
import net.minecraft.predicate.entity.EntityFlagsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class EnchantmentGenerator extends BlocktopiaEnchantmentGenerator {
    public EnchantmentGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup, Entries entries) {
        ModEnchantments.REPLACE_DISK_ENCHANTMENT_EFFECT_WITH_ICE.codec();

        addEnchantment(entries, Enchantments.AQUA_AFFINITY,
                new Enchantment.Builder(Enchantment.definition(
                        helmetEnchantable,
                        2,
                        1,
                        Enchantment.leveledCost(1, 4),
                        Enchantment.leveledCost(41, 4),
                        4,
                        AttributeModifierSlot.HEAD
                )).addEffect(
                        EnchantmentEffectComponentTypes.ATTRIBUTES,
                        new AttributeEnchantmentEffect(
                                Identifier.ofVanilla("enchantment.aqua_affinity"),
                                EntityAttributes.PLAYER_SUBMERGED_MINING_SPEED,
                                new EnchantmentLevelBasedValue.Clamped(
                                        EnchantmentLevelBasedValue.linear(4), 1, 12),
                                EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                ));
        addEnchantment(
                entries,
                Enchantments.FLAME,
                Enchantment.builder(
                                Enchantment.definition(
                                        bowEnchantable,
                                        2,
                                        1,
                                        Enchantment.constantCost(20),
                                        Enchantment.constantCost(50),
                                        4,
                                        AttributeModifierSlot.MAINHAND
                                )
                        )
                        .addEffect(EnchantmentEffectComponentTypes.PROJECTILE_SPAWNED, new IgniteEnchantmentEffect(EnchantmentLevelBasedValue.linear(20)))
        );
        addEnchantment(
                entries,
                Enchantments.FROST_WALKER,
                Enchantment.builder(
                                Enchantment.definition(
                                        bootEnchantable,
                                        2,
                                        2,
                                        Enchantment.leveledCost(10, 10),
                                        Enchantment.leveledCost(25, 10),
                                        4,
                                        AttributeModifierSlot.FEET
                                )
                        )
                        .exclusiveSet(bootSet)
                        .addEffect(
                                EnchantmentEffectComponentTypes.DAMAGE_IMMUNITY,
                                DamageImmunityEnchantmentEffect.INSTANCE,
                                DamageSourcePropertiesLootCondition.builder(
                                        DamageSourcePredicate.Builder.create()
                                                .tag(TagPredicate.expected(DamageTypeTags.BURN_FROM_STEPPING))
                                                .tag(TagPredicate.unexpected(DamageTypeTags.BYPASSES_INVULNERABILITY))
                                )
                        )
                        .addEffect(
                                EnchantmentEffectComponentTypes.LOCATION_CHANGED,
                                new ReplaceDiskEnchantmentEffectWithIce(
                                        new EnchantmentLevelBasedValue.Clamped(EnchantmentLevelBasedValue.linear(3.0F, 1.0F), 0, 25),
                                        EnchantmentLevelBasedValue.linear(1, 0.01F),
                                        new Vec3i(0, -1, 0),
                                        Optional.of(
                                                BlockPredicate.allOf(
                                                        BlockPredicate.matchingBlockTag(new Vec3i(0, 1, 0), BlockTags.AIR),
                                                        BlockPredicate.matchingBlocks(Blocks.WATER),
                                                        BlockPredicate.matchingFluids(Fluids.WATER),
                                                        BlockPredicate.unobstructed()
                                                )
                                        ),
                                        Optional.of(GameEvent.BLOCK_PLACE)
                                ),
                                EntityPropertiesLootCondition.builder(
                                        LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onGround(true))
                                )
                        )
        );
        addEnchantment(
                entries,
                Enchantments.INFINITY,
                Enchantment.builder(
                                Enchantment.definition(
                                        bowEnchantable,
                                        1,
                                        1,
                                        Enchantment.constantCost(20),
                                        Enchantment.constantCost(50),
                                        8,
                                        AttributeModifierSlot.MAINHAND
                                )
                        )
                        .exclusiveSet(bowSet)
                        .addEffect(
                                EnchantmentEffectComponentTypes.AMMO_USE,
                                new SetEnchantmentEffect(EnchantmentLevelBasedValue.constant(0.0F)),
                                MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.ARROWS))
                        )
        );
        addEnchantment(
                entries,
                Enchantments.MENDING,
                Enchantment.builder(
                                Enchantment.definition(
                                        durabilityEnchantable,
                                        2,
                                        1,
                                        Enchantment.leveledCost(25, 25),
                                        Enchantment.leveledCost(75, 25),
                                        4,
                                        AttributeModifierSlot.ANY
                                )
                        )
                        .addEffect(EnchantmentEffectComponentTypes.REPAIR_WITH_XP,
                                new MultiplyEnchantmentEffect(EnchantmentLevelBasedValue.linear(2, 2)))
        );
    }
}
