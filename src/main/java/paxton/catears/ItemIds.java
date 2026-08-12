package paxton.catears;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.resources.Identifier;

public class ItemIds {
    public static ResourceKey<Item> create(String name) {
		// Create the item key.
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("cat-ears", name));
	}

    public static final ResourceKey<Item> CAT_EARS = create("cat_ears");
}
