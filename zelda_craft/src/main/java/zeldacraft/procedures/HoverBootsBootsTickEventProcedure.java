package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModItems;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

public class HoverBootsBootsTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == ZeldaCraftModItems.HOVER_BOOTS_BOOTS.get()) {
			if (!world.getBlockState(BlockPos.containing(x, y - 0.1, z)).canOcclude()) {
				if (entity.getPersistentData().getDouble("htimer") < 30) {
					entity.getPersistentData().putDouble("htimer", (entity.getPersistentData().getDouble("htimer") + 1));
				} else {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("zelda_craft:cartoon_gravity_joke"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.LEVITATION);
				}
			} else {
				entity.getPersistentData().putDouble("htimer", 0);
			}
			if (entity.getPersistentData().getDouble("htimer") < 30) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 1, -1, false, false));
			}
		}
	}
}
