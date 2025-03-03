
package zeldacraft.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class NewHyrleShieldBetterWayTestItem extends ShieldItem {
	public NewHyrleShieldBetterWayTestItem() {
		super(new Item.Properties().durability(450).rarity(Rarity.COMMON));
	}

	@Override
	public int getEnchantmentValue() {
		return 1;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("This shield can commonly be found in shops across the kingodm of New Hyrule and is believed to be used by the Hero of Trains for a while."));
	}
}
