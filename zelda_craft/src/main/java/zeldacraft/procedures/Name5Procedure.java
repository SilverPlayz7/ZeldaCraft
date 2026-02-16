package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.storage.LevelResource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.core.BlockPos;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class Name5Procedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		File file = new File("");
		com.google.gson.JsonArray statueArray = new com.google.gson.JsonArray();
		com.google.gson.JsonObject mainObj = new com.google.gson.JsonObject();
		String name = "";
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
					if (!(statueArray.size() < 19 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)) {
						name = new Object() {
							public String getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getString(tag);
								return "";
							}
						}.getValue(world,
								BlockPos.containing((int) statueArray.get((int) (17 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(),
										(int) statueArray.get((int) (18 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble(),
										(int) statueArray.get((int) (19 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)).getAsDouble()),
								"statueName");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return name;
		}
		return "";
	}
}