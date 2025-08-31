package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModMenus;
import zeldacraft.init.ZeldaCraftModItems;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.screens.Screen;

public class Withdraw100Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double dividen = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ZeldaCraftModItems.CHILD_WALLET.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") >= 100) {
				if (Screen.hasShiftDown()) {
					dividen = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") / 100;
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") >= dividen) {
						if (new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									ItemStack stack = _menu.getSlots().get(sltid).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(0) == 0 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == ZeldaCraftModItems.SILVER_RUPEE.get()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
								ItemStack _setstack = new ItemStack(ZeldaCraftModItems.SILVER_RUPEE.get()).copy();
								_setstack.setCount((int) (new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) + dividen));
								_menu.getSlots().get(0).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
									((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") - new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
												ItemStack stack = _menu.getSlots().get(sltid).getItem();
												if (stack != null)
													return stack.getCount();
											}
											return 0;
										}
									}.getAmount(0) * 100));
						}
					}
				} else {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") >= 100) {
						if (new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									ItemStack stack = _menu.getSlots().get(sltid).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(0) == 0 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == ZeldaCraftModItems.SILVER_RUPEE.get()) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
									((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") - 100));
							if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
								ItemStack _setstack = new ItemStack(ZeldaCraftModItems.SILVER_RUPEE.get()).copy();
								_setstack.setCount(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) + 1);
								_menu.getSlots().get(0).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(ZeldaCraftModItems.CHILD_WALLET.get(), lv).isPresent() : false) {
			if (entity instanceof LivingEntity lv) {
				CuriosApi.getCuriosHelper().findCurios(lv, ZeldaCraftModItems.CHILD_WALLET.get()).forEach(item -> {
					ItemStack itemstackiterator = item.stack();
					if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") >= 100) {
						if (Screen.hasShiftDown()) {
							entity.getPersistentData().putDouble("dividen", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") / 100));
							if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") >= entity.getPersistentData().getDouble("dividen")) {
								if (new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) == 0 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu39 ? _menu39.getSlots().get(0).getItem() : ItemStack.EMPTY)
										.getItem() == ZeldaCraftModItems.SILVER_RUPEE.get()) {
									if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
										ItemStack _setstack = new ItemStack(ZeldaCraftModItems.SILVER_RUPEE.get()).copy();
										_setstack.setCount((int) (new Object() {
											public int getAmount(int sltid) {
												if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
													ItemStack stack = _menu.getSlots().get(sltid).getItem();
													if (stack != null)
														return stack.getCount();
												}
												return 0;
											}
										}.getAmount(0) + entity.getPersistentData().getDouble("dividen")));
										_menu.getSlots().get(0).set(_setstack);
										_player.containerMenu.broadcastChanges();
									}
									itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") - new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
												ItemStack stack = _menu.getSlots().get(sltid).getItem();
												if (stack != null)
													return stack.getCount();
											}
											return 0;
										}
									}.getAmount(0) * 100));
								}
							}
						} else {
							if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") >= 100) {
								if (new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) == 0 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu52 ? _menu52.getSlots().get(0).getItem() : ItemStack.EMPTY)
										.getItem() == ZeldaCraftModItems.SILVER_RUPEE.get()) {
									itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") - 100));
									if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
										ItemStack _setstack = new ItemStack(ZeldaCraftModItems.SILVER_RUPEE.get()).copy();
										_setstack.setCount(new Object() {
											public int getAmount(int sltid) {
												if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
													ItemStack stack = _menu.getSlots().get(sltid).getItem();
													if (stack != null)
														return stack.getCount();
												}
												return 0;
											}
										}.getAmount(0) + 1);
										_menu.getSlots().get(0).set(_setstack);
										_player.containerMenu.broadcastChanges();
									}
								}
							}
						}
					}
				});
			}
		}
	}
}