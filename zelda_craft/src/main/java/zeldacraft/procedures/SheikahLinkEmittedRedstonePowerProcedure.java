package zeldacraft.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;

public class SheikahLinkEmittedRedstonePowerProcedure {
	public static double execute(BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) == 3) {
			return 15;
		}
		return 0;
	}
}