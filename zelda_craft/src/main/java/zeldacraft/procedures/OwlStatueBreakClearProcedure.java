package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import zeldacraft.init.ZeldaCraftModBlocks;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class OwlStatueBreakClearProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double removeIndex = 0;
		double checkIndex = 0;
		ArrayList<Object> statueList = new ArrayList<>();
		if (blockstate.getBlock() == ZeldaCraftModBlocks.OWL_STATUE.get()) {
			{
				statueList.addAll((new Object() {
					public ArrayList<Object> convert(String text, String separator) {
						return new ArrayList<>(Arrays.asList(text.split(separator)));
					}
				}.convert(((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).owlStatue), ",")));
			}
			checkIndex = 0;
			removeIndex = 0;
			if (((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).owlStatue).contains(new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "statueName"))
					&& ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).owlStatue).contains(new java.text.DecimalFormat("##.##").format(x))
					&& ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).owlStatue).contains(new java.text.DecimalFormat("##.##").format(y))
					&& ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).owlStatue).contains(new java.text.DecimalFormat("##.##").format(z))) {
				for (int index0 = 0; index0 < (int) statueList.size(); index0++) {
					if ((new Object() {
						public String get(ArrayList<?> list, int index) {
							if (list.get(index) instanceof String text) {
								return text;
							}
							return "";
						}
					}.get(statueList, (int) checkIndex)).contains(new Object() {
						public String getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getString(tag);
							return "";
						}
					}.getValue(world, BlockPos.containing(x, y, z), "statueName"))) {
						if (new Object() {
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
						}.get(statueList, (int) (checkIndex + 2))) == x && new Object() {
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
						}.get(statueList, (int) (checkIndex + 3))) == y && new Object() {
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
						}.get(statueList, (int) (checkIndex + 4))) == z) {
							removeIndex = checkIndex;
							for (int index1 = 0; index1 < 5; index1++) {
								{
									statueList.remove((int) (int) removeIndex);
								}
							}
							{
								String _setval = statueList.stream().map(String::valueOf).collect(Collectors.joining(","));
								entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.owlStatue = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							break;
						} else {
							checkIndex = checkIndex + 5;
						}
					} else {
						checkIndex = checkIndex + 5;
					}
				}
			}
		}
	}
}