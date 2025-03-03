
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package zeldacraft.init;

import zeldacraft.client.gui.WalletWithdrawScreen;
import zeldacraft.client.gui.WalletDepositScreen;
import zeldacraft.client.gui.StatueMenuScreen;
import zeldacraft.client.gui.OcarinaBlankScreen;
import zeldacraft.client.gui.MaskShopScreen;
import zeldacraft.client.gui.ChestScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ZeldaCraftModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(ZeldaCraftModMenus.CHEST.get(), ChestScreen::new);
			MenuScreens.register(ZeldaCraftModMenus.OCARINA_BLANK.get(), OcarinaBlankScreen::new);
			MenuScreens.register(ZeldaCraftModMenus.STATUE_MENU.get(), StatueMenuScreen::new);
			MenuScreens.register(ZeldaCraftModMenus.WALLET_DEPOSIT.get(), WalletDepositScreen::new);
			MenuScreens.register(ZeldaCraftModMenus.WALLET_WITHDRAW.get(), WalletWithdrawScreen::new);
			MenuScreens.register(ZeldaCraftModMenus.MASK_SHOP.get(), MaskShopScreen::new);
		});
	}
}
