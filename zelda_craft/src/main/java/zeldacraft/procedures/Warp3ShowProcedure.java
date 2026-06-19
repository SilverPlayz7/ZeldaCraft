package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import net.minecraft.world.entity.Entity;

import java.util.Arrays;
import java.util.ArrayList;

import java.io.File;

public class Warp3ShowProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		File file = new File("");
		com.google.gson.JsonArray statueArray = new com.google.gson.JsonArray();
		com.google.gson.JsonObject mainObj = new com.google.gson.JsonObject();
		boolean hasWarp = false;
		String worldName = "";
		ArrayList<Object> statueList = new ArrayList<>();
		{
			statueList.addAll((new Object() {
				public ArrayList<Object> convert(String text, String separator) {
					return new ArrayList<>(Arrays.asList(text.split(separator)));
				}
			}.convert(((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).owlStatue), ",")));
		}
		if (!(statueList.size() < 11 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).pageNum)) {
			if (!(new Object() {
				public String get(ArrayList<?> list, int index) {
					if (list.get(index) instanceof String text) {
						return text;
					}
					return "";
				}
			}.get(statueList, (int) (int) (10 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).pageNum))).isEmpty()) {
				hasWarp = true;
			}
		}
		return hasWarp;
	}
}