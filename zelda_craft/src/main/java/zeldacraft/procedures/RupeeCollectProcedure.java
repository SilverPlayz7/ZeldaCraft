package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModItems;

import zeldacraft.ZeldaCraftMod;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RupeeCollectProcedure {
	@SubscribeEvent
	public static void onPickup(EntityItemPickupEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getItem().getItem());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		execute(null, world, x, y, z, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("zelda_craft:rupee")))) {
			if (entity instanceof Player) {
				if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(ZeldaCraftModItems.CHILD_WALLET.get(), lv).isPresent() : false) {
					if (entity instanceof LivingEntity lv) {
						CuriosApi.getCuriosHelper().findCurios(lv, ZeldaCraftModItems.CHILD_WALLET.get()).forEach(item -> {
							ItemStack itemstackiterator = item.stack();
							if (itemstack.getItem() == ZeldaCraftModItems.GREEN_RUPEE.get()) {
								if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() <= 99) {
									if (event != null && event.hasResult()) {
										event.setResult(Event.Result.ALLOW);
									}
									itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount()));
									ZeldaCraftMod.queueServerWork(1, () -> {
										if (event != null && event.hasResult()) {
											event.setResult(Event.Result.DENY);
										}
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													"/kill @e[sort=nearest,type=minecraft:item,nbt={Item:{id:\"zelda_craft:green_rupee\"}},limit=1]");
									});
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Your wallet is full"), true);
								}
							} else if (itemstack.getItem() == ZeldaCraftModItems.BLUE_RUPEE.get()) {
								if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 5 <= 99) {
									if (event != null && event.hasResult()) {
										event.setResult(Event.Result.ALLOW);
									}
									itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 5));
									ZeldaCraftMod.queueServerWork(1, () -> {
										if (event != null && event.hasResult()) {
											event.setResult(Event.Result.DENY);
										}
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													"/kill @e[sort=nearest,type=minecraft:item,nbt={Item:{id:\"zelda_craft:blue_rupee\"}},limit=1]");
									});
								} else {
									if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") == 99) {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Your wallet is full"), true);
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Your wallet can't fit that much"), true);
									}
								}
							} else if (itemstack.getItem() == ZeldaCraftModItems.RED_RUPEE.get()) {
								if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 20 <= 99) {
									if (event != null && event.hasResult()) {
										event.setResult(Event.Result.ALLOW);
									}
									itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 20));
									ZeldaCraftMod.queueServerWork(1, () -> {
										if (event != null && event.hasResult()) {
											event.setResult(Event.Result.DENY);
										}
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													"/kill @e[sort=nearest,type=minecraft:item,nbt={Item:{id:\"zelda_craft:red_rupee\"}},limit=1]");
									});
								} else {
									if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") == 99) {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Your wallet is full"), true);
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Your wallet can't fit that much"), true);
									}
								}
							} else if (itemstack.getItem() == ZeldaCraftModItems.PURPLE_RUPEE.get()) {
								if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 50 <= 99) {
									if (event != null && event.hasResult()) {
										event.setResult(Event.Result.ALLOW);
									}
									itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 50));
									ZeldaCraftMod.queueServerWork(1, () -> {
										if (event != null && event.hasResult()) {
											event.setResult(Event.Result.DENY);
										}
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													"/kill @e[sort=nearest,type=minecraft:item,nbt={Item:{id:\"zelda_craft:purple_rupee\"}},limit=1]");
									});
								} else {
									if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") == 99) {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Your wallet is full"), true);
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Your wallet can't fit that much"), true);
									}
								}
							} else if (itemstack.getItem() == ZeldaCraftModItems.SILVER_RUPEE.get()) {
								if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 100 <= 99) {
									if (event != null && event.hasResult()) {
										event.setResult(Event.Result.ALLOW);
									}
									itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 100));
									ZeldaCraftMod.queueServerWork(1, () -> {
										if (event != null && event.hasResult()) {
											event.setResult(Event.Result.DENY);
										}
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													"/kill @e[sort=nearest,type=minecraft:item,nbt={Item:{id:\"zelda_craft:silver_rupee\"}},limit=1]");
									});
								} else {
									if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") == 99) {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Your wallet is full"), true);
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Your wallet can't fit that much"), true);
									}
								}
							} else if (itemstack.getItem() == ZeldaCraftModItems.GOLD_RUPEE.get()) {
								if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 300 <= 99) {
									if (event != null && event.hasResult()) {
										event.setResult(Event.Result.ALLOW);
									}
									itemstackiterator.getOrCreateTag().putDouble("RupeeCount", (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") + itemstack.getCount() * 300));
									ZeldaCraftMod.queueServerWork(1, () -> {
										if (event != null && event.hasResult()) {
											event.setResult(Event.Result.DENY);
										}
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													"/kill @e[sort=nearest,type=minecraft:item,nbt={Item:{id:\"zelda_craft:gold_rupee\"}},limit=1]");
									});
								} else {
									if (itemstackiterator.getOrCreateTag().getDouble("RupeeCount") == 99) {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Your wallet is full"), true);
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Your wallet can't fit that much"), true);
									}
								}
							}
						});
					}
				}
			}
		}
	}
}