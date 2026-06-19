package zeldacraft.procedures;

import zeldacraft.world.inventory.StatueNameSetMenu;

import zeldacraft.network.ZeldaCraftModVariables;

import zeldacraft.init.ZeldaCraftModBlocks;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayList;

import java.io.File;

import io.netty.buffer.Unpooled;

public class OwlStatueOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonArray statueArray = new com.google.gson.JsonArray();
		com.google.gson.JsonObject mainObj = new com.google.gson.JsonObject();
		boolean success = false;
		double xRadius = 0;
		double loop = 0;
		double zRadius = 0;
		double particleAmount = 0;
		String worldName = "";
		ArrayList<Object> statueList = new ArrayList<>();
		{
			statueList.addAll((new Object() {
				public ArrayList<Object> convert(String text, String separator) {
					return new ArrayList<>(Arrays.asList(text.split(separator)));
				}
			}.convert(((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).owlStatue), ",")));
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "hasName") == true) {
			if (((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).owlStatue).contains(getBlockNBTString(world, BlockPos.containing(x, y, z), "statueName"))
					&& ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).owlStatue).contains(new java.text.DecimalFormat("##.##").format(x))
					&& ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).owlStatue).contains(new java.text.DecimalFormat("##.##").format(y))
					&& ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).owlStatue).contains(new java.text.DecimalFormat("##.##").format(z))) {
				if (world instanceof Level _level) {
					if (_level.isClientSide()) {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS, (float) 0.1, 1, false);
					}
				}
			} else {
				{
					statueList.add((getBlockNBTString(world, BlockPos.containing(x, y, z), "statueName")));
				}
				{
					statueList.add(entity.level().dimension().location().toString());
				}
				{
					statueList.add(x);
				}
				{
					statueList.add(y);
				}
				{
					statueList.add(z);
				}
				if ((new Object() {
					public String get(ArrayList<?> list, int index) {
						if (list.get(index) instanceof String text) {
							return text;
						}
						return "";
					}
				}.get(statueList, 0)).isEmpty()) {
					{
						statueList.remove(0);
					}
				}
				{
					String _setval = statueList.stream().map(String::valueOf).collect(Collectors.joining(","));
					entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.owlStatue = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (blockstate.getBlock() == ZeldaCraftModBlocks.OWL_STATUE.get()) {
					if (world.isClientSide()) {
						if (world instanceof Level)
							((Level) world).playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.BLOCKS, (float) 0.5, 1, false);
						loop = 0;
						particleAmount = 16;
						xRadius = 1;
						zRadius = 1;
						while (loop < particleAmount) {
							world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, (x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), y, (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius),
									((Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius) / 10), 0.75, ((Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius) / 10));
							loop = loop + 1;
						}
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Statue activated"), true);
			}
		} else {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("StatueNameSet");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new StatueNameSetMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}
}