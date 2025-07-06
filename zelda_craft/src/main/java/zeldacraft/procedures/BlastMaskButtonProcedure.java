package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

public class BlastMaskButtonProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		{
			double _setval = 2;
			entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.selectedmask = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = 15;
			entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MaskPrice = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("zelda_craft:blast_mask_4"))).isDone()) {
			return true;
		}
		return false;
	}
}
