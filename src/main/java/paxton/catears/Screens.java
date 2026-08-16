package paxton.catears;

import net.minecraft.client.gui.screens.MenuScreens;
import net.fabricmc.api.ModInitializer;

public class Screens implements ModInitializer {
    @Override
	public void onInitialize() {
		CatEars.LOGGER.info("pre init");
		MenuScreens.register(MenuTypes.PEDESTAL, PedestalScreen::new);
		CatEars.LOGGER.info("init pedestal");
	}

	public static void initialize() {
	}
}
