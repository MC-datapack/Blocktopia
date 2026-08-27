package github.mcdatapack.blocktopia.item;

import com.google.common.collect.ImmutableList;

import github.mcdatapack.blocktopia.statuseffect.ModStatusEffects;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.HungerConstants;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public interface ModFoodComponents {
    FoodComponent COCONUT_SETTINGS = new Builder()
            .nutrition(10)
            .saturationModifier(1.0F)
            .alwaysEdible()
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, seconds(10), 1))
            .build();
    FoodComponent GOLDEN_COCONUT_SETTINGS = new Builder()
            .nutrition(11)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(14)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, minutes(1), 2))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, minutes(4), 1))
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, minutes(3), 0))
            .build();
    FoodComponent ENCHANTED_GOLDEN_COCONUT_SETTINGS  = new Builder()
            .nutrition(12)
            .saturationModifier(1.0F)
            .alwaysEdible()
            .eatingTime(12)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, minutes(2), 4))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, minutes(5), 4))
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, minutes(5), 2))
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, minutes(4), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, minutes(4), 0))
            .build();
    FoodComponent ENCHANTED_GOLDEN_CARROT_SETTINGS = new Builder()
            .nutrition(6)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, seconds(25), 1))
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, minutes(5), 1))
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, minutes(5), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, minutes(3), 3))
            .build();
    FoodComponent GOLDEN_POTATO_SETTINGS  = new Builder()
            .nutrition(3)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, seconds(5), 1))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, minutes(4), 0))
            .build();
    FoodComponent ENCHANTED_GOLDEN_POTATO_SETTINGS = new Builder()
            .nutrition(6)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, seconds(25), 1))
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, minutes(5), 1))
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, minutes(5), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, minutes(3), 3))
            .build();
    FoodComponent GOLDEN_BAKED_POTATO_SETTINGS = new Builder()
            .nutrition(8)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, seconds(5), 1))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, minutes(4), 0))
            .build();
    FoodComponent ENCHANTED_GOLDEN_BAKED_POTATO_SETTINGS = new Builder()
            .nutrition(8)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, seconds(25), 1))
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, minutes(5), 1))
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, minutes(5), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, minutes(3), 3))
            .build();

    FoodComponent CHERRY_SETTINGS = new Builder()
            .nutrition(6)
            .saturationModifier(0.5F)
            .alwaysEdible()
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, seconds(25), 1))
            .build();
    FoodComponent GOLDEN_CHERRY_SETTINGS = new Builder()
            .nutrition(8)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(14)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, minutes(1), 2))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, minutes(4), 1))
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, minutes(4), 0))
            .build();
    FoodComponent ENCHANTED_GOLDEN_CHERRY_SETTINGS = new Builder()
            .nutrition(10)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(12)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, minutes(2), 3))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, minutes(8), 2))
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, minutes(8), 1))
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, minutes(8), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, minutes(8), 0))
            .build();
    FoodComponent DIAMOND_CHERRY_SETTINGS = new Builder()
            .nutrition(12)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(10)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, minutes(4), 4))
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, minutes(4), 3))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, minutes(10), 3))
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, minutes(10), 2))
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, minutes(10), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, minutes(10), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, minutes(10), 9))
            .build();
    FoodComponent ENCHANTED_DIAMOND_CHERRY_SETTINGS = new Builder()
            .nutrition(16)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(8)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, minutes(10), 6))
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, minutes(10), 5))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, minutes(20), 5))
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, minutes(20), 3))
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, minutes(20), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, minutes(20), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, minutes(20), 9))
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, minutes(20), 4))
            .statusEffect(new StatusEffectInstance(ModStatusEffects.XP_BOOST, minutes(2), 0))
            .build();
    FoodComponent NETHERITE_CHERRY_SETTINGS = new Builder()
            .nutrition(18)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(6)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, minutes(12), 7))
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, minutes(12), 6))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, minutes(20), 7))
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, minutes(20), 3))
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, hours(1), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, hours(1), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, hours(1), 9))
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, hours(1), 4))
            .statusEffect(new StatusEffectInstance(ModStatusEffects.XP_BOOST, minutes(10), 2))
            .build();
    FoodComponent ENCHANTED_NETHERITE_CHERRY_SETTINGS = new Builder()
            .nutrition(20)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(4)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, minutes(20), 9))
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, minutes(20), 9))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, minutes(30), 9))
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, minutes(30), 3))
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, hours(1.5), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, hours(1.5), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, hours(1.5), 9))
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, hours(1.5), 6))
            .statusEffect(new StatusEffectInstance(ModStatusEffects.XP_BOOST, minutes(25), 4))
            .build();
    FoodComponent DEEPSLATE_EMERALD_CHERRY_SETTINGS = new Builder()
            .nutrition(40)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(5)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, hours(1), 14))
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, hours(1), 14))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, hours(1), 14))
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, hours(1), 14))
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, hours(1), 3))
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, hours(4), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, hours(4), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, hours(4), 14))
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, hours(4), 9))
            .statusEffect(new StatusEffectInstance(ModStatusEffects.XP_BOOST, minutes(30), 7))
            .build();
    FoodComponent ENCHANTED_DEEPSLATE_EMERALD_CHERRY_SETTINGS = new Builder()
            .nutrition(100)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(5)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, hours(2), 19))
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, hours(2), 19))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, hours(2), 19))
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, hours(2), 19))
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, hours(2), 3))
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, hours(3), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, hours(3), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, hours(3), 19))
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, hours(3), 14))
            .statusEffect(new StatusEffectInstance(ModStatusEffects.XP_BOOST, hours(1), 9))
            .build();
    FoodComponent END_DIAMOND_CHERRY_SETTINGS = new Builder()
            .nutrition(150)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(5)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, hours(3), 24))
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, hours(3), 24))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, hours(3), 24))
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, hours(3), 24))
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, hours(3), 3))
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, hours(5), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, hours(5), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, hours(5), 24))
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, hours(5), 19))
            .statusEffect(new StatusEffectInstance(ModStatusEffects.XP_BOOST, hours(1.5), 14))
            .build();
    FoodComponent ENCHANTED_END_DIAMOND_CHERRY_SETTINGS = new Builder()
            .nutrition(300)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(5)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, hours(6), 29))
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, hours(6), 29))
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, hours(6), 29))
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, hours(6), 29))
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, hours(6), 3))
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, hours(10), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, hours(10), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, hours(10), 29))
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, hours(10), 24))
            .statusEffect(new StatusEffectInstance(ModStatusEffects.XP_BOOST, hours(3), 19))
            .build();
    FoodComponent BANANA = new Builder()
            .nutrition(5)
            .saturationModifier(0.5F)
            .alwaysEdible()
            .eatingTime(64)
            .build();




    FoodComponent BROWN_MUSHROOM_C0_0_20A_SETTINGS = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(2)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 5))
            .build();
    FoodComponent RED_MUSHROOM_C0_0_20A_SETTINGS = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_REMOVE, 1, 3))
            .build();
    FoodComponent APPLE_IN20091231_2255 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(2)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 4))
            .build();
    FoodComponent APPLE_B1_8 = new Builder()
            .nutrition(4)
            .saturationModifier(1.0F)
            .build();
    FoodComponent MUSHROOM_STEW_IN20100130 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(2)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 8))
            .convertsTo(LegacyItems.BOWL_IN20100130)
            .build();
    FoodComponent BREAD_IN20100206 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(2)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 5))
            .build();
    FoodComponent BREAD_1_4 = new Builder()
            .nutrition(5)
            .saturationModifier(0.5F)
            .build();
    FoodComponent PORKCHOP_IN20100219 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(2)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 3))
            .build();
    FoodComponent PORKCHOP_1_4 = new Builder()
            .nutrition(3)
            .saturationModifier(0.5F)
            .build();
    FoodComponent COOKED_PORKCHOP_IN20100219 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(2)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 8))
            .build();
    FoodComponent COOKED_PORKCHOP_B1_8_AND_1_4 = new Builder()
            .nutrition(8)
            .saturationModifier(0.5F)
            .build();
    FoodComponent GOLDEN_APPLE_INF20100227 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(2)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 42))
            .build();
    FoodComponent COOKED_FISH_A1_2_0 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(2)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 5))
            .build();
    FoodComponent FISH_A1_2_0 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(2)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 2))
            .build();
    FoodComponent COOKIE_B1_4 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(2)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 1))
            .build();
    FoodComponent ENCHANTED_GOLDEN_APPLE_1_3 = new Builder()
            .nutrition(4)
            .saturationModifier(0.5F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, minutes(5), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, minutes(5), 0))
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, minutes(0.5), 4))
            .build();
    FoodComponent BAKED_POTATO_1_4 = new Builder()
            .nutrition(6)
            .saturationModifier(0.5F)
            .build();




    private static int seconds(double seconds) {return (int) (seconds * 20);}
    private static int minutes(double minutes) {return (int) (minutes * 20 * 60);}
    private static int hours(double hours) {return (int) (hours * 20 * 60 * 60);}



    class Builder {
        private int nutrition;
        private float saturationModifier;
        private boolean canAlwaysEat = false;
        private float eatSeconds = 1.6F;
        @Nullable private ItemStack convertsTo = null;
        private final ImmutableList.Builder<FoodComponent.StatusEffectEntry> effects = ImmutableList.builder();
        public Builder nutrition(int nutrition) {
            this.nutrition = nutrition;
            return this;
        }
        public Builder saturationModifier(float saturationModifier) {
            this.saturationModifier = saturationModifier;
            return this;
        }
        public Builder alwaysEdible() {
            canAlwaysEat = true;
            return this;
        }
        public Builder snack() {
            eatSeconds = 0.8F;
            return this;
        }
        public Builder eatingTime(float ticks) {
            eatSeconds = ticks/20;
            return this;
        }
        public Builder statusEffect(StatusEffectInstance effect) {
            effects.add(new FoodComponent.StatusEffectEntry(effect, 1));
            return this;
        }

        public Builder convertsTo(ItemConvertible item) {
            convertsTo = new ItemStack(item);
            return this;
        }

        public FoodComponent build() {
            float f = HungerConstants.calculateSaturation(nutrition, saturationModifier);
            return new FoodComponent(nutrition, f, canAlwaysEat, eatSeconds, Optional.ofNullable(convertsTo), effects.build());
        }
    }
}
