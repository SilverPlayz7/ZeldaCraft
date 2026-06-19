package zeldacraft.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class LullabySwitchBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((getDirectionFromBlockState(blockstate)) == Direction.UP) {
			if (world.getBlockState(BlockPos.containing(x, y - 1, z)).isFaceSturdy(world, BlockPos.containing(x, y - 1, z), (getDirectionFromBlockState(blockstate)))) {
				return true;
			}
		} else if ((getDirectionFromBlockState(blockstate)) == Direction.DOWN) {
			if (world.getBlockState(BlockPos.containing(x, y + 1, z)).isFaceSturdy(world, BlockPos.containing(x, y + 1, z), (getDirectionFromBlockState(blockstate)))) {
				return true;
			}
		} else if ((getDirectionFromBlockState(blockstate)) == Direction.NORTH) {
			if (world.getBlockState(BlockPos.containing(x, y, z + 1)).isFaceSturdy(world, BlockPos.containing(x, y, z + 1), (getDirectionFromBlockState(blockstate)))) {
				return true;
			}
		} else if ((getDirectionFromBlockState(blockstate)) == Direction.SOUTH) {
			if (world.getBlockState(BlockPos.containing(x, y, z - 1)).isFaceSturdy(world, BlockPos.containing(x, y, z - 1), (getDirectionFromBlockState(blockstate)))) {
				return true;
			}
		} else if ((getDirectionFromBlockState(blockstate)) == Direction.WEST) {
			if (world.getBlockState(BlockPos.containing(x + 1, y, z)).isFaceSturdy(world, BlockPos.containing(x + 1, y, z), (getDirectionFromBlockState(blockstate)))) {
				return true;
			}
		} else if ((getDirectionFromBlockState(blockstate)) == Direction.EAST) {
			if (world.getBlockState(BlockPos.containing(x - 1, y, z)).isFaceSturdy(world, BlockPos.containing(x - 1, y, z), (getDirectionFromBlockState(blockstate)))) {
				return true;
			}
		}
		return false;
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (prop instanceof DirectionProperty dp)
			return blockState.getValue(dp);
		prop = blockState.getBlock().getStateDefinition().getProperty("axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
	}
}