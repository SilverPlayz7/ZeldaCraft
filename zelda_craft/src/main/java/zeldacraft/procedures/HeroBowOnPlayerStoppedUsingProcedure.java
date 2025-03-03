package zeldacraft.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

public class HeroBowOnPlayerStoppedUsingProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("BowLoading") && entity.getPersistentData().getDouble("BowPull") > 3) {
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, (float) (2 * (entity.getPersistentData().getDouble("BowPull") / itemstack.getOrCreateTag().getDouble("BowMaxPull"))), 1);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) (2 * (entity.getPersistentData().getDouble("BowPull") / itemstack.getOrCreateTag().getDouble("BowMaxPull"))), 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
		}
		entity.getPersistentData().putBoolean("BowLoading", false);
		entity.getPersistentData().putDouble("BowPull", 0);
	}
}
