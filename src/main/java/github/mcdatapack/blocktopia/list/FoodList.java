package github.mcdatapack.blocktopia.list;

import com.google.common.collect.ImmutableList;
import java.util.Optional;

import github.mcdatapack.blocktopia.init.StatusEffectInit;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.HungerConstants;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;

public class FoodList {
    public static final FoodComponent COCONUT_SETTINGS = new Builder()
            .nutrition(10).
            saturationModifier(1.0F).
            alwaysEdible()
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickSecondConverter(10), 1), 1.0F)
            .build();
    public static final FoodComponent GOLDEN_COCONUT_SETTINGS = new Builder()
            .nutrition(11)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(14)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickMinuteConverter(1), 2), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, TickMinuteConverter(4), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, TickMinuteConverter(3), 0), 1.0F)
            .build();
    public static final FoodComponent ENCHANTED_GOLDEN_COCONUT_SETTINGS  = new Builder()
            .nutrition(12)
            .saturationModifier(1.0F)
            .alwaysEdible()
            .eatingTime(12)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickMinuteConverter(2), 4), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, TickMinuteConverter(5), 4), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, TickMinuteConverter(5), 2), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, TickMinuteConverter(4), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, TickMinuteConverter(4), 0), 1.0F)
            .build();
    public static final FoodComponent ENCHANTED_GOLDEN_CARROT_SETTINGS = new Builder()
            .nutrition(6)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickSecondConverter(25), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, TickMinuteConverter(5), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, TickMinuteConverter(5), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, TickMinuteConverter(3), 3), 1.0F)
            .build();
    public static final FoodComponent GOLDEN_POTATO_SETTINGS  = new Builder()
            .nutrition(3)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickSecondConverter(5), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, TickMinuteConverter(4), 0), 1.0F)
            .build();
    public static final FoodComponent ENCHANTED_GOLDEN_POTATO_SETTINGS = new Builder()
            .nutrition(6)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickSecondConverter(25), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, TickMinuteConverter(5), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, TickMinuteConverter(5), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, TickMinuteConverter(3), 3), 1.0F)
            .build();
    public static final FoodComponent GOLDEN_BAKED_POTATO_SETTINGS = new Builder()
            .nutrition(8)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickSecondConverter(5), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, TickMinuteConverter(4), 0), 1.0F)
            .build();
    public static final FoodComponent ENCHANTED_GOLDEN_BAKED_POTATO_SETTINGS = new Builder()
            .nutrition(8)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickSecondConverter(25), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, TickMinuteConverter(5), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, TickMinuteConverter(5), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, TickMinuteConverter(3), 3), 1.0F)
            .build();
    public static final FoodComponent BROWN_MUSHROOM_C0_0_20A_SETTINGS = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .alwaysEdible()
            .eatingTime(1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 0), 1.0F)
            .build();
    public static final FoodComponent RED_MUSHROOM_C0_0_20A_SETTINGS = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .alwaysEdible()
            .eatingTime(1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0), 1.0F).build();
    public static final FoodComponent CHERRY_SETTINGS = new Builder()
            .nutrition(6)
            .saturationModifier(0.5F)
            .alwaysEdible()
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickSecondConverter(25), 1), 1.0F)
            .build();
    public static final FoodComponent GOLDEN_CHERRY_SETTINGS = new Builder()
            .nutrition(8)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(14)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickMinuteConverter(2), 2), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, TickMinuteConverter(6), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, TickMinuteConverter(6), 0), 1.0F)
            .build();
    public static final FoodComponent ENCHANTED_GOLDEN_CHERRY_SETTINGS = new Builder()
            .nutrition(10)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(12)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickMinuteConverter(4), 3), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, TickMinuteConverter(8), 2), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, TickMinuteConverter(8), 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, TickMinuteConverter(8), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, TickMinuteConverter(8), 0), 1.0F)
            .build();
    public static final FoodComponent DIAMOND_CHERRY_SETTINGS = new Builder()
            .nutrition(12)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(10)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickMinuteConverter(5), 4), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, TickMinuteConverter(5), 3), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, TickMinuteConverter(10), 3), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, TickMinuteConverter(10), 2), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, TickMinuteConverter(10), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, TickMinuteConverter(10), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, TickHourConverter(1), 9), 1.0F)
            .build();
    public static final FoodComponent ENCHANTED_DIAMOND_CHERRY_SETTINGS = new Builder()
            .nutrition(16)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(8)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickMinuteConverter(10), 8), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, TickMinuteConverter(10), 5), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, TickMinuteConverter(20), 5), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, TickMinuteConverter(20), 4), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, TickMinuteConverter(20), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, TickMinuteConverter(20), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, TickHourConverter(1.5), 9), 0.775F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, TickHourConverter(1.5), 4), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffectInit.XP_BOOST, TickMinuteConverter(2), 0), 1.0F)
            .build();
    public static final FoodComponent NETHERITE_CHERRY_SETTINGS = new Builder()
            .nutrition(18)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(6)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickMinuteConverter(12), 9), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, TickMinuteConverter(12), 9), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, TickMinuteConverter(20), 9), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, TickMinuteConverter(20), 9), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, TickHourConverter(1), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, TickHourConverter(1), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, TickHourConverter(2), 9), 0.775F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, TickHourConverter(2), 4), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffectInit.XP_BOOST, TickMinuteConverter(10), 4), 1.0F)
            .build();
    public static final FoodComponent ENCHANTED_NETHERITE_CHERRY_SETTINGS = new Builder()
            .nutrition(20)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(4)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickMinuteConverter(20), 14), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, TickMinuteConverter(20), 14), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, TickMinuteConverter(30), 14), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, TickMinuteConverter(30), 14), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, TickHourConverter(2), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, TickHourConverter(2), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, TickHourConverter(3), 9), 0.775F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, TickHourConverter(3), 9), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffectInit.XP_BOOST, TickMinuteConverter(25), 9), 1.0F)
            .build();
    public static final FoodComponent DEEPSLATE_EMERALD_CHERRY_SETTINGS = new Builder()
            .nutrition(40)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(5)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickHourConverter(1), 16), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, TickHourConverter(1), 16), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, TickHourConverter(1), 16), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, TickHourConverter(1), 16), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, TickHourConverter(1), 16), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, TickHourConverter(4), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, TickHourConverter(4), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, TickHourConverter(6), 14), 0.775F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, TickHourConverter(6), 14), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffectInit.XP_BOOST, TickHourConverter(1), 14), 1.0F)
            .build();
    public static final FoodComponent ENCHANTED_DEEPSLATE_EMERALD_CHERRY_SETTINGS = new Builder()
            .nutrition(100)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(5)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, TickHourConverter(2), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, TickHourConverter(2), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, TickHourConverter(2), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, TickHourConverter(2), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, TickHourConverter(2), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, TickHourConverter(10), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, TickHourConverter(10), 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, TickHourConverter(10), 32), 0.775F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, TickHourConverter(10), 32), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffectInit.XP_BOOST, TickHourConverter(2), 32), 1.0F)
            .build();
    public static final FoodComponent BANANA = new Builder()
            .nutrition(5)
            .saturationModifier(0.5F)
            .alwaysEdible()
            .eatingTime(64)
            .build();



    public static int TickSecondConverter(int seconds) {return seconds * 20;}
    public static int TickMinuteConverter(int minutes) {return minutes * 20 * 60;}
    public static int TickHourConverter(double hours) {return (int) (hours * 20 * 60 * 60);}



    public static class Builder {
        private int nutrition;
        private float saturationModifier;
        private boolean canAlwaysEat;
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
