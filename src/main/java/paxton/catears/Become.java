package paxton.catears;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

public class Become extends MobEffect {
	protected Become() {
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

			final Inventory yeah = player.getInventory();
			
			yeah.add(99, Items.CAT_EARS.getDefaultInstance());
		}

		return super.applyEffectTick(level, entity, amplifier);
	}
}
