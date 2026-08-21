package paxton.pixton;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.resources.Identifier;

public class ItemIds {
    public static ResourceKey<Item> create(String name) {
		// Create the item key.
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CatEars.MOD_ID, name));
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
}
