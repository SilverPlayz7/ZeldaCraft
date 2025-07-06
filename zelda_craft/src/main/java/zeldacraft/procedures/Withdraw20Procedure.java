package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModItems;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.screens.Screen;

import java.util.function.Supplier;
import java.util.Map;

public class Withdraw20Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double dividen = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ZeldaCraftModItems.CHILD_WALLET.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") >= 20) {
				if (Screen.hasShiftDown()) {
					dividen = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") / 20;
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") >= dividen) {
						if (new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(0) == 0 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getItem() == ZeldaCraftModItems.RED_RUPEE.get()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(ZeldaCraftModItems.RED_RUPEE.get()).copy();
								_setstack.setCount((int) (new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) + dividen));
								((Slot) _slots.get(0)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
									((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") - new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
												ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
												if (stack != null)
													return stack.getCount();
											}
											return 0;
										}
									}.getAmount(0) * 20));
						}
					}
				} else {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") >= 20) {
						if (new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(0) == 0 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getItem() == ZeldaCraftModItems.BLUE_RUPEE.get()) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
									((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") - 20));
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(ZeldaCraftModItems.RED_RUPEE.get()).copy();
								_setstack.setCount((int) (new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) + 1));
								((Slot) _slots.get(0)).set(_setstack);
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
					if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") >= 20) {
						if (Screen.hasShiftDown()) {
							entity.getPersistentData().putDouble("dividen", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") / 20));
							if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") >= entity.getPersistentData().getDouble("dividen")) {
								if (new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) == 0 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
										.getItem() == ZeldaCraftModItems.RED_RUPEE.get()) {
									if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack _setstack = new ItemStack(ZeldaCraftModItems.RED_RUPEE.get()).copy();
										_setstack.setCount((int) (new Object() {
											public int getAmount(int sltid) {
												if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
													ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
													if (stack != null)
														return stack.getCount();
												}
												return 0;
											}
										}.getAmount(0) + entity.getPersistentData().getDouble("dividen")));
										((Slot) _slots.get(0)).set(_setstack);
										_player.containerMenu.broadcastChanges();
									}
									itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") - new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
												ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
												if (stack != null)
													return stack.getCount();
											}
											return 0;
										}
									}.getAmount(0) * 20));
								}
							}
						} else {
							if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") >= 5) {
								if (new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) == 0 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
										.getItem() == ZeldaCraftModItems.RED_RUPEE.get()) {
									itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") - 20));
									if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack _setstack = new ItemStack(ZeldaCraftModItems.RED_RUPEE.get()).copy();
										_setstack.setCount((int) (new Object() {
											public int getAmount(int sltid) {
												if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
													ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
													if (stack != null)
														return stack.getCount();
												}
												return 0;
											}
										}.getAmount(0) + 1));
										((Slot) _slots.get(0)).set(_setstack);
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
