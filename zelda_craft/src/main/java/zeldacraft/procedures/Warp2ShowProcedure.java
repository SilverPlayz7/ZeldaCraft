package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class Warp2ShowProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		File file = new File("");
		com.google.gson.JsonArray statueArray = new com.google.gson.JsonArray();
		boolean hasWarp = false;
		com.google.gson.JsonObject mainObj = new com.google.gson.JsonObject();
		file = new File(
				(FMLPaths.GAMEDIR.get().toString() + ""
						+ ("/saves/" + ((world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "/data"))),
				File.separator + "owlstatue.json");
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
					if (!(statueArray.size() < 5 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)) {
						if (!(statueArray.get((int) ((int) (4 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))).getAsString()).isEmpty()) {
							hasWarp = true;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return hasWarp;
		}
		return false;
	}
}