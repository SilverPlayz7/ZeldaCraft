package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import zeldacraft.init.ZeldaCraftModBlocks;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.Arrays;
import java.util.ArrayList;

public class Warp1TeleportProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double index = 0;
		ArrayList<Object> statueList = new ArrayList<>();
		MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
		if (server != null) {
			{
				statueList.addAll((new Object() {
					public ArrayList<Object> convert(String text, String separator) {
						return new ArrayList<>(Arrays.asList(text.split(separator)));
					}
				}.convert(((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).owlStatue), ",")));
			}
			index = 0;
			if ((world.getBlockState(BlockPos.containing(new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
			}.get(statueList, (int) (index + 2 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
			}.get(statueList, (int) (index + 3 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
			}.get(statueList, (int) (index + 4 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)))))))).getBlock() == ZeldaCraftModBlocks.OWL_STATUE
					.get()) {
				if ((new Object() {
					public Direction getDirection(BlockPos pos) {
						BlockState _bs = world.getBlockState(pos);
						Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (property != null && _bs.getValue(property) instanceof Direction _dir)
							return _dir;
						else if (_bs.hasProperty(BlockStateProperties.AXIS))
							return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
						else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
							return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
						return Direction.NORTH;
					}
				}.getDirection(BlockPos.containing((int) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
				}.get(statueList, (int) (index + 2 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), (int) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
				}.get(statueList, (int) (index + 3 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), (int) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
				}.get(statueList, (int) (index + 4 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)))))))) == Direction.NORTH) {
					{
						Entity _ent = entity;
						_ent.teleportTo((new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
						}.get(statueList, (int) (index + 2 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))) + 0.5), new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
						}.get(statueList, (int) (index + 3 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), ((int) new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
						}.get(statueList, (int) (index + 4 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))) - 0.5));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
							}.get(statueList, (int) (index + 2 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))) + 0.5), new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
							}.get(statueList, (int) (index + 3 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), ((int) new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
							}.get(statueList, (int) (index + 4 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))) - 0.5), _ent.getYRot(),
									_ent.getXRot());
					}
				}
				if ((new Object() {
					public Direction getDirection(BlockPos pos) {
						BlockState _bs = world.getBlockState(pos);
						Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (property != null && _bs.getValue(property) instanceof Direction _dir)
							return _dir;
						else if (_bs.hasProperty(BlockStateProperties.AXIS))
							return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
						else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
							return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
						return Direction.NORTH;
					}
				}.getDirection(BlockPos.containing((int) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
				}.get(statueList, (int) (index + 2 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), (int) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
				}.get(statueList, (int) (index + 3 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), (int) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
				}.get(statueList, (int) (index + 4 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)))))))) == Direction.SOUTH) {
					{
						Entity _ent = entity;
						_ent.teleportTo((new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
						}.get(statueList, (int) (index + 2 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))) + 0.5), new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
						}.get(statueList, (int) (index + 3 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), ((int) new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
						}.get(statueList, (int) (index + 4 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))) + 1.5));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
							}.get(statueList, (int) (index + 2 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))) + 0.5), new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
							}.get(statueList, (int) (index + 3 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), ((int) new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
							}.get(statueList, (int) (index + 4 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))) + 1.5), _ent.getYRot(),
									_ent.getXRot());
					}
				}
				if ((new Object() {
					public Direction getDirection(BlockPos pos) {
						BlockState _bs = world.getBlockState(pos);
						Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (property != null && _bs.getValue(property) instanceof Direction _dir)
							return _dir;
						else if (_bs.hasProperty(BlockStateProperties.AXIS))
							return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
						else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
							return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
						return Direction.NORTH;
					}
				}.getDirection(BlockPos.containing((int) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
				}.get(statueList, (int) (index + 2 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
				}.get(statueList, (int) (index + 3 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), (int) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
				}.get(statueList, (int) (index + 4 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)))))))) == Direction.WEST) {
					{
						Entity _ent = entity;
						_ent.teleportTo((new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
						}.get(statueList, (int) (index + 2 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))) - 0.5), new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
						}.get(statueList, (int) (index + 3 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), ((int) new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
						}.get(statueList, (int) (index + 4 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))) + 0.5));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
							}.get(statueList, (int) (index + 2 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))) - 0.5), new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
							}.get(statueList, (int) (index + 3 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), ((int) new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
							}.get(statueList, (int) (index + 4 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))) + 0.5), _ent.getYRot(),
									_ent.getXRot());
					}
				}
				if ((new Object() {
					public Direction getDirection(BlockPos pos) {
						BlockState _bs = world.getBlockState(pos);
						Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (property != null && _bs.getValue(property) instanceof Direction _dir)
							return _dir;
						else if (_bs.hasProperty(BlockStateProperties.AXIS))
							return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
						else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
							return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
						return Direction.NORTH;
					}
				}.getDirection(BlockPos.containing((int) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
				}.get(statueList, (int) (index + 2 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), (int) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
				}.get(statueList, (int) (index + 3 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), (int) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
				}.get(statueList, (int) (index + 4 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum)))))))) == Direction.EAST) {
					{
						Entity _ent = entity;
						_ent.teleportTo((new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
						}.get(statueList, (int) (index + 2 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))) + 1.5), new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
						}.get(statueList, (int) (index + 3 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), ((int) new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
						}.get(statueList, (int) (index + 4 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))) + 0.5));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
							}.get(statueList, (int) (index + 2 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))) + 1.5), new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
							}.get(statueList, (int) (index + 3 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))), ((int) new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(new java.text.DecimalFormat("##.##").format(new Object() {
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
							}.get(statueList, (int) (index + 4 + 25 * (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).pageNum))))) + 0.5), _ent.getYRot(),
									_ent.getXRot());
					}
				}
			}
		}
	}
}