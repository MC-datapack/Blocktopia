package github.mcdatapack.blocktopia.list;

import com.google.common.collect.ImmutableList;
import java.util.Optional;
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



    public static int TickSecondConverter(int seconds) {
        return seconds * 20;
    }
    public static int TickMinuteConverter(int minutes) {
        return minutes * 20 * 60;
    }
    public static int TickHourConverter(int hours) {
        return hours * 20 * 60 * 60;
    }

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

        public Builder usingConvertsTo(ItemConvertible item) {
            this.usingConvertsTo = Optional.of(new ItemStack(item));
            return this;
        }

        public FoodComponent build() {
            float f = HungerConstants.calculateSaturation(this.nutrition, this.saturationModifier);
            return new FoodComponent(this.nutrition, f, this.canAlwaysEat, this.eatSeconds, this.usingConvertsTo, this.effects.build());
        }
    }
}
