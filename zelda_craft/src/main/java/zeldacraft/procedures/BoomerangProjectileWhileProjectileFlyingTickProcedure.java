package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModMobEffects;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Comparator;

public class BoomerangProjectileWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double DVX = 0;
		double DVY = 0;
		double DVZ = 0;
		double NDVX = 0;
		double NDVY = 0;
		double NDVZ = 0;
		double MVX = 0;
		double MVY = 0;
		double MVZ = 0;
		{
			Entity _ent = immediatesourceentity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data merge entity @s {NoGravity:1b}");
			}
		}
		if (immediatesourceentity.getPersistentData().getDouble("SoundClock") < 10) {
			if (immediatesourceentity.getPersistentData().getDouble("SoundClock") == 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("zelda_craft:boomerang_flying_loop")), SoundSource.NEUTRAL, (float) 0.8, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("zelda_craft:boomerang_flying_loop")), SoundSource.NEUTRAL, (float) 0.8, 1, false);
					}
				}
			}
			immediatesourceentity.getPersistentData().putDouble("SoundClock", (immediatesourceentity.getPersistentData().getDouble("SoundClock") + 1));
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("zelda_craft:boomerang_flying_loop")), SoundSource.NEUTRAL, (float) 0.8, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("zelda_craft:boomerang_flying_loop")), SoundSource.NEUTRAL, (float) 0.8, 1, false);
				}
			}
			immediatesourceentity.getPersistentData().putDouble("SoundClock", 1);
		}
		if (immediatesourceentity.getPersistentData().getDouble("DistanceTime") < 25) {
			if (!world.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3((immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getX()), (immediatesourceentity.getDeltaMovement().y() + immediatesourceentity.getY()),
					(immediatesourceentity.getDeltaMovement().z() + immediatesourceentity.getZ())), 1.5, 1.5, 1.5), e -> true).isEmpty()) {
				immediatesourceentity.getPersistentData().putDouble("DistanceTime", 25);
				((Entity) world.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3((immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getX()), (immediatesourceentity.getDeltaMovement().y() + immediatesourceentity.getY()),
						(immediatesourceentity.getDeltaMovement().z() + immediatesourceentity.getZ())), 1.5, 1.5, 1.5), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getX()), (immediatesourceentity.getDeltaMovement().y() + immediatesourceentity.getY()),
								(immediatesourceentity.getDeltaMovement().z() + immediatesourceentity.getZ())))
						.findFirst().orElse(null))
						.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("zelda_craft:boomerang_damage")))), 5);
				if (((Entity) world.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3((immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getX()), (immediatesourceentity.getDeltaMovement().y() + immediatesourceentity.getY()),
						(immediatesourceentity.getDeltaMovement().z() + immediatesourceentity.getZ())), 1.5, 1.5, 1.5), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getX()), (immediatesourceentity.getDeltaMovement().y() + immediatesourceentity.getY()),
								(immediatesourceentity.getDeltaMovement().z() + immediatesourceentity.getZ())))
						.findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(ZeldaCraftModMobEffects.STUNNED.get(), 60, 1));
			}
			if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.25, 1.25, 1.25), e -> true).isEmpty()) {
				((Entity) world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.25, 1.25, 1.25), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).startRiding(immediatesourceentity);
			}
			if (!((world.getBlockState(BlockPos.containing(immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()))).getBlock() == Blocks.AIR)) {
				if ((world.getBlockState(BlockPos.containing(immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ())))
						.is(BlockTags.create(ResourceLocation.parse("zelda_craft:boomerang_breakable")))) {
					{
						BlockPos _pos = BlockPos.containing(immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()), null);
						world.destroyBlock(_pos, false);
					}
				} else if ((world.getBlockState(BlockPos.containing(immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ())))
						.is(BlockTags.create(ResourceLocation.parse("zelda_craft:boomerang_interactable")))) {
					if (entity instanceof Player _player) {
						BlockPos _bp = BlockPos.containing(immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
						_player.level().getBlockState(_bp).use(_player.level(), _player, InteractionHand.MAIN_HAND, BlockHitResult.miss(new Vec3(_bp.getX(), _bp.getY(), _bp.getZ()), Direction.UP, _bp));
					}
				} else {
					immediatesourceentity.getPersistentData().putBoolean("bounced", true);
					immediatesourceentity.setDeltaMovement(new Vec3((immediatesourceentity.getDeltaMovement().x() * (-1)), (immediatesourceentity.getDeltaMovement().y()), (immediatesourceentity.getDeltaMovement().z())));
				}
			}
			if (!((world.getBlockState(BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getDeltaMovement().y() + immediatesourceentity.getY(), immediatesourceentity.getZ()))).getBlock() == Blocks.AIR)) {
				if ((world.getBlockState(BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getDeltaMovement().y() + immediatesourceentity.getY(), immediatesourceentity.getZ())))
						.is(BlockTags.create(ResourceLocation.parse("zelda_craft:boomerang_breakable")))) {
					{
						BlockPos _pos = BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getDeltaMovement().y() + immediatesourceentity.getY(), immediatesourceentity.getZ());
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getDeltaMovement().y() + immediatesourceentity.getY(), immediatesourceentity.getZ()), null);
						world.destroyBlock(_pos, false);
					}
				} else if ((world.getBlockState(BlockPos.containing(immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ())))
						.is(BlockTags.create(ResourceLocation.parse("zelda_craft:boomerang_interactable")))) {
					if (entity instanceof Player _player) {
						BlockPos _bp = BlockPos.containing(immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
						_player.level().getBlockState(_bp).use(_player.level(), _player, InteractionHand.MAIN_HAND, BlockHitResult.miss(new Vec3(_bp.getX(), _bp.getY(), _bp.getZ()), Direction.UP, _bp));
					}
				} else {
					immediatesourceentity.getPersistentData().putBoolean("bounced", true);
					immediatesourceentity.setDeltaMovement(new Vec3((immediatesourceentity.getDeltaMovement().x()), (immediatesourceentity.getDeltaMovement().y() * (-1)), (immediatesourceentity.getDeltaMovement().z())));
				}
			}
			if (!((world.getBlockState(BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getDeltaMovement().z() + immediatesourceentity.getZ()))).getBlock() == Blocks.AIR)) {
				if ((world.getBlockState(BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getDeltaMovement().z() + immediatesourceentity.getZ())))
						.is(BlockTags.create(ResourceLocation.parse("zelda_craft:boomerang_breakable")))) {
					{
						BlockPos _pos = BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getDeltaMovement().z() + immediatesourceentity.getZ());
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getDeltaMovement().z() + immediatesourceentity.getZ()), null);
						world.destroyBlock(_pos, false);
					}
				} else if ((world.getBlockState(BlockPos.containing(immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ())))
						.is(BlockTags.create(ResourceLocation.parse("zelda_craft:boomerang_interactable")))) {
					if (entity instanceof Player _player) {
						BlockPos _bp = BlockPos.containing(immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
						_player.level().getBlockState(_bp).use(_player.level(), _player, InteractionHand.MAIN_HAND, BlockHitResult.miss(new Vec3(_bp.getX(), _bp.getY(), _bp.getZ()), Direction.UP, _bp));
					}
				} else {
					immediatesourceentity.getPersistentData().putBoolean("bounced", true);
					immediatesourceentity.setDeltaMovement(new Vec3((immediatesourceentity.getDeltaMovement().x()), (immediatesourceentity.getDeltaMovement().y()), (immediatesourceentity.getDeltaMovement().z() * (-1))));
					{
						Entity _ent = immediatesourceentity;
						_ent.setYRot(immediatesourceentity.getYRot() + 180);
						_ent.setXRot(immediatesourceentity.getXRot() * (-1));
						_ent.setYBodyRot(_ent.getYRot());
						_ent.setYHeadRot(_ent.getYRot());
						_ent.yRotO = _ent.getYRot();
						_ent.xRotO = _ent.getXRot();
						if (_ent instanceof LivingEntity _entity) {
							_entity.yBodyRotO = _entity.getYRot();
							_entity.yHeadRotO = _entity.getYRot();
						}
					}
				}
			}
			if (immediatesourceentity.getPersistentData().getBoolean("bounced") == false) {
				immediatesourceentity.setDeltaMovement(new Vec3((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z)));
			}
			immediatesourceentity.getPersistentData().putDouble("DistanceTime", (immediatesourceentity.getPersistentData().getDouble("DistanceTime") + 1));
		} else {
			DVX = entity.getX() - immediatesourceentity.getX();
			NDVX = DVX;
			MVX = NDVX * 0.15;
			DVY = (entity.getY() + 1) - immediatesourceentity.getY();
			NDVY = DVY;
			MVY = NDVY * 0.15;
			DVZ = entity.getZ() - immediatesourceentity.getZ();
			NDVZ = DVZ;
			MVZ = NDVZ * 0.15;
			immediatesourceentity.setDeltaMovement(new Vec3(MVX, MVY, MVZ));
		}
	}
}