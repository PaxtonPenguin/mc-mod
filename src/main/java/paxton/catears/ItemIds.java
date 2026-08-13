package paxton.catears;

import com.geckolib.animatable.GeoItem;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.util.GeckoLibUtil;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.resources.Identifier;

public class ItemIds {
    public static ResourceKey<Item> create(String name) {
		// Create the item key.
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("cat-ears", name));
	}

    public static final ResourceKey<Item> CAT_EARS = create("cat_ears");

	public static final ResourceKey<Item> ORB = create("orb");

	public class ExampleArmorItem extends Item implements GeoItem {
		private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    	public ExampleArmorItem(ArmorMaterial material, ArmorType type, Properties properties) {
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
	}
}
