
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package zeldacraft.init;

import zeldacraft.world.inventory.WalletWithdrawMenu;
import zeldacraft.world.inventory.WalletDepositMenu;
import zeldacraft.world.inventory.SwitchTimerSetMenu;
import zeldacraft.world.inventory.StatueMenuMenu;
import zeldacraft.world.inventory.OcarinaBlankMenu;
import zeldacraft.world.inventory.MaskShopMenu;
import zeldacraft.world.inventory.ChestMenu;

import zeldacraft.ZeldaCraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class ZeldaCraftModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ZeldaCraftMod.MODID);
	public static final RegistryObject<MenuType<ChestMenu>> CHEST = REGISTRY.register("chest", () -> IForgeMenuType.create(ChestMenu::new));
	public static final RegistryObject<MenuType<OcarinaBlankMenu>> OCARINA_BLANK = REGISTRY.register("ocarina_blank", () -> IForgeMenuType.create(OcarinaBlankMenu::new));
	public static final RegistryObject<MenuType<StatueMenuMenu>> STATUE_MENU = REGISTRY.register("statue_menu", () -> IForgeMenuType.create(StatueMenuMenu::new));
	public static final RegistryObject<MenuType<WalletDepositMenu>> WALLET_DEPOSIT = REGISTRY.register("wallet_deposit", () -> IForgeMenuType.create(WalletDepositMenu::new));
	public static final RegistryObject<MenuType<WalletWithdrawMenu>> WALLET_WITHDRAW = REGISTRY.register("wallet_withdraw", () -> IForgeMenuType.create(WalletWithdrawMenu::new));
	public static final RegistryObject<MenuType<MaskShopMenu>> MASK_SHOP = REGISTRY.register("mask_shop", () -> IForgeMenuType.create(MaskShopMenu::new));
	public static final RegistryObject<MenuType<SwitchTimerSetMenu>> SWITCH_TIMER_SET = REGISTRY.register("switch_timer_set", () -> IForgeMenuType.create(SwitchTimerSetMenu::new));
}
