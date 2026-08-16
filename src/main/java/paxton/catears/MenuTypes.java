package paxton.catears;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;

public class MenuTypes {
    public static final MenuType<PedestalMenu> PEDESTAL = register("pedestal", PedestalMenu::new);

	public static <T extends AbstractContainerMenu> MenuType<T> register(
					String name,
					MenuType.MenuSupplier<T> constructor
	) {
		return Registry.register(BuiltInRegistries.MENU, Identifier.fromNamespaceAndPath("cat-ears", name), new MenuType<>(constructor, FeatureFlagSet.of()));
	}
}
