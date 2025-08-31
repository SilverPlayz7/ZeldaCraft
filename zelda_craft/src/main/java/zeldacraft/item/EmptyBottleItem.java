package zeldacraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class EmptyBottleItem extends Item {
	public EmptyBottleItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}