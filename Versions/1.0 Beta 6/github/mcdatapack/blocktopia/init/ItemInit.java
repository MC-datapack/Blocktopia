package github.mcdatapack.blocktopia.init;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.boat.api.item.BlocktopiaBoatItemHelper;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import github.mcdatapack.blocktopia.list.FoodList;
import net.minecraft.class_1299;
import net.minecraft.class_1792;
import net.minecraft.class_1814;
import net.minecraft.class_1822;
import net.minecraft.class_1826;
import net.minecraft.class_1827;
import net.minecraft.class_2350;
import net.minecraft.class_2378;
import net.minecraft.class_7707;
import net.minecraft.class_7923;
import net.minecraft.class_9334;
import net.minecraft.item.*;
import java.awt.*;

public class ItemInit {
    public static final class_1792 COCONUT = register("coconut", new class_1792(new class_1792.class_1793().method_19265(FoodList.COCONUT_SETTINGS).method_7894(class_1814.field_8907)));
    public static final class_1792 GOLDEN_COCONUT = register("golden_coconut", new class_1792(new class_1792.class_1793().method_19265(FoodList.GOLDEN_COCONUT_SETTINGS).method_7894(class_1814.field_8903)));
    public static final class_1792 ENCHANTED_GOLDEN_COCONUT = register("enchanted_golden_coconut", new class_1792(new class_1792.class_1793().method_19265(FoodList.ENCHANTED_GOLDEN_COCONUT_SETTINGS).method_57349(class_9334.field_49641, true).method_7894(class_1814.field_8904)));
    public static final class_1792 ENCHANTED_GOLDEN_CARROT = register("enchanted_golden_carrot", new class_1792(new class_1792.class_1793().method_19265(FoodList.ENCHANTED_GOLDEN_CARROT_SETTINGS).method_57349(class_9334.field_49641, true).method_7894(class_1814.field_8904)));
    public static final class_1792 GOLDEN_POTATO = register("golden_potato", new class_1792(new class_1792.class_1793().method_19265(FoodList.GOLDEN_POTATO_SETTINGS).method_7894(class_1814.field_8903)));
    public static final class_1792 ENCHANTED_GOLDEN_POTATO = register("enchanted_golden_potato", new class_1792(new class_1792.class_1793().method_19265(FoodList.ENCHANTED_GOLDEN_POTATO_SETTINGS).method_57349(class_9334.field_49641, true).method_7894(class_1814.field_8904)));
    public static final class_1792 GOLDEN_BAKED_POTATO = register("golden_baked_potato", new class_1792(new class_1792.class_1793().method_19265(FoodList.GOLDEN_BAKED_POTATO_SETTINGS).method_7894(class_1814.field_8903)));
    public static final class_1792 ENCHANTED_GOLDEN_BAKED_POTATO = register("enchanted_golden_baked_potato", new class_1792(new class_1792.class_1793().method_19265(FoodList.ENCHANTED_GOLDEN_BAKED_POTATO_SETTINGS).method_57349(class_9334.field_49641, true).method_7894(class_1814.field_8904)));
    public static final class_1822 PALM_SIGN = register("palm_sign", new class_1822(new class_1792.class_1793().method_7889(16), BlockInit.PALM_SIGN, BlockInit.PALM_WALL_SIGN));
    public static final class_7707 PALM_HANGING_SIGN = register("palm_hanging_sign", new class_7707(BlockInit.PALM_HANGING_SIGN, BlockInit.PALM_WALL_HANGING_SIGN, new class_1792.class_1793().method_7889(16)));
    public static final class_1792 PALM_BOAT = BlocktopiaBoatItemHelper.registerBoatItem(BoatInit.PALM_BOAT_ID, BoatInit.PALM_BOAT_KEY, false);
    public static final class_1792 PALM_CHEST_BOAT = BlocktopiaBoatItemHelper.registerBoatItem(BoatInit.PALM_CHEST_BOAT_ID, BoatInit.PALM_BOAT_KEY, true);
    public static final class_1792 TORCH_IN20100124_2 = register("torch_in20100124_2", new class_1827(LegacyBlocks.TORCH_IN20100124_2, LegacyBlocks.WALL_TORCH_IN20100124_2, new class_1792.class_1793(), class_2350.field_11033));
    public static final class_1822 SIGN_INF20100607 = register("sign_inf20100607", new class_1822(new class_1792.class_1793().method_7889(16), LegacyBlocks.SIGN_INF20100607, LegacyBlocks.WALL_SIGN_INF20100607));
    public static final class_1792 REDSTONE_TORCH_A1_0_1 = register("redstone_torch_a1_0_1", new class_1827(LegacyBlocks.REDSTONE_TORCH_A1_0_1, LegacyBlocks.REDSTONE_WALL_TORCH_A1_0_1, new class_1792.class_1793(), class_2350.field_11033));
    public static final class_1826 GIANT_SPAWN_EGG = registerAsVanilla("giant_spawn_egg", new class_1826(class_1299.field_6095, 44993, 7969900, new class_1792.class_1793().method_7894(class_1814.field_8904)));
    public static final class_1826 ILLUSIONER_SPAWN_EGG = registerAsVanilla("illusioner_spawn_egg", new class_1826(class_1299.field_6065, 44543, 4500, new class_1792.class_1793().method_7894(class_1814.field_8904)));

    public static <T extends class_1792> T register(String name, T Item) {
        return class_2378.method_10230(class_7923.field_41178, Blocktopia.id(name), Item);
    }
    public static <T extends class_1792> T registerAsVanilla(String name, T Item) {
        return class_2378.method_10230(class_7923.field_41178, Blocktopia.idMinecraft(name), Item);
    }

    public static void load() {}
}
