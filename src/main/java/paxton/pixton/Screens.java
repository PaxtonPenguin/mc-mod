package paxton.pixton;

import net.minecraft.client.gui.screens.MenuScreens;
import net.fabricmc.api.ModInitializer;

public class Screens implements ModInitializer {
    @Override
	public void onInitialize() {
		MenuScreens.register(MenuTypes.PEDESTAL, PedestalScreen::new);
	}

	public static void initialize() {
		MenuScreens.register(MenuTypes.PEDESTAL, PedestalScreen::new);
	}
}
