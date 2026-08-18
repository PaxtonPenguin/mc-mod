package paxton.pixton;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.core.Registry;

public class Components {
	public static final DataComponentType<Tooltip> TOOLTIP = Registry.register(
			BuiltInRegistries.DATA_COMPONENT_TYPE,
			Identifier.fromNamespaceAndPath(CatEars.MOD_ID, "tooltip"),
			DataComponentType.<Tooltip>builder().persistent(Tooltip.CODEC).build()
	);

    protected static void initialize() {
		CatEars.LOGGER.info("Registering {} components", "paxton.pixton");
		// Technically this method can stay empty, but some developers like to notify
		// the console, that certain parts of the mod have been successfully initialized
	}

    
}
