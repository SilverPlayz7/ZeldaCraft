package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModMenus;
import zeldacraft.init.ZeldaCraftModItems;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

public class DepositRupeesProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ZeldaCraftModItems.CHILD_WALLET.get()) {
			if (Screen.hasShiftDown()) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") < 99) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ZeldaCraftModItems.GREEN_RUPEE
							.get()) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
								((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") + new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) * 1));
						if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu13 ? _menu13.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ZeldaCraftModItems.BLUE_RUPEE
							.get()) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
								((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") + new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) * 5));
						if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ZeldaCraftModItems.RED_RUPEE
							.get()) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
								((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") + new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) * 20));
						if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu29 ? _menu29.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.getItem() == ZeldaCraftModItems.PURPLE_RUPEE.get()) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
								((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") + new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) * 50));
						if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu37 ? _menu37.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.getItem() == ZeldaCraftModItems.SILVER_RUPEE.get()) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
								((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") + new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) * 100));
						if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu45 ? _menu45.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ZeldaCraftModItems.GOLD_RUPEE
							.get()) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
								((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") + new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) * 300));
						if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			} else {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") < 99) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu55 ? _menu55.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ZeldaCraftModItems.GREEN_RUPEE
							.get()) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
								((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") + 1));
						if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							_player.containerMenu.broadcastChanges();
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu62 ? _menu62.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ZeldaCraftModItems.BLUE_RUPEE
							.get()) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
								((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") + 5));
						if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							_player.containerMenu.broadcastChanges();
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu69 ? _menu69.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ZeldaCraftModItems.RED_RUPEE
							.get()) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
								((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") + 20));
						if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							_player.containerMenu.broadcastChanges();
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu76 ? _menu76.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.getItem() == ZeldaCraftModItems.PURPLE_RUPEE.get()) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
								((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") + 50));
						if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							_player.containerMenu.broadcastChanges();
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu83 ? _menu83.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.getItem() == ZeldaCraftModItems.SILVER_RUPEE.get()) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
								((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") + 100));
						if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							_player.containerMenu.broadcastChanges();
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu90 ? _menu90.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ZeldaCraftModItems.GOLD_RUPEE
							.get()) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
								((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") + 300));
						if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") > 99) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount", 99);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Your wallet is full"), true);
			}
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(ZeldaCraftModItems.CHILD_WALLET.get(), lv).isPresent() : false) {
			if (entity instanceof LivingEntity lv) {
				CuriosApi.getCuriosHelper().findCurios(lv, ZeldaCraftModItems.CHILD_WALLET.get()).forEach(item -> {
					ItemStack itemstackiterator = item.stack();
					if (Screen.hasShiftDown()) {
						if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") < 99) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu106 ? _menu106.getSlots().get(0).getItem() : ItemStack.EMPTY)
									.getItem() == ZeldaCraftModItems.GREEN_RUPEE.get()) {
								itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) * 1));
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).set(ItemStack.EMPTY);
									_player.containerMenu.broadcastChanges();
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu114 ? _menu114.getSlots().get(0).getItem() : ItemStack.EMPTY)
									.getItem() == ZeldaCraftModItems.BLUE_RUPEE.get()) {
								itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) * 5));
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).set(ItemStack.EMPTY);
									_player.containerMenu.broadcastChanges();
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu122 ? _menu122.getSlots().get(0).getItem() : ItemStack.EMPTY)
									.getItem() == ZeldaCraftModItems.RED_RUPEE.get()) {
								itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) * 20));
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).set(ItemStack.EMPTY);
									_player.containerMenu.broadcastChanges();
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu130 ? _menu130.getSlots().get(0).getItem() : ItemStack.EMPTY)
									.getItem() == ZeldaCraftModItems.PURPLE_RUPEE.get()) {
								itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) * 50));
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).set(ItemStack.EMPTY);
									_player.containerMenu.broadcastChanges();
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu138 ? _menu138.getSlots().get(0).getItem() : ItemStack.EMPTY)
									.getItem() == ZeldaCraftModItems.SILVER_RUPEE.get()) {
								itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) * 100));
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).set(ItemStack.EMPTY);
									_player.containerMenu.broadcastChanges();
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu146 ? _menu146.getSlots().get(0).getItem() : ItemStack.EMPTY)
									.getItem() == ZeldaCraftModItems.GOLD_RUPEE.get()) {
								itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) * 300));
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).set(ItemStack.EMPTY);
									_player.containerMenu.broadcastChanges();
								}
							}
						}
					} else {
						if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") < 99) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu156 ? _menu156.getSlots().get(0).getItem() : ItemStack.EMPTY)
									.getItem() == ZeldaCraftModItems.GREEN_RUPEE.get()) {
								itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + 1));
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu163 ? _menu163.getSlots().get(0).getItem() : ItemStack.EMPTY)
									.getItem() == ZeldaCraftModItems.BLUE_RUPEE.get()) {
								itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + 5));
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu170 ? _menu170.getSlots().get(0).getItem() : ItemStack.EMPTY)
									.getItem() == ZeldaCraftModItems.RED_RUPEE.get()) {
								itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + 20));
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu177 ? _menu177.getSlots().get(0).getItem() : ItemStack.EMPTY)
									.getItem() == ZeldaCraftModItems.PURPLE_RUPEE.get()) {
								itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + 50));
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu184 ? _menu184.getSlots().get(0).getItem() : ItemStack.EMPTY)
									.getItem() == ZeldaCraftModItems.SILVER_RUPEE.get()) {
								itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + 100));
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu191 ? _menu191.getSlots().get(0).getItem() : ItemStack.EMPTY)
									.getItem() == ZeldaCraftModItems.GOLD_RUPEE.get()) {
								itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + 300));
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							}
						}
					}
					if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") > 99) {
						itemstackiterator.getOrCreateTag().putDouble("RupeeCount", 99);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your wallet is full"), true);
					}
				});
			}
		}
	}
}