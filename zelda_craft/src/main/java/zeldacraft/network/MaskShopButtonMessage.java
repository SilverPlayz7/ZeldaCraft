package zeldacraft.network;

import zeldacraft.procedures.ResetMaskShopProcedure;
import zeldacraft.procedures.GetContractButtonProcedure;
import zeldacraft.procedures.BuyMaskButtonProcedure;
import zeldacraft.procedures.BunnyHoodButtonProcedure;
import zeldacraft.procedures.BlastMaskButtonProcedure;

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
public class MaskShopButtonMessage {
	private final int buttonID, x, y, z;

	public MaskShopButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public MaskShopButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(MaskShopButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(MaskShopButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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

			ResetMaskShopProcedure.execute(entity);
		}
		if (buttonID == 2) {

			BunnyHoodButtonProcedure.execute(entity);
		}
		if (buttonID == 3) {

			BlastMaskButtonProcedure.execute(entity);
		}
		if (buttonID == 4) {

			BuyMaskButtonProcedure.execute(world, entity);
		}
		if (buttonID == 5) {

			GetContractButtonProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ZeldaCraftMod.addNetworkMessage(MaskShopButtonMessage.class, MaskShopButtonMessage::buffer, MaskShopButtonMessage::new, MaskShopButtonMessage::handler);
	}
}