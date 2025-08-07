package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import zeldacraft.ZeldaCraftMod;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class LongShotWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double MVZ = 0;
		double MVY = 0;
		double DVY = 0;
		double DVX = 0;
		double DVZ = 0;
		double NDVX = 0;
		double NDVY = 0;
		double MVX = 0;
		double NDVZ = 0;
		{
			Entity _ent = immediatesourceentity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data merge entity @s {NoGravity:1b}");
			}
		}
		if (immediatesourceentity.getPersistentData().getDouble("SoundClock") < 8) {
			immediatesourceentity.getPersistentData().putDouble("SoundClock", (immediatesourceentity.getPersistentData().getDouble("SoundClock") + 1));
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:hookshot_flying")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:hookshot_flying")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			immediatesourceentity.getPersistentData().putDouble("SoundClock", 0);
		}
		if (immediatesourceentity.getPersistentData().getDouble("DistanceTime") < 20) {
			immediatesourceentity.getPersistentData().putDouble("DistanceTime", (immediatesourceentity.getPersistentData().getDouble("DistanceTime") + 1));
		} else {
			if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).Hooked == false) {
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
			} else {
				ZeldaCraftMod.queueServerWork((int) Math.sqrt(Math.pow((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).HookX, 2)
						+ Math.pow((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).HookY, 2)
						+ Math.pow((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).HookZ, 2)), () -> {
							if (!immediatesourceentity.level().isClientSide())
								immediatesourceentity.discard();
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "stopsound @s * zelda_craft:hookshot_flying");
								}
							}
						});
			}
		}
	}
}
