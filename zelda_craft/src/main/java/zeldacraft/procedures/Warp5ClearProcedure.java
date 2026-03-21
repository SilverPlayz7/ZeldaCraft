package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.screens.Screen;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayList;

public class Warp5ClearProcedure {
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
				}.convert(((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).owlStatue), ",")));
			}
			if (!(statueList.size() < 20 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)) {
				for (int index0 = 0; index0 < 5; index0++) {
					{
						statueList.remove((int) (int) (20 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum));
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
			if (statueList.size() < 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum) {
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