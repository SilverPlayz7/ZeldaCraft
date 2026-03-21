package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModItems;

import net.minecraft.world.item.ItemStack;

public class MaxRupeesProcedure {
	public static double execute(ItemStack itemstack) {
		if (itemstack.getItem() == ZeldaCraftModItems.CHILD_WALLET.get()) {
			return 99;
		}
		if (itemstack.getItem() == ZeldaCraftModItems.ADULT_WALLET.get()) {
			return 200;
		}
		if (itemstack.getItem() == ZeldaCraftModItems.BIG_WALLET.get()) {
			return 500;
		}
		if (itemstack.getItem() == ZeldaCraftModItems.GIANT_WALLET.get()) {
			return 1000;
		}
		if (itemstack.getItem() == ZeldaCraftModItems.TYCOON_WALLET.get()) {
			return 10000;
		}
		return 0;
	}
}