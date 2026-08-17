package paxton.catears;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.ItemStack;

public class BecomeFop extends MobEffect {
	protected BecomeFop() {
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

			player.setItemSlot(EquipmentSlot.HEAD, Items.FOP_EARS.getDefaultInstance());
			player.setItemSlot(EquipmentSlot.LEGS, Items.FOP_TAIL.getDefaultInstance());
			player.setAttached(Save.isFurry, "fox");
			
			//yeah.add(103, Items.CAT_EARS.getDefaultInstance());
		}

		return super.applyEffectTick(level, entity, amplifier);
	}
}
