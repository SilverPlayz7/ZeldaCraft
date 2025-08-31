package zeldacraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BlastMaskContractItem extends Item {
	public BlastMaskContractItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}