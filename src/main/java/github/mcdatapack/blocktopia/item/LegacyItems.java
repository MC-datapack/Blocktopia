package github.mcdatapack.blocktopia.item;

import github.mcdatapack.blocktopia.block.MinecraftVersion;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;
import java.util.function.Function;

import static github.mcdatapack.blocktopia.block.MinecraftVersions.*;

public interface LegacyItems {
    Item QUIVER_IN20091231_2255 = register("quiver_in20091231_2255", IN20091231_2255, IN20100122_1708);
    Item QUIVER_IN20100122_2251 = register("quiver_in20100122_2251", IN20100122_2251);
    Item APPLE_IN20091231_2255 = register("apple_in20091231_2255", settings -> settings.food(ModFoodComponents.APPLE_IN20091231_2255),
            IN20091231_2255, _1_3_2);
    Item APPLE_1_4 = register("apple_1_4", settings -> settings.food(ModFoodComponents.APPLE_B1_8), _1_4, _1_13_2);
    Item COAL_IN20100128 = register("coal_in20100128", IN20100128, IN20100218);
    Item COAL_IN20100219 = register("coal_in20100219", IN20100219, _1_2_5);
    Item COAL_1_3 = register("coal_1_3", _1_3, _1_13_2);
    Item DIAMOND_IN20100128 = register("diamond_in20100128", IN20100128, _1_2_5);
    Item DIAMOND_1_3 = register("diamond_1_3", _1_3, _1_13_2);
    Item GOLD_INGOT_IN20100128 = register("gold_ingot_in20100128", IN20100128);
    Item GOLD_INGOT_IN20100129 = register("gold_ingot_in20100129", IN20100129, _1_13_2);
    Item IRON_INGOT_IN20100128 = register("iron_ingot_in20100128", IN20100128);
    Item IRON_INGOT_IN20100129 = register("iron_ingot_in20100129", IN20100129, _1_13_2);
    Item BOWL_IN20100130 = register("bowl_in20100130", IN20100130, _1_13_2);
    Item MUSHROOM_STEW_IN20100130 = register("mushroom_stew_in20100130", settings -> settings.food(ModFoodComponents.MUSHROOM_STEW_IN20100130),
            IN20100130, _1_13_2);
    Item SULPHUR = register("sulphur", IN20100130, _1_13_2);
    Item STRING_IN20100130 = register("string_in20100130", IN20100130, _1_13_2);
    Item FEATHER_IN20100130 = register("feather_in20100130", IN20100130, IN20100205);
    Item FEATHER_IN20100206 = register("feather_in20100206", IN20100206, _1_13_2);
    Item BREAD_IN20100206 = register("bread_in20100206", settings -> settings.food(ModFoodComponents.BREAD_IN20100206), IN20100206, _1_3_2);
    Item BREAD_1_4 = register("bread_1_4", settings -> settings.food(ModFoodComponents.BREAD_1_4), _1_4, _1_13_2);
    Item WHEAT_IN20100206 = register("wheat_in20100206", IN20100206, _1_3_2);
    Item FLINT_IN20100219 = register("flint_in20100219", IN20100219, _1_2_5);
    Item FLINT_1_3 = register("flint_1_3", _1_3, _1_13_2);
    Item PORKCHOP_IN20100219 = register("porkchop_in20100219", settings -> settings.food(ModFoodComponents.PORKCHOP_IN20100219), IN20100219, _1_3_2);
    Item PORKCHOP_1_4 = register("porkchop_1_4", settings -> settings.food(ModFoodComponents.PORKCHOP_1_4),_1_4, _1_13_2);
    Item COOKED_PORKCHOP_IN20100219 = register("cooked_porkchop_in20100219", settings -> settings.food(ModFoodComponents.COOKED_PORKCHOP_IN20100219), IN20100219, B1_7_3);
    Item COOKED_PORKCHOP_B1_8 = register("cooked_porkchop_b1_8", settings -> settings.food(ModFoodComponents.COOKED_PORKCHOP_B1_8_AND_1_4), B1_8, _1_3_2);
    Item COOKED_PORKCHOP_1_4 = register("cooked_porkchop_1_4", settings -> settings.food(ModFoodComponents.COOKED_PORKCHOP_B1_8_AND_1_4), _1_4, _1_13_2);
    Item GOLDEN_APPLE_INF20100227 = register("golden_apple_inf20100227", settings -> settings.food(ModFoodComponents.GOLDEN_APPLE_INF20100227), INF20100227, _1_13_2);
    Item LEATHER_A1_0_8 = register("leather_a1_0_8", A1_0_8, _1_13_2);
    Item PAPER_A1_0_11 = register("paper_a1_0_11", A1_0_11, _1_13_2);
    Item BOOK_A1_0_11 = register("book_a1_0_11", A1_0_11, _1_13_2);
    Item CLAY_BALL_A1_0_11 = register("clay_ball_a1_0_11", A1_0_11, _1_13_2);
    Item BRICK_A1_0_11 = register("brick_a1_0_11", A1_0_11, _1_13_2);
    Item SLIMEBALL_A1_0_11 = register("slimeball_a1_0_11", A1_0_11, _1_13_2);
    Item GLOWSTONE_DUST_A1_2_0 = register("glowstone_dust_a1_2_0", A1_2_0, _1_13_2);
    Item FISH_A1_2_0 = register("fish_a1_2_0", settings -> settings.food(ModFoodComponents.FISH_A1_2_0), A1_2_0, _1_12_2);
    Item COOKED_FISH_A1_2_0 = register("cooked_fish_a1_2_0", settings -> settings.food(ModFoodComponents.COOKED_FISH_A1_2_0), A1_2_0, _1_12_2);
    Item BONE_B1_2 = register("bone_b1_2", B1_2, _1_13_2);
    BoneMealItem BONE_MEAL_B1_2 = ModItems.register("bone_meal_b1_2", new BoneMealItem(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            addLegacyTooltip(tooltip, B1_2, _1_2_5);
        }
    });
    BoneMealItem BONE_MEAL_1_3 = ModItems.register("bone_meal_1_3", new BoneMealItem(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            addLegacyTooltip(tooltip, B1_2, _1_2_5);
        }
    });
    Item COOKIE_B1_4 = register("cookie_b1_4", settings -> settings.food(ModFoodComponents.COOKIE_B1_4), B1_4, _1_13_2);
    Item CHICKEN_B1_8 = register("chicken_b1_8", settings -> settings.food(FoodComponents.CHICKEN), B1_8, _1_3_2);
    Item CHICKEN_1_4 = register("chicken_1_4", settings -> settings.food(FoodComponents.CHICKEN), _1_4, _1_13_2);
    Item COOKED_CHICKEN_B1_8 = register("cooked_chicken_b1_8", settings -> settings.food(FoodComponents.COOKED_CHICKEN), B1_8, _1_3_2);
    Item COOKED_CHICKEN_1_4 = register("cooked_chicken_1_4", settings -> settings.food(FoodComponents.COOKED_CHICKEN), _1_4, _1_13_2);
    Item BEEF_B1_8 = register("beef_b1_8", settings -> settings.food(FoodComponents.BEEF), B1_8, _1_2_5);
    Item BEEF_1_3 = register("beef_1_3", settings -> settings.food(FoodComponents.BEEF), _1_3, _1_3_2);
    Item BEEF_1_4 = register("beef_1_4", settings -> settings.food(FoodComponents.BEEF), _1_4, _1_13_2);
    Item COOKED_BEEF_B1_8 = register("cooked_beef_b1_8", settings -> settings.food(FoodComponents.COOKED_BEEF), B1_8, _1_2_5);
    Item COOKED_BEEF_1_3 = register("cooked_beef_1_3", settings -> settings.food(FoodComponents.COOKED_BEEF), _1_3, _1_3_2);
    Item COOKED_BEEF_1_4 = register("cooked_beef_1_4", settings -> settings.food(FoodComponents.COOKED_BEEF), _1_4, _1_13_2);
    Item ROTTEN_FLESH_B1_8 = register("rotten_flesh_b1_8", settings -> settings.food(FoodComponents.ROTTEN_FLESH), B1_8, _1_2_5);
    Item ROTTEN_FLESH_1_3 = register("rotten_flesh_1_3", settings -> settings.food(FoodComponents.ROTTEN_FLESH), _1_3, _1_13_2);
    Item GHAST_TEAR_B1_9PRE = register("ghast_tear_b1_9pre", B1_9PRE, _1_13_2);
    Item GOLD_NUGGET_B1_9PRE = register("gold_nugget_b1_9pre", B1_9PRE, _1_2_5);
    Item GOLD_NUGGET_1_3 = register("gold_nugget_1_3", _1_3, _1_13_2);
    Item BLAZE_POWDER_B1_9PRE2 = register("blaze_powder_b1_9pre2", B1_9PRE2, _1_2_5);
    Item FERMENTED_SPIDER_EYE_B1_9PRE2 = register("fermented_spider_eye_b1_9pre2", B1_9PRE2, _1_13_2);
    Item MAGMA_CREAM_B1_9PRE2 = register("magma_cream_b1_9pre2", B1_9PRE2, _1_2_5);
    Item MAGMA_CREAM_1_3 = register("magma_cream_1_3", _1_3, _1_13_2);
    Item SPIDER_EYE_B1_9PRE2 = register("spider_eye_b1_9pre2", B1_9PRE2, _1_13_2);
    Item GLISTERING_MELON_B1_9PRE4 = register("glistering_melon_b1_9pre4", B1_9PRE4, _1_13_2);
    Item RUBY = ModItems.register("ruby", new Item(new Item.Settings()));
    Item EMERALD_1_3 = register("emerald_1_3", _1_3, _1_13_2);
    Item ENCHANTED_GOLDEN_APPLE_1_3 = register("enchanted_golden_apple_1_3", settings ->
            settings.food(ModFoodComponents.ENCHANTED_GOLDEN_APPLE_1_3).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true), _1_3, _1_13_2);
    Item GOLDEN_CARROT_1_4 = register("golden_carrot_1_4", settings -> settings.food(FoodComponents.GOLDEN_CARROT), _1_4, _1_13_2);
    Item BAKED_POTATO_1_4 = register("baked_potato_1_4", settings -> settings.food(ModFoodComponents.BAKED_POTATO_1_4), _1_4, _1_13_2);
    Item POISONOUS_POTATO_1_4 = register("poisonous_potato_1_4", settings -> settings.food(FoodComponents.POISONOUS_POTATO), _1_4, _1_13_2);
    Item NETHER_STAR_1_4 = register("nether_star_1_4", settings -> settings.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true), _1_4, _1_13_2);
    Item PUMPKIN_PIE_1_4 = register("pumpkin_pie_1_4", settings -> settings.food(FoodComponents.PUMPKIN_PIE), _1_4, _1_13_2);
    Item QUARTZ_1_5 = register("quartz_1_5", _1_5, _1_13_2);
    Item CLOWNFISH_1_7 = register("clownfish_1_7", settings -> settings.food(FoodComponents.TROPICAL_FISH), _1_7, _1_12_2);
    Item SALMON_1_7 = register("salmon_1_7", settings -> settings.food(FoodComponents.SALMON), _1_7, _1_12_2);
    Item COOKED_SALMON_1_7 = register("cooked_salmon_1_7", settings -> settings.food(FoodComponents.COOKED_SALMON), _1_7, _1_12_2);
    Item PUFFERFISH_1_7 = register("pufferfish_1_7", settings -> settings.food(FoodComponents.PUFFERFISH), _1_7, _1_12_2);
    Item PRISMARINE_CRYSTAL_1_8 = register("prismarine_crystal_1_8", _1_8, _1_13_2);
    Item PRISMARINE_SHARD_1_8 = register("prismarine_shard_1_8", _1_8, _1_13_2);
    Item MUTTON_1_8 = register("mutton_1_8", settings -> settings.food(FoodComponents.MUTTON), _1_8, _1_12_2);
    Item COOKED_MUTTON_1_8 = register("cooked_mutton_1_8", settings -> settings.food(FoodComponents.COOKED_MUTTON), _1_8, _1_12_2);
    Item RABBIT_1_8 = register("rabbit_1_8", settings -> settings.food(FoodComponents.RABBIT), _1_8, _1_12_2);
    Item COOKED_RABBIT_1_8 = register("cooked_rabbit_1_8", settings -> settings.food(FoodComponents.COOKED_RABBIT), _1_8, _1_12_2);
    Item RABBIT_FOOT_1_8 = register("rabbit_foot_1_8", _1_8, _1_13_2);
    Item RABBIT_HIDE_1_8 = register("rabbit_hide_1_8", _1_8, _1_13_2);
    Item RABBIT_STEW_1_8 = register("rabbit_stew_1_8", settings -> settings.food(FoodComponents.RABBIT_STEW), _1_8, _1_13_2);


    private static Item register(String name, MinecraftVersion from, MinecraftVersion to) {
        return register(name, settings -> settings, from, to);
    }

    private static Item register(String name, MinecraftVersion only) {
        return register(name, settings -> settings, only);
    }

    private static Item register(String name, Function<Item.Settings, Item.Settings> settings, MinecraftVersion from, MinecraftVersion to) {
        return ModItems.register(name, new Item(settings.apply(new Item.Settings())) {
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                addLegacyTooltip(tooltip, from, to);
            }
        });
    }

    private static Item register(String name, Function<Item.Settings, Item.Settings> settings, MinecraftVersion only) {
        return ModItems.register(name, new Item(settings.apply(new Item.Settings())) {
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("blocktopia.tooltip.legacy"));
                tooltip.add(Text.literal(only.getName()));
            }
        });
    }

    private static void addLegacyTooltip(List<Text> tooltip, MinecraftVersion from, MinecraftVersion to) {
        tooltip.add(Text.translatable("blocktopia.tooltip.legacy"));
        tooltip.add(Text.literal(from.getName() + " - " + to.getName()));
    }

    static void load() {}
}
