package github.mcdatapack.blocktopia.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.LegacyBlocks;
import github.mcdatapack.blocktopia.entity.ModBoats;
import github.mcdatapack.blocktopia.entity.ModEntityTypes;
import github.mcdatapack.blocktopia.fluid.ModFluids;
import github.mcdatapack.blocktopia.item.custom.CatTrinket;
import github.mcdatapack.blocktopia.item.custom.FishTrinket;
import github.mcdatapack.blocktopia.item.custom.RabbitTrinket;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;

public interface ModItems {
    Item COCONUT = register("coconut", new Item(new Item.Settings().food(ModFoodComponents.COCONUT_SETTINGS).rarity(Rarity.UNCOMMON)));
    Item GOLDEN_COCONUT = register("golden_coconut", new Item(new Item.Settings().food(ModFoodComponents.GOLDEN_COCONUT_SETTINGS).rarity(Rarity.RARE)));
    Item ENCHANTED_GOLDEN_COCONUT = register("enchanted_golden_coconut", new Item(new Item.Settings().food(ModFoodComponents.ENCHANTED_GOLDEN_COCONUT_SETTINGS).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).rarity(Rarity.EPIC)));
    Item ENCHANTED_GOLDEN_CARROT = register("enchanted_golden_carrot", new Item(new Item.Settings().food(ModFoodComponents.ENCHANTED_GOLDEN_CARROT_SETTINGS).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).rarity(Rarity.EPIC)));
    Item GOLDEN_POTATO = register("golden_potato", new Item(new Item.Settings().food(ModFoodComponents.GOLDEN_POTATO_SETTINGS).rarity(Rarity.RARE)));
    Item ENCHANTED_GOLDEN_POTATO = register("enchanted_golden_potato", new Item(new Item.Settings().food(ModFoodComponents.ENCHANTED_GOLDEN_POTATO_SETTINGS).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).rarity(Rarity.EPIC)));
    Item GOLDEN_BAKED_POTATO = register("golden_baked_potato", new Item(new Item.Settings().food(ModFoodComponents.GOLDEN_BAKED_POTATO_SETTINGS).rarity(Rarity.RARE)));
    Item ENCHANTED_GOLDEN_BAKED_POTATO = register("enchanted_golden_baked_potato", new Item(new Item.Settings().food(ModFoodComponents.ENCHANTED_GOLDEN_BAKED_POTATO_SETTINGS).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).rarity(Rarity.EPIC)));
    Item CHERRY = register("cherry", new Item(new Item.Settings()
            .food(ModFoodComponents.CHERRY_SETTINGS)
            .rarity(Rarity.UNCOMMON)
    ));
    Item GOLDEN_CHERRY = register("golden_cherry", new Item(new Item.Settings()
            .food(ModFoodComponents.GOLDEN_CHERRY_SETTINGS)
            .rarity(Rarity.RARE)
    ));
    Item ENCHANTED_GOLDEN_CHERRY = register("enchanted_golden_cherry", new Item(new Item.Settings()
            .food(ModFoodComponents.ENCHANTED_GOLDEN_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
    ));
    Item DIAMOND_CHERRY = register("diamond_cherry", new Item(new Item.Settings()
            .food(ModFoodComponents.DIAMOND_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
    ));
    Item ENCHANTED_DIAMOND_CHERRY = register("enchanted_diamond_cherry", new Item(new Item.Settings()
            .food(ModFoodComponents.ENCHANTED_DIAMOND_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
    ));
    Item NETHERITE_CHERRY = register("netherite_cherry", new Item(new Item.Settings()
            .food(ModFoodComponents.NETHERITE_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .maxCount(99)
    ));
    Item ENCHANTED_NETHERITE_CHERRY = register("enchanted_netherite_cherry", new Item(new Item.Settings()
            .food(ModFoodComponents.ENCHANTED_NETHERITE_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .maxCount(99)
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
    ));
    Item DEEPSLATE_EMERALD_CHERRY = register("deepslate_emerald_cherry", new Item(new Item.Settings()
            .food(ModFoodComponents.DEEPSLATE_EMERALD_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .maxCount(99)
    ));
    Item ENCHANTED_DEEPSLATE_EMERALD_CHERRY = register("enchanted_deepslate_emerald_cherry", new Item(new Item.Settings()
            .food(ModFoodComponents.ENCHANTED_DEEPSLATE_EMERALD_CHERRY_SETTINGS)
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

    SpawnEggItem GIANT_SPAWN_EGG = registerAsVanilla("giant_spawn_egg", new SpawnEggItem(EntityType.GIANT, 44993, 7969900, new Item.Settings().rarity(Rarity.EPIC)));
    SpawnEggItem ILLUSIONER_SPAWN_EGG = registerAsVanilla("illusioner_spawn_egg", new SpawnEggItem(EntityType.ILLUSIONER, 44543, 4500, new Item.Settings().rarity(Rarity.EPIC)));
    SpawnEggItem MONKEY_SPAWN_EGG = register("monkey_spawn_egg", new SpawnEggItem(ModEntityTypes.MONKEY, 2626304, 4532741, new Item.Settings()));

    RabbitTrinket RABBIT_TRINKET = register("rabbit_trinket", new RabbitTrinket(new Item.Settings()));
    FishTrinket FISH_TRINKET = register("fish_trinket", new FishTrinket(new Item.Settings()));
    CatTrinket CAT_TRINKET = register("cat_trinket", new CatTrinket(new Item.Settings()));
    Item BANANA = register("banana", new Item(new Item.Settings().food(ModFoodComponents.BANANA)));

    Item CREATIVE_NUGGET = register("creative_nugget", new Item(new Item.Settings()
            .fireproof()
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
    ));
    Item CREATIVE_INGOT = register("creative_ingot", new Item(new Item.Settings()
            .fireproof()
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
    ));

    BucketItem TROPICAL_WATER_BUCKET = register("tropical_water_bucket", new BucketItem(ModFluids.TROPICAL_WATER, new Item.Settings().maxCount(1)));

    static <T extends Item> T register(String name, T Item) {
        return Registry.register(Registries.ITEM, Blocktopia.id(name), Item);
    }
    static <T extends Item> T registerAsVanilla(String name, T Item) {
        return Registry.register(Registries.ITEM, Identifier.ofVanilla(name), Item);
    }

    static void load() {}
}
