package paxton.pixton;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorType;
//import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import java.util.function.Supplier;
import java.util.function.Consumer;
import com.google.common.base.Suppliers;
import com.geckolib.animatable.GeoItem;
import com.geckolib.animatable.client.GeoRenderProvider;
//import com.geckolib.animatable.client.GeoRenderProvider;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.util.GeckoLibUtil;
//import org.apache.commons.lang3.mutable.MutableObject;
import com.geckolib.renderer.GeoArmorRenderer;
import com.geckolib.renderer.GeoItemRenderer;

import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import org.jetbrains.annotations.Nullable;

import net.minecraft.world.item.equipment.ArmorMaterial;

public class fop_ears extends Item implements GeoItem {
    	private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
		//public static final MutableObject<Object> geoRenderProvider = new MutableObject<>();

    	public fop_ears(ArmorMaterial material, ArmorType type, Properties properties) {
        	super(properties.humanoidArmor(material, type));
    	}

		@Override
    	public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        	consumer.accept(new GeoRenderProvider() {
            	private final Supplier<GeoArmorRenderer<fop_ears, HumanoidRenderState>> renderer = Suppliers.memoize(() -> new GeoArmorRenderer<>(fop_ears.this));
				private final Supplier<GeoItemRenderer<fop_ears>> itemrenderer = Suppliers.memoize(() -> new GeoItemRenderer<>(fop_ears.this));

            	@Override
            	public @Nullable GeoArmorRenderer<?, ?> getGeoArmorRenderer(ItemStack itemStack, EquipmentSlot equipmentSlot) {
                	return this.renderer.get();
            	}

				@Override
           		public @Nullable GeoItemRenderer<fop_ears> getGeoItemRenderer() {
                	return this.itemrenderer.get();
            	}
        	});
    	}

    	@Override
    	public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        	// We can fill this in later
    	}

    	@Override
    	public AnimatableInstanceCache getAnimatableInstanceCache() {
        	return this.geoCache;
    	}
	}