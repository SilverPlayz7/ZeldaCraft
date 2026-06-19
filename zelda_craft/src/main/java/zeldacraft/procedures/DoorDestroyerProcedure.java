package zeldacraft.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DoorDestroyerProcedure {
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
		boolean foundBlock = false;
		double posX = 0;
		double posX2 = 0;
		double posY = 0;
		double posZ = 0;
		double posZ2 = 0;
		double posY2 = 0;
		double width = 0;
		double height = 0;
		double openValue = 0;
		if (blockstate.is(BlockTags.create(ResourceLocation.parse("zelda_craft:doors")))) {
			width = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(DoorSizeRegistrationProcedure.execute(blockstate).substring((int) DoorSizeRegistrationProcedure.execute(blockstate).indexOf("[") + "[".length(), (int) DoorSizeRegistrationProcedure.execute(blockstate).indexOf(",")));
			height = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(DoorSizeRegistrationProcedure.execute(blockstate).substring((int) DoorSizeRegistrationProcedure.execute(blockstate).indexOf(",") + ",".length(), (int) DoorSizeRegistrationProcedure.execute(blockstate).indexOf("]")));
			openValue = width * height;
			if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.NORTH) {
				posX = x;
				posY = y;
				posZ = z;
				if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp10
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp10)
						&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep12
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep12).toString()
								: "").equals("right")) {
					for (int index0 = 0; index0 < (int) width; index0++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip14
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip14)
								: -1) >= height + 3 * openValue) {
							posX = posX + 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip16
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip16)
									: -1) - 3 * openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip21
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip21)
										: -1) == 3 * openValue) {
							foundBlock = true;
							break;
						}
					}
				} else if (!((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp23
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp23))
						&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep25
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep25).toString()
								: "").equals("right")) {
					for (int index1 = 0; index1 < (int) width; index1++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip27
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip27)
								: -1) >= height + 2 * openValue) {
							posX = posX + 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip29
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip29)
									: -1) - 2 * openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip34
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip34)
										: -1) == 2 * openValue) {
							foundBlock = true;
							break;
						}
					}
				} else if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp36
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp36)) {
					for (int index2 = 0; index2 < (int) width; index2++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip38
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip38)
								: -1) >= height + openValue) {
							posX = posX + 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip40
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip40)
									: -1) - openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip45
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip45)
										: -1) == openValue) {
							foundBlock = true;
							break;
						}
					}
				} else {
					for (int index3 = 0; index3 < (int) width; index3++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip47
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip47)
								: -1) >= height) {
							posX = posX + 1;
						} else {
							posY = posY - Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip49
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip49)
									: -1);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip54
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip54)
										: -1) == 0) {
							foundBlock = true;
							break;
						}
					}
				}
				if (foundBlock) {
					posX2 = posX;
					posY2 = posY;
					posZ2 = posZ;
					for (int index4 = 0; index4 < (int) height; index4++) {
						for (int index5 = 0; index5 < (int) width; index5++) {
							if ((world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock() == blockstate.getBlock()) {
								world.setBlock(BlockPos.containing(posX2, posY2, posZ2), Blocks.AIR.defaultBlockState(), 3);
							}
							posX2 = posX2 - 1;
						}
						posX2 = posX;
						posY2 = posY2 + 1;
					}
				}
			}
			if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.SOUTH) {
				posX = x;
				posY = y;
				posZ = z;
				if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp63
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp63)
						&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep65
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep65).toString()
								: "").equals("right")) {
					for (int index6 = 0; index6 < (int) width; index6++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip67
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip67)
								: -1) >= height + 3 * openValue) {
							posX = posX - 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip69
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip69)
									: -1) - 3 * openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip74
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip74)
										: -1) == 3 * openValue) {
							foundBlock = true;
							break;
						}
					}
				} else if (!((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp76
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp76))
						&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep78
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep78).toString()
								: "").equals("right")) {
					for (int index7 = 0; index7 < (int) width; index7++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip80
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip80)
								: -1) >= height + 2 * openValue) {
							posX = posX - 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip82
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip82)
									: -1) - 2 * openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip87
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip87)
										: -1) == 2 * openValue) {
							foundBlock = true;
							break;
						}
					}
				} else if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp89
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp89)) {
					for (int index8 = 0; index8 < (int) width; index8++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip91
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip91)
								: -1) >= height + openValue) {
							posX = posX - 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip93
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip93)
									: -1) - openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip98
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip98)
										: -1) == openValue) {
							foundBlock = true;
							break;
						}
					}
				} else {
					for (int index9 = 0; index9 < (int) width; index9++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip100
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip100)
								: -1) >= height) {
							posX = posX - 1;
						} else {
							posY = posY - Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip102
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip102)
									: -1);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip107
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip107)
										: -1) == 0) {
							foundBlock = true;
							break;
						}
					}
				}
				if (foundBlock) {
					posX2 = posX;
					posY2 = posY;
					posZ2 = posZ;
					for (int index10 = 0; index10 < (int) height; index10++) {
						for (int index11 = 0; index11 < (int) width; index11++) {
							if ((world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock() == blockstate.getBlock()) {
								world.setBlock(BlockPos.containing(posX2, posY2, posZ2), Blocks.AIR.defaultBlockState(), 3);
							}
							posX2 = posX2 + 1;
						}
						posX2 = posX;
						posY2 = posY2 + 1;
					}
				}
			}
			if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.EAST) {
				posX = x;
				posY = y;
				posZ = z;
				if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp116
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp116)
						&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep118
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep118).toString()
								: "").equals("right")) {
					for (int index12 = 0; index12 < (int) width; index12++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip120
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip120)
								: -1) >= height + 3 * openValue) {
							posZ = posZ + 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip122
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip122)
									: -1) - 3 * openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip127
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip127)
										: -1) == 3 * openValue) {
							foundBlock = true;
							break;
						}
					}
				} else if (!((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp129
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp129))
						&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep131
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep131).toString()
								: "").equals("right")) {
					for (int index13 = 0; index13 < (int) width; index13++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip133
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip133)
								: -1) >= height + 2 * openValue) {
							posZ = posZ + 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip135
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip135)
									: -1) - 2 * openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip140
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip140)
										: -1) == 2 * openValue) {
							foundBlock = true;
							break;
						}
					}
				} else if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp142
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp142)) {
					for (int index14 = 0; index14 < (int) width; index14++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip144
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip144)
								: -1) >= height + openValue) {
							posZ = posZ + 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip146
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip146)
									: -1) - openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip151
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip151)
										: -1) == openValue) {
							foundBlock = true;
							break;
						}
					}
				} else {
					for (int index15 = 0; index15 < (int) width; index15++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip153
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip153)
								: -1) >= height) {
							posZ = posZ + 1;
						} else {
							posY = posY - Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip155
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip155)
									: -1);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip160
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip160)
										: -1) == 0) {
							foundBlock = true;
							break;
						}
					}
				}
				if (foundBlock) {
					posX2 = posX;
					posY2 = posY;
					posZ2 = posZ;
					for (int index16 = 0; index16 < (int) height; index16++) {
						for (int index17 = 0; index17 < (int) width; index17++) {
							if ((world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock() == blockstate.getBlock()) {
								world.setBlock(BlockPos.containing(posX2, posY2, posZ2), Blocks.AIR.defaultBlockState(), 3);
							}
							posZ2 = posZ2 - 1;
						}
						posZ2 = posZ;
						posY2 = posY2 + 1;
					}
				}
			}
			if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.WEST) {
				posX = x;
				posY = y;
				posZ = z;
				if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp169
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp169)
						&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep171
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep171).toString()
								: "").equals("right")) {
					for (int index18 = 0; index18 < (int) width; index18++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip173
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip173)
								: -1) >= height + 3 * openValue) {
							posZ = posZ - 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip175
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip175)
									: -1) - 3 * openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip180
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip180)
										: -1) == 3 * openValue) {
							foundBlock = true;
							break;
						}
					}
				} else if (!((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp182
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp182))
						&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep184
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep184).toString()
								: "").equals("right")) {
					for (int index19 = 0; index19 < (int) width; index19++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip186
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip186)
								: -1) >= height + 2 * openValue) {
							posZ = posZ - 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip188
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip188)
									: -1) - 2 * openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip193
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip193)
										: -1) == 2 * openValue) {
							foundBlock = true;
							break;
						}
					}
				} else if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp195
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp195)) {
					for (int index20 = 0; index20 < (int) width; index20++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip197
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip197)
								: -1) >= height + openValue) {
							posZ = posZ - 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip199
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip199)
									: -1) - openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip204
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip204)
										: -1) == openValue) {
							foundBlock = true;
							break;
						}
					}
				} else {
					for (int index21 = 0; index21 < (int) width; index21++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip206
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip206)
								: -1) >= height) {
							posZ = posZ - 1;
						} else {
							posY = posY - Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip208
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip208)
									: -1);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip213
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip213)
										: -1) == 0) {
							foundBlock = true;
							break;
						}
					}
				}
				if (foundBlock) {
					posX2 = posX;
					posY2 = posY;
					posZ2 = posZ;
					for (int index22 = 0; index22 < (int) height; index22++) {
						for (int index23 = 0; index23 < (int) width; index23++) {
							if ((world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock() == blockstate.getBlock()) {
								world.setBlock(BlockPos.containing(posX2, posY2, posZ2), Blocks.AIR.defaultBlockState(), 3);
							}
							posZ2 = posZ2 + 1;
						}
						posZ2 = posZ;
						posY2 = posY2 + 1;
					}
				}
			}
			if (foundBlock) {
				if (!(getEntityGameType(entity) == GameType.CREATIVE)) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (posX + 0.5), (posY + 0.5), (posZ + 0.5), (new ItemStack(blockstate.getBlock())));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (prop instanceof DirectionProperty dp)
			return blockState.getValue(dp);
		prop = blockState.getBlock().getStateDefinition().getProperty("axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}