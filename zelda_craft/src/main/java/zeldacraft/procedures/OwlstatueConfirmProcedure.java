package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModMenus;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class OwlstatueConfirmProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (!((entity instanceof Player _entity1 && _entity1.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(0, "statue", "") : "").isEmpty()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putString("statueName",
								(((entity instanceof Player _entity2 && _entity2.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu2) ? _menu2.getMenuState(0, "statue", "") : "").replace(",", ".")));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("hasName", true);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y - 1, z), _level.getBlockState(BlockPos.containing(x, y - 1, z)).getBlock());
				if (entity instanceof Player _player)
					_player.closeContainer();
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Name cannot be empty"), true);
			}
		}
	}
}