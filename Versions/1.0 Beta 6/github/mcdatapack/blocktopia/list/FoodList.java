package github.mcdatapack.blocktopia.list;

import com.google.common.collect.ImmutableList;
import java.util.Optional;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_4174;
import net.minecraft.class_6075;

public class FoodList {
    public static final class_4174 COCONUT_SETTINGS = new Builder()
            .nutrition(10).
            saturationModifier(1.0F).
            alwaysEdible()
            .snack()
            .statusEffect(new class_1293(class_1294.field_5924, TickSecondConverter(10), 1), 1.0F)
            .build();
    public static final class_4174 GOLDEN_COCONUT_SETTINGS = new Builder()
            .nutrition(11)
            .saturationModifier(1)
            .alwaysEdible()
            .eatingTime(14)
            .statusEffect(new class_1293(class_1294.field_5924, TickMinuteConverter(1), 2), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5898, TickMinuteConverter(4), 1), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5907, TickMinuteConverter(3), 0), 1.0F)
            .build();
    public static final class_4174 ENCHANTED_GOLDEN_COCONUT_SETTINGS  = new Builder()
            .nutrition(12)
            .saturationModifier(1.0F)
            .alwaysEdible()
            .eatingTime(12)
            .statusEffect(new class_1293(class_1294.field_5924, TickMinuteConverter(2), 4), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5898, TickMinuteConverter(5), 4), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5907, TickMinuteConverter(5), 2), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5918, TickMinuteConverter(4), 0), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5923, TickMinuteConverter(4), 0), 1.0F)
            .build();
    public static final class_4174 ENCHANTED_GOLDEN_CARROT_SETTINGS = new Builder()
            .nutrition(6)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new class_1293(class_1294.field_5924, TickSecondConverter(25), 1), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5907, TickMinuteConverter(5), 1), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5918, TickMinuteConverter(5), 0), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5898, TickMinuteConverter(3), 3), 1.0F)
            .build();
    public static final class_4174 GOLDEN_POTATO_SETTINGS  = new Builder()
            .nutrition(3)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new class_1293(class_1294.field_5924, TickSecondConverter(5), 1), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5898, TickMinuteConverter(4), 0), 1.0F)
            .build();
    public static final class_4174 ENCHANTED_GOLDEN_POTATO_SETTINGS = new Builder()
            .nutrition(6)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new class_1293(class_1294.field_5924, TickSecondConverter(25), 1), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5907, TickMinuteConverter(5), 1), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5918, TickMinuteConverter(5), 0), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5898, TickMinuteConverter(3), 3), 1.0F)
            .build();
    public static final class_4174 GOLDEN_BAKED_POTATO_SETTINGS = new Builder()
            .nutrition(8)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new class_1293(class_1294.field_5924, TickSecondConverter(5), 1), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5898, TickMinuteConverter(4), 0), 1.0F)
            .build();
    public static final class_4174 ENCHANTED_GOLDEN_BAKED_POTATO_SETTINGS = new Builder()
            .nutrition(8)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new class_1293(class_1294.field_5924, TickSecondConverter(25), 1), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5907, TickMinuteConverter(5), 1), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5918, TickMinuteConverter(5), 0), 1.0F)
            .statusEffect(new class_1293(class_1294.field_5898, TickMinuteConverter(3), 3), 1.0F)
            .build();
    public static final class_4174 BROWN_MUSHROOM_C0_0_20A_SETTINGS = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .alwaysEdible()
            .eatingTime(1.0F)
            .statusEffect(new class_1293(class_1294.field_5921, 1, 0), 1.0F)
            .build();
    public static final class_4174 RED_MUSHROOM_C0_0_20A_SETTINGS = new Builder()
            .nutrition(0)
            .saturationModifier(0.5F)
            .alwaysEdible()
            .eatingTime(1.0F)
            .statusEffect(new class_1293(class_1294.field_5915, 1, 0), 1.0F).build();



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
        private Optional<class_1799> usingConvertsTo = Optional.empty();
        private final ImmutableList.Builder<class_4174.class_9423> effects = ImmutableList.builder();
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
            this.eatSeconds = ticks*20;
            return this;
        }
        public Builder statusEffect(class_1293 effect, float chance) {
            this.effects.add(new class_4174.class_9423(effect, chance));
            return this;
        }

        public Builder usingConvertsTo(class_1935 item) {
            this.usingConvertsTo = Optional.of(new class_1799(item));
            return this;
        }

        public class_4174 build() {
            float f = class_6075.method_59683(this.nutrition, this.saturationModifier);
            return new class_4174(this.nutrition, f, this.canAlwaysEat, this.eatSeconds, this.usingConvertsTo, this.effects.build());
        }
    }
}
