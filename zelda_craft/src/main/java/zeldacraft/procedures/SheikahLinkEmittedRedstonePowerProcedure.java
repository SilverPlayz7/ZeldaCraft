package zeldacraft.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;

public class SheikahLinkEmittedRedstonePowerProcedure {
	public static double execute(BlockState blockstate) {
		if (blockstate.getBlock().getStateDefinition().getProperty("enabled") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) {
			return 15;
		}
		return 0;
	}
}
