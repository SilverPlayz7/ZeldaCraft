package zeldacraft.procedures;

import net.minecraft.world.entity.Entity;

public class HeroBowPropertyValueProviderProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getPersistentData().getDouble("BowPull") / 20;
	}
}
