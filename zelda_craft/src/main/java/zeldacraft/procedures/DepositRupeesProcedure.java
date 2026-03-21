package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModMenus;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

public class DepositRupeesProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("zelda_craft:wallet")))) {
			if (Screen.hasShiftDown()) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") < MaxRupeesProcedure
						.execute(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("zelda_craft:rupee")))) {
						if (!world.isClientSide()) {
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
									}.getAmount(0) * RupeeValueProcedure
											.execute(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(0).getItem() : ItemStack.EMPTY)));
							if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).set(ItemStack.EMPTY);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			} else {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") < MaxRupeesProcedure
						.execute(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu19 ? _menu19.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("zelda_craft:rupee")))) {
						if (!world.isClientSide()) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
									((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") + RupeeValueProcedure
											.execute(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(0).getItem() : ItemStack.EMPTY)));
							if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") > MaxRupeesProcedure
					.execute(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) {
				if (!world.isClientSide()) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
							MaxRupeesProcedure.execute(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Your wallet is full"), true);
			}
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(EquipedWalletProcedure.execute(entity).getItem(), lv).isPresent() : false) {
			if (entity instanceof LivingEntity lv) {
				CuriosApi.getCuriosHelper().findCurios(lv, EquipedWalletProcedure.execute(entity).getItem()).forEach(item -> {
					ItemStack itemstackiterator = item.stack();
					if (Screen.hasShiftDown()) {
						if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") < MaxRupeesProcedure.execute(itemstackiterator)) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu41 ? _menu41.getSlots().get(0).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("zelda_craft:rupee")))) {
								if (!world.isClientSide()) {
									itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
												ItemStack stack = _menu.getSlots().get(sltid).getItem();
												if (stack != null)
													return stack.getCount();
											}
											return 0;
										}
									}.getAmount(0) * RupeeValueProcedure
											.execute(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu47 ? _menu47.getSlots().get(0).getItem() : ItemStack.EMPTY)));
									if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(0).set(ItemStack.EMPTY);
										_player.containerMenu.broadcastChanges();
									}
								}
							}
						}
					} else {
						if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") < MaxRupeesProcedure.execute(itemstackiterator)) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(0).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("zelda_craft:rupee")))) {
								if (!world.isClientSide()) {
									itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + RupeeValueProcedure
											.execute(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu59 ? _menu59.getSlots().get(0).getItem() : ItemStack.EMPTY)));
									if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(0).remove(1);
										_player.containerMenu.broadcastChanges();
									}
								}
							}
						}
					}
					if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") > MaxRupeesProcedure.execute(itemstackiterator)) {
						if (!world.isClientSide()) {
							itemstackiterator.getOrCreateTag().putDouble("RupeeCount", MaxRupeesProcedure.execute(itemstackiterator));
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your wallet is full"), true);
					}
				});
			}
		}
	}
}