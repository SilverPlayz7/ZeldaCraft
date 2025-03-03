package zeldacraft.network;

import zeldacraft.ZeldaCraftMod;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ZeldaCraftModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ZeldaCraftMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Warp1X = original.Warp1X;
			clone.Warp1Y = original.Warp1Y;
			clone.Warp1Z = original.Warp1Z;
			clone.HasWarp1 = original.HasWarp1;
			clone.Warp2X = original.Warp2X;
			clone.Warp2Y = original.Warp2Y;
			clone.Warp2Z = original.Warp2Z;
			clone.HasWarp2 = original.HasWarp2;
			clone.Warp3X = original.Warp3X;
			clone.Warp3Y = original.Warp3Y;
			clone.Warp3Z = original.Warp3Z;
			clone.HasWarp3 = original.HasWarp3;
			clone.Warp4X = original.Warp4X;
			clone.Warp4Y = original.Warp4Y;
			clone.Warp4Z = original.Warp4Z;
			clone.HasWarp4 = original.HasWarp4;
			clone.Warp5X = original.Warp5X;
			clone.Warp5Y = original.Warp5Y;
			clone.Warp5Z = original.Warp5Z;
			clone.HasWarp5 = original.HasWarp5;
			clone.BeenResed = original.BeenResed;
			clone.BombsCrafted = original.BombsCrafted;
			clone.CreepersDetonated = original.CreepersDetonated;
			clone.ExplosiveKills = original.ExplosiveKills;
			if (!event.isWasDeath()) {
				clone.OcarinaNote1 = original.OcarinaNote1;
				clone.OcarinaNote2 = original.OcarinaNote2;
				clone.OcarinaNote3 = original.OcarinaNote3;
				clone.OcarinaNote4 = original.OcarinaNote4;
				clone.OcarinaNote5 = original.OcarinaNote5;
				clone.OcarinaNote6 = original.OcarinaNote6;
				clone.jumpvar = original.jumpvar;
				clone.DungeontoLoad = original.DungeontoLoad;
				clone.BoomerangOwner = original.BoomerangOwner;
				clone.HookX = original.HookX;
				clone.HookY = original.HookY;
				clone.HookZ = original.HookZ;
				clone.Hooked = original.Hooked;
				clone.selectedmask = original.selectedmask;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("zelda_craft", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double OcarinaNote1 = 0;
		public double OcarinaNote2 = 0;
		public double OcarinaNote3 = 0;
		public double OcarinaNote4 = 0;
		public double OcarinaNote5 = 0;
		public double OcarinaNote6 = 0;
		public double Warp1X = 0;
		public double Warp1Y = 0;
		public double Warp1Z = 0;
		public boolean HasWarp1 = false;
		public double Warp2X = 0;
		public double Warp2Y = 0;
		public double Warp2Z = 0;
		public boolean HasWarp2 = false;
		public double Warp3X = 0;
		public double Warp3Y = 0;
		public double Warp3Z = 0;
		public boolean HasWarp3 = false;
		public double Warp4X = 0;
		public double Warp4Y = 0;
		public double Warp4Z = 0;
		public boolean HasWarp4 = false;
		public double Warp5X = 0;
		public double Warp5Y = 0;
		public double Warp5Z = 0;
		public boolean HasWarp5 = false;
		public boolean BeenResed = false;
		public double jumpvar = 0;
		public double DungeontoLoad = 0;
		public String BoomerangOwner = "\"\"";
		public double HookX = 0;
		public double HookY = 0;
		public double HookZ = 0;
		public boolean Hooked = false;
		public double BombsCrafted = 0;
		public double CreepersDetonated = 0;
		public double ExplosiveKills = 0;
		public double selectedmask = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				ZeldaCraftMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("OcarinaNote1", OcarinaNote1);
			nbt.putDouble("OcarinaNote2", OcarinaNote2);
			nbt.putDouble("OcarinaNote3", OcarinaNote3);
			nbt.putDouble("OcarinaNote4", OcarinaNote4);
			nbt.putDouble("OcarinaNote5", OcarinaNote5);
			nbt.putDouble("OcarinaNote6", OcarinaNote6);
			nbt.putDouble("Warp1X", Warp1X);
			nbt.putDouble("Warp1Y", Warp1Y);
			nbt.putDouble("Warp1Z", Warp1Z);
			nbt.putBoolean("HasWarp1", HasWarp1);
			nbt.putDouble("Warp2X", Warp2X);
			nbt.putDouble("Warp2Y", Warp2Y);
			nbt.putDouble("Warp2Z", Warp2Z);
			nbt.putBoolean("HasWarp2", HasWarp2);
			nbt.putDouble("Warp3X", Warp3X);
			nbt.putDouble("Warp3Y", Warp3Y);
			nbt.putDouble("Warp3Z", Warp3Z);
			nbt.putBoolean("HasWarp3", HasWarp3);
			nbt.putDouble("Warp4X", Warp4X);
			nbt.putDouble("Warp4Y", Warp4Y);
			nbt.putDouble("Warp4Z", Warp4Z);
			nbt.putBoolean("HasWarp4", HasWarp4);
			nbt.putDouble("Warp5X", Warp5X);
			nbt.putDouble("Warp5Y", Warp5Y);
			nbt.putDouble("Warp5Z", Warp5Z);
			nbt.putBoolean("HasWarp5", HasWarp5);
			nbt.putBoolean("BeenResed", BeenResed);
			nbt.putDouble("jumpvar", jumpvar);
			nbt.putDouble("DungeontoLoad", DungeontoLoad);
			nbt.putString("BoomerangOwner", BoomerangOwner);
			nbt.putDouble("HookX", HookX);
			nbt.putDouble("HookY", HookY);
			nbt.putDouble("HookZ", HookZ);
			nbt.putBoolean("Hooked", Hooked);
			nbt.putDouble("BombsCrafted", BombsCrafted);
			nbt.putDouble("CreepersDetonated", CreepersDetonated);
			nbt.putDouble("ExplosiveKills", ExplosiveKills);
			nbt.putDouble("selectedmask", selectedmask);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			OcarinaNote1 = nbt.getDouble("OcarinaNote1");
			OcarinaNote2 = nbt.getDouble("OcarinaNote2");
			OcarinaNote3 = nbt.getDouble("OcarinaNote3");
			OcarinaNote4 = nbt.getDouble("OcarinaNote4");
			OcarinaNote5 = nbt.getDouble("OcarinaNote5");
			OcarinaNote6 = nbt.getDouble("OcarinaNote6");
			Warp1X = nbt.getDouble("Warp1X");
			Warp1Y = nbt.getDouble("Warp1Y");
			Warp1Z = nbt.getDouble("Warp1Z");
			HasWarp1 = nbt.getBoolean("HasWarp1");
			Warp2X = nbt.getDouble("Warp2X");
			Warp2Y = nbt.getDouble("Warp2Y");
			Warp2Z = nbt.getDouble("Warp2Z");
			HasWarp2 = nbt.getBoolean("HasWarp2");
			Warp3X = nbt.getDouble("Warp3X");
			Warp3Y = nbt.getDouble("Warp3Y");
			Warp3Z = nbt.getDouble("Warp3Z");
			HasWarp3 = nbt.getBoolean("HasWarp3");
			Warp4X = nbt.getDouble("Warp4X");
			Warp4Y = nbt.getDouble("Warp4Y");
			Warp4Z = nbt.getDouble("Warp4Z");
			HasWarp4 = nbt.getBoolean("HasWarp4");
			Warp5X = nbt.getDouble("Warp5X");
			Warp5Y = nbt.getDouble("Warp5Y");
			Warp5Z = nbt.getDouble("Warp5Z");
			HasWarp5 = nbt.getBoolean("HasWarp5");
			BeenResed = nbt.getBoolean("BeenResed");
			jumpvar = nbt.getDouble("jumpvar");
			DungeontoLoad = nbt.getDouble("DungeontoLoad");
			BoomerangOwner = nbt.getString("BoomerangOwner");
			HookX = nbt.getDouble("HookX");
			HookY = nbt.getDouble("HookY");
			HookZ = nbt.getDouble("HookZ");
			Hooked = nbt.getBoolean("Hooked");
			BombsCrafted = nbt.getDouble("BombsCrafted");
			CreepersDetonated = nbt.getDouble("CreepersDetonated");
			ExplosiveKills = nbt.getDouble("ExplosiveKills");
			selectedmask = nbt.getDouble("selectedmask");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.OcarinaNote1 = message.data.OcarinaNote1;
					variables.OcarinaNote2 = message.data.OcarinaNote2;
					variables.OcarinaNote3 = message.data.OcarinaNote3;
					variables.OcarinaNote4 = message.data.OcarinaNote4;
					variables.OcarinaNote5 = message.data.OcarinaNote5;
					variables.OcarinaNote6 = message.data.OcarinaNote6;
					variables.Warp1X = message.data.Warp1X;
					variables.Warp1Y = message.data.Warp1Y;
					variables.Warp1Z = message.data.Warp1Z;
					variables.HasWarp1 = message.data.HasWarp1;
					variables.Warp2X = message.data.Warp2X;
					variables.Warp2Y = message.data.Warp2Y;
					variables.Warp2Z = message.data.Warp2Z;
					variables.HasWarp2 = message.data.HasWarp2;
					variables.Warp3X = message.data.Warp3X;
					variables.Warp3Y = message.data.Warp3Y;
					variables.Warp3Z = message.data.Warp3Z;
					variables.HasWarp3 = message.data.HasWarp3;
					variables.Warp4X = message.data.Warp4X;
					variables.Warp4Y = message.data.Warp4Y;
					variables.Warp4Z = message.data.Warp4Z;
					variables.HasWarp4 = message.data.HasWarp4;
					variables.Warp5X = message.data.Warp5X;
					variables.Warp5Y = message.data.Warp5Y;
					variables.Warp5Z = message.data.Warp5Z;
					variables.HasWarp5 = message.data.HasWarp5;
					variables.BeenResed = message.data.BeenResed;
					variables.jumpvar = message.data.jumpvar;
					variables.DungeontoLoad = message.data.DungeontoLoad;
					variables.BoomerangOwner = message.data.BoomerangOwner;
					variables.HookX = message.data.HookX;
					variables.HookY = message.data.HookY;
					variables.HookZ = message.data.HookZ;
					variables.Hooked = message.data.Hooked;
					variables.BombsCrafted = message.data.BombsCrafted;
					variables.CreepersDetonated = message.data.CreepersDetonated;
					variables.ExplosiveKills = message.data.ExplosiveKills;
					variables.selectedmask = message.data.selectedmask;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
