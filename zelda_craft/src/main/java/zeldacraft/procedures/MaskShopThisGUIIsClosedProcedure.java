package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import net.minecraft.world.entity.Entity;

public class MaskShopThisGUIIsClosedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 0;
			entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.selectedmask = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = 0;
			entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MaskPrice = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
