package zeldacraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.ParticleTypes;

public class ShockArrowProjectileWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double multiplier = 0;
		double damage = 0;
		world.addParticle(ParticleTypes.WAX_OFF, x, y, z, 0, 0, 0);
	}
}