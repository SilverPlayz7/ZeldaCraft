package zeldacraft.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.Map;

public class DoorGeneratorProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		boolean canPlace = false;
		boolean canTestAir = false;
		double width = 0;
		double height = 0;
		double state = 0;
		double posX = 0;
		double posY = 0;
		double posZ = 0;
		double xModifier = 0;
		double maxStates = 0;
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
		maxStates = width * height;
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.NORTH) {
			canTestAir = true;
			posX = x;
			posY = y - 1;
			posZ = z;
			if (!(world.getBlockState(BlockPos.containing(x - 1, y, z))).canBeReplaced()) {
				xModifier = -1;
			} else {
				xModifier = 1;
			}
			for (int index0 = 0; index0 < (int) width; index0++) {
				if (!(world.getBlockState(BlockPos.containing(posX, posY, posZ))).canBeReplaced()) {
					canTestAir = true;
				} else {
					canTestAir = false;
					break;
				}
				posX = posX - 1 * xModifier;
			}
			if (canTestAir) {
				canPlace = true;
				posX = x;
				posY = y;
				posZ = z;
				for (int index1 = 0; index1 < (int) width; index1++) {
					for (int index2 = 0; index2 < (int) height; index2++) {
						if (!((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock())) {
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).canBeReplaced()) {
								canPlace = true;
							} else {
								canPlace = false;
								break;
							}
						}
						posY = posY + 1;
					}
					if (!canPlace) {
						break;
					}
					posY = y;
					posX = posX - 1 * xModifier;
				}
				if (canPlace) {
					posX = x;
					posY = y;
					posZ = z;
					if (xModifier == -1) {
						state = maxStates - height;
						for (int index3 = 0; index3 < (int) width; index3++) {
							for (int index4 = 0; index4 < (int) height; index4++) {
								if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getFluidState().isSource()) {
									world.setBlock(BlockPos.containing(posX, posY, posZ), (new Object() {
										public BlockState with(BlockState _bs, String _property, int _newValue) {
											Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
											return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
										}
									}.with(blockstate, "blockstate", (int) state)), 3);
									{
										Direction _dir = (new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate));
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
											world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
										} else {
											_property = _bs.getBlock().getStateDefinition().getProperty("axis");
											if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
												world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
										}
									}
									{
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _booleanProp)
											world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
									}
								} else {
									world.setBlock(BlockPos.containing(posX, posY, posZ), (new Object() {
										public BlockState with(BlockState _bs, String _property, int _newValue) {
											Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
											return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
										}
									}.with(blockstate, "blockstate", (int) state)), 3);
									{
										Direction _dir = (new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate));
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
											world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
										} else {
											_property = _bs.getBlock().getStateDefinition().getProperty("axis");
											if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
												world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
										}
									}
								}
								state = state + 1;
								posY = posY + 1;
							}
							posY = y;
							state = state - height * 2;
							posX = posX - 1 * xModifier;
						}
					} else {
						state = 0;
						for (int index5 = 0; index5 < (int) width; index5++) {
							for (int index6 = 0; index6 < (int) height; index6++) {
								if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getFluidState().isSource()) {
									{
										BlockPos _bp = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = (new Object() {
											public BlockState with(BlockState _bs, String _property, int _newValue) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
												return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
											}
										}.with(blockstate, "blockstate", (int) state));
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
									{
										Direction _dir = (new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate));
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
											world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
										} else {
											_property = _bs.getBlock().getStateDefinition().getProperty("axis");
											if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
												world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
										}
									}
									{
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _booleanProp)
											world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
									}
								} else {
									{
										BlockPos _bp = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = (new Object() {
											public BlockState with(BlockState _bs, String _property, int _newValue) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
												return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
											}
										}.with(blockstate, "blockstate", (int) state));
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
									{
										Direction _dir = (new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate));
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
											world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
										} else {
											_property = _bs.getBlock().getStateDefinition().getProperty("axis");
											if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
												world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
										}
									}
								}
								state = state + 1;
								posY = posY + 1;
							}
							posY = y;
							posX = posX - 1 * xModifier;
						}
					}
				} else {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (new ItemStack(blockstate.getBlock())));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else {
				world.destroyBlock(BlockPos.containing(x, y, z), false);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (new ItemStack(blockstate.getBlock())));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.SOUTH) {
			canTestAir = true;
			posX = x;
			posY = y - 1;
			posZ = z;
			if (!(world.getBlockState(BlockPos.containing(x + 1, y, z))).canBeReplaced()) {
				xModifier = -1;
			} else {
				xModifier = 1;
			}
			for (int index7 = 0; index7 < (int) width; index7++) {
				if (!(world.getBlockState(BlockPos.containing(posX, posY, posZ))).canBeReplaced()) {
					canTestAir = true;
				} else {
					canTestAir = false;
					break;
				}
				posX = posX + 1 * xModifier;
			}
			if (canTestAir) {
				canPlace = true;
				posX = x;
				posY = y;
				posZ = z;
				for (int index8 = 0; index8 < (int) width; index8++) {
					for (int index9 = 0; index9 < (int) height; index9++) {
						if (!((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock())) {
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).canBeReplaced()) {
								canPlace = true;
							} else {
								canPlace = false;
								break;
							}
						}
						posY = posY + 1;
					}
					if (!canPlace) {
						break;
					}
					posY = y;
					posX = posX + 1 * xModifier;
				}
				if (canPlace) {
					posX = x;
					posY = y;
					posZ = z;
					if (xModifier == -1) {
						state = maxStates - height;
						for (int index10 = 0; index10 < (int) width; index10++) {
							for (int index11 = 0; index11 < (int) height; index11++) {
								if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getFluidState().isSource()) {
									world.setBlock(BlockPos.containing(posX, posY, posZ), (new Object() {
										public BlockState with(BlockState _bs, String _property, int _newValue) {
											Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
											return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
										}
									}.with(blockstate, "blockstate", (int) state)), 3);
									{
										Direction _dir = (new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate));
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
											world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
										} else {
											_property = _bs.getBlock().getStateDefinition().getProperty("axis");
											if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
												world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
										}
									}
									{
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _booleanProp)
											world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
									}
								} else {
									world.setBlock(BlockPos.containing(posX, posY, posZ), (new Object() {
										public BlockState with(BlockState _bs, String _property, int _newValue) {
											Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
											return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
										}
									}.with(blockstate, "blockstate", (int) state)), 3);
									{
										Direction _dir = (new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate));
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
											world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
										} else {
											_property = _bs.getBlock().getStateDefinition().getProperty("axis");
											if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
												world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
										}
									}
								}
								state = state + 1;
								posY = posY + 1;
							}
							posY = y;
							state = state - height * 2;
							posX = posX + 1 * xModifier;
						}
					} else {
						state = 0;
						for (int index12 = 0; index12 < (int) width; index12++) {
							for (int index13 = 0; index13 < (int) height; index13++) {
								if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getFluidState().isSource()) {
									{
										BlockPos _bp = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = (new Object() {
											public BlockState with(BlockState _bs, String _property, int _newValue) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
												return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
											}
										}.with(blockstate, "blockstate", (int) state));
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
									{
										Direction _dir = (new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate));
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
											world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
										} else {
											_property = _bs.getBlock().getStateDefinition().getProperty("axis");
											if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
												world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
										}
									}
									{
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _booleanProp)
											world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
									}
								} else {
									{
										BlockPos _bp = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = (new Object() {
											public BlockState with(BlockState _bs, String _property, int _newValue) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
												return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
											}
										}.with(blockstate, "blockstate", (int) state));
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
									{
										Direction _dir = (new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate));
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
											world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
										} else {
											_property = _bs.getBlock().getStateDefinition().getProperty("axis");
											if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
												world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
										}
									}
								}
								state = state + 1;
								posY = posY + 1;
							}
							posY = y;
							posX = posX + 1 * xModifier;
						}
					}
				} else {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (new ItemStack(blockstate.getBlock())));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else {
				world.destroyBlock(BlockPos.containing(x, y, z), false);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (new ItemStack(blockstate.getBlock())));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.EAST) {
			canTestAir = true;
			posX = x;
			posY = y - 1;
			posZ = z;
			if (!(world.getBlockState(BlockPos.containing(x, y, z - 1))).canBeReplaced()) {
				xModifier = -1;
			} else {
				xModifier = 1;
			}
			for (int index14 = 0; index14 < (int) width; index14++) {
				if (!(world.getBlockState(BlockPos.containing(posX, posY, posZ))).canBeReplaced()) {
					canTestAir = true;
				} else {
					canTestAir = false;
					break;
				}
				posZ = posZ - 1 * xModifier;
			}
			if (canTestAir) {
				canPlace = true;
				posX = x;
				posY = y;
				posZ = z;
				for (int index15 = 0; index15 < (int) width; index15++) {
					for (int index16 = 0; index16 < (int) height; index16++) {
						if (!((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock())) {
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).canBeReplaced()) {
								canPlace = true;
							} else {
								canPlace = false;
								break;
							}
						}
						posY = posY + 1;
					}
					if (!canPlace) {
						break;
					}
					posY = y;
					posZ = posZ - 1 * xModifier;
				}
				if (canPlace) {
					posX = x;
					posY = y;
					posZ = z;
					if (xModifier == -1) {
						state = maxStates - height;
						for (int index17 = 0; index17 < (int) width; index17++) {
							for (int index18 = 0; index18 < (int) height; index18++) {
								if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getFluidState().isSource()) {
									world.setBlock(BlockPos.containing(posX, posY, posZ), (new Object() {
										public BlockState with(BlockState _bs, String _property, int _newValue) {
											Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
											return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
										}
									}.with(blockstate, "blockstate", (int) state)), 3);
									{
										Direction _dir = (new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate));
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
											world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
										} else {
											_property = _bs.getBlock().getStateDefinition().getProperty("axis");
											if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
												world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
										}
									}
									{
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _booleanProp)
											world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
									}
								} else {
									world.setBlock(BlockPos.containing(posX, posY, posZ), (new Object() {
										public BlockState with(BlockState _bs, String _property, int _newValue) {
											Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
											return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
										}
									}.with(blockstate, "blockstate", (int) state)), 3);
									{
										Direction _dir = (new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate));
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
											world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
										} else {
											_property = _bs.getBlock().getStateDefinition().getProperty("axis");
											if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
												world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
										}
									}
								}
								state = state + 1;
								posY = posY + 1;
							}
							posY = y;
							state = state - height * 2;
							posZ = posZ - 1 * xModifier;
						}
					} else {
						state = 0;
						for (int index19 = 0; index19 < (int) width; index19++) {
							for (int index20 = 0; index20 < (int) height; index20++) {
								if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getFluidState().isSource()) {
									{
										BlockPos _bp = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = (new Object() {
											public BlockState with(BlockState _bs, String _property, int _newValue) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
												return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
											}
										}.with(blockstate, "blockstate", (int) state));
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
									{
										Direction _dir = (new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate));
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
											world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
										} else {
											_property = _bs.getBlock().getStateDefinition().getProperty("axis");
											if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
												world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
										}
									}
									{
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _booleanProp)
											world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
									}
								} else {
									{
										BlockPos _bp = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = (new Object() {
											public BlockState with(BlockState _bs, String _property, int _newValue) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
												return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
											}
										}.with(blockstate, "blockstate", (int) state));
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
									{
										Direction _dir = (new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate));
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
											world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
										} else {
											_property = _bs.getBlock().getStateDefinition().getProperty("axis");
											if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
												world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
										}
									}
								}
								state = state + 1;
								posY = posY + 1;
							}
							posY = y;
							posZ = posZ - 1 * xModifier;
						}
					}
				} else {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (new ItemStack(blockstate.getBlock())));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else {
				world.destroyBlock(BlockPos.containing(x, y, z), false);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (new ItemStack(blockstate.getBlock())));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.WEST) {
			canTestAir = true;
			posX = x;
			posY = y - 1;
			posZ = z;
			if (!(world.getBlockState(BlockPos.containing(x, y, z + 1))).canBeReplaced()) {
				xModifier = -1;
			} else {
				xModifier = 1;
			}
			for (int index21 = 0; index21 < (int) width; index21++) {
				if (!(world.getBlockState(BlockPos.containing(posX, posY, posZ))).canBeReplaced()) {
					canTestAir = true;
				} else {
					canTestAir = false;
					break;
				}
				posZ = posZ + 1 * xModifier;
			}
			if (canTestAir) {
				canPlace = true;
				posX = x;
				posY = y;
				posZ = z;
				for (int index22 = 0; index22 < (int) width; index22++) {
					for (int index23 = 0; index23 < (int) height; index23++) {
						if (!((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == blockstate.getBlock())) {
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).canBeReplaced()) {
								canPlace = true;
							} else {
								canPlace = false;
								break;
							}
						}
						posY = posY + 1;
					}
					if (!canPlace) {
						break;
					}
					posY = y;
					posZ = posZ + 1 * xModifier;
				}
				if (canPlace) {
					posX = x;
					posY = y;
					posZ = z;
					if (xModifier == -1) {
						state = maxStates - height;
						for (int index24 = 0; index24 < (int) width; index24++) {
							for (int index25 = 0; index25 < (int) height; index25++) {
								if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getFluidState().isSource()) {
									world.setBlock(BlockPos.containing(posX, posY, posZ), (new Object() {
										public BlockState with(BlockState _bs, String _property, int _newValue) {
											Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
											return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
										}
									}.with(blockstate, "blockstate", (int) state)), 3);
									{
										Direction _dir = (new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate));
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
											world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
										} else {
											_property = _bs.getBlock().getStateDefinition().getProperty("axis");
											if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
												world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
										}
									}
									{
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _booleanProp)
											world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
									}
								} else {
									world.setBlock(BlockPos.containing(posX, posY, posZ), (new Object() {
										public BlockState with(BlockState _bs, String _property, int _newValue) {
											Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
											return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
										}
									}.with(blockstate, "blockstate", (int) state)), 3);
									{
										Direction _dir = (new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate));
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
											world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
										} else {
											_property = _bs.getBlock().getStateDefinition().getProperty("axis");
											if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
												world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
										}
									}
								}
								state = state + 1;
								posY = posY + 1;
							}
							posY = y;
							state = state - height * 2;
							posZ = posZ + 1 * xModifier;
						}
					} else {
						state = 0;
						for (int index26 = 0; index26 < (int) width; index26++) {
							for (int index27 = 0; index27 < (int) height; index27++) {
								if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getFluidState().isSource()) {
									{
										BlockPos _bp = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = (new Object() {
											public BlockState with(BlockState _bs, String _property, int _newValue) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
												return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
											}
										}.with(blockstate, "blockstate", (int) state));
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
									{
										Direction _dir = (new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate));
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
											world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
										} else {
											_property = _bs.getBlock().getStateDefinition().getProperty("axis");
											if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
												world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
										}
									}
									{
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _booleanProp)
											world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
									}
								} else {
									{
										BlockPos _bp = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = (new Object() {
											public BlockState with(BlockState _bs, String _property, int _newValue) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
												return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
											}
										}.with(blockstate, "blockstate", (int) state));
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
									{
										Direction _dir = (new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate));
										BlockPos _pos = BlockPos.containing(posX, posY, posZ);
										BlockState _bs = world.getBlockState(_pos);
										Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
											world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
										} else {
											_property = _bs.getBlock().getStateDefinition().getProperty("axis");
											if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
												world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
										}
									}
								}
								state = state + 1;
								posY = posY + 1;
							}
							posY = y;
							posZ = posZ + 1 * xModifier;
						}
					}
				} else {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (new ItemStack(blockstate.getBlock())));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else {
				world.destroyBlock(BlockPos.containing(x, y, z), false);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (new ItemStack(blockstate.getBlock())));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}