package github.mcdatapack.blocktopia.statuseffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

import java.awt.*;

public class XPRemoverEffect extends StatusEffect {
    public XPRemoverEffect() {
        super(StatusEffectCategory.HARMFUL, new Color(12, 177, 119).getRGB());
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity playerEntity) {
            playerEntity.addExperience( -5 << amplifier);
        }

        return super.applyUpdateEffect(entity, amplifier);
    }
}
