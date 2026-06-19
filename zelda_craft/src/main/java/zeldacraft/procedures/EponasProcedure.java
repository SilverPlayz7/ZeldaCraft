package zeldacraft.procedures;

import zeldacraft.ZeldaCraftMod;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.world.ForgeChunkManager;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Comparator;

public class EponasProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean foundEpona = false;
		if (!world.isClientSide()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("zelda_craft:ocarina_song_correct")), SoundSource.RECORDS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("zelda_craft:ocarina_song_correct")), SoundSource.RECORDS, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("zelda_craft:eponas_song")), SoundSource.RECORDS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("zelda_craft:eponas_song")), SoundSource.RECORDS, 1, 1, false);
				}
			}
			foundEpona = false;
			if (world instanceof ServerLevel) {
				for (Entity entityiterator : ((ServerLevel) world).getAllEntities()) {
					if (entityiterator == null)
						continue;
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("iterating"), true);
					if (!world.getEntitiesOfClass(Cow.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()) {
						if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("minecraft:cow")) {
							entityiterator.getPersistentData().putBoolean("lonlon", true);
						}
					}
				}
			}
			if (world instanceof ServerLevel) {
				for (Entity entityiterator : ((ServerLevel) world).getAllEntities()) {
					if (entityiterator == null)
						continue;
					if (entity.onGround()) {
						if (entity.getPersistentData().getBoolean("hasEpona") == false) {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("here's a new one"), false);
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											"/summon horse ~ ~ ~ {Variant:258,PersistenceRequired:1,Tame:1,SaddleItem:{id:saddle,Count:1},CustomName:\"\\\"Epona\\\"\",DeathLootTable:\"minecraft:empty\"}");
								}
							}
							(findEntityInWorldRange(world, Horse.class, x, y, z, 2)).getPersistentData().putString("ownerID", (entity.getStringUUID()));
							(findEntityInWorldRange(world, Horse.class, x, y, z, 2)).getPersistentData().putBoolean("isEpona", true);
							entity.getPersistentData().putBoolean("hasEpona", true);
							foundEpona = true;
							break;
						} else {
							if (entityiterator instanceof Horse && entityiterator.getPersistentData().getBoolean("isEpona") == true) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("true! YIPPIE!"), false);
								if ((entityiterator.getPersistentData().getString("ownerID")).equals(entity.getStringUUID())) {
									{
										Entity _ent = entityiterator;
										_ent.teleportTo(x, y, z);
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("got a horse"), false);
									foundEpona = true;
									break;
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("false..."), false);
							}
						}
					}
				}
			}
			if (foundEpona == false) {
				if (entity.getPersistentData().getBoolean("hasEpona") == true) {
					if (world instanceof ServerLevel _world)
						ForgeChunkManager.forceChunk(_world, "zelda_craft", new BlockPos(
								(int) world.getChunk(new BlockPos((int) (entity.getPersistentData().getDouble("eponaX")), (int) (entity.getPersistentData().getDouble("eponaY")), (int) (entity.getPersistentData().getDouble("eponaZ")))).getPos().x, 0,
								(int) world.getChunk(new BlockPos((int) (entity.getPersistentData().getDouble("eponaX")), (int) (entity.getPersistentData().getDouble("eponaY")), (int) (entity.getPersistentData().getDouble("eponaZ")))).getPos().z),
								world.getChunk(new BlockPos((int) (entity.getPersistentData().getDouble("eponaX")), (int) (entity.getPersistentData().getDouble("eponaY")), (int) (entity.getPersistentData().getDouble("eponaZ")))).getPos().x,
								world.getChunk(new BlockPos((int) (entity.getPersistentData().getDouble("eponaX")), (int) (entity.getPersistentData().getDouble("eponaY")), (int) (entity.getPersistentData().getDouble("eponaZ")))).getPos().z, true,
								true);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("maybe horse..."), false);
					ZeldaCraftMod.queueServerWork(5, () -> {
						if (!world.getEntitiesOfClass(Horse.class,
								new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3((entity.getPersistentData().getDouble("eponaX")), (entity.getPersistentData().getDouble("eponaY")), (entity.getPersistentData().getDouble("eponaZ")))).inflate(2 / 2d),
								e -> true).isEmpty()) {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("a horse is here"), false);
							if ((findEntityInWorldRange(world, Horse.class, (entity.getPersistentData().getDouble("eponaX")), (entity.getPersistentData().getDouble("eponaY")), (entity.getPersistentData().getDouble("eponaZ")), 2)).getPersistentData()
									.getBoolean("isEpona") == true
									&& ((findEntityInWorldRange(world, Horse.class, (entity.getPersistentData().getDouble("eponaX")), (entity.getPersistentData().getDouble("eponaY")), (entity.getPersistentData().getDouble("eponaZ")), 2))
											.getPersistentData().getString("ownerID")).equals(entity.getStringUUID())) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("got your horse"), false);
								{
									Entity _ent = (findEntityInWorldRange(world, Horse.class, (entity.getPersistentData().getDouble("eponaX")), (entity.getPersistentData().getDouble("eponaY")), (entity.getPersistentData().getDouble("eponaZ")), 2));
									_ent.teleportTo(x, y, z);
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("nope, no horse"), false);
								entity.getPersistentData().putBoolean("hasEpona", false);
							}
						}
						ZeldaCraftMod.queueServerWork(20, () -> {
							if (world instanceof ServerLevel _world)
								ForgeChunkManager.forceChunk(_world, "zelda_craft",
										new BlockPos(
												(int) world.getChunk(new BlockPos((int) (entity.getPersistentData().getDouble("eponaX")), (int) (entity.getPersistentData().getDouble("eponaY")), (int) (entity.getPersistentData().getDouble("eponaZ"))))
														.getPos().x,
												0,
												(int) world.getChunk(new BlockPos((int) (entity.getPersistentData().getDouble("eponaX")), (int) (entity.getPersistentData().getDouble("eponaY")), (int) (entity.getPersistentData().getDouble("eponaZ"))))
														.getPos().z),
										world.getChunk(new BlockPos((int) (entity.getPersistentData().getDouble("eponaX")), (int) (entity.getPersistentData().getDouble("eponaY")), (int) (entity.getPersistentData().getDouble("eponaZ")))).getPos().x,
										world.getChunk(new BlockPos((int) (entity.getPersistentData().getDouble("eponaX")), (int) (entity.getPersistentData().getDouble("eponaY")), (int) (entity.getPersistentData().getDouble("eponaZ")))).getPos().z,
										false, true);
						});
					});
				}
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}