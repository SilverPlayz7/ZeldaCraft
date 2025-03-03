
package zeldacraft.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class CostumeCoinItem extends Item {
	public CostumeCoinItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("This coin allows you roll the Anchient Capsule Machine's costume pool"));
		list.add(Component.literal("Drops:"));
		list.add(Component.literal(" Armor of Time - 50%"));
		list.add(Component.literal(" Armor of Twilight - 50%"));
	}
}
