package paxton.pixton;

import net.minecraft.client.gui.screens.MenuScreens;
import net.fabricmc.api.ClientModInitializer;

public class Screens implements ClientModInitializer {
    @Override
	public void onInitializeClient() {
		MenuScreens.register(MenuTypes.PEDESTAL, PedestalScreen::new);
	}
}
