package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModMenus;
import zeldacraft.init.ZeldaCraftModItems;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.screens.Screen;

public class Withdraw1Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double dividen = 0;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("zelda_craft:wallet")))) {
				if (Screen.hasShiftDown()) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("dividen",
							((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") / 1));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") >= (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
							.getOrCreateTag().getDouble("dividen")) {
						if (new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									ItemStack stack = _menu.getSlots().get(sltid).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(0) == 0 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == ZeldaCraftModItems.GREEN_RUPEE.get()) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
									((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount")
											- (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("dividen")));
							if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
								ItemStack _setstack = new ItemStack(ZeldaCraftModItems.GREEN_RUPEE.get()).copy();
								_setstack.setCount((int) (new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("dividen")));
								_menu.getSlots().get(0).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				} else {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") >= 1) {
						if (new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									ItemStack stack = _menu.getSlots().get(sltid).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(0) == 0 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == ZeldaCraftModItems.GREEN_RUPEE.get()) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
									((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") - 1));
							if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
								ItemStack _setstack = new ItemStack(ZeldaCraftModItems.GREEN_RUPEE.get()).copy();
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
			} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(EquipedWalletProcedure.execute(entity).getItem(), lv).isPresent() : false) {
				if (entity instanceof LivingEntity lv) {
					CuriosApi.getCuriosHelper().findCurios(lv, EquipedWalletProcedure.execute(entity).getItem()).forEach(item -> {
						ItemStack itemstackiterator = item.stack();
						if (Screen.hasShiftDown()) {
							itemstackiterator.getOrCreateTag().putDouble("dividen", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") / 1));
							if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") >= itemstackiterator.getOrCreateTag().getDouble("dividen")) {
								if (new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) == 0 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu45 ? _menu45.getSlots().get(0).getItem() : ItemStack.EMPTY)
										.getItem() == ZeldaCraftModItems.GREEN_RUPEE.get()) {
									itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") - itemstackiterator.getOrCreateTag().getDouble("dividen")));
									if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
										ItemStack _setstack = new ItemStack(ZeldaCraftModItems.GREEN_RUPEE.get()).copy();
										_setstack.setCount((int) (new Object() {
											public int getAmount(int sltid) {
												if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
													ItemStack stack = _menu.getSlots().get(sltid).getItem();
													if (stack != null)
														return stack.getCount();
												}
												return 0;
											}
										}.getAmount(0) + itemstackiterator.getOrCreateTag().getDouble("dividen")));
										_menu.getSlots().get(0).set(_setstack);
										_player.containerMenu.broadcastChanges();
									}
								}
							}
						} else {
							if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") >= 1) {
								if (new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) == 0 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu60 ? _menu60.getSlots().get(0).getItem() : ItemStack.EMPTY)
										.getItem() == ZeldaCraftModItems.GREEN_RUPEE.get()) {
									itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") - 1));
									if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
										ItemStack _setstack = new ItemStack(ZeldaCraftModItems.GREEN_RUPEE.get()).copy();
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
					});
				}
			}
		}
	}
}