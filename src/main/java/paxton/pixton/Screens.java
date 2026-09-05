package paxton.pixton;

import net.minecraft.client.gui.screens.MenuScreens;
import paxton.pixton.dyed.cat_tails.renderers.*;
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
		bellcollar bellcollar = new bellcollar();
		TrinketRendererRegistry.registerRenderer(Items.BELL_COLLAR, bellcollar);

		black_dye_cat_tail black_dye_cat_tail = new black_dye_cat_tail();
		TrinketRendererRegistry.registerRenderer(Items.BLACK_DYED_CAT_TAIL, black_dye_cat_tail);
		red_dye_cat_tail red_dye_cat_tail = new red_dye_cat_tail();
		TrinketRendererRegistry.registerRenderer(Items.RED_DYED_CAT_TAIL, red_dye_cat_tail);
		orange_dye_cat_tail orange_dye_cat_tail = new orange_dye_cat_tail();
		TrinketRendererRegistry.registerRenderer(Items.ORANGE_DYED_CAT_TAIL, orange_dye_cat_tail);
		yellow_dye_cat_tail yellow_dye_cat_tail = new yellow_dye_cat_tail();
		TrinketRendererRegistry.registerRenderer(Items.YELLOW_DYED_CAT_TAIL, yellow_dye_cat_tail);
		lime_dye_cat_tail lime_dye_cat_tail = new lime_dye_cat_tail();
		TrinketRendererRegistry.registerRenderer(Items.LIME_DYED_CAT_TAIL, lime_dye_cat_tail);
		green_dye_cat_tail green_dye_cat_tail = new green_dye_cat_tail();
		TrinketRendererRegistry.registerRenderer(Items.GREEN_DYED_CAT_TAIL, green_dye_cat_tail);
		light_blue_dye_cat_tail light_blue_dye_cat_tail = new light_blue_dye_cat_tail();
		TrinketRendererRegistry.registerRenderer(Items.LIGHT_BLUE_DYED_CAT_TAIL, light_blue_dye_cat_tail);
		cyan_dye_cat_tail cyan_dye_cat_tail = new cyan_dye_cat_tail();
		TrinketRendererRegistry.registerRenderer(Items.CYAN_DYED_CAT_TAIL, cyan_dye_cat_tail);
		blue_dye_cat_tail blue_dye_cat_tail = new blue_dye_cat_tail();
		TrinketRendererRegistry.registerRenderer(Items.BLUE_DYED_CAT_TAIL, blue_dye_cat_tail);
		pink_dye_cat_tail pink_dye_cat_tail = new pink_dye_cat_tail();
		TrinketRendererRegistry.registerRenderer(Items.PINK_DYED_CAT_TAIL, pink_dye_cat_tail);
		magenta_dye_cat_tail magenta_dye_cat_tail = new magenta_dye_cat_tail();
		TrinketRendererRegistry.registerRenderer(Items.MAGENTA_DYED_CAT_TAIL, magenta_dye_cat_tail);
		purple_dye_cat_tail purple_dye_cat_tail = new purple_dye_cat_tail();
		TrinketRendererRegistry.registerRenderer(Items.PURPLE_DYED_CAT_TAIL, purple_dye_cat_tail);
		gray_dye_cat_tail gray_dye_cat_tail = new gray_dye_cat_tail();
		TrinketRendererRegistry.registerRenderer(Items.GRAY_DYED_CAT_TAIL, gray_dye_cat_tail);
		light_gray_dye_cat_tail light_gray_dye_cat_tail = new light_gray_dye_cat_tail();
		TrinketRendererRegistry.registerRenderer(Items.LIGHT_GRAY_DYED_CAT_TAIL, light_gray_dye_cat_tail);
		brown_dye_cat_tail brown_dye_cat_tail = new brown_dye_cat_tail();
		TrinketRendererRegistry.registerRenderer(Items.BROWN_DYED_CAT_TAIL, brown_dye_cat_tail);
		white_dye_cat_tail white_dye_cat_tail = new white_dye_cat_tail();
		TrinketRendererRegistry.registerRenderer(Items.WHITE_DYED_CAT_TAIL, white_dye_cat_tail);
	}
}
