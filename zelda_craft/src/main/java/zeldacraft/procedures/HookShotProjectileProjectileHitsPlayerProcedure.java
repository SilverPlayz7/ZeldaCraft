package zeldacraft.procedures;

import net.minecraft.world.entity.Entity;

public class HookShotProjectileProjectileHitsPlayerProcedure {
	public static void execute(Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (immediatesourceentity.getPersistentData().getDouble("DistanceTime") == 10) {
			if (sourceentity == entity) {
				if (!immediatesourceentity.level().isClientSide())
					immediatesourceentity.discard();
			}
		}
	}
}
