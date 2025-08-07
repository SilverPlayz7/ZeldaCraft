package zeldacraft.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class Show4YProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("OcarinaNote4")).startsWith("y")) {
			return true;
		}
		return false;
	}
}
