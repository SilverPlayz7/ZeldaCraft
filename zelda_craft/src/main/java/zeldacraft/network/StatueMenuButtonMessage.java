package zeldacraft.network;

import zeldacraft.procedures.Warp5TeleportProcedure;
import zeldacraft.procedures.Warp5ClearProcedure;
import zeldacraft.procedures.Warp4TeleportProcedure;
import zeldacraft.procedures.Warp4ClearProcedure;
import zeldacraft.procedures.Warp3TeleportProcedure;
import zeldacraft.procedures.Warp3ClearProcedure;
import zeldacraft.procedures.Warp2TeleportProcedure;
import zeldacraft.procedures.Warp2ClearProcedure;
import zeldacraft.procedures.Warp1TeleportProcedure;
import zeldacraft.procedures.Warp1ClearProcedure;
import zeldacraft.procedures.SoaringNextPageProcedure;
import zeldacraft.procedures.SoaringBackPageProcedure;

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

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StatueMenuButtonMessage {
	private final int buttonID, x, y, z;

	public StatueMenuButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public StatueMenuButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(StatueMenuButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(StatueMenuButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Warp1TeleportProcedure.execute(world, entity);
		}
		if (buttonID == 1) {

			Warp2TeleportProcedure.execute(world, entity);
		}
		if (buttonID == 2) {

			Warp3TeleportProcedure.execute(world, entity);
		}
		if (buttonID == 3) {

			Warp4TeleportProcedure.execute(world, entity);
		}
		if (buttonID == 4) {

			Warp5TeleportProcedure.execute(world, entity);
		}
		if (buttonID == 5) {

			Warp1ClearProcedure.execute(world, entity);
		}
		if (buttonID == 6) {

			Warp2ClearProcedure.execute(world, entity);
		}
		if (buttonID == 7) {

			Warp3ClearProcedure.execute(world, entity);
		}
		if (buttonID == 8) {

			Warp4ClearProcedure.execute(world, entity);
		}
		if (buttonID == 9) {

			Warp5ClearProcedure.execute(world, entity);
		}
		if (buttonID == 10) {

			SoaringNextPageProcedure.execute(entity);
		}
		if (buttonID == 11) {

			SoaringBackPageProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ZeldaCraftMod.addNetworkMessage(StatueMenuButtonMessage.class, StatueMenuButtonMessage::buffer, StatueMenuButtonMessage::new, StatueMenuButtonMessage::handler);
	}
}