package zeldacraft.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

public class WarpFlutePlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("HasWarp")) {
			{
				Entity _ent = entity;
				_ent.teleportTo((itemstack.getOrCreateTag().getDouble("TPX")), (itemstack.getOrCreateTag().getDouble("TPY")), (itemstack.getOrCreateTag().getDouble("TPZ")));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((itemstack.getOrCreateTag().getDouble("TPX")), (itemstack.getOrCreateTag().getDouble("TPY")), (itemstack.getOrCreateTag().getDouble("TPZ")), _ent.getYRot(), _ent.getXRot());
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("There is no warp set"), true);
		}
	}
}
