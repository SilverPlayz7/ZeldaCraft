package zeldacraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BigKeyItem extends Item {
	public BigKeyItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}
}