package zeldacraft.procedures;

import net.minecraft.world.entity.Entity;

public class MasterSwordBeamProjectileWhileProjectileFlyingTickProcedure {
	public static void execute(Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		immediatesourceentity.getPersistentData().putDouble("Despawn", (immediatesourceentity.getPersistentData().getDouble("Despawn") + 1));
		immediatesourceentity.setNoGravity(true);
		if (immediatesourceentity.getPersistentData().getDouble("Despawn") == 25) {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
	}
}
