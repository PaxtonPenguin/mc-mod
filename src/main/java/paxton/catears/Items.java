package paxton.catears;

//import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
//import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.core.Registry;
import java.util.function.Function;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

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

	public static final Item ORB = register(
		ItemIds.ORB,
		Item::new,
		new Item.Properties().food(Orb.ORB_COMPONENT, Orb.ORB_CONSUMABLE_COMPONENT)
	);
	
	public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
		BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath("cat-ears", "creative_tab")
	);

	public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricCreativeModeTab.builder()
		.icon(() -> new ItemStack(Items.CAT_EARS))
		.title(Component.translatable("creativeTab.cat-ears"))
		.displayItems((params, output) -> {
			output.accept(Items.CAT_EARS);
			output.accept(Items.ORB);
		})
		.build();
	
		public static final Item CAT_EARS = register(
		ItemIds.CAT_EARS,
		Item::new,
		new Item.Properties().humanoidArmor(Material.INSTANCE, ArmorType.HELMET)
				//.durability(ArmorType.HELMET)//.getDurability(Material.BASE_DURABILITY))
		);

    public static void initialize() {
        //CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> creativeTab.accept(Items.CAT_EARS));
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);
    }
}
