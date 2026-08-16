package paxton.catears;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;

public class BlockEntities {
    public static final BlockEntityType<PedestalEntity> PEDESTAL =
		register("pedestal", PedestalEntity::new, Blocks.PEDESTAL);

	private static <T extends BlockEntity> BlockEntityType<T> register(
		String name,
		FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
		Block... blocks
) {
	Identifier id = Identifier.fromNamespaceAndPath("cat-ears", name);
	return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
}

public static void initialize() {
	}

}
