package zeldacraft.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class WarpFlutePlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entUseTicks0 ? _entUseTicks0.getTicksUsingItem() : 0) == 55) {
			if (itemstack.getOrCreateTag().getBoolean("HasWarp")) {
				{
					Entity _ent = entity;
					_ent.teleportTo((itemstack.getOrCreateTag().getDouble("TPX") + 0.5), (itemstack.getOrCreateTag().getDouble("TPY")), (itemstack.getOrCreateTag().getDouble("TPZ") + 0.5));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((itemstack.getOrCreateTag().getDouble("TPX") + 0.5), (itemstack.getOrCreateTag().getDouble("TPY")), (itemstack.getOrCreateTag().getDouble("TPZ") + 0.5), _ent.getYRot(), _ent.getXRot());
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(itemstack.getOrCreateTag().getDouble("TPX"), itemstack.getOrCreateTag().getDouble("TPY"), itemstack.getOrCreateTag().getDouble("TPZ")),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.wool.fall")), SoundSource.NEUTRAL, (float) 0.8, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
					} else {
						_level.playLocalSound((itemstack.getOrCreateTag().getDouble("TPX")), (itemstack.getOrCreateTag().getDouble("TPY")), (itemstack.getOrCreateTag().getDouble("TPZ")),
								ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.wool.fall")), SoundSource.NEUTRAL, (float) 0.8, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("There is no warp set"), true);
			}
		}
	}
}