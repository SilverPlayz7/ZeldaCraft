package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import zeldacraft.init.ZeldaCraftModBlocks;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.storage.LevelResource;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class Warp3TeleportProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject mainObj = new com.google.gson.JsonObject();
		com.google.gson.JsonArray statueArray = new com.google.gson.JsonArray();
		String worldName = "";
		MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
		worldName = server.getWorldPath(LevelResource.ROOT).getParent().getFileName().toString();
		file = new File((FMLPaths.GAMEDIR.get().toString() + "" + ("/saves/" + (worldName + "/data"))), File.separator + "owlstatue.json");
		if (file.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					mainObj = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					statueArray = mainObj.get("statues").getAsJsonArray();
					if ((world.getBlockState(
							BlockPos.containing(statueArray.get((int) (9 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(),
									statueArray.get((int) (10 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(),
									statueArray.get((int) (11 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble())))
							.getBlock() == ZeldaCraftModBlocks.OWL_STATUE.get()) {
						if ((new Object() {
							public Direction getDirection(BlockPos pos) {
								BlockState _bs = world.getBlockState(pos);
								Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (property != null && _bs.getValue(property) instanceof Direction _dir)
									return _dir;
								else if (_bs.hasProperty(BlockStateProperties.AXIS))
									return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
								else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
									return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
								return Direction.NORTH;
							}
						}.getDirection(BlockPos.containing(
								(int) statueArray.get((int) (9 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(),
								(int) statueArray.get((int) (10 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(), (int) statueArray
										.get((int) (11 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble()))) == Direction.NORTH) {
							{
								Entity _ent = entity;
								_ent.teleportTo((statueArray.get((int) (9 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble() + 0.5),
										statueArray.get((int) (10 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(),
										((int) statueArray.get((int) (11 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble() - 0.5));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(
											(statueArray.get((int) (9 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble() + 0.5),
											statueArray.get((int) (10 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(),
											((int) statueArray.get((int) (11 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble() - 0.5),
											_ent.getYRot(), _ent.getXRot());
							}
						}
						if ((new Object() {
							public Direction getDirection(BlockPos pos) {
								BlockState _bs = world.getBlockState(pos);
								Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (property != null && _bs.getValue(property) instanceof Direction _dir)
									return _dir;
								else if (_bs.hasProperty(BlockStateProperties.AXIS))
									return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
								else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
									return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
								return Direction.NORTH;
							}
						}.getDirection(BlockPos.containing(
								(int) statueArray.get((int) (9 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(),
								(int) statueArray.get((int) (10 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(), (int) statueArray
										.get((int) (11 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble()))) == Direction.SOUTH) {
							{
								Entity _ent = entity;
								_ent.teleportTo((statueArray.get((int) (9 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble() + 0.5),
										statueArray.get((int) (10 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(),
										((int) statueArray.get((int) (11 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble() + 1.5));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(
											(statueArray.get((int) (9 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble() + 0.5),
											statueArray.get((int) (10 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(),
											((int) statueArray.get((int) (11 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble() + 1.5),
											_ent.getYRot(), _ent.getXRot());
							}
						}
						if ((new Object() {
							public Direction getDirection(BlockPos pos) {
								BlockState _bs = world.getBlockState(pos);
								Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (property != null && _bs.getValue(property) instanceof Direction _dir)
									return _dir;
								else if (_bs.hasProperty(BlockStateProperties.AXIS))
									return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
								else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
									return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
								return Direction.NORTH;
							}
						}.getDirection(BlockPos.containing(
								(int) statueArray.get((int) (9 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(),
								(int) statueArray.get((int) (10 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(), (int) statueArray
										.get((int) (11 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble()))) == Direction.WEST) {
							{
								Entity _ent = entity;
								_ent.teleportTo((statueArray.get((int) (9 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble() - 0.5),
										statueArray.get((int) (10 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(),
										((int) statueArray.get((int) (11 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble() + 0.5));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(
											(statueArray.get((int) (9 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble() - 0.5),
											statueArray.get((int) (10 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(),
											((int) statueArray.get((int) (11 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble() + 0.5),
											_ent.getYRot(), _ent.getXRot());
							}
						}
						if ((new Object() {
							public Direction getDirection(BlockPos pos) {
								BlockState _bs = world.getBlockState(pos);
								Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (property != null && _bs.getValue(property) instanceof Direction _dir)
									return _dir;
								else if (_bs.hasProperty(BlockStateProperties.AXIS))
									return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
								else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
									return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
								return Direction.NORTH;
							}
						}.getDirection(BlockPos.containing(
								(int) statueArray.get((int) (9 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(),
								(int) statueArray.get((int) (10 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(), (int) statueArray
										.get((int) (11 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble()))) == Direction.EAST) {
							{
								Entity _ent = entity;
								_ent.teleportTo((statueArray.get((int) (9 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble() + 1.5),
										statueArray.get((int) (10 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(),
										((int) statueArray.get((int) (11 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble() + 0.5));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(
											(statueArray.get((int) (9 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble() + 1.5),
											statueArray.get((int) (10 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(),
											((int) statueArray.get((int) (11 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble() + 0.5),
											_ent.getYRot(), _ent.getXRot());
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}