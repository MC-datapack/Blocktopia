package github.mcdatapack.blocktopia.statuseffect.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import org.jetbrains.annotations.Nullable;

public class HealthAddOrRemoveEffect extends InstantStatusEffect {
    private final boolean damage;

    public HealthAddOrRemoveEffect(StatusEffectCategory category, int color, boolean damage) {
        super(category, color);
        this.damage = damage;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (this.damage) {
            entity.damage(entity.getDamageSources().magic(), amplifier);
        } else {
            entity.heal(amplifier);
        }

        return true;
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        if (this.damage) {
            target.damage(target.getDamageSources().magic(), amplifier);
        } else {
            target.heal(amplifier);
        }
    }
}
