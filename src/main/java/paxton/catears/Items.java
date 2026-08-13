package paxton.catears;

//import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
//import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.core.Registry;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Consumer;
import com.google.common.base.Suppliers;
import javax.annotation.*;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import com.geckolib.animatable.GeoItem;
import com.geckolib.animatable.client.GeoRenderProvider;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.renderer.GeoArmorRenderer;
import com.geckolib.util.GeckoLibUtil;

import net.minecraft.world.item.equipment.ArmorMaterial;

public class Items {
    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
		// Create the item instance.
		Item item = itemFactory.apply(settings.setId(itemKey));

		// Register the item.
		Registry.register(BuiltInRegistries.ITEM, itemKey, item);

		return item;
	}

    //public static final Item CAT_EARS = register(ItemIds.CAT_EARS, Item::new, new Item.Properties());

	//public static final Item ORB = register(ItemIds.ORB, Item::new, new Item.Properties());

	public static final Item DARK_ORB = register(ItemIds.DARK_ORB, Item::new, new Item.Properties());

	public static final Item FOP_ORB = register(ItemIds.FOP_ORB, Item::new, new Item.Properties());

	public class cat_ears extends Item implements GeoItem {
    	private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

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
    	public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        	consumer.accept(new GeoRenderProvider() {
            	private final Supplier<GeoArmorRenderer<cat_ears>> renderer = Suppliers.memoize(() -> new GeoArmorRenderer<>(cat_ears.this));

            	@Override
            	public @Nullable GeoArmorRenderer<?, ?> getGeoArmorRenderer(ItemStack itemStack, EquipmentSlot equipmentSlot) {
                	return this.renderer.get();
            	}
        	});
    	}
	}

	public static final Item ORB = register(
		ItemIds.ORB,
		Item::new,
		new Item.Properties().food(Orb.ORB_COMPONENT, Orb.ORB_CONSUMABLE_COMPONENT)
	);
	
	public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
		BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath("cat-ears", "creative_tab")
	);

	public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricCreativeModeTab.builder()
		.icon(() -> new ItemStack(Items.cat_ears))
		.title(Component.translatable("creativeTab.cat-ears"))
		.displayItems((params, output) -> {
			output.accept(Items.cat_ears);
			output.accept(Items.ORB);
			output.accept(Items.DARK_ORB);
			output.accept(Items.FOP_ORB);
		})
		.build();
	
		//public static final Item CAT_EARS = register(
		//ItemIds.CAT_EARS,
		//Item::new,
		//new Item.Properties().humanoidArmor(Material.INSTANCE, ArmorType.HELMET)
		//		//.durability(ArmorType.HELMET)//.getDurability(Material.BASE_DURABILITY))
		//);

    public static void initialize() {
        //CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> creativeTab.accept(Items.CAT_EARS));
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);
    }
}
