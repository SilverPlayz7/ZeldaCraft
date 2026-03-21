package zeldacraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BigKeyItem extends Item {
	public BigKeyItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}