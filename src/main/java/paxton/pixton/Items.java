package paxton.pixton;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.core.Registry;
import java.util.function.Function;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Unit;
import net.minecraft.world.item.alchemy.Potion;

public class Items {
    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
		// Create the item instance.
		Item item = itemFactory.apply(settings.setId(itemKey));

		// Register the item.
		Registry.register(BuiltInRegistries.ITEM, itemKey, item);

		return item;
	}

	private static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CatEars.MOD_ID, name));
		//? if >=1.21.2 {
		T item = itemFactory.apply(settings.setId(itemKey));
		return Registry.register(BuiltInRegistries.ITEM, itemKey, item);
		//?} else {
		/*T item = itemFactory.apply(settings);
		return Registry.register(BuiltInRegistries.ITEM, itemKey, item);
		*///?}
	}

	//public static Supplier<T> register(ResourceKey<Item>)

	public static final Holder<MobEffect> BECOME = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(CatEars.MOD_ID, "become"), new Become());

	public static final Holder<MobEffect> BECOMEBLACK = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(CatEars.MOD_ID, "becomeblack"), new BecomeBlack());

	public static final Holder<MobEffect> BECOMEFOP = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(CatEars.MOD_ID, "becomefop"), new BecomeFop());

	public static final Holder<MobEffect> RANDOM = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(CatEars.MOD_ID, "random"), new RandomEffect());

    public static final Item DUD = register(ItemIds.DUD, Item::new, new Item.Properties().component(Components.TOOLTIP, new Tooltip("you got the dud card")));

	public static final Item VINYL = register(ItemIds.VINYL, Item::new, new Item.Properties().component(Components.TOOLTIP, new Tooltip("a blank vinyl record")));

	public static final Item INFERNO = register(ItemIds.INFERNO, Item::new, new Item.Properties().component(Components.TOOLTIP, new Tooltip("wow, inferno")).jukeboxPlayable(Songs.INFERNODISC));

	public static final Item SLIGHTLYWEATHERED = register(ItemIds.SLIGHTLYWEATHERED, Item::new, new Item.Properties().component(Components.TOOLTIP, new Tooltip("uhhh...inferno i guess")).jukeboxPlayable(Songs.SLIGHTLYWEATHEREDDISC));

	public static final Item WEATHEREDINFERNO = register(ItemIds.WEATHEREDINFERNO, Item::new, new Item.Properties().component(Components.TOOLTIP, new Tooltip("what the fuck is this")).jukeboxPlayable(Songs.WEATHEREDINFERNODISC));

	public static final Item WAXEDINFERNO = register(ItemIds.WAXEDINFERNO, Item::new, new Item.Properties().component(Components.TOOLTIP, new Tooltip("wow, waxed inferno")).jukeboxPlayable(Songs.INFERNODISC));

	public static final Item WAXEDSLIGHTLYWEATHERED = register(ItemIds.WAXEDSLIGHTLYWEATHERED, Item::new, new Item.Properties().component(Components.TOOLTIP, new Tooltip("uhhh...waxed inferno i guess")).jukeboxPlayable(Songs.SLIGHTLYWEATHEREDDISC));

	public static final Item WAXEDWEATHEREDINFERNO = register(ItemIds.WAXEDWEATHEREDINFERNO, Item::new, new Item.Properties().component(Components.TOOLTIP, new Tooltip("what the fuck is this (waxed)")).jukeboxPlayable(Songs.WEATHEREDINFERNODISC));

	public static final Item BABYVINYL = register(ItemIds.BABYVINYL, Item::new, new Item.Properties().component(Components.TOOLTIP, new Tooltip("autozone")).jukeboxPlayable(Songs.BABYDISC));

	public static final Item ORB = register(
		ItemIds.ORB,
		Item::new,
		new Item.Properties().food(Orb.ORB_COMPONENT, Orb.ORB_CONSUMABLE_COMPONENT).component(Components.TOOLTIP, new Tooltip("Wait...why can you eat this"))
	);

	public static final Item DARK_ORB = register(
		ItemIds.DARK_ORB,
		Item::new,
		new Item.Properties().food(DarkOrb.ORB_COMPONENT, DarkOrb.ORB_CONSUMABLE_COMPONENT).component(Components.TOOLTIP, new Tooltip("Wait...why can you eat this"))
	);

	public static final Item FOP_ORB = register(
		ItemIds.FOP_ORB,
		Item::new,
		new Item.Properties().food(FopOrb.ORB_COMPONENT, FopOrb.ORB_CONSUMABLE_COMPONENT).component(Components.TOOLTIP, new Tooltip("Wait...why can you eat this"))
	);

	public static final Item BOTTLE = register(
		ItemIds.BOTTLE,
		Item::new,
		new Item.Properties().food(Bottle.BOTTLE_COMPONENT, Bottle.BOTTLE_CONSUMABLE_COMPONENT).component(Components.TOOLTIP, new Tooltip("Probably not a good idea to drink this"))
	);
	
	public static final Item CAT_EARS = register(ItemIds.CAT_EARS, properties -> new cat_ears(properties), new Item.Properties().component(Components.TOOLTIP, new Tooltip("meow :3")).component(DataComponents.UNBREAKABLE, Unit.INSTANCE));

	public static final Item BLACK_CAT_EARS = register(ItemIds.BLACK_CAT_EARS, properties -> new black_cat_ears(Material.INSTANCE, ArmorType.HELMET, properties), new Item.Properties().component(Components.TOOLTIP, new Tooltip("mrrp :3")).component(DataComponents.UNBREAKABLE, Unit.INSTANCE));

	public static final Item FOP_EARS = register(ItemIds.FOP_EARS, properties -> new fop_ears(Material.INSTANCE, ArmorType.HELMET, properties), new Item.Properties().component(Components.TOOLTIP, new Tooltip("fun fact: you can bind animal noises")).component(DataComponents.UNBREAKABLE, Unit.INSTANCE));

	public static final Item CAT_TAIL = register(ItemIds.CAT_TAIL, properties -> new cat_tail(properties), new Item.Properties().component(Components.TOOLTIP, new Tooltip("purr :3")).component(DataComponents.UNBREAKABLE, Unit.INSTANCE));

	public static final Item BLACK_CAT_TAIL = register(ItemIds.BLACK_CAT_TAIL, properties -> new black_cat_tail(properties), new Item.Properties().component(Components.TOOLTIP, new Tooltip("*wags tail* :3")).component(DataComponents.UNBREAKABLE, Unit.INSTANCE));

	public static final Item FOP_TAIL = register(ItemIds.FOP_TAIL, properties -> new fop_tail(properties), new Item.Properties().component(Components.TOOLTIP, new Tooltip("fun fact: you need ears to make noises")).component(DataComponents.UNBREAKABLE, Unit.INSTANCE));

	public static final Item BABY = register(ItemIds.BABY, Item::new, new Item.Properties().component(Components.TOOLTIP, new Tooltip("everything you do")));

	public static final Holder<Potion> BECOME_POTION =
		Registry.registerForHolder(
				BuiltInRegistries.POTION,
				ItemIds.BECOME_POTION,
				new Potion("random",
						new MobEffectInstance(
								RANDOM,
								1,
								0
						)
				)
		);

	public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
		BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(CatEars.MOD_ID, "creative_tab")
	);

	public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricCreativeModeTab.builder()
		.icon(() -> new ItemStack(Items.CAT_EARS))
		.title(Component.translatable("creativeTab.pixton"))
		.displayItems((params, output) -> {
			output.accept(Items.CAT_EARS);
			output.accept(Items.CAT_TAIL);
			output.accept(Items.BLACK_CAT_EARS);
			output.accept(Items.BLACK_CAT_TAIL);
			output.accept(Items.FOP_EARS);
			output.accept(Items.FOP_TAIL);
			output.accept(Items.ORB);
			output.accept(Items.DARK_ORB);
			output.accept(Items.FOP_ORB);
			output.accept(Blocks.PEDESTAL.asItem());
			output.accept(Blocks.WHITE_TUFF.asItem());
			output.accept(Items.DUD);
			output.accept(Blocks.GMOD.asItem());
			output.accept(Blocks.SUFRAISEII.asItem());
			output.accept(Items.BOTTLE);
			output.accept(Blocks.SHELF.asItem());
			output.accept(Items.VINYL);
			output.accept(Items.INFERNO);
			output.accept(Items.SLIGHTLYWEATHERED);
			output.accept(Items.WEATHEREDINFERNO);
			output.accept(Items.WAXEDINFERNO);
			output.accept(Items.WAXEDSLIGHTLYWEATHERED);
			output.accept(Items.WAXEDWEATHEREDINFERNO);
			output.accept(Items.BABYVINYL);
			output.accept(Items.BABY);
			output.accept(Blocks.BABY.asItem());
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
