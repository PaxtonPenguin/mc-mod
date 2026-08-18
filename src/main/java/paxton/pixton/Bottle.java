package paxton.pixton;
import net.minecraft.world.effect.MobEffectInstance;
//import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class Bottle {
	
    public static final Consumable BOTTLE_CONSUMABLE_COMPONENT = Consumables.defaultDrink()
		// The duration is in ticks, 20 ticks = 1 second
		.onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(Items.RANDOM, 1, 1), 1.0f))
		.build();
    public static final FoodProperties BOTTLE_COMPONENT = new FoodProperties.Builder()
		.alwaysEdible()
		.build(); 
}
