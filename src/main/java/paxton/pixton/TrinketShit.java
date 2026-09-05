package paxton.pixton;

import eu.pb4.trinkets.api.TrinketAttachment;
import eu.pb4.trinkets.api.TrinketsApi;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import java.util.function.Predicate;

public class TrinketShit {
    public static boolean hasEquipped(LivingEntity entity, Predicate<ItemStack> predicate) {
        TrinketAttachment attachment = TrinketsApi.getAttachment(entity);
        if (attachment == null) return false;
        return attachment.isEquipped(stack -> !stack.isEmpty() && predicate.test(stack));
    }
}
