package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModEntities;

import zeldacraft.entity.FierceDeitySwordBeamEntity;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class FierceDeitySwordEntitySwingsItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean swordbeam = false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
			if (swordbeam == true) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new FierceDeitySwordBeamEntity(ZeldaCraftModEntities.FIERCE_DEITY_SWORD_BEAM.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 7, 1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 0.8, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				swordbeam = false;
			} else {
				swordbeam = true;
			}
		}
	}
}
