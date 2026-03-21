package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModItems;

import net.minecraft.world.item.ItemStack;

public class RupeeValueProcedure {
	public static double execute(ItemStack itemstack) {
		if (itemstack.getItem() == ZeldaCraftModItems.GREEN_RUPEE.get()) {
			return 1;
		}
		if (itemstack.getItem() == ZeldaCraftModItems.BLUE_RUPEE.get()) {
			return 5;
		}
		if (itemstack.getItem() == ZeldaCraftModItems.RED_RUPEE.get()) {
			return 20;
		}
		if (itemstack.getItem() == ZeldaCraftModItems.PURPLE_RUPEE.get()) {
			return 50;
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SILVER_RUPEE.get()) {
			return 100;
		}
		if (itemstack.getItem() == ZeldaCraftModItems.GOLD_RUPEE.get()) {
			return 300;
		}
		return 0;
	}
}