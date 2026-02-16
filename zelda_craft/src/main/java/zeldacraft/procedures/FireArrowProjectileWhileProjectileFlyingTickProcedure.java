package zeldacraft.procedures;

import zeldacraft.configuration.ZeldaCraftConfigConfiguration;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.ParticleTypes;

public class FireArrowProjectileWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (ZeldaCraftConfigConfiguration.PARTICLE_TRAIL.get() == true) {
			world.addParticle(ParticleTypes.SMALL_FLAME, x, y, z, 0, 0, 0);
		}
	}
}