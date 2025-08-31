/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package zeldacraft.init;

import zeldacraft.world.inventory.WalletWithdrawMenu;
import zeldacraft.world.inventory.WalletDepositMenu;
import zeldacraft.world.inventory.SwitchTimerSetMenu;
import zeldacraft.world.inventory.StatueNameSetMenu;
import zeldacraft.world.inventory.StatueMenuMenu;
import zeldacraft.world.inventory.OcarinaBlankMenu;
import zeldacraft.world.inventory.MaskShopMenu;
import zeldacraft.world.inventory.ChestMenu;

import zeldacraft.network.MenuStateUpdateMessage;

import zeldacraft.ZeldaCraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import java.util.Map;

public class ZeldaCraftModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ZeldaCraftMod.MODID);
	public static final RegistryObject<MenuType<ChestMenu>> CHEST = REGISTRY.register("chest", () -> IForgeMenuType.create(ChestMenu::new));
	public static final RegistryObject<MenuType<OcarinaBlankMenu>> OCARINA_BLANK = REGISTRY.register("ocarina_blank", () -> IForgeMenuType.create(OcarinaBlankMenu::new));
	public static final RegistryObject<MenuType<StatueMenuMenu>> STATUE_MENU = REGISTRY.register("statue_menu", () -> IForgeMenuType.create(StatueMenuMenu::new));
	public static final RegistryObject<MenuType<WalletDepositMenu>> WALLET_DEPOSIT = REGISTRY.register("wallet_deposit", () -> IForgeMenuType.create(WalletDepositMenu::new));
	public static final RegistryObject<MenuType<WalletWithdrawMenu>> WALLET_WITHDRAW = REGISTRY.register("wallet_withdraw", () -> IForgeMenuType.create(WalletWithdrawMenu::new));
	public static final RegistryObject<MenuType<MaskShopMenu>> MASK_SHOP = REGISTRY.register("mask_shop", () -> IForgeMenuType.create(MaskShopMenu::new));
	public static final RegistryObject<MenuType<SwitchTimerSetMenu>> SWITCH_TIMER_SET = REGISTRY.register("switch_timer_set", () -> IForgeMenuType.create(SwitchTimerSetMenu::new));
	public static final RegistryObject<MenuType<StatueNameSetMenu>> STATUE_NAME_SET = REGISTRY.register("statue_name_set", () -> IForgeMenuType.create(StatueNameSetMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				ZeldaCraftMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof ZeldaCraftModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}