package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import net.minecraft.world.entity.Entity;

import java.util.Arrays;
import java.util.ArrayList;

public class NextPageShowProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		ArrayList<Object> statueList = new ArrayList<>();
		boolean hasPage = false;
		{
			statueList.addAll((new Object() {
				public ArrayList<Object> convert(String text, String separator) {
					return new ArrayList<>(Arrays.asList(text.split(separator)));
				}
			}.convert(((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).owlStatue), ",")));
		}
		if (statueList.size() > 25 * ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).pageNum + 1)) {
			if (!(new Object() {
				public String get(ArrayList<?> list, int index) {
					if (list.get(index) instanceof String text) {
						return text;
					}
					return "";
				}
			}.get(statueList, (int) (int) (25 * ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).pageNum + 1)))).isEmpty()) {
				hasPage = true;
			}
		}
		return hasPage;
	}
}