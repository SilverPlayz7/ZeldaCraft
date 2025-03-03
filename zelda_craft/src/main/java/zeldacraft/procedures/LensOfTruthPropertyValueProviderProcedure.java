package zeldacraft.procedures;

import net.minecraft.world.entity.Entity;

public class LensOfTruthPropertyValueProviderProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getPersistentData().getDouble("UsingLens");
	}
}
