package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModBlocks;

import net.minecraft.world.level.block.state.BlockState;

public class DoorSizeRegistrationProcedure {
	public static String execute(BlockState blockstate) {
		if (blockstate.getBlock() == ZeldaCraftModBlocks.DUNGEON_DOOR.get() || blockstate.getBlock() == ZeldaCraftModBlocks.LOCKED_DUNGEON_DOOR.get()) {
			return "[1,2]";
		}
		if (blockstate.getBlock() == ZeldaCraftModBlocks.BIG_DUNGEON_DOOR.get() || blockstate.getBlock() == ZeldaCraftModBlocks.LOCKED_BIG_DUNGEON_DOOR.get()) {
			return "[2,3]";
		}
		return "";
	}
}