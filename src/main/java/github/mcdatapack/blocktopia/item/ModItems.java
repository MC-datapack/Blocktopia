package github.mcdatapack.blocktopia.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.entity.ModBoats;
import github.mcdatapack.blocktopia.entity.ModEntityTypes;
import github.mcdatapack.blocktopia.fluid.ModFluids;
import github.mcdatapack.blocktopia.item.custom.CatTrinket;
import github.mcdatapack.blocktopia.item.custom.FishTrinket;
import github.mcdatapack.blocktopia.item.custom.RabbitTrinket;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.BoatDispenserBehavior;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public interface ModItems {
    Item COCONUT = register("coconut", settings -> new Item(settings
            .food(ModFoodComponents.COCONUT_SETTINGS)
            .rarity(Rarity.UNCOMMON)));
    Item GOLDEN_COCONUT = register("golden_coconut", settings -> new Item(settings
            .food(ModFoodComponents.GOLDEN_COCONUT_SETTINGS)
            .rarity(Rarity.RARE)));
    Item ENCHANTED_GOLDEN_COCONUT = register("enchanted_golden_coconut", settings -> new Item(settings
            .food(ModFoodComponents.ENCHANTED_GOLDEN_COCONUT_SETTINGS)
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
            .rarity(Rarity.EPIC)));
    Item ENCHANTED_GOLDEN_CARROT = register("enchanted_golden_carrot", settings -> new Item(settings
            .food(ModFoodComponents.ENCHANTED_GOLDEN_CARROT_SETTINGS)
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
            .rarity(Rarity.EPIC)));
    Item GOLDEN_POTATO = register("golden_potato", settings -> new Item(settings
            .food(ModFoodComponents.GOLDEN_POTATO_SETTINGS)
            .rarity(Rarity.RARE)));
    Item ENCHANTED_GOLDEN_POTATO = register("enchanted_golden_potato", settings -> new Item(settings
            .food(ModFoodComponents.ENCHANTED_GOLDEN_POTATO_SETTINGS)
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
            .rarity(Rarity.EPIC)));
    Item GOLDEN_BAKED_POTATO = register("golden_baked_potato", settings -> new Item(settings
            .food(ModFoodComponents.GOLDEN_BAKED_POTATO_SETTINGS)
            .rarity(Rarity.RARE)));
    Item ENCHANTED_GOLDEN_BAKED_POTATO = register("enchanted_golden_baked_potato", settings -> new Item(settings
            .food(ModFoodComponents.ENCHANTED_GOLDEN_BAKED_POTATO_SETTINGS)
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
            .rarity(Rarity.EPIC)));
    Item CHERRY = register("cherry", settings -> new Item(settings
            .food(ModFoodComponents.CHERRY_SETTINGS)
            .rarity(Rarity.UNCOMMON)
    ));
    Item GOLDEN_CHERRY = register("golden_cherry", settings -> new Item(settings
            .food(ModFoodComponents.GOLDEN_CHERRY_SETTINGS)
            .rarity(Rarity.RARE)
    ));
    Item ENCHANTED_GOLDEN_CHERRY = register("enchanted_golden_cherry", settings -> new Item(settings
            .food(ModFoodComponents.ENCHANTED_GOLDEN_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
    ));
    Item DIAMOND_CHERRY = register("diamond_cherry", settings -> new Item(settings
            .food(ModFoodComponents.DIAMOND_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
    ));
    Item ENCHANTED_DIAMOND_CHERRY = register("enchanted_diamond_cherry", settings -> new Item(settings
            .food(ModFoodComponents.ENCHANTED_DIAMOND_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
    ));
    Item NETHERITE_CHERRY = register("netherite_cherry", settings -> new Item(settings
            .food(ModFoodComponents.NETHERITE_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .maxCount(99)
    ));
    Item ENCHANTED_NETHERITE_CHERRY = register("enchanted_netherite_cherry", settings -> new Item(settings
            .food(ModFoodComponents.ENCHANTED_NETHERITE_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .maxCount(99)
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
    ));
    Item DEEPSLATE_EMERALD_CHERRY = register("deepslate_emerald_cherry", settings -> new Item(settings
            .food(ModFoodComponents.DEEPSLATE_EMERALD_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .maxCount(99)
    ));
    Item ENCHANTED_DEEPSLATE_EMERALD_CHERRY = register("enchanted_deepslate_emerald_cherry", settings -> new Item(settings
            .food(ModFoodComponents.ENCHANTED_DEEPSLATE_EMERALD_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .maxCount(99)
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
    ));
    Item END_DIAMOND_CHERRY = register("end_diamond_cherry", settings -> new Item(settings
            .food(ModFoodComponents.END_DIAMOND_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .maxCount(99)
    ));
    Item ENCHANTED_END_DIAMOND_CHERRY = register("enchanted_end_diamond_cherry", settings -> new Item(settings
            .food(ModFoodComponents.ENCHANTED_END_DIAMOND_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .maxCount(99)
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
    ));
    Item PALM_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.PALM_BOAT_ID, ModBoats.PALM_BOAT_KEY, false);
    Item PALM_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.PALM_CHEST_BOAT_ID, ModBoats.PALM_BOAT_KEY, true);
    Item BANANA_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.BANANA_BOAT_ID, ModBoats.BANANA_BOAT_KEY, false);
    Item BANANA_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.BANANA_CHEST_BOAT_ID, ModBoats.BANANA_BOAT_KEY, true);
    Item CORN_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.CORN_BOAT_ID, ModBoats.CORN_BOAT_KEY, false);
    Item CORN_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.CORN_CHEST_BOAT_ID, ModBoats.CORN_BOAT_KEY, true);
    Item POISONED_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.POISONED_BOAT_ID, ModBoats.POISONED_BOAT_KEY, false);
    Item POISONED_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.POISONED_CHEST_BOAT_ID, ModBoats.POISONED_BOAT_KEY, true);
    Item MAHOGANY_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.MAHOGANY_BOAT_ID, ModBoats.MAHOGANY_BOAT_KEY, false);
    Item MAHOGANY_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.MAHOGANY_CHEST_BOAT_ID, ModBoats.MAHOGANY_BOAT_KEY, true);

    SpawnEggItem GIANT_SPAWN_EGG = registerAsVanilla("giant_spawn_egg", settings -> new SpawnEggItem(EntityType.GIANT,  44993, 7969900,
            settings.rarity(Rarity.EPIC)));
    SpawnEggItem ILLUSIONER_SPAWN_EGG = registerAsVanilla("illusioner_spawn_egg", settings -> new SpawnEggItem(EntityType.ILLUSIONER, 44543, 4500,
            settings.rarity(Rarity.EPIC)));

    MinecartItem SPAWNER_MINECART = register("spawner_minecart", settings -> new MinecartItem(AbstractMinecartEntity.Type.SPAWNER, settings));

    SpawnEggItem MONKEY_SPAWN_EGG = register("monkey_spawn_egg", settings -> new SpawnEggItem(ModEntityTypes.MONKEY, 2626304, 4532741, settings));

    RabbitTrinket RABBIT_TRINKET = register("rabbit_trinket", RabbitTrinket::new);
    FishTrinket FISH_TRINKET = register("fish_trinket", FishTrinket::new);
    CatTrinket CAT_TRINKET = register("cat_trinket", CatTrinket::new);
    Item BANANA = register("banana", settings -> new Item(settings.food(ModFoodComponents.BANANA)));

    Item CREATIVE_NUGGET = register("creative_nugget", settings -> new Item(settings
            .fireproof()
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
    ));
    Item CREATIVE_INGOT = register("creative_ingot", settings -> new Item(settings
            .fireproof()
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
    ));

    Item FUTURE_INGOT = register("future_ingot", Item::new);
    Item THERMORGANIC_FUEL = register("thermorganic_fuel", settings -> new Item(settings
            .rarity(Rarity.RARE)));

    static <T extends Item> T register(String name, Function<Item.Settings, T> Item) {
        return Registry.register(Registries.ITEM, Blocktopia.id(name), Item.apply(new Item.Settings()));
    }
    static <T extends Item> T registerAsVanilla(String name, Function<Item.Settings, T> Item) {
        return Registry.register(Registries.ITEM, Identifier.ofVanilla(name), Item.apply(new Item.Settings()));
    }
    static <T extends Item> T register(String name, Item.Settings settings, Function<Item.Settings, T> Item) {
        return Registry.register(Registries.ITEM, Blocktopia.id(name), Item.apply(settings));
    }
    static <T extends Item> T registerAsVanilla(String name, Item.Settings settings, Function<Item.Settings, T> Item) {
        return Registry.register(Registries.ITEM, Identifier.ofVanilla(name), Item.apply(settings));
    }

    static void load() {}
}
