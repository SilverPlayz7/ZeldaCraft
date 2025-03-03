package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModItems;

import zeldacraft.ZeldaCraftMod;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RupeeCollectProcedure {
	@SubscribeEvent
	public static void onPickup(EntityItemPickupEvent event) {
		execute(event, event.getEntity().level(), event.getEntity(), event.getItem().getItem());
	}

	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		execute(null, world, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity lv) {
			CuriosApi.getCuriosHelper().findCurios(lv, ZeldaCraftModItems.CHILD_WALLET.get()).forEach(item -> {
				ItemStack itemstackiterator = item.stack();
				if (itemstackiterator.is(ItemTags.create(new ResourceLocation("zelda_craft:wallet")))) {
					if (itemstack.getItem() == ZeldaCraftModItems.GREEN_RUPIE.get()) {
						if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() <= 99) {
							itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount()));
							ZeldaCraftMod.queueServerWork(2, () -> {
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = new ItemStack(ZeldaCraftModItems.GREEN_RUPIE.get());
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstack.getCount(), _player.inventoryMenu.getCraftSlots());
								}
							});
						}
					} else if (itemstack.getItem() == ZeldaCraftModItems.BLUE_RUPEE.get()) {
						if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 5 <= 99) {
							itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 5));
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(ZeldaCraftModItems.BLUE_RUPEE.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstack.getCount(), _player.inventoryMenu.getCraftSlots());
							}
							ZeldaCraftMod.queueServerWork(2, () -> {
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = new ItemStack(ZeldaCraftModItems.GREEN_RUPIE.get());
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstack.getCount(), _player.inventoryMenu.getCraftSlots());
								}
							});
						}
					} else if (itemstack.getItem() == ZeldaCraftModItems.RED_RUPEE.get()) {
						if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 20 <= 99) {
							itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 20));
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(ZeldaCraftModItems.RED_RUPEE.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstack.getCount(), _player.inventoryMenu.getCraftSlots());
							}
							ZeldaCraftMod.queueServerWork(2, () -> {
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = new ItemStack(ZeldaCraftModItems.GREEN_RUPIE.get());
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstack.getCount(), _player.inventoryMenu.getCraftSlots());
								}
							});
						}
					} else if (itemstack.getItem() == ZeldaCraftModItems.PURPLE_RUPEE.get()) {
						if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 50 <= 99) {
							itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 50));
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(ZeldaCraftModItems.PURPLE_RUPEE.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstack.getCount(), _player.inventoryMenu.getCraftSlots());
							}
							ZeldaCraftMod.queueServerWork(2, () -> {
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = new ItemStack(ZeldaCraftModItems.GREEN_RUPIE.get());
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstack.getCount(), _player.inventoryMenu.getCraftSlots());
								}
							});
						}
					} else if (itemstack.getItem() == ZeldaCraftModItems.SILVER_RUPEE.get()) {
						if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 100 <= 99) {
							itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 100));
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(ZeldaCraftModItems.SILVER_RUPEE.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstack.getCount(), _player.inventoryMenu.getCraftSlots());
							}
							ZeldaCraftMod.queueServerWork(2, () -> {
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = new ItemStack(ZeldaCraftModItems.GREEN_RUPIE.get());
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstack.getCount(), _player.inventoryMenu.getCraftSlots());
								}
							});
						}
					} else if (itemstack.getItem() == ZeldaCraftModItems.GOLD_RUPEE.get()) {
						if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 300 <= 99) {
							itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 300));
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(ZeldaCraftModItems.GOLD_RUPEE.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstack.getCount(), _player.inventoryMenu.getCraftSlots());
							}
							ZeldaCraftMod.queueServerWork(2, () -> {
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = new ItemStack(ZeldaCraftModItems.GREEN_RUPIE.get());
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstack.getCount(), _player.inventoryMenu.getCraftSlots());
								}
							});
						}
					}
				}
			});
		}
	}
}
