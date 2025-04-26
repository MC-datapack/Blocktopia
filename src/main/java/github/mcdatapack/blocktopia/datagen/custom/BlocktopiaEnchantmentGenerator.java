package github.mcdatapack.blocktopia.datagen.custom;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public abstract class BlocktopiaEnchantmentGenerator extends FabricDynamicRegistryProvider {
    protected RegistryEntryList<Item> swordEnchantable, axeEnchantable, pickaxeEnchantable, shovelEnchantable, hoeEnchantable, armorEnchantable, helmetEnchantable, chestplateEnchantable, leggingsEnchantable, bootEnchantable, weaponEnchantable,
            sharpWeaponEnchantable, miningToolEnchantable, bowEnchantable;
    protected RegistryWrapper<Item> wrapper;

    public BlocktopiaEnchantmentGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
        registriesFuture.thenAccept(registries -> {
            wrapper = registries.getWrapperOrThrow(RegistryKeys.ITEM);
            swordEnchantable = wrapper.getOrThrow(ItemTags.SWORD_ENCHANTABLE);
            axeEnchantable = wrapper.getOrThrow(ItemTags.AXES);
            pickaxeEnchantable = wrapper.getOrThrow(ItemTags.PICKAXES);
            shovelEnchantable = wrapper.getOrThrow(ItemTags.SHOVELS);
            hoeEnchantable = wrapper.getOrThrow(ItemTags.HOES);
            armorEnchantable = wrapper.getOrThrow(ItemTags.ARMOR_ENCHANTABLE);
            helmetEnchantable = wrapper.getOrThrow(ItemTags.HEAD_ARMOR_ENCHANTABLE);
            chestplateEnchantable = wrapper.getOrThrow(ItemTags.CHEST_ARMOR_ENCHANTABLE);
            leggingsEnchantable = wrapper.getOrThrow(ItemTags.LEG_ARMOR_ENCHANTABLE);
            bootEnchantable = wrapper.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE);
            weaponEnchantable = wrapper.getOrThrow(ItemTags.WEAPON_ENCHANTABLE);
            sharpWeaponEnchantable = wrapper.getOrThrow(ItemTags.SHARP_WEAPON_ENCHANTABLE);
            miningToolEnchantable = wrapper.getOrThrow(ItemTags.MINING_ENCHANTABLE);
            bowEnchantable = wrapper.getOrThrow(ItemTags.BOW_ENCHANTABLE);
        });
    }

    protected void addEnchantment(Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        entries.add(key, builder.build(key.getValue()));
    }

    @Override
    public String getName() {
        return "Enchantment Generator";
    }
}
