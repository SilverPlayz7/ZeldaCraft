package zeldacraft.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
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

import java.util.Map;

public class DoorUnlockerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
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
		ItemStack key = ItemStack.EMPTY;
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
								{
									BlockPos _bp = BlockPos.containing(posX2, posY2, posZ2);
									BlockState _bs = (new Object() {
										public BlockState with(BlockState _bs, String _property, int _newValue) {
											Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
											return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
										}
									}.with(ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse((((ForgeRegistries.BLOCKS.getKey(blockstate.getBlock()).toString()).replace(":locked_", ":"))).toLowerCase(java.util.Locale.ENGLISH)))
											.defaultBlockState(), "blockstate",
											(world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip62
													? (world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getValue(_getip62)
													: -1));
									BlockState _bso = world.getBlockState(_bp);
									for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
										Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
										if (_property != null && _bs.getValue(_property) != null)
											try {
												_bs = _bs.setValue(_property, (Comparable) entry.getValue());
											} catch (Exception e) {
											}
									}
									world.setBlock(_bp, _bs, 3);
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
				if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp69
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp69)
						&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep71
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep71).toString()
								: "").equals("right")) {
					for (int index6 = 0; index6 < (int) width; index6++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip73
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip73)
								: -1) >= height + 3 * openValue) {
							posX = posX - 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip75
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip75)
									: -1) - 3 * openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip80
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip80)
										: -1) == 3 * openValue) {
							foundBlock = true;
							break;
						}
					}
				} else if (!((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp82
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp82))
						&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep84
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep84).toString()
								: "").equals("right")) {
					for (int index7 = 0; index7 < (int) width; index7++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip86
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip86)
								: -1) >= height + 2 * openValue) {
							posX = posX - 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip88
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip88)
									: -1) - 2 * openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip93
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip93)
										: -1) == 2 * openValue) {
							foundBlock = true;
							break;
						}
					}
				} else if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp95
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp95)) {
					for (int index8 = 0; index8 < (int) width; index8++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip97
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip97)
								: -1) >= height + openValue) {
							posX = posX - 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip99
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip99)
									: -1) - openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip104
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip104)
										: -1) == openValue) {
							foundBlock = true;
							break;
						}
					}
				} else {
					for (int index9 = 0; index9 < (int) width; index9++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip106
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip106)
								: -1) >= height) {
							posX = posX - 1;
						} else {
							posY = posY - Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip108
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip108)
									: -1);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip113
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip113)
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
								{
									BlockPos _bp = BlockPos.containing(posX2, posY2, posZ2);
									BlockState _bs = (new Object() {
										public BlockState with(BlockState _bs, String _property, int _newValue) {
											Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
											return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
										}
									}.with(ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse((((ForgeRegistries.BLOCKS.getKey(blockstate.getBlock()).toString()).replace(":locked_", ":"))).toLowerCase(java.util.Locale.ENGLISH)))
											.defaultBlockState(), "blockstate",
											(world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip121
													? (world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getValue(_getip121)
													: -1));
									BlockState _bso = world.getBlockState(_bp);
									for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
										Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
										if (_property != null && _bs.getValue(_property) != null)
											try {
												_bs = _bs.setValue(_property, (Comparable) entry.getValue());
											} catch (Exception e) {
											}
									}
									world.setBlock(_bp, _bs, 3);
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
				if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp128
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp128)
						&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep130
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep130).toString()
								: "").equals("right")) {
					for (int index12 = 0; index12 < (int) width; index12++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip132
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip132)
								: -1) >= height + 3 * openValue) {
							posZ = posZ + 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip134
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip134)
									: -1) - 3 * openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip139
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip139)
										: -1) == 3 * openValue) {
							foundBlock = true;
							break;
						}
					}
				} else if (!((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp141
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp141))
						&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep143
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep143).toString()
								: "").equals("right")) {
					for (int index13 = 0; index13 < (int) width; index13++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip145
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip145)
								: -1) >= height + 2 * openValue) {
							posZ = posZ + 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip147
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip147)
									: -1) - 2 * openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip152
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip152)
										: -1) == 2 * openValue) {
							foundBlock = true;
							break;
						}
					}
				} else if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp154
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp154)) {
					for (int index14 = 0; index14 < (int) width; index14++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip156
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip156)
								: -1) >= height + openValue) {
							posZ = posZ + 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip158
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip158)
									: -1) - openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip163
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip163)
										: -1) == openValue) {
							foundBlock = true;
							break;
						}
					}
				} else {
					for (int index15 = 0; index15 < (int) width; index15++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip165
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip165)
								: -1) >= height) {
							posZ = posZ + 1;
						} else {
							posY = posY - Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip167
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip167)
									: -1);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip172
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip172)
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
								{
									BlockPos _bp = BlockPos.containing(posX2, posY2, posZ2);
									BlockState _bs = (new Object() {
										public BlockState with(BlockState _bs, String _property, int _newValue) {
											Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
											return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
										}
									}.with(ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse((((ForgeRegistries.BLOCKS.getKey(blockstate.getBlock()).toString()).replace(":locked_", ":"))).toLowerCase(java.util.Locale.ENGLISH)))
											.defaultBlockState(), "blockstate",
											(world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip180
													? (world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getValue(_getip180)
													: -1));
									BlockState _bso = world.getBlockState(_bp);
									for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
										Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
										if (_property != null && _bs.getValue(_property) != null)
											try {
												_bs = _bs.setValue(_property, (Comparable) entry.getValue());
											} catch (Exception e) {
											}
									}
									world.setBlock(_bp, _bs, 3);
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
				if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp187
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp187)
						&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep189
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep189).toString()
								: "").equals("right")) {
					for (int index18 = 0; index18 < (int) width; index18++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip191
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip191)
								: -1) >= height + 3 * openValue) {
							posZ = posZ - 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip193
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip193)
									: -1) - 3 * openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip198
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip198)
										: -1) == 3 * openValue) {
							foundBlock = true;
							break;
						}
					}
				} else if (!((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp200
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp200))
						&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("hinge") instanceof EnumProperty _getep202
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getep202).toString()
								: "").equals("right")) {
					for (int index19 = 0; index19 < (int) width; index19++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip204
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip204)
								: -1) >= height + 2 * openValue) {
							posZ = posZ - 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip206
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip206)
									: -1) - 2 * openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip211
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip211)
										: -1) == 2 * openValue) {
							foundBlock = true;
							break;
						}
					}
				} else if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp213
						&& (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getbp213)) {
					for (int index20 = 0; index20 < (int) width; index20++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip215
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip215)
								: -1) >= height + openValue) {
							posZ = posZ - 1;
						} else {
							posY = posY - (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip217
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip217)
									: -1) - openValue);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip222
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip222)
										: -1) == openValue) {
							foundBlock = true;
							break;
						}
					}
				} else {
					for (int index21 = 0; index21 < (int) width; index21++) {
						if (Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip224
								? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip224)
								: -1) >= height) {
							posZ = posZ - 1;
						} else {
							posY = posY - Math.abs((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip226
									? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip226)
									: -1);
						}
						if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock()
								&& ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip231
										? (world.getBlockState(BlockPos.containing(posX, posY, posZ))).getValue(_getip231)
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
								{
									BlockPos _bp = BlockPos.containing(posX2, posY2, posZ2);
									BlockState _bs = (new Object() {
										public BlockState with(BlockState _bs, String _property, int _newValue) {
											Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
											return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
										}
									}.with(ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse((((ForgeRegistries.BLOCKS.getKey(blockstate.getBlock()).toString()).replace(":locked_", ":"))).toLowerCase(java.util.Locale.ENGLISH)))
											.defaultBlockState(), "blockstate",
											(world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip239
													? (world.getBlockState(BlockPos.containing(posX2, posY2, posZ2))).getValue(_getip239)
													: -1));
									BlockState _bso = world.getBlockState(_bp);
									for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
										Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
										if (_property != null && _bs.getValue(_property) != null)
											try {
												_bs = _bs.setValue(_property, (Comparable) entry.getValue());
											} catch (Exception e) {
											}
									}
									world.setBlock(_bp, _bs, 3);
								}
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