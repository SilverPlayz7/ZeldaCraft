package zeldacraft.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class HeroBowRightclickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("BowLoading", true);
		if (!itemstack.getOrCreateTag().getBoolean("FirstLoad")) {
			itemstack.getOrCreateTag().putBoolean("FirstLoad", true);
			itemstack.getOrCreateTag().putDouble("ProjectileDamage", 1.5);
			itemstack.getOrCreateTag().putDouble("ProjectileSpeed", 1);
			itemstack.getOrCreateTag().putDouble("BowMaxPull", 20);
		}
	}
}
