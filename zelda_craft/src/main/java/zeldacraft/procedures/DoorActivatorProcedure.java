package zeldacraft.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class DoorActivatorProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
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
		if (!world.isClientSide()) {
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
					if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp11
							&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp11)
							&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep13
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep13).toString()
									: "").equals("right")) {
						for (int index0 = 0; index0 < (int) width; index0++) {
							if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip15
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip15)
									: -1) >= height + 3 * openValue) {
								posX = posX + 1;
							} else {
								posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip17
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip17)
										: -1) - 3 * openValue);
							}
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
									&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip22
											? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip22)
											: -1) == 3 * openValue) {
								foundBlock = true;
								break;
							}
						}
					} else if (!((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp24
							&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp24))
							&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep26
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep26).toString()
									: "").equals("right")) {
						for (int index1 = 0; index1 < (int) width; index1++) {
							if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip28
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip28)
									: -1) >= height + 2 * openValue) {
								posX = posX + 1;
							} else {
								posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip30
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip30)
										: -1) - 2 * openValue);
							}
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
									&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip35
											? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip35)
											: -1) == 2 * openValue) {
								foundBlock = true;
								break;
							}
						}
					} else if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp37
							&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp37)) {
						for (int index2 = 0; index2 < (int) width; index2++) {
							if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip39
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip39)
									: -1) >= height + openValue) {
								posX = posX + 1;
							} else {
								posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip41
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip41)
										: -1) - openValue);
							}
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
									&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip46
											? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip46)
											: -1) == openValue) {
								foundBlock = true;
								break;
							}
						}
					} else {
						for (int index3 = 0; index3 < (int) width; index3++) {
							if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip48
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip48)
									: -1) >= height) {
								posX = posX + 1;
							} else {
								posY = posY - Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip50
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip50)
										: -1);
							}
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
									&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip55
											? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip55)
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
								if (((world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp57
										&& (world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getValue(_getbp57)) == false) {
									{
										int _value = (int) (((world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip59
												? (world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getValue(_getip59)
												: -1) + openValue);
										BlockPos _pos = BlockPos.containing(posX2, posY2, posZ2);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									{
										BlockPos _pos = BlockPos.containing(posX2, posY2, posZ2);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
											world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
									}
								} else {
									{
										int _value = (int) (((world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip63
												? (world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getValue(_getip63)
												: -1) - openValue);
										BlockPos _pos = BlockPos.containing(posX2, posY2, posZ2);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									{
										BlockPos _pos = BlockPos.containing(posX2, posY2, posZ2);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
											world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
									}
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
					if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp70
							&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp70)
							&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep72
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep72).toString()
									: "").equals("right")) {
						for (int index6 = 0; index6 < (int) width; index6++) {
							if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip74
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip74)
									: -1) >= height + 3 * openValue) {
								posX = posX - 1;
							} else {
								posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip76
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip76)
										: -1) - 3 * openValue);
							}
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
									&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip81
											? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip81)
											: -1) == 3 * openValue) {
								foundBlock = true;
								break;
							}
						}
					} else if (!((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp83
							&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp83))
							&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep85
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep85).toString()
									: "").equals("right")) {
						for (int index7 = 0; index7 < (int) width; index7++) {
							if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip87
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip87)
									: -1) >= height + 2 * openValue) {
								posX = posX - 1;
							} else {
								posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip89
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip89)
										: -1) - 2 * openValue);
							}
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
									&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip94
											? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip94)
											: -1) == 2 * openValue) {
								foundBlock = true;
								break;
							}
						}
					} else if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp96
							&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp96)) {
						for (int index8 = 0; index8 < (int) width; index8++) {
							if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip98
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip98)
									: -1) >= height + openValue) {
								posX = posX - 1;
							} else {
								posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip100
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip100)
										: -1) - openValue);
							}
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
									&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip105
											? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip105)
											: -1) == openValue) {
								foundBlock = true;
								break;
							}
						}
					} else {
						for (int index9 = 0; index9 < (int) width; index9++) {
							if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip107
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip107)
									: -1) >= height) {
								posX = posX - 1;
							} else {
								posY = posY - Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip109
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip109)
										: -1);
							}
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
									&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip114
											? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip114)
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
								if (((world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp116
										&& (world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getValue(_getbp116)) == false) {
									{
										int _value = (int) (((world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip118
												? (world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getValue(_getip118)
												: -1) + openValue);
										BlockPos _pos = BlockPos.containing(posX2, posY2, posZ2);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									{
										BlockPos _pos = BlockPos.containing(posX2, posY2, posZ2);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
											world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
									}
								} else {
									{
										int _value = (int) (((world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip122
												? (world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getValue(_getip122)
												: -1) - openValue);
										BlockPos _pos = BlockPos.containing(posX2, posY2, posZ2);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									{
										BlockPos _pos = BlockPos.containing(posX2, posY2, posZ2);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
											world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
									}
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
					if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp129
							&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp129)
							&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep131
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep131).toString()
									: "").equals("right")) {
						for (int index12 = 0; index12 < (int) width; index12++) {
							if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip133
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip133)
									: -1) >= height + 3 * openValue) {
								posZ = posZ + 1;
							} else {
								posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip135
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip135)
										: -1) - 3 * openValue);
							}
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
									&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip140
											? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip140)
											: -1) == 3 * openValue) {
								foundBlock = true;
								break;
							}
						}
					} else if (!((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp142
							&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp142))
							&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep144
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep144).toString()
									: "").equals("right")) {
						for (int index13 = 0; index13 < (int) width; index13++) {
							if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip146
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip146)
									: -1) >= height + 2 * openValue) {
								posZ = posZ + 1;
							} else {
								posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip148
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip148)
										: -1) - 2 * openValue);
							}
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
									&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip153
											? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip153)
											: -1) == 2 * openValue) {
								foundBlock = true;
								break;
							}
						}
					} else if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp155
							&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp155)) {
						for (int index14 = 0; index14 < (int) width; index14++) {
							if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip157
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip157)
									: -1) >= height + openValue) {
								posZ = posZ + 1;
							} else {
								posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip159
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip159)
										: -1) - openValue);
							}
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
									&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip164
											? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip164)
											: -1) == openValue) {
								foundBlock = true;
								break;
							}
						}
					} else {
						for (int index15 = 0; index15 < (int) width; index15++) {
							if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip166
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip166)
									: -1) >= height) {
								posZ = posZ + 1;
							} else {
								posY = posY - Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip168
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip168)
										: -1);
							}
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
									&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip173
											? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip173)
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
								if (((world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp175
										&& (world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getValue(_getbp175)) == false) {
									{
										int _value = (int) (((world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip177
												? (world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getValue(_getip177)
												: -1) + openValue);
										BlockPos _pos = BlockPos.containing(posX2, posY2, posZ2);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									{
										BlockPos _pos = BlockPos.containing(posX2, posY2, posZ2);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
											world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
									}
								} else {
									{
										int _value = (int) (((world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip181
												? (world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getValue(_getip181)
												: -1) - openValue);
										BlockPos _pos = BlockPos.containing(posX2, posY2, posZ2);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									{
										BlockPos _pos = BlockPos.containing(posX2, posY2, posZ2);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
											world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
									}
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
					if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp188
							&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp188)
							&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep190
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep190).toString()
									: "").equals("right")) {
						for (int index18 = 0; index18 < (int) width; index18++) {
							if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip192
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip192)
									: -1) >= height + 3 * openValue) {
								posZ = posZ - 1;
							} else {
								posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip194
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip194)
										: -1) - 3 * openValue);
							}
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
									&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip199
											? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip199)
											: -1) == 3 * openValue) {
								foundBlock = true;
								break;
							}
						}
					} else if (!((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp201
							&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp201))
							&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep203
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep203).toString()
									: "").equals("right")) {
						for (int index19 = 0; index19 < (int) width; index19++) {
							if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip205
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip205)
									: -1) >= height + 2 * openValue) {
								posZ = posZ - 1;
							} else {
								posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip207
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip207)
										: -1) - 2 * openValue);
							}
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
									&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip212
											? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip212)
											: -1) == 2 * openValue) {
								foundBlock = true;
								break;
							}
						}
					} else if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp214
							&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp214)) {
						for (int index20 = 0; index20 < (int) width; index20++) {
							if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip216
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip216)
									: -1) >= height + openValue) {
								posZ = posZ - 1;
							} else {
								posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip218
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip218)
										: -1) - openValue);
							}
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
									&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip223
											? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip223)
											: -1) == openValue) {
								foundBlock = true;
								break;
							}
						}
					} else {
						for (int index21 = 0; index21 < (int) width; index21++) {
							if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip225
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip225)
									: -1) >= height) {
								posZ = posZ - 1;
							} else {
								posY = posY - Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip227
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip227)
										: -1);
							}
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
									&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip232
											? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip232)
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
								if (((world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp234
										&& (world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getValue(_getbp234)) == false) {
									{
										int _value = (int) (((world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip236
												? (world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getValue(_getip236)
												: -1) + openValue);
										BlockPos _pos = BlockPos.containing(posX2, posY2, posZ2);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									{
										BlockPos _pos = BlockPos.containing(posX2, posY2, posZ2);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
											world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
									}
								} else {
									{
										int _value = (int) (((world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip240
												? (world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getValue(_getip240)
												: -1) - openValue);
										BlockPos _pos = BlockPos.containing(posX2, posY2, posZ2);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
									{
										BlockPos _pos = BlockPos.containing(posX2, posY2, posZ2);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
											world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
									}
								}
								posZ2 = posZ2 + 1;
							}
							posZ2 = posZ;
							posY2 = posY2 + 1;
						}
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
}