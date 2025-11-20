package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import zeldacraft.init.ZeldaCraftModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class ContractShowProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).selectedmask == 1) {
			if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).hasBunny == false
					&& !(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ZeldaCraftModItems.BUNNY_HOOD_CONTRACT.get())) : false)) {
				return true;
			}
		} else if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).selectedmask == 2) {
			if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).hasBlast == false
					&& !(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ZeldaCraftModItems.BLAST_MASK_CONTRACT.get())) : false)) {
				return true;
			}
		}
		return false;
	}
}