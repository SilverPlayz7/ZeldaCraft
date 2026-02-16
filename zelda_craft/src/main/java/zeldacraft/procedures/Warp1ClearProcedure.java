package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.storage.LevelResource;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.client.gui.screens.Screen;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class Warp1ClearProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonArray statueArray = new com.google.gson.JsonArray();
		com.google.gson.JsonObject mainObj = new com.google.gson.JsonObject();
		String worldName = "";
		if (Screen.hasShiftDown()) {
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
						if (!(statueArray.size() < 0 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)) {
							for (int index0 = 0; index0 < 4; index0++) {
								statueArray.remove(((int) (0 + 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)));
							}
							mainObj.add("statues", statueArray);
							{
								com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
								try {
									FileWriter fileWriter = new FileWriter(file);
									fileWriter.write(mainGSONBuilderVariable.toJson(mainObj));
									fileWriter.close();
								} catch (IOException exception) {
									exception.printStackTrace();
								}
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (statueArray.size() < 20 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum) {
					{
						double _setval = (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum - 1;
						entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.pageNum = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}