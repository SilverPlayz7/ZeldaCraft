package zeldacraft.procedures;

import zeldacraft.configuration.ZeldaCraftConfigConfiguration;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.ParticleTypes;

public class ShockArrowProjectileWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double multiplier = 0;
		double damage = 0;
		if (ZeldaCraftConfigConfiguration.PARTICLE_TRAIL.get() == true) {
			world.addParticle(ParticleTypes.WAX_OFF, x, y, z, 0, 0, 0);
		}
	}
}