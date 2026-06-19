package zeldacraft.procedures;

import net.minecraft.world.entity.Entity;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayList;

public class OwlStatueClearProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ArrayList<Object> statueList = new ArrayList<>();
		{
			statueList.addAll((new Object() {
				public ArrayList<Object> convert(String text, String separator) {
					return new ArrayList<>(Arrays.asList(text.split(separator)));
				}
			}.convert((entity.getPersistentData().getString("owlStatue")), ",")));
		}
		{
			statueList.clear();
		}
		entity.getPersistentData().putString("owlStatue", (statueList.stream().map(String::valueOf).collect(Collectors.joining(","))));
	}
}