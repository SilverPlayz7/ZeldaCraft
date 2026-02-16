package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModBlocks;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.storage.LevelResource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

@Mod.EventBusSubscriber
public class OwlStatueBreakClearProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		execute(null, world, x, y, z, blockstate);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		File file = new File("");
		com.google.gson.JsonArray statueArray = new com.google.gson.JsonArray();
		com.google.gson.JsonObject mainObj = new com.google.gson.JsonObject();
		double removeIndex = 0;
		double checkIndex = 0;
		String worldName = "";
		if (blockstate.getBlock() == ZeldaCraftModBlocks.OWL_STATUE.get()) {
			checkIndex = 0;
			removeIndex = 0;
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
						if (mainObj.toString().contains(new Object() {
							public String getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getString(tag);
								return "";
							}
						}.getValue(world, BlockPos.containing(x, y, z), "statueName")) && mainObj.toString().contains(new java.text.DecimalFormat("##.##").format(x)) && mainObj.toString().contains(new java.text.DecimalFormat("##.##").format(y))
								&& mainObj.toString().contains(new java.text.DecimalFormat("##.##").format(z))) {
							for (int index0 = 0; index0 < (int) statueArray.size(); index0++) {
								if (statueArray.get((int) checkIndex).getAsString().contains(new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "statueName"))) {
									if (statueArray.get((int) (checkIndex + 1)).getAsDouble() == x && statueArray.get((int) (checkIndex + 2)).getAsDouble() == y && statueArray.get((int) (checkIndex + 3)).getAsDouble() == z) {
										removeIndex = checkIndex;
										for (int index1 = 0; index1 < 4; index1++) {
											statueArray.remove(((int) removeIndex));
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
										break;
									} else {
										checkIndex = checkIndex + 4;
									}
								} else {
									checkIndex = checkIndex + 4;
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
}