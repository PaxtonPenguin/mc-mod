package paxton.pixton;

import net.minecraft.client.gui.screens.MenuScreens;
import eu.pb4.trinkets.api.client.TrinketRenderer;
import eu.pb4.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ClientModInitializer;

public class Screens implements ClientModInitializer {
    @Override
	public void onInitializeClient() {
		MenuScreens.register(MenuTypes.PEDESTAL, PedestalScreen::new);
		cat_ears cat_ears = new cat_ears();
		cat_tail cat_tail = new cat_tail();
		black_cat_tail black_cat_tail = new black_cat_tail();
		fop_tail fop_tail = new fop_tail();
		TrinketRendererRegistry.registerRenderer(Items.CAT_TAIL, cat_tail);
		TrinketRendererRegistry.registerRenderer(Items.BLACK_CAT_TAIL, black_cat_tail);
		TrinketRendererRegistry.registerRenderer(Items.FOP_TAIL, fop_tail);
		TrinketRendererRegistry.registerRenderer(Items.CAT_EARS, cat_ears);
		collar collar = new collar();
		TrinketRendererRegistry.registerRenderer(Items.COLLAR, collar);
	}
}
