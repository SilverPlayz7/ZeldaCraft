
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
		list.add(Component.translatable("item.zelda_craft.costume_coin.description_0"));
		list.add(Component.translatable("item.zelda_craft.costume_coin.description_1"));
		list.add(Component.translatable("item.zelda_craft.costume_coin.description_2"));
		list.add(Component.translatable("item.zelda_craft.costume_coin.description_3"));
	}
}
