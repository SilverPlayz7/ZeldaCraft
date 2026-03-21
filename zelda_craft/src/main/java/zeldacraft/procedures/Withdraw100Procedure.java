package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModMenus;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.screens.Screen;

public class Withdraw100Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double dividen = 0;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("zelda_craft:wallet")))) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("rupee", "zelda_craft:silver_rupee");
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") >= RupeeValueProcedure.execute(new ItemStack(
						ForgeRegistries.ITEMS.getValue(ResourceLocation.parse((((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH)))))) {
					if (Screen.hasShiftDown()) {
						dividen = Math.floor((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") / RupeeValueProcedure.execute(new ItemStack(ForgeRegistries.ITEMS
								.getValue(ResourceLocation.parse((((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH))))));
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") >= dividen) {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") - dividen * RupeeValueProcedure.execute(new ItemStack(ForgeRegistries.ITEMS
									.getValue(ResourceLocation.parse((((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH))))) >= 0) {
								if (new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack stack = _menu.getSlots().get(sltid).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) == 0 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(0).getItem() : ItemStack.EMPTY)
										.getItem() == ForgeRegistries.ITEMS
												.getValue(ResourceLocation.parse((((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH)))) {
									if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
										ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS
												.getValue(ResourceLocation.parse((((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH))))
												.copy();
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
											((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount")
													- dividen * RupeeValueProcedure.execute(new ItemStack(ForgeRegistries.ITEMS.getValue(ResourceLocation
															.parse((((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH)))))));
								}
							}
						}
					} else {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") >= RupeeValueProcedure.execute(new ItemStack(ForgeRegistries.ITEMS
								.getValue(ResourceLocation.parse((((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH)))))) {
							if (new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
										ItemStack stack = _menu.getSlots().get(sltid).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(0) == 0
									|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu46 ? _menu46.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS
											.getValue(ResourceLocation.parse((((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH)))) {
								(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount") - RupeeValueProcedure.execute(new ItemStack(ForgeRegistries.ITEMS.getValue(
												ResourceLocation.parse((((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH)))))));
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS
											.getValue(ResourceLocation.parse((((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH))))
											.copy();
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
			} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(EquipedWalletProcedure.execute(entity).getItem(), lv).isPresent() : false) {
				if (entity instanceof LivingEntity lv) {
					CuriosApi.getCuriosHelper().findCurios(lv, EquipedWalletProcedure.execute(entity).getItem()).forEach(item -> {
						ItemStack itemstackiterator = item.stack();
						itemstackiterator.getOrCreateTag().putString("rupee", "zelda_craft:silver_rupee");
						if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") >= RupeeValueProcedure
								.execute(new ItemStack(ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((itemstackiterator.getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH)))))) {
							if (Screen.hasShiftDown()) {
								itemstackiterator.getOrCreateTag().putDouble("dividen", Math.floor(itemstackiterator.getOrCreateTag().getDouble("RupeeCount")
										/ RupeeValueProcedure.execute(new ItemStack(ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((itemstackiterator.getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH)))))));
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
									}.getAmount(0) == 0 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu83 ? _menu83.getSlots().get(0).getItem() : ItemStack.EMPTY)
											.getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((itemstackiterator.getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH)))) {
										if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((itemstackiterator.getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
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
										itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") - itemstackiterator.getOrCreateTag().getDouble("dividen")
												* RupeeValueProcedure.execute(new ItemStack(ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((itemstackiterator.getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH)))))));
									}
								}
							} else {
								if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") >= RupeeValueProcedure
										.execute(new ItemStack(ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((itemstackiterator.getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH)))))) {
									if (new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
												ItemStack stack = _menu.getSlots().get(sltid).getItem();
												if (stack != null)
													return stack.getCount();
											}
											return 0;
										}
									}.getAmount(0) == 0 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu110 ? _menu110.getSlots().get(0).getItem() : ItemStack.EMPTY)
											.getItem() == ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((itemstackiterator.getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH)))) {
										itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount")
												- RupeeValueProcedure.execute(new ItemStack(ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((itemstackiterator.getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH)))))));
										if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
											ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(((itemstackiterator.getOrCreateTag().getString("rupee"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
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
}