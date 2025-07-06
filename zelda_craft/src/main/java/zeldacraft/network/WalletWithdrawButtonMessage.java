
package zeldacraft.network;

import zeldacraft.world.inventory.WalletWithdrawMenu;

import zeldacraft.procedures.Withdraw5Procedure;
import zeldacraft.procedures.Withdraw50Procedure;
import zeldacraft.procedures.Withdraw300Procedure;
import zeldacraft.procedures.Withdraw20Procedure;
import zeldacraft.procedures.Withdraw1Procedure;
import zeldacraft.procedures.OpenDepositMenuProcedure;

import zeldacraft.ZeldaCraftMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WalletWithdrawButtonMessage {
	private final int buttonID, x, y, z;

	public WalletWithdrawButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public WalletWithdrawButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(WalletWithdrawButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(WalletWithdrawButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = WalletWithdrawMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Withdraw1Procedure.execute(world, entity);
		}
		if (buttonID == 1) {

			Withdraw5Procedure.execute(world, entity);
		}
		if (buttonID == 2) {

			Withdraw20Procedure.execute(world, entity);
		}
		if (buttonID == 3) {

			Withdraw50Procedure.execute(world, entity);
		}
		if (buttonID == 5) {

			Withdraw300Procedure.execute(world, entity);
		}
		if (buttonID == 6) {

			OpenDepositMenuProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ZeldaCraftMod.addNetworkMessage(WalletWithdrawButtonMessage.class, WalletWithdrawButtonMessage::buffer, WalletWithdrawButtonMessage::new, WalletWithdrawButtonMessage::handler);
	}
}
