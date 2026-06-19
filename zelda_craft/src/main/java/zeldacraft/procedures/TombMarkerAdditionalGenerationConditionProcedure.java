package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class TombMarkerAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sy = -60;
		for (int index0 = 0; index0 < 60; index0++) {
			if ((world.getBlockState(BlockPos.containing(x, y + sy, z))).getBlock() == ZeldaCraftModBlocks.ROYAL_SARCOPHAGUS.get()) {
				found = true;
				break;
			}
			sy = sy + 1;
		}
		if (found == true) {
			return true;
		}
		return false;
	}
}