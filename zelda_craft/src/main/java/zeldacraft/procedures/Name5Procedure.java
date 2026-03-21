package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import java.util.Arrays;
import java.util.ArrayList;

public class Name5Procedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		ArrayList<Object> statueList = new ArrayList<>();
		String name = "";
		{
			statueList.addAll((new Object() {
				public ArrayList<Object> convert(String text, String separator) {
					return new ArrayList<>(Arrays.asList(text.split(separator)));
				}
			}.convert(((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).owlStatue), ",")));
		}
		if (!(statueList.size() < 24 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)) {
			name = new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing((int) new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(new Object() {
				public String get(ArrayList<?> list, int index) {
					if (list.get(index) instanceof String text) {
						return text;
					}
					return "";
				}
			}.get(statueList, (int) (22 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))), (int) new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(new Object() {
				public String get(ArrayList<?> list, int index) {
					if (list.get(index) instanceof String text) {
						return text;
					}
					return "";
				}
			}.get(statueList, (int) (23 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))), (int) new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(new Object() {
				public String get(ArrayList<?> list, int index) {
					if (list.get(index) instanceof String text) {
						return text;
					}
					return "";
				}
			}.get(statueList, (int) (24 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)))), "statueName");
		}
		return name;
	}
}