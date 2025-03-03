package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModItems;

import zeldacraft.ZeldaCraftMod;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class MaskAbilityOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(ZeldaCraftModItems.BLAST_MASK.get(), lv).isPresent() : false) {
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
		}
	}
}
