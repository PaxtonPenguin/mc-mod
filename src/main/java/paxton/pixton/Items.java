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

import eu.pb4.trinkets.api.DefaultTrinketSlots;
import eu.pb4.trinkets.api.component.TrinketDataComponents;
import eu.pb4.trinkets.api.component.TrinketEquippable;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Unit;
import net.minecraft.world.item.alchemy.Potion;

import paxton.pixton.dyed.cat_tails.items.*;
import paxton.pixton.dyed.cat_ears.items.*;

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
	
	public static final CatEarsItem CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.CAT_EARS, new CatEarsItem());

	public static final Item BLACK_CAT_EARS = register(ItemIds.BLACK_CAT_EARS, properties -> new black_cat_ears(Material.INSTANCE, ArmorType.HELMET, properties), new Item.Properties().component(Components.TOOLTIP, new Tooltip("mrrp :3")).component(DataComponents.UNBREAKABLE, Unit.INSTANCE));

	public static final FopEarsItem FOP_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.FOP_EARS, new FopEarsItem());//, new Item.Properties().component(Components.TOOLTIP, new Tooltip("fun fact: you can bind animal noises")).component(DataComponents.UNBREAKABLE, Unit.INSTANCE));

	public static final CatTailItem CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.CAT_TAIL, new CatTailItem());

	public static final BlackCatTailItem BLACK_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.BLACK_CAT_TAIL, new BlackCatTailItem());

	public static final FopTailItem FOP_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.FOP_TAIL, new FopTailItem());

	public static final CollarItem COLLAR = Registry.register(BuiltInRegistries.ITEM, ItemIds.COLLAR, new CollarItem());

	public static final BellCollarItem BELL_COLLAR = Registry.register(BuiltInRegistries.ITEM, ItemIds.BELL_COLLAR, new BellCollarItem());

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

	//dyed shit
	public static final WhiteCatTailItem WHITE_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.WHITE_DYED_CAT_TAIL, new WhiteCatTailItem());
	public static final BlackCatTailItem BLACK_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.BLACK_DYED_CAT_TAIL, new BlackCatTailItem());
	public static final RedCatTailItem RED_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.RED_DYED_CAT_TAIL, new RedCatTailItem());
	public static final OrangeCatTailItem ORANGE_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.ORANGE_DYED_CAT_TAIL, new OrangeCatTailItem());
	public static final YellowCatTailItem YELLOW_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.YELLOW_DYED_CAT_TAIL, new YellowCatTailItem());
	public static final LimeCatTailItem LIME_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.LIME_DYED_CAT_TAIL, new LimeCatTailItem());
	public static final GreenCatTailItem GREEN_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.GREEN_DYED_CAT_TAIL, new GreenCatTailItem());
	public static final LightBlueCatTailItem LIGHT_BLUE_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.LIGHT_BLUE_DYED_CAT_TAIL, new LightBlueCatTailItem());
	public static final CyanCatTailItem CYAN_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.CYAN_DYED_CAT_TAIL, new CyanCatTailItem());
	public static final BlueCatTailItem BLUE_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.BLUE_DYED_CAT_TAIL, new BlueCatTailItem());
	public static final PinkCatTailItem PINK_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.PINK_DYED_CAT_TAIL, new PinkCatTailItem());
	public static final MagentaCatTailItem MAGENTA_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.MAGENTA_DYED_CAT_TAIL, new MagentaCatTailItem());
	public static final PurpleCatTailItem PURPLE_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.PURPLE_DYED_CAT_TAIL, new PurpleCatTailItem());
	public static final GrayCatTailItem GRAY_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.GRAY_DYED_CAT_TAIL, new GrayCatTailItem());
	public static final LightGrayCatTailItem LIGHT_GRAY_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.LIGHT_GRAY_DYED_CAT_TAIL, new LightGrayCatTailItem());
	public static final BrownCatTailItem BROWN_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.BROWN_DYED_CAT_TAIL, new BrownCatTailItem());

	public static final WhiteCatEarsItem WHITE_DYED_CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.WHITE_DYED_CAT_EARS, new WhiteCatEarsItem());
	public static final RedCatEarsItem RED_DYED_CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.RED_DYED_CAT_EARS, new RedCatEarsItem());
	public static final OrangeCatEarsItem ORANGE_DYED_CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.ORANGE_DYED_CAT_EARS, new OrangeCatEarsItem());
	public static final YellowCatEarsItem YELLOW_DYED_CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.YELLOW_DYED_CAT_EARS, new YellowCatEarsItem());
	public static final LimeCatEarsItem LIME_DYED_CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.LIME_DYED_CAT_EARS, new LimeCatEarsItem());
	public static final GreenCatEarsItem GREEN_DYED_CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.GREEN_DYED_CAT_EARS, new GreenCatEarsItem());
	public static final LightBlueCatEarsItem LIGHT_BLUE_DYED_CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.LIGHT_BLUE_DYED_CAT_EARS, new LightBlueCatEarsItem());
	public static final CyanCatEarsItem CYAN_DYED_CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.CYAN_DYED_CAT_EARS, new CyanCatEarsItem());
	public static final BlueCatEarsItem BLUE_DYED_CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.BLUE_DYED_CAT_EARS, new BlueCatEarsItem());
	public static final PinkCatEarsItem PINK_DYED_CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.PINK_DYED_CAT_EARS, new PinkCatEarsItem());
	public static final MagentaCatEarsItem MAGENTA_DYED_CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.MAGENTA_DYED_CAT_EARS, new MagentaCatEarsItem());
	public static final PurpleCatEarsItem PURPLE_DYED_CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.PURPLE_DYED_CAT_EARS, new PurpleCatEarsItem());
	public static final LightGrayCatEarsItem LIGHT_GRAY_DYED_CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.LIGHT_GRAY_DYED_CAT_EARS, new LightGrayCatEarsItem());
	public static final GrayCatEarsItem GRAY_DYED_CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.GRAY_DYED_CAT_EARS, new GrayCatEarsItem());
	public static final BrownCatEarsItem BROWN_DYED_CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.BROWN_DYED_CAT_EARS, new BrownCatEarsItem());
	public static final BlackCatEarsItem BLACK_DYED_CAT_EARS = Registry.register(BuiltInRegistries.ITEM, ItemIds.BLACK_DYED_CAT_EARS, new BlackCatEarsItem());

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
			output.accept(Items.COLLAR);
			output.accept(Items.BELL_COLLAR);
		})
		.build();

		public static final ResourceKey<CreativeModeTab> DYED_TAB_KEY = ResourceKey.create(
			BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(CatEars.MOD_ID, "dyed_tab")
		);

		public static final CreativeModeTab DYED_TAB = FabricCreativeModeTab.builder()
		.icon(() -> new ItemStack(Items.WHITE_DYED_CAT_TAIL))
		.title(Component.translatable("creativeTab.pixton_dyed"))
		.displayItems((params, output) -> {
			output.accept(Items.WHITE_DYED_CAT_EARS);
			output.accept(Items.RED_DYED_CAT_EARS);
			output.accept(Items.ORANGE_DYED_CAT_EARS);
			output.accept(Items.YELLOW_DYED_CAT_EARS);
			output.accept(Items.LIME_DYED_CAT_EARS);
			output.accept(Items.GREEN_DYED_CAT_EARS);
			output.accept(Items.LIGHT_BLUE_DYED_CAT_EARS);
			output.accept(Items.CYAN_DYED_CAT_EARS);
			output.accept(Items.BLUE_DYED_CAT_EARS);
			output.accept(Items.PINK_DYED_CAT_EARS);
			output.accept(Items.MAGENTA_DYED_CAT_EARS);
			output.accept(Items.PURPLE_DYED_CAT_EARS);
			output.accept(Items.LIGHT_GRAY_DYED_CAT_EARS);
			output.accept(Items.GRAY_DYED_CAT_EARS);
			output.accept(Items.BROWN_DYED_CAT_EARS);
			output.accept(Items.BLACK_DYED_CAT_EARS);
			output.accept(Items.WHITE_DYED_CAT_TAIL);
			output.accept(Items.RED_DYED_CAT_TAIL);
			output.accept(Items.ORANGE_DYED_CAT_TAIL);
			output.accept(Items.YELLOW_DYED_CAT_TAIL);
			output.accept(Items.LIME_DYED_CAT_TAIL);
			output.accept(Items.GREEN_DYED_CAT_TAIL);
			output.accept(Items.LIGHT_BLUE_DYED_CAT_TAIL);
			output.accept(Items.CYAN_DYED_CAT_TAIL);
			output.accept(Items.BLUE_DYED_CAT_TAIL);
			output.accept(Items.PINK_DYED_CAT_TAIL);
			output.accept(Items.MAGENTA_DYED_CAT_TAIL);
			output.accept(Items.PURPLE_DYED_CAT_TAIL);
			output.accept(Items.LIGHT_GRAY_DYED_CAT_TAIL);
			output.accept(Items.GRAY_DYED_CAT_TAIL);
			output.accept(Items.BROWN_DYED_CAT_TAIL);
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
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, DYED_TAB_KEY, DYED_TAB);
    }
}
