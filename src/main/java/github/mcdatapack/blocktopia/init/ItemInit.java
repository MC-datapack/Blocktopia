package github.mcdatapack.blocktopia.init;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import github.mcdatapack.blocktopia.item.FishTrinket;
import github.mcdatapack.blocktopia.item.RabbitTrinket;
import github.mcdatapack.blocktopia.list.FoodList;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;

public class ItemInit {
    public static final Item COCONUT = register("coconut", new Item(new Item.Settings().food(FoodList.COCONUT_SETTINGS).rarity(Rarity.UNCOMMON)));
    public static final Item GOLDEN_COCONUT = register("golden_coconut", new Item(new Item.Settings().food(FoodList.GOLDEN_COCONUT_SETTINGS).rarity(Rarity.RARE)));
    public static final Item ENCHANTED_GOLDEN_COCONUT = register("enchanted_golden_coconut", new Item(new Item.Settings().food(FoodList.ENCHANTED_GOLDEN_COCONUT_SETTINGS).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).rarity(Rarity.EPIC)));
    public static final Item ENCHANTED_GOLDEN_CARROT = register("enchanted_golden_carrot", new Item(new Item.Settings().food(FoodList.ENCHANTED_GOLDEN_CARROT_SETTINGS).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).rarity(Rarity.EPIC)));
    public static final Item GOLDEN_POTATO = register("golden_potato", new Item(new Item.Settings().food(FoodList.GOLDEN_POTATO_SETTINGS).rarity(Rarity.RARE)));
    public static final Item ENCHANTED_GOLDEN_POTATO = register("enchanted_golden_potato", new Item(new Item.Settings().food(FoodList.ENCHANTED_GOLDEN_POTATO_SETTINGS).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).rarity(Rarity.EPIC)));
    public static final Item GOLDEN_BAKED_POTATO = register("golden_baked_potato", new Item(new Item.Settings().food(FoodList.GOLDEN_BAKED_POTATO_SETTINGS).rarity(Rarity.RARE)));
    public static final Item ENCHANTED_GOLDEN_BAKED_POTATO = register("enchanted_golden_baked_potato", new Item(new Item.Settings().food(FoodList.ENCHANTED_GOLDEN_BAKED_POTATO_SETTINGS).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).rarity(Rarity.EPIC)));
    public static final Item CHERRY = register("cherry", new Item(new Item.Settings()
            .food(FoodList.CHERRY_SETTINGS)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final Item GOLDEN_CHERRY = register("golden_cherry", new Item(new Item.Settings()
            .food(FoodList.GOLDEN_CHERRY_SETTINGS)
            .rarity(Rarity.RARE)
    ));
    public static final Item ENCHANTED_GOLDEN_CHERRY = register("enchanted_golden_cherry", new Item(new Item.Settings()
            .food(FoodList.ENCHANTED_GOLDEN_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
    ));
    public static final Item DIAMOND_CHERRY = register("diamond_cherry", new Item(new Item.Settings()
            .food(FoodList.DIAMOND_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
    ));
    public static final Item ENCHANTED_DIAMOND_CHERRY = register("enchanted_diamond_cherry", new Item(new Item.Settings()
            .food(FoodList.ENCHANTED_DIAMOND_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
    ));
    public static final Item NETHERITE_CHERRY = register("netherite_cherry", new Item(new Item.Settings()
            .food(FoodList.NETHERITE_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .maxCount(99)
    ));
    public static final Item ENCHANTED_NETHERITE_CHERRY = register("enchanted_netherite_cherry", new Item(new Item.Settings()
            .food(FoodList.ENCHANTED_NETHERITE_CHERRY_SETTINGS)
            .rarity(Rarity.EPIC)
            .maxCount(99)
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
    ));
    public static final Item PALM_BOAT = TerraformBoatItemHelper.registerBoatItem(BoatInit.PALM_BOAT_ID, BoatInit.PALM_BOAT_KEY, false);
    public static final Item PALM_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(BoatInit.PALM_CHEST_BOAT_ID, BoatInit.PALM_BOAT_KEY, true);
    public static final Item BANANA_BOAT = TerraformBoatItemHelper.registerBoatItem(BoatInit.BANANA_BOAT_ID, BoatInit.BANANA_BOAT_KEY, false);
    public static final Item BANANA_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(BoatInit.BANANA_CHEST_BOAT_ID, BoatInit.BANANA_BOAT_KEY, true);
    public static final Item CORN_BOAT = TerraformBoatItemHelper.registerBoatItem(BoatInit.CORN_BOAT_ID, BoatInit.CORN_BOAT_KEY, false);
    public static final Item CORN_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(BoatInit.CORN_CHEST_BOAT_ID, BoatInit.CORN_BOAT_KEY, true);
    public static final Item POISONED_BOAT = TerraformBoatItemHelper.registerBoatItem(BoatInit.POISONED_BOAT_ID, BoatInit.POISONED_BOAT_KEY, false);
    public static final Item POISONED_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(BoatInit.POISONED_CHEST_BOAT_ID, BoatInit.POISONED_BOAT_KEY, true);
    public static final Item TORCH_IN20100124_2 = register("torch_in20100124_2", new VerticallyAttachableBlockItem(LegacyBlocks.TORCH_IN20100124_2, LegacyBlocks.WALL_TORCH_IN20100124_2, new Item.Settings(), Direction.DOWN));
    public static final Item REDSTONE_TORCH_A1_0_1 = register("redstone_torch_a1_0_1", new VerticallyAttachableBlockItem(LegacyBlocks.REDSTONE_TORCH_A1_0_1, LegacyBlocks.REDSTONE_WALL_TORCH_A1_0_1, new Item.Settings(), Direction.DOWN));

    public static final SpawnEggItem GIANT_SPAWN_EGG = registerAsVanilla("giant_spawn_egg", new SpawnEggItem(EntityType.GIANT, 44993, 7969900, new Item.Settings().rarity(Rarity.EPIC)));
    public static final SpawnEggItem ILLUSIONER_SPAWN_EGG = registerAsVanilla("illusioner_spawn_egg", new SpawnEggItem(EntityType.ILLUSIONER, 44543, 4500, new Item.Settings().rarity(Rarity.EPIC)));
    public static final SpawnEggItem MONKEY_SPAWN_EGG = register("monkey_spawn_egg", new SpawnEggItem(EntityInit.MONKEY, 2626304, 4532741, new Item.Settings()));

    public static final RabbitTrinket RABBIT_TRINKET = register("rabbit_trinket", new RabbitTrinket(new Item.Settings()));
    public static final FishTrinket FISH_TRINKET = register("fish_trinket", new FishTrinket(new Item.Settings()));
    public static final Item BANANA = register("banana", new Item(new Item.Settings().food(FoodList.BANANA)));

    public static final BucketItem TROPICAL_WATER_BUCKET = register("tropical_water_bucket", new BucketItem(FluidInit.TROPICAL_WATER, new Item.Settings().maxCount(1)));

    public static <T extends Item> T register(String name, T Item) {
        return Registry.register(Registries.ITEM, Blocktopia.id(name), Item);
    }
    public static <T extends Item> T registerAsVanilla(String name, T Item) {
        return Registry.register(Registries.ITEM, Identifier.ofVanilla(name), Item);
    }

    public static void load() {}
}
