
package zeldacraft.item;

import zeldacraft.procedures.BunnyHoodTickEventProcedure;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class BunnyHoodItem extends Item implements ICurioItem {
	public BunnyHoodItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		BunnyHoodTickEventProcedure.execute(slotContext.entity());
	}
}
