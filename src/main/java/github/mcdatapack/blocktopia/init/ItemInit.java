package github.mcdatapack.blocktopia.init;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.boat.api.item.BlocktopiaBoatItemHelper;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import github.mcdatapack.blocktopia.list.FoodList;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;

import java.awt.*;

public class ItemInit {
    public static final Item COCONUT = register("coconut", new Item(new Item.Settings().food(FoodList.COCONUT_SETTINGS).rarity(Rarity.UNCOMMON)));
    public static final Item GOLDEN_COCONUT = register("golden_coconut", new Item(new Item.Settings().food(FoodList.GOLDEN_COCONUT_SETTINGS).rarity(Rarity.RARE)));
    public static final Item ENCHANTED_GOLDEN_COCONUT = register("enchanted_golden_coconut", new Item(new Item.Settings().food(FoodList.ENCHANTED_GOLDEN_COCONUT_SETTINGS).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).rarity(Rarity.EPIC)));
    public static final Item ENCHANTED_GOLDEN_CARROT = register("enchanted_golden_carrot", new Item(new Item.Settings().food(FoodList.ENCHANTED_GOLDEN_CARROT_SETTINGS).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).rarity(Rarity.EPIC)));
    public static final Item GOLDEN_POTATO = register("golden_potato", new Item(new Item.Settings().food(FoodList.GOLDEN_POTATO_SETTINGS).rarity(Rarity.RARE)));
    public static final Item ENCHANTED_GOLDEN_POTATO = register("enchanted_golden_potato", new Item(new Item.Settings().food(FoodList.ENCHANTED_GOLDEN_POTATO_SETTINGS).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).rarity(Rarity.EPIC)));
    public static final Item GOLDEN_BAKED_POTATO = register("golden_baked_potato", new Item(new Item.Settings().food(FoodList.GOLDEN_BAKED_POTATO_SETTINGS).rarity(Rarity.RARE)));
    public static final Item ENCHANTED_GOLDEN_BAKED_POTATO = register("enchanted_golden_baked_potato", new Item(new Item.Settings().food(FoodList.ENCHANTED_GOLDEN_BAKED_POTATO_SETTINGS).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).rarity(Rarity.EPIC)));
    public static final SignItem PALM_SIGN = register("palm_sign", new SignItem(new Item.Settings().maxCount(16), BlockInit.PALM_SIGN, BlockInit.PALM_WALL_SIGN));
    public static final HangingSignItem PALM_HANGING_SIGN = register("palm_hanging_sign", new HangingSignItem(BlockInit.PALM_HANGING_SIGN, BlockInit.PALM_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));
    public static final Item PALM_BOAT = BlocktopiaBoatItemHelper.registerBoatItem(BoatInit.PALM_BOAT_ID, BoatInit.PALM_BOAT_KEY, false);
    public static final Item PALM_CHEST_BOAT = BlocktopiaBoatItemHelper.registerBoatItem(BoatInit.PALM_CHEST_BOAT_ID, BoatInit.PALM_BOAT_KEY, true);
    public static final Item TORCH_IN20100124_2 = register("torch_in20100124_2", new VerticallyAttachableBlockItem(LegacyBlocks.TORCH_IN20100124_2, LegacyBlocks.WALL_TORCH_IN20100124_2, new Item.Settings(), Direction.DOWN));
    public static final SignItem SIGN_INF20100607 = register("sign_inf20100607", new SignItem(new Item.Settings().maxCount(16), LegacyBlocks.SIGN_INF20100607, LegacyBlocks.WALL_SIGN_INF20100607));
    public static final Item REDSTONE_TORCH_A1_0_1 = register("redstone_torch_a1_0_1", new VerticallyAttachableBlockItem(LegacyBlocks.REDSTONE_TORCH_A1_0_1, LegacyBlocks.REDSTONE_WALL_TORCH_A1_0_1, new Item.Settings(), Direction.DOWN));
    public static final SpawnEggItem GIANT_SPAWN_EGG = registerAsVanilla("giant_spawn_egg", new SpawnEggItem(EntityType.GIANT, 44993, 7969900, new Item.Settings().rarity(Rarity.EPIC)));
    public static final SpawnEggItem ILLUSIONER_SPAWN_EGG = registerAsVanilla("illusioner_spawn_egg", new SpawnEggItem(EntityType.ILLUSIONER, 44543, 4500, new Item.Settings().rarity(Rarity.EPIC)));

    public static <T extends Item> T register(String name, T Item) {
        return Registry.register(Registries.ITEM, Blocktopia.id(name), Item);
    }
    public static <T extends Item> T registerAsVanilla(String name, T Item) {
        return Registry.register(Registries.ITEM, Blocktopia.idMinecraft(name), Item);
    }

    public static void load() {}
}
