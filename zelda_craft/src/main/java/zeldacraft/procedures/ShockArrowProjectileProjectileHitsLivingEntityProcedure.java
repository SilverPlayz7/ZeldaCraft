package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModMobEffects;
import zeldacraft.init.ZeldaCraftModGameRules;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

public class ShockArrowProjectileProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		double damage = 0;
		double multiplier = 0;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, y, z, 10, 0.5, 0.5, 0.5, 1);
		multiplier = 1;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.IRON_HELMET) {
			multiplier = multiplier + 0.5;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.IRON_CHESTPLATE) {
			multiplier = multiplier + 0.5;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.IRON_LEGGINGS) {
			multiplier = multiplier + 0.5;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.IRON_BOOTS) {
			multiplier = multiplier + 0.5;
		}
		damage = 5 * multiplier;
		entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ARROW), immediatesourceentity, sourceentity), (float) damage);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(ZeldaCraftModMobEffects.STUNNED.get(), 60, 1, false, true));
		if (world.getLevelData().getGameRules().getBoolean(ZeldaCraftModGameRules.SHOCK_DROP) == true) {
			if (entity instanceof Player _player_) {
				if (!_player_.getMainHandItem().isEmpty()) {
					_player_.drop(_player_.getMainHandItem(), true);
					_player_.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
				}
				_player_.getInventory().setChanged();
			}
			if (entity instanceof Player _player_) {
				if (!_player_.getOffhandItem().isEmpty()) {
					_player_.drop(_player_.getOffhandItem(), true);
					_player_.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
					_player_.getInventory().setChanged();
				}
			}
		}
	}
}