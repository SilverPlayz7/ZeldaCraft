
package zeldacraft.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class NewHyruleShieldItem extends ShieldItem {
	public NewHyruleShieldItem() {
		super(new Item.Properties().durability(450));
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(Items.IRON_INGOT)).test(repairitem);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.zelda_craft.new_hyrule_shield.description_0"));
	}
}
