package zeldacraft.procedures;

import zeldacraft.configuration.ZeldaCraftConfigConfiguration;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class IceArrowProjectileWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (ZeldaCraftConfigConfiguration.PARTICLE_TRAIL.get() == true) {
			world.addParticle(ParticleTypes.SNOWFLAKE, x, y, z, 0, 0, 0);
		}
		if (immediatesourceentity.isInWater()) {
			int horizontalRadiusHemiBot = (int) 4 - 1;
			int verticalRadiusHemiBot = (int) 4;
			int yIterationsHemiBot = verticalRadiusHemiBot;
			for (int i = -yIterationsHemiBot; i <= 0; i++) {
				if (i == -verticalRadiusHemiBot) {
					continue;
				}
				for (int xi = -horizontalRadiusHemiBot; xi <= horizontalRadiusHemiBot; xi++) {
					for (int zi = -horizontalRadiusHemiBot; zi <= horizontalRadiusHemiBot; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot) + (i * i) / (double) (verticalRadiusHemiBot * verticalRadiusHemiBot)
								+ (zi * zi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot);
						if (distanceSq <= 1.0) {
							if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() instanceof LiquidBlock) {
								world.setBlock(BlockPos.containing(x, y, z), Blocks.FROSTED_ICE.defaultBlockState(), 3);
							}
						}
					}
				}
			}
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
	}
}