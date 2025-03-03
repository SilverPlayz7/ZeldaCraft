package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import zeldacraft.init.ZeldaCraftModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class HookShotProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/axe"))) || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ZeldaCraftModBlocks.HOOKSHOT_TARGET.get()) {
			{
				double _setval = immediatesourceentity.getX() - entity.getX();
				entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HookX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = immediatesourceentity.getY() - entity.getY();
				entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HookY = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = immediatesourceentity.getZ() - entity.getZ();
				entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HookZ = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = true;
				entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Hooked = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
