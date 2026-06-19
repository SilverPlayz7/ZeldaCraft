package zeldacraft.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityLeaveLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.util.function.BiFunction;
import java.util.UUID;

@Mod.EventBusSubscriber
public class EponaSaveCoordsProcedure {
	@SubscribeEvent
	public static void onEntityLeave(EntityLeaveLevelEvent event) {
		if (event.getEntity() != null) {
			String removalreason = "null";
			if (event.getEntity().getRemovalReason() != null) {
				removalreason = event.getEntity().getRemovalReason().toString().toLowerCase();
			}
			execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), removalreason);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, String removalreason) {
		execute(null, world, x, y, z, entity, removalreason);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, String removalreason) {
		if (entity == null || removalreason == null)
			return;
		if (entity.getPersistentData().getBoolean("isEpona") == true) {
			if ((entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : true) == true) {
				if ((new BiFunction<LevelAccessor, String, Entity>() {
					@Override
					public Entity apply(LevelAccessor levelAccessor, String uuid) {
						if (levelAccessor instanceof ServerLevel serverLevel) {
							try {
								return serverLevel.getEntity(UUID.fromString(uuid));
							} catch (Exception e) {
							}
						}
						return null;
					}
				}).apply(world, (entity.getPersistentData().getString("ownerID"))) != null) {
					if ((removalreason).equals("null")) {
						((new BiFunction<LevelAccessor, String, Entity>() {
							@Override
							public Entity apply(LevelAccessor levelAccessor, String uuid) {
								if (levelAccessor instanceof ServerLevel serverLevel) {
									try {
										return serverLevel.getEntity(UUID.fromString(uuid));
									} catch (Exception e) {
									}
								}
								return null;
							}
						}).apply(world, (entity.getPersistentData().getString("ownerID")))).getPersistentData().putDouble("eponaX", Math.round(x));
						((new BiFunction<LevelAccessor, String, Entity>() {
							@Override
							public Entity apply(LevelAccessor levelAccessor, String uuid) {
								if (levelAccessor instanceof ServerLevel serverLevel) {
									try {
										return serverLevel.getEntity(UUID.fromString(uuid));
									} catch (Exception e) {
									}
								}
								return null;
							}
						}).apply(world, (entity.getPersistentData().getString("ownerID")))).getPersistentData().putDouble("eponaY", Math.round(y));
						((new BiFunction<LevelAccessor, String, Entity>() {
							@Override
							public Entity apply(LevelAccessor levelAccessor, String uuid) {
								if (levelAccessor instanceof ServerLevel serverLevel) {
									try {
										return serverLevel.getEntity(UUID.fromString(uuid));
									} catch (Exception e) {
									}
								}
								return null;
							}
						}).apply(world, (entity.getPersistentData().getString("ownerID")))).getPersistentData().putDouble("eponaZ", Math.round(z));
						if (((new BiFunction<LevelAccessor, String, Entity>() {
							@Override
							public Entity apply(LevelAccessor levelAccessor, String uuid) {
								if (levelAccessor instanceof ServerLevel serverLevel) {
									try {
										return serverLevel.getEntity(UUID.fromString(uuid));
									} catch (Exception e) {
									}
								}
								return null;
							}
						}).apply(world, (entity.getPersistentData().getString("ownerID")))) instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Unloaded"), false);
					} else if ((removalreason).equals("killed")) {
						((new BiFunction<LevelAccessor, String, Entity>() {
							@Override
							public Entity apply(LevelAccessor levelAccessor, String uuid) {
								if (levelAccessor instanceof ServerLevel serverLevel) {
									try {
										return serverLevel.getEntity(UUID.fromString(uuid));
									} catch (Exception e) {
									}
								}
								return null;
							}
						}).apply(world, (entity.getPersistentData().getString("ownerID")))).getPersistentData().putBoolean("hasEpona", false);
					}
				}
			}
		}
	}
}