package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.screens.Screen;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayList;

public class Warp1ClearProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ArrayList<Object> statueList = new ArrayList<>();
		if (Screen.hasShiftDown()) {
			{
				statueList.addAll((new Object() {
					public ArrayList<Object> convert(String text, String separator) {
						return new ArrayList<>(Arrays.asList(text.split(separator)));
					}
				}.convert(((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).owlStatue), ",")));
			}
			if (!(statueList.size() < 0 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).pageNum)) {
				for (int index0 = 0; index0 < 5; index0++) {
					{
						statueList.remove((int) (int) (0 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).pageNum));
					}
				}
				{
					String _setval = statueList.stream().map(String::valueOf).collect(Collectors.joining(","));
					entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.owlStatue = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (statueList.size() < 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).pageNum) {
				{
					double _setval = (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElseGet(ZeldaCraftModVariables.PlayerVariables::new)).pageNum - 1;
					entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pageNum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}