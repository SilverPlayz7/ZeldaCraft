package zeldacraft.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class DungeonDoorBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).canBeReplaced() || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == blockstate.getBlock()
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == blockstate.getBlock()) {
			return true;
		}
		return false;
	}
}