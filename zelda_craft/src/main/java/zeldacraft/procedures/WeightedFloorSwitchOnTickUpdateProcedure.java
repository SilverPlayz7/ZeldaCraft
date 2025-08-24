package zeldacraft.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;

public class WeightedFloorSwitchOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("triggered") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) == true) {
			if (!(!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), 1, 1, 1), e -> true).isEmpty()
					|| !world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), 1, 1, 1), e -> true).isEmpty())) {
				FloorSwitchOnBlockRightClickedProcedure.execute(world, x, y, z, blockstate);
			}
		}
	}
}
