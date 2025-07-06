package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import zeldacraft.init.ZeldaCraftModItems;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;
import java.util.Map;

public class BuyMaskButtonProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity lv) {
			CuriosApi.getCuriosHelper().findCurios(lv, ZeldaCraftModItems.CHILD_WALLET.get()).forEach(item -> {
				ItemStack itemstackiterator = item.stack();
				if (new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(1) == 0) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(new ResourceLocation("zelda_craft:wallet")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
									.getDouble("RupeeCount") >= (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).MaskPrice) {
						if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).selectedmask == 1) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(ZeldaCraftModItems.BUNNY_HOOD.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(1)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("RupeeCount",
									((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
											.getDouble("RupeeCount") - (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).MaskPrice));
						}
						if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).selectedmask == 2) {
							if (entity instanceof ServerPlayer _plr10 && _plr10.level() instanceof ServerLevel
									&& _plr10.getAdvancements().getOrStartProgress(_plr10.server.getAdvancements().getAdvancement(new ResourceLocation("zelda_craft:blast_mask_4"))).isDone()) {
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(ZeldaCraftModItems.BLAST_MASK.get()).copy();
									_setstack.setCount(1);
									((Slot) _slots.get(1)).set(_setstack);
									_player.containerMenu.broadcastChanges();
								}
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
										.putDouble("RupeeCount", ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
												.getOrCreateTag().getDouble("RupeeCount") - (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).MaskPrice));
							}
						}
					} else if (itemstackiterator.is(ItemTags.create(new ResourceLocation("zelda_craft:wallet")))
							&& itemstackiterator.getOrCreateTag().getDouble("RupeeCount") >= (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).MaskPrice) {
						if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).selectedmask == 1) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(ZeldaCraftModItems.BUNNY_HOOD.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(1)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
							itemstackiterator.getOrCreateTag().putDouble("RupeeCount",
									(itemstackiterator.getOrCreateTag().getDouble("RupeeCount") - (entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).MaskPrice));
						}
						if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).selectedmask == 2) {
							if (entity instanceof ServerPlayer _plr25 && _plr25.level() instanceof ServerLevel
									&& _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("zelda_craft:blast_mask_4"))).isDone()) {
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(ZeldaCraftModItems.BLAST_MASK.get()).copy();
									_setstack.setCount(1);
									((Slot) _slots.get(1)).set(_setstack);
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
