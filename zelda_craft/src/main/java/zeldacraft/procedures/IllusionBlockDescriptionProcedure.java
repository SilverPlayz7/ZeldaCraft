package zeldacraft.procedures;

import net.minecraft.world.item.ItemStack;

public class IllusionBlockDescriptionProcedure {
	public static String execute(ItemStack itemstack) {
		if ((itemstack.getOrCreateTag().getString("illusion")).isEmpty()) {
			return "shift right-click a block to set the illusion";
		}
		return itemstack.getOrCreateTag().getString("illusion");
	}
}
