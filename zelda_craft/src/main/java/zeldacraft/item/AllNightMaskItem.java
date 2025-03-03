
package zeldacraft.item;

import zeldacraft.procedures.AllNightMaskWhileBaubleIsEquippedTickProcedure;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class AllNightMaskItem extends Item implements ICurioItem {
	public AllNightMaskItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		AllNightMaskWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity());
	}
}
