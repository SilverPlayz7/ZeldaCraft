package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModGameRules;
import zeldacraft.init.ZeldaCraftModBlocks;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Comparator;

public class BombProjectileWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (entity.isInWaterRainOrBubble()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:bomb_defuse")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:bomb_defuse")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (entity.getPersistentData().getDouble("SoundClock") < 20) {
			if (entity.getPersistentData().getDouble("SoundClock") == 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:bomb_fuse")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:bomb_fuse")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			entity.getPersistentData().putDouble("SoundClock", (entity.getPersistentData().getDouble("SoundClock") + 1));
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:bomb_fuse")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:bomb_fuse")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			entity.getPersistentData().putDouble("SoundClock", 1);
		}
		if (!entity.onGround()) {
			if (!world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).isEmpty() || !world.getEntitiesOfClass(Animal.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).isEmpty()) {
				entity.getPersistentData().putDouble("FuseTime", 80);
			}
		}
		if (entity.getPersistentData().getDouble("FuseTime") < 80) {
			entity.getPersistentData().putDouble("FuseTime", (entity.getPersistentData().getDouble("FuseTime") + 1));
		} else {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world.getLevelData().getGameRules().getBoolean(ZeldaCraftModGameRules.BOMB_GREIFING) == false) {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)), new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_EXPLOSION)), null, x, y, z, 3, false,
							Level.ExplosionInteraction.NONE);
				sx = -1.6;
				found = false;
				for (int index0 = 0; index0 < 4; index0++) {
					sy = -1.6;
					for (int index1 = 0; index1 < 4; index1++) {
						sz = -1.6;
						for (int index2 = 0; index2 < 4; index2++) {
							if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == ZeldaCraftModBlocks.BOMBABLE_WALL.get()) {
								found = true;
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
				if (found == true) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:secret_found")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:secret_found")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"fill ~3.2 ~3.2 ~3.2 ~-3.2 ~-3.2 ~-3.2 air replace zelda_craft:bombable_wall");
				}
			} else {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, y, z, 3, Level.ExplosionInteraction.TNT);
			}
		}
		world.addParticle(ParticleTypes.SMALL_FLAME, x, (y + 0.5), z, 0, 0.1, 0);
	}
}
