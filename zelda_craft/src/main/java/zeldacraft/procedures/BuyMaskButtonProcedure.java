package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import zeldacraft.init.ZeldaCraftModMenus;
import zeldacraft.init.ZeldaCraftModItems;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

public class BuyMaskButtonProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity lv) {
			CuriosApi.getCuriosHelper().findCurios(lv, ZeldaCraftModItems.CHILD_WALLET.get()).forEach(item -> {
				ItemStack itemstackiterator = item.stack();
				if (new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof Player player && player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
							ItemStack stack = _menu.getSlots().get(sltid).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(1) == 0) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("zelda_craft:wallet")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(0).getItem() : ItemStack.EMPTY).getOrCreateTag()
									.getDouble("RupeeCount") >= (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).MaskPrice) {
						if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).selectedmask == 1) {
							if (entity instanceof ServerPlayer _plr5 && _plr5.level() instanceof ServerLevel
									&& _plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().getAdvancement(ResourceLocation.parse("zelda_craft:bunny_hood_4"))).isDone()) {
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									ItemStack _setstack = new ItemStack(ZeldaCraftModItems.BUNNY_HOOD.get()).copy();
									_setstack.setCount(1);
									_menu.getSlots().get(1).set(_setstack);
									_player.containerMenu.broadcastChanges();
								}
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(0).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
										((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(0).getItem() : ItemStack.EMPTY).getOrCreateTag()
												.getDouble("RupeeCount") - (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).MaskPrice));
							}
						}
						if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).selectedmask == 2) {
							if (entity instanceof ServerPlayer _plr11 && _plr11.level() instanceof ServerLevel
									&& _plr11.getAdvancements().getOrStartProgress(_plr11.server.getAdvancements().getAdvancement(ResourceLocation.parse("zelda_craft:blast_mask_4"))).isDone()) {
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									ItemStack _setstack = new ItemStack(ZeldaCraftModItems.BLAST_MASK.get()).copy();
									_setstack.setCount(1);
									_menu.getSlots().get(1).set(_setstack);
									_player.containerMenu.broadcastChanges();
								}
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(0).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
										((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu13 ? _menu13.getSlots().get(0).getItem() : ItemStack.EMPTY).getOrCreateTag()
												.getDouble("RupeeCount") - (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).MaskPrice));
							}
						}
					} else if (itemstackiterator.is(ItemTags.create(ResourceLocation.parse("zelda_craft:wallet")))
							&& itemstackiterator.getOrCreateTag().getDouble("RupeeCount") >= (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).MaskPrice) {
						if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).selectedmask == 1) {
							if (entity instanceof ServerPlayer _plr21 && _plr21.level() instanceof ServerLevel
									&& _plr21.getAdvancements().getOrStartProgress(_plr21.server.getAdvancements().getAdvancement(ResourceLocation.parse("zelda_craft:bunny_hood_4"))).isDone()) {
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									ItemStack _setstack = new ItemStack(ZeldaCraftModItems.BUNNY_HOOD.get()).copy();
									_setstack.setCount(1);
									_menu.getSlots().get(1).set(_setstack);
									_player.containerMenu.broadcastChanges();
								}
								itemstackiterator.getOrCreateTag().putDouble("RupeeCount",
										(itemstackiterator.getOrCreateTag().getDouble("RupeeCount") - (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).MaskPrice));
							}
						}
						if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).selectedmask == 2) {
							if (entity instanceof ServerPlayer _plr27 && _plr27.level() instanceof ServerLevel
									&& _plr27.getAdvancements().getOrStartProgress(_plr27.server.getAdvancements().getAdvancement(ResourceLocation.parse("zelda_craft:blast_mask_4"))).isDone()) {
								if (entity instanceof Player _player && _player.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu) {
									ItemStack _setstack = new ItemStack(ZeldaCraftModItems.BLAST_MASK.get()).copy();
									_setstack.setCount(1);
									_menu.getSlots().get(1).set(_setstack);
									_player.containerMenu.broadcastChanges();
								}
								itemstackiterator.getOrCreateTag().putDouble("RupeeCount",
										(itemstackiterator.getOrCreateTag().getDouble("RupeeCount") - (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).MaskPrice));
							}
						}
					}
				}
			});
		}
	}
}