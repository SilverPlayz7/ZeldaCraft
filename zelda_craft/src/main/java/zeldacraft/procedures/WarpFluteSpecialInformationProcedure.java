package zeldacraft.procedures;

import net.minecraft.world.item.ItemStack;

public class WarpFluteSpecialInformationProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getBoolean("HasWarp")) {
			return "X: " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("TPX")) + ", Y: " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("TPY")) + ", Z: "
					+ new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("TPZ"));
		}
		return "";
	}
}