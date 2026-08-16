package paxton.catears;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;

public class Screens implements ClientModInitializer {
    @Override
	public void onInitializeClient() {
		MenuScreens.register(MenuTypes.PEDESTAL, PedestalScreen::new);
	}
}
