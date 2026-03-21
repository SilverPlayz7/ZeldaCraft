package zeldacraft.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class RupeeCountOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(EquipedWalletProcedure.execute(entity).getItem(), lv).isPresent() : false) {
			return true;
		}
		return false;
	}
}