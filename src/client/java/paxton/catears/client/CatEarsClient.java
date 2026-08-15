package paxton.catears.client;

import com.geckolib.animatable.client.GeoRenderProvider;
import com.geckolib.renderer.GeoArmorRenderer;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorType;
import paxton.catears.Items;
import paxton.catears.Material;
import paxton.catears.cat_ears;

import java.util.function.Supplier;
import java.util.function.Consumer;
import com.google.common.base.Suppliers;

public class CatEarsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
    	cat_ears.geoRenderProvider.setValue(new GeoRenderProvider() {
        private final Supplier<GeoArmorRenderer<cat_ears, HumanoidRenderState>> renderer = Suppliers.memoize(() -> new GeoArmorRenderer<>());

        @Override
        public GeoArmorRenderer<?, ?> getGeoArmorRenderer(ItemStack itemStack, EquipmentSlot equipmentSlot) {
            return this.renderer.get();
        }
    });
	}
}