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
			clone.BeenResed = original.BeenResed;
			clone.BombsCrafted = original.BombsCrafted;
			clone.CreepersDetonated = original.CreepersDetonated;
			clone.ExplosiveKills = original.ExplosiveKills;
			clone.StepsRun = original.StepsRun;
			clone.TimedJumped = original.TimedJumped;
			clone.Fell50 = original.Fell50;
			clone.hasBunny = original.hasBunny;
			clone.hasBlast = original.hasBlast;
			if (!event.isWasDeath()) {
				clone.jumpvar = original.jumpvar;
				clone.DungeontoLoad = original.DungeontoLoad;
				clone.HookX = original.HookX;
				clone.HookY = original.HookY;
				clone.HookZ = original.HookZ;
				clone.Hooked = original.Hooked;
				clone.selectedmask = original.selectedmask;
				clone.MaskPrice = original.MaskPrice;
				clone.UsingLens = original.UsingLens;
				clone.pageNum = original.pageNum;
				clone.xPlayer = original.xPlayer;
				clone.zPlayer = original.zPlayer;
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
				event.addCapability(ResourceLocation.fromNamespaceAndPath("zelda_craft", "player_variables"), new PlayerVariablesProvider());
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
		public boolean BeenResed = false;
		public double jumpvar = 0;
		public double DungeontoLoad = 0;
		public double HookX = 0;
		public double HookY = 0;
		public double HookZ = 0;
		public boolean Hooked = false;
		public double BombsCrafted = 0;
		public double CreepersDetonated = 0;
		public double ExplosiveKills = 0;
		public double selectedmask = 0;
		public double MaskPrice = 0;
		public double UsingLens = 0;
		public double pageNum = 0;
		public double StepsRun = 0;
		public double TimedJumped = 0;
		public boolean Fell50 = false;
		public double xPlayer = 0;
		public double zPlayer = 0;
		public boolean hasBunny = false;
		public boolean hasBlast = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				ZeldaCraftMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("BeenResed", BeenResed);
			nbt.putDouble("jumpvar", jumpvar);
			nbt.putDouble("DungeontoLoad", DungeontoLoad);
			nbt.putDouble("HookX", HookX);
			nbt.putDouble("HookY", HookY);
			nbt.putDouble("HookZ", HookZ);
			nbt.putBoolean("Hooked", Hooked);
			nbt.putDouble("BombsCrafted", BombsCrafted);
			nbt.putDouble("CreepersDetonated", CreepersDetonated);
			nbt.putDouble("ExplosiveKills", ExplosiveKills);
			nbt.putDouble("selectedmask", selectedmask);
			nbt.putDouble("MaskPrice", MaskPrice);
			nbt.putDouble("UsingLens", UsingLens);
			nbt.putDouble("pageNum", pageNum);
			nbt.putDouble("StepsRun", StepsRun);
			nbt.putDouble("TimedJumped", TimedJumped);
			nbt.putBoolean("Fell50", Fell50);
			nbt.putDouble("xPlayer", xPlayer);
			nbt.putDouble("zPlayer", zPlayer);
			nbt.putBoolean("hasBunny", hasBunny);
			nbt.putBoolean("hasBlast", hasBlast);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			BeenResed = nbt.getBoolean("BeenResed");
			jumpvar = nbt.getDouble("jumpvar");
			DungeontoLoad = nbt.getDouble("DungeontoLoad");
			HookX = nbt.getDouble("HookX");
			HookY = nbt.getDouble("HookY");
			HookZ = nbt.getDouble("HookZ");
			Hooked = nbt.getBoolean("Hooked");
			BombsCrafted = nbt.getDouble("BombsCrafted");
			CreepersDetonated = nbt.getDouble("CreepersDetonated");
			ExplosiveKills = nbt.getDouble("ExplosiveKills");
			selectedmask = nbt.getDouble("selectedmask");
			MaskPrice = nbt.getDouble("MaskPrice");
			UsingLens = nbt.getDouble("UsingLens");
			pageNum = nbt.getDouble("pageNum");
			StepsRun = nbt.getDouble("StepsRun");
			TimedJumped = nbt.getDouble("TimedJumped");
			Fell50 = nbt.getBoolean("Fell50");
			xPlayer = nbt.getDouble("xPlayer");
			zPlayer = nbt.getDouble("zPlayer");
			hasBunny = nbt.getBoolean("hasBunny");
			hasBlast = nbt.getBoolean("hasBlast");
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
					variables.BeenResed = message.data.BeenResed;
					variables.jumpvar = message.data.jumpvar;
					variables.DungeontoLoad = message.data.DungeontoLoad;
					variables.HookX = message.data.HookX;
					variables.HookY = message.data.HookY;
					variables.HookZ = message.data.HookZ;
					variables.Hooked = message.data.Hooked;
					variables.BombsCrafted = message.data.BombsCrafted;
					variables.CreepersDetonated = message.data.CreepersDetonated;
					variables.ExplosiveKills = message.data.ExplosiveKills;
					variables.selectedmask = message.data.selectedmask;
					variables.MaskPrice = message.data.MaskPrice;
					variables.UsingLens = message.data.UsingLens;
					variables.pageNum = message.data.pageNum;
					variables.StepsRun = message.data.StepsRun;
					variables.TimedJumped = message.data.TimedJumped;
					variables.Fell50 = message.data.Fell50;
					variables.xPlayer = message.data.xPlayer;
					variables.zPlayer = message.data.zPlayer;
					variables.hasBunny = message.data.hasBunny;
					variables.hasBlast = message.data.hasBlast;
				}
			});
			context.setPacketHandled(true);
		}
	}
}