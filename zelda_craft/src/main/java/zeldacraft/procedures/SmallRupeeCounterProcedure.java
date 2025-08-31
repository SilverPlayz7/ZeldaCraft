package zeldacraft.procedures;

import net.minecraft.world.item.ItemStack;

public class SmallRupeeCounterProcedure {
	public static String execute(ItemStack itemstack) {
		return "You can use this to store your hard earned rupees, although it's only big enough to hold 99! " + (" " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("RupeeCount")) + "/99");
	}
}