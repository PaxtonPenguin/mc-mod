package paxton.pixton;

import net.minecraft.client.gui.screens.MenuScreens;
import eu.pb4.trinkets.api.client.TrinketRenderer;
import eu.pb4.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ClientModInitializer;

public class Screens implements ClientModInitializer {
    @Override
	public void onInitializeClient() {
		MenuScreens.register(MenuTypes.PEDESTAL, PedestalScreen::new);
		TrinketRendererRegistry.registerRenderer(Items.CAT_TAIL, (TrinketRenderer) Items.CAT_TAIL);
		TrinketRendererRegistry.registerRenderer(Items.BLACK_CAT_TAIL, (TrinketRenderer) Items.BLACK_CAT_TAIL);
		TrinketRendererRegistry.registerRenderer(Items.FOP_TAIL, (TrinketRenderer) Items.FOP_TAIL);
		TrinketRendererRegistry.registerRenderer(Items.CAT_EARS, (TrinketRenderer) Items.CAT_EARS);
	}
}
