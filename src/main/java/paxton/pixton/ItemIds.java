package paxton.pixton;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.alchemy.Potion;

public class ItemIds {
    public static ResourceKey<Item> create(String name) {
		// Create the item key.
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CatEars.MOD_ID, name));
	}

	private static ResourceKey<Potion> createpotion(String name) {
		Identifier id = Identifier.fromNamespaceAndPath(CatEars.MOD_ID, name);
		return ResourceKey.create(Registries.POTION, id);
	}

    public static final ResourceKey<Item> CAT_EARS = create("cat_ears");

	public static final ResourceKey<Item> ORB = create("orb");

	public static final ResourceKey<Item> DARK_ORB = create("dark_orb");

	public static final ResourceKey<Item> FOP_ORB = create("fop_orb");

	public static final ResourceKey<Item> BLACK_CAT_EARS = create("black_cat_ears");

	public static final ResourceKey<Item> CAT_TAIL = create("cat_tail");

	public static final ResourceKey<Item> FOP_EARS = create("fop_ears");

	public static final ResourceKey<Item> BLACK_CAT_TAIL = create("black_cat_tail");

	public static final ResourceKey<Item> FOP_TAIL = create("fop_tail");

	public static final ResourceKey<Item> DUD = create("dud");

	public static final ResourceKey<Item> BOTTLE = create("bottle");

	public static final ResourceKey<Item> VINYL = create("vinyl");

	public static final ResourceKey<Item> INFERNO = create("inferno");

	public static final ResourceKey<Item> SLIGHTLYWEATHERED = create("slightlyweathered");

	public static final ResourceKey<Item> WEATHEREDINFERNO = create("weatheredinferno");

	public static final ResourceKey<Item> WAXEDINFERNO = create("waxedinferno");

	public static final ResourceKey<Item> WAXEDSLIGHTLYWEATHERED = create("waxedslightlyweathered");

	public static final ResourceKey<Item> WAXEDWEATHEREDINFERNO = create("waxedweatheredinferno");

	public static final ResourceKey<Item> BABYVINYL = create("babyvinyl");

	public static final ResourceKey<Item> BABY = create("baby");

	public static final ResourceKey<Potion> BECOME_POTION = createpotion("becomepotion");

	public static final ResourceKey<Item> COLLAR = create("collar");

	public static final ResourceKey<Item> BELL_COLLAR = create("bell_collar");

	public static final ResourceKey<Item> WHITE_DYED_CAT_TAIL = create("white_dyed_cat_tail");

	public static final ResourceKey<Item> BLACK_DYED_CAT_TAIL = create("black_dyed_cat_tail");

	public static final ResourceKey<Item> RED_DYED_CAT_TAIL = create("red_dyed_cat_tail");

	public static final ResourceKey<Item> ORANGE_DYED_CAT_TAIL = create("orange_dyed_cat_tail");

	public static final ResourceKey<Item> YELLOW_DYED_CAT_TAIL = create("yellow_dyed_cat_tail");

	public static final ResourceKey<Item> LIME_DYED_CAT_TAIL = create("lime_dyed_cat_tail");

	public static final ResourceKey<Item> GREEN_DYED_CAT_TAIL = create("green_dyed_cat_tail");

	public static final ResourceKey<Item> LIGHT_BLUE_DYED_CAT_TAIL = create("light_blue_dyed_cat_tail");

	public static final ResourceKey<Item> CYAN_DYED_CAT_TAIL = create("cyan_dyed_cat_tail");

	public static final ResourceKey<Item> BLUE_DYED_CAT_TAIL = create("blue_dyed_cat_tail");

	public static final ResourceKey<Item> PINK_DYED_CAT_TAIL = create("pink_dyed_cat_tail");

	public static final ResourceKey<Item> MAGENTA_DYED_CAT_TAIL = create("magenta_dyed_cat_tail");

	public static final ResourceKey<Item> PURPLE_DYED_CAT_TAIL = create("purple_dyed_cat_tail");

	public static final ResourceKey<Item> BROWN_DYED_CAT_TAIL = create("brown_dyed_cat_tail");

	public static final ResourceKey<Item> GRAY_DYED_CAT_TAIL = create("gray_dyed_cat_tail");

	public static final ResourceKey<Item> LIGHT_GRAY_DYED_CAT_TAIL = create("light_gray_dyed_cat_tail");
}
