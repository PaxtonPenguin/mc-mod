package paxton.pixton;

import java.util.function.Consumer;

import com.mojang.serialization.Codec;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

// #region component_with_tooltip
public record Tooltip(String clickCount) implements TooltipProvider {
	// #endregion component_with_tooltip
	public static final Codec<Tooltip> CODEC = Codec.STRING.xmap(Tooltip::new, Tooltip::clickCount);

	// #region component_with_tooltip
	@Override
	public void addToTooltip(TooltipContext tooltip, Consumer<Component> textConsumer, TooltipFlag type, DataComponentGetter components) {
		textConsumer.accept(Component.translatable(clickCount).withStyle(ChatFormatting.ITALIC));
	}
}
