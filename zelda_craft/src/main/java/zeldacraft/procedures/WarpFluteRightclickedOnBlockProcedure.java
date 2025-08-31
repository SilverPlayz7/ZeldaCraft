package zeldacraft.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class WarpFluteRightclickedOnBlockProcedure {
	public static void execute(double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			itemstack.getOrCreateTag().putDouble("TPX", x);
			itemstack.getOrCreateTag().putDouble("TPY", (y + 1));
			itemstack.getOrCreateTag().putDouble("TPZ", z);
			itemstack.getOrCreateTag().putBoolean("HasWarp", true);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Warp Set"), true);
		}
	}
}