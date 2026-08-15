package paxton.catears;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorType;
//import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import java.util.function.Supplier;
import java.util.function.Consumer;
import com.google.common.base.Suppliers;
import com.geckolib.animatable.GeoItem;
//import com.geckolib.animatable.client.GeoRenderProvider;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.util.GeckoLibUtil;
import org.apache.commons.lang3.mutable.MutableObject;

import net.minecraft.world.item.equipment.ArmorMaterial;

public class cat_ears extends Item implements GeoItem {
    	private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
		public static final MutableObject<Object> geoRenderProvider = new MutableObject<>();

    	public cat_ears(ArmorMaterial material, ArmorType type, Properties properties) {
        	super(properties.humanoidArmor(material, type));
    	}

    	@Override
    	public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        	// We can fill this in later
    	}

    	@Override
    	public AnimatableInstanceCache getAnimatableInstanceCache() {
        	return this.geoCache;
    	}

		@Override
    	public void createGeoRenderer(Consumer consumer) {
			consumer.accept(this.geoRenderProvider.getValue());
        	//consumer.accept(new GeoRenderProvider() {
            //	private final Supplier<GeoArmorRenderer<cat_ears, HumanoidRenderState>> renderer = Suppliers.memoize(() -> new GeoArmorRenderer<>(cat_ears.this));

            //	@Override
            //	public GeoArmorRenderer<?, ?> getGeoArmorRenderer(ItemStack itemStack, EquipmentSlot equipmentSlot) {
            //   	return this.renderer.get();
            //	}
        	//});
    	}
	}