package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModItems;
import zeldacraft.init.ZeldaCraftModGameRules;
import zeldacraft.init.ZeldaCraftModBlocks;

import zeldacraft.ZeldaCraftMod;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class MaskAbilityOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(ZeldaCraftModItems.BLAST_MASK.get(), lv).isPresent() : false) {
			if (world.getLevelData().getGameRules().getBoolean(ZeldaCraftModGameRules.BOMB_GREIFING) == false) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 0, 255, false, false));
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(entity, new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("zelda_craft:bomb_mask")))), null, x, y, z, 3,
							false, Level.ExplosionInteraction.NONE);
				ZeldaCraftMod.queueServerWork(1, () -> {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 5) {
						if (entity instanceof LivingEntity _entity)
							_entity.setHealth(2);
					} else {
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("zelda_craft:bomb_mask")))), 100);
					}
				});
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
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 0, 255, false, false));
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(entity, new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("zelda_craft:bomb_mask")))), null, x, y, z, 3,
							false, Level.ExplosionInteraction.TNT);
				ZeldaCraftMod.queueServerWork(1, () -> {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 5) {
						if (entity instanceof LivingEntity _entity)
							_entity.setHealth(2);
					} else {
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("zelda_craft:bomb_mask")))), 10);
					}
				});
			}
		}
	}
}
