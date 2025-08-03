package github.mcdatapack.blocktopia.item;

import com.google.common.collect.ImmutableList;
import java.util.Optional;

import github.mcdatapack.blocktopia.statuseffect.ModStatusEffects;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.HungerConstants;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;

public interface ModFoodComponents {
    FoodComponent COCONUT_SETTINGS = new Builder()
            .nutrition(10)
            .saturationModifier(1.0F)
            .alwaysEdible()
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickSecondConverter(10), 1), 1.0F)
            .build();
    FoodComponent GOLDEN_COCONUT_SETTINGS = new Builder()
            .nutrition(11)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(14)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickMinuteConverter(1), 2), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickMinuteConverter(4), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, tickMinuteConverter(3), 0), 1.0F)
            .build();
    FoodComponent ENCHANTED_GOLDEN_COCONUT_SETTINGS  = new Builder()
            .nutrition(12)
            .saturationModifier(1.0F)
            .alwaysEdible()
            .eatingTime(12)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickMinuteConverter(2), 4), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickMinuteConverter(5), 4), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, tickMinuteConverter(5), 2), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, tickMinuteConverter(4), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, tickMinuteConverter(4), 0), 1.0F)
            .build();
    FoodComponent ENCHANTED_GOLDEN_CARROT_SETTINGS = new Builder()
            .nutrition(6)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickSecondConverter(25), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, tickMinuteConverter(5), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, tickMinuteConverter(5), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickMinuteConverter(3), 3), 1.0F)
            .build();
    FoodComponent GOLDEN_POTATO_SETTINGS  = new Builder()
            .nutrition(3)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickSecondConverter(5), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickMinuteConverter(4), 0), 1.0F)
            .build();
    FoodComponent ENCHANTED_GOLDEN_POTATO_SETTINGS = new Builder()
            .nutrition(6)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickSecondConverter(25), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, tickMinuteConverter(5), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, tickMinuteConverter(5), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickMinuteConverter(3), 3), 1.0F)
            .build();
    FoodComponent GOLDEN_BAKED_POTATO_SETTINGS = new Builder()
            .nutrition(8)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickSecondConverter(5), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickMinuteConverter(4), 0), 1.0F)
            .build();
    FoodComponent ENCHANTED_GOLDEN_BAKED_POTATO_SETTINGS = new Builder()
            .nutrition(8)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickSecondConverter(25), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, tickMinuteConverter(5), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, tickMinuteConverter(5), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickMinuteConverter(3), 3), 1.0F)
            .build();

    FoodComponent CHERRY_SETTINGS = new Builder()
            .nutrition(6)
            .saturationModifier(0.5F)
            .alwaysEdible()
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickSecondConverter(25), 1), 1.0F)
            .build();
    FoodComponent GOLDEN_CHERRY_SETTINGS = new Builder()
            .nutrition(8)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(14)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickMinuteConverter(2), 2), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickMinuteConverter(6), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, tickMinuteConverter(6), 0), 1.0F)
            .build();
    FoodComponent ENCHANTED_GOLDEN_CHERRY_SETTINGS = new Builder()
            .nutrition(10)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(12)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickMinuteConverter(4), 3), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickMinuteConverter(8), 2), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, tickMinuteConverter(8), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, tickMinuteConverter(8), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, tickMinuteConverter(8), 0), 1.0F)
            .build();
    FoodComponent DIAMOND_CHERRY_SETTINGS = new Builder()
            .nutrition(12)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(10)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickMinuteConverter(5), 4), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, tickMinuteConverter(5), 3), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickMinuteConverter(10), 3), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, tickMinuteConverter(10), 2), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, tickMinuteConverter(10), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, tickMinuteConverter(10), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, tickHourConverter(1), 9), 1.0F)
            .build();
    FoodComponent ENCHANTED_DIAMOND_CHERRY_SETTINGS = new Builder()
            .nutrition(16)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(8)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickMinuteConverter(10), 8), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, tickMinuteConverter(10), 5), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickMinuteConverter(20), 5), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, tickMinuteConverter(20), 4), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, tickMinuteConverter(20), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, tickMinuteConverter(20), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, tickHourConverter(1.5), 9), 0.775F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, tickHourConverter(1.5), 4), 1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.XP_BOOST, tickMinuteConverter(2), 0), 1.0F)
            .build();
    FoodComponent NETHERITE_CHERRY_SETTINGS = new Builder()
            .nutrition(18)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(6)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickMinuteConverter(12), 9), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, tickMinuteConverter(12), 9), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickMinuteConverter(20), 9), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, tickMinuteConverter(20), 9), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, tickHourConverter(1), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, tickHourConverter(1), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, tickHourConverter(2), 9), 0.775F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, tickHourConverter(2), 4), 1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.XP_BOOST, tickMinuteConverter(10), 4), 1.0F)
            .build();
    FoodComponent ENCHANTED_NETHERITE_CHERRY_SETTINGS = new Builder()
            .nutrition(20)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(4)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickMinuteConverter(20), 14), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, tickMinuteConverter(20), 14), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickMinuteConverter(30), 14), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, tickMinuteConverter(30), 14), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, tickHourConverter(2), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, tickHourConverter(2), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, tickHourConverter(3), 9), 0.775F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, tickHourConverter(3), 9), 1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.XP_BOOST, tickMinuteConverter(25), 9), 1.0F)
            .build();
    FoodComponent DEEPSLATE_EMERALD_CHERRY_SETTINGS = new Builder()
            .nutrition(40)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(5)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickHourConverter(1), 16), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, tickHourConverter(1), 16), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickHourConverter(1), 16), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, tickHourConverter(1), 16), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, tickHourConverter(1), 16), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, tickHourConverter(4), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, tickHourConverter(4), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, tickHourConverter(6), 14), 0.775F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, tickHourConverter(6), 14), 1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.XP_BOOST, tickHourConverter(1), 14), 1.0F)
            .build();
    FoodComponent ENCHANTED_DEEPSLATE_EMERALD_CHERRY_SETTINGS = new Builder()
            .nutrition(100)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(5)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickHourConverter(2), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, tickHourConverter(2), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickHourConverter(2), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, tickHourConverter(2), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, tickHourConverter(2), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, tickHourConverter(10), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, tickHourConverter(10), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, tickHourConverter(10), 32), 0.775F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, tickHourConverter(10), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.XP_BOOST, tickHourConverter(2), 32), 1.0F)
            .build();
    FoodComponent END_DIAMOND_CHERRY_SETTINGS = new Builder()
            .nutrition(150)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(5)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickHourConverter(3), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, tickHourConverter(3), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickHourConverter(3), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, tickHourConverter(3), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, tickHourConverter(3), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, tickHourConverter(8), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, tickHourConverter(8), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, tickHourConverter(12), 14), 0.775F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, tickHourConverter(12), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.XP_BOOST, tickHourConverter(2), 32), 1.0F)
            .build();
    FoodComponent ENCHANTED_END_DIAMOND_CHERRY_SETTINGS = new Builder()
            .nutrition(300)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(5)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickHourConverter(6), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, tickHourConverter(6), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, tickHourConverter(6), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, tickHourConverter(6), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, tickHourConverter(6), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, tickHourConverter(16), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, tickHourConverter(16), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, tickHourConverter(24), 32), 0.775F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, tickHourConverter(24), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.XP_BOOST, tickHourConverter(4), 32), 1.0F)
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
            .eatingTime(1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 5), 1.0F)
            .build();
    FoodComponent RED_MUSHROOM_C0_0_20A_SETTINGS = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_REMOVE, 1, 3), 1.0F)
            .build();
    FoodComponent APPLE_IN20091231_2255 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 4), 1.0F)
            .build();
    FoodComponent APPLE_B1_8 = new Builder()
            .nutrition(4)
            .saturationModifier(1.0F)
            .build();
    FoodComponent MUSHROOM_STEW_IN20100130 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 8), 1.0F)
            .convertsTo(LegacyItems.BOWL_IN20100130)
            .build();
    FoodComponent BREAD_IN20100206 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 5), 1.0F)
            .build();
    FoodComponent BREAD_1_4 = new Builder()
            .nutrition(5)
            .saturationModifier(0.5F)
            .build();
    FoodComponent PORKCHOP_IN20100219 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 3), 1.0F)
            .build();
    FoodComponent PORKCHOP_1_4 = new Builder()
            .nutrition(3)
            .saturationModifier(0.5F)
            .build();
    FoodComponent COOKED_PORKCHOP_IN20100219 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 8), 1.0F)
            .build();
    FoodComponent COOKED_PORKCHOP_B1_8_AND_1_4 = new Builder()
            .nutrition(8)
            .saturationModifier(0.5F)
            .build();
    FoodComponent GOLDEN_APPLE_INF20100227 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 42), 1.0F)
            .build();
    FoodComponent COOKED_FISH_A1_2_0 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 5), 1.0F)
            .build();
    FoodComponent FISH_A1_2_0 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 2), 1.0F)
            .build();
    FoodComponent COOKIE_B1_4 = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .eatingTime(1.0F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HEALTH_ADD, 1, 1), 1.0F)
            .build();
    FoodComponent ENCHANTED_GOLDEN_APPLE_1_3 = new Builder()
            .nutrition(4)
            .saturationModifier(0.5F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, tickMinuteConverter(5), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, tickMinuteConverter(5), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, tickMinuteConverter(0.5), 4), 1.0F)
            .build();
    FoodComponent BAKED_POTATO_1_4 = new Builder()
            .nutrition(6)
            .saturationModifier(0.5F)
            .build();




    private static int tickSecondConverter(double seconds) {return (int) (seconds * 20);}
    private static int tickMinuteConverter(double minutes) {return (int) (minutes * 20 * 60);}
    private static int tickHourConverter(double hours) {return (int) (hours * 20 * 60 * 60);}



    class Builder {
        private int nutrition;
        private float saturationModifier;
        private boolean canAlwaysEat = false;
        private float eatSeconds = 1.6F;
        private Optional<ItemStack> usingConvertsTo = Optional.empty();
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
            this.canAlwaysEat = true;
            return this;
        }
        public Builder snack() {
            this.eatSeconds = 0.8F;
            return this;
        }
        public Builder eatingTime(float ticks) {
            this.eatSeconds = ticks/20;
            return this;
        }
        public Builder statusEffect(StatusEffectInstance effect, float chance) {
            this.effects.add(new FoodComponent.StatusEffectEntry(effect, chance));
            return this;
        }

        public Builder convertsTo(ItemConvertible item) {
            this.usingConvertsTo = Optional.of(new ItemStack(item));
            return this;
        }

        public FoodComponent build() {
            float f = HungerConstants.calculateSaturation(this.nutrition, this.saturationModifier);
            return new FoodComponent(this.nutrition, f, this.canAlwaysEat, this.eatSeconds, this.usingConvertsTo, this.effects.build());
        }
    }
}
