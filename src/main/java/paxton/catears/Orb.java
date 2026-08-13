package paxton.catears;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Orb {
    public static final Consumable ORB_CONSUMABLE_COMPONENT = Consumables.defaultFood()
		// The duration is in ticks, 20 ticks = 1 second
		.onConsume(CatEars.LOGGER.info("eated a orb :3"))
		.build();
    public static final FoodProperties ORB_COMPONENT = new FoodProperties.Builder()
		.alwaysEdible()
		.build();
}
