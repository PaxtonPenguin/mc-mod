package paxton.pixton;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;

public class Pedestal extends BaseEntityBlock{
    public Pedestal(Properties settings) {
		super(settings);
	}

	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		return simpleCodec(Pedestal::new);
	}

	//@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new PedestalEntity(pos, state);
	}

    @Override
protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
	if (!level.isClientSide() && level.getBlockEntity(pos) instanceof PedestalEntity pedestal) {
		player.openMenu(pedestal);
		CatEars.LOGGER.info("opened pedestal");
	}

	return InteractionResult.SUCCESS;
}
}
