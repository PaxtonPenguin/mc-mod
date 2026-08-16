package paxton.catears;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;

public class Blocks {
    private static Block register(BlockItemId id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
		// Create the block instance
		Block block = register(id, blockFactory, properties);

		// Create the block item instance
		BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item()));
		Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);

		return block;
	}

    public static final Block GMOD = register(
		BlockIds.GMOD,
		Block::new,
		BlockBehaviour.Properties.of().sound(SoundType.GRASS)
);

    public static final Block PEDESTAL = register(
		BlockIds.PEDESTAL,
		Block::new,
		BlockBehaviour.Properties.of()
);

    public static void initialize() {
	}
}
