package paxton.catears;

import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.world.level.block.Block;

public class BlockIds {
    private static BlockItemId create(String name) {
		Identifier id = Identifier.fromNamespaceAndPath("cat-ears", name);
		return BlockItemId.create(id, id);
	}

    public static final BlockItemId GMOD = create("gmod");

    public static final BlockItemId PEDESTAL = create("pedestal");

    public static final BlockItemId WHITE_TUFF = create("white_tuff");

}
