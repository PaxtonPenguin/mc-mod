package paxton.catears;

import org.jspecify.annotations.NonNull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.network.chat.Component;

public class PedestalEntity extends BlockEntity implements ImplementedContainer, MenuProvider {
	public static final int CONTAINER_SIZE = 1;
	private final NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);

	@Override
	public NonNullList<ItemStack> getItems() {
		return this.items;
	}

	public PedestalEntity(BlockPos pos, BlockState state) {
		super(BlockEntities.PEDESTAL, pos, state);
	}

	@Override
protected void loadAdditional(ValueInput input) {
	super.loadAdditional(input);
	ContainerHelper.loadAllItems(input, this.items);
}

@Override
protected void saveAdditional(ValueOutput output) {
	ContainerHelper.saveAllItems(output, this.items);
	super.saveAdditional(output);
}

	@Override
	@NonNull
	public Component getDisplayName() {
		return Component.translatable("block.example-mod.pedestal");
	}

	@Override
	public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
		return new PedestalMenu(containerId, inventory, this);
	}

@Override
public boolean stillValid(Player player) {
	return Container.stillValidBlockEntity(this, player);
}
}
