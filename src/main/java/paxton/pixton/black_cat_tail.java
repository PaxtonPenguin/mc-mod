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
import com.geckolib.constant.DefaultAnimations;
import com.geckolib.util.GeckoLibUtil;
//import org.apache.commons.lang3.mutable.MutableObject;
import com.geckolib.renderer.GeoArmorRenderer;
import com.geckolib.renderer.GeoItemRenderer;

import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import org.jetbrains.annotations.Nullable;

import net.minecraft.world.item.equipment.ArmorMaterial;

public class black_cat_tail extends Item implements GeoItem {
    	private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
		//public static final MutableObject<Object> geoRenderProvider = new MutableObject<>();

    	public black_cat_tail(ArmorMaterial material, ArmorType type, Properties properties) {
        	super(properties.humanoidArmor(material, type));
    	}

		@Override
    	public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        	consumer.accept(new GeoRenderProvider() {
            	private final Supplier<GeoArmorRenderer<black_cat_tail, HumanoidRenderState>> renderer = Suppliers.memoize(() -> new GeoArmorRenderer<>(black_cat_tail.this));
				private final Supplier<GeoItemRenderer<black_cat_tail>> itemrenderer = Suppliers.memoize(() -> new GeoItemRenderer<>(black_cat_tail.this));

            	@Override
            	public @Nullable GeoArmorRenderer<?, ?> getGeoArmorRenderer(ItemStack itemStack, EquipmentSlot equipmentSlot) {
                	return this.renderer.get();
            	}

				@Override
           		public @Nullable GeoItemRenderer<black_cat_tail> getGeoItemRenderer() {
                	return this.itemrenderer.get();
            	}
        	});
    	}

    	@Override
    	public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        	controllers.add(DefaultAnimations.genericIdleController());
    	}

    	@Override
    	public AnimatableInstanceCache getAnimatableInstanceCache() {
        	return this.geoCache;
    	}
	}