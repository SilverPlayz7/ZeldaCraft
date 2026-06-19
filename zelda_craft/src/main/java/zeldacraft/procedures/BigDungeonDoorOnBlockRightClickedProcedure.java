package zeldacraft.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;

public class BigDungeonDoorOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (!world.isClientSide()) {
			DoorActivatorProcedure.execute(world, x, y, z, blockstate);
		}
	}
}