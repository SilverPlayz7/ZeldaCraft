package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import zeldacraft.init.ZeldaCraftModMenus;
import zeldacraft.init.ZeldaCraftModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class GetContractButtonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
					ItemStack stack = _menu.getSlots().get(sltid).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(1) == 0) {
			if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).selectedmask == 1) {
				if (!(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ZeldaCraftModItems.BUNNY_HOOD_CONTRACT.get())) : false)
						&& (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).hasBunny == false) {
					if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
						ItemStack _setstack = new ItemStack(ZeldaCraftModItems.BUNNY_HOOD_CONTRACT.get()).copy();
						_setstack.setCount(1);
						_menu.getSlots().get(1).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
			}
			if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).selectedmask == 2) {
				if (!(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ZeldaCraftModItems.BLAST_MASK_CONTRACT.get())) : false)
						&& (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).hasBlast == false) {
					if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
						ItemStack _setstack = new ItemStack(ZeldaCraftModItems.BLAST_MASK_CONTRACT.get()).copy();
						_setstack.setCount(1);
						_menu.getSlots().get(1).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
			}
		}
	}
}