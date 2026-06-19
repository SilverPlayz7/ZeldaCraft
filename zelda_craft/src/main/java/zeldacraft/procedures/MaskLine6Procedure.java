package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import net.minecraft.world.entity.Entity;

public class MaskLine6Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).selectedmask == 1) {
			return "";
		}
		if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).selectedmask == 2) {
			return "";
		}
		return "";
	}
}