package paxton.pixton;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.*;
import java.util.Random;

public class RandomEffect extends MobEffect {
    protected RandomEffect() {
		// category: StatusEffectCategory - describes if the effect is helpful (BENEFICIAL), harmful (HARMFUL) or useless (NEUTRAL)
		// color: int - Color is the color assigned to the effect (in RGB)
		super(MobEffectCategory.BENEFICIAL, 0xe9b8b3);
	}

	// Called every tick to check if the effect can be applied or not
	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		// In our case, we just make it return true so that it applies the effect every tick
		return true;
	}

	// Called when the effect is applied.
	@Override
	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		if (entity instanceof Player player) {
			((Player) entity).giveExperiencePoints(1 << amplifier); // Higher amplifier gives you experience faster
            final Random r = new Random();
	        final int r1 = r.nextInt(3);
	        final int r2 = r.nextInt(3);
	        final int r3 = r.nextInt(3);

            final MobEffectInstance white = new MobEffectInstance(Items.BECOME, r1);
            final MobEffectInstance black = new MobEffectInstance(Items.BECOMEBLACK, r2);
            final MobEffectInstance fop = new MobEffectInstance(Items.BECOMEFOP, r1);

            player.addEffect(white);
            player.addEffect(black);
            player.addEffect(black);
		}

		return super.applyEffectTick(level, entity, amplifier);
	}
}
